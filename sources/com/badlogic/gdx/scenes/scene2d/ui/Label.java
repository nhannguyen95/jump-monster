package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.StringBuilder;

public class Label extends Widget {
    private static final Color tempColor = new Color();
    private final TextBounds bounds;
    private BitmapFontCache cache;
    private boolean ellipsis;
    private float fontScaleX;
    private float fontScaleY;
    private int labelAlign;
    private float lastPrefHeight;
    private HAlignment lineAlign;
    private boolean sizeInvalid;
    private LabelStyle style;
    private StringBuilder tempText;
    private final StringBuilder text;
    private boolean wrap;

    public static class LabelStyle {
        public Drawable background;
        public BitmapFont font;
        public Color fontColor;

        public LabelStyle(BitmapFont font, Color fontColor) {
            this.font = font;
            this.fontColor = fontColor;
        }

        public LabelStyle(LabelStyle style) {
            this.font = style.font;
            if (style.fontColor != null) {
                this.fontColor = new Color(style.fontColor);
            }
            this.background = style.background;
        }
    }

    public Label(CharSequence text, Skin skin) {
        this(text, (LabelStyle) skin.get(LabelStyle.class));
    }

    public Label(CharSequence text, Skin skin, String styleName) {
        this(text, (LabelStyle) skin.get(styleName, LabelStyle.class));
    }

    public Label(CharSequence text, Skin skin, String fontName, Color color) {
        this(text, new LabelStyle(skin.getFont(fontName), color));
    }

    public Label(CharSequence text, Skin skin, String fontName, String colorName) {
        this(text, new LabelStyle(skin.getFont(fontName), skin.getColor(colorName)));
    }

    public Label(CharSequence text, LabelStyle style) {
        this.bounds = new TextBounds();
        this.text = new StringBuilder();
        this.labelAlign = 8;
        this.lineAlign = HAlignment.LEFT;
        this.sizeInvalid = true;
        this.fontScaleX = 1.0f;
        this.fontScaleY = 1.0f;
        if (text != null) {
            this.text.append(text);
        }
        setStyle(style);
        setSize(getPrefWidth(), getPrefHeight());
    }

    public void setStyle(LabelStyle style) {
        if (style == null) {
            throw new IllegalArgumentException("style cannot be null.");
        } else if (style.font == null) {
            throw new IllegalArgumentException("Missing LabelStyle font.");
        } else {
            this.style = style;
            this.cache = new BitmapFontCache(style.font, style.font.usesIntegerPositions());
            invalidateHierarchy();
        }
    }

    public LabelStyle getStyle() {
        return this.style;
    }

    public void setText(CharSequence newText) {
        if (newText == null) {
            newText = "";
        }
        if (newText instanceof StringBuilder) {
            if (!this.text.equals(newText)) {
                this.text.setLength(0);
                this.text.append((StringBuilder) newText);
            } else {
                return;
            }
        } else if (!textEquals(newText)) {
            this.text.setLength(0);
            this.text.append(newText);
        } else {
            return;
        }
        invalidateHierarchy();
    }

    public boolean textEquals(CharSequence other) {
        int length = this.text.length;
        char[] chars = this.text.chars;
        if (length != other.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (chars[i] != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public StringBuilder getText() {
        return this.text;
    }

    public void invalidate() {
        super.invalidate();
        this.sizeInvalid = true;
    }

    private void scaleAndComputeSize() {
        BitmapFont font = this.cache.getFont();
        float oldScaleX = font.getScaleX();
        float oldScaleY = font.getScaleY();
        if (!(this.fontScaleX == 1.0f && this.fontScaleY == 1.0f)) {
            font.setScale(this.fontScaleX, this.fontScaleY);
        }
        computeSize();
        if (this.fontScaleX != 1.0f || this.fontScaleY != 1.0f) {
            font.setScale(oldScaleX, oldScaleY);
        }
    }

    private void computeSize() {
        this.sizeInvalid = false;
        if (this.wrap) {
            float width = getWidth();
            if (this.style.background != null) {
                width -= this.style.background.getLeftWidth() + this.style.background.getRightWidth();
            }
            this.bounds.set(this.cache.getFont().getWrappedBounds(this.text, width));
            return;
        }
        this.bounds.set(this.cache.getFont().getMultiLineBounds(this.text));
    }

    public void layout() {
        StringBuilder text;
        BitmapFont font = this.cache.getFont();
        float oldScaleX = font.getScaleX();
        float oldScaleY = font.getScaleY();
        if (!(this.fontScaleX == 1.0f && this.fontScaleY == 1.0f)) {
            font.setScale(this.fontScaleX, this.fontScaleY);
        }
        if (this.sizeInvalid) {
            computeSize();
        }
        if (this.wrap) {
            float prefHeight = getPrefHeight();
            if (prefHeight != this.lastPrefHeight) {
                this.lastPrefHeight = prefHeight;
                invalidateHierarchy();
            }
        }
        float width = getWidth();
        float height = getHeight();
        if (!this.ellipsis || width >= this.bounds.width) {
            text = this.text;
        } else {
            float ellipseWidth = font.getBounds("...").width;
            if (this.tempText != null) {
                text = this.tempText;
            } else {
                text = new StringBuilder();
                this.tempText = text;
            }
            text.setLength(0);
            if (width > ellipseWidth) {
                text.append(this.text, 0, font.computeVisibleGlyphs(this.text, 0, this.text.length, width - ellipseWidth));
                text.append("...");
            }
        }
        Drawable background = this.style.background;
        float x = 0.0f;
        float y = 0.0f;
        if (background != null) {
            x = background.getLeftWidth();
            y = background.getBottomHeight();
            width -= background.getLeftWidth() + background.getRightWidth();
            height -= background.getBottomHeight() + background.getTopHeight();
        }
        if ((this.labelAlign & 2) != 0) {
            y = (y + (this.cache.getFont().isFlipped() ? 0.0f : height - this.bounds.height)) + this.style.font.getDescent();
        } else if ((this.labelAlign & 4) != 0) {
            y = (y + (this.cache.getFont().isFlipped() ? height - this.bounds.height : 0.0f)) - this.style.font.getDescent();
        } else {
            y += (float) ((int) ((height - this.bounds.height) / 2.0f));
        }
        if (!this.cache.getFont().isFlipped()) {
            y += this.bounds.height;
        }
        if ((this.labelAlign & 8) == 0) {
            if ((this.labelAlign & 16) != 0) {
                x += width - this.bounds.width;
            } else {
                x += (float) ((int) ((width - this.bounds.width) / 2.0f));
            }
        }
        this.cache.setColor(Color.WHITE);
        if (this.wrap) {
            this.cache.setWrappedText(text, x, y, this.bounds.width, this.lineAlign);
        } else {
            this.cache.setMultiLineText(text, x, y, this.bounds.width, this.lineAlign);
        }
        if (this.fontScaleX != 1.0f || this.fontScaleY != 1.0f) {
            font.setScale(oldScaleX, oldScaleY);
        }
    }

    public void draw(Batch batch, float parentAlpha) {
        validate();
        Color color = tempColor.set(getColor());
        color.f37a *= parentAlpha;
        if (this.style.background != null) {
            batch.setColor(color.f40r, color.f39g, color.f38b, color.f37a);
            this.style.background.draw(batch, getX(), getY(), getWidth(), getHeight());
        }
        if (this.style.fontColor != null) {
            color.mul(this.style.fontColor);
        }
        this.cache.tint(color);
        this.cache.setPosition(getX(), getY());
        this.cache.draw(batch);
    }

    public float getPrefWidth() {
        if (this.wrap) {
            return 0.0f;
        }
        if (this.sizeInvalid) {
            scaleAndComputeSize();
        }
        float width = this.bounds.width;
        Drawable background = this.style.background;
        if (background != null) {
            return width + (background.getLeftWidth() + background.getRightWidth());
        }
        return width;
    }

    public float getPrefHeight() {
        if (this.sizeInvalid) {
            scaleAndComputeSize();
        }
        float height = this.bounds.height - (this.style.font.getDescent() * 2.0f);
        Drawable background = this.style.background;
        if (background != null) {
            return height + (background.getTopHeight() + background.getBottomHeight());
        }
        return height;
    }

    public TextBounds getTextBounds() {
        if (this.sizeInvalid) {
            scaleAndComputeSize();
        }
        return this.bounds;
    }

    public void setWrap(boolean wrap) {
        this.wrap = wrap;
        invalidateHierarchy();
    }

    public void setBreakChars(char[] breakChars) {
        this.cache.setBreakChars(breakChars);
        invalidateHierarchy();
    }

    public void setAlignment(int alignment) {
        setAlignment(alignment, alignment);
    }

    public void setAlignment(int labelAlign, int lineAlign) {
        this.labelAlign = labelAlign;
        if ((lineAlign & 8) != 0) {
            this.lineAlign = HAlignment.LEFT;
        } else if ((lineAlign & 16) != 0) {
            this.lineAlign = HAlignment.RIGHT;
        } else {
            this.lineAlign = HAlignment.CENTER;
        }
        invalidate();
    }

    public void setFontScale(float fontScale) {
        this.fontScaleX = fontScale;
        this.fontScaleY = fontScale;
        invalidateHierarchy();
    }

    public void setFontScale(float fontScaleX, float fontScaleY) {
        this.fontScaleX = fontScaleX;
        this.fontScaleY = fontScaleY;
        invalidateHierarchy();
    }

    public float getFontScaleX() {
        return this.fontScaleX;
    }

    public void setFontScaleX(float fontScaleX) {
        this.fontScaleX = fontScaleX;
        invalidateHierarchy();
    }

    public float getFontScaleY() {
        return this.fontScaleY;
    }

    public void setFontScaleY(float fontScaleY) {
        this.fontScaleY = fontScaleY;
        invalidateHierarchy();
    }

    public void setEllipsis(boolean ellipsis) {
        this.ellipsis = ellipsis;
    }

    protected BitmapFontCache getBitmapFontCache() {
        return this.cache;
    }

    public String toString() {
        return super.toString() + ": " + this.text;
    }
}
