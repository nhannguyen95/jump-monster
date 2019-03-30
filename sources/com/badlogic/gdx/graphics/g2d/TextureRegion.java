package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Texture;
import java.lang.reflect.Array;

public class TextureRegion {
    int regionHeight;
    int regionWidth;
    Texture texture;
    /* renamed from: u */
    float f52u;
    float u2;
    /* renamed from: v */
    float f53v;
    float v2;

    public TextureRegion(Texture texture) {
        if (texture == null) {
            throw new IllegalArgumentException("texture cannot be null.");
        }
        this.texture = texture;
        setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public TextureRegion(Texture texture, int width, int height) {
        this.texture = texture;
        setRegion(0, 0, width, height);
    }

    public TextureRegion(Texture texture, int x, int y, int width, int height) {
        this.texture = texture;
        setRegion(x, y, width, height);
    }

    public TextureRegion(Texture texture, float u, float v, float u2, float v2) {
        this.texture = texture;
        setRegion(u, v, u2, v2);
    }

    public TextureRegion(TextureRegion region) {
        setRegion(region);
    }

    public TextureRegion(TextureRegion region, int x, int y, int width, int height) {
        setRegion(region, x, y, width, height);
    }

    public void setRegion(Texture texture) {
        this.texture = texture;
        setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public void setRegion(int x, int y, int width, int height) {
        float invTexWidth = 1.0f / ((float) this.texture.getWidth());
        float invTexHeight = 1.0f / ((float) this.texture.getHeight());
        setRegion(((float) x) * invTexWidth, ((float) y) * invTexHeight, ((float) (x + width)) * invTexWidth, ((float) (y + height)) * invTexHeight);
        this.regionWidth = Math.abs(width);
        this.regionHeight = Math.abs(height);
    }

    public void setRegion(float u, float v, float u2, float v2) {
        int texWidth = this.texture.getWidth();
        int texHeight = this.texture.getHeight();
        this.regionWidth = Math.round(Math.abs(u2 - u) * ((float) texWidth));
        this.regionHeight = Math.round(Math.abs(v2 - v) * ((float) texHeight));
        if (this.regionWidth == 1 && this.regionHeight == 1) {
            float adjustX = 0.25f / ((float) texWidth);
            u += adjustX;
            u2 -= adjustX;
            float adjustY = 0.25f / ((float) texHeight);
            v += adjustY;
            v2 -= adjustY;
        }
        this.f52u = u;
        this.f53v = v;
        this.u2 = u2;
        this.v2 = v2;
    }

    public void setRegion(TextureRegion region) {
        this.texture = region.texture;
        setRegion(region.f52u, region.f53v, region.u2, region.v2);
    }

    public void setRegion(TextureRegion region, int x, int y, int width, int height) {
        this.texture = region.texture;
        setRegion(region.getRegionX() + x, region.getRegionY() + y, width, height);
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getU() {
        return this.f52u;
    }

    public void setU(float u) {
        this.f52u = u;
        this.regionWidth = Math.round(Math.abs(this.u2 - u) * ((float) this.texture.getWidth()));
    }

    public float getV() {
        return this.f53v;
    }

    public void setV(float v) {
        this.f53v = v;
        this.regionHeight = Math.round(Math.abs(this.v2 - v) * ((float) this.texture.getHeight()));
    }

    public float getU2() {
        return this.u2;
    }

    public void setU2(float u2) {
        this.u2 = u2;
        this.regionWidth = Math.round(Math.abs(u2 - this.f52u) * ((float) this.texture.getWidth()));
    }

    public float getV2() {
        return this.v2;
    }

    public void setV2(float v2) {
        this.v2 = v2;
        this.regionHeight = Math.round(Math.abs(v2 - this.f53v) * ((float) this.texture.getHeight()));
    }

    public int getRegionX() {
        return Math.round(this.f52u * ((float) this.texture.getWidth()));
    }

    public void setRegionX(int x) {
        setU(((float) x) / ((float) this.texture.getWidth()));
    }

    public int getRegionY() {
        return Math.round(this.f53v * ((float) this.texture.getHeight()));
    }

    public void setRegionY(int y) {
        setV(((float) y) / ((float) this.texture.getHeight()));
    }

    public int getRegionWidth() {
        return this.regionWidth;
    }

    public void setRegionWidth(int width) {
        if (isFlipX()) {
            setU(this.u2 + (((float) width) / ((float) this.texture.getWidth())));
        } else {
            setU2(this.f52u + (((float) width) / ((float) this.texture.getWidth())));
        }
    }

    public int getRegionHeight() {
        return this.regionHeight;
    }

    public void setRegionHeight(int height) {
        if (isFlipY()) {
            setV(this.v2 + (((float) height) / ((float) this.texture.getHeight())));
        } else {
            setV2(this.f53v + (((float) height) / ((float) this.texture.getHeight())));
        }
    }

    public void flip(boolean x, boolean y) {
        if (x) {
            float temp = this.f52u;
            this.f52u = this.u2;
            this.u2 = temp;
        }
        if (y) {
            temp = this.f53v;
            this.f53v = this.v2;
            this.v2 = temp;
        }
    }

    public boolean isFlipX() {
        return this.f52u > this.u2;
    }

    public boolean isFlipY() {
        return this.f53v > this.v2;
    }

    public void scroll(float xAmount, float yAmount) {
        if (xAmount != 0.0f) {
            float width = (this.u2 - this.f52u) * ((float) this.texture.getWidth());
            this.f52u = (this.f52u + xAmount) % 1.0f;
            this.u2 = this.f52u + (width / ((float) this.texture.getWidth()));
        }
        if (yAmount != 0.0f) {
            float height = (this.v2 - this.f53v) * ((float) this.texture.getHeight());
            this.f53v = (this.f53v + yAmount) % 1.0f;
            this.v2 = this.f53v + (height / ((float) this.texture.getHeight()));
        }
    }

    public TextureRegion[][] split(int tileWidth, int tileHeight) {
        int x = getRegionX();
        int y = getRegionY();
        int rows = this.regionHeight / tileHeight;
        int cols = this.regionWidth / tileWidth;
        int startX = x;
        TextureRegion[][] tiles = (TextureRegion[][]) Array.newInstance(TextureRegion.class, new int[]{rows, cols});
        int row = 0;
        while (row < rows) {
            x = startX;
            int col = 0;
            while (col < cols) {
                tiles[row][col] = new TextureRegion(this.texture, x, y, tileWidth, tileHeight);
                col++;
                x += tileWidth;
            }
            row++;
            y += tileHeight;
        }
        return tiles;
    }

    public static TextureRegion[][] split(Texture texture, int tileWidth, int tileHeight) {
        return new TextureRegion(texture).split(tileWidth, tileHeight);
    }
}
