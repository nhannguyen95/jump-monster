package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Segment implements Serializable {
    private static final long serialVersionUID = 2739667069736519602L;
    /* renamed from: a */
    public final Vector3 f71a = new Vector3();
    /* renamed from: b */
    public final Vector3 f72b = new Vector3();

    public Segment(Vector3 a, Vector3 b) {
        this.f71a.set(a);
        this.f72b.set(b);
    }

    public Segment(float aX, float aY, float aZ, float bX, float bY, float bZ) {
        this.f71a.set(aX, aY, aZ);
        this.f72b.set(bX, bY, bZ);
    }

    public float len() {
        return this.f71a.dst(this.f72b);
    }

    public float len2() {
        return this.f71a.dst2(this.f72b);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Segment s = (Segment) o;
        if (this.f71a.equals(s.f71a) && this.f72b.equals(s.f72b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f71a.hashCode() + 71) * 71) + this.f72b.hashCode();
    }
}
