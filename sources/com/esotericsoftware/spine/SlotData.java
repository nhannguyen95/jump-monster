package com.esotericsoftware.spine;

import com.badlogic.gdx.graphics.Color;

public class SlotData {
    boolean additiveBlending;
    String attachmentName;
    final BoneData boneData;
    final Color color;
    final String name;

    SlotData() {
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.name = null;
        this.boneData = null;
    }

    public SlotData(String name, BoneData boneData) {
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        } else if (boneData == null) {
            throw new IllegalArgumentException("boneData cannot be null.");
        } else {
            this.name = name;
            this.boneData = boneData;
        }
    }

    public String getName() {
        return this.name;
    }

    public BoneData getBoneData() {
        return this.boneData;
    }

    public Color getColor() {
        return this.color;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentName() {
        return this.attachmentName;
    }

    public boolean getAdditiveBlending() {
        return this.additiveBlending;
    }

    public void setAdditiveBlending(boolean additiveBlending) {
        this.additiveBlending = additiveBlending;
    }

    public String toString() {
        return this.name;
    }
}
