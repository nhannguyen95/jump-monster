package com.esotericsoftware.spine;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;

public class Bone {
    final BoneData data;
    float m00;
    float m01;
    float m10;
    float m11;
    final Bone parent;
    float rotation;
    float scaleX;
    float scaleY;
    float worldRotation;
    float worldScaleX;
    float worldScaleY;
    float worldX;
    float worldY;
    /* renamed from: x */
    float f84x;
    /* renamed from: y */
    float f85y;

    public Bone(BoneData data, Bone parent) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null.");
        }
        this.data = data;
        this.parent = parent;
        setToSetupPose();
    }

    public Bone(Bone bone, Bone parent) {
        if (bone == null) {
            throw new IllegalArgumentException("bone cannot be null.");
        }
        this.parent = parent;
        this.data = bone.data;
        this.f84x = bone.f84x;
        this.f85y = bone.f85y;
        this.rotation = bone.rotation;
        this.scaleX = bone.scaleX;
        this.scaleY = bone.scaleY;
    }

    public void updateWorldTransform(boolean flipX, boolean flipY) {
        Bone parent = this.parent;
        if (parent != null) {
            this.worldX = ((this.f84x * parent.m00) + (this.f85y * parent.m01)) + parent.worldX;
            this.worldY = ((this.f84x * parent.m10) + (this.f85y * parent.m11)) + parent.worldY;
            if (this.data.inheritScale) {
                this.worldScaleX = parent.worldScaleX * this.scaleX;
                this.worldScaleY = parent.worldScaleY * this.scaleY;
            } else {
                this.worldScaleX = this.scaleX;
                this.worldScaleY = this.scaleY;
            }
            this.worldRotation = this.data.inheritRotation ? parent.worldRotation + this.rotation : this.rotation;
        } else {
            this.worldX = flipX ? -this.f84x : this.f84x;
            this.worldY = flipY ? -this.f85y : this.f85y;
            this.worldScaleX = this.scaleX;
            this.worldScaleY = this.scaleY;
            this.worldRotation = this.rotation;
        }
        float cos = MathUtils.cosDeg(this.worldRotation);
        float sin = MathUtils.sinDeg(this.worldRotation);
        this.m00 = this.worldScaleX * cos;
        this.m10 = this.worldScaleX * sin;
        this.m01 = (-sin) * this.worldScaleY;
        this.m11 = this.worldScaleY * cos;
        if (flipX) {
            this.m00 = -this.m00;
            this.m01 = -this.m01;
        }
        if (flipY) {
            this.m10 = -this.m10;
            this.m11 = -this.m11;
        }
    }

    public void setToSetupPose() {
        BoneData data = this.data;
        this.f84x = data.f86x;
        this.f85y = data.f87y;
        this.rotation = data.rotation;
        this.scaleX = data.scaleX;
        this.scaleY = data.scaleY;
    }

    public BoneData getData() {
        return this.data;
    }

    public Bone getParent() {
        return this.parent;
    }

    public float getX() {
        return this.f84x;
    }

    public void setX(float x) {
        this.f84x = x;
    }

    public float getY() {
        return this.f85y;
    }

    public void setY(float y) {
        this.f85y = y;
    }

    public void setPosition(float x, float y) {
        this.f84x = x;
        this.f85y = y;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public void setScale(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public void setScale(float scale) {
        this.scaleX = scale;
        this.scaleY = scale;
    }

    public float getM00() {
        return this.m00;
    }

    public float getM01() {
        return this.m01;
    }

    public float getM10() {
        return this.m10;
    }

    public float getM11() {
        return this.m11;
    }

    public float getWorldX() {
        return this.worldX;
    }

    public float getWorldY() {
        return this.worldY;
    }

    public float getWorldRotation() {
        return this.worldRotation;
    }

    public float getWorldScaleX() {
        return this.worldScaleX;
    }

    public float getWorldScaleY() {
        return this.worldScaleY;
    }

    public Matrix3 getWorldTransform(Matrix3 worldTransform) {
        if (worldTransform == null) {
            throw new IllegalArgumentException("worldTransform cannot be null.");
        }
        float[] val = worldTransform.val;
        val[0] = this.m00;
        val[3] = this.m01;
        val[1] = this.m10;
        val[4] = this.m11;
        val[6] = this.worldX;
        val[7] = this.worldY;
        val[2] = 0.0f;
        val[5] = 0.0f;
        val[8] = 1.0f;
        return worldTransform;
    }

    public String toString() {
        return this.data.name;
    }
}
