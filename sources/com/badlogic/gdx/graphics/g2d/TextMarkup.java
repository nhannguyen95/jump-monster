package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.StringBuilder;
import java.util.Iterator;

class TextMarkup {
    private static final Pool<ColorChunk> colorChunkPool = new Pool<ColorChunk>(32) {
        protected ColorChunk newObject() {
            return new ColorChunk();
        }
    };
    private static final Color tempColor = new Color();
    private static final StringBuilder tempColorBuffer = new StringBuilder();
    private Array<ColorChunk> colorChunks = new Array();
    private Array<Color> currentColorStack = new Array();
    private Color defaultColor = Color.WHITE;
    private Color lastColor = Color.WHITE;

    public static class ColorChunk {
        public final Color color = new Color();
        public int start;
    }

    TextMarkup() {
    }

    public static int parseColorTag(TextMarkup markup, CharSequence str, int nomarkupStart, int start, int end) {
        if (start < end) {
            Color hexColor = tempColor;
            int i;
            char ch;
            if (str.charAt(start) == '#') {
                int colorInt = 0;
                i = start + 1;
                while (i < end) {
                    ch = str.charAt(i);
                    if (ch != ']') {
                        if (ch >= '0' && ch <= '9') {
                            colorInt = (colorInt * 16) + (ch - 48);
                        } else if (ch >= 'a' && ch <= 'f') {
                            colorInt = (colorInt * 16) + (ch - 87);
                        } else if (ch < 'A' || ch > 'F') {
                            throw new GdxRuntimeException("Unexpected character in hex color: " + ch);
                        } else {
                            colorInt = (colorInt * 16) + (ch - 55);
                        }
                        i++;
                    } else if (i < start + 2 || i > start + 9) {
                        throw new GdxRuntimeException("Hex color cannot have " + ((i - start) - 1) + " digits.");
                    } else {
                        if (i <= start + 7) {
                            Color.rgb888ToColor(hexColor, colorInt);
                            hexColor.f37a = 1.0f;
                        } else {
                            Color.rgba8888ToColor(hexColor, colorInt);
                        }
                        markup.beginChunk(hexColor, nomarkupStart);
                        return i - start;
                    }
                }
            }
            tempColorBuffer.setLength(0);
            for (i = start; i < end; i++) {
                ch = str.charAt(i);
                if (ch == ']') {
                    if (tempColorBuffer.length() == 0) {
                        markup.endChunk(nomarkupStart);
                    } else {
                        String colorString = tempColorBuffer.toString();
                        Color newColor = Colors.get(colorString);
                        if (newColor == null) {
                            throw new GdxRuntimeException("Unknown color: " + colorString);
                        }
                        markup.beginChunk(newColor, nomarkupStart);
                    }
                    return i - start;
                }
                tempColorBuffer.append(ch);
            }
        }
        throw new GdxRuntimeException("Unclosed color tag.");
    }

    public void beginChunk(Color color, int start) {
        ColorChunk newChunk = (ColorChunk) colorChunkPool.obtain();
        newChunk.color.set(color);
        newChunk.start = start;
        this.colorChunks.add(newChunk);
        this.currentColorStack.add(this.lastColor);
        this.lastColor = newChunk.color;
    }

    public void endChunk(int start) {
        if (this.currentColorStack.size > 0) {
            this.lastColor = (Color) this.currentColorStack.pop();
            ColorChunk newChunk = (ColorChunk) colorChunkPool.obtain();
            newChunk.color.set(this.lastColor);
            newChunk.start = start;
            this.colorChunks.add(newChunk);
        }
    }

    public void tint(BitmapFontCache cache, Color tint) {
        int current = 0;
        float floatColor = tempColor.set(this.defaultColor).mul(tint).toFloatBits();
        Iterator i$ = this.colorChunks.iterator();
        while (i$.hasNext()) {
            ColorChunk chunk = (ColorChunk) i$.next();
            int next = chunk.start;
            if (current < next) {
                cache.setColors(floatColor, current, next);
                current = next;
            }
            floatColor = tempColor.set(chunk.color).mul(tint).toFloatBits();
        }
        int charsCount = cache.getCharsCount();
        if (current < charsCount) {
            cache.setColors(floatColor, current, charsCount);
        }
    }

    public void clear() {
        int size = this.colorChunks.size;
        for (int i = 0; i < size; i++) {
            colorChunkPool.free(this.colorChunks.get(i));
            this.colorChunks.set(i, null);
        }
        this.colorChunks.size = 0;
        this.currentColorStack.clear();
        setDefaultChunk(this.defaultColor, 0);
    }

    public Color getLastColor() {
        return this.lastColor;
    }

    private void setDefaultColor(Color defaultColor) {
        if (this.currentColorStack.size == 0) {
            this.defaultColor = defaultColor;
            this.lastColor = defaultColor;
        }
    }

    public void setDefaultChunk(float color, int start) {
        setDefaultChunk(NumberUtils.floatToIntColor(color), start);
    }

    public void setDefaultChunk(int abgr, int start) {
        ColorChunk newChunk = (ColorChunk) colorChunkPool.obtain();
        Color color = newChunk.color;
        color.f40r = ((float) (abgr & 255)) / 255.0f;
        color.f39g = ((float) ((abgr >>> 8) & 255)) / 255.0f;
        color.f38b = ((float) ((abgr >>> 16) & 255)) / 255.0f;
        color.f37a = ((float) ((abgr >>> 24) & 255)) / 255.0f;
        newChunk.start = start;
        this.colorChunks.add(newChunk);
        setDefaultColor(newChunk.color);
    }

    public void setDefaultChunk(Color color, int start) {
        ColorChunk newChunk = (ColorChunk) colorChunkPool.obtain();
        newChunk.color.set(color);
        newChunk.start = start;
        this.colorChunks.add(newChunk);
        setDefaultColor(newChunk.color);
    }
}
