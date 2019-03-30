package com.egovy.jumpmonster.objects;

import com.egovy.jumpmonster.game.Assets;

public class Grass1 extends ScrollObject {
    public static final String TAG = Grass1.class.getName();

    public void init2(float x, float y, float vX, float vY, float scaleFactor, float xLimit) {
        this.reg = Assets.instance.levelDecoration.grass_1;
        this.position.set(x, y);
        this.velocity.set(vX, vY);
        this.scaleFactor = scaleFactor;
        this.xLimit = xLimit;
        init();
    }
}
