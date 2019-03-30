package com.egovy.jumpmonster.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.egovy.jumpmonster.game.Level;
import com.egovy.jumpmonster.game.WorldController;
import com.egovy.jumpmonster.game.WorldController.GameState;

public class ScrollHandler {
    private static final float CIRCLE_GAP = 1.8f;
    private static final float CIRCLE_Y_LENGTH = 1.3f;
    private static final float STREET_SCROLL_SPEED = -1.75f;
    public static final String TAG = ScrollHandler.class.getName();
    private BigStreet bigStreet_s;
    private BigStreet bigStreet_t;
    public Circle circle_0;
    public Circle circle_1;
    public Circle circle_2;
    public City city_s;
    public City city_t;
    private Grass0 grass0_s;
    private Grass0 grass0_t;
    private Grass1 grass1_s;
    private Grass1 grass1_t;
    /* renamed from: x */
    private float f82x;
    /* renamed from: y */
    private float f83y;

    public ScrollHandler() {
        if (this.city_t == null) {
            this.city_t = new City();
        }
        if (this.city_s == null) {
            this.city_s = new City();
        }
        if (this.grass1_t == null) {
            this.grass1_t = new Grass1();
        }
        if (this.grass1_s == null) {
            this.grass1_s = new Grass1();
        }
        if (this.grass0_t == null) {
            this.grass0_t = new Grass0();
        }
        if (this.grass0_s == null) {
            this.grass0_s = new Grass0();
        }
        if (this.bigStreet_t == null) {
            this.bigStreet_t = new BigStreet();
        }
        if (this.bigStreet_s == null) {
            this.bigStreet_s = new BigStreet();
        }
        if (this.circle_0 == null) {
            this.circle_0 = new Circle();
        }
        if (this.circle_1 == null) {
            this.circle_1 = new Circle();
        }
        if (this.circle_2 == null) {
            this.circle_2 = new Circle();
        }
    }

    public void init2(float x, float y) {
        this.f82x = x;
        this.f83y = y;
        init();
    }

    private void init() {
        this.city_t.init2(this.f82x, this.f83y, -1.35f, 0.0f, 0.01f, -3.0f, Level.random);
        this.city_s.init2(this.city_t.getTailX() - 0.02f, this.f83y, -1.35f, 0.0f, 0.01f, -3.0f, Level.random);
        this.grass1_t.init2(this.f82x, this.f83y, -1.65f, 0.0f, 0.01f, -3.0f);
        this.grass1_s.init2(this.grass1_t.getTailX() - 0.02f, this.f83y, -1.65f, 0.0f, 0.01f, -3.0f);
        this.grass0_t.init2(this.f82x, this.f83y, -1.7f, 0.0f, 0.01f, -3.0f);
        this.grass0_s.init2(this.grass0_t.getTailX() - 0.02f, this.f83y, -1.7f, 0.0f, 0.01f, -3.0f);
        this.bigStreet_t.init2(this.f82x, this.f83y, STREET_SCROLL_SPEED, 0.0f, 0.01f, -3.0f);
        this.bigStreet_s.init2(this.bigStreet_t.getTailX() - 0.02f, this.f83y, STREET_SCROLL_SPEED, 0.0f, 0.01f, -3.0f);
        Vector2 vel = new Vector2(STREET_SCROLL_SPEED, 0.35f);
        float y_Min = (this.bigStreet_t.position.f159y + this.bigStreet_t.dimension.f159y) + 0.66f;
        float y_Max = y_Min + CIRCLE_Y_LENGTH;
        vel.f159y *= (float) MathUtils.randomSign();
        this.circle_0.init2(2.65f, MathUtils.random(y_Min, y_Max), y_Min, y_Max, vel, -2.4f);
        vel.f159y *= (float) MathUtils.randomSign();
        this.circle_1.init2(this.circle_0.getTailX() + CIRCLE_GAP, MathUtils.random(y_Min, y_Max), y_Min, y_Max, vel, -2.4f);
        vel.f159y *= (float) MathUtils.randomSign();
        this.circle_2.init2(this.circle_1.getTailX() + CIRCLE_GAP, MathUtils.random(y_Min, y_Max), y_Min, y_Max, vel, -2.4f);
    }

    public void update(float deltaTime) {
        this.city_t.update(deltaTime);
        this.city_s.update(deltaTime);
        this.grass1_t.update(deltaTime);
        this.grass1_s.update(deltaTime);
        this.grass0_t.update(deltaTime);
        this.grass0_s.update(deltaTime);
        this.bigStreet_t.update(deltaTime);
        this.bigStreet_s.update(deltaTime);
        if (WorldController.currentState == GameState.RUNNING) {
            this.circle_0.update(deltaTime);
            this.circle_1.update(deltaTime);
            this.circle_2.update(deltaTime);
        }
        if (this.city_t.disappear()) {
            this.city_t.resetX(this.city_s.getTailX() - 0.02f);
        } else if (this.city_s.disappear()) {
            this.city_s.resetX(this.city_t.getTailX() - 0.02f);
        }
        if (this.grass1_t.disappear()) {
            this.grass1_t.resetX(this.grass1_s.getTailX() - 0.02f);
        } else if (this.grass1_s.disappear()) {
            this.grass1_s.resetX(this.grass1_t.getTailX() - 0.02f);
        }
        if (this.grass0_t.disappear()) {
            this.grass0_t.resetX(this.grass0_s.getTailX() - 0.02f);
        } else if (this.grass0_s.disappear()) {
            this.grass0_s.resetX(this.grass0_t.getTailX() - 0.02f);
        }
        if (this.bigStreet_t.disappear()) {
            this.bigStreet_t.resetX(this.bigStreet_s.getTailX() - 0.02f);
        } else if (this.bigStreet_s.disappear()) {
            this.bigStreet_s.resetX(this.bigStreet_t.getTailX() - 0.02f);
        }
        if (this.circle_0.disappear()) {
            this.circle_0.resetX(this.circle_2.getTailX() + CIRCLE_GAP);
        } else if (this.circle_1.disappear()) {
            this.circle_1.resetX(this.circle_0.getTailX() + CIRCLE_GAP);
        } else if (this.circle_2.disappear()) {
            this.circle_2.resetX(this.circle_1.getTailX() + CIRCLE_GAP);
        }
        if (WorldController.currentState == GameState.RUNNING) {
            if (this.circle_0.velocity.f159y == 0.0f) {
                this.circle_0.velocity.f159y = ((float) MathUtils.randomSign()) * 0.35f;
            }
            if (this.circle_1.velocity.f159y == 0.0f) {
                this.circle_1.velocity.f159y = ((float) MathUtils.randomSign()) * 0.35f;
            }
            if (this.circle_2.velocity.f159y == 0.0f) {
                this.circle_2.velocity.f159y = ((float) MathUtils.randomSign()) * 0.35f;
            }
        }
    }

    public void render(SpriteBatch batch) {
        this.city_t.render(batch);
        this.city_s.render(batch);
        this.grass1_t.render(batch);
        this.grass1_s.render(batch);
        this.grass0_t.render(batch);
        this.grass0_s.render(batch);
        this.bigStreet_t.render(batch);
        this.bigStreet_s.render(batch);
    }

    public void renderCircleSes(SpriteBatch batch) {
        this.circle_0.renderCircleS(batch);
        this.circle_1.renderCircleS(batch);
        this.circle_2.renderCircleS(batch);
    }

    public void renderCircleTes(SpriteBatch batch) {
        this.circle_0.renderCircleT(batch);
        this.circle_1.renderCircleT(batch);
        this.circle_2.renderCircleT(batch);
    }

    public void renderRectanglesForDebugging(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(this.circle_0.getSmallUp().f154x, this.circle_0.getSmallUp().f155y, this.circle_0.getSmallUp().width, this.circle_0.getSmallUp().height);
        shapeRenderer.rect(this.circle_1.getSmallUp().f154x, this.circle_1.getSmallUp().f155y, this.circle_1.getSmallUp().width, this.circle_1.getSmallUp().height);
        shapeRenderer.rect(this.circle_2.getSmallUp().f154x, this.circle_2.getSmallUp().f155y, this.circle_2.getSmallUp().width, this.circle_2.getSmallUp().height);
        shapeRenderer.rect(this.circle_0.getSmallDown().f154x, this.circle_0.getSmallDown().f155y, this.circle_0.getSmallDown().width, this.circle_0.getSmallDown().height);
        shapeRenderer.rect(this.circle_1.getSmallDown().f154x, this.circle_1.getSmallDown().f155y, this.circle_1.getSmallDown().width, this.circle_1.getSmallDown().height);
        shapeRenderer.rect(this.circle_2.getSmallDown().f154x, this.circle_2.getSmallDown().f155y, this.circle_2.getSmallDown().width, this.circle_2.getSmallDown().height);
        shapeRenderer.rect(this.circle_0.getBigUp().f154x, this.circle_0.getBigUp().f155y, this.circle_0.getBigUp().width, this.circle_0.getBigUp().height);
        shapeRenderer.rect(this.circle_1.getBigUp().f154x, this.circle_1.getBigUp().f155y, this.circle_1.getBigUp().width, this.circle_1.getBigUp().height);
        shapeRenderer.rect(this.circle_2.getBigUp().f154x, this.circle_2.getBigUp().f155y, this.circle_2.getBigUp().width, this.circle_2.getBigUp().height);
        shapeRenderer.rect(this.circle_0.getBigDown().f154x, this.circle_0.getBigDown().f155y, this.circle_0.getBigDown().width, this.circle_0.getBigDown().height);
        shapeRenderer.rect(this.circle_1.getBigDown().f154x, this.circle_1.getBigDown().f155y, this.circle_1.getBigDown().width, this.circle_1.getBigDown().height);
        shapeRenderer.rect(this.circle_2.getBigDown().f154x, this.circle_2.getBigDown().f155y, this.circle_2.getBigDown().width, this.circle_2.getBigDown().height);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(this.circle_0.getGreenZone().f154x, this.circle_0.getGreenZone().f155y, this.circle_0.getGreenZone().width, this.circle_0.getGreenZone().height);
        shapeRenderer.rect(this.circle_1.getGreenZone().f154x, this.circle_1.getGreenZone().f155y, this.circle_1.getGreenZone().width, this.circle_1.getGreenZone().height);
        shapeRenderer.rect(this.circle_2.getGreenZone().f154x, this.circle_2.getGreenZone().f155y, this.circle_2.getGreenZone().width, this.circle_2.getGreenZone().height);
        shapeRenderer.end();
    }

    public boolean collidesWithDeadBox(Monster monster) {
        return this.circle_0.collidesWithDeadBox(monster) || this.circle_1.collidesWithDeadBox(monster) || this.circle_2.collidesWithDeadBox(monster);
    }

    public int collidesWithLimitLine(Monster monster) {
        if (this.circle_0.collidesWithLimitLine(monster)) {
            return 0;
        }
        if (this.circle_1.collidesWithLimitLine(monster)) {
            return 1;
        }
        if (this.circle_2.collidesWithLimitLine(monster)) {
            return 2;
        }
        return -1;
    }

    public void setFlashCircle(int index) {
        if (index == 0) {
            this.circle_0.setFlash();
        } else if (index == 1) {
            this.circle_1.setFlash();
        } else if (index == 2) {
            this.circle_2.setFlash();
        }
    }

    public void traceCollidesWithGreenZone(Monster monster) {
        this.circle_0.traceCollidesWithGreenZone(monster);
        this.circle_1.traceCollidesWithGreenZone(monster);
        this.circle_2.traceCollidesWithGreenZone(monster);
    }

    public boolean collidedWithGreenZone() {
        return this.circle_0.hasMonsterCollidedWithGreenZone() || this.circle_1.hasMonsterCollidedWithGreenZone() || this.circle_2.hasMonsterCollidedWithGreenZone();
    }

    public void isMonsterGetScore(Monster monster) {
        isMonsterGetScoreWith(monster, this.circle_0);
        isMonsterGetScoreWith(monster, this.circle_1);
        isMonsterGetScoreWith(monster, this.circle_2);
    }

    private void isMonsterGetScoreWith(Monster monster, Circle circle) {
        if (!circle.isScored() && monster.getBoundingRect().f154x > circle.getTailXofGreenZone() && circle.hasMonsterCollidedWithGreenZone()) {
            WorldController.score++;
            circle.hasScored();
        }
    }

    public void stop() {
        this.grass1_t.stop();
        this.grass1_s.stop();
        this.grass0_t.stop();
        this.grass0_s.stop();
        this.bigStreet_t.stop();
        this.bigStreet_s.stop();
        this.circle_0.stop();
        this.circle_1.stop();
        this.circle_2.stop();
    }

    public void onRestart() {
        this.grass1_t.onRestart(this.f82x, this.f83y, -1.65f, 0.0f);
        this.grass1_s.onRestart(this.grass1_t.getTailX() - 0.02f, this.f83y, -1.65f, 0.0f);
        this.grass0_t.onRestart(this.f82x, this.f83y, -1.7f, 0.0f);
        this.grass0_s.onRestart(this.grass0_t.getTailX() - 0.02f, this.f83y, -1.7f, 0.0f);
        this.bigStreet_t.onRestart(this.f82x, this.f83y, STREET_SCROLL_SPEED, 0.0f);
        this.bigStreet_s.onRestart(this.bigStreet_t.getTailX() - 0.02f, this.f83y, STREET_SCROLL_SPEED, 0.0f);
        Vector2 vel = new Vector2(STREET_SCROLL_SPEED, 0.35f);
        vel.f159y *= (float) MathUtils.randomSign();
        this.circle_0.onRestart(2.65f, this.circle_0.position.f159y, vel.f158x, vel.f159y);
        vel.f159y *= (float) MathUtils.randomSign();
        this.circle_1.onRestart(this.circle_0.getTailX() + CIRCLE_GAP, this.circle_1.position.f159y, vel.f158x, vel.f159y);
        vel.f159y *= (float) MathUtils.randomSign();
        this.circle_2.onRestart(this.circle_1.getTailX() + CIRCLE_GAP, this.circle_2.position.f159y, vel.f158x, vel.f159y);
    }
}
