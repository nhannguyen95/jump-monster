package com.egovy.jumpmonster.objects;

import com.egovy.jumpmonster.game.Assets;

public class City extends ScrollObject {
    public static final String TAG = City.class.getName();

    public void init2(float x, float y, float vX, float vY, float scaleFactor, float xLimit, boolean use0) {
        reset(use0);
        this.position.set(x, y);
        this.velocity.set(vX, vY);
        this.scaleFactor = scaleFactor;
        this.xLimit = xLimit;
        init();
    }

    public void reset(boolean use0) {
        if (use0) {
            this.reg = Assets.instance.levelDecoration.city0;
        } else {
            this.reg = Assets.instance.levelDecoration.city1;
        }
    }
}
