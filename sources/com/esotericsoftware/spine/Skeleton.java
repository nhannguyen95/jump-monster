package com.esotericsoftware.spine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.attachments.Attachment;
import java.util.Iterator;

public class Skeleton {
    final Array<Bone> bones;
    final Color color;
    final SkeletonData data;
    Array<Slot> drawOrder;
    boolean flipX;
    boolean flipY;
    Skin skin;
    final Array<Slot> slots;
    float time;
    /* renamed from: x */
    float f88x;
    /* renamed from: y */
    float f89y;

    public Skeleton(SkeletonData data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null.");
        }
        this.data = data;
        this.bones = new Array(data.bones.size);
        Iterator it = data.bones.iterator();
        while (it.hasNext()) {
            BoneData boneData = (BoneData) it.next();
            this.bones.add(new Bone(boneData, boneData.parent == null ? null : (Bone) this.bones.get(data.bones.indexOf(boneData.parent, true))));
        }
        this.slots = new Array(data.slots.size);
        this.drawOrder = new Array(data.slots.size);
        Iterator it2 = data.slots.iterator();
        while (it2.hasNext()) {
            SlotData slotData = (SlotData) it2.next();
            Slot slot = new Slot(slotData, this, (Bone) this.bones.get(data.bones.indexOf(slotData.boneData, true)));
            this.slots.add(slot);
            this.drawOrder.add(slot);
        }
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public Skeleton(Skeleton skeleton) {
        if (skeleton == null) {
            throw new IllegalArgumentException("skeleton cannot be null.");
        }
        this.data = skeleton.data;
        this.bones = new Array(skeleton.bones.size);
        Iterator it = skeleton.bones.iterator();
        while (it.hasNext()) {
            Bone bone = (Bone) it.next();
            this.bones.add(new Bone(bone, bone.parent == null ? null : (Bone) this.bones.get(skeleton.bones.indexOf(bone.parent, true))));
        }
        this.slots = new Array(skeleton.slots.size);
        Iterator it2 = skeleton.slots.iterator();
        while (it2.hasNext()) {
            Slot slot = (Slot) it2.next();
            this.slots.add(new Slot(slot, this, (Bone) this.bones.get(skeleton.bones.indexOf(slot.bone, true))));
        }
        this.drawOrder = new Array(this.slots.size);
        it = skeleton.drawOrder.iterator();
        while (it.hasNext()) {
            this.drawOrder.add((Slot) this.slots.get(skeleton.slots.indexOf((Slot) it.next(), true)));
        }
        this.skin = skeleton.skin;
        this.color = new Color(skeleton.color);
        this.time = skeleton.time;
    }

    public void updateWorldTransform() {
        boolean flipX = this.flipX;
        boolean flipY = this.flipY;
        Array<Bone> bones = this.bones;
        int n = bones.size;
        for (int i = 0; i < n; i++) {
            ((Bone) bones.get(i)).updateWorldTransform(flipX, flipY);
        }
    }

    public void setToSetupPose() {
        setBonesToSetupPose();
        setSlotsToSetupPose();
    }

    public void setBonesToSetupPose() {
        Array<Bone> bones = this.bones;
        int n = bones.size;
        for (int i = 0; i < n; i++) {
            ((Bone) bones.get(i)).setToSetupPose();
        }
    }

    public void setSlotsToSetupPose() {
        Array<Slot> slots = this.slots;
        System.arraycopy(slots.items, 0, this.drawOrder.items, 0, slots.size);
        int n = slots.size;
        for (int i = 0; i < n; i++) {
            ((Slot) slots.get(i)).setToSetupPose(i);
        }
    }

    public SkeletonData getData() {
        return this.data;
    }

    public Array<Bone> getBones() {
        return this.bones;
    }

    public Bone getRootBone() {
        if (this.bones.size == 0) {
            return null;
        }
        return (Bone) this.bones.first();
    }

    public Bone findBone(String boneName) {
        if (boneName == null) {
            throw new IllegalArgumentException("boneName cannot be null.");
        }
        Array<Bone> bones = this.bones;
        int n = bones.size;
        for (int i = 0; i < n; i++) {
            Bone bone = (Bone) bones.get(i);
            if (bone.data.name.equals(boneName)) {
                return bone;
            }
        }
        return null;
    }

    public int findBoneIndex(String boneName) {
        if (boneName == null) {
            throw new IllegalArgumentException("boneName cannot be null.");
        }
        Array<Bone> bones = this.bones;
        int n = bones.size;
        for (int i = 0; i < n; i++) {
            if (((Bone) bones.get(i)).data.name.equals(boneName)) {
                return i;
            }
        }
        return -1;
    }

    public Array<Slot> getSlots() {
        return this.slots;
    }

    public Slot findSlot(String slotName) {
        if (slotName == null) {
            throw new IllegalArgumentException("slotName cannot be null.");
        }
        Array<Slot> slots = this.slots;
        int n = slots.size;
        for (int i = 0; i < n; i++) {
            Slot slot = (Slot) slots.get(i);
            if (slot.data.name.equals(slotName)) {
                return slot;
            }
        }
        return null;
    }

    public int findSlotIndex(String slotName) {
        if (slotName == null) {
            throw new IllegalArgumentException("slotName cannot be null.");
        }
        Array<Slot> slots = this.slots;
        int n = slots.size;
        for (int i = 0; i < n; i++) {
            if (((Slot) slots.get(i)).data.name.equals(slotName)) {
                return i;
            }
        }
        return -1;
    }

    public Array<Slot> getDrawOrder() {
        return this.drawOrder;
    }

    public void setDrawOrder(Array<Slot> drawOrder) {
        this.drawOrder = drawOrder;
    }

    public Skin getSkin() {
        return this.skin;
    }

    public void setSkin(String skinName) {
        Skin skin = this.data.findSkin(skinName);
        if (skin == null) {
            throw new IllegalArgumentException("Skin not found: " + skinName);
        }
        setSkin(skin);
    }

    public void setSkin(Skin newSkin) {
        if (newSkin != null) {
            if (this.skin != null) {
                newSkin.attachAll(this, this.skin);
            } else {
                Array<Slot> slots = this.slots;
                int n = slots.size;
                for (int i = 0; i < n; i++) {
                    Slot slot = (Slot) slots.get(i);
                    String name = slot.data.attachmentName;
                    if (name != null) {
                        Attachment attachment = newSkin.getAttachment(i, name);
                        if (attachment != null) {
                            slot.setAttachment(attachment);
                        }
                    }
                }
            }
        }
        this.skin = newSkin;
    }

    public Attachment getAttachment(String slotName, String attachmentName) {
        return getAttachment(this.data.findSlotIndex(slotName), attachmentName);
    }

    public Attachment getAttachment(int slotIndex, String attachmentName) {
        if (attachmentName == null) {
            throw new IllegalArgumentException("attachmentName cannot be null.");
        }
        if (this.skin != null) {
            Attachment attachment = this.skin.getAttachment(slotIndex, attachmentName);
            if (attachment != null) {
                return attachment;
            }
        }
        if (this.data.defaultSkin != null) {
            return this.data.defaultSkin.getAttachment(slotIndex, attachmentName);
        }
        return null;
    }

    public void setAttachment(String slotName, String attachmentName) {
        if (slotName == null) {
            throw new IllegalArgumentException("slotName cannot be null.");
        }
        Array<Slot> slots = this.slots;
        int n = slots.size;
        for (int i = 0; i < n; i++) {
            Slot slot = (Slot) slots.get(i);
            if (slot.data.name.equals(slotName)) {
                Attachment attachment = null;
                if (attachmentName != null) {
                    attachment = getAttachment(i, attachmentName);
                    if (attachment == null) {
                        throw new IllegalArgumentException("Attachment not found: " + attachmentName + ", for slot: " + slotName);
                    }
                }
                slot.setAttachment(attachment);
                return;
            }
        }
        throw new IllegalArgumentException("Slot not found: " + slotName);
    }

    public Color getColor() {
        return this.color;
    }

    public boolean getFlipX() {
        return this.flipX;
    }

    public void setFlipX(boolean flipX) {
        this.flipX = flipX;
    }

    public boolean getFlipY() {
        return this.flipY;
    }

    public void setFlipY(boolean flipY) {
        this.flipY = flipY;
    }

    public float getX() {
        return this.f88x;
    }

    public void setX(float x) {
        this.f88x = x;
    }

    public float getY() {
        return this.f89y;
    }

    public void setY(float y) {
        this.f89y = y;
    }

    public void setPosition(float x, float y) {
        this.f88x = x;
        this.f89y = y;
    }

    public float getTime() {
        return this.time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void update(float delta) {
        this.time += delta;
    }

    public String toString() {
        return this.data.name != null ? this.data.name : super.toString();
    }
}
