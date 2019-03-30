package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class EarClippingTriangulator {
    private static final int CONCAVE = -1;
    private static final int CONVEX = 1;
    private static final int TANGENTIAL = 0;
    private short[] indices;
    private final ShortArray indicesArray = new ShortArray();
    private final ShortArray triangles = new ShortArray();
    private int vertexCount;
    private final IntArray vertexTypes = new IntArray();
    private float[] vertices;

    public ShortArray computeTriangles(FloatArray vertices) {
        return computeTriangles(vertices.items, 0, vertices.size);
    }

    public ShortArray computeTriangles(float[] vertices) {
        return computeTriangles(vertices, 0, vertices.length);
    }

    public ShortArray computeTriangles(float[] vertices, int offset, int count) {
        short i;
        this.vertices = vertices;
        short vertexCount = count / 2;
        this.vertexCount = vertexCount;
        ShortArray indicesArray = this.indicesArray;
        indicesArray.clear();
        indicesArray.ensureCapacity(vertexCount);
        indicesArray.size = vertexCount;
        short[] indices = indicesArray.items;
        this.indices = indices;
        if (areVerticesClockwise(vertices, offset, count)) {
            for (i = (short) 0; i < vertexCount; i = (short) (i + 1)) {
                indices[i] = i;
            }
        } else {
            int n = vertexCount - 1;
            for (i = (short) 0; i < vertexCount; i++) {
                indices[i] = (short) (n - i);
            }
        }
        IntArray vertexTypes = this.vertexTypes;
        vertexTypes.clear();
        vertexTypes.ensureCapacity(vertexCount);
        short n2 = vertexCount;
        for (i = (short) 0; i < n2; i++) {
            vertexTypes.add(classifyVertex(i));
        }
        ShortArray triangles = this.triangles;
        triangles.clear();
        triangles.ensureCapacity(Math.max(0, vertexCount - 2) * 3);
        triangulate();
        return triangles;
    }

    private void triangulate() {
        int[] vertexTypes = this.vertexTypes.items;
        while (this.vertexCount > 3) {
            int nextIndex;
            int earTipIndex = findEarTip();
            cutEarTip(earTipIndex);
            int previousIndex = previousIndex(earTipIndex);
            if (earTipIndex == this.vertexCount) {
                nextIndex = 0;
            } else {
                nextIndex = earTipIndex;
            }
            vertexTypes[previousIndex] = classifyVertex(previousIndex);
            vertexTypes[nextIndex] = classifyVertex(nextIndex);
        }
        if (this.vertexCount == 3) {
            ShortArray triangles = this.triangles;
            short[] indices = this.indices;
            triangles.add(indices[0]);
            triangles.add(indices[1]);
            triangles.add(indices[2]);
        }
    }

    private int classifyVertex(int index) {
        short[] indices = this.indices;
        int previous = indices[previousIndex(index)] * 2;
        int current = indices[index] * 2;
        int next = indices[nextIndex(index)] * 2;
        float[] vertices = this.vertices;
        return computeSpannedAreaSign(vertices[previous], vertices[previous + 1], vertices[current], vertices[current + 1], vertices[next], vertices[next + 1]);
    }

    private int findEarTip() {
        int i;
        int vertexCount = this.vertexCount;
        for (i = 0; i < vertexCount; i++) {
            if (isEarTip(i)) {
                return i;
            }
        }
        int[] vertexTypes = this.vertexTypes.items;
        for (i = 0; i < vertexCount; i++) {
            if (vertexTypes[i] != -1) {
                return i;
            }
        }
        return 0;
    }

    private boolean isEarTip(int earTipIndex) {
        int[] vertexTypes = this.vertexTypes.items;
        if (vertexTypes[earTipIndex] == -1) {
            return false;
        }
        int previousIndex = previousIndex(earTipIndex);
        int nextIndex = nextIndex(earTipIndex);
        short[] indices = this.indices;
        int p1 = indices[previousIndex] * 2;
        int p2 = indices[earTipIndex] * 2;
        int p3 = indices[nextIndex] * 2;
        float[] vertices = this.vertices;
        float p1x = vertices[p1];
        float p1y = vertices[p1 + 1];
        float p2x = vertices[p2];
        float p2y = vertices[p2 + 1];
        float p3x = vertices[p3];
        float p3y = vertices[p3 + 1];
        int i = nextIndex(nextIndex);
        while (i != previousIndex) {
            if (vertexTypes[i] != 1) {
                int v = indices[i] * 2;
                float vx = vertices[v];
                float vy = vertices[v + 1];
                if (computeSpannedAreaSign(p3x, p3y, p1x, p1y, vx, vy) >= 0 && computeSpannedAreaSign(p1x, p1y, p2x, p2y, vx, vy) >= 0 && computeSpannedAreaSign(p2x, p2y, p3x, p3y, vx, vy) >= 0) {
                    return false;
                }
            }
            i = nextIndex(i);
        }
        return true;
    }

    private void cutEarTip(int earTipIndex) {
        short[] indices = this.indices;
        ShortArray triangles = this.triangles;
        triangles.add(indices[previousIndex(earTipIndex)]);
        triangles.add(indices[earTipIndex]);
        triangles.add(indices[nextIndex(earTipIndex)]);
        this.indicesArray.removeIndex(earTipIndex);
        this.vertexTypes.removeIndex(earTipIndex);
        this.vertexCount--;
    }

    private int previousIndex(int index) {
        if (index == 0) {
            index = this.vertexCount;
        }
        return index - 1;
    }

    private int nextIndex(int index) {
        return (index + 1) % this.vertexCount;
    }

    private static boolean areVerticesClockwise(float[] vertices, int offset, int count) {
        boolean z = true;
        if (count <= 2) {
            return false;
        }
        float p1x;
        float p1y;
        float area = 0.0f;
        int n = (offset + count) - 3;
        for (int i = offset; i < n; i += 2) {
            p1x = vertices[i];
            p1y = vertices[i + 1];
            area += (p1x * vertices[i + 3]) - (vertices[i + 2] * p1y);
        }
        p1x = vertices[count - 2];
        p1y = vertices[count - 1];
        if (((p1x * vertices[1]) + area) - (vertices[0] * p1y) >= 0.0f) {
            z = false;
        }
        return z;
    }

    private static int computeSpannedAreaSign(float p1x, float p1y, float p2x, float p2y, float p3x, float p3y) {
        return (int) Math.signum(((p1x * (p3y - p2y)) + ((p1y - p3y) * p2x)) + ((p2y - p1y) * p3x));
    }
}
