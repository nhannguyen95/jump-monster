package com.esotericsoftware.spine;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
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

public class SkeletonJson {
    /* renamed from: $SWITCH_TABLE$com$esotericsoftware$spine$attachments$AttachmentType */
    private static /* synthetic */ int[] f91x63e53b5;
    private final AttachmentLoader attachmentLoader;
    private float scale = 1.0f;

    /* renamed from: $SWITCH_TABLE$com$esotericsoftware$spine$attachments$AttachmentType */
    static /* synthetic */ int[] m1x63e53b5() {
        int[] iArr = f91x63e53b5;
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
            f91x63e53b5 = iArr;
        }
        return iArr;
    }

    public SkeletonJson(TextureAtlas atlas) {
        this.attachmentLoader = new AtlasAttachmentLoader(atlas);
    }

    public SkeletonJson(AttachmentLoader attachmentLoader) {
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
        JsonValue root = new JsonReader().parse(file);
        for (JsonValue boneMap = root.getChild("bones"); boneMap != null; boneMap = boneMap.next) {
            BoneData parent = null;
            String parentName = boneMap.getString("parent", null);
            if (parentName != null) {
                parent = skeletonData.findBone(parentName);
                if (parent == null) {
                    throw new SerializationException("Parent bone not found: " + parentName);
                }
            }
            BoneData boneData = new BoneData(boneMap.getString("name"), parent);
            boneData.length = boneMap.getFloat("length", 0.0f) * scale;
            boneData.f86x = boneMap.getFloat("x", 0.0f) * scale;
            boneData.f87y = boneMap.getFloat("y", 0.0f) * scale;
            boneData.rotation = boneMap.getFloat("rotation", 0.0f);
            boneData.scaleX = boneMap.getFloat("scaleX", 1.0f);
            boneData.scaleY = boneMap.getFloat("scaleY", 1.0f);
            boneData.inheritScale = boneMap.getBoolean("inheritScale", true);
            boneData.inheritRotation = boneMap.getBoolean("inheritRotation", true);
            String color = boneMap.getString("color", null);
            if (color != null) {
                boneData.getColor().set(Color.valueOf(color));
            }
            skeletonData.addBone(boneData);
        }
        for (JsonValue slotMap = root.getChild("slots"); slotMap != null; slotMap = slotMap.next) {
            String slotName = slotMap.getString("name");
            String boneName = slotMap.getString("bone");
            boneData = skeletonData.findBone(boneName);
            if (boneData == null) {
                throw new SerializationException("Slot bone not found: " + boneName);
            }
            SlotData slotData = new SlotData(slotName, boneData);
            color = slotMap.getString("color", null);
            if (color != null) {
                slotData.getColor().set(Color.valueOf(color));
            }
            slotData.attachmentName = slotMap.getString("attachment", null);
            slotData.additiveBlending = slotMap.getBoolean("additive", false);
            skeletonData.addSlot(slotData);
        }
        for (JsonValue skinMap = root.getChild("skins"); skinMap != null; skinMap = skinMap.next) {
            Skin skin = new Skin(skinMap.name);
            for (JsonValue slotEntry = skinMap.child; slotEntry != null; slotEntry = slotEntry.next) {
                int slotIndex = skeletonData.findSlotIndex(slotEntry.name);
                if (slotIndex == -1) {
                    throw new SerializationException("Slot not found: " + slotEntry.name);
                }
                for (JsonValue entry = slotEntry.child; entry != null; entry = entry.next) {
                    Attachment attachment = readAttachment(skin, entry.name, entry);
                    if (attachment != null) {
                        skin.addAttachment(slotIndex, entry.name, attachment);
                    }
                }
            }
            skeletonData.addSkin(skin);
            if (skin.name.equals("default")) {
                skeletonData.defaultSkin = skin;
            }
        }
        for (JsonValue eventMap = root.getChild("events"); eventMap != null; eventMap = eventMap.next) {
            EventData eventData = new EventData(eventMap.name);
            eventData.intValue = eventMap.getInt("int", 0);
            eventData.floatValue = eventMap.getFloat("float", 0.0f);
            eventData.stringValue = eventMap.getString("string", null);
            skeletonData.addEvent(eventData);
        }
        for (JsonValue animationMap = root.getChild("animations"); animationMap != null; animationMap = animationMap.next) {
            readAnimation(animationMap.name, animationMap, skeletonData);
        }
        skeletonData.bones.shrink();
        skeletonData.slots.shrink();
        skeletonData.skins.shrink();
        skeletonData.animations.shrink();
        return skeletonData;
    }

    private Attachment readAttachment(Skin skin, String name, JsonValue map) {
        float scale = this.scale;
        name = map.getString("name", name);
        String path = map.getString("path", name);
        float[] vertices;
        int n;
        int i;
        Attachment mesh;
        switch (m1x63e53b5()[AttachmentType.valueOf(map.getString("type", AttachmentType.region.name())).ordinal()]) {
            case 1:
                Attachment region = this.attachmentLoader.newRegionAttachment(skin, name, path);
                if (region == null) {
                    return null;
                }
                region.setPath(path);
                region.setX(map.getFloat("x", 0.0f) * scale);
                region.setY(map.getFloat("y", 0.0f) * scale);
                region.setScaleX(map.getFloat("scaleX", 1.0f));
                region.setScaleY(map.getFloat("scaleY", 1.0f));
                region.setRotation(map.getFloat("rotation", 0.0f));
                region.setWidth(map.getFloat("width") * scale);
                region.setHeight(map.getFloat("height") * scale);
                String color = map.getString("color", null);
                if (color != null) {
                    region.getColor().set(Color.valueOf(color));
                }
                region.updateOffset();
                return region;
            case 2:
                Attachment box = this.attachmentLoader.newBoundingBoxAttachment(skin, name);
                if (box == null) {
                    return null;
                }
                vertices = map.require("vertices").asFloatArray();
                if (scale != 1.0f) {
                    n = vertices.length;
                    for (i = 0; i < n; i++) {
                        vertices[i] = vertices[i] * scale;
                    }
                }
                box.setVertices(vertices);
                return box;
            case 3:
                mesh = this.attachmentLoader.newMeshAttachment(skin, name, path);
                if (mesh == null) {
                    return null;
                }
                mesh.setPath(path);
                vertices = map.require("vertices").asFloatArray();
                if (scale != 1.0f) {
                    n = vertices.length;
                    for (i = 0; i < n; i++) {
                        vertices[i] = vertices[i] * scale;
                    }
                }
                mesh.setVertices(vertices);
                mesh.setTriangles(map.require("triangles").asShortArray());
                mesh.setRegionUVs(map.require("uvs").asFloatArray());
                mesh.updateUVs();
                if (map.has("hull")) {
                    mesh.setHullLength(map.require("hull").asInt() * 2);
                }
                if (map.has("edges")) {
                    mesh.setEdges(map.require("edges").asIntArray());
                }
                mesh.setWidth(map.getFloat("width", 0.0f) * scale);
                mesh.setHeight(map.getFloat("height", 0.0f) * scale);
                return mesh;
            case 4:
                mesh = this.attachmentLoader.newSkinnedMeshAttachment(skin, name, path);
                if (mesh == null) {
                    return null;
                }
                mesh.setPath(path);
                float[] uvs = map.require("uvs").asFloatArray();
                vertices = map.require("vertices").asFloatArray();
                FloatArray weights = new FloatArray((uvs.length * 3) * 3);
                IntArray bones = new IntArray(uvs.length * 3);
                n = vertices.length;
                int i2 = 0;
                while (i2 < n) {
                    i = i2 + 1;
                    int boneCount = (int) vertices[i2];
                    bones.add(boneCount);
                    int nn = i + (boneCount * 4);
                    while (i < nn) {
                        bones.add((int) vertices[i]);
                        weights.add(vertices[i + 1] * scale);
                        weights.add(vertices[i + 2] * scale);
                        weights.add(vertices[i + 3]);
                        i += 4;
                    }
                    i2 = i;
                }
                mesh.setBones(bones.toArray());
                mesh.setWeights(weights.toArray());
                mesh.setTriangles(map.require("triangles").asShortArray());
                mesh.setRegionUVs(uvs);
                mesh.updateUVs();
                if (map.has("hull")) {
                    mesh.setHullLength(map.require("hull").asInt() * 2);
                }
                if (map.has("edges")) {
                    mesh.setEdges(map.require("edges").asIntArray());
                }
                mesh.setWidth(map.getFloat("width", 0.0f) * scale);
                mesh.setHeight(map.getFloat("height", 0.0f) * scale);
                return mesh;
            default:
                return null;
        }
    }

    private void readAnimation(String name, JsonValue map, SkeletonData skeletonData) {
        JsonValue slotMap;
        int frameIndex;
        JsonValue valueMap;
        float scale = this.scale;
        Array<Timeline> timelines = new Array();
        float duration = 0.0f;
        for (slotMap = map.getChild("slots"); slotMap != null; slotMap = slotMap.next) {
            int slotIndex = skeletonData.findSlotIndex(slotMap.name);
            if (slotIndex == -1) {
                throw new SerializationException("Slot not found: " + slotMap.name);
            }
            JsonValue timelineMap;
            for (timelineMap = slotMap.child; timelineMap != null; timelineMap = timelineMap.next) {
                EventTimeline timeline;
                int i;
                String timelineName = timelineMap.name;
                if (timelineName.equals("color")) {
                    timeline = new ColorTimeline(timelineMap.size);
                    timeline.slotIndex = slotIndex;
                    frameIndex = 0;
                    for (valueMap = timelineMap.child; valueMap != null; valueMap = valueMap.next) {
                        Color color = Color.valueOf(valueMap.getString("color"));
                        timeline.setFrame(frameIndex, valueMap.getFloat("time"), color.f40r, color.f39g, color.f38b, color.f37a);
                        readCurve(timeline, frameIndex, valueMap);
                        frameIndex++;
                    }
                    timelines.add(timeline);
                    duration = Math.max(duration, timeline.getFrames()[(timeline.getFrameCount() * 5) - 5]);
                } else {
                    if (timelineName.equals("attachment")) {
                        timeline = new AttachmentTimeline(timelineMap.size);
                        timeline.slotIndex = slotIndex;
                        valueMap = timelineMap.child;
                        i = 0;
                        while (valueMap != null) {
                            frameIndex = i + 1;
                            timeline.setFrame(i, valueMap.getFloat("time"), valueMap.getString("name"));
                            valueMap = valueMap.next;
                            i = frameIndex;
                        }
                        timelines.add(timeline);
                        duration = Math.max(duration, timeline.getFrames()[timeline.getFrameCount() - 1]);
                        frameIndex = i;
                    } else {
                        throw new RuntimeException("Invalid timeline type for a slot: " + timelineName + " (" + slotMap.name + ")");
                    }
                }
            }
        }
        for (JsonValue boneMap = map.getChild("bones"); boneMap != null; boneMap = boneMap.next) {
            int boneIndex = skeletonData.findBoneIndex(boneMap.name);
            if (boneIndex == -1) {
                throw new SerializationException("Bone not found: " + boneMap.name);
            }
            for (timelineMap = boneMap.child; timelineMap != null; timelineMap = timelineMap.next) {
                timelineName = timelineMap.name;
                if (timelineName.equals("rotate")) {
                    timeline = new RotateTimeline(timelineMap.size);
                    timeline.boneIndex = boneIndex;
                    frameIndex = 0;
                    for (valueMap = timelineMap.child; valueMap != null; valueMap = valueMap.next) {
                        timeline.setFrame(frameIndex, valueMap.getFloat("time"), valueMap.getFloat("angle"));
                        readCurve(timeline, frameIndex, valueMap);
                        frameIndex++;
                    }
                    timelines.add(timeline);
                    duration = Math.max(duration, timeline.getFrames()[(timeline.getFrameCount() * 2) - 2]);
                } else {
                    if (!timelineName.equals("translate")) {
                        if (!timelineName.equals("scale")) {
                            throw new RuntimeException("Invalid timeline type for a bone: " + timelineName + " (" + boneMap.name + ")");
                        }
                    }
                    float timelineScale = 1.0f;
                    if (timelineName.equals("scale")) {
                        timeline = new ScaleTimeline(timelineMap.size);
                    } else {
                        timeline = new TranslateTimeline(timelineMap.size);
                        timelineScale = scale;
                    }
                    timeline.boneIndex = boneIndex;
                    frameIndex = 0;
                    for (valueMap = timelineMap.child; valueMap != null; valueMap = valueMap.next) {
                        timeline.setFrame(frameIndex, valueMap.getFloat("time"), valueMap.getFloat("x", 0.0f) * timelineScale, valueMap.getFloat("y", 0.0f) * timelineScale);
                        readCurve(timeline, frameIndex, valueMap);
                        frameIndex++;
                    }
                    timelines.add(timeline);
                    duration = Math.max(duration, timeline.getFrames()[(timeline.getFrameCount() * 3) - 3]);
                }
            }
        }
        for (JsonValue ffdMap = map.getChild("ffd"); ffdMap != null; ffdMap = ffdMap.next) {
            Skin skin = skeletonData.findSkin(ffdMap.name);
            if (skin == null) {
                throw new SerializationException("Skin not found: " + ffdMap.name);
            }
            for (slotMap = ffdMap.child; slotMap != null; slotMap = slotMap.next) {
                slotIndex = skeletonData.findSlotIndex(slotMap.name);
                if (slotIndex == -1) {
                    throw new SerializationException("Slot not found: " + slotMap.name);
                }
                for (JsonValue meshMap = slotMap.child; meshMap != null; meshMap = meshMap.next) {
                    timeline = new FfdTimeline(meshMap.size);
                    Attachment attachment = skin.getAttachment(slotIndex, meshMap.name);
                    if (attachment == null) {
                        throw new SerializationException("FFD attachment not found: " + meshMap.name);
                    }
                    int vertexCount;
                    timeline.slotIndex = slotIndex;
                    timeline.attachment = attachment;
                    if (attachment instanceof MeshAttachment) {
                        vertexCount = ((MeshAttachment) attachment).getVertices().length;
                    } else {
                        vertexCount = (((SkinnedMeshAttachment) attachment).getWeights().length / 3) * 2;
                    }
                    frameIndex = 0;
                    for (valueMap = meshMap.child; valueMap != null; valueMap = valueMap.next) {
                        float[] vertices;
                        int i2;
                        JsonValue verticesValue = valueMap.get("vertices");
                        if (verticesValue == null) {
                            vertices = attachment instanceof MeshAttachment ? ((MeshAttachment) attachment).getVertices() : new float[vertexCount];
                        } else {
                            Object vertices2 = new float[vertexCount];
                            int start = valueMap.getInt("offset", 0);
                            System.arraycopy(verticesValue.asFloatArray(), 0, vertices2, start, verticesValue.size);
                            if (scale != 1.0f) {
                                i2 = start;
                                int n = i2 + verticesValue.size;
                                while (i2 < n) {
                                    vertices2[i2] = vertices2[i2] * scale;
                                    i2++;
                                }
                            }
                            if (attachment instanceof MeshAttachment) {
                                float[] meshVertices = ((MeshAttachment) attachment).getVertices();
                                for (i2 = 0; i2 < vertexCount; i2++) {
                                    vertices2[i2] = vertices2[i2] + meshVertices[i2];
                                }
                            }
                        }
                        timeline.setFrame(frameIndex, valueMap.getFloat("time"), vertices);
                        readCurve(timeline, frameIndex, valueMap);
                        frameIndex++;
                    }
                    timelines.add(timeline);
                    duration = Math.max(duration, timeline.getFrames()[timeline.getFrameCount() - 1]);
                }
            }
        }
        JsonValue drawOrdersMap = map.get("draworder");
        if (drawOrdersMap != null) {
            timeline = new DrawOrderTimeline(drawOrdersMap.size);
            int slotCount = skeletonData.slots.size;
            JsonValue drawOrderMap = drawOrdersMap.child;
            i = 0;
            while (drawOrderMap != null) {
                int[] drawOrder = null;
                JsonValue offsets = drawOrderMap.get("offsets");
                if (offsets != null) {
                    int unchangedIndex;
                    int originalIndex;
                    drawOrder = new int[slotCount];
                    for (i2 = slotCount - 1; i2 >= 0; i2--) {
                        drawOrder[i2] = -1;
                    }
                    int[] unchanged = new int[(slotCount - offsets.size)];
                    int originalIndex2 = 0;
                    int unchangedIndex2 = 0;
                    JsonValue offsetMap = offsets.child;
                    while (offsetMap != null) {
                        slotIndex = skeletonData.findSlotIndex(offsetMap.getString("slot"));
                        if (slotIndex == -1) {
                            throw new SerializationException("Slot not found: " + offsetMap.getString("slot"));
                        }
                        while (true) {
                            unchangedIndex = unchangedIndex2;
                            originalIndex = originalIndex2;
                            if (originalIndex == slotIndex) {
                                break;
                            }
                            unchangedIndex2 = unchangedIndex + 1;
                            originalIndex2 = originalIndex + 1;
                            unchanged[unchangedIndex] = originalIndex;
                        }
                        originalIndex2 = originalIndex + 1;
                        drawOrder[offsetMap.getInt("offset") + originalIndex] = originalIndex;
                        offsetMap = offsetMap.next;
                        unchangedIndex2 = unchangedIndex;
                    }
                    unchangedIndex = unchangedIndex2;
                    originalIndex = originalIndex2;
                    while (originalIndex < slotCount) {
                        unchangedIndex2 = unchangedIndex + 1;
                        originalIndex2 = originalIndex + 1;
                        unchanged[unchangedIndex] = originalIndex;
                        unchangedIndex = unchangedIndex2;
                        originalIndex = originalIndex2;
                    }
                    unchangedIndex2 = unchangedIndex;
                    for (i2 = slotCount - 1; i2 >= 0; i2--) {
                        if (drawOrder[i2] == -1) {
                            unchangedIndex2--;
                            drawOrder[i2] = unchanged[unchangedIndex2];
                        }
                    }
                }
                frameIndex = i + 1;
                timeline.setFrame(i, drawOrderMap.getFloat("time"), drawOrder);
                drawOrderMap = drawOrderMap.next;
                i = frameIndex;
            }
            timelines.add(timeline);
            duration = Math.max(duration, timeline.getFrames()[timeline.getFrameCount() - 1]);
        }
        JsonValue eventsMap = map.get("events");
        if (eventsMap != null) {
            timeline = new EventTimeline(eventsMap.size);
            JsonValue eventMap = eventsMap.child;
            i = 0;
            while (eventMap != null) {
                EventData eventData = skeletonData.findEvent(eventMap.getString("name"));
                if (eventData == null) {
                    throw new SerializationException("Event not found: " + eventMap.getString("name"));
                }
                Event event = new Event(eventData);
                event.intValue = eventMap.getInt("int", eventData.getInt());
                event.floatValue = eventMap.getFloat("float", eventData.getFloat());
                event.stringValue = eventMap.getString("string", eventData.getString());
                frameIndex = i + 1;
                timeline.setFrame(i, eventMap.getFloat("time"), event);
                eventMap = eventMap.next;
                i = frameIndex;
            }
            timelines.add(timeline);
            duration = Math.max(duration, timeline.getFrames()[timeline.getFrameCount() - 1]);
        }
        timelines.shrink();
        skeletonData.addAnimation(new Animation(name, timelines, duration));
    }

    void readCurve(CurveTimeline timeline, int frameIndex, JsonValue valueMap) {
        JsonValue curve = valueMap.get("curve");
        if (curve != null) {
            if (curve.isString() && curve.asString().equals("stepped")) {
                timeline.setStepped(frameIndex);
            } else if (curve.isArray()) {
                timeline.setCurve(frameIndex, curve.getFloat(0), curve.getFloat(1), curve.getFloat(2), curve.getFloat(3));
            }
        }
    }
}
