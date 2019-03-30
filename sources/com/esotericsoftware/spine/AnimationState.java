package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

public class AnimationState {
    private final AnimationStateData data;
    private final Array<Event> events = new Array();
    private final Array<AnimationStateListener> listeners = new Array();
    private float timeScale = 1.0f;
    private Pool<TrackEntry> trackEntryPool = new C05151();
    private Array<TrackEntry> tracks = new Array();

    public interface AnimationStateListener {
        void complete(int i, int i2);

        void end(int i);

        void event(int i, Event event);

        void start(int i);
    }

    /* renamed from: com.esotericsoftware.spine.AnimationState$1 */
    class C05151 extends Pool {
        C05151() {
        }

        protected Object newObject() {
            return new TrackEntry();
        }
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
        float mix = 1.0f;
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

        public float getMix() {
            return this.mix;
        }

        public void setMix(float mix) {
            this.mix = mix;
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

    public AnimationState(AnimationStateData data) {
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
                current.time += current.timeScale * delta;
                if (current.previous != null) {
                    float previousDelta = delta * current.previous.timeScale;
                    TrackEntry trackEntry = current.previous;
                    trackEntry.time += previousDelta;
                    current.mixTime += previousDelta;
                }
                TrackEntry next = current.next;
                if (next != null) {
                    next.time = current.lastTime - next.delay;
                    if (next.time >= 0.0f) {
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
    public void apply(com.esotericsoftware.spine.Skeleton r25) {
        /*
        r24 = this;
        r0 = r24;
        r7 = r0.events;
        r0 = r24;
        r2 = r0.listeners;
        r0 = r2.size;
        r21 = r0;
        r18 = 0;
    L_0x000e:
        r0 = r24;
        r2 = r0.tracks;
        r2 = r2.size;
        r0 = r18;
        if (r0 < r2) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r0 = r24;
        r2 = r0.tracks;
        r0 = r18;
        r15 = r2.get(r0);
        r15 = (com.esotericsoftware.spine.AnimationState.TrackEntry) r15;
        if (r15 != 0) goto L_0x002a;
    L_0x0027:
        r18 = r18 + 1;
        goto L_0x000e;
    L_0x002a:
        r2 = 0;
        r7.size = r2;
        r5 = r15.time;
        r4 = r15.lastTime;
        r0 = r15.endTime;
        r16 = r0;
        r6 = r15.loop;
        if (r6 != 0) goto L_0x003f;
    L_0x0039:
        r2 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1));
        if (r2 <= 0) goto L_0x003f;
    L_0x003d:
        r5 = r16;
    L_0x003f:
        r0 = r15.previous;
        r23 = r0;
        if (r23 != 0) goto L_0x0097;
    L_0x0045:
        r2 = r15.mix;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x008d;
    L_0x004d:
        r2 = r15.animation;
        r3 = r25;
        r2.apply(r3, r4, r5, r6, r7);
    L_0x0054:
        r19 = 0;
        r0 = r7.size;
        r22 = r0;
    L_0x005a:
        r0 = r19;
        r1 = r22;
        if (r0 < r1) goto L_0x00e2;
    L_0x0060:
        if (r6 == 0) goto L_0x0119;
    L_0x0062:
        r2 = r4 % r16;
        r3 = r5 % r16;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x0088;
    L_0x006a:
        r2 = r5 / r16;
        r14 = (int) r2;
        r2 = r15.listener;
        if (r2 == 0) goto L_0x0078;
    L_0x0071:
        r2 = r15.listener;
        r0 = r18;
        r2.complete(r0, r14);
    L_0x0078:
        r19 = 0;
        r0 = r24;
        r2 = r0.listeners;
        r0 = r2.size;
        r22 = r0;
    L_0x0082:
        r0 = r19;
        r1 = r22;
        if (r0 < r1) goto L_0x0123;
    L_0x0088:
        r2 = r15.time;
        r15.lastTime = r2;
        goto L_0x0027;
    L_0x008d:
        r2 = r15.animation;
        r8 = r15.mix;
        r3 = r25;
        r2.mix(r3, r4, r5, r6, r7, r8);
        goto L_0x0054;
    L_0x0097:
        r0 = r23;
        r10 = r0.time;
        r0 = r23;
        r2 = r0.loop;
        if (r2 != 0) goto L_0x00ad;
    L_0x00a1:
        r0 = r23;
        r2 = r0.endTime;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x00ad;
    L_0x00a9:
        r0 = r23;
        r10 = r0.endTime;
    L_0x00ad:
        r0 = r23;
        r8 = r0.animation;
        r0 = r23;
        r12 = r0.loop;
        r13 = 0;
        r9 = r25;
        r11 = r10;
        r8.apply(r9, r10, r11, r12, r13);
        r2 = r15.mixTime;
        r3 = r15.mixDuration;
        r2 = r2 / r3;
        r3 = r15.mix;
        r8 = r2 * r3;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x00d9;
    L_0x00cb:
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r24;
        r2 = r0.trackEntryPool;
        r0 = r23;
        r2.free(r0);
        r2 = 0;
        r15.previous = r2;
    L_0x00d9:
        r2 = r15.animation;
        r3 = r25;
        r2.mix(r3, r4, r5, r6, r7, r8);
        goto L_0x0054;
    L_0x00e2:
        r0 = r19;
        r17 = r7.get(r0);
        r17 = (com.esotericsoftware.spine.Event) r17;
        r2 = r15.listener;
        if (r2 == 0) goto L_0x00f7;
    L_0x00ee:
        r2 = r15.listener;
        r0 = r18;
        r1 = r17;
        r2.event(r0, r1);
    L_0x00f7:
        r20 = 0;
    L_0x00f9:
        r0 = r20;
        r1 = r21;
        if (r0 < r1) goto L_0x0103;
    L_0x00ff:
        r19 = r19 + 1;
        goto L_0x005a;
    L_0x0103:
        r0 = r24;
        r2 = r0.listeners;
        r0 = r20;
        r2 = r2.get(r0);
        r2 = (com.esotericsoftware.spine.AnimationState.AnimationStateListener) r2;
        r0 = r18;
        r1 = r17;
        r2.event(r0, r1);
        r20 = r20 + 1;
        goto L_0x00f9;
    L_0x0119:
        r2 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1));
        if (r2 >= 0) goto L_0x0088;
    L_0x011d:
        r2 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1));
        if (r2 < 0) goto L_0x0088;
    L_0x0121:
        goto L_0x006a;
    L_0x0123:
        r0 = r24;
        r2 = r0.listeners;
        r0 = r19;
        r2 = r2.get(r0);
        r2 = (com.esotericsoftware.spine.AnimationState.AnimationStateListener) r2;
        r0 = r18;
        r2.complete(r0, r14);
        r19 = r19 + 1;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.spine.AnimationState.apply(com.esotericsoftware.spine.Skeleton):void");
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
                    this.trackEntryPool.free(current.previous);
                }
            }
        }
    }

    private void freeAll(TrackEntry entry) {
        while (entry != null) {
            TrackEntry next = entry.next;
            this.trackEntryPool.free(entry);
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
            TrackEntry previous = current.previous;
            current.previous = null;
            if (current.listener != null) {
                current.listener.end(index);
            }
            n = this.listeners.size;
            for (i = 0; i < n; i++) {
                ((AnimationStateListener) this.listeners.get(i)).end(index);
            }
            entry.mixDuration = this.data.getMix(current.animation, entry.animation);
            if (entry.mixDuration > 0.0f) {
                entry.mixTime = 0.0f;
                if (previous == null || current.mixTime / current.mixDuration >= 0.5f) {
                    entry.previous = current;
                } else {
                    entry.previous = previous;
                    previous = current;
                }
            } else {
                this.trackEntryPool.free(current);
            }
            if (previous != null) {
                this.trackEntryPool.free(previous);
            }
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
        TrackEntry entry = (TrackEntry) this.trackEntryPool.obtain();
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
        TrackEntry entry = (TrackEntry) this.trackEntryPool.obtain();
        entry.animation = animation;
        entry.loop = loop;
        entry.endTime = animation.getDuration();
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
                delay += last.endTime - this.data.getMix(last.animation, animation);
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

    public Array<TrackEntry> getTracks() {
        return this.tracks;
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
