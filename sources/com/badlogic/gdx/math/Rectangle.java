package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Rectangle implements Serializable, Shape2D {
    private static final long serialVersionUID = 5733252015138115702L;
    public static final Rectangle tmp = new Rectangle();
    public static final Rectangle tmp2 = new Rectangle();
    public float height;
    public float width;
    /* renamed from: x */
    public float f154x;
    /* renamed from: y */
    public float f155y;

    public Rectangle(float x, float y, float width, float height) {
        this.f154x = x;
        this.f155y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle rect) {
        this.f154x = rect.f154x;
        this.f155y = rect.f155y;
        this.width = rect.width;
        this.height = rect.height;
    }

    public Rectangle set(float x, float y, float width, float height) {
        this.f154x = x;
        this.f155y = y;
        this.width = width;
        this.height = height;
        return this;
    }

    public float getX() {
        return this.f154x;
    }

    public Rectangle setX(float x) {
        this.f154x = x;
        return this;
    }

    public float getY() {
        return this.f155y;
    }

    public Rectangle setY(float y) {
        this.f155y = y;
        return this;
    }

    public float getWidth() {
        return this.width;
    }

    public Rectangle setWidth(float width) {
        this.width = width;
        return this;
    }

    public float getHeight() {
        return this.height;
    }

    public Rectangle setHeight(float height) {
        this.height = height;
        return this;
    }

    public Vector2 getPosition(Vector2 position) {
        return position.set(this.f154x, this.f155y);
    }

    public Rectangle setPosition(Vector2 position) {
        this.f154x = position.f158x;
        this.f155y = position.f159y;
        return this;
    }

    public Rectangle setPosition(float x, float y) {
        this.f154x = x;
        this.f155y = y;
        return this;
    }

    public Rectangle setSize(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public Rectangle setSize(float sizeXY) {
        this.width = sizeXY;
        this.height = sizeXY;
        return this;
    }

    public Vector2 getSize(Vector2 size) {
        return size.set(this.width, this.height);
    }

    public boolean contains(float x, float y) {
        return this.f154x <= x && this.f154x + this.width >= x && this.f155y <= y && this.f155y + this.height >= y;
    }

    public boolean contains(Vector2 point) {
        return contains(point.f158x, point.f159y);
    }

    public boolean contains(Rectangle rectangle) {
        float xmin = rectangle.f154x;
        float xmax = xmin + rectangle.width;
        float ymin = rectangle.f155y;
        float ymax = ymin + rectangle.height;
        return xmin > this.f154x && xmin < this.f154x + this.width && xmax > this.f154x && xmax < this.f154x + this.width && ymin > this.f155y && ymin < this.f155y + this.height && ymax > this.f155y && ymax < this.f155y + this.height;
    }

    public boolean overlaps(Rectangle r) {
        return this.f154x < r.f154x + r.width && this.f154x + this.width > r.f154x && this.f155y < r.f155y + r.height && this.f155y + this.height > r.f155y;
    }

    public Rectangle set(Rectangle rect) {
        this.f154x = rect.f154x;
        this.f155y = rect.f155y;
        this.width = rect.width;
        this.height = rect.height;
        return this;
    }

    public Rectangle merge(Rectangle rect) {
        float minX = Math.min(this.f154x, rect.f154x);
        float maxX = Math.max(this.f154x + this.width, rect.f154x + rect.width);
        this.f154x = minX;
        this.width = maxX - minX;
        float minY = Math.min(this.f155y, rect.f155y);
        float maxY = Math.max(this.f155y + this.height, rect.f155y + rect.height);
        this.f155y = minY;
        this.height = maxY - minY;
        return this;
    }

    public Rectangle merge(float x, float y) {
        float minX = Math.min(this.f154x, x);
        float maxX = Math.max(this.f154x + this.width, x);
        this.f154x = minX;
        this.width = maxX - minX;
        float minY = Math.min(this.f155y, y);
        float maxY = Math.max(this.f155y + this.height, y);
        this.f155y = minY;
        this.height = maxY - minY;
        return this;
    }

    public Rectangle merge(Vector2 vec) {
        return merge(vec.f158x, vec.f159y);
    }

    public Rectangle merge(Vector2[] vecs) {
        float minX = this.f154x;
        float maxX = this.f154x + this.width;
        float minY = this.f155y;
        float maxY = this.f155y + this.height;
        for (Vector2 v : vecs) {
            minX = Math.min(minX, v.f158x);
            maxX = Math.max(maxX, v.f158x);
            minY = Math.min(minY, v.f159y);
            maxY = Math.max(maxY, v.f159y);
        }
        this.f154x = minX;
        this.width = maxX - minX;
        this.f155y = minY;
        this.height = maxY - minY;
        return this;
    }

    public float getAspectRatio() {
        return this.height == 0.0f ? Float.NaN : this.width / this.height;
    }

    public Vector2 getCenter(Vector2 vector) {
        vector.f158x = this.f154x + (this.width / 2.0f);
        vector.f159y = this.f155y + (this.height / 2.0f);
        return vector;
    }

    public Rectangle setCenter(float x, float y) {
        setPosition(x - (this.width / 2.0f), y - (this.height / 2.0f));
        return this;
    }

    public Rectangle setCenter(Vector2 position) {
        setPosition(position.f158x - (this.width / 2.0f), position.f159y - (this.height / 2.0f));
        return this;
    }

    public Rectangle fitOutside(Rectangle rect) {
        float ratio = getAspectRatio();
        if (ratio > rect.getAspectRatio()) {
            setSize(rect.height * ratio, rect.height);
        } else {
            setSize(rect.width, rect.width / ratio);
        }
        setPosition((rect.f154x + (rect.width / 2.0f)) - (this.width / 2.0f), (rect.f155y + (rect.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public Rectangle fitInside(Rectangle rect) {
        float ratio = getAspectRatio();
        if (ratio < rect.getAspectRatio()) {
            setSize(rect.height * ratio, rect.height);
        } else {
            setSize(rect.width, rect.width / ratio);
        }
        setPosition((rect.f154x + (rect.width / 2.0f)) - (this.width / 2.0f), (rect.f155y + (rect.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public String toString() {
        return this.f154x + "," + this.f155y + "," + this.width + "," + this.height;
    }

    public float area() {
        return this.width * this.height;
    }

    public float perimeter() {
        return 2.0f * (this.width + this.height);
    }

    public int hashCode() {
        return ((((((NumberUtils.floatToRawIntBits(this.height) + 31) * 31) + NumberUtils.floatToRawIntBits(this.width)) * 31) + NumberUtils.floatToRawIntBits(this.f154x)) * 31) + NumberUtils.floatToRawIntBits(this.f155y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Rectangle other = (Rectangle) obj;
        if (NumberUtils.floatToRawIntBits(this.height) != NumberUtils.floatToRawIntBits(other.height)) {
            return false;
        }
        if (NumberUtils.floatToRawIntBits(this.width) != NumberUtils.floatToRawIntBits(other.width)) {
            return false;
        }
        if (NumberUtils.floatToRawIntBits(this.f154x) != NumberUtils.floatToRawIntBits(other.f154x)) {
            return false;
        }
        if (NumberUtils.floatToRawIntBits(this.f155y) != NumberUtils.floatToRawIntBits(other.f155y)) {
            return false;
        }
        return true;
    }
}
