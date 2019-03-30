package com.egovy.jumpmonster.utils;

public class MultipleVirtualViewportBuilder {
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public void init(float minWidth, float minHeight, float maxWidth, float maxHeight) {
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public VirtualViewport getVirtualViewport(float width, float height) {
        if (width >= this.minWidth && width <= this.maxWidth && height >= this.minHeight && height <= this.maxHeight) {
            return new VirtualViewport(width, height, true);
        }
        float aspect = width / height;
        float scaleForMinSize = this.minWidth / width;
        float virtualViewportWidth = width * (this.maxWidth / width);
        float virtualViewportHeight = virtualViewportWidth / aspect;
        if (insideBounds(virtualViewportWidth, virtualViewportHeight)) {
            return new VirtualViewport(virtualViewportWidth, virtualViewportHeight, false);
        }
        virtualViewportWidth = width * scaleForMinSize;
        virtualViewportHeight = virtualViewportWidth / aspect;
        if (insideBounds(virtualViewportWidth, virtualViewportHeight)) {
            return new VirtualViewport(virtualViewportWidth, virtualViewportHeight, false);
        }
        return new VirtualViewport(this.minWidth, this.minHeight, true);
    }

    private boolean insideBounds(float width, float height) {
        if (width < this.minWidth || width > this.maxWidth || height < this.minHeight || height > this.maxHeight) {
            return false;
        }
        return true;
    }
}
