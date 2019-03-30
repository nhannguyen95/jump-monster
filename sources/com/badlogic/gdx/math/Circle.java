package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Circle implements Serializable, Shape2D {
    public float radius;
    /* renamed from: x */
    public float f146x;
    /* renamed from: y */
    public float f147y;

    public Circle(float x, float y, float radius) {
        this.f146x = x;
        this.f147y = y;
        this.radius = radius;
    }

    public Circle(Vector2 position, float radius) {
        this.f146x = position.f158x;
        this.f147y = position.f159y;
        this.radius = radius;
    }

    public Circle(Circle circle) {
        this.f146x = circle.f146x;
        this.f147y = circle.f147y;
        this.radius = circle.radius;
    }

    public Circle(Vector2 center, Vector2 edge) {
        this.f146x = center.f158x;
        this.f147y = center.f159y;
        this.radius = Vector2.len(center.f158x - edge.f158x, center.f159y - edge.f159y);
    }

    public void set(float x, float y, float radius) {
        this.f146x = x;
        this.f147y = y;
        this.radius = radius;
    }

    public void set(Vector2 position, float radius) {
        this.f146x = position.f158x;
        this.f147y = position.f159y;
        this.radius = radius;
    }

    public void set(Circle circle) {
        this.f146x = circle.f146x;
        this.f147y = circle.f147y;
        this.radius = circle.radius;
    }

    public void set(Vector2 center, Vector2 edge) {
        this.f146x = center.f158x;
        this.f147y = center.f159y;
        this.radius = Vector2.len(center.f158x - edge.f158x, center.f159y - edge.f159y);
    }

    public void setPosition(Vector2 position) {
        this.f146x = position.f158x;
        this.f147y = position.f159y;
    }

    public void setPosition(float x, float y) {
        this.f146x = x;
        this.f147y = y;
    }

    public void setX(float x) {
        this.f146x = x;
    }

    public void setY(float y) {
        this.f147y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public boolean contains(float x, float y) {
        x = this.f146x - x;
        y = this.f147y - y;
        return (x * x) + (y * y) <= this.radius * this.radius;
    }

    public boolean contains(Vector2 point) {
        float dx = this.f146x - point.f158x;
        float dy = this.f147y - point.f159y;
        return (dx * dx) + (dy * dy) <= this.radius * this.radius;
    }

    public boolean contains(Circle c) {
        float dx = this.f146x - c.f146x;
        float dy = this.f147y - c.f147y;
        return ((dx * dx) + (dy * dy)) + (c.radius * c.radius) <= this.radius * this.radius;
    }

    public boolean overlaps(Circle c) {
        float dx = this.f146x - c.f146x;
        float dy = this.f147y - c.f147y;
        float radiusSum = this.radius + c.radius;
        return (dx * dx) + (dy * dy) < radiusSum * radiusSum;
    }

    public String toString() {
        return this.f146x + "," + this.f147y + "," + this.radius;
    }

    public float circumference() {
        return this.radius * 6.2831855f;
    }

    public float area() {
        return (this.radius * this.radius) * 3.1415927f;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Circle c = (Circle) o;
        if (this.f146x == c.f146x && this.f147y == c.f147y && this.radius == c.radius) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((NumberUtils.floatToRawIntBits(this.radius) + 41) * 41) + NumberUtils.floatToRawIntBits(this.f146x)) * 41) + NumberUtils.floatToRawIntBits(this.f147y);
    }
}
