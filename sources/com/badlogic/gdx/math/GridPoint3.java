package com.badlogic.gdx.math;

public class GridPoint3 {
    /* renamed from: x */
    public int f60x;
    /* renamed from: y */
    public int f61y;
    /* renamed from: z */
    public int f62z;

    public GridPoint3(int x, int y, int z) {
        this.f60x = x;
        this.f61y = y;
        this.f62z = z;
    }

    public GridPoint3(GridPoint3 point) {
        this.f60x = point.f60x;
        this.f61y = point.f61y;
        this.f62z = point.f62z;
    }

    public GridPoint3 set(GridPoint3 point) {
        this.f60x = point.f60x;
        this.f61y = point.f61y;
        this.f62z = point.f62z;
        return this;
    }

    public GridPoint3 set(int x, int y, int z) {
        this.f60x = x;
        this.f61y = y;
        this.f62z = z;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        GridPoint3 g = (GridPoint3) o;
        if (this.f60x == g.f60x && this.f61y == g.f61y && this.f62z == g.f62z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f60x + 17) * 17) + this.f61y) * 17) + this.f62z;
    }
}
