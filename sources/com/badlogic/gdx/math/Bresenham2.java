package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Bresenham2 {
    private final Array<GridPoint2> points = new Array();
    private final Pool<GridPoint2> pool = new C04871();

    /* renamed from: com.badlogic.gdx.math.Bresenham2$1 */
    class C04871 extends Pool<GridPoint2> {
        C04871() {
        }

        protected GridPoint2 newObject() {
            return new GridPoint2();
        }
    }

    public Array<GridPoint2> line(GridPoint2 start, GridPoint2 end) {
        return line(start.f58x, start.f59y, end.f58x, end.f59y);
    }

    public Array<GridPoint2> line(int startX, int startY, int endX, int endY) {
        this.pool.freeAll(this.points);
        this.points.clear();
        return line(startX, startY, endX, endY, this.pool, this.points);
    }

    public Array<GridPoint2> line(int startX, int startY, int endX, int endY, Pool<GridPoint2> pool, Array<GridPoint2> output) {
        int w = endX - startX;
        int h = endY - startY;
        int dx1 = 0;
        int dy1 = 0;
        int dx2 = 0;
        int dy2 = 0;
        if (w < 0) {
            dx1 = -1;
            dx2 = -1;
        } else if (w > 0) {
            dx1 = 1;
            dx2 = 1;
        }
        if (h < 0) {
            dy1 = -1;
        } else if (h > 0) {
            dy1 = 1;
        }
        int longest = Math.abs(w);
        int shortest = Math.abs(h);
        if (longest <= shortest) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) {
                dy2 = -1;
            } else if (h > 0) {
                dy2 = 1;
            }
            dx2 = 0;
        }
        int numerator = longest >> 1;
        for (int i = 0; i <= longest; i++) {
            GridPoint2 point = (GridPoint2) pool.obtain();
            point.set(startX, startY);
            output.add(point);
            numerator += shortest;
            if (numerator > longest) {
                numerator -= longest;
                startX += dx1;
                startY += dy1;
            } else {
                startX += dx2;
                startY += dy2;
            }
        }
        return output;
    }
}
