package com.esotericsoftware.spine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.esotericsoftware.spine.attachments.Attachment;

public class Animation {
    private float duration;
    final String name;
    private final Array<Timeline> timelines;

    public interface Timeline {
        void apply(Skeleton skeleton, float f, float f2, Array<Event> array, float f3);
    }

    public static class AttachmentTimeline implements Timeline {
        private final String[] attachmentNames;
        private final float[] frames;
        int slotIndex;

        public AttachmentTimeline(int frameCount) {
            this.frames = new float[frameCount];
            this.attachmentNames = new String[frameCount];
        }

        public int getFrameCount() {
            return this.frames.length;
        }

        public int getSlotIndex() {
            return this.slotIndex;
        }

        public void setSlotIndex(int slotIndex) {
            this.slotIndex = slotIndex;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public String[] getAttachmentNames() {
            return this.attachmentNames;
        }

        public void setFrame(int frameIndex, float time, String attachmentName) {
            this.frames[frameIndex] = time;
            this.attachmentNames[frameIndex] = attachmentName;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            float[] frames = this.frames;
            if (time >= frames[0]) {
                int frameIndex;
                if (time >= frames[frames.length - 1]) {
                    frameIndex = frames.length - 1;
                } else {
                    frameIndex = Animation.binarySearch(frames, time, 1) - 1;
                }
                String attachmentName = this.attachmentNames[frameIndex];
                ((Slot) skeleton.slots.get(this.slotIndex)).setAttachment(attachmentName == null ? null : skeleton.getAttachment(this.slotIndex, attachmentName));
            }
        }
    }

    public static abstract class CurveTimeline implements Timeline {
        public static final float BEZIER = -2.0f;
        private static final int BEZIER_SEGMENTS = 10;
        public static final float LINEAR = 0.0f;
        public static final float STEPPED = -1.0f;
        private final float[] curves;

        public CurveTimeline(int frameCount) {
            this.curves = new float[((frameCount - 1) * 6)];
        }

        public int getFrameCount() {
            return (this.curves.length / 6) + 1;
        }

        public void setLinear(int frameIndex) {
            this.curves[frameIndex * 6] = 0.0f;
        }

        public void setStepped(int frameIndex) {
            this.curves[frameIndex * 6] = -1.0f;
        }

        public float getCurveType(int frameIndex) {
            int index = frameIndex * 6;
            if (index == this.curves.length) {
                return 0.0f;
            }
            float type = this.curves[index];
            if (type == 0.0f) {
                return 0.0f;
            }
            if (type == -1.0f) {
                return -1.0f;
            }
            return -2.0f;
        }

        public void setCurve(int frameIndex, float cx1, float cy1, float cx2, float cy2) {
            float subdiv_step2 = 0.1f * 0.1f;
            float subdiv_step3 = subdiv_step2 * 0.1f;
            float pre1 = 3.0f * 0.1f;
            float pre2 = 3.0f * subdiv_step2;
            float pre4 = 6.0f * subdiv_step2;
            float pre5 = 6.0f * subdiv_step3;
            float tmp1x = ((-cx1) * 2.0f) + cx2;
            float tmp1y = ((-cy1) * 2.0f) + cy2;
            float tmp2x = ((cx1 - cx2) * 3.0f) + 1.0f;
            float tmp2y = ((cy1 - cy2) * 3.0f) + 1.0f;
            int i = frameIndex * 6;
            float[] curves = this.curves;
            curves[i] = ((cx1 * pre1) + (tmp1x * pre2)) + (tmp2x * subdiv_step3);
            curves[i + 1] = ((cy1 * pre1) + (tmp1y * pre2)) + (tmp2y * subdiv_step3);
            curves[i + 2] = (tmp1x * pre4) + (tmp2x * pre5);
            curves[i + 3] = (tmp1y * pre4) + (tmp2y * pre5);
            curves[i + 4] = tmp2x * pre5;
            curves[i + 5] = tmp2y * pre5;
        }

        public float getCurvePercent(int frameIndex, float percent) {
            int curveIndex = frameIndex * 6;
            float[] curves = this.curves;
            float dfx = curves[curveIndex];
            if (dfx == 0.0f) {
                return percent;
            }
            if (dfx == -1.0f) {
                return 0.0f;
            }
            float dfy = curves[curveIndex + 1];
            float ddfx = curves[curveIndex + 2];
            float ddfy = curves[curveIndex + 3];
            float dddfx = curves[curveIndex + 4];
            float dddfy = curves[curveIndex + 5];
            float x = dfx;
            float y = dfy;
            int i = 8;
            while (x < percent) {
                if (i == 0) {
                    return y + (((1.0f - y) * (percent - x)) / (1.0f - x));
                }
                i--;
                dfx += ddfx;
                dfy += ddfy;
                ddfx += dddfx;
                ddfy += dddfy;
                x += dfx;
                y += dfy;
            }
            float prevX = x - dfx;
            float prevY = y - dfy;
            return prevY + (((y - prevY) * (percent - prevX)) / (x - prevX));
        }
    }

    public static class DrawOrderTimeline implements Timeline {
        private final int[][] drawOrders;
        private final float[] frames;

        public DrawOrderTimeline(int frameCount) {
            this.frames = new float[frameCount];
            this.drawOrders = new int[frameCount][];
        }

        public int getFrameCount() {
            return this.frames.length;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public int[][] getDrawOrders() {
            return this.drawOrders;
        }

        public void setFrame(int frameIndex, float time, int[] drawOrder) {
            this.frames[frameIndex] = time;
            this.drawOrders[frameIndex] = drawOrder;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            float[] frames = this.frames;
            if (time >= frames[0]) {
                int frameIndex;
                if (time >= frames[frames.length - 1]) {
                    frameIndex = frames.length - 1;
                } else {
                    frameIndex = Animation.binarySearch(frames, time, 1) - 1;
                }
                Array<Slot> drawOrder = skeleton.drawOrder;
                Array<Slot> slots = skeleton.slots;
                int[] drawOrderToSetupIndex = this.drawOrders[frameIndex];
                if (drawOrderToSetupIndex == null) {
                    System.arraycopy(slots.items, 0, drawOrder.items, 0, slots.size);
                    return;
                }
                int n = drawOrderToSetupIndex.length;
                for (int i = 0; i < n; i++) {
                    drawOrder.set(i, (Slot) slots.get(drawOrderToSetupIndex[i]));
                }
            }
        }
    }

    public static class EventTimeline implements Timeline {
        private final Event[] events;
        private final float[] frames;

        public EventTimeline(int frameCount) {
            this.frames = new float[frameCount];
            this.events = new Event[frameCount];
        }

        public int getFrameCount() {
            return this.frames.length;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public Event[] getEvents() {
            return this.events;
        }

        public void setFrame(int frameIndex, float time, Event event) {
            this.frames[frameIndex] = time;
            this.events[frameIndex] = event;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> firedEvents, float alpha) {
            if (firedEvents != null) {
                float[] frames = this.frames;
                int frameCount = frames.length;
                if (lastTime > time) {
                    apply(skeleton, lastTime, 2.14748365E9f, firedEvents, alpha);
                    lastTime = -1.0f;
                } else if (lastTime >= frames[frameCount - 1]) {
                    return;
                }
                if (time >= frames[0]) {
                    int frameIndex;
                    if (lastTime < frames[0]) {
                        frameIndex = 0;
                    } else {
                        frameIndex = Animation.binarySearch(frames, lastTime, 1);
                        float frame = frames[frameIndex];
                        while (frameIndex > 0 && frames[frameIndex - 1] == frame) {
                            frameIndex--;
                        }
                    }
                    while (frameIndex < frameCount && time >= frames[frameIndex]) {
                        firedEvents.add(this.events[frameIndex]);
                        frameIndex++;
                    }
                }
            }
        }
    }

    public static class ColorTimeline extends CurveTimeline {
        private static final int FRAME_A = 4;
        private static final int FRAME_B = 3;
        private static final int FRAME_G = 2;
        private static final int FRAME_R = 1;
        private static final int PREV_FRAME_TIME = -5;
        private final float[] frames;
        int slotIndex;

        public ColorTimeline(int frameCount) {
            super(frameCount);
            this.frames = new float[(frameCount * 5)];
        }

        public void setSlotIndex(int slotIndex) {
            this.slotIndex = slotIndex;
        }

        public int getSlotIndex() {
            return this.slotIndex;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public void setFrame(int frameIndex, float time, float r, float g, float b, float a) {
            frameIndex *= 5;
            this.frames[frameIndex] = time;
            this.frames[frameIndex + 1] = r;
            this.frames[frameIndex + 2] = g;
            this.frames[frameIndex + 3] = b;
            this.frames[frameIndex + 4] = a;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            float[] frames = this.frames;
            if (time >= frames[0]) {
                float r;
                float g;
                float b;
                float a;
                if (time >= frames[frames.length + PREV_FRAME_TIME]) {
                    int i = frames.length - 1;
                    r = frames[i - 3];
                    g = frames[i - 2];
                    b = frames[i - 1];
                    a = frames[i];
                } else {
                    int frameIndex = Animation.binarySearch(frames, time, 5);
                    float prevFrameR = frames[frameIndex - 4];
                    float prevFrameG = frames[frameIndex - 3];
                    float prevFrameB = frames[frameIndex - 2];
                    float prevFrameA = frames[frameIndex - 1];
                    float frameTime = frames[frameIndex];
                    float percent = getCurvePercent((frameIndex / 5) - 1, MathUtils.clamp(1.0f - ((time - frameTime) / (frames[frameIndex + PREV_FRAME_TIME] - frameTime)), 0.0f, 1.0f));
                    r = prevFrameR + ((frames[frameIndex + 1] - prevFrameR) * percent);
                    g = prevFrameG + ((frames[frameIndex + 2] - prevFrameG) * percent);
                    b = prevFrameB + ((frames[frameIndex + 3] - prevFrameB) * percent);
                    a = prevFrameA + ((frames[frameIndex + 4] - prevFrameA) * percent);
                }
                Color color = ((Slot) skeleton.slots.get(this.slotIndex)).color;
                if (alpha < 1.0f) {
                    color.add((r - color.f40r) * alpha, (g - color.f39g) * alpha, (b - color.f38b) * alpha, (a - color.f37a) * alpha);
                    return;
                }
                color.set(r, g, b, a);
            }
        }
    }

    public static class FfdTimeline extends CurveTimeline {
        Attachment attachment;
        private final float[][] frameVertices;
        private final float[] frames;
        int slotIndex;

        public FfdTimeline(int frameCount) {
            super(frameCount);
            this.frames = new float[frameCount];
            this.frameVertices = new float[frameCount][];
        }

        public void setSlotIndex(int slotIndex) {
            this.slotIndex = slotIndex;
        }

        public int getSlotIndex() {
            return this.slotIndex;
        }

        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }

        public Attachment getAttachment() {
            return this.attachment;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public float[][] getVertices() {
            return this.frameVertices;
        }

        public void setFrame(int frameIndex, float time, float[] vertices) {
            this.frames[frameIndex] = time;
            this.frameVertices[frameIndex] = vertices;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            Slot slot = (Slot) skeleton.slots.get(this.slotIndex);
            if (slot.getAttachment() == this.attachment) {
                float[] frames = this.frames;
                if (time >= frames[0]) {
                    float[][] frameVertices = this.frameVertices;
                    int vertexCount = frameVertices[0].length;
                    FloatArray verticesArray = slot.getAttachmentVertices();
                    if (verticesArray.size != vertexCount) {
                        alpha = 1.0f;
                    }
                    verticesArray.size = 0;
                    verticesArray.ensureCapacity(vertexCount);
                    verticesArray.size = vertexCount;
                    float[] vertices = verticesArray.items;
                    int i;
                    if (time >= frames[frames.length - 1]) {
                        float[] lastVertices = frameVertices[frames.length - 1];
                        if (alpha < 1.0f) {
                            for (i = 0; i < vertexCount; i++) {
                                vertices[i] = vertices[i] + ((lastVertices[i] - vertices[i]) * alpha);
                            }
                            return;
                        }
                        System.arraycopy(lastVertices, 0, vertices, 0, vertexCount);
                        return;
                    }
                    int frameIndex = Animation.binarySearch(frames, time, 1);
                    float frameTime = frames[frameIndex];
                    float percent = getCurvePercent(frameIndex - 1, MathUtils.clamp(1.0f - ((time - frameTime) / (frames[frameIndex - 1] - frameTime)), 0.0f, 1.0f));
                    float[] prevVertices = frameVertices[frameIndex - 1];
                    float[] nextVertices = frameVertices[frameIndex];
                    float prev;
                    if (alpha < 1.0f) {
                        for (i = 0; i < vertexCount; i++) {
                            prev = prevVertices[i];
                            vertices[i] = vertices[i] + (((((nextVertices[i] - prev) * percent) + prev) - vertices[i]) * alpha);
                        }
                        return;
                    }
                    for (i = 0; i < vertexCount; i++) {
                        prev = prevVertices[i];
                        vertices[i] = ((nextVertices[i] - prev) * percent) + prev;
                    }
                }
            }
        }
    }

    public static class RotateTimeline extends CurveTimeline {
        private static final int FRAME_VALUE = 1;
        private static final int PREV_FRAME_TIME = -2;
        int boneIndex;
        private final float[] frames;

        public RotateTimeline(int frameCount) {
            super(frameCount);
            this.frames = new float[(frameCount * 2)];
        }

        public void setBoneIndex(int boneIndex) {
            this.boneIndex = boneIndex;
        }

        public int getBoneIndex() {
            return this.boneIndex;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public void setFrame(int frameIndex, float time, float angle) {
            frameIndex *= 2;
            this.frames[frameIndex] = time;
            this.frames[frameIndex + 1] = angle;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            float[] frames = this.frames;
            if (time >= frames[0]) {
                Bone bone = (Bone) skeleton.bones.get(this.boneIndex);
                float amount;
                if (time >= frames[frames.length - 2]) {
                    amount = (bone.data.rotation + frames[frames.length - 1]) - bone.rotation;
                    while (amount > 180.0f) {
                        amount -= 360.0f;
                    }
                    while (amount < -180.0f) {
                        amount += 360.0f;
                    }
                    bone.rotation += amount * alpha;
                    return;
                }
                int frameIndex = Animation.binarySearch(frames, time, 2);
                float prevFrameValue = frames[frameIndex - 1];
                float frameTime = frames[frameIndex];
                float percent = getCurvePercent((frameIndex / 2) - 1, MathUtils.clamp(1.0f - ((time - frameTime) / (frames[frameIndex - 2] - frameTime)), 0.0f, 1.0f));
                amount = frames[frameIndex + 1] - prevFrameValue;
                while (amount > 180.0f) {
                    amount -= 360.0f;
                }
                while (amount < -180.0f) {
                    amount += 360.0f;
                }
                amount = (bone.data.rotation + ((amount * percent) + prevFrameValue)) - bone.rotation;
                while (amount > 180.0f) {
                    amount -= 360.0f;
                }
                while (amount < -180.0f) {
                    amount += 360.0f;
                }
                bone.rotation += amount * alpha;
            }
        }
    }

    public static class TranslateTimeline extends CurveTimeline {
        static final int FRAME_X = 1;
        static final int FRAME_Y = 2;
        static final int PREV_FRAME_TIME = -3;
        int boneIndex;
        final float[] frames;

        public TranslateTimeline(int frameCount) {
            super(frameCount);
            this.frames = new float[(frameCount * 3)];
        }

        public void setBoneIndex(int boneIndex) {
            this.boneIndex = boneIndex;
        }

        public int getBoneIndex() {
            return this.boneIndex;
        }

        public float[] getFrames() {
            return this.frames;
        }

        public void setFrame(int frameIndex, float time, float x, float y) {
            frameIndex *= 3;
            this.frames[frameIndex] = time;
            this.frames[frameIndex + 1] = x;
            this.frames[frameIndex + 2] = y;
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            float[] frames = this.frames;
            if (time >= frames[0]) {
                Bone bone = (Bone) skeleton.bones.get(this.boneIndex);
                if (time >= frames[frames.length + PREV_FRAME_TIME]) {
                    bone.f84x += ((bone.data.f86x + frames[frames.length - 2]) - bone.f84x) * alpha;
                    bone.f85y += ((bone.data.f87y + frames[frames.length - 1]) - bone.f85y) * alpha;
                    return;
                }
                int frameIndex = Animation.binarySearch(frames, time, 3);
                float prevFrameX = frames[frameIndex - 2];
                float prevFrameY = frames[frameIndex - 1];
                float frameTime = frames[frameIndex];
                float percent = getCurvePercent((frameIndex / 3) - 1, MathUtils.clamp(1.0f - ((time - frameTime) / (frames[frameIndex + PREV_FRAME_TIME] - frameTime)), 0.0f, 1.0f));
                bone.f84x += (((bone.data.f86x + prevFrameX) + ((frames[frameIndex + 1] - prevFrameX) * percent)) - bone.f84x) * alpha;
                bone.f85y += (((bone.data.f87y + prevFrameY) + ((frames[frameIndex + 2] - prevFrameY) * percent)) - bone.f85y) * alpha;
            }
        }
    }

    public static class ScaleTimeline extends TranslateTimeline {
        public ScaleTimeline(int frameCount) {
            super(frameCount);
        }

        public void apply(Skeleton skeleton, float lastTime, float time, Array<Event> array, float alpha) {
            float[] frames = this.frames;
            if (time >= frames[0]) {
                Bone bone = (Bone) skeleton.bones.get(this.boneIndex);
                if (time >= frames[frames.length - 3]) {
                    bone.scaleX += (((bone.data.scaleX - 1.0f) + frames[frames.length - 2]) - bone.scaleX) * alpha;
                    bone.scaleY += (((bone.data.scaleY - 1.0f) + frames[frames.length - 1]) - bone.scaleY) * alpha;
                    return;
                }
                int frameIndex = Animation.binarySearch(frames, time, 3);
                float prevFrameX = frames[frameIndex - 2];
                float prevFrameY = frames[frameIndex - 1];
                float frameTime = frames[frameIndex];
                float percent = getCurvePercent((frameIndex / 3) - 1, MathUtils.clamp(1.0f - ((time - frameTime) / (frames[frameIndex - 3] - frameTime)), 0.0f, 1.0f));
                bone.scaleX += ((((bone.data.scaleX - 1.0f) + prevFrameX) + ((frames[frameIndex + 1] - prevFrameX) * percent)) - bone.scaleX) * alpha;
                bone.scaleY += ((((bone.data.scaleY - 1.0f) + prevFrameY) + ((frames[frameIndex + 2] - prevFrameY) * percent)) - bone.scaleY) * alpha;
            }
        }
    }

    public Animation(String name, Array<Timeline> timelines, float duration) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        } else if (timelines == null) {
            throw new IllegalArgumentException("timelines cannot be null.");
        } else {
            this.name = name;
            this.timelines = timelines;
            this.duration = duration;
        }
    }

    public Array<Timeline> getTimelines() {
        return this.timelines;
    }

    public float getDuration() {
        return this.duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void apply(Skeleton skeleton, float lastTime, float time, boolean loop, Array<Event> events) {
        if (skeleton == null) {
            throw new IllegalArgumentException("skeleton cannot be null.");
        }
        if (loop && this.duration != 0.0f) {
            time %= this.duration;
            lastTime %= this.duration;
        }
        Array<Timeline> timelines = this.timelines;
        int n = timelines.size;
        for (int i = 0; i < n; i++) {
            ((Timeline) timelines.get(i)).apply(skeleton, lastTime, time, events, 1.0f);
        }
    }

    public void mix(Skeleton skeleton, float lastTime, float time, boolean loop, Array<Event> events, float alpha) {
        if (skeleton == null) {
            throw new IllegalArgumentException("skeleton cannot be null.");
        }
        if (loop && this.duration != 0.0f) {
            lastTime %= this.duration;
            time %= this.duration;
        }
        Array<Timeline> timelines = this.timelines;
        int n = timelines.size;
        for (int i = 0; i < n; i++) {
            ((Timeline) timelines.get(i)).apply(skeleton, lastTime, time, events, alpha);
        }
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    static int binarySearch(float[] values, float target, int step) {
        int low = 0;
        int high = (values.length / step) - 2;
        if (high == 0) {
            return step;
        }
        int current = high >>> 1;
        while (true) {
            if (values[(current + 1) * step] <= target) {
                low = current + 1;
            } else {
                high = current;
            }
            if (low == high) {
                return step * (low + 1);
            }
            current = (low + high) >>> 1;
        }
    }

    static int linearSearch(float[] values, float target, int step) {
        int i = 0;
        int last = values.length - step;
        while (i <= last) {
            if (values[i] > target) {
                return i;
            }
            i += step;
        }
        return -1;
    }
}
