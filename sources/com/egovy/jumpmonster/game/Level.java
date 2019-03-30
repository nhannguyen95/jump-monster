package com.egovy.jumpmonster.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.egovy.jumpmonster.objects.Background;
import com.egovy.jumpmonster.objects.Clouds;
import com.egovy.jumpmonster.objects.Monster;
import com.egovy.jumpmonster.objects.ScrollHandler;

public class Level {
    public static final String TAG = Level.class.getName();
    public static boolean random;
    public Background background;
    public Clouds gameClouds;
    public Monster monster;
    public ScrollHandler scrollHandler;

    public Level() {
        if (this.background == null) {
            this.background = new Background();
        }
        if (this.gameClouds == null) {
            this.gameClouds = new Clouds();
        }
        if (this.scrollHandler == null) {
            this.scrollHandler = new ScrollHandler();
        }
        if (this.monster == null) {
            this.monster = new Monster();
        }
        init();
    }

    private void init() {
        float y = (-((4.8f / ((float) Gdx.graphics.getWidth())) * ((float) Gdx.graphics.getHeight()))) * 0.5f;
        random = MathUtils.randomBoolean();
        this.background.init2(-3.0f, y, 0.01f, random);
        this.gameClouds.init2(0.01f, 2.4f, -y);
        this.scrollHandler.init2(-3.0f, y);
        this.monster.init(-1.0f, -0.8f, 0.0f, 0.0f, -15.0f, 0.01f);
    }

    public void update(float deltaTime) {
        this.gameClouds.update(deltaTime);
        this.scrollHandler.update(deltaTime);
        this.monster.update(deltaTime);
    }

    public void render(SpriteBatch batch) {
        this.background.render(batch);
        this.gameClouds.render(batch);
        this.scrollHandler.render(batch);
        this.scrollHandler.renderCircleSes(batch);
        this.monster.render(batch);
        this.scrollHandler.renderCircleTes(batch);
    }

    public void renderRectanglesForDebugging(ShapeRenderer shapeRenderer) {
        this.scrollHandler.renderRectanglesForDebugging(shapeRenderer);
        this.monster.renderRectangleForDebugging(shapeRenderer);
    }

    public void randomDecoration() {
        random = MathUtils.randomBoolean();
        this.background.reset(random);
        this.scrollHandler.city_t.reset(random);
        this.scrollHandler.city_s.reset(random);
    }
}
