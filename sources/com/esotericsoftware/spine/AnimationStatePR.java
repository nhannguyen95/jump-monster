package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.Pools;

public class AnimationStatePR {
    private final AnimationStateData data;
    private final Array<Event> events = new Array();
    private final Array<AnimationStateListener> listeners = new Array();
    private float timeScale = 1.0f;
    private Array<TrackEntry> tracks = new Array();

    public interface AnimationStateListener {
        void complete(int i, int i2);

        void end(int i);

        void event(int i, Event event);

        void start(int i);
    }

    public static abstract class AnimationStateAdapter implements AnimationStateListener {
        public void event(int trackIndex, Event event) {
        }

        public void complete(int trackIndex, int loopCount) {
        }

        public void start(int trackIndex) {
        }

        public void end(int trackIndex) {
        }
    }

    public static class TrackEntry implements Poolable {
        Animation animation;
        float delay;
        float endTime;
        float lastTime;
        AnimationStateListener listener;
        boolean loop;
        float mixDuration;
        float mixTime;
        TrackEntry next;
        TrackEntry previous;
        float time;
        float timeScale = 1.0f;

        public void reset() {
            this.next = null;
            this.previous = null;
            this.animation = null;
            this.listener = null;
            this.timeScale = 1.0f;
            this.lastTime = -1.0f;
            this.time = 0.0f;
            this.mixDuration = 0.0f;
            this.mixTime = 0.0f;
        }

        public Animation getAnimation() {
            return this.animation;
        }

        public void setAnimation(Animation animation) {
            this.animation = animation;
        }

        public boolean getLoop() {
            return this.loop;
        }

        public void setLoop(boolean loop) {
            this.loop = loop;
        }

        public float getDelay() {
            return this.delay;
        }

        public void setDelay(float delay) {
            this.delay = delay;
        }

        public float getTime() {
            return this.time;
        }

        public void setTime(float time) {
            this.time = time;
        }

        public float getEndTime() {
            return this.endTime;
        }

        public void setEndTime(float endTime) {
            this.endTime = endTime;
        }

        public AnimationStateListener getListener() {
            return this.listener;
        }

        public void setListener(AnimationStateListener listener) {
            this.listener = listener;
        }

        public float getLastTime() {
            return this.lastTime;
        }

        public void setLastTime(float lastTime) {
            this.lastTime = lastTime;
        }

        public float getTimeScale() {
            return this.timeScale;
        }

        public void setTimeScale(float timeScale) {
            this.timeScale = timeScale;
        }

        public TrackEntry getNext() {
            return this.next;
        }

        public void setNext(TrackEntry next) {
            this.next = next;
        }

        public boolean isComplete() {
            return this.time >= this.endTime;
        }

        public String toString() {
            return this.animation == null ? "<none>" : this.animation.name;
        }
    }

    public AnimationStatePR(AnimationStateData data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null.");
        }
        this.data = data;
    }

    public void update(float delta) {
        delta *= this.timeScale;
        for (int i = 0; i < this.tracks.size; i++) {
            TrackEntry current = (TrackEntry) this.tracks.get(i);
            if (current != null) {
                float trackDelta = delta * current.timeScale;
                current.time += trackDelta;
                if (current.mixDuration > 0.0f) {
                    if (current.previous != null) {
                        TrackEntry trackEntry = current.previous;
                        trackEntry.time += trackDelta;
                    }
                    current.mixTime += trackDelta;
                }
                TrackEntry next = current.next;
                if (next != null) {
                    if (current.lastTime >= next.delay) {
                        setCurrent(i, next);
                    }
                } else if (!current.loop && current.lastTime >= current.endTime) {
                    clearTrack(i);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void apply(com.esotericsoftware.spine.Skeleton r27) {
        /*
        r26 = this;
        r0 = r26;
        r7 = r0.events;
        r0 = r26;
        r2 = r0.listeners;
        r0 = r2.size;
        r23 = r0;
        r20 = 0;
    L_0x000e:
        r0 = r26;
        r2 = r0.tracks;
        r2 = r2.size;
        r0 = r20;
        if (r0 < r2) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r0 = r26;
        r2 = r0.tracks;
        r0 = r20;
        r17 = r2.get(r0);
        r17 = (com.esotericsoftware.spine.AnimationStatePR.TrackEntry) r17;
        if (r17 != 0) goto L_0x002a;
    L_0x0027:
        r20 = r20 + 1;
        goto L_0x000e;
    L_0x002a:
        r2 = 0;
        r7.size = r2;
        r0 = r17;
        r5 = r0.time;
        r0 = r17;
        r4 = r0.lastTime;
        r0 = r17;
        r0 = r0.endTime;
        r18 = r0;
        r0 = r17;
        r6 = r0.loop;
        if (r6 != 0) goto L_0x0047;
    L_0x0041:
        r2 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1));
        if (r2 <= 0) goto L_0x0047;
    L_0x0045:
        r5 = r18;
    L_0x0047:
        r0 = r17;
        r0 = r0.previous;
        r25 = r0;
        r0 = r17;
        r2 = r0.mixDuration;
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x018b;
    L_0x0056:
        r0 = r17;
        r2 = r0.mixTime;
        r0 = r17;
        r3 = r0.mixDuration;
        r8 = r2 / r3;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x006d;
    L_0x0066:
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 0;
        r0 = r17;
        r0.mixDuration = r2;
    L_0x006d:
        if (r25 != 0) goto L_0x00e0;
    L_0x006f:
        r0 = r17;
        r2 = r0.animation;
        r3 = r27;
        r2.mix(r3, r4, r5, r6, r7, r8);
        r2 = java.lang.System.out;
        r3 = new java.lang.StringBuilder;
        r9 = "none -> ";
        r3.<init>(r9);
        r0 = r17;
        r9 = r0.animation;
        r3 = r3.append(r9);
        r9 = ": ";
        r3 = r3.append(r9);
        r3 = r3.append(r8);
        r3 = r3.toString();
        r2.println(r3);
    L_0x009a:
        r21 = 0;
        r0 = r7.size;
        r24 = r0;
    L_0x00a0:
        r0 = r21;
        r1 = r24;
        if (r0 < r1) goto L_0x0196;
    L_0x00a6:
        if (r6 == 0) goto L_0x01d1;
    L_0x00a8:
        r2 = r4 % r18;
        r3 = r5 % r18;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x00d6;
    L_0x00b0:
        r2 = r5 / r18;
        r0 = (int) r2;
        r16 = r0;
        r0 = r17;
        r2 = r0.listener;
        if (r2 == 0) goto L_0x00c6;
    L_0x00bb:
        r0 = r17;
        r2 = r0.listener;
        r0 = r20;
        r1 = r16;
        r2.complete(r0, r1);
    L_0x00c6:
        r21 = 0;
        r0 = r26;
        r2 = r0.listeners;
        r0 = r2.size;
        r24 = r0;
    L_0x00d0:
        r0 = r21;
        r1 = r24;
        if (r0 < r1) goto L_0x01db;
    L_0x00d6:
        r0 = r17;
        r2 = r0.time;
        r0 = r17;
        r0.lastTime = r2;
        goto L_0x0027;
    L_0x00e0:
        r0 = r25;
        r11 = r0.time;
        r0 = r25;
        r2 = r0.loop;
        if (r2 != 0) goto L_0x00f6;
    L_0x00ea:
        r0 = r25;
        r2 = r0.endTime;
        r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x00f6;
    L_0x00f2:
        r0 = r25;
        r11 = r0.endTime;
    L_0x00f6:
        r0 = r17;
        r2 = r0.animation;
        if (r2 != 0) goto L_0x0144;
    L_0x00fc:
        r0 = r25;
        r9 = r0.animation;
        r0 = r25;
        r13 = r0.loop;
        r14 = 0;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r15 = r2 - r8;
        r10 = r27;
        r12 = r11;
        r9.mix(r10, r11, r12, r13, r14, r15);
        r2 = java.lang.System.out;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r25;
        r9 = r0.animation;
        r3 = r3.append(r9);
        r9 = " -> none: ";
        r3 = r3.append(r9);
        r3 = r3.append(r8);
        r3 = r3.toString();
        r2.println(r3);
    L_0x012f:
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x009a;
    L_0x0135:
        com.badlogic.gdx.utils.Pools.free(r25);
        r2 = 0;
        r0 = r17;
        r0.previous = r2;
        r2 = 0;
        r0 = r17;
        r0.mixDuration = r2;
        goto L_0x009a;
    L_0x0144:
        r0 = r25;
        r9 = r0.animation;
        r0 = r25;
        r13 = r0.loop;
        r14 = 0;
        r10 = r27;
        r12 = r11;
        r9.apply(r10, r11, r12, r13, r14);
        r0 = r17;
        r2 = r0.animation;
        r3 = r27;
        r2.mix(r3, r4, r5, r6, r7, r8);
        r2 = java.lang.System.out;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r25;
        r9 = r0.animation;
        r3 = r3.append(r9);
        r9 = " -> ";
        r3 = r3.append(r9);
        r0 = r17;
        r9 = r0.animation;
        r3 = r3.append(r9);
        r9 = ": ";
        r3 = r3.append(r9);
        r3 = r3.append(r8);
        r3 = r3.toString();
        r2.println(r3);
        goto L_0x012f;
    L_0x018b:
        r0 = r17;
        r2 = r0.animation;
        r3 = r27;
        r2.apply(r3, r4, r5, r6, r7);
        goto L_0x009a;
    L_0x0196:
        r0 = r21;
        r19 = r7.get(r0);
        r19 = (com.esotericsoftware.spine.Event) r19;
        r0 = r17;
        r2 = r0.listener;
        if (r2 == 0) goto L_0x01af;
    L_0x01a4:
        r0 = r17;
        r2 = r0.listener;
        r0 = r20;
        r1 = r19;
        r2.event(r0, r1);
    L_0x01af:
        r22 = 0;
    L_0x01b1:
        r0 = r22;
        r1 = r23;
        if (r0 < r1) goto L_0x01bb;
    L_0x01b7:
        r21 = r21 + 1;
        goto L_0x00a0;
    L_0x01bb:
        r0 = r26;
        r2 = r0.listeners;
        r0 = r22;
        r2 = r2.get(r0);
        r2 = (com.esotericsoftware.spine.AnimationStatePR.AnimationStateListener) r2;
        r0 = r20;
        r1 = r19;
        r2.event(r0, r1);
        r22 = r22 + 1;
        goto L_0x01b1;
    L_0x01d1:
        r2 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1));
        if (r2 >= 0) goto L_0x00d6;
    L_0x01d5:
        r2 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1));
        if (r2 < 0) goto L_0x00d6;
    L_0x01d9:
        goto L_0x00b0;
    L_0x01db:
        r0 = r26;
        r2 = r0.listeners;
        r0 = r21;
        r2 = r2.get(r0);
        r2 = (com.esotericsoftware.spine.AnimationStatePR.AnimationStateListener) r2;
        r0 = r20;
        r1 = r16;
        r2.complete(r0, r1);
        r21 = r21 + 1;
        goto L_0x00d0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.spine.AnimationStatePR.apply(com.esotericsoftware.spine.Skeleton):void");
    }

    public void clearTracks() {
        int n = this.tracks.size;
        for (int i = 0; i < n; i++) {
            clearTrack(i);
        }
        this.tracks.clear();
    }

    public void clearTrack(int trackIndex) {
        if (trackIndex < this.tracks.size) {
            TrackEntry current = (TrackEntry) this.tracks.get(trackIndex);
            if (current != null) {
                if (current.listener != null) {
                    current.listener.end(trackIndex);
                }
                int n = this.listeners.size;
                for (int i = 0; i < n; i++) {
                    ((AnimationStateListener) this.listeners.get(i)).end(trackIndex);
                }
                this.tracks.set(trackIndex, null);
                freeAll(current);
                if (current.previous != null) {
                    Pools.free(current.previous);
                }
            }
        }
    }

    private void freeAll(TrackEntry entry) {
        while (entry != null) {
            TrackEntry next = entry.next;
            Pools.free(entry);
            entry = next;
        }
    }

    private TrackEntry expandToIndex(int index) {
        if (index < this.tracks.size) {
            return (TrackEntry) this.tracks.get(index);
        }
        this.tracks.ensureCapacity((index - this.tracks.size) + 1);
        this.tracks.size = index + 1;
        return null;
    }

    private void setCurrent(int index, TrackEntry entry) {
        int n;
        int i;
        TrackEntry current = expandToIndex(index);
        if (current != null) {
            if (current.previous != null) {
                Pools.free(current.previous);
                current.previous = null;
            }
            if (current.listener != null) {
                current.listener.end(index);
            }
            n = this.listeners.size;
            for (i = 0; i < n; i++) {
                ((AnimationStateListener) this.listeners.get(i)).end(index);
            }
            entry.mixDuration = entry.animation != null ? this.data.getMix(current.animation, entry.animation) : this.data.defaultMix;
            if (entry.mixDuration > 0.0f) {
                entry.mixTime = 0.0f;
                entry.previous = current;
            } else {
                Pools.free(current);
            }
        } else {
            entry.mixDuration = this.data.defaultMix;
        }
        this.tracks.set(index, entry);
        if (entry.listener != null) {
            entry.listener.start(index);
        }
        n = this.listeners.size;
        for (i = 0; i < n; i++) {
            ((AnimationStateListener) this.listeners.get(i)).start(index);
        }
    }

    public TrackEntry setAnimation(int trackIndex, String animationName, boolean loop) {
        Animation animation = this.data.getSkeletonData().findAnimation(animationName);
        if (animation != null) {
            return setAnimation(trackIndex, animation, loop);
        }
        throw new IllegalArgumentException("Animation not found: " + animationName);
    }

    public TrackEntry setAnimation(int trackIndex, Animation animation, boolean loop) {
        TrackEntry current = expandToIndex(trackIndex);
        if (current != null) {
            freeAll(current.next);
        }
        TrackEntry entry = (TrackEntry) Pools.obtain(TrackEntry.class);
        entry.animation = animation;
        entry.loop = loop;
        entry.endTime = animation.getDuration();
        setCurrent(trackIndex, entry);
        return entry;
    }

    public TrackEntry addAnimation(int trackIndex, String animationName, boolean loop, float delay) {
        Animation animation = this.data.getSkeletonData().findAnimation(animationName);
        if (animation != null) {
            return addAnimation(trackIndex, animation, loop, delay);
        }
        throw new IllegalArgumentException("Animation not found: " + animationName);
    }

    public TrackEntry addAnimation(int trackIndex, Animation animation, boolean loop, float delay) {
        TrackEntry entry = (TrackEntry) Pools.obtain(TrackEntry.class);
        entry.animation = animation;
        entry.loop = loop;
        entry.endTime = animation != null ? animation.getDuration() : this.data.defaultMix;
        TrackEntry last = expandToIndex(trackIndex);
        if (last != null) {
            while (last.next != null) {
                last = last.next;
            }
            last.next = entry;
        } else {
            this.tracks.set(trackIndex, entry);
        }
        if (delay <= 0.0f) {
            if (last != null) {
                delay += last.endTime - (animation != null ? this.data.getMix(last.animation, animation) : this.data.defaultMix);
            } else {
                delay = 0.0f;
            }
        }
        entry.delay = delay;
        return entry;
    }

    public TrackEntry getCurrent(int trackIndex) {
        if (trackIndex >= this.tracks.size) {
            return null;
        }
        return (TrackEntry) this.tracks.get(trackIndex);
    }

    public void addListener(AnimationStateListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        this.listeners.add(listener);
    }

    public void removeListener(AnimationStateListener listener) {
        this.listeners.removeValue(listener, true);
    }

    public float getTimeScale() {
        return this.timeScale;
    }

    public void setTimeScale(float timeScale) {
        this.timeScale = timeScale;
    }

    public AnimationStateData getData() {
        return this.data;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(64);
        int n = this.tracks.size;
        for (int i = 0; i < n; i++) {
            TrackEntry entry = (TrackEntry) this.tracks.get(i);
            if (entry != null) {
                if (buffer.length() > 0) {
                    buffer.append(", ");
                }
                buffer.append(entry.toString());
            }
        }
        if (buffer.length() == 0) {
            return "<none>";
        }
        return buffer.toString();
    }
}
