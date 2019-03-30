package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.ObjectFloatMap;

public class AnimationStateData {
    final ObjectFloatMap<Key> animationToMixTime = new ObjectFloatMap();
    float defaultMix;
    private final SkeletonData skeletonData;
    final Key tempKey = new Key();

    static class Key {
        Animation a1;
        Animation a2;

        Key() {
        }

        public int hashCode() {
            return ((this.a1.hashCode() + 31) * 31) + this.a2.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            Key other = (Key) obj;
            if (this.a1 == null) {
                if (other.a1 != null) {
                    return false;
                }
            } else if (!this.a1.equals(other.a1)) {
                return false;
            }
            if (this.a2 == null) {
                if (other.a2 != null) {
                    return false;
                }
                return true;
            } else if (this.a2.equals(other.a2)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public AnimationStateData(SkeletonData skeletonData) {
        this.skeletonData = skeletonData;
    }

    public SkeletonData getSkeletonData() {
        return this.skeletonData;
    }

    public void setMix(String fromName, String toName, float duration) {
        Animation from = this.skeletonData.findAnimation(fromName);
        if (from == null) {
            throw new IllegalArgumentException("Animation not found: " + fromName);
        }
        Animation to = this.skeletonData.findAnimation(toName);
        if (to == null) {
            throw new IllegalArgumentException("Animation not found: " + toName);
        }
        setMix(from, to, duration);
    }

    public void setMix(Animation from, Animation to, float duration) {
        if (from == null) {
            throw new IllegalArgumentException("from cannot be null.");
        } else if (to == null) {
            throw new IllegalArgumentException("to cannot be null.");
        } else {
            Key key = new Key();
            key.a1 = from;
            key.a2 = to;
            this.animationToMixTime.put(key, duration);
        }
    }

    public float getMix(Animation from, Animation to) {
        this.tempKey.a1 = from;
        this.tempKey.a2 = to;
        return this.animationToMixTime.get(this.tempKey, this.defaultMix);
    }

    public float getDefaultMix() {
        return this.defaultMix;
    }

    public void setDefaultMix(float defaultMix) {
        this.defaultMix = defaultMix;
    }
}
