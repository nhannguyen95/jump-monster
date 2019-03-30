package com.egovy.jumpmonster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.egovy.jumpmonster.JumpMonsterMain;
import com.egovy.jumpmonster.game.Assets;
import com.egovy.jumpmonster.transitions.ScreenTransitionFade;
import com.egovy.jumpmonster.utils.GlobeInput;
import com.egovy.jumpmonster.utils.MultipleVirtualViewportBuilder;
import com.egovy.jumpmonster.utils.OrthographicCameraWithVirtualViewport;
import com.egovy.jumpmonster.utils.VirtualViewport;

public class LogoScreen extends AbstractGameScreen {
    public static final float OTHER_ASSETS_WAITING_TIME = 3.0f;
    public static final String TAG = LogoScreen.class.getName();
    private SpriteBatch batch;
    private OrthographicCameraWithVirtualViewport camera;
    private boolean getAssets;
    private MultipleVirtualViewportBuilder multipleVirtualViewportBuilder;
    private boolean setScreen;
    private VirtualViewport virtualViewport;

    public LogoScreen(JumpMonsterMain game) {
        super(game);
    }

    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        this.camera.update();
        if (Assets.instance.assetManager.update() && !this.setScreen) {
            if (!this.getAssets) {
                Assets.instance.getAssets();
                this.getAssets = true;
            }
            if (!this.setScreen) {
                this.game.setScreen(new MenuScreen(this.game), ScreenTransitionFade.init(0.5f));
                this.setScreen = true;
            }
        }
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        this.batch.draw(Assets.instance.loading, -300.0f, -427.0f);
        this.batch.end();
    }

    public void resize(int width, int height) {
        this.camera.setVirtualViewport(this.multipleVirtualViewportBuilder.getVirtualViewport((float) width, (float) height));
        this.camera.updateViewport();
        this.camera.position.set(0.0f, 0.0f, 0.0f);
    }

    public void show() {
        Gdx.app.setLogLevel(3);
        Assets.instance.init(new AssetManager());
        Gdx.input.setInputProcessor(GlobeInput.instance);
        this.batch = new SpriteBatch();
        if (this.multipleVirtualViewportBuilder == null) {
            this.multipleVirtualViewportBuilder = new MultipleVirtualViewportBuilder();
        }
        this.multipleVirtualViewportBuilder.init(480.0f, 800.0f, 600.0f, 854.0f);
        this.virtualViewport = this.multipleVirtualViewportBuilder.getVirtualViewport((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
        if (this.camera == null) {
            this.camera = new OrthographicCameraWithVirtualViewport();
        }
        this.camera.init(this.virtualViewport);
        this.camera.updateViewport();
        this.camera.position.set(0.0f, 0.0f, 0.0f);
        this.getAssets = false;
        this.setScreen = false;
    }

    public void hide() {
        this.batch.dispose();
    }

    public void pause() {
    }

    public InputProcessor getInputProcessor() {
        return null;
    }
}
