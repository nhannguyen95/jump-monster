package com.egovy.jumpmonster.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.net.HttpStatus;
import com.badlogic.gdx.utils.Array;
import com.egovy.jumpmonster.game.Assets;
import java.util.Iterator;

public class Clouds extends AbstractGameObject {
    public static final int NUM_CLOUDS = 3;
    public static final String TAG = Clouds.class.getName();
    private Array<Cloud> clouds;
    private Array<TextureRegion> regClouds = new Array();
    private float xRight;
    private float yTop;

    private class Cloud extends AbstractGameObject {
        public void init2(TextureRegion reg, float scaleFactor) {
            this.reg = reg;
            this.scaleFactor = scaleFactor;
            init();
        }

        public void randomValue(float scaleFactor2, float xRight2, float yTop2) {
            this.position.f158x = (100.0f * scaleFactor2) + xRight2;
            this.position.f159y = MathUtils.random((yTop2 - (150.0f * scaleFactor2)) - this.dimension.f159y, yTop2 - this.dimension.f159y);
            this.velocity.f158x = ((float) MathUtils.random(30, 60)) * scaleFactor2;
            Vector2 vector2 = this.velocity;
            vector2.f158x *= -1.0f;
            this.velocity.f159y = 0.0f;
        }

        public void render(SpriteBatch batch) {
            super.render(batch);
        }
    }

    public Clouds() {
        this.regClouds.add(Assets.instance.levelDecoration.cloud_0);
        this.regClouds.add(Assets.instance.levelDecoration.cloud_1);
        this.clouds = new Array(3);
        for (int i = 0; i < 3; i++) {
            this.clouds.add(new Cloud());
        }
    }

    public void init2(float scaleFactor, float xRight, float yTop) {
        this.xRight = xRight;
        this.yTop = yTop;
        this.scaleFactor = scaleFactor;
        for (int i = 0; i < 3; i++) {
            ((Cloud) this.clouds.get(i)).init2((TextureRegion) this.regClouds.random(), scaleFactor);
            ((Cloud) this.clouds.get(i)).randomValue(scaleFactor, xRight, yTop);
            ((Cloud) this.clouds.get(i)).position.f158x = (((float) (i * HttpStatus.SC_OK)) * scaleFactor) + xRight;
        }
    }

    public void update(float deltaTime) {
        for (int i = this.clouds.size - 1; i >= 0; i--) {
            Cloud cloud = (Cloud) this.clouds.get(i);
            cloud.update(deltaTime);
            if (cloud.position.f158x + cloud.dimension.f158x <= (-this.xRight)) {
                ((Cloud) this.clouds.get(i)).randomValue(this.scaleFactor, this.xRight, this.yTop);
            }
        }
    }

    public void render(SpriteBatch batch) {
        Iterator it = this.clouds.iterator();
        while (it.hasNext()) {
            ((Cloud) it.next()).render(batch);
        }
    }
}
