package com.esotericsoftware.spine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.esotericsoftware.spine.attachments.Attachment;
import com.esotericsoftware.spine.attachments.MeshAttachment;
import com.esotericsoftware.spine.attachments.RegionAttachment;
import com.esotericsoftware.spine.attachments.SkinnedMeshAttachment;

public class SkeletonRendererDebug {
    private static final Color aabbColor = new Color(0.0f, 1.0f, 0.0f, 0.5f);
    private static final Color attachmentLineColor = new Color(0.0f, 0.0f, 1.0f, 0.5f);
    private static final Color boneLineColor = Color.RED;
    private static final Color boneOriginColor = Color.GREEN;
    private static final Color boundingBoxColor = new Color(0.0f, 1.0f, 0.0f, 0.8f);
    private static final Color triangleLineColor = new Color(1.0f, 0.64f, 0.0f, 0.5f);
    private final SkeletonBounds bounds;
    private boolean drawBones;
    private boolean drawBoundingBoxes;
    private boolean drawMeshHull;
    private boolean drawMeshTriangles;
    private boolean drawRegionAttachments;
    private float scale;
    private final ShapeRenderer shapes;

    public SkeletonRendererDebug() {
        this.drawBones = true;
        this.drawRegionAttachments = true;
        this.drawBoundingBoxes = true;
        this.drawMeshHull = true;
        this.drawMeshTriangles = true;
        this.bounds = new SkeletonBounds();
        this.scale = 1.0f;
        this.shapes = new ShapeRenderer();
    }

    public SkeletonRendererDebug(ShapeRenderer shapes) {
        this.drawBones = true;
        this.drawRegionAttachments = true;
        this.drawBoundingBoxes = true;
        this.drawMeshHull = true;
        this.drawMeshTriangles = true;
        this.bounds = new SkeletonBounds();
        this.scale = 1.0f;
        this.shapes = shapes;
    }

    public void draw(Skeleton skeleton) {
        int n;
        int i;
        Bone bone;
        Array<Slot> slots;
        Slot slot;
        Attachment attachment;
        float skeletonX = skeleton.getX();
        float skeletonY = skeleton.getY();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        ShapeRenderer shapes = this.shapes;
        shapes.begin(ShapeType.Line);
        Array<Bone> bones = skeleton.getBones();
        if (this.drawBones) {
            shapes.setColor(boneLineColor);
            n = bones.size;
            for (i = 0; i < n; i++) {
                bone = (Bone) bones.get(i);
                if (bone.parent != null) {
                    shapes.line(bone.worldX + skeletonX, bone.worldY + skeletonY, ((bone.data.length * bone.m00) + skeletonX) + bone.worldX, ((bone.data.length * bone.m10) + skeletonY) + bone.worldY);
                }
            }
            shapes.m1527x(skeletonX, skeletonY, 4.0f * this.scale);
        }
        if (this.drawRegionAttachments) {
            shapes.setColor(attachmentLineColor);
            slots = skeleton.getSlots();
            n = slots.size;
            for (i = 0; i < n; i++) {
                slot = (Slot) slots.get(i);
                attachment = slot.attachment;
                if (attachment instanceof RegionAttachment) {
                    RegionAttachment regionAttachment = (RegionAttachment) attachment;
                    regionAttachment.updateWorldVertices(slot, false);
                    float[] vertices = regionAttachment.getWorldVertices();
                    shapes.line(vertices[0], vertices[1], vertices[5], vertices[6]);
                    shapes.line(vertices[5], vertices[6], vertices[10], vertices[11]);
                    shapes.line(vertices[10], vertices[11], vertices[15], vertices[16]);
                    shapes.line(vertices[15], vertices[16], vertices[0], vertices[1]);
                }
            }
        }
        if (this.drawMeshHull || this.drawMeshTriangles) {
            slots = skeleton.getSlots();
            n = slots.size;
            for (i = 0; i < n; i++) {
                slot = (Slot) slots.get(i);
                attachment = slot.attachment;
                vertices = null;
                short[] triangles = null;
                int hullLength = 0;
                if (attachment instanceof MeshAttachment) {
                    MeshAttachment mesh = (MeshAttachment) attachment;
                    mesh.updateWorldVertices(slot, false);
                    vertices = mesh.getWorldVertices();
                    triangles = mesh.getTriangles();
                    hullLength = mesh.getHullLength();
                } else if (attachment instanceof SkinnedMeshAttachment) {
                    SkinnedMeshAttachment mesh2 = (SkinnedMeshAttachment) attachment;
                    mesh2.updateWorldVertices(slot, false);
                    vertices = mesh2.getWorldVertices();
                    triangles = mesh2.getTriangles();
                    hullLength = mesh2.getHullLength();
                }
                if (!(vertices == null || triangles == null)) {
                    int nn;
                    int ii;
                    if (this.drawMeshTriangles) {
                        shapes.setColor(triangleLineColor);
                        nn = triangles.length;
                        for (ii = 0; ii < nn; ii += 3) {
                            int v1 = triangles[ii] * 5;
                            int v2 = triangles[ii + 1] * 5;
                            int v3 = triangles[ii + 2] * 5;
                            shapes.triangle(vertices[v1], vertices[v1 + 1], vertices[v2], vertices[v2 + 1], vertices[v3], vertices[v3 + 1]);
                        }
                    }
                    if (this.drawMeshHull && hullLength > 0) {
                        shapes.setColor(attachmentLineColor);
                        hullLength = (hullLength / 2) * 5;
                        float lastX = vertices[hullLength - 5];
                        float lastY = vertices[hullLength - 4];
                        nn = hullLength;
                        for (ii = 0; ii < nn; ii += 5) {
                            float x = vertices[ii];
                            float y = vertices[ii + 1];
                            shapes.line(x, y, lastX, lastY);
                            lastX = x;
                            lastY = y;
                        }
                    }
                }
            }
        }
        if (this.drawBoundingBoxes) {
            SkeletonBounds bounds = this.bounds;
            bounds.update(skeleton, true);
            shapes.setColor(aabbColor);
            shapes.rect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
            shapes.setColor(boundingBoxColor);
            Array<FloatArray> polygons = bounds.getPolygons();
            n = polygons.size;
            for (i = 0; i < n; i++) {
                FloatArray polygon = (FloatArray) polygons.get(i);
                shapes.polygon(polygon.items, 0, polygon.size);
            }
        }
        shapes.end();
        shapes.begin(ShapeType.Filled);
        if (this.drawBones) {
            shapes.setColor(boneOriginColor);
            n = bones.size;
            for (i = 0; i < n; i++) {
                bone = (Bone) bones.get(i);
                shapes.setColor(Color.GREEN);
                shapes.circle(bone.worldX + skeletonX, bone.worldY + skeletonY, 3.0f * this.scale, 8);
            }
        }
        shapes.end();
    }

    public ShapeRenderer getShapeRenderer() {
        return this.shapes;
    }

    public void setBones(boolean bones) {
        this.drawBones = bones;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setRegionAttachments(boolean regionAttachments) {
        this.drawRegionAttachments = regionAttachments;
    }

    public void setBoundingBoxes(boolean boundingBoxes) {
        this.drawBoundingBoxes = boundingBoxes;
    }

    public void setMeshHull(boolean meshHull) {
        this.drawMeshHull = meshHull;
    }

    public void setMeshTriangles(boolean meshTriangles) {
        this.drawMeshTriangles = meshTriangles;
    }
}
