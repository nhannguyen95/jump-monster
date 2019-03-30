package com.esotericsoftware.spine;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DataInput;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.SerializationException;
import com.esotericsoftware.spine.Animation.AttachmentTimeline;
import com.esotericsoftware.spine.Animation.ColorTimeline;
import com.esotericsoftware.spine.Animation.CurveTimeline;
import com.esotericsoftware.spine.Animation.DrawOrderTimeline;
import com.esotericsoftware.spine.Animation.EventTimeline;
import com.esotericsoftware.spine.Animation.FfdTimeline;
import com.esotericsoftware.spine.Animation.RotateTimeline;
import com.esotericsoftware.spine.Animation.ScaleTimeline;
import com.esotericsoftware.spine.Animation.Timeline;
import com.esotericsoftware.spine.Animation.TranslateTimeline;
import com.esotericsoftware.spine.attachments.AtlasAttachmentLoader;
import com.esotericsoftware.spine.attachments.Attachment;
import com.esotericsoftware.spine.attachments.AttachmentLoader;
import com.esotericsoftware.spine.attachments.AttachmentType;
import com.esotericsoftware.spine.attachments.MeshAttachment;
import com.esotericsoftware.spine.attachments.SkinnedMeshAttachment;
import java.io.IOException;

public class SkeletonBinary {
    /* renamed from: $SWITCH_TABLE$com$esotericsoftware$spine$attachments$AttachmentType */
    private static /* synthetic */ int[] f90x63e53b5 = null;
    public static final int CURVE_BEZIER = 2;
    public static final int CURVE_LINEAR = 0;
    public static final int CURVE_STEPPED = 1;
    public static final int TIMELINE_ATTACHMENT = 3;
    public static final int TIMELINE_COLOR = 4;
    public static final int TIMELINE_DRAWORDER = 6;
    public static final int TIMELINE_EVENT = 5;
    public static final int TIMELINE_FFD = 7;
    public static final int TIMELINE_ROTATE = 1;
    public static final int TIMELINE_SCALE = 0;
    public static final int TIMELINE_TRANSLATE = 2;
    private static final Color tempColor = new Color();
    private final AttachmentLoader attachmentLoader;
    private float scale = 1.0f;

    /* renamed from: $SWITCH_TABLE$com$esotericsoftware$spine$attachments$AttachmentType */
    static /* synthetic */ int[] m0x63e53b5() {
        int[] iArr = f90x63e53b5;
        if (iArr == null) {
            iArr = new int[AttachmentType.values().length];
            try {
                iArr[AttachmentType.boundingbox.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AttachmentType.mesh.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AttachmentType.region.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AttachmentType.skinnedmesh.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f90x63e53b5 = iArr;
        }
        return iArr;
    }

    public SkeletonBinary(TextureAtlas atlas) {
        this.attachmentLoader = new AtlasAttachmentLoader(atlas);
    }

    public SkeletonBinary(AttachmentLoader attachmentLoader) {
        this.attachmentLoader = attachmentLoader;
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public SkeletonData readSkeletonData(FileHandle file) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null.");
        }
        float scale = this.scale;
        SkeletonData skeletonData = new SkeletonData();
        skeletonData.name = file.nameWithoutExtension();
        DataInput input = new DataInput(file.read(512));
        try {
            int i;
            boolean nonessential = input.readBoolean();
            int n = input.readInt(true);
            for (i = 0; i < n; i++) {
                String name = input.readString();
                BoneData parent = null;
                int parentIndex = input.readInt(true) - 1;
                if (parentIndex != -1) {
                    parent = (BoneData) skeletonData.bones.get(parentIndex);
                }
                BoneData boneData = new BoneData(name, parent);
                boneData.f86x = input.readFloat() * scale;
                boneData.f87y = input.readFloat() * scale;
                boneData.scaleX = input.readFloat();
                boneData.scaleY = input.readFloat();
                boneData.rotation = input.readFloat();
                boneData.length = input.readFloat() * scale;
                boneData.inheritScale = input.readBoolean();
                boneData.inheritRotation = input.readBoolean();
                if (nonessential) {
                    Color.rgba8888ToColor(boneData.getColor(), input.readInt());
                }
                skeletonData.addBone(boneData);
            }
            n = input.readInt(true);
            for (i = 0; i < n; i++) {
                SlotData slotData = new SlotData(input.readString(), (BoneData) skeletonData.bones.get(input.readInt(true)));
                Color.rgba8888ToColor(slotData.getColor(), input.readInt());
                slotData.attachmentName = input.readString();
                slotData.additiveBlending = input.readBoolean();
                skeletonData.addSlot(slotData);
            }
            Skin defaultSkin = readSkin(input, "default", nonessential);
            if (defaultSkin != null) {
                skeletonData.defaultSkin = defaultSkin;
                skeletonData.addSkin(defaultSkin);
            }
            n = input.readInt(true);
            for (i = 0; i < n; i++) {
                skeletonData.addSkin(readSkin(input, input.readString(), nonessential));
            }
            n = input.readInt(true);
            for (i = 0; i < n; i++) {
                EventData eventData = new EventData(input.readString());
                eventData.intValue = input.readInt(false);
                eventData.floatValue = input.readFloat();
                eventData.stringValue = input.readString();
                skeletonData.addEvent(eventData);
            }
            n = input.readInt(true);
            for (i = 0; i < n; i++) {
                readAnimation(input.readString(), input, skeletonData);
            }
            try {
                input.close();
            } catch (IOException e) {
            }
            skeletonData.bones.shrink();
            skeletonData.slots.shrink();
            skeletonData.skins.shrink();
            return skeletonData;
        } catch (IOException ex) {
            throw new SerializationException("Error reading skeleton file.", ex);
        } catch (Throwable th) {
            try {
                input.close();
            } catch (IOException e2) {
            }
        }
    }

    private Skin readSkin(DataInput input, String skinName, boolean nonessential) throws IOException {
        int slotCount = input.readInt(true);
        if (slotCount == 0) {
            return null;
        }
        Skin skin = new Skin(skinName);
        for (int i = 0; i < slotCount; i++) {
            int slotIndex = input.readInt(true);
            int nn = input.readInt(true);
            for (int ii = 0; ii < nn; ii++) {
                String name = input.readString();
                skin.addAttachment(slotIndex, name, readAttachment(input, skin, name, nonessential));
            }
        }
        return skin;
    }

    private Attachment readAttachment(DataInput input, Skin skin, String attachmentName, boolean nonessential) throws IOException {
        float scale = this.scale;
        String name = input.readString();
        if (name == null) {
            name = attachmentName;
        }
        String path;
        Attachment mesh;
        float[] uvs;
        short[] triangles;
        switch (m0x63e53b5()[AttachmentType.values()[input.readByte()].ordinal()]) {
            case 1:
                path = input.readString();
                if (path == null) {
                    path = name;
                }
                Attachment region = this.attachmentLoader.newRegionAttachment(skin, name, path);
                if (region == null) {
                    return null;
                }
                region.setPath(path);
                region.setX(input.readFloat() * scale);
                region.setY(input.readFloat() * scale);
                region.setScaleX(input.readFloat());
                region.setScaleY(input.readFloat());
                region.setRotation(input.readFloat());
                region.setWidth(input.readFloat() * scale);
                region.setHeight(input.readFloat() * scale);
                Color.rgba8888ToColor(region.getColor(), input.readInt());
                region.updateOffset();
                return region;
            case 2:
                Attachment box = this.attachmentLoader.newBoundingBoxAttachment(skin, name);
                if (box == null) {
                    return null;
                }
                box.setVertices(readFloatArray(input, scale));
                return box;
            case 3:
                path = input.readString();
                if (path == null) {
                    path = name;
                }
                mesh = this.attachmentLoader.newMeshAttachment(skin, name, path);
                if (mesh == null) {
                    return null;
                }
                mesh.setPath(path);
                uvs = readFloatArray(input, 1.0f);
                triangles = readShortArray(input);
                mesh.setVertices(readFloatArray(input, scale));
                mesh.setTriangles(triangles);
                mesh.setRegionUVs(uvs);
                mesh.updateUVs();
                Color.rgba8888ToColor(mesh.getColor(), input.readInt());
                mesh.setHullLength(input.readInt(true) * 2);
                if (!nonessential) {
                    return mesh;
                }
                mesh.setEdges(readIntArray(input));
                mesh.setWidth(input.readFloat() * scale);
                mesh.setHeight(input.readFloat() * scale);
                return mesh;
            case 4:
                path = input.readString();
                if (path == null) {
                    path = name;
                }
                mesh = this.attachmentLoader.newSkinnedMeshAttachment(skin, name, path);
                if (mesh == null) {
                    return null;
                }
                mesh.setPath(path);
                uvs = readFloatArray(input, 1.0f);
                triangles = readShortArray(input);
                int vertexCount = input.readInt(true);
                FloatArray weights = new FloatArray((uvs.length * 3) * 3);
                IntArray bones = new IntArray(uvs.length * 3);
                int i = 0;
                while (i < vertexCount) {
                    int boneCount = (int) input.readFloat();
                    bones.add(boneCount);
                    int nn = i + (boneCount * 4);
                    while (i < nn) {
                        bones.add((int) input.readFloat());
                        weights.add(input.readFloat() * scale);
                        weights.add(input.readFloat() * scale);
                        weights.add(input.readFloat());
                        i += 4;
                    }
                    i++;
                }
                mesh.setBones(bones.toArray());
                mesh.setWeights(weights.toArray());
                mesh.setTriangles(triangles);
                mesh.setRegionUVs(uvs);
                mesh.updateUVs();
                Color.rgba8888ToColor(mesh.getColor(), input.readInt());
                mesh.setHullLength(input.readInt(true) * 2);
                if (!nonessential) {
                    return mesh;
                }
                mesh.setEdges(readIntArray(input));
                mesh.setWidth(input.readFloat() * scale);
                mesh.setHeight(input.readFloat() * scale);
                return mesh;
            default:
                return null;
        }
    }

    private float[] readFloatArray(DataInput input, float scale) throws IOException {
        int n = input.readInt(true);
        float[] array = new float[n];
        int i;
        if (scale == 1.0f) {
            for (i = 0; i < n; i++) {
                array[i] = input.readFloat();
            }
        } else {
            for (i = 0; i < n; i++) {
                array[i] = input.readFloat() * scale;
            }
        }
        return array;
    }

    private short[] readShortArray(DataInput input) throws IOException {
        int n = input.readInt(true);
        short[] array = new short[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.readShort();
        }
        return array;
    }

    private int[] readIntArray(DataInput input) throws IOException {
        int n = input.readInt(true);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.readInt(true);
        }
        return array;
    }

    private void readAnimation(String name, DataInput input, SkeletonData skeletonData) {
        Array<Timeline> timelines = new Array();
        float scale = this.scale;
        float duration = 0.0f;
        try {
            int i;
            int slotIndex;
            int nn;
            int ii;
            int timelineType;
            int frameCount;
            EventTimeline timeline;
            int frameIndex;
            float time;
            int n = input.readInt(true);
            for (i = 0; i < n; i++) {
                slotIndex = input.readInt(true);
                nn = input.readInt(true);
                for (ii = 0; ii < nn; ii++) {
                    timelineType = input.readByte();
                    frameCount = input.readInt(true);
                    switch (timelineType) {
                        case 3:
                            timeline = new AttachmentTimeline(frameCount);
                            timeline.slotIndex = slotIndex;
                            for (frameIndex = 0; frameIndex < frameCount; frameIndex++) {
                                timeline.setFrame(frameIndex, input.readFloat(), input.readString());
                            }
                            timelines.add(timeline);
                            duration = Math.max(duration, timeline.getFrames()[frameCount - 1]);
                            break;
                        case 4:
                            timeline = new ColorTimeline(frameCount);
                            timeline.slotIndex = slotIndex;
                            for (frameIndex = 0; frameIndex < frameCount; frameIndex++) {
                                time = input.readFloat();
                                Color.rgba8888ToColor(tempColor, input.readInt());
                                timeline.setFrame(frameIndex, time, tempColor.f40r, tempColor.f39g, tempColor.f38b, tempColor.f37a);
                                if (frameIndex < frameCount - 1) {
                                    readCurve(input, frameIndex, timeline);
                                }
                            }
                            timelines.add(timeline);
                            duration = Math.max(duration, timeline.getFrames()[(frameCount * 5) - 5]);
                            break;
                        default:
                            break;
                    }
                }
            }
            n = input.readInt(true);
            for (i = 0; i < n; i++) {
                int boneIndex = input.readInt(true);
                nn = input.readInt(true);
                for (ii = 0; ii < nn; ii++) {
                    timelineType = input.readByte();
                    frameCount = input.readInt(true);
                    switch (timelineType) {
                        case 0:
                        case 2:
                            float timelineScale = 1.0f;
                            if (timelineType == 0) {
                                timeline = new ScaleTimeline(frameCount);
                            } else {
                                timeline = new TranslateTimeline(frameCount);
                                timelineScale = scale;
                            }
                            timeline.boneIndex = boneIndex;
                            for (frameIndex = 0; frameIndex < frameCount; frameIndex++) {
                                timeline.setFrame(frameIndex, input.readFloat(), input.readFloat() * timelineScale, input.readFloat() * timelineScale);
                                if (frameIndex < frameCount - 1) {
                                    readCurve(input, frameIndex, timeline);
                                }
                            }
                            timelines.add(timeline);
                            duration = Math.max(duration, timeline.getFrames()[(frameCount * 3) - 3]);
                            break;
                        case 1:
                            timeline = new RotateTimeline(frameCount);
                            timeline.boneIndex = boneIndex;
                            for (frameIndex = 0; frameIndex < frameCount; frameIndex++) {
                                timeline.setFrame(frameIndex, input.readFloat(), input.readFloat());
                                if (frameIndex < frameCount - 1) {
                                    readCurve(input, frameIndex, timeline);
                                }
                            }
                            timelines.add(timeline);
                            duration = Math.max(duration, timeline.getFrames()[(frameCount * 2) - 2]);
                            break;
                        default:
                            break;
                    }
                }
            }
            n = input.readInt(true);
            for (i = 0; i < n; i++) {
                Skin skin = (Skin) skeletonData.getSkins().get(input.readInt(true) + 1);
                nn = input.readInt(true);
                for (ii = 0; ii < nn; ii++) {
                    slotIndex = input.readInt(true);
                    int nnn = input.readInt(true);
                    for (int iii = 0; iii < nnn; iii++) {
                        Attachment attachment = skin.getAttachment(slotIndex, input.readString());
                        frameCount = input.readInt(true);
                        timeline = new FfdTimeline(frameCount);
                        timeline.slotIndex = slotIndex;
                        timeline.attachment = attachment;
                        for (frameIndex = 0; frameIndex < frameCount; frameIndex++) {
                            int vertexCount;
                            float[] vertices;
                            time = input.readFloat();
                            if (attachment instanceof MeshAttachment) {
                                vertexCount = ((MeshAttachment) attachment).getVertices().length;
                            } else {
                                vertexCount = (((SkinnedMeshAttachment) attachment).getWeights().length / 3) * 2;
                            }
                            int end = input.readInt(true);
                            if (end == 0) {
                                vertices = attachment instanceof MeshAttachment ? ((MeshAttachment) attachment).getVertices() : new float[vertexCount];
                            } else {
                                int v;
                                vertices = new float[vertexCount];
                                int start = input.readInt(true);
                                end += start;
                                if (scale == 1.0f) {
                                    for (v = start; v < end; v++) {
                                        vertices[v] = input.readFloat();
                                    }
                                } else {
                                    for (v = start; v < end; v++) {
                                        vertices[v] = input.readFloat() * scale;
                                    }
                                }
                                if (attachment instanceof MeshAttachment) {
                                    float[] meshVertices = ((MeshAttachment) attachment).getVertices();
                                    int vn = vertices.length;
                                    for (v = 0; v < vn; v++) {
                                        vertices[v] = vertices[v] + meshVertices[v];
                                    }
                                }
                            }
                            timeline.setFrame(frameIndex, time, vertices);
                            if (frameIndex < frameCount - 1) {
                                readCurve(input, frameIndex, timeline);
                            }
                        }
                        timelines.add(timeline);
                        duration = Math.max(duration, timeline.getFrames()[frameCount - 1]);
                    }
                }
            }
            int drawOrderCount = input.readInt(true);
            if (drawOrderCount > 0) {
                timeline = new DrawOrderTimeline(drawOrderCount);
                int slotCount = skeletonData.slots.size;
                for (i = 0; i < drawOrderCount; i++) {
                    int i2;
                    int originalIndex;
                    int offsetCount = input.readInt(true);
                    int[] drawOrder = new int[slotCount];
                    for (ii = slotCount - 1; ii >= 0; ii--) {
                        drawOrder[ii] = -1;
                    }
                    int[] unchanged = new int[(slotCount - offsetCount)];
                    int originalIndex2 = 0;
                    int unchangedIndex = 0;
                    ii = 0;
                    while (ii < offsetCount) {
                        slotIndex = input.readInt(true);
                        i2 = unchangedIndex;
                        originalIndex = originalIndex2;
                        while (originalIndex != slotIndex) {
                            unchangedIndex = i2 + 1;
                            originalIndex2 = originalIndex + 1;
                            unchanged[i2] = originalIndex;
                            i2 = unchangedIndex;
                            originalIndex = originalIndex2;
                        }
                        originalIndex2 = originalIndex + 1;
                        drawOrder[input.readInt(true) + originalIndex] = originalIndex;
                        ii++;
                        unchangedIndex = i2;
                    }
                    i2 = unchangedIndex;
                    originalIndex = originalIndex2;
                    while (originalIndex < slotCount) {
                        unchangedIndex = i2 + 1;
                        originalIndex2 = originalIndex + 1;
                        unchanged[i2] = originalIndex;
                        i2 = unchangedIndex;
                        originalIndex = originalIndex2;
                    }
                    unchangedIndex = i2;
                    for (ii = slotCount - 1; ii >= 0; ii--) {
                        if (drawOrder[ii] == -1) {
                            unchangedIndex--;
                            drawOrder[ii] = unchanged[unchangedIndex];
                        }
                    }
                    timeline.setFrame(i, input.readFloat(), drawOrder);
                }
                timelines.add(timeline);
                duration = Math.max(duration, timeline.getFrames()[drawOrderCount - 1]);
            }
            int eventCount = input.readInt(true);
            if (eventCount > 0) {
                timeline = new EventTimeline(eventCount);
                for (i = 0; i < eventCount; i++) {
                    time = input.readFloat();
                    EventData eventData = (EventData) skeletonData.events.get(input.readInt(true));
                    Event event = new Event(eventData);
                    event.intValue = input.readInt(false);
                    event.floatValue = input.readFloat();
                    event.stringValue = input.readBoolean() ? input.readString() : eventData.stringValue;
                    timeline.setFrame(i, time, event);
                }
                timelines.add(timeline);
                duration = Math.max(duration, timeline.getFrames()[eventCount - 1]);
            }
            timelines.shrink();
            skeletonData.addAnimation(new Animation(name, timelines, duration));
        } catch (Throwable ex) {
            throw new SerializationException("Error reading skeleton file.", ex);
        }
    }

    private void readCurve(DataInput input, int frameIndex, CurveTimeline timeline) throws IOException {
        switch (input.readByte()) {
            case (byte) 1:
                timeline.setStepped(frameIndex);
                return;
            case (byte) 2:
                setCurve(timeline, frameIndex, input.readFloat(), input.readFloat(), input.readFloat(), input.readFloat());
                return;
            default:
                return;
        }
    }

    void setCurve(CurveTimeline timeline, int frameIndex, float cx1, float cy1, float cx2, float cy2) {
        timeline.setCurve(frameIndex, cx1, cy1, cx2, cy2);
    }
}
