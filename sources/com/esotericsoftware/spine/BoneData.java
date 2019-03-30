package com.esotericsoftware.spine;

import com.badlogic.gdx.graphics.Color;

public class BoneData {
    final Color color = new Color(0.61f, 0.61f, 0.61f, 1.0f);
    boolean inheritRotation = true;
    boolean inheritScale = true;
    float length;
    final String name;
    final BoneData parent;
    float rotation;
    float scaleX = 1.0f;
    float scaleY = 1.0f;
    /* renamed from: x */
    float f86x;
    /* renamed from: y */
    float f87y;

    public BoneData(String name, BoneData parent) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        this.name = name;
        this.parent = parent;
    }

    public BoneData(BoneData bone, BoneData parent) {
        if (bone == null) {
            throw new IllegalArgumentException("bone cannot be null.");
        }
        this.parent = parent;
        this.name = bone.name;
        this.length = bone.length;
        this.f86x = bone.f86x;
        this.f87y = bone.f87y;
        this.rotation = bone.rotation;
        this.scaleX = bone.scaleX;
        this.scaleY = bone.scaleY;
    }

    public BoneData getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getX() {
        return this.f86x;
    }

    public void setX(float x) {
        this.f86x = x;
    }

    public float getY() {
        return this.f87y;
    }

    public void setY(float y) {
        this.f87y = y;
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

    public boolean getInheritScale() {
        return this.inheritScale;
    }

    public void setInheritScale(boolean inheritScale) {
        this.inheritScale = inheritScale;
    }

    public boolean getInheritRotation() {
        return this.inheritRotation;
    }

    public void setInheritRotation(boolean inheritRotation) {
        this.inheritRotation = inheritRotation;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return this.name;
    }
}
