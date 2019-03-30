package com.egovy.jumpmonster.objects;

import com.egovy.jumpmonster.game.Assets;

public class Background extends AbstractGameObject {
    public static final String TAG = Background.class.getName();
    private boolean use0;

    public void init2(float x, float y, float scaleFactor, boolean use0) {
        this.use0 = use0;
        reset(use0);
        this.position.set(x, y);
        this.scaleFactor = scaleFactor;
        init();
    }

    public void reset(boolean use0) {
        if (use0) {
            this.reg = Assets.instance.levelDecoration.background0;
        } else {
            this.reg = Assets.instance.levelDecoration.background1;
        }
    }

    public boolean isUse0() {
        return this.use0;
    }
}
