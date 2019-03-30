package com.esotericsoftware.spine.attachments;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.Slot;

public class MeshAttachment extends Attachment {
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private int[] edges;
    private float height;
    private int hullLength;
    private String path;
    private TextureRegion region;
    private float[] regionUVs;
    private short[] triangles;
    private float[] vertices;
    private float width;
    private float[] worldVertices;

    public MeshAttachment(String name) {
        super(name);
    }

    public void setRegion(TextureRegion region) {
        if (region == null) {
            throw new IllegalArgumentException("region cannot be null.");
        }
        this.region = region;
    }

    public TextureRegion getRegion() {
        if (this.region != null) {
            return this.region;
        }
        throw new IllegalStateException("Region has not been set: " + this);
    }

    public void updateUVs() {
        float v;
        float u;
        float height;
        float width;
        int verticesLength = this.vertices.length;
        int worldVerticesLength = (verticesLength / 2) * 5;
        if (this.worldVertices == null || this.worldVertices.length != worldVerticesLength) {
            this.worldVertices = new float[worldVerticesLength];
        }
        if (this.region == null) {
            v = 0.0f;
            u = 0.0f;
            height = 1.0f;
            width = 1.0f;
        } else {
            u = this.region.getU();
            v = this.region.getV();
            width = this.region.getU2() - u;
            height = this.region.getV2() - v;
        }
        float[] regionUVs = this.regionUVs;
        int i;
        int w;
        if ((this.region instanceof AtlasRegion) && ((AtlasRegion) this.region).rotate) {
            i = 0;
            w = 3;
            while (i < verticesLength) {
                this.worldVertices[w] = (regionUVs[i + 1] * width) + u;
                this.worldVertices[w + 1] = (v + height) - (regionUVs[i] * height);
                i += 2;
                w += 5;
            }
            return;
        }
        i = 0;
        w = 3;
        while (i < verticesLength) {
            this.worldVertices[w] = (regionUVs[i] * width) + u;
            this.worldVertices[w + 1] = (regionUVs[i + 1] * height) + v;
            i += 2;
            w += 5;
        }
    }

    public void updateWorldVertices(Slot slot, boolean premultipliedAlpha) {
        Skeleton skeleton = slot.getSkeleton();
        Color skeletonColor = skeleton.getColor();
        Color slotColor = slot.getColor();
        Color meshColor = this.color;
        float a = ((skeletonColor.f37a * slotColor.f37a) * meshColor.f37a) * 255.0f;
        float multiplier = premultipliedAlpha ? a : 255.0f;
        float color = NumberUtils.intToFloatColor((((((int) a) << 24) | (((int) (((skeletonColor.f38b * slotColor.f38b) * meshColor.f38b) * multiplier)) << 16)) | (((int) (((skeletonColor.f39g * slotColor.f39g) * meshColor.f39g) * multiplier)) << 8)) | ((int) (((skeletonColor.f40r * slotColor.f40r) * meshColor.f40r) * multiplier)));
        float[] worldVertices = this.worldVertices;
        FloatArray slotVertices = slot.getAttachmentVertices();
        float[] vertices = this.vertices;
        if (slotVertices.size == vertices.length) {
            vertices = slotVertices.items;
        }
        Bone bone = slot.getBone();
        float x = skeleton.getX() + bone.getWorldX();
        float y = skeleton.getY() + bone.getWorldY();
        float m00 = bone.getM00();
        float m01 = bone.getM01();
        float m10 = bone.getM10();
        float m11 = bone.getM11();
        int v = 0;
        int n = worldVertices.length;
        for (int w = 0; w < n; w += 5) {
            float vx = vertices[v];
            float vy = vertices[v + 1];
            worldVertices[w] = ((vx * m00) + (vy * m01)) + x;
            worldVertices[w + 1] = ((vx * m10) + (vy * m11)) + y;
            worldVertices[w + 2] = color;
            v += 2;
        }
    }

    public float[] getWorldVertices() {
        return this.worldVertices;
    }

    public float[] getVertices() {
        return this.vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    public short[] getTriangles() {
        return this.triangles;
    }

    public void setTriangles(short[] triangles) {
        this.triangles = triangles;
    }

    public float[] getRegionUVs() {
        return this.regionUVs;
    }

    public void setRegionUVs(float[] regionUVs) {
        this.regionUVs = regionUVs;
    }

    public Color getColor() {
        return this.color;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getHullLength() {
        return this.hullLength;
    }

    public void setHullLength(int hullLength) {
        this.hullLength = hullLength;
    }

    public int[] getEdges() {
        return this.edges;
    }

    public void setEdges(int[] edges) {
        this.edges = edges;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
