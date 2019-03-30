package com.egovy.jumpmonster.transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

public class ScreenTransitionSlide implements ScreenTransition {
    public static final int DOWN = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    private static final ScreenTransitionSlide instance = new ScreenTransitionSlide();
    private int direction;
    private float duration;
    private Interpolation easing;
    private boolean slideOut;

    public static ScreenTransitionSlide init(float duration, int direction, boolean slideOut, Interpolation easing) {
        instance.duration = duration;
        instance.direction = direction;
        instance.slideOut = slideOut;
        instance.easing = easing;
        return instance;
    }

    public float getDuration() {
        return this.duration;
    }

    public void render(SpriteBatch batch, Texture currScreen, Texture nextScreen, float alpha) {
        Texture texBottom;
        Texture texTop;
        float w = (float) currScreen.getWidth();
        float h = (float) currScreen.getHeight();
        float x = 0.0f;
        float y = 0.0f;
        if (this.easing != null) {
            alpha = this.easing.apply(alpha);
        }
        switch (this.direction) {
            case 1:
                x = (-w) * alpha;
                if (!this.slideOut) {
                    x += w;
                    break;
                }
                break;
            case 2:
                x = w * alpha;
                if (!this.slideOut) {
                    x -= w;
                    break;
                }
                break;
            case 3:
                y = h * alpha;
                if (!this.slideOut) {
                    y -= h;
                    break;
                }
                break;
            case 4:
                y = (-h) * alpha;
                if (!this.slideOut) {
                    y += h;
                    break;
                }
                break;
        }
        if (this.slideOut) {
            texBottom = nextScreen;
        } else {
            texBottom = currScreen;
        }
        if (this.slideOut) {
            texTop = currScreen;
        } else {
            texTop = nextScreen;
        }
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        batch.begin();
        batch.draw(texBottom, 0.0f, 0.0f, 0.0f, 0.0f, w, h, 1.0f, 1.0f, 0.0f, 0, 0, currScreen.getWidth(), currScreen.getHeight(), false, true);
        batch.draw(texTop, x, y, 0.0f, 0.0f, w, h, 1.0f, 1.0f, 0.0f, 0, 0, nextScreen.getWidth(), nextScreen.getHeight(), false, true);
        batch.end();
    }
}
