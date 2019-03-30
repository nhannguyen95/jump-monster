package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Vector3 implements Serializable, Vector<Vector3> {
    /* renamed from: X */
    public static final Vector3 f160X = new Vector3(1.0f, 0.0f, 0.0f);
    /* renamed from: Y */
    public static final Vector3 f161Y = new Vector3(0.0f, 1.0f, 0.0f);
    /* renamed from: Z */
    public static final Vector3 f162Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 Zero = new Vector3(0.0f, 0.0f, 0.0f);
    private static final long serialVersionUID = 3840054589595372522L;
    private static final Matrix4 tmpMat = new Matrix4();
    /* renamed from: x */
    public float f163x;
    /* renamed from: y */
    public float f164y;
    /* renamed from: z */
    public float f165z;

    public Vector3(float x, float y, float z) {
        set(x, y, z);
    }

    public Vector3(Vector3 vector) {
        set(vector);
    }

    public Vector3(float[] values) {
        set(values[0], values[1], values[2]);
    }

    public Vector3(Vector2 vector, float z) {
        set(vector.f158x, vector.f159y, z);
    }

    public Vector3 set(float x, float y, float z) {
        this.f163x = x;
        this.f164y = y;
        this.f165z = z;
        return this;
    }

    public Vector3 set(Vector3 vector) {
        return set(vector.f163x, vector.f164y, vector.f165z);
    }

    public Vector3 set(float[] values) {
        return set(values[0], values[1], values[2]);
    }

    public Vector3 set(Vector2 vector, float z) {
        return set(vector.f158x, vector.f159y, z);
    }

    public Vector3 cpy() {
        return new Vector3(this);
    }

    public Vector3 add(Vector3 vector) {
        return add(vector.f163x, vector.f164y, vector.f165z);
    }

    public Vector3 add(float x, float y, float z) {
        return set(this.f163x + x, this.f164y + y, this.f165z + z);
    }

    public Vector3 add(float values) {
        return set(this.f163x + values, this.f164y + values, this.f165z + values);
    }

    public Vector3 sub(Vector3 a_vec) {
        return sub(a_vec.f163x, a_vec.f164y, a_vec.f165z);
    }

    public Vector3 sub(float x, float y, float z) {
        return set(this.f163x - x, this.f164y - y, this.f165z - z);
    }

    public Vector3 sub(float value) {
        return set(this.f163x - value, this.f164y - value, this.f165z - value);
    }

    public Vector3 scl(float scalar) {
        return set(this.f163x * scalar, this.f164y * scalar, this.f165z * scalar);
    }

    public Vector3 scl(Vector3 other) {
        return set(this.f163x * other.f163x, this.f164y * other.f164y, this.f165z * other.f165z);
    }

    public Vector3 scl(float vx, float vy, float vz) {
        return set(this.f163x * vx, this.f164y * vy, this.f165z * vz);
    }

    public Vector3 mulAdd(Vector3 vec, float scalar) {
        this.f163x += vec.f163x * scalar;
        this.f164y += vec.f164y * scalar;
        this.f165z += vec.f165z * scalar;
        return this;
    }

    public Vector3 mulAdd(Vector3 vec, Vector3 mulVec) {
        this.f163x += vec.f163x * mulVec.f163x;
        this.f164y += vec.f164y * mulVec.f164y;
        this.f165z += vec.f165z * mulVec.f165z;
        return this;
    }

    public static float len(float x, float y, float z) {
        return (float) Math.sqrt((double) (((x * x) + (y * y)) + (z * z)));
    }

    public float len() {
        return (float) Math.sqrt((double) (((this.f163x * this.f163x) + (this.f164y * this.f164y)) + (this.f165z * this.f165z)));
    }

    public static float len2(float x, float y, float z) {
        return ((x * x) + (y * y)) + (z * z);
    }

    public float len2() {
        return ((this.f163x * this.f163x) + (this.f164y * this.f164y)) + (this.f165z * this.f165z);
    }

    public boolean idt(Vector3 vector) {
        return this.f163x == vector.f163x && this.f164y == vector.f164y && this.f165z == vector.f165z;
    }

    public static float dst(float x1, float y1, float z1, float x2, float y2, float z2) {
        float a = x2 - x1;
        float b = y2 - y1;
        float c = z2 - z1;
        return (float) Math.sqrt((double) (((a * a) + (b * b)) + (c * c)));
    }

    public float dst(Vector3 vector) {
        float a = vector.f163x - this.f163x;
        float b = vector.f164y - this.f164y;
        float c = vector.f165z - this.f165z;
        return (float) Math.sqrt((double) (((a * a) + (b * b)) + (c * c)));
    }

    public float dst(float x, float y, float z) {
        float a = x - this.f163x;
        float b = y - this.f164y;
        float c = z - this.f165z;
        return (float) Math.sqrt((double) (((a * a) + (b * b)) + (c * c)));
    }

    public static float dst2(float x1, float y1, float z1, float x2, float y2, float z2) {
        float a = x2 - x1;
        float b = y2 - y1;
        float c = z2 - z1;
        return ((a * a) + (b * b)) + (c * c);
    }

    public float dst2(Vector3 point) {
        float a = point.f163x - this.f163x;
        float b = point.f164y - this.f164y;
        float c = point.f165z - this.f165z;
        return ((a * a) + (b * b)) + (c * c);
    }

    public float dst2(float x, float y, float z) {
        float a = x - this.f163x;
        float b = y - this.f164y;
        float c = z - this.f165z;
        return ((a * a) + (b * b)) + (c * c);
    }

    public Vector3 nor() {
        float len2 = len2();
        return (len2 == 0.0f || len2 == 1.0f) ? this : scl(1.0f / ((float) Math.sqrt((double) len2)));
    }

    public static float dot(float x1, float y1, float z1, float x2, float y2, float z2) {
        return ((x1 * x2) + (y1 * y2)) + (z1 * z2);
    }

    public float dot(Vector3 vector) {
        return ((this.f163x * vector.f163x) + (this.f164y * vector.f164y)) + (this.f165z * vector.f165z);
    }

    public float dot(float x, float y, float z) {
        return ((this.f163x * x) + (this.f164y * y)) + (this.f165z * z);
    }

    public Vector3 crs(Vector3 vector) {
        return set((this.f164y * vector.f165z) - (this.f165z * vector.f164y), (this.f165z * vector.f163x) - (this.f163x * vector.f165z), (this.f163x * vector.f164y) - (this.f164y * vector.f163x));
    }

    public Vector3 crs(float x, float y, float z) {
        return set((this.f164y * z) - (this.f165z * y), (this.f165z * x) - (this.f163x * z), (this.f163x * y) - (this.f164y * x));
    }

    public Vector3 mul4x3(float[] matrix) {
        return set((((this.f163x * matrix[0]) + (this.f164y * matrix[3])) + (this.f165z * matrix[6])) + matrix[9], (((this.f163x * matrix[1]) + (this.f164y * matrix[4])) + (this.f165z * matrix[7])) + matrix[10], (((this.f163x * matrix[2]) + (this.f164y * matrix[5])) + (this.f165z * matrix[8])) + matrix[11]);
    }

    public Vector3 mul(Matrix4 matrix) {
        float[] l_mat = matrix.val;
        return set((((this.f163x * l_mat[0]) + (this.f164y * l_mat[4])) + (this.f165z * l_mat[8])) + l_mat[12], (((this.f163x * l_mat[1]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[9])) + l_mat[13], (((this.f163x * l_mat[2]) + (this.f164y * l_mat[6])) + (this.f165z * l_mat[10])) + l_mat[14]);
    }

    public Vector3 traMul(Matrix4 matrix) {
        float[] l_mat = matrix.val;
        return set((((this.f163x * l_mat[0]) + (this.f164y * l_mat[1])) + (this.f165z * l_mat[2])) + l_mat[3], (((this.f163x * l_mat[4]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[6])) + l_mat[7], (((this.f163x * l_mat[8]) + (this.f164y * l_mat[9])) + (this.f165z * l_mat[10])) + l_mat[11]);
    }

    public Vector3 mul(Matrix3 matrix) {
        float[] l_mat = matrix.val;
        return set(((this.f163x * l_mat[0]) + (this.f164y * l_mat[3])) + (this.f165z * l_mat[6]), ((this.f163x * l_mat[1]) + (this.f164y * l_mat[4])) + (this.f165z * l_mat[7]), ((this.f163x * l_mat[2]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[8]));
    }

    public Vector3 traMul(Matrix3 matrix) {
        float[] l_mat = matrix.val;
        return set(((this.f163x * l_mat[0]) + (this.f164y * l_mat[1])) + (this.f165z * l_mat[2]), ((this.f163x * l_mat[3]) + (this.f164y * l_mat[4])) + (this.f165z * l_mat[5]), ((this.f163x * l_mat[6]) + (this.f164y * l_mat[7])) + (this.f165z * l_mat[8]));
    }

    public Vector3 mul(Quaternion quat) {
        return quat.transform(this);
    }

    public Vector3 prj(Matrix4 matrix) {
        float[] l_mat = matrix.val;
        float l_w = 1.0f / ((((this.f163x * l_mat[3]) + (this.f164y * l_mat[7])) + (this.f165z * l_mat[11])) + l_mat[15]);
        return set(((((this.f163x * l_mat[0]) + (this.f164y * l_mat[4])) + (this.f165z * l_mat[8])) + l_mat[12]) * l_w, ((((this.f163x * l_mat[1]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[9])) + l_mat[13]) * l_w, ((((this.f163x * l_mat[2]) + (this.f164y * l_mat[6])) + (this.f165z * l_mat[10])) + l_mat[14]) * l_w);
    }

    public Vector3 rot(Matrix4 matrix) {
        float[] l_mat = matrix.val;
        return set(((this.f163x * l_mat[0]) + (this.f164y * l_mat[4])) + (this.f165z * l_mat[8]), ((this.f163x * l_mat[1]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[9]), ((this.f163x * l_mat[2]) + (this.f164y * l_mat[6])) + (this.f165z * l_mat[10]));
    }

    public Vector3 unrotate(Matrix4 matrix) {
        float[] l_mat = matrix.val;
        return set(((this.f163x * l_mat[0]) + (this.f164y * l_mat[1])) + (this.f165z * l_mat[2]), ((this.f163x * l_mat[4]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[6]), ((this.f163x * l_mat[8]) + (this.f164y * l_mat[9])) + (this.f165z * l_mat[10]));
    }

    public Vector3 untransform(Matrix4 matrix) {
        float[] l_mat = matrix.val;
        this.f163x -= l_mat[12];
        this.f164y -= l_mat[12];
        this.f165z -= l_mat[12];
        return set(((this.f163x * l_mat[0]) + (this.f164y * l_mat[1])) + (this.f165z * l_mat[2]), ((this.f163x * l_mat[4]) + (this.f164y * l_mat[5])) + (this.f165z * l_mat[6]), ((this.f163x * l_mat[8]) + (this.f164y * l_mat[9])) + (this.f165z * l_mat[10]));
    }

    public Vector3 rotate(float degrees, float axisX, float axisY, float axisZ) {
        return mul(tmpMat.setToRotation(axisX, axisY, axisZ, degrees));
    }

    public Vector3 rotateRad(float radians, float axisX, float axisY, float axisZ) {
        return mul(tmpMat.setToRotationRad(axisX, axisY, axisZ, radians));
    }

    public Vector3 rotate(Vector3 axis, float degrees) {
        tmpMat.setToRotation(axis, degrees);
        return mul(tmpMat);
    }

    public Vector3 rotateRad(Vector3 axis, float radians) {
        tmpMat.setToRotationRad(axis, radians);
        return mul(tmpMat);
    }

    public boolean isUnit() {
        return isUnit(1.0E-9f);
    }

    public boolean isUnit(float margin) {
        return Math.abs(len2() - 1.0f) < margin;
    }

    public boolean isZero() {
        return this.f163x == 0.0f && this.f164y == 0.0f && this.f165z == 0.0f;
    }

    public boolean isZero(float margin) {
        return len2() < margin;
    }

    public boolean isOnLine(Vector3 other, float epsilon) {
        return len2((this.f164y * other.f165z) - (this.f165z * other.f164y), (this.f165z * other.f163x) - (this.f163x * other.f165z), (this.f163x * other.f164y) - (this.f164y * other.f163x)) <= epsilon;
    }

    public boolean isOnLine(Vector3 other) {
        return len2((this.f164y * other.f165z) - (this.f165z * other.f164y), (this.f165z * other.f163x) - (this.f163x * other.f165z), (this.f163x * other.f164y) - (this.f164y * other.f163x)) <= 1.0E-6f;
    }

    public boolean isCollinear(Vector3 other, float epsilon) {
        return isOnLine(other, epsilon) && hasSameDirection(other);
    }

    public boolean isCollinear(Vector3 other) {
        return isOnLine(other) && hasSameDirection(other);
    }

    public boolean isCollinearOpposite(Vector3 other, float epsilon) {
        return isOnLine(other, epsilon) && hasOppositeDirection(other);
    }

    public boolean isCollinearOpposite(Vector3 other) {
        return isOnLine(other) && hasOppositeDirection(other);
    }

    public boolean isPerpendicular(Vector3 vector) {
        return MathUtils.isZero(dot(vector));
    }

    public boolean isPerpendicular(Vector3 vector, float epsilon) {
        return MathUtils.isZero(dot(vector), epsilon);
    }

    public boolean hasSameDirection(Vector3 vector) {
        return dot(vector) > 0.0f;
    }

    public boolean hasOppositeDirection(Vector3 vector) {
        return dot(vector) < 0.0f;
    }

    public Vector3 lerp(Vector3 target, float alpha) {
        scl(1.0f - alpha);
        add(target.f163x * alpha, target.f164y * alpha, target.f165z * alpha);
        return this;
    }

    public Vector3 interpolate(Vector3 target, float alpha, Interpolation interpolator) {
        return lerp(target, interpolator.apply(0.0f, 1.0f, alpha));
    }

    public Vector3 slerp(Vector3 target, float alpha) {
        float dot = dot(target);
        if (((double) dot) > 0.9995d || ((double) dot) < -0.9995d) {
            return lerp(target, alpha);
        }
        float theta = ((float) Math.acos((double) dot)) * alpha;
        float tx = target.f163x - (this.f163x * dot);
        float ty = target.f164y - (this.f164y * dot);
        float tz = target.f165z - (this.f165z * dot);
        float l2 = ((tx * tx) + (ty * ty)) + (tz * tz);
        float dl = ((float) Math.sin((double) theta)) * (l2 < 1.0E-4f ? 1.0f : 1.0f / ((float) Math.sqrt((double) l2)));
        return scl((float) Math.cos((double) theta)).add(tx * dl, ty * dl, tz * dl).nor();
    }

    public String toString() {
        return "[" + this.f163x + ", " + this.f164y + ", " + this.f165z + "]";
    }

    public Vector3 limit(float limit) {
        return limit2(limit * limit);
    }

    public Vector3 limit2(float limit2) {
        float len2 = len2();
        if (len2 > limit2) {
            scl(limit2 / len2);
        }
        return this;
    }

    public Vector3 setLength(float len) {
        return setLength2(len * len);
    }

    public Vector3 setLength2(float len2) {
        float oldLen2 = len2();
        return (oldLen2 == 0.0f || oldLen2 == len2) ? this : scl((float) Math.sqrt((double) (len2 / oldLen2)));
    }

    public Vector3 clamp(float min, float max) {
        float len2 = len2();
        if (len2 == 0.0f) {
            return this;
        }
        float max2 = max * max;
        if (len2 > max2) {
            return scl((float) Math.sqrt((double) (max2 / len2)));
        }
        float min2 = min * min;
        if (len2 < min2) {
            return scl((float) Math.sqrt((double) (min2 / len2)));
        }
        return this;
    }

    public int hashCode() {
        return ((((NumberUtils.floatToIntBits(this.f163x) + 31) * 31) + NumberUtils.floatToIntBits(this.f164y)) * 31) + NumberUtils.floatToIntBits(this.f165z);
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
        Vector3 other = (Vector3) obj;
        if (NumberUtils.floatToIntBits(this.f163x) != NumberUtils.floatToIntBits(other.f163x)) {
            return false;
        }
        if (NumberUtils.floatToIntBits(this.f164y) != NumberUtils.floatToIntBits(other.f164y)) {
            return false;
        }
        if (NumberUtils.floatToIntBits(this.f165z) != NumberUtils.floatToIntBits(other.f165z)) {
            return false;
        }
        return true;
    }

    public boolean epsilonEquals(Vector3 other, float epsilon) {
        if (other != null && Math.abs(other.f163x - this.f163x) <= epsilon && Math.abs(other.f164y - this.f164y) <= epsilon && Math.abs(other.f165z - this.f165z) <= epsilon) {
            return true;
        }
        return false;
    }

    public boolean epsilonEquals(float x, float y, float z, float epsilon) {
        if (Math.abs(x - this.f163x) <= epsilon && Math.abs(y - this.f164y) <= epsilon && Math.abs(z - this.f165z) <= epsilon) {
            return true;
        }
        return false;
    }

    public Vector3 setZero() {
        this.f163x = 0.0f;
        this.f164y = 0.0f;
        this.f165z = 0.0f;
        return this;
    }
}
