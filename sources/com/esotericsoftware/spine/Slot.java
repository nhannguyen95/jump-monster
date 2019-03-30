package com.esotericsoftware.spine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.FloatArray;
import com.esotericsoftware.spine.attachments.Attachment;

public class Slot {
    Attachment attachment;
    private float attachmentTime;
    private FloatArray attachmentVertices;
    final Bone bone;
    final Color color;
    final SlotData data;
    private final Skeleton skeleton;

    Slot() {
        this.attachmentVertices = new FloatArray();
        this.data = null;
        this.bone = null;
        this.skeleton = null;
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public Slot(SlotData data, Skeleton skeleton, Bone bone) {
        this.attachmentVertices = new FloatArray();
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null.");
        } else if (skeleton == null) {
            throw new IllegalArgumentException("skeleton cannot be null.");
        } else if (bone == null) {
            throw new IllegalArgumentException("bone cannot be null.");
        } else {
            this.data = data;
            this.skeleton = skeleton;
            this.bone = bone;
            this.color = new Color();
            setToSetupPose();
        }
    }

    public Slot(Slot slot, Skeleton skeleton, Bone bone) {
        this.attachmentVertices = new FloatArray();
        if (slot == null) {
            throw new IllegalArgumentException("slot cannot be null.");
        } else if (skeleton == null) {
            throw new IllegalArgumentException("skeleton cannot be null.");
        } else if (bone == null) {
            throw new IllegalArgumentException("bone cannot be null.");
        } else {
            this.data = slot.data;
            this.skeleton = skeleton;
            this.bone = bone;
            this.color = new Color(slot.color);
            this.attachment = slot.attachment;
            this.attachmentTime = slot.attachmentTime;
        }
    }

    public SlotData getData() {
        return this.data;
    }

    public Skeleton getSkeleton() {
        return this.skeleton;
    }

    public Bone getBone() {
        return this.bone;
    }

    public Color getColor() {
        return this.color;
    }

    public Attachment getAttachment() {
        return this.attachment;
    }

    public void setAttachment(Attachment attachment) {
        if (this.attachment != attachment) {
            this.attachment = attachment;
            this.attachmentTime = this.skeleton.time;
            this.attachmentVertices.clear();
        }
    }

    public void setAttachmentTime(float time) {
        this.attachmentTime = this.skeleton.time - time;
    }

    public float getAttachmentTime() {
        return this.skeleton.time - this.attachmentTime;
    }

    public void setAttachmentVertices(FloatArray attachmentVertices) {
        this.attachmentVertices = attachmentVertices;
    }

    public FloatArray getAttachmentVertices() {
        return this.attachmentVertices;
    }

    void setToSetupPose(int slotIndex) {
        this.color.set(this.data.color);
        setAttachment(this.data.attachmentName == null ? null : this.skeleton.getAttachment(slotIndex, this.data.attachmentName));
        this.attachmentVertices.clear();
    }

    public void setToSetupPose() {
        setToSetupPose(this.skeleton.data.slots.indexOf(this.data, true));
    }

    public String toString() {
        return this.data.name;
    }
}
