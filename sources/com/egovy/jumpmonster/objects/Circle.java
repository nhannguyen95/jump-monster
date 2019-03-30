package com.egovy.jumpmonster.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.egovy.jumpmonster.game.Assets;
import com.egovy.jumpmonster.game.WorldRenderer;
import com.egovy.jumpmonster.utils.GamePreferences;

public class Circle extends ScrollObject {
    private Rectangle bigDown = new Rectangle();
    private Rectangle bigUp = new Rectangle();
    private CircleS circleS = new CircleS();
    private CircleT circleT = new CircleT();
    private Glass glass = new Glass();
    private Rectangle greenZone = new Rectangle();
    private boolean isPlayGlassSound;
    private boolean monsterCollidedWithGreenZone;
    private float offsetGlassX;
    private float offsetGlassY;
    private boolean scored;
    private Rectangle smallDown = new Rectangle();
    private Rectangle smallUp = new Rectangle();
    private float yMax;
    private float yMin;

    public class CircleS extends ScrollObject {
        private float alpha;
        private boolean flash;

        public CircleS() {
            this.tex = Assets.instance.circle_s;
            this.scaleFactor = 0.01f;
            this.alpha = 1.0f;
            this.flash = false;
            init();
        }

        public void setFlash() {
            this.flash = true;
        }

        public void render(SpriteBatch batch) {
            if (this.flash) {
                this.alpha -= 0.05f;
                if (this.alpha < 0.0f) {
                    this.alpha = 1.0f;
                }
            }
            Color currColor = batch.getColor();
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, this.alpha);
            super.render(batch);
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, 1.0f);
        }
    }

    public class CircleT extends ScrollObject {
        public float alpha;
        public boolean flash;

        public CircleT() {
            this.tex = Assets.instance.circle_t;
            this.scaleFactor = 0.01f;
            this.alpha = 1.0f;
            this.flash = false;
            init();
        }

        public void setFlash() {
            this.flash = true;
        }

        public void render(SpriteBatch batch) {
            if (this.flash) {
                this.alpha -= 0.05f;
                if (this.alpha < 0.0f) {
                    this.alpha = 1.0f;
                }
            }
            Color currColor = batch.getColor();
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, this.alpha);
            super.render(batch);
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, 1.0f);
        }
    }

    public class Glass extends ScrollObject {
        public float alpha;
        public boolean flash;
        public boolean isBroke;

        public Glass() {
            this.tex = Assets.instance.glass;
            this.scaleFactor = 0.01f;
            this.alpha = 1.0f;
            this.flash = false;
            this.isBroke = false;
            init();
        }

        public void setFlash() {
            this.flash = true;
        }

        public void render(SpriteBatch batch) {
            if (this.flash) {
                this.alpha -= 0.05f;
                if (this.alpha < 0.0f) {
                    this.alpha = 1.0f;
                }
            }
            Color currColor = batch.getColor();
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, this.alpha);
            super.render(batch);
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, 1.0f);
        }
    }

    public void init2(float x, float y, float yMin, float yMax, Vector2 velocity, float xLimit) {
        this.position.set(x, y);
        this.yMin = yMin;
        this.yMax = yMax;
        this.velocity.set(velocity);
        this.xLimit = xLimit;
        this.circleS.position.set(x, y);
        this.circleT.position.set(x, y);
        this.offsetGlassX = 0.04f;
        this.offsetGlassY = 0.0833f;
        this.glass.position.set(this.offsetGlassX + x, this.offsetGlassY + y);
        this.circleS.velocity.set(velocity);
        this.circleT.velocity.set(velocity);
        this.glass.velocity.set(velocity);
        this.dimension.set(this.circleT.dimension);
        this.monsterCollidedWithGreenZone = false;
        this.scored = false;
        this.isPlayGlassSound = false;
    }

    public void update(float deltaTime) {
        Vector2 vector2 = this.position;
        vector2.f158x += this.velocity.f158x * deltaTime;
        vector2 = this.position;
        vector2.f159y += this.velocity.f159y * deltaTime;
        this.circleS.position = this.position;
        this.circleT.position = this.position;
        this.glass.position.f158x = this.position.f158x + this.offsetGlassX;
        this.glass.position.f159y = this.position.f159y + this.offsetGlassY;
        this.circleS.velocity = this.velocity;
        this.circleT.velocity = this.velocity;
        this.glass.velocity = this.velocity;
        if (this.position.f159y <= this.yMin) {
            this.velocity.f159y = 0.35f;
        } else if (this.position.f159y >= this.yMax) {
            this.velocity.f159y = -0.35f;
        }
        this.smallUp.set(this.position.f158x, this.position.f159y + this.circleS.dimension.f159y, 0.27f, 0.0604f);
        this.smallDown.set(this.position.f158x + this.circleS.dimension.f158x, this.position.f159y, 0.0604f, 0.0604f);
        this.bigUp.set((this.position.f158x + this.circleS.dimension.f158x) + 1.0f, this.smallUp.f155y + this.smallUp.height, 0.06f, 4.51f);
        this.bigDown.set(this.bigUp.f154x, this.bigUp.f155y - 4.51f, 0.06f, 4.51f);
        this.greenZone.set(this.smallDown.f154x, this.smallDown.f155y + this.smallDown.height, this.bigDown.width, 1.05f);
    }

    public float getTailX() {
        return (this.circleS.position.f158x + (this.circleS.dimension.f158x * 0.5f)) + this.circleT.dimension.f158x;
    }

    public void resetX(float newX) {
        this.position.f158x = newX;
        this.circleS.position.f158x = newX;
        this.circleT.position.f158x = newX;
        this.glass.position.f158x = this.offsetGlassX + newX;
        this.scored = false;
        this.monsterCollidedWithGreenZone = false;
        this.isPlayGlassSound = false;
        this.glass.isBroke = false;
        WorldRenderer.isStartGlassEffect = false;
    }

    public void renderCircleS(SpriteBatch batch) {
        this.circleS.render(batch);
        if (!this.glass.isBroke) {
            this.glass.render(batch);
        }
    }

    public void renderCircleT(SpriteBatch batch) {
        this.circleT.render(batch);
    }

    public Rectangle getSmallUp() {
        return this.smallUp;
    }

    public Rectangle getSmallDown() {
        return this.smallDown;
    }

    public Rectangle getBigUp() {
        return this.bigUp;
    }

    public Rectangle getBigDown() {
        return this.bigDown;
    }

    public Rectangle getGreenZone() {
        return this.greenZone;
    }

    public boolean collidesWithDeadBox(Monster monster) {
        if (this.position.f158x >= monster.getX() + monster.getWidth()) {
            return false;
        }
        if (Intersector.overlaps(monster.getBoundingRect(), this.smallUp) || Intersector.overlaps(monster.getBoundingRect(), this.smallDown)) {
            return true;
        }
        return false;
    }

    public boolean collidesWithLimitLine(Monster monster) {
        if (this.bigDown.f154x >= monster.getX() + monster.getWidth()) {
            return false;
        }
        if (Intersector.overlaps(monster.getBoundingRect(), this.bigUp) || Intersector.overlaps(monster.getBoundingRect(), this.bigDown)) {
            return true;
        }
        return false;
    }

    public void traceCollidesWithGreenZone(Monster monster) {
        if (this.greenZone.f154x < monster.getX() + monster.getWidth()) {
            boolean z = this.monsterCollidedWithGreenZone || Intersector.overlaps(monster.getBoundingRect(), this.greenZone);
            this.monsterCollidedWithGreenZone = z;
        }
        if (this.monsterCollidedWithGreenZone) {
            if (!this.isPlayGlassSound) {
                Assets.instance.sounds.glass.play();
                GamePreferences gamePreferences = GamePreferences.instance;
                gamePreferences.breakingWindows++;
                this.isPlayGlassSound = true;
            }
            if (!this.glass.isBroke) {
                this.glass.isBroke = true;
            }
        }
    }

    public boolean hasMonsterCollidedWithGreenZone() {
        return this.monsterCollidedWithGreenZone;
    }

    public boolean isScored() {
        return this.scored;
    }

    public void hasScored() {
        this.scored = true;
    }

    public float getTailXofGreenZone() {
        return this.greenZone.f154x + this.greenZone.width;
    }

    public void setFlash() {
        this.circleS.setFlash();
        this.circleT.setFlash();
        this.glass.setFlash();
    }

    public void stop() {
        this.circleS.stop();
        this.circleT.stop();
        this.glass.stop();
    }

    public void onRestart(float x, float y, float vX, float vY) {
        resetX(x);
        this.velocity.set(vX, vY);
        this.circleS.alpha = 1.0f;
        this.circleT.alpha = 1.0f;
        this.glass.alpha = 1.0f;
        this.circleS.flash = false;
        this.circleT.flash = false;
        this.glass.flash = false;
    }
}
