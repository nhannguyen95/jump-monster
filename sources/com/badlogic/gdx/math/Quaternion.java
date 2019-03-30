package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Quaternion implements Serializable {
    private static final long serialVersionUID = -7661875440774897168L;
    private static Quaternion tmp1 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    private static Quaternion tmp2 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    /* renamed from: w */
    public float f67w;
    /* renamed from: x */
    public float f68x;
    /* renamed from: y */
    public float f69y;
    /* renamed from: z */
    public float f70z;

    public Quaternion(float x, float y, float z, float w) {
        set(x, y, z, w);
    }

    public Quaternion() {
        idt();
    }

    public Quaternion(Quaternion quaternion) {
        set(quaternion);
    }

    public Quaternion(Vector3 axis, float angle) {
        set(axis, angle);
    }

    public Quaternion set(float x, float y, float z, float w) {
        this.f68x = x;
        this.f69y = y;
        this.f70z = z;
        this.f67w = w;
        return this;
    }

    public Quaternion set(Quaternion quaternion) {
        return set(quaternion.f68x, quaternion.f69y, quaternion.f70z, quaternion.f67w);
    }

    public Quaternion set(Vector3 axis, float angle) {
        return setFromAxis(axis.f163x, axis.f164y, axis.f165z, angle);
    }

    public Quaternion cpy() {
        return new Quaternion(this);
    }

    public static final float len(float x, float y, float z, float w) {
        return (float) Math.sqrt((double) ((((x * x) + (y * y)) + (z * z)) + (w * w)));
    }

    public float len() {
        return (float) Math.sqrt((double) ((((this.f68x * this.f68x) + (this.f69y * this.f69y)) + (this.f70z * this.f70z)) + (this.f67w * this.f67w)));
    }

    public String toString() {
        return "[" + this.f68x + "|" + this.f69y + "|" + this.f70z + "|" + this.f67w + "]";
    }

    public Quaternion setEulerAngles(float yaw, float pitch, float roll) {
        return setEulerAnglesRad(yaw * 0.017453292f, pitch * 0.017453292f, 0.017453292f * roll);
    }

    public Quaternion setEulerAnglesRad(float yaw, float pitch, float roll) {
        float hr = roll * 0.5f;
        float shr = (float) Math.sin((double) hr);
        float chr = (float) Math.cos((double) hr);
        float hp = pitch * 0.5f;
        float shp = (float) Math.sin((double) hp);
        float chp = (float) Math.cos((double) hp);
        float hy = yaw * 0.5f;
        float shy = (float) Math.sin((double) hy);
        float chy = (float) Math.cos((double) hy);
        float chy_shp = chy * shp;
        float shy_chp = shy * chp;
        float chy_chp = chy * chp;
        float shy_shp = shy * shp;
        this.f68x = (chy_shp * chr) + (shy_chp * shr);
        this.f69y = (shy_chp * chr) - (chy_shp * shr);
        this.f70z = (chy_chp * shr) - (shy_shp * chr);
        this.f67w = (chy_chp * chr) + (shy_shp * shr);
        return this;
    }

    public int getGimbalPole() {
        float t = (this.f69y * this.f68x) + (this.f70z * this.f67w);
        if (t > 0.499f) {
            return 1;
        }
        return t < -0.499f ? -1 : 0;
    }

    public float getRollRad() {
        int pole = getGimbalPole();
        return pole == 0 ? MathUtils.atan2(((this.f67w * this.f70z) + (this.f69y * this.f68x)) * 2.0f, 1.0f - (((this.f68x * this.f68x) + (this.f70z * this.f70z)) * 2.0f)) : (((float) pole) * 2.0f) * MathUtils.atan2(this.f69y, this.f67w);
    }

    public float getRoll() {
        return getRollRad() * 57.295776f;
    }

    public float getPitchRad() {
        int pole = getGimbalPole();
        return pole == 0 ? (float) Math.asin((double) MathUtils.clamp(2.0f * ((this.f67w * this.f68x) - (this.f70z * this.f69y)), -1.0f, 1.0f)) : (((float) pole) * 3.1415927f) * 0.5f;
    }

    public float getPitch() {
        return getPitchRad() * 57.295776f;
    }

    public float getYawRad() {
        return getGimbalPole() == 0 ? MathUtils.atan2(((this.f69y * this.f67w) + (this.f68x * this.f70z)) * 2.0f, 1.0f - (((this.f69y * this.f69y) + (this.f68x * this.f68x)) * 2.0f)) : 0.0f;
    }

    public float getYaw() {
        return getYawRad() * 57.295776f;
    }

    public static final float len2(float x, float y, float z, float w) {
        return (((x * x) + (y * y)) + (z * z)) + (w * w);
    }

    public float len2() {
        return (((this.f68x * this.f68x) + (this.f69y * this.f69y)) + (this.f70z * this.f70z)) + (this.f67w * this.f67w);
    }

    public Quaternion nor() {
        float len = len2();
        if (!(len == 0.0f || MathUtils.isEqual(len, 1.0f))) {
            len = (float) Math.sqrt((double) len);
            this.f67w /= len;
            this.f68x /= len;
            this.f69y /= len;
            this.f70z /= len;
        }
        return this;
    }

    public Quaternion conjugate() {
        this.f68x = -this.f68x;
        this.f69y = -this.f69y;
        this.f70z = -this.f70z;
        return this;
    }

    public Vector3 transform(Vector3 v) {
        tmp2.set(this);
        tmp2.conjugate();
        tmp2.mulLeft(tmp1.set(v.f163x, v.f164y, v.f165z, 0.0f)).mulLeft(this);
        v.f163x = tmp2.f68x;
        v.f164y = tmp2.f69y;
        v.f165z = tmp2.f70z;
        return v;
    }

    public Quaternion mul(Quaternion other) {
        float newY = (((this.f67w * other.f69y) + (this.f69y * other.f67w)) + (this.f70z * other.f68x)) - (this.f68x * other.f70z);
        float newZ = (((this.f67w * other.f70z) + (this.f70z * other.f67w)) + (this.f68x * other.f69y)) - (this.f69y * other.f68x);
        float newW = (((this.f67w * other.f67w) - (this.f68x * other.f68x)) - (this.f69y * other.f69y)) - (this.f70z * other.f70z);
        this.f68x = (((this.f67w * other.f68x) + (this.f68x * other.f67w)) + (this.f69y * other.f70z)) - (this.f70z * other.f69y);
        this.f69y = newY;
        this.f70z = newZ;
        this.f67w = newW;
        return this;
    }

    public Quaternion mul(float x, float y, float z, float w) {
        float newY = (((this.f67w * y) + (this.f69y * w)) + (this.f70z * x)) - (this.f68x * z);
        float newZ = (((this.f67w * z) + (this.f70z * w)) + (this.f68x * y)) - (this.f69y * x);
        float newW = (((this.f67w * w) - (this.f68x * x)) - (this.f69y * y)) - (this.f70z * z);
        this.f68x = (((this.f67w * x) + (this.f68x * w)) + (this.f69y * z)) - (this.f70z * y);
        this.f69y = newY;
        this.f70z = newZ;
        this.f67w = newW;
        return this;
    }

    public Quaternion mulLeft(Quaternion other) {
        float newY = (((other.f67w * this.f69y) + (other.f69y * this.f67w)) + (other.f70z * this.f68x)) - (other.f68x * this.f70z);
        float newZ = (((other.f67w * this.f70z) + (other.f70z * this.f67w)) + (other.f68x * this.f69y)) - (other.f69y * this.f68x);
        float newW = (((other.f67w * this.f67w) - (other.f68x * this.f68x)) - (other.f69y * this.f69y)) - (other.f70z * this.f70z);
        this.f68x = (((other.f67w * this.f68x) + (other.f68x * this.f67w)) + (other.f69y * this.f70z)) - (other.f70z * this.f69y);
        this.f69y = newY;
        this.f70z = newZ;
        this.f67w = newW;
        return this;
    }

    public Quaternion mulLeft(float x, float y, float z, float w) {
        float newY = (((this.f69y * w) + (this.f67w * y)) + (this.f68x * z)) - (x * z);
        float newZ = (((this.f70z * w) + (this.f67w * z)) + (this.f69y * x)) - (y * x);
        float newW = (((this.f67w * w) - (this.f68x * x)) - (this.f69y * y)) - (z * z);
        this.f68x = (((this.f68x * w) + (this.f67w * x)) + (this.f70z * y)) - (z * y);
        this.f69y = newY;
        this.f70z = newZ;
        this.f67w = newW;
        return this;
    }

    public Quaternion add(Quaternion quaternion) {
        this.f68x += quaternion.f68x;
        this.f69y += quaternion.f69y;
        this.f70z += quaternion.f70z;
        this.f67w += quaternion.f67w;
        return this;
    }

    public Quaternion add(float qx, float qy, float qz, float qw) {
        this.f68x += qx;
        this.f69y += qy;
        this.f70z += qz;
        this.f67w += qw;
        return this;
    }

    public void toMatrix(float[] matrix) {
        float xx = this.f68x * this.f68x;
        float xy = this.f68x * this.f69y;
        float xz = this.f68x * this.f70z;
        float xw = this.f68x * this.f67w;
        float yy = this.f69y * this.f69y;
        float yz = this.f69y * this.f70z;
        float yw = this.f69y * this.f67w;
        float zz = this.f70z * this.f70z;
        float zw = this.f70z * this.f67w;
        matrix[0] = 1.0f - ((yy + zz) * 2.0f);
        matrix[4] = (xy - zw) * 2.0f;
        matrix[8] = (xz + yw) * 2.0f;
        matrix[12] = 0.0f;
        matrix[1] = (xy + zw) * 2.0f;
        matrix[5] = 1.0f - ((xx + zz) * 2.0f);
        matrix[9] = (yz - xw) * 2.0f;
        matrix[13] = 0.0f;
        matrix[2] = (xz - yw) * 2.0f;
        matrix[6] = (yz + xw) * 2.0f;
        matrix[10] = 1.0f - ((xx + yy) * 2.0f);
        matrix[14] = 0.0f;
        matrix[3] = 0.0f;
        matrix[7] = 0.0f;
        matrix[11] = 0.0f;
        matrix[15] = 1.0f;
    }

    public Quaternion idt() {
        return set(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public boolean isIdentity() {
        return MathUtils.isZero(this.f68x) && MathUtils.isZero(this.f69y) && MathUtils.isZero(this.f70z) && MathUtils.isEqual(this.f67w, 1.0f);
    }

    public boolean isIdentity(float tolerance) {
        return MathUtils.isZero(this.f68x, tolerance) && MathUtils.isZero(this.f69y, tolerance) && MathUtils.isZero(this.f70z, tolerance) && MathUtils.isEqual(this.f67w, 1.0f, tolerance);
    }

    public Quaternion setFromAxis(Vector3 axis, float degrees) {
        return setFromAxis(axis.f163x, axis.f164y, axis.f165z, degrees);
    }

    public Quaternion setFromAxisRad(Vector3 axis, float radians) {
        return setFromAxisRad(axis.f163x, axis.f164y, axis.f165z, radians);
    }

    public Quaternion setFromAxis(float x, float y, float z, float degrees) {
        return setFromAxisRad(x, y, z, 0.017453292f * degrees);
    }

    public Quaternion setFromAxisRad(float x, float y, float z, float radians) {
        float d = Vector3.len(x, y, z);
        if (d == 0.0f) {
            return idt();
        }
        d = 1.0f / d;
        float l_ang = radians < 0.0f ? 6.2831855f - ((-radians) % 6.2831855f) : radians % 6.2831855f;
        float l_sin = (float) Math.sin((double) (l_ang / 2.0f));
        return set((d * x) * l_sin, (d * y) * l_sin, (d * z) * l_sin, (float) Math.cos((double) (l_ang / 2.0f))).nor();
    }

    public Quaternion setFromMatrix(boolean normalizeAxes, Matrix4 matrix) {
        return setFromAxes(normalizeAxes, matrix.val[0], matrix.val[4], matrix.val[8], matrix.val[1], matrix.val[5], matrix.val[9], matrix.val[2], matrix.val[6], matrix.val[10]);
    }

    public Quaternion setFromMatrix(Matrix4 matrix) {
        return setFromMatrix(false, matrix);
    }

    public Quaternion setFromMatrix(boolean normalizeAxes, Matrix3 matrix) {
        return setFromAxes(normalizeAxes, matrix.val[0], matrix.val[3], matrix.val[6], matrix.val[1], matrix.val[4], matrix.val[7], matrix.val[2], matrix.val[5], matrix.val[8]);
    }

    public Quaternion setFromMatrix(Matrix3 matrix) {
        return setFromMatrix(false, matrix);
    }

    public Quaternion setFromAxes(float xx, float xy, float xz, float yx, float yy, float yz, float zx, float zy, float zz) {
        return setFromAxes(false, xx, xy, xz, yx, yy, yz, zx, zy, zz);
    }

    public Quaternion setFromAxes(boolean normalizeAxes, float xx, float xy, float xz, float yx, float yy, float yz, float zx, float zy, float zz) {
        if (normalizeAxes) {
            float lx = 1.0f / Vector3.len(xx, xy, xz);
            float ly = 1.0f / Vector3.len(yx, yy, yz);
            float lz = 1.0f / Vector3.len(zx, zy, zz);
            xx *= lx;
            xy *= lx;
            xz *= lx;
            yy *= ly;
            yz = (yz * ly) * ly;
            zx *= lz;
            zy *= lz;
            zz *= lz;
        }
        float t = (xx + yy) + zz;
        float s;
        if (t >= 0.0f) {
            s = (float) Math.sqrt((double) (1.0f + t));
            this.f67w = 0.5f * s;
            s = 0.5f / s;
            this.f68x = (zy - yz) * s;
            this.f69y = (xz - zx) * s;
            this.f70z = (yx - xy) * s;
        } else if (xx > yy && xx > zz) {
            s = (float) Math.sqrt(((1.0d + ((double) xx)) - ((double) yy)) - ((double) zz));
            this.f68x = 0.5f * s;
            s = 0.5f / s;
            this.f69y = (yx + xy) * s;
            this.f70z = (xz + zx) * s;
            this.f67w = (zy - yz) * s;
        } else if (yy > zz) {
            s = (float) Math.sqrt(((1.0d + ((double) yy)) - ((double) xx)) - ((double) zz));
            this.f69y = 0.5f * s;
            s = 0.5f / s;
            this.f68x = (yx + xy) * s;
            this.f70z = (zy + yz) * s;
            this.f67w = (xz - zx) * s;
        } else {
            s = (float) Math.sqrt(((1.0d + ((double) zz)) - ((double) xx)) - ((double) yy));
            this.f70z = 0.5f * s;
            s = 0.5f / s;
            this.f68x = (xz + zx) * s;
            this.f69y = (zy + yz) * s;
            this.f67w = (yx - xy) * s;
        }
        return this;
    }

    public Quaternion setFromCross(Vector3 v1, Vector3 v2) {
        return setFromAxisRad((v1.f164y * v2.f165z) - (v1.f165z * v2.f164y), (v1.f165z * v2.f163x) - (v1.f163x * v2.f165z), (v1.f163x * v2.f164y) - (v1.f164y * v2.f163x), (float) Math.acos((double) MathUtils.clamp(v1.dot(v2), -1.0f, 1.0f)));
    }

    public Quaternion setFromCross(float x1, float y1, float z1, float x2, float y2, float z2) {
        return setFromAxisRad((y1 * z2) - (z1 * y2), (z1 * x2) - (x1 * z2), (x1 * y2) - (y1 * x2), (float) Math.acos((double) MathUtils.clamp(Vector3.dot(x1, y1, z1, x2, y2, z2), -1.0f, 1.0f)));
    }

    public Quaternion slerp(Quaternion end, float alpha) {
        float absDot;
        float dot = dot(end);
        if (dot < 0.0f) {
            absDot = -dot;
        } else {
            absDot = dot;
        }
        float scale0 = 1.0f - alpha;
        float scale1 = alpha;
        if (((double) (1.0f - absDot)) > 0.1d) {
            double angle = Math.acos((double) absDot);
            double invSinTheta = 1.0d / Math.sin(angle);
            scale0 = (float) (Math.sin(((double) (1.0f - alpha)) * angle) * invSinTheta);
            scale1 = (float) (Math.sin(((double) alpha) * angle) * invSinTheta);
        }
        if (dot < 0.0f) {
            scale1 = -scale1;
        }
        this.f68x = (this.f68x * scale0) + (end.f68x * scale1);
        this.f69y = (this.f69y * scale0) + (end.f69y * scale1);
        this.f70z = (this.f70z * scale0) + (end.f70z * scale1);
        this.f67w = (this.f67w * scale0) + (end.f67w * scale1);
        return this;
    }

    public Quaternion slerp(Quaternion[] q) {
        float w = 1.0f / ((float) q.length);
        set(q[0]).exp(w);
        for (int i = 1; i < q.length; i++) {
            mul(tmp1.set(q[i]).exp(w));
        }
        nor();
        return this;
    }

    public Quaternion slerp(Quaternion[] q, float[] w) {
        set(q[0]).exp(w[0]);
        for (int i = 1; i < q.length; i++) {
            mul(tmp1.set(q[i]).exp(w[i]));
        }
        nor();
        return this;
    }

    public Quaternion exp(float alpha) {
        float coeff;
        float norm = len();
        float normExp = (float) Math.pow((double) norm, (double) alpha);
        float theta = (float) Math.acos((double) (this.f67w / norm));
        if (((double) Math.abs(theta)) < 0.001d) {
            coeff = (normExp * alpha) / norm;
        } else {
            coeff = (float) ((((double) normExp) * Math.sin((double) (alpha * theta))) / (((double) norm) * Math.sin((double) theta)));
        }
        this.f67w = (float) (((double) normExp) * Math.cos((double) (alpha * theta)));
        this.f68x *= coeff;
        this.f69y *= coeff;
        this.f70z *= coeff;
        nor();
        return this;
    }

    public int hashCode() {
        return ((((((NumberUtils.floatToRawIntBits(this.f67w) + 31) * 31) + NumberUtils.floatToRawIntBits(this.f68x)) * 31) + NumberUtils.floatToRawIntBits(this.f69y)) * 31) + NumberUtils.floatToRawIntBits(this.f70z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Quaternion)) {
            return false;
        }
        Quaternion other = (Quaternion) obj;
        if (NumberUtils.floatToRawIntBits(this.f67w) == NumberUtils.floatToRawIntBits(other.f67w) && NumberUtils.floatToRawIntBits(this.f68x) == NumberUtils.floatToRawIntBits(other.f68x) && NumberUtils.floatToRawIntBits(this.f69y) == NumberUtils.floatToRawIntBits(other.f69y) && NumberUtils.floatToRawIntBits(this.f70z) == NumberUtils.floatToRawIntBits(other.f70z)) {
            return true;
        }
        return false;
    }

    public static final float dot(float x1, float y1, float z1, float w1, float x2, float y2, float z2, float w2) {
        return (((x1 * x2) + (y1 * y2)) + (z1 * z2)) + (w1 * w2);
    }

    public float dot(Quaternion other) {
        return (((this.f68x * other.f68x) + (this.f69y * other.f69y)) + (this.f70z * other.f70z)) + (this.f67w * other.f67w);
    }

    public float dot(float x, float y, float z, float w) {
        return (((this.f68x * x) + (this.f69y * y)) + (this.f70z * z)) + (this.f67w * w);
    }

    public Quaternion mul(float scalar) {
        this.f68x *= scalar;
        this.f69y *= scalar;
        this.f70z *= scalar;
        this.f67w *= scalar;
        return this;
    }

    public float getAxisAngle(Vector3 axis) {
        return getAxisAngleRad(axis) * 57.295776f;
    }

    public float getAxisAngleRad(Vector3 axis) {
        if (this.f67w > 1.0f) {
            nor();
        }
        float angle = (float) (2.0d * Math.acos((double) this.f67w));
        double s = Math.sqrt((double) (1.0f - (this.f67w * this.f67w)));
        if (s < 9.999999974752427E-7d) {
            axis.f163x = this.f68x;
            axis.f164y = this.f69y;
            axis.f165z = this.f70z;
        } else {
            axis.f163x = (float) (((double) this.f68x) / s);
            axis.f164y = (float) (((double) this.f69y) / s);
            axis.f165z = (float) (((double) this.f70z) / s);
        }
        return angle;
    }

    public float getAngleRad() {
        return (float) (Math.acos(this.f67w > 1.0f ? (double) (this.f67w / len()) : (double) this.f67w) * 2.0d);
    }

    public float getAngle() {
        return getAngleRad() * 57.295776f;
    }

    public void getSwingTwist(float axisX, float axisY, float axisZ, Quaternion swing, Quaternion twist) {
        float d = Vector3.dot(this.f68x, this.f69y, this.f70z, axisX, axisY, axisZ);
        twist.set(axisX * d, axisY * d, axisZ * d, this.f67w).nor();
        swing.set(twist).conjugate().mulLeft(this);
    }

    public void getSwingTwist(Vector3 axis, Quaternion swing, Quaternion twist) {
        getSwingTwist(axis.f163x, axis.f164y, axis.f165z, swing, twist);
    }

    public float getAngleAroundRad(float axisX, float axisY, float axisZ) {
        float d = Vector3.dot(this.f68x, this.f69y, this.f70z, axisX, axisY, axisZ);
        float l2 = len2(axisX * d, axisY * d, axisZ * d, this.f67w);
        return MathUtils.isZero(l2) ? 0.0f : (float) (2.0d * Math.acos((double) MathUtils.clamp((float) (((double) this.f67w) / Math.sqrt((double) l2)), -1.0f, 1.0f)));
    }

    public float getAngleAroundRad(Vector3 axis) {
        return getAngleAroundRad(axis.f163x, axis.f164y, axis.f165z);
    }

    public float getAngleAround(float axisX, float axisY, float axisZ) {
        return getAngleAroundRad(axisX, axisY, axisZ) * 57.295776f;
    }

    public float getAngleAround(Vector3 axis) {
        return getAngleAround(axis.f163x, axis.f164y, axis.f165z);
    }
}
