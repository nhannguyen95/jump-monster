package com.egovy.jumpmonster.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.egovy.jumpmonster.ActionResolver;
import com.egovy.jumpmonster.AdsController;
import com.egovy.jumpmonster.transitions.ScreenTransition;

public class DirectedGame implements ApplicationListener {
    public static final String TAG = DirectedGame.class.getName();
    public ActionResolver actionResolver;
    public AdsController adsController;
    private SpriteBatch batch;
    private FrameBuffer currFbo;
    private AbstractGameScreen currScreen;
    private boolean init;
    private FrameBuffer nextFbo;
    private AbstractGameScreen nextScreen;
    private ScreenTransition screenTransition;
    /* renamed from: t */
    private float f167t;

    public void setScreen(AbstractGameScreen screen) {
        setScreen(screen, null);
    }

    public void setScreen(AbstractGameScreen screen, ScreenTransition screenTransition) {
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        if (!this.init) {
            this.currFbo = new FrameBuffer(Format.RGB888, w, h, false);
            this.nextFbo = new FrameBuffer(Format.RGB888, w, h, false);
            this.batch = new SpriteBatch();
            this.init = true;
        }
        this.nextScreen = screen;
        this.nextScreen.show();
        this.nextScreen.resize(w, h);
        this.nextScreen.render(0.0f);
        if (this.currScreen != null) {
            this.currScreen.pause();
        }
        this.nextScreen.pause();
        this.screenTransition = screenTransition;
        this.f167t = 0.0f;
    }

    public void create() {
    }

    public void resize(int width, int height) {
        if (this.currScreen != null) {
            this.currScreen.resize(width, height);
        }
        if (this.nextScreen != null) {
            this.nextScreen.resize(width, height);
        }
    }

    public void render() {
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 0.016666668f);
        if (this.nextScreen != null) {
            float duration = 0.0f;
            if (this.screenTransition != null) {
                duration = this.screenTransition.getDuration();
            }
            this.f167t = Math.min(this.f167t + deltaTime, duration);
            if (this.screenTransition == null || this.f167t >= duration) {
                if (this.currScreen != null) {
                    this.currScreen.hide();
                }
                this.nextScreen.resume();
                this.currScreen = this.nextScreen;
                this.nextScreen = null;
                this.screenTransition = null;
                return;
            }
            this.currFbo.begin();
            if (this.currScreen != null) {
                this.currScreen.render(deltaTime);
            }
            this.currFbo.end();
            this.nextFbo.begin();
            this.nextScreen.render(deltaTime);
            this.nextFbo.end();
            this.screenTransition.render(this.batch, this.currFbo.getColorBufferTexture(), this.nextFbo.getColorBufferTexture(), this.f167t / duration);
        } else if (this.currScreen != null) {
            this.currScreen.render(deltaTime);
        }
    }

    public void pause() {
        if (this.currScreen != null) {
            this.currScreen.pause();
        }
    }

    public void resume() {
        if (this.currScreen != null) {
            this.currScreen.resume();
        }
        System.out.println(1);
    }

    public void dispose() {
        if (this.currScreen != null) {
            this.currScreen.hide();
        }
        if (this.nextScreen != null) {
            this.nextScreen.hide();
        }
        if (this.init) {
            this.currFbo.dispose();
            this.currScreen = null;
            this.nextFbo.dispose();
            this.nextScreen = null;
            this.batch.dispose();
            this.init = false;
        }
    }
}
