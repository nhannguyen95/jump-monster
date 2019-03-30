package com.esotericsoftware.spine.attachments;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.Slot;

public class SkinnedMeshAttachment extends Attachment {
    private int[] bones;
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private int[] edges;
    private float height;
    private int hullLength;
    private String path;
    private TextureRegion region;
    private float[] regionUVs;
    private short[] triangles;
    private float[] weights;
    private float width;
    private float[] worldVertices;

    public SkinnedMeshAttachment(String name) {
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
        float[] regionUVs = this.regionUVs;
        int verticesLength = regionUVs.length;
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
        Color meshColor = slot.getColor();
        Color regionColor = this.color;
        float a = ((skeletonColor.f37a * meshColor.f37a) * regionColor.f37a) * 255.0f;
        float multiplier = premultipliedAlpha ? a : 255.0f;
        float color = NumberUtils.intToFloatColor((((((int) a) << 24) | (((int) (((skeletonColor.f38b * meshColor.f38b) * regionColor.f38b) * multiplier)) << 16)) | (((int) (((skeletonColor.f39g * meshColor.f39g) * regionColor.f39g) * multiplier)) << 8)) | ((int) (((skeletonColor.f40r * meshColor.f40r) * regionColor.f40r) * multiplier)));
        float[] worldVertices = this.worldVertices;
        float x = skeleton.getX();
        float y = skeleton.getY();
        Object[] skeletonBones = skeleton.getBones().items;
        float[] weights = this.weights;
        int[] bones = this.bones;
        FloatArray ffdArray = slot.getAttachmentVertices();
        int w;
        int b;
        int n;
        int v;
        int v2;
        float wx;
        float wy;
        int nn;
        if (ffdArray.size == 0) {
            w = 0;
            b = 0;
            n = bones.length;
            for (v = 0; v < n; v = v2) {
                wx = 0.0f;
                wy = 0.0f;
                v2 = v + 1;
                nn = bones[v] + v2;
                while (v2 < nn) {
                    Bone bone = skeletonBones[bones[v2]];
                    float vx = weights[b];
                    float vy = weights[b + 1];
                    float weight = weights[b + 2];
                    wx += (((bone.getM00() * vx) + (bone.getM01() * vy)) + bone.getWorldX()) * weight;
                    wy += (((bone.getM10() * vx) + (bone.getM11() * vy)) + bone.getWorldY()) * weight;
                    v2++;
                    b += 3;
                }
                worldVertices[w] = wx + x;
                worldVertices[w + 1] = wy + y;
                worldVertices[w + 2] = color;
                w += 5;
            }
            return;
        }
        float[] ffd = ffdArray.items;
        w = 0;
        b = 0;
        int f = 0;
        n = bones.length;
        for (v = 0; v < n; v = v2) {
            wx = 0.0f;
            wy = 0.0f;
            v2 = v + 1;
            nn = bones[v] + v2;
            while (v2 < nn) {
                bone = (Bone) skeletonBones[bones[v2]];
                vx = weights[b] + ffd[f];
                vy = weights[b + 1] + ffd[f + 1];
                weight = weights[b + 2];
                wx += (((bone.getM00() * vx) + (bone.getM01() * vy)) + bone.getWorldX()) * weight;
                wy += (((bone.getM10() * vx) + (bone.getM11() * vy)) + bone.getWorldY()) * weight;
                v2++;
                b += 3;
                f += 2;
            }
            worldVertices[w] = wx + x;
            worldVertices[w + 1] = wy + y;
            worldVertices[w + 2] = color;
            w += 5;
        }
    }

    public float[] getWorldVertices() {
        return this.worldVertices;
    }

    public int[] getBones() {
        return this.bones;
    }

    public void setBones(int[] bones) {
        this.bones = bones;
    }

    public float[] getWeights() {
        return this.weights;
    }

    public void setWeights(float[] weights) {
        this.weights = weights;
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

    public void setEdges(int[] edges) {
        this.edges = edges;
    }

    public int[] getEdges() {
        return this.edges;
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
