package com.egovy.jumpmonster.utils;

import com.badlogic.gdx.Gdx;

public class VirtualViewport {
    float realVirtualHeight;
    float realVirtualWidth;
    float virtualHeight;
    float virtualWidth;

    public float getVirtualWidth() {
        return this.virtualWidth;
    }

    public float getVirtualHeight() {
        return this.virtualHeight;
    }

    public VirtualViewport(float virtualWidth, float virtualHeight) {
        this(virtualWidth, virtualHeight, false);
    }

    public VirtualViewport(float virtualWidth, float virtualHeight, boolean shrink) {
        this.virtualWidth = virtualWidth;
        this.virtualHeight = virtualHeight;
    }

    public float getWidth() {
        return getWidth((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
    }

    public float getHeight() {
        return getHeight((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
    }

    public float getWidth(float screenWidth, float screenHeight) {
        float virtualAspect = this.virtualWidth / this.virtualHeight;
        float aspect = screenWidth / screenHeight;
        if (aspect > virtualAspect || Math.abs(aspect - virtualAspect) < 0.01f) {
            this.realVirtualWidth = this.virtualHeight * aspect;
        } else {
            this.realVirtualWidth = this.virtualWidth;
        }
        return this.realVirtualWidth;
    }

    public float getHeight(float screenWidth, float screenHeight) {
        float virtualAspect = this.virtualWidth / this.virtualHeight;
        float aspect = screenWidth / screenHeight;
        if (aspect < virtualAspect || Math.abs(aspect - virtualAspect) < 0.01f) {
            this.realVirtualHeight = this.virtualHeight;
        } else {
            this.realVirtualHeight = this.virtualWidth / aspect;
        }
        return this.realVirtualHeight;
    }

    public float getRealVirtualWidth() {
        return this.realVirtualWidth;
    }

    public float getRealVirtualHeight() {
        return this.realVirtualHeight;
    }
}
