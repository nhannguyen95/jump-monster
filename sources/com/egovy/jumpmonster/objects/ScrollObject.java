package com.egovy.jumpmonster.objects;

public class ScrollObject extends AbstractGameObject {
    public static final String TAG = ScrollObject.class.getName();
    protected float xLimit;

    public void resetX(float newX) {
        this.position.f158x = newX;
    }

    public boolean disappear() {
        return getTailX() <= this.xLimit;
    }

    public float getTailX() {
        return this.position.f158x + this.dimension.f158x;
    }

    public void stop() {
        this.velocity.set(0.0f, 0.0f);
    }

    public void onRestart(float x, float y, float vX, float vY) {
        this.position.set(x, y);
        this.velocity.set(vX, vY);
    }
}
