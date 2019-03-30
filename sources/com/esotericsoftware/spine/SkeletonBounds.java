package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Pool;
import com.esotericsoftware.spine.attachments.Attachment;
import com.esotericsoftware.spine.attachments.BoundingBoxAttachment;

public class SkeletonBounds {
    private Array<BoundingBoxAttachment> boundingBoxes = new Array();
    private float maxX;
    private float maxY;
    private float minX;
    private float minY;
    private Pool<FloatArray> polygonPool = new C05161();
    private Array<FloatArray> polygons = new Array();

    /* renamed from: com.esotericsoftware.spine.SkeletonBounds$1 */
    class C05161 extends Pool {
        C05161() {
        }

        protected Object newObject() {
            return new FloatArray();
        }
    }

    public void update(Skeleton skeleton, boolean updateAabb) {
        Array<BoundingBoxAttachment> boundingBoxes = this.boundingBoxes;
        Array<FloatArray> polygons = this.polygons;
        Array<Slot> slots = skeleton.slots;
        int slotCount = slots.size;
        float x = skeleton.getX();
        float y = skeleton.getY();
        boundingBoxes.clear();
        this.polygonPool.freeAll(polygons);
        polygons.clear();
        for (int i = 0; i < slotCount; i++) {
            Slot slot = (Slot) slots.get(i);
            Attachment attachment = slot.attachment;
            if (attachment instanceof BoundingBoxAttachment) {
                BoundingBoxAttachment boundingBox = (BoundingBoxAttachment) attachment;
                boundingBoxes.add(boundingBox);
                FloatArray polygon = (FloatArray) this.polygonPool.obtain();
                polygons.add(polygon);
                int vertexCount = boundingBox.getVertices().length;
                polygon.ensureCapacity(vertexCount);
                polygon.size = vertexCount;
                boundingBox.computeWorldVertices(x, y, slot.bone, polygon.items);
            }
        }
        if (updateAabb) {
            aabbCompute();
        }
    }

    private void aabbCompute() {
        float minX = 2.14748365E9f;
        float minY = 2.14748365E9f;
        float maxX = -2.14748365E9f;
        float maxY = -2.14748365E9f;
        Array<FloatArray> polygons = this.polygons;
        int n = polygons.size;
        for (int i = 0; i < n; i++) {
            FloatArray polygon = (FloatArray) polygons.get(i);
            float[] vertices = polygon.items;
            int nn = polygon.size;
            for (int ii = 0; ii < nn; ii += 2) {
                float x = vertices[ii];
                float y = vertices[ii + 1];
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean aabbContainsPoint(float x, float y) {
        return x >= this.minX && x <= this.maxX && y >= this.minY && y <= this.maxY;
    }

    public boolean aabbIntersectsSegment(float x1, float y1, float x2, float y2) {
        float minX = this.minX;
        float minY = this.minY;
        float maxX = this.maxX;
        float maxY = this.maxY;
        if (x1 <= minX && x2 <= minX) {
            return false;
        }
        if (y1 <= minY && y2 <= minY) {
            return false;
        }
        if (x1 >= maxX && x2 >= maxX) {
            return false;
        }
        if (y1 >= maxY && y2 >= maxY) {
            return false;
        }
        float m = (y2 - y1) / (x2 - x1);
        float y = ((minX - x1) * m) + y1;
        if (y > minY && y < maxY) {
            return true;
        }
        y = ((maxX - x1) * m) + y1;
        if (y > minY && y < maxY) {
            return true;
        }
        float x = ((minY - y1) / m) + x1;
        if (x > minX && x < maxX) {
            return true;
        }
        x = ((maxY - y1) / m) + x1;
        if (x <= minX || x >= maxX) {
            return false;
        }
        return true;
    }

    public boolean aabbIntersectsSkeleton(SkeletonBounds bounds) {
        return this.minX < bounds.maxX && this.maxX > bounds.minX && this.minY < bounds.maxY && this.maxY > bounds.minY;
    }

    public BoundingBoxAttachment containsPoint(float x, float y) {
        Array<FloatArray> polygons = this.polygons;
        int n = polygons.size;
        for (int i = 0; i < n; i++) {
            if (containsPoint((FloatArray) polygons.get(i), x, y)) {
                return (BoundingBoxAttachment) this.boundingBoxes.get(i);
            }
        }
        return null;
    }

    public boolean containsPoint(FloatArray polygon, float x, float y) {
        float[] vertices = polygon.items;
        int nn = polygon.size;
        int prevIndex = nn - 2;
        boolean inside = false;
        for (int ii = 0; ii < nn; ii += 2) {
            float vertexY = vertices[ii + 1];
            float prevY = vertices[prevIndex + 1];
            if ((vertexY < y && prevY >= y) || (prevY < y && vertexY >= y)) {
                float vertexX = vertices[ii];
                if ((((y - vertexY) / (prevY - vertexY)) * (vertices[prevIndex] - vertexX)) + vertexX < x) {
                    inside = !inside;
                }
            }
            prevIndex = ii;
        }
        return inside;
    }

    public BoundingBoxAttachment intersectsSegment(float x1, float y1, float x2, float y2) {
        Array<FloatArray> polygons = this.polygons;
        int n = polygons.size;
        for (int i = 0; i < n; i++) {
            if (intersectsSegment((FloatArray) polygons.get(i), x1, y1, x2, y2)) {
                return (BoundingBoxAttachment) this.boundingBoxes.get(i);
            }
        }
        return null;
    }

    public boolean intersectsSegment(FloatArray polygon, float x1, float y1, float x2, float y2) {
        float[] vertices = polygon.items;
        int nn = polygon.size;
        float width12 = x1 - x2;
        float height12 = y1 - y2;
        float det1 = (x1 * y2) - (y1 * x2);
        float x3 = vertices[nn - 2];
        float y3 = vertices[nn - 1];
        for (int ii = 0; ii < nn; ii += 2) {
            float x4 = vertices[ii];
            float y4 = vertices[ii + 1];
            float det2 = (x3 * y4) - (y3 * x4);
            float width34 = x3 - x4;
            float height34 = y3 - y4;
            float det3 = (width12 * height34) - (height12 * width34);
            float x = ((det1 * width34) - (width12 * det2)) / det3;
            if (((x >= x3 && x <= x4) || (x >= x4 && x <= x3)) && ((x >= x1 && x <= x2) || (x >= x2 && x <= x1))) {
                float y = ((det1 * height34) - (height12 * det2)) / det3;
                if (((y >= y3 && y <= y4) || (y >= y4 && y <= y3)) && ((y >= y1 && y <= y2) || (y >= y2 && y <= y1))) {
                    return true;
                }
            }
            x3 = x4;
            y3 = y4;
        }
        return false;
    }

    public float getMinX() {
        return this.minX;
    }

    public float getMinY() {
        return this.minY;
    }

    public float getMaxX() {
        return this.maxX;
    }

    public float getMaxY() {
        return this.maxY;
    }

    public float getWidth() {
        return this.maxX - this.minX;
    }

    public float getHeight() {
        return this.maxY - this.minY;
    }

    public Array<BoundingBoxAttachment> getBoundingBoxes() {
        return this.boundingBoxes;
    }

    public Array<FloatArray> getPolygons() {
        return this.polygons;
    }

    public FloatArray getPolygon(BoundingBoxAttachment boundingBox) {
        int index = this.boundingBoxes.indexOf(boundingBox, true);
        return index == -1 ? null : (FloatArray) this.polygons.get(index);
    }
}
