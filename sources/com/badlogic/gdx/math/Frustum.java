package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Plane.PlaneSide;
import com.badlogic.gdx.math.collision.BoundingBox;

public class Frustum {
    protected static final Vector3[] clipSpacePlanePoints = new Vector3[]{new Vector3(-1.0f, -1.0f, -1.0f), new Vector3(1.0f, -1.0f, -1.0f), new Vector3(1.0f, 1.0f, -1.0f), new Vector3(-1.0f, 1.0f, -1.0f), new Vector3(-1.0f, -1.0f, 1.0f), new Vector3(1.0f, -1.0f, 1.0f), new Vector3(1.0f, 1.0f, 1.0f), new Vector3(-1.0f, 1.0f, 1.0f)};
    protected static final float[] clipSpacePlanePointsArray = new float[24];
    public final Vector3[] planePoints = new Vector3[]{new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3()};
    protected final float[] planePointsArray = new float[24];
    public final Plane[] planes = new Plane[6];

    static {
        Vector3[] arr$ = clipSpacePlanePoints;
        int len$ = arr$.length;
        int i$ = 0;
        int j = 0;
        while (i$ < len$) {
            Vector3 v = arr$[i$];
            int i = j + 1;
            clipSpacePlanePointsArray[j] = v.f163x;
            j = i + 1;
            clipSpacePlanePointsArray[i] = v.f164y;
            i = j + 1;
            clipSpacePlanePointsArray[j] = v.f165z;
            i$++;
            j = i;
        }
    }

    public Frustum() {
        for (int i = 0; i < 6; i++) {
            this.planes[i] = new Plane(new Vector3(), 0.0f);
        }
    }

    public void update(Matrix4 inverseProjectionView) {
        System.arraycopy(clipSpacePlanePointsArray, 0, this.planePointsArray, 0, clipSpacePlanePointsArray.length);
        Matrix4.prj(inverseProjectionView.val, this.planePointsArray, 0, 8, 3);
        int i = 0;
        int j = 0;
        while (i < 8) {
            Vector3 v = this.planePoints[i];
            int j2 = j + 1;
            v.f163x = this.planePointsArray[j];
            j = j2 + 1;
            v.f164y = this.planePointsArray[j2];
            j2 = j + 1;
            v.f165z = this.planePointsArray[j];
            i++;
            j = j2;
        }
        this.planes[0].set(this.planePoints[1], this.planePoints[0], this.planePoints[2]);
        this.planes[1].set(this.planePoints[4], this.planePoints[5], this.planePoints[7]);
        this.planes[2].set(this.planePoints[0], this.planePoints[4], this.planePoints[3]);
        this.planes[3].set(this.planePoints[5], this.planePoints[1], this.planePoints[6]);
        this.planes[4].set(this.planePoints[2], this.planePoints[3], this.planePoints[6]);
        this.planes[5].set(this.planePoints[4], this.planePoints[0], this.planePoints[1]);
    }

    public boolean pointInFrustum(Vector3 point) {
        for (Plane testPoint : this.planes) {
            if (testPoint.testPoint(point) == PlaneSide.Back) {
                return false;
            }
        }
        return true;
    }

    public boolean pointInFrustum(float x, float y, float z) {
        for (Plane testPoint : this.planes) {
            if (testPoint.testPoint(x, y, z) == PlaneSide.Back) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustum(Vector3 center, float radius) {
        for (int i = 0; i < 6; i++) {
            if (((this.planes[i].normal.f163x * center.f163x) + (this.planes[i].normal.f164y * center.f164y)) + (this.planes[i].normal.f165z * center.f165z) < (-radius) - this.planes[i].f66d) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustum(float x, float y, float z, float radius) {
        for (int i = 0; i < 6; i++) {
            if (((this.planes[i].normal.f163x * x) + (this.planes[i].normal.f164y * y)) + (this.planes[i].normal.f165z * z) < (-radius) - this.planes[i].f66d) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustumWithoutNearFar(Vector3 center, float radius) {
        for (int i = 2; i < 6; i++) {
            if (((this.planes[i].normal.f163x * center.f163x) + (this.planes[i].normal.f164y * center.f164y)) + (this.planes[i].normal.f165z * center.f165z) < (-radius) - this.planes[i].f66d) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustumWithoutNearFar(float x, float y, float z, float radius) {
        for (int i = 2; i < 6; i++) {
            if (((this.planes[i].normal.f163x * x) + (this.planes[i].normal.f164y * y)) + (this.planes[i].normal.f165z * z) < (-radius) - this.planes[i].f66d) {
                return false;
            }
        }
        return true;
    }

    public boolean boundsInFrustum(BoundingBox bounds) {
        for (Plane testPoint : this.planes) {
            int out = 0;
            for (Vector3 testPoint2 : bounds.getCorners()) {
                if (testPoint.testPoint(testPoint2) == PlaneSide.Back) {
                    out++;
                }
            }
            if (out == 8) {
                return false;
            }
        }
        return true;
    }

    public boolean boundsInFrustum(Vector3 center, Vector3 dimensions) {
        return boundsInFrustum(center.f163x, center.f164y, center.f165z, dimensions.f163x / 2.0f, dimensions.f164y / 2.0f, dimensions.f165z / 2.0f);
    }

    public boolean boundsInFrustum(float x, float y, float z, float halfWidth, float halfHeight, float halfDepth) {
        int i = 0;
        int len2 = this.planes.length;
        while (i < len2) {
            if (this.planes[i].testPoint(x + halfWidth, y + halfHeight, z + halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x + halfWidth, y + halfHeight, z - halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x + halfWidth, y - halfHeight, z + halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x + halfWidth, y - halfHeight, z - halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x - halfWidth, y + halfHeight, z + halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x - halfWidth, y + halfHeight, z - halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x - halfWidth, y - halfHeight, z + halfDepth) == PlaneSide.Back && this.planes[i].testPoint(x - halfWidth, y - halfHeight, z - halfDepth) == PlaneSide.Back) {
                return false;
            }
            i++;
        }
        return true;
    }
}
