package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;
import java.util.List;

public class BoundingBox implements Serializable {
    private static final long serialVersionUID = -1286036817192127343L;
    private static final Vector3 tmpVector = new Vector3();
    private final Vector3 cnt = new Vector3();
    @Deprecated
    private Vector3[] corners;
    private final Vector3 dim = new Vector3();
    public final Vector3 max = new Vector3();
    public final Vector3 min = new Vector3();

    @Deprecated
    public Vector3 getCenter() {
        return this.cnt;
    }

    public Vector3 getCenter(Vector3 out) {
        return out.set(this.cnt);
    }

    public float getCenterX() {
        return this.cnt.f163x;
    }

    public float getCenterY() {
        return this.cnt.f164y;
    }

    public float getCenterZ() {
        return this.cnt.f165z;
    }

    @Deprecated
    protected void updateCorners() {
    }

    @Deprecated
    public Vector3[] getCorners() {
        if (this.corners == null) {
            this.corners = new Vector3[8];
            for (int i = 0; i < 8; i++) {
                this.corners[i] = new Vector3();
            }
        }
        this.corners[0].set(this.min.f163x, this.min.f164y, this.min.f165z);
        this.corners[1].set(this.max.f163x, this.min.f164y, this.min.f165z);
        this.corners[2].set(this.max.f163x, this.max.f164y, this.min.f165z);
        this.corners[3].set(this.min.f163x, this.max.f164y, this.min.f165z);
        this.corners[4].set(this.min.f163x, this.min.f164y, this.max.f165z);
        this.corners[5].set(this.max.f163x, this.min.f164y, this.max.f165z);
        this.corners[6].set(this.max.f163x, this.max.f164y, this.max.f165z);
        this.corners[7].set(this.min.f163x, this.max.f164y, this.max.f165z);
        return this.corners;
    }

    public Vector3 getCorner000(Vector3 out) {
        return out.set(this.min.f163x, this.min.f164y, this.min.f165z);
    }

    public Vector3 getCorner001(Vector3 out) {
        return out.set(this.min.f163x, this.min.f164y, this.max.f165z);
    }

    public Vector3 getCorner010(Vector3 out) {
        return out.set(this.min.f163x, this.max.f164y, this.min.f165z);
    }

    public Vector3 getCorner011(Vector3 out) {
        return out.set(this.min.f163x, this.max.f164y, this.max.f165z);
    }

    public Vector3 getCorner100(Vector3 out) {
        return out.set(this.max.f163x, this.min.f164y, this.min.f165z);
    }

    public Vector3 getCorner101(Vector3 out) {
        return out.set(this.max.f163x, this.min.f164y, this.max.f165z);
    }

    public Vector3 getCorner110(Vector3 out) {
        return out.set(this.max.f163x, this.max.f164y, this.min.f165z);
    }

    public Vector3 getCorner111(Vector3 out) {
        return out.set(this.max.f163x, this.max.f164y, this.max.f165z);
    }

    @Deprecated
    public Vector3 getDimensions() {
        return this.dim;
    }

    public Vector3 getDimensions(Vector3 out) {
        return out.set(this.dim);
    }

    public float getWidth() {
        return this.dim.f163x;
    }

    public float getHeight() {
        return this.dim.f164y;
    }

    public float getDepth() {
        return this.dim.f165z;
    }

    @Deprecated
    public Vector3 getMin() {
        return this.min;
    }

    public Vector3 getMin(Vector3 out) {
        return out.set(this.min);
    }

    @Deprecated
    public Vector3 getMax() {
        return this.max;
    }

    public Vector3 getMax(Vector3 out) {
        return out.set(this.max);
    }

    public BoundingBox() {
        clr();
    }

    public BoundingBox(BoundingBox bounds) {
        set(bounds);
    }

    public BoundingBox(Vector3 minimum, Vector3 maximum) {
        set(minimum, maximum);
    }

    public BoundingBox set(BoundingBox bounds) {
        return set(bounds.min, bounds.max);
    }

    public BoundingBox set(Vector3 minimum, Vector3 maximum) {
        this.min.set(minimum.f163x < maximum.f163x ? minimum.f163x : maximum.f163x, minimum.f164y < maximum.f164y ? minimum.f164y : maximum.f164y, minimum.f165z < maximum.f165z ? minimum.f165z : maximum.f165z);
        this.max.set(minimum.f163x > maximum.f163x ? minimum.f163x : maximum.f163x, minimum.f164y > maximum.f164y ? minimum.f164y : maximum.f164y, minimum.f165z > maximum.f165z ? minimum.f165z : maximum.f165z);
        this.cnt.set(this.min).add(this.max).scl(0.5f);
        this.dim.set(this.max).sub(this.min);
        return this;
    }

    public BoundingBox set(Vector3[] points) {
        inf();
        for (Vector3 l_point : points) {
            ext(l_point);
        }
        return this;
    }

    public BoundingBox set(List<Vector3> points) {
        inf();
        for (Vector3 l_point : points) {
            ext(l_point);
        }
        return this;
    }

    public BoundingBox inf() {
        this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.cnt.set(0.0f, 0.0f, 0.0f);
        this.dim.set(0.0f, 0.0f, 0.0f);
        return this;
    }

    public BoundingBox ext(Vector3 point) {
        return set(this.min.set(min(this.min.f163x, point.f163x), min(this.min.f164y, point.f164y), min(this.min.f165z, point.f165z)), this.max.set(Math.max(this.max.f163x, point.f163x), Math.max(this.max.f164y, point.f164y), Math.max(this.max.f165z, point.f165z)));
    }

    public BoundingBox clr() {
        return set(this.min.set(0.0f, 0.0f, 0.0f), this.max.set(0.0f, 0.0f, 0.0f));
    }

    public boolean isValid() {
        return this.min.f163x < this.max.f163x && this.min.f164y < this.max.f164y && this.min.f165z < this.max.f165z;
    }

    public BoundingBox ext(BoundingBox a_bounds) {
        return set(this.min.set(min(this.min.f163x, a_bounds.min.f163x), min(this.min.f164y, a_bounds.min.f164y), min(this.min.f165z, a_bounds.min.f165z)), this.max.set(max(this.max.f163x, a_bounds.max.f163x), max(this.max.f164y, a_bounds.max.f164y), max(this.max.f165z, a_bounds.max.f165z)));
    }

    public BoundingBox ext(BoundingBox bounds, Matrix4 transform) {
        ext(tmpVector.set(bounds.min.f163x, bounds.min.f164y, bounds.min.f165z).mul(transform));
        ext(tmpVector.set(bounds.min.f163x, bounds.min.f164y, bounds.max.f165z).mul(transform));
        ext(tmpVector.set(bounds.min.f163x, bounds.max.f164y, bounds.min.f165z).mul(transform));
        ext(tmpVector.set(bounds.min.f163x, bounds.max.f164y, bounds.max.f165z).mul(transform));
        ext(tmpVector.set(bounds.max.f163x, bounds.min.f164y, bounds.min.f165z).mul(transform));
        ext(tmpVector.set(bounds.max.f163x, bounds.min.f164y, bounds.max.f165z).mul(transform));
        ext(tmpVector.set(bounds.max.f163x, bounds.max.f164y, bounds.min.f165z).mul(transform));
        ext(tmpVector.set(bounds.max.f163x, bounds.max.f164y, bounds.max.f165z).mul(transform));
        return this;
    }

    public BoundingBox mul(Matrix4 transform) {
        float x0 = this.min.f163x;
        float y0 = this.min.f164y;
        float z0 = this.min.f165z;
        float x1 = this.max.f163x;
        float y1 = this.max.f164y;
        float z1 = this.max.f165z;
        inf();
        ext(tmpVector.set(x0, y0, z0).mul(transform));
        ext(tmpVector.set(x0, y0, z1).mul(transform));
        ext(tmpVector.set(x0, y1, z0).mul(transform));
        ext(tmpVector.set(x0, y1, z1).mul(transform));
        ext(tmpVector.set(x1, y0, z0).mul(transform));
        ext(tmpVector.set(x1, y0, z1).mul(transform));
        ext(tmpVector.set(x1, y1, z0).mul(transform));
        ext(tmpVector.set(x1, y1, z1).mul(transform));
        return this;
    }

    public boolean contains(BoundingBox b) {
        return !isValid() || (this.min.f163x <= b.min.f163x && this.min.f164y <= b.min.f164y && this.min.f165z <= b.min.f165z && this.max.f163x >= b.max.f163x && this.max.f164y >= b.max.f164y && this.max.f165z >= b.max.f165z);
    }

    public boolean intersects(BoundingBox b) {
        if (!isValid()) {
            return false;
        }
        float lx = Math.abs(this.cnt.f163x - b.cnt.f163x);
        float sumx = (this.dim.f163x / 2.0f) + (b.dim.f163x / 2.0f);
        float ly = Math.abs(this.cnt.f164y - b.cnt.f164y);
        float sumy = (this.dim.f164y / 2.0f) + (b.dim.f164y / 2.0f);
        float lz = Math.abs(this.cnt.f165z - b.cnt.f165z);
        float sumz = (this.dim.f165z / 2.0f) + (b.dim.f165z / 2.0f);
        if (lx > sumx || ly > sumy || lz > sumz) {
            return false;
        }
        return true;
    }

    public boolean contains(Vector3 v) {
        return this.min.f163x <= v.f163x && this.max.f163x >= v.f163x && this.min.f164y <= v.f164y && this.max.f164y >= v.f164y && this.min.f165z <= v.f165z && this.max.f165z >= v.f165z;
    }

    public String toString() {
        return "[" + this.min + "|" + this.max + "]";
    }

    public BoundingBox ext(float x, float y, float z) {
        return set(this.min.set(min(this.min.f163x, x), min(this.min.f164y, y), min(this.min.f165z, z)), this.max.set(max(this.max.f163x, x), max(this.max.f164y, y), max(this.max.f165z, z)));
    }

    static final float min(float a, float b) {
        return a > b ? b : a;
    }

    static final float max(float a, float b) {
        return a > b ? a : b;
    }
}
