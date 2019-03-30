package com.badlogic.gdx.math;

public class Polygon implements Shape2D {
    private Rectangle bounds;
    private boolean dirty;
    private float[] localVertices;
    private float originX;
    private float originY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    private float[] worldVertices;
    /* renamed from: x */
    private float f150x;
    /* renamed from: y */
    private float f151y;

    public Polygon() {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        this.localVertices = new float[0];
    }

    public Polygon(float[] vertices) {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        if (vertices.length < 6) {
            throw new IllegalArgumentException("polygons must contain at least 3 points.");
        }
        this.localVertices = vertices;
    }

    public float[] getVertices() {
        return this.localVertices;
    }

    public float[] getTransformedVertices() {
        if (!this.dirty) {
            return this.worldVertices;
        }
        this.dirty = false;
        float[] localVertices = this.localVertices;
        if (this.worldVertices == null || this.worldVertices.length != localVertices.length) {
            this.worldVertices = new float[localVertices.length];
        }
        float[] worldVertices = this.worldVertices;
        float positionX = this.f150x;
        float positionY = this.f151y;
        float originX = this.originX;
        float originY = this.originY;
        float scaleX = this.scaleX;
        float scaleY = this.scaleY;
        boolean scale = (scaleX == 1.0f && scaleY == 1.0f) ? false : true;
        float rotation = this.rotation;
        float cos = MathUtils.cosDeg(rotation);
        float sin = MathUtils.sinDeg(rotation);
        int n = localVertices.length;
        for (int i = 0; i < n; i += 2) {
            float x = localVertices[i] - originX;
            float y = localVertices[i + 1] - originY;
            if (scale) {
                x *= scaleX;
                y *= scaleY;
            }
            if (rotation != 0.0f) {
                float oldX = x;
                x = (cos * x) - (sin * y);
                y = (sin * oldX) + (cos * y);
            }
            worldVertices[i] = (positionX + x) + originX;
            worldVertices[i + 1] = (positionY + y) + originY;
        }
        return worldVertices;
    }

    public void setOrigin(float originX, float originY) {
        this.originX = originX;
        this.originY = originY;
        this.dirty = true;
    }

    public void setPosition(float x, float y) {
        this.f150x = x;
        this.f151y = y;
        this.dirty = true;
    }

    public void setVertices(float[] vertices) {
        if (vertices.length < 6) {
            throw new IllegalArgumentException("polygons must contain at least 3 points.");
        }
        this.localVertices = vertices;
        this.dirty = true;
    }

    public void translate(float x, float y) {
        this.f150x += x;
        this.f151y += y;
        this.dirty = true;
    }

    public void setRotation(float degrees) {
        this.rotation = degrees;
        this.dirty = true;
    }

    public void rotate(float degrees) {
        this.rotation += degrees;
        this.dirty = true;
    }

    public void setScale(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.dirty = true;
    }

    public void scale(float amount) {
        this.scaleX += amount;
        this.scaleY += amount;
        this.dirty = true;
    }

    public void dirty() {
        this.dirty = true;
    }

    public float area() {
        float[] vertices = getTransformedVertices();
        return GeometryUtils.polygonArea(vertices, 0, vertices.length);
    }

    public Rectangle getBoundingRectangle() {
        float[] vertices = getTransformedVertices();
        float minX = vertices[0];
        float minY = vertices[1];
        float maxX = vertices[0];
        float maxY = vertices[1];
        int numFloats = vertices.length;
        for (int i = 2; i < numFloats; i += 2) {
            if (minX > vertices[i]) {
                minX = vertices[i];
            }
            if (minY > vertices[i + 1]) {
                minY = vertices[i + 1];
            }
            if (maxX < vertices[i]) {
                maxX = vertices[i];
            }
            if (maxY < vertices[i + 1]) {
                maxY = vertices[i + 1];
            }
        }
        if (this.bounds == null) {
            this.bounds = new Rectangle();
        }
        this.bounds.f154x = minX;
        this.bounds.f155y = minY;
        this.bounds.width = maxX - minX;
        this.bounds.height = maxY - minY;
        return this.bounds;
    }

    public boolean contains(float x, float y) {
        float[] vertices = getTransformedVertices();
        int numFloats = vertices.length;
        int intersects = 0;
        for (int i = 0; i < numFloats; i += 2) {
            float x1 = vertices[i];
            float y1 = vertices[i + 1];
            float x2 = vertices[(i + 2) % numFloats];
            float y2 = vertices[(i + 3) % numFloats];
            if (((y1 <= y && y < y2) || (y2 <= y && y < y1)) && x < (((x2 - x1) / (y2 - y1)) * (y - y1)) + x1) {
                intersects++;
            }
        }
        if ((intersects & 1) == 1) {
            return true;
        }
        return false;
    }

    public float getX() {
        return this.f150x;
    }

    public float getY() {
        return this.f151y;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }
}
