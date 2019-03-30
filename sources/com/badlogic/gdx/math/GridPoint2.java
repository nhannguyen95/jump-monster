package com.badlogic.gdx.math;

public class GridPoint2 {
    /* renamed from: x */
    public int f58x;
    /* renamed from: y */
    public int f59y;

    public GridPoint2(int x, int y) {
        this.f58x = x;
        this.f59y = y;
    }

    public GridPoint2(GridPoint2 point) {
        this.f58x = point.f58x;
        this.f59y = point.f59y;
    }

    public GridPoint2 set(GridPoint2 point) {
        this.f58x = point.f58x;
        this.f59y = point.f59y;
        return this;
    }

    public GridPoint2 set(int x, int y) {
        this.f58x = x;
        this.f59y = y;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        GridPoint2 g = (GridPoint2) o;
        if (this.f58x == g.f58x && this.f59y == g.f59y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f58x + 53) * 53) + this.f59y;
    }
}
