package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.NumberUtils;

public class BitmapFontCache {
    private int charsCount;
    private float color;
    private final BitmapFont font;
    private int glyphCount;
    private IntArray[] glyphIndices;
    private int[] idx;
    private boolean integer;
    private TextMarkup markup;
    private float oldTint;
    private final Color tempColor;
    private final TextBounds textBounds;
    private boolean textChanged;
    private int[] tmpGlyphCount;
    private float[][] vertexData;
    /* renamed from: x */
    private float f43x;
    /* renamed from: y */
    private float f44y;

    public BitmapFontCache(BitmapFont font) {
        this(font, font.usesIntegerPositions());
    }

    public BitmapFontCache(BitmapFont font, boolean integer) {
        this.color = Color.WHITE.toFloatBits();
        this.tempColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.textBounds = new TextBounds();
        this.integer = true;
        this.glyphCount = 0;
        this.oldTint = 0.0f;
        this.markup = new TextMarkup();
        this.font = font;
        this.integer = integer;
        int regionsLength = font.regions.length;
        if (regionsLength == 0) {
            throw new IllegalArgumentException("The specified font must contain at least one texture page.");
        }
        this.vertexData = new float[regionsLength][];
        this.idx = new int[regionsLength];
        int vertexDataLength = this.vertexData.length;
        if (vertexDataLength > 1) {
            this.glyphIndices = new IntArray[vertexDataLength];
            int n = this.glyphIndices.length;
            for (int i = 0; i < n; i++) {
                this.glyphIndices[i] = new IntArray();
            }
            this.tmpGlyphCount = new int[vertexDataLength];
        }
    }

    public void setPosition(float x, float y) {
        translate(x - this.f43x, y - this.f44y);
    }

    public void translate(float xAmount, float yAmount) {
        if (xAmount != 0.0f || yAmount != 0.0f) {
            if (this.integer) {
                xAmount = (float) Math.round(xAmount);
                yAmount = (float) Math.round(yAmount);
            }
            this.f43x += xAmount;
            this.f44y += yAmount;
            int length = this.vertexData.length;
            for (int j = 0; j < length; j++) {
                float[] vertices = this.vertexData[j];
                int n = this.idx[j];
                for (int i = 0; i < n; i += 5) {
                    vertices[i] = vertices[i] + xAmount;
                    int i2 = i + 1;
                    vertices[i2] = vertices[i2] + yAmount;
                }
            }
        }
    }

    private Color setColor(Color color, float floatColor) {
        int intBits = NumberUtils.floatToIntColor(floatColor);
        color.f40r = ((float) (intBits & 255)) / 255.0f;
        color.f39g = ((float) ((intBits >>> 8) & 255)) / 255.0f;
        color.f38b = ((float) ((intBits >>> 16) & 255)) / 255.0f;
        color.f37a = ((float) ((intBits >>> 24) & 255)) / 255.0f;
        return color;
    }

    public void tint(Color tint) {
        float floatTint = tint.toFloatBits();
        if (this.textChanged || this.oldTint != floatTint) {
            this.textChanged = false;
            this.oldTint = floatTint;
            this.markup.tint(this, tint);
        }
    }

    public void setColors(float color) {
        int length = this.vertexData.length;
        for (int j = 0; j < length; j++) {
            float[] vertices = this.vertexData[j];
            int n = this.idx[j];
            for (int i = 2; i < n; i += 5) {
                vertices[i] = color;
            }
        }
    }

    public void setColors(Color tint) {
        float color = tint.toFloatBits();
        int length = this.vertexData.length;
        for (int j = 0; j < length; j++) {
            float[] vertices = this.vertexData[j];
            int n = this.idx[j];
            for (int i = 2; i < n; i += 5) {
                vertices[i] = color;
            }
        }
    }

    public void setColors(float r, float g, float b, float a) {
        float color = NumberUtils.intToFloatColor((((((int) (255.0f * a)) << 24) | (((int) (255.0f * b)) << 16)) | (((int) (255.0f * g)) << 8)) | ((int) (255.0f * r)));
        int length = this.vertexData.length;
        for (int j = 0; j < length; j++) {
            float[] vertices = this.vertexData[j];
            int n = this.idx[j];
            for (int i = 2; i < n; i += 5) {
                vertices[i] = color;
            }
        }
    }

    public void setColors(Color tint, int start, int end) {
        setColors(tint.toFloatBits(), start, end);
    }

    public void setColors(float color, int start, int end) {
        float[] vertices;
        int n;
        int i;
        if (this.vertexData.length == 1) {
            vertices = this.vertexData[0];
            n = end * 20;
            for (i = (start * 20) + 2; i < n; i += 5) {
                vertices[i] = color;
            }
            return;
        }
        int pageCount = this.vertexData.length;
        for (i = 0; i < pageCount; i++) {
            vertices = this.vertexData[i];
            n = this.glyphIndices[i].size;
            for (int j = 0; j < n; j++) {
                int gInd = this.glyphIndices[i].items[j];
                if (gInd >= end) {
                    break;
                }
                if (gInd >= start) {
                    for (int off = 0; off < 20; off += 5) {
                        vertices[((j * 20) + 2) + off] = color;
                    }
                }
            }
        }
    }

    public void setColor(Color tint) {
        this.color = tint.toFloatBits();
        this.markup.setDefaultChunk(tint, this.charsCount);
    }

    public void setColor(float r, float g, float b, float a) {
        int intBits = (((((int) (255.0f * a)) << 24) | (((int) (255.0f * b)) << 16)) | (((int) (255.0f * g)) << 8)) | ((int) (255.0f * r));
        this.color = NumberUtils.intToFloatColor(intBits);
        this.markup.setDefaultChunk(intBits, this.charsCount);
    }

    public void setColor(float color) {
        this.color = color;
        this.markup.setDefaultChunk(color, this.charsCount);
    }

    public Color getColor() {
        int intBits = NumberUtils.floatToIntColor(this.color);
        Color color = this.tempColor;
        color.f40r = ((float) (intBits & 255)) / 255.0f;
        color.f39g = ((float) ((intBits >>> 8) & 255)) / 255.0f;
        color.f38b = ((float) ((intBits >>> 16) & 255)) / 255.0f;
        color.f37a = ((float) ((intBits >>> 24) & 255)) / 255.0f;
        return color;
    }

    public void draw(Batch spriteBatch) {
        TextureRegion[] regions = this.font.getRegions();
        int n = this.vertexData.length;
        for (int j = 0; j < n; j++) {
            if (this.idx[j] > 0) {
                spriteBatch.draw(regions[j].getTexture(), this.vertexData[j], 0, this.idx[j]);
            }
        }
    }

    public void draw(Batch spriteBatch, int start, int end) {
        if (this.vertexData.length == 1) {
            spriteBatch.draw(this.font.getRegion().getTexture(), this.vertexData[0], start * 20, (end - start) * 20);
            return;
        }
        TextureRegion[] regions = this.font.getRegions();
        int pageCount = this.vertexData.length;
        for (int i = 0; i < pageCount; i++) {
            int offset = -1;
            int count = 0;
            IntArray currentGlyphIndices = this.glyphIndices[i];
            int n = currentGlyphIndices.size;
            for (int j = 0; j < n; j++) {
                int glyphIndex = currentGlyphIndices.items[j];
                if (glyphIndex >= end) {
                    break;
                }
                if (offset == -1 && glyphIndex >= start) {
                    offset = j;
                }
                if (glyphIndex >= start) {
                    count++;
                }
            }
            if (!(offset == -1 || count == 0)) {
                spriteBatch.draw(regions[i].getTexture(), this.vertexData[i], offset * 20, count * 20);
            }
        }
    }

    public void draw(Batch spriteBatch, float alphaModulation) {
        if (alphaModulation == 1.0f) {
            draw(spriteBatch);
            return;
        }
        Color color = getColor();
        float oldAlpha = color.f37a;
        color.f37a *= alphaModulation;
        setColors(color);
        draw(spriteBatch);
        color.f37a = oldAlpha;
        setColors(color);
    }

    public void clear() {
        this.f43x = 0.0f;
        this.f44y = 0.0f;
        this.glyphCount = 0;
        this.charsCount = 0;
        this.markup.clear();
        int n = this.idx.length;
        for (int i = 0; i < n; i++) {
            if (this.glyphIndices != null) {
                this.glyphIndices[i].clear();
            }
            this.idx[i] = 0;
        }
    }

    private int countGlyphs(CharSequence seq, int start, int end) {
        int count = end - start;
        int start2 = start;
        while (start2 < end) {
            start = start2 + 1;
            if (seq.charAt(start2) == '[') {
                count--;
                if (start >= end || seq.charAt(start) != '[') {
                    while (start < end && seq.charAt(start) != ']') {
                        start++;
                        count--;
                    }
                    count--;
                }
                start++;
            }
            start2 = start;
        }
        return count;
    }

    private void requireSequence(CharSequence seq, int start, int end) {
        if (this.vertexData.length == 1) {
            require(0, this.font.markupEnabled ? countGlyphs(seq, start, end) : end - start);
            return;
        }
        int i;
        int n = this.tmpGlyphCount.length;
        for (i = 0; i < n; i++) {
            this.tmpGlyphCount[i] = 0;
        }
        int start2 = start;
        while (start2 < end) {
            start = start2 + 1;
            char ch = seq.charAt(start2);
            if (ch == '[' && this.font.markupEnabled) {
                if (start >= end || seq.charAt(start) != '[') {
                    while (start < end && seq.charAt(start) != ']') {
                        start++;
                    }
                    start2 = start + 1;
                } else {
                    start++;
                }
            }
            Glyph g = this.font.data.getGlyph(ch);
            if (g == null) {
                start2 = start;
            } else {
                int[] iArr = this.tmpGlyphCount;
                int i2 = g.page;
                iArr[i2] = iArr[i2] + 1;
                start2 = start;
            }
        }
        n = this.tmpGlyphCount.length;
        for (i = 0; i < n; i++) {
            require(i, this.tmpGlyphCount[i]);
        }
        start = start2;
    }

    private void require(int page, int glyphCount) {
        if (this.glyphIndices != null && glyphCount > this.glyphIndices[page].items.length) {
            this.glyphIndices[page].ensureCapacity(glyphCount - this.glyphIndices[page].items.length);
        }
        int vertexCount = this.idx[page] + (glyphCount * 20);
        float[] vertices = this.vertexData[page];
        if (vertices == null) {
            this.vertexData[page] = new float[vertexCount];
        } else if (vertices.length < vertexCount) {
            float[] newVertices = new float[vertexCount];
            System.arraycopy(vertices, 0, newVertices, 0, this.idx[page]);
            this.vertexData[page] = newVertices;
        }
    }

    private float addToCache(CharSequence str, float x, float y, int start, int end) {
        int start2;
        float startX = x;
        BitmapFont font = this.font;
        Glyph lastGlyph = null;
        BitmapFontData data = font.data;
        this.textChanged = start < end;
        char ch;
        Glyph g;
        if (data.scaleX == 1.0f && data.scaleY == 1.0f) {
            start2 = start;
            while (start2 < end) {
                start = start2 + 1;
                ch = str.charAt(start2);
                if (ch == '[' && font.markupEnabled) {
                    if (start >= end || str.charAt(start) != '[') {
                        start += TextMarkup.parseColorTag(this.markup, str, this.charsCount, start, end) + 1;
                        this.color = this.markup.getLastColor().toFloatBits();
                        start2 = start;
                    } else {
                        start++;
                    }
                }
                lastGlyph = data.getGlyph(ch);
                if (lastGlyph != null) {
                    addGlyph(lastGlyph, x + ((float) lastGlyph.xoffset), y + ((float) lastGlyph.yoffset), (float) lastGlyph.width, (float) lastGlyph.height);
                    x += (float) lastGlyph.xadvance;
                    start2 = start;
                    break;
                }
                start2 = start;
            }
            while (start2 < end) {
                start = start2 + 1;
                ch = str.charAt(start2);
                if (ch == '[' && font.markupEnabled) {
                    if (start >= end || str.charAt(start) != '[') {
                        start += TextMarkup.parseColorTag(this.markup, str, this.charsCount, start, end) + 1;
                        this.color = this.markup.getLastColor().toFloatBits();
                        start2 = start;
                    } else {
                        start++;
                    }
                }
                g = data.getGlyph(ch);
                if (g != null) {
                    x += (float) lastGlyph.getKerning(ch);
                    lastGlyph = g;
                    addGlyph(lastGlyph, x + ((float) g.xoffset), y + ((float) g.yoffset), (float) g.width, (float) g.height);
                    x += (float) g.xadvance;
                }
                start2 = start;
            }
        } else {
            float scaleX = data.scaleX;
            float scaleY = data.scaleY;
            start2 = start;
            while (start2 < end) {
                start = start2 + 1;
                ch = str.charAt(start2);
                if (ch == '[' && font.markupEnabled) {
                    if (start >= end || str.charAt(start) != '[') {
                        start += TextMarkup.parseColorTag(this.markup, str, this.charsCount, start, end) + 1;
                        this.color = this.markup.getLastColor().toFloatBits();
                        start2 = start;
                    } else {
                        start++;
                    }
                }
                lastGlyph = data.getGlyph(ch);
                if (lastGlyph != null) {
                    addGlyph(lastGlyph, x + (((float) lastGlyph.xoffset) * scaleX), y + (((float) lastGlyph.yoffset) * scaleY), ((float) lastGlyph.width) * scaleX, ((float) lastGlyph.height) * scaleY);
                    x += ((float) lastGlyph.xadvance) * scaleX;
                    start2 = start;
                    break;
                }
                start2 = start;
            }
            while (start2 < end) {
                start = start2 + 1;
                ch = str.charAt(start2);
                if (ch == '[' && font.markupEnabled) {
                    if (start >= end || str.charAt(start) != '[') {
                        start += TextMarkup.parseColorTag(this.markup, str, this.charsCount, start, end) + 1;
                        this.color = this.markup.getLastColor().toFloatBits();
                        start2 = start;
                    } else {
                        start++;
                    }
                }
                g = data.getGlyph(ch);
                if (g != null) {
                    x += ((float) lastGlyph.getKerning(ch)) * scaleX;
                    lastGlyph = g;
                    addGlyph(lastGlyph, x + (((float) g.xoffset) * scaleX), y + (((float) g.yoffset) * scaleY), ((float) g.width) * scaleX, ((float) g.height) * scaleY);
                    x += ((float) g.xadvance) * scaleX;
                }
                start2 = start;
            }
        }
        start = start2;
        return x - startX;
    }

    private void addGlyph(Glyph glyph, float x, float y, float width, float height) {
        float x2 = x + width;
        float y2 = y + height;
        float u = glyph.f41u;
        float u2 = glyph.u2;
        float v = glyph.f42v;
        float v2 = glyph.v2;
        int page = glyph.page;
        if (this.glyphIndices != null) {
            IntArray intArray = this.glyphIndices[page];
            int i = this.glyphCount;
            this.glyphCount = i + 1;
            intArray.add(i);
        }
        float[] vertices = this.vertexData[page];
        if (this.integer) {
            x = (float) Math.round(x);
            y = (float) Math.round(y);
            x2 = (float) Math.round(x2);
            y2 = (float) Math.round(y2);
        }
        int idx = this.idx[page];
        int[] iArr = this.idx;
        iArr[page] = iArr[page] + 20;
        int idx2 = idx + 1;
        vertices[idx] = x;
        idx = idx2 + 1;
        vertices[idx2] = y;
        idx2 = idx + 1;
        vertices[idx] = this.color;
        idx = idx2 + 1;
        vertices[idx2] = u;
        idx2 = idx + 1;
        vertices[idx] = v;
        idx = idx2 + 1;
        vertices[idx2] = x;
        idx2 = idx + 1;
        vertices[idx] = y2;
        idx = idx2 + 1;
        vertices[idx2] = this.color;
        idx2 = idx + 1;
        vertices[idx] = u;
        idx = idx2 + 1;
        vertices[idx2] = v2;
        idx2 = idx + 1;
        vertices[idx] = x2;
        idx = idx2 + 1;
        vertices[idx2] = y2;
        idx2 = idx + 1;
        vertices[idx] = this.color;
        idx = idx2 + 1;
        vertices[idx2] = u2;
        idx2 = idx + 1;
        vertices[idx] = v2;
        idx = idx2 + 1;
        vertices[idx2] = x2;
        idx2 = idx + 1;
        vertices[idx] = y;
        idx = idx2 + 1;
        vertices[idx2] = this.color;
        idx2 = idx + 1;
        vertices[idx] = u2;
        vertices[idx2] = v;
        this.charsCount++;
    }

    public TextBounds setText(CharSequence str, float x, float y) {
        clear();
        return addText(str, x, y, 0, str.length());
    }

    public TextBounds setText(CharSequence str, float x, float y, int start, int end) {
        clear();
        return addText(str, x, y, start, end);
    }

    public TextBounds addText(CharSequence str, float x, float y) {
        return addText(str, x, y, 0, str.length());
    }

    public TextBounds addText(CharSequence str, float x, float y, int start, int end) {
        requireSequence(str, start, end);
        y += this.font.data.ascent;
        this.textBounds.width = addToCache(str, x, y, start, end);
        this.textBounds.height = this.font.data.capHeight;
        return this.textBounds;
    }

    public TextBounds setMultiLineText(CharSequence str, float x, float y) {
        clear();
        return addMultiLineText(str, x, y, 0.0f, HAlignment.LEFT);
    }

    public TextBounds setMultiLineText(CharSequence str, float x, float y, float alignmentWidth, HAlignment alignment) {
        clear();
        return addMultiLineText(str, x, y, alignmentWidth, alignment);
    }

    public TextBounds addMultiLineText(CharSequence str, float x, float y) {
        return addMultiLineText(str, x, y, 0.0f, HAlignment.LEFT);
    }

    public TextBounds addMultiLineText(CharSequence str, float x, float y, float alignmentWidth, HAlignment alignment) {
        BitmapFont font = this.font;
        int length = str.length();
        requireSequence(str, 0, length);
        y += font.data.ascent;
        float down = font.data.down;
        float maxWidth = 0.0f;
        float startY = y;
        int start = 0;
        int numLines = 0;
        while (start < length) {
            int lineEnd = BitmapFont.indexOf(str, '\n', start);
            float xOffset = 0.0f;
            if (alignment != HAlignment.LEFT) {
                xOffset = alignmentWidth - font.getBounds(str, start, lineEnd).width;
                if (alignment == HAlignment.CENTER) {
                    xOffset /= 2.0f;
                }
            }
            maxWidth = Math.max(maxWidth, addToCache(str, x + xOffset, y, start, lineEnd));
            start = lineEnd + 1;
            y += down;
            numLines++;
        }
        this.textBounds.width = maxWidth;
        this.textBounds.height = font.data.capHeight + (((float) (numLines - 1)) * font.data.lineHeight);
        return this.textBounds;
    }

    public TextBounds setWrappedText(CharSequence str, float x, float y, float wrapWidth) {
        clear();
        return addWrappedText(str, x, y, wrapWidth, HAlignment.LEFT);
    }

    public TextBounds setWrappedText(CharSequence str, float x, float y, float wrapWidth, HAlignment alignment) {
        clear();
        return addWrappedText(str, x, y, wrapWidth, alignment);
    }

    public TextBounds addWrappedText(CharSequence str, float x, float y, float wrapWidth) {
        return addWrappedText(str, x, y, wrapWidth, HAlignment.LEFT);
    }

    public TextBounds addWrappedText(CharSequence str, float x, float y, float wrapWidth, HAlignment alignment) {
        BitmapFont font = this.font;
        int length = str.length();
        requireSequence(str, 0, length);
        y += font.data.ascent;
        float down = font.data.down;
        if (wrapWidth <= 0.0f) {
            wrapWidth = 2.14748365E9f;
        }
        float maxWidth = 0.0f;
        int start = 0;
        int numLines = 0;
        while (start < length) {
            int newLine = BitmapFont.indexOf(str, '\n', start);
            int lineEnd = start + font.computeVisibleGlyphs(str, start, newLine, wrapWidth);
            int nextStart = lineEnd + 1;
            if (lineEnd < newLine) {
                while (lineEnd > start && !BitmapFont.isWhitespace(str.charAt(lineEnd))) {
                    if (font.isBreakChar(str.charAt(lineEnd - 1))) {
                        break;
                    }
                    lineEnd--;
                }
                if (lineEnd != start) {
                    nextStart = lineEnd;
                    while (nextStart < length) {
                        char c = str.charAt(nextStart);
                        if (!BitmapFont.isWhitespace(c)) {
                            break;
                        }
                        nextStart++;
                        if (c == '\n') {
                            break;
                        }
                    }
                    while (lineEnd > start) {
                        if (!BitmapFont.isWhitespace(str.charAt(lineEnd - 1))) {
                            break;
                        }
                        lineEnd--;
                    }
                } else {
                    if (nextStart > start + 1) {
                        nextStart--;
                    }
                    lineEnd = nextStart;
                }
            }
            if (lineEnd > start) {
                float xOffset = 0.0f;
                if (alignment != HAlignment.LEFT) {
                    xOffset = wrapWidth - font.getBounds(str, start, lineEnd).width;
                    if (alignment == HAlignment.CENTER) {
                        xOffset /= 2.0f;
                    }
                }
                maxWidth = Math.max(maxWidth, addToCache(str, x + xOffset, y, start, lineEnd));
            }
            start = nextStart;
            y += down;
            numLines++;
        }
        this.textBounds.width = maxWidth;
        this.textBounds.height = font.data.capHeight + (((float) (numLines - 1)) * font.data.lineHeight);
        return this.textBounds;
    }

    public void setBreakChars(char[] breakChars) {
        this.font.setBreakChars(breakChars);
    }

    public TextBounds getBounds() {
        return this.textBounds;
    }

    public float getX() {
        return this.f43x;
    }

    public float getY() {
        return this.f44y;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public void setUseIntegerPositions(boolean use) {
        this.integer = use;
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public float[] getVertices() {
        return getVertices(0);
    }

    public float[] getVertices(int page) {
        return this.vertexData[page];
    }

    public int getCharsCount() {
        return this.charsCount;
    }
}
