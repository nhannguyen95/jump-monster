package com.esotericsoftware.spine.attachments;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.Slot;

public class RegionSequenceAttachment extends RegionAttachment {
    /* renamed from: $SWITCH_TABLE$com$esotericsoftware$spine$attachments$RegionSequenceAttachment$Mode */
    private static /* synthetic */ int[] f178xda0edd57;
    private float frameTime;
    private Mode mode;
    private TextureRegion[] regions;

    public enum Mode {
        forward,
        backward,
        forwardLoop,
        backwardLoop,
        pingPong,
        random
    }

    /* renamed from: $SWITCH_TABLE$com$esotericsoftware$spine$attachments$RegionSequenceAttachment$Mode */
    static /* synthetic */ int[] m2614xda0edd57() {
        int[] iArr = f178xda0edd57;
        if (iArr == null) {
            iArr = new int[Mode.values().length];
            try {
                iArr[Mode.backward.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mode.backwardLoop.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.forward.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.forwardLoop.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.pingPong.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Mode.random.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            f178xda0edd57 = iArr;
        }
        return iArr;
    }

    public RegionSequenceAttachment(String name) {
        super(name);
    }

    public void updateWorldVertices(Slot slot, boolean premultipliedAlpha) {
        if (this.regions == null) {
            throw new IllegalStateException("Regions have not been set: " + this);
        }
        int frameIndex = (int) (slot.getAttachmentTime() / this.frameTime);
        switch (m2614xda0edd57()[this.mode.ordinal()]) {
            case 1:
                frameIndex = Math.min(this.regions.length - 1, frameIndex);
                break;
            case 2:
                frameIndex = Math.max((this.regions.length - frameIndex) - 1, 0);
                break;
            case 3:
                frameIndex %= this.regions.length;
                break;
            case 4:
                frameIndex = (this.regions.length - (frameIndex % this.regions.length)) - 1;
                break;
            case 5:
                frameIndex %= this.regions.length * 2;
                if (frameIndex >= this.regions.length) {
                    frameIndex = (this.regions.length - 1) - (frameIndex - this.regions.length);
                    break;
                }
                break;
            case 6:
                frameIndex = MathUtils.random(this.regions.length - 1);
                break;
        }
        setRegion(this.regions[frameIndex]);
        super.updateWorldVertices(slot, premultipliedAlpha);
    }

    public TextureRegion[] getRegions() {
        if (this.regions != null) {
            return this.regions;
        }
        throw new IllegalStateException("Regions have not been set: " + this);
    }

    public void setRegions(TextureRegion[] regions) {
        this.regions = regions;
    }

    public void setFrameTime(float frameTime) {
        this.frameTime = frameTime;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
