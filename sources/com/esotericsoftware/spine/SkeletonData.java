package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class SkeletonData {
    final Array<Animation> animations = new Array();
    final Array<BoneData> bones = new Array();
    Skin defaultSkin;
    final Array<EventData> events = new Array();
    String name;
    final Array<Skin> skins = new Array();
    final Array<SlotData> slots = new Array();

    public void clear() {
        this.bones.clear();
        this.slots.clear();
        this.skins.clear();
        this.defaultSkin = null;
        this.events.clear();
        this.animations.clear();
    }

    public void addBone(BoneData bone) {
        if (bone == null) {
            throw new IllegalArgumentException("bone cannot be null.");
        }
        this.bones.add(bone);
    }

    public Array<BoneData> getBones() {
        return this.bones;
    }

    public BoneData findBone(String boneName) {
        if (boneName == null) {
            throw new IllegalArgumentException("boneName cannot be null.");
        }
        Array<BoneData> bones = this.bones;
        int n = bones.size;
        for (int i = 0; i < n; i++) {
            BoneData bone = (BoneData) bones.get(i);
            if (bone.name.equals(boneName)) {
                return bone;
            }
        }
        return null;
    }

    public int findBoneIndex(String boneName) {
        if (boneName == null) {
            throw new IllegalArgumentException("boneName cannot be null.");
        }
        Array<BoneData> bones = this.bones;
        int n = bones.size;
        for (int i = 0; i < n; i++) {
            if (((BoneData) bones.get(i)).name.equals(boneName)) {
                return i;
            }
        }
        return -1;
    }

    public void addSlot(SlotData slot) {
        if (slot == null) {
            throw new IllegalArgumentException("slot cannot be null.");
        }
        this.slots.add(slot);
    }

    public Array<SlotData> getSlots() {
        return this.slots;
    }

    public SlotData findSlot(String slotName) {
        if (slotName == null) {
            throw new IllegalArgumentException("slotName cannot be null.");
        }
        Array<SlotData> slots = this.slots;
        int n = slots.size;
        for (int i = 0; i < n; i++) {
            SlotData slot = (SlotData) slots.get(i);
            if (slot.name.equals(slotName)) {
                return slot;
            }
        }
        return null;
    }

    public int findSlotIndex(String slotName) {
        if (slotName == null) {
            throw new IllegalArgumentException("slotName cannot be null.");
        }
        Array<SlotData> slots = this.slots;
        int n = slots.size;
        for (int i = 0; i < n; i++) {
            if (((SlotData) slots.get(i)).name.equals(slotName)) {
                return i;
            }
        }
        return -1;
    }

    public Skin getDefaultSkin() {
        return this.defaultSkin;
    }

    public void setDefaultSkin(Skin defaultSkin) {
        this.defaultSkin = defaultSkin;
    }

    public void addSkin(Skin skin) {
        if (skin == null) {
            throw new IllegalArgumentException("skin cannot be null.");
        }
        this.skins.add(skin);
    }

    public Skin findSkin(String skinName) {
        if (skinName == null) {
            throw new IllegalArgumentException("skinName cannot be null.");
        }
        Iterator it = this.skins.iterator();
        while (it.hasNext()) {
            Skin skin = (Skin) it.next();
            if (skin.name.equals(skinName)) {
                return skin;
            }
        }
        return null;
    }

    public Array<Skin> getSkins() {
        return this.skins;
    }

    public void addEvent(EventData eventData) {
        if (eventData == null) {
            throw new IllegalArgumentException("eventData cannot be null.");
        }
        this.events.add(eventData);
    }

    public EventData findEvent(String eventDataName) {
        if (eventDataName == null) {
            throw new IllegalArgumentException("eventDataName cannot be null.");
        }
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            EventData eventData = (EventData) it.next();
            if (eventData.name.equals(eventDataName)) {
                return eventData;
            }
        }
        return null;
    }

    public Array<EventData> getEvents() {
        return this.events;
    }

    public void addAnimation(Animation animation) {
        if (animation == null) {
            throw new IllegalArgumentException("animation cannot be null.");
        }
        this.animations.add(animation);
    }

    public Array<Animation> getAnimations() {
        return this.animations;
    }

    public Animation findAnimation(String animationName) {
        if (animationName == null) {
            throw new IllegalArgumentException("animationName cannot be null.");
        }
        Array<Animation> animations = this.animations;
        int n = animations.size;
        for (int i = 0; i < n; i++) {
            Animation animation = (Animation) animations.get(i);
            if (animation.name.equals(animationName)) {
                return animation;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name != null ? this.name : super.toString();
    }
}
