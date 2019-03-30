package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Ellipse implements Serializable, Shape2D {
    private static final long serialVersionUID = 7381533206532032099L;
    public float height;
    public float width;
    /* renamed from: x */
    public float f148x;
    /* renamed from: y */
    public float f149y;

    public Ellipse(Ellipse ellipse) {
        this.f148x = ellipse.f148x;
        this.f149y = ellipse.f149y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public Ellipse(float x, float y, float width, float height) {
        this.f148x = x;
        this.f149y = y;
        this.width = width;
        this.height = height;
    }

    public Ellipse(Vector2 position, float width, float height) {
        this.f148x = position.f158x;
        this.f149y = position.f159y;
        this.width = width;
        this.height = height;
    }

    public Ellipse(Vector2 position, Vector2 size) {
        this.f148x = position.f158x;
        this.f149y = position.f159y;
        this.width = size.f158x;
        this.height = size.f159y;
    }

    public Ellipse(Circle circle) {
        this.f148x = circle.f146x;
        this.f149y = circle.f147y;
        this.width = circle.radius;
        this.height = circle.radius;
    }

    public boolean contains(float x, float y) {
        x -= this.f148x;
        y -= this.f149y;
        return ((x * x) / (((this.width * 0.5f) * this.width) * 0.5f)) + ((y * y) / (((this.height * 0.5f) * this.height) * 0.5f)) <= 1.0f;
    }

    public boolean contains(Vector2 point) {
        return contains(point.f158x, point.f159y);
    }

    public void set(float x, float y, float width, float height) {
        this.f148x = x;
        this.f149y = y;
        this.width = width;
        this.height = height;
    }

    public void set(Ellipse ellipse) {
        this.f148x = ellipse.f148x;
        this.f149y = ellipse.f149y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public void set(Circle circle) {
        this.f148x = circle.f146x;
        this.f149y = circle.f147y;
        this.width = circle.radius;
        this.height = circle.radius;
    }

    public void set(Vector2 position, Vector2 size) {
        this.f148x = position.f158x;
        this.f149y = position.f159y;
        this.width = size.f158x;
        this.height = size.f159y;
    }

    public Ellipse setPosition(Vector2 position) {
        this.f148x = position.f158x;
        this.f149y = position.f159y;
        return this;
    }

    public Ellipse setPosition(float x, float y) {
        this.f148x = x;
        this.f149y = y;
        return this;
    }

    public Ellipse setSize(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public float area() {
        return (3.1415927f * (this.width * this.height)) / 4.0f;
    }

    public float circumference() {
        float a = this.width / 2.0f;
        float b = this.height / 2.0f;
        if (a * 3.0f > b || b * 3.0f > a) {
            return (float) (3.1415927410125732d * (((double) ((a + b) * 3.0f)) - Math.sqrt((double) (((3.0f * a) + b) * ((3.0f * b) + a)))));
        }
        return (float) (6.2831854820251465d * Math.sqrt((double) (((a * a) + (b * b)) / 2.0f)));
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Ellipse e = (Ellipse) o;
        if (this.f148x == e.f148x && this.f149y == e.f149y && this.width == e.width && this.height == e.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((NumberUtils.floatToRawIntBits(this.height) + 53) * 53) + NumberUtils.floatToRawIntBits(this.width)) * 53) + NumberUtils.floatToRawIntBits(this.f148x)) * 53) + NumberUtils.floatToRawIntBits(this.f149y);
    }
}
