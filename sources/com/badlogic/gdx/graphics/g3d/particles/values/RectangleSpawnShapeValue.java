package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class RectangleSpawnShapeValue extends PrimitiveSpawnShapeValue {
    public RectangleSpawnShapeValue(RectangleSpawnShapeValue value) {
        super(value);
        load(value);
    }

    public void spawnAux(Vector3 vector, float percent) {
        float width = this.spawnWidth + (this.spawnWidthDiff * this.spawnWidthValue.getScale(percent));
        float height = this.spawnHeight + (this.spawnHeightDiff * this.spawnHeightValue.getScale(percent));
        float depth = this.spawnDepth + (this.spawnDepthDiff * this.spawnDepthValue.getScale(percent));
        if (this.edges) {
            float tx;
            float ty;
            float tz;
            int a = MathUtils.random(-1, 1);
            if (a == -1) {
                tx = MathUtils.random(1) == 0 ? (-width) / 2.0f : width / 2.0f;
                if (tx == 0.0f) {
                    ty = MathUtils.random(1) == 0 ? (-height) / 2.0f : height / 2.0f;
                    tz = MathUtils.random(1) == 0 ? (-depth) / 2.0f : depth / 2.0f;
                } else {
                    ty = MathUtils.random(height) - (height / 2.0f);
                    tz = MathUtils.random(depth) - (depth / 2.0f);
                }
            } else if (a == 0) {
                tz = MathUtils.random(1) == 0 ? (-depth) / 2.0f : depth / 2.0f;
                if (tz == 0.0f) {
                    ty = MathUtils.random(1) == 0 ? (-height) / 2.0f : height / 2.0f;
                    tx = MathUtils.random(1) == 0 ? (-width) / 2.0f : width / 2.0f;
                } else {
                    ty = MathUtils.random(height) - (height / 2.0f);
                    tx = MathUtils.random(width) - (width / 2.0f);
                }
            } else {
                ty = MathUtils.random(1) == 0 ? (-height) / 2.0f : height / 2.0f;
                if (ty == 0.0f) {
                    tx = MathUtils.random(1) == 0 ? (-width) / 2.0f : width / 2.0f;
                    tz = MathUtils.random(1) == 0 ? (-depth) / 2.0f : depth / 2.0f;
                } else {
                    tx = MathUtils.random(width) - (width / 2.0f);
                    tz = MathUtils.random(depth) - (depth / 2.0f);
                }
            }
            vector.f163x = tx;
            vector.f164y = ty;
            vector.f165z = tz;
            return;
        }
        vector.f163x = MathUtils.random(width) - (width / 2.0f);
        vector.f164y = MathUtils.random(height) - (height / 2.0f);
        vector.f165z = MathUtils.random(depth) - (depth / 2.0f);
    }

    public SpawnShapeValue copy() {
        return new RectangleSpawnShapeValue(this);
    }
}
