package com.esotericsoftware.spine;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.attachments.Attachment;
import com.esotericsoftware.spine.attachments.MeshAttachment;
import com.esotericsoftware.spine.attachments.RegionAttachment;
import com.esotericsoftware.spine.attachments.SkeletonAttachment;
import com.esotericsoftware.spine.attachments.SkinnedMeshAttachment;

public class SkeletonRenderer {
    private static final short[] quadTriangles;
    private boolean premultipliedAlpha;

    static {
        short[] sArr = new short[6];
        sArr[1] = (short) 1;
        sArr[2] = (short) 2;
        sArr[3] = (short) 2;
        sArr[4] = (short) 3;
        quadTriangles = sArr;
    }

    public void draw(PolygonSpriteBatch batch, Skeleton skeleton) {
        boolean premultipliedAlpha = this.premultipliedAlpha;
        int srcFunc = premultipliedAlpha ? 1 : GL20.GL_SRC_ALPHA;
        batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);
        boolean additive = false;
        float[] vertices = null;
        short[] triangles = null;
        Array<Slot> drawOrder = skeleton.drawOrder;
        int n = drawOrder.size;
        for (int i = 0; i < n; i++) {
            Slot slot = (Slot) drawOrder.get(i);
            Attachment attachment = slot.attachment;
            Texture texture = null;
            if (attachment instanceof RegionAttachment) {
                RegionAttachment region = (RegionAttachment) attachment;
                region.updateWorldVertices(slot, premultipliedAlpha);
                vertices = region.getWorldVertices();
                triangles = quadTriangles;
                texture = region.getRegion().getTexture();
            } else if (attachment instanceof MeshAttachment) {
                MeshAttachment mesh = (MeshAttachment) attachment;
                mesh.updateWorldVertices(slot, true);
                vertices = mesh.getWorldVertices();
                triangles = mesh.getTriangles();
                texture = mesh.getRegion().getTexture();
            } else if (attachment instanceof SkinnedMeshAttachment) {
                SkinnedMeshAttachment mesh2 = (SkinnedMeshAttachment) attachment;
                mesh2.updateWorldVertices(slot, true);
                vertices = mesh2.getWorldVertices();
                triangles = mesh2.getTriangles();
                texture = mesh2.getRegion().getTexture();
            } else if (attachment instanceof SkeletonAttachment) {
                Skeleton attachmentSkeleton = ((SkeletonAttachment) attachment).getSkeleton();
                if (attachmentSkeleton != null) {
                    Bone bone = slot.getBone();
                    Bone rootBone = attachmentSkeleton.getRootBone();
                    float oldScaleX = rootBone.getScaleX();
                    float oldScaleY = rootBone.getScaleY();
                    float oldRotation = rootBone.getRotation();
                    attachmentSkeleton.setPosition(skeleton.getX() + bone.getWorldX(), skeleton.getY() + bone.getWorldY());
                    rootBone.setScaleX((1.0f + bone.getWorldScaleX()) - oldScaleX);
                    rootBone.setScaleY((1.0f + bone.getWorldScaleY()) - oldScaleY);
                    rootBone.setRotation(bone.getWorldRotation() + oldRotation);
                    attachmentSkeleton.updateWorldTransform();
                    draw(batch, attachmentSkeleton);
                    attachmentSkeleton.setPosition(0.0f, 0.0f);
                    rootBone.setScaleX(oldScaleX);
                    rootBone.setScaleY(oldScaleY);
                    rootBone.setRotation(oldRotation);
                } else {
                }
            }
            if (texture != null) {
                if (slot.data.getAdditiveBlending() != additive) {
                    additive = !additive;
                    if (additive) {
                        batch.setBlendFunction(srcFunc, 1);
                    } else {
                        batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);
                    }
                }
                batch.draw(texture, vertices, 0, vertices.length, triangles, 0, triangles.length);
            }
        }
    }

    public void draw(Batch batch, Skeleton skeleton) {
        boolean premultipliedAlpha = this.premultipliedAlpha;
        int srcFunc = premultipliedAlpha ? 1 : GL20.GL_SRC_ALPHA;
        batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);
        boolean additive = false;
        Array<Slot> drawOrder = skeleton.drawOrder;
        int n = drawOrder.size;
        for (int i = 0; i < n; i++) {
            Slot slot = (Slot) drawOrder.get(i);
            Attachment attachment = slot.attachment;
            if (attachment instanceof RegionAttachment) {
                RegionAttachment regionAttachment = (RegionAttachment) attachment;
                regionAttachment.updateWorldVertices(slot, premultipliedAlpha);
                float[] vertices = regionAttachment.getWorldVertices();
                if (slot.data.getAdditiveBlending() != additive) {
                    additive = !additive;
                    if (additive) {
                        batch.setBlendFunction(srcFunc, 1);
                    } else {
                        batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);
                    }
                }
                batch.draw(regionAttachment.getRegion().getTexture(), vertices, 0, 20);
            } else if ((attachment instanceof MeshAttachment) || (attachment instanceof SkinnedMeshAttachment)) {
                throw new RuntimeException("PolygonSpriteBatch is required to render meshes.");
            } else if (attachment instanceof SkeletonAttachment) {
                Skeleton attachmentSkeleton = ((SkeletonAttachment) attachment).getSkeleton();
                if (attachmentSkeleton != null) {
                    Bone bone = slot.getBone();
                    Bone rootBone = attachmentSkeleton.getRootBone();
                    float oldScaleX = rootBone.getScaleX();
                    float oldScaleY = rootBone.getScaleY();
                    float oldRotation = rootBone.getRotation();
                    attachmentSkeleton.setPosition(skeleton.getX() + bone.getWorldX(), skeleton.getY() + bone.getWorldY());
                    rootBone.setScaleX((1.0f + bone.getWorldScaleX()) - oldScaleX);
                    rootBone.setScaleY((1.0f + bone.getWorldScaleY()) - oldScaleY);
                    rootBone.setRotation(bone.getWorldRotation() + oldRotation);
                    attachmentSkeleton.updateWorldTransform();
                    draw(batch, attachmentSkeleton);
                    attachmentSkeleton.setX(0.0f);
                    attachmentSkeleton.setY(0.0f);
                    rootBone.setScaleX(oldScaleX);
                    rootBone.setScaleY(oldScaleY);
                    rootBone.setRotation(oldRotation);
                }
            }
        }
    }

    public void setPremultipliedAlpha(boolean premultipliedAlpha) {
        this.premultipliedAlpha = premultipliedAlpha;
    }
}
