package com.egovy.jumpmonster.transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

public class ScreenTransitionFade implements ScreenTransition {
    private static final ScreenTransitionFade instance = new ScreenTransitionFade();
    private float duration;

    public static ScreenTransitionFade init(float duration) {
        instance.duration = duration;
        return instance;
    }

    public float getDuration() {
        return this.duration;
    }

    public void render(SpriteBatch batch, Texture currScreen, Texture nextScreen, float alpha) {
        float w = (float) currScreen.getWidth();
        float h = (float) currScreen.getHeight();
        alpha = Interpolation.fade.apply(alpha);
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        batch.begin();
        batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        batch.draw(currScreen, 0.0f, 0.0f, 0.0f, 0.0f, w, h, 1.0f, 1.0f, 0.0f, 0, 0, currScreen.getWidth(), currScreen.getHeight(), false, true);
        batch.setColor(0.0f, 0.0f, 0.0f, alpha);
        batch.draw(nextScreen, 0.0f, 0.0f, 0.0f, 0.0f, w, h, 1.0f, 1.0f, 0.0f, 0, 0, nextScreen.getWidth(), nextScreen.getHeight(), false, true);
        batch.end();
    }
}
