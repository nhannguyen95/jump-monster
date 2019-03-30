package com.egovy.jumpmonster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.egovy.jumpmonster.JumpMonsterMain;
import com.egovy.jumpmonster.game.WorldController;
import com.egovy.jumpmonster.game.WorldRenderer;

public class GameScreen extends AbstractGameScreen {
    public static final String TAG = GameScreen.class.getName();
    private WorldController worldController;
    private WorldRenderer worldRenderer = new WorldRenderer(this.worldController);

    public GameScreen(JumpMonsterMain game) {
        super(game);
        this.worldController = new WorldController(game);
    }

    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        this.worldController.update(deltaTime);
        this.worldRenderer.render();
    }

    public void resize(int width, int height) {
        this.worldRenderer.resize(width, height);
    }

    public void show() {
        this.worldController.init();
        this.worldController.restart();
        this.worldRenderer.init();
        Gdx.input.setCatchBackKey(true);
    }

    public void hide() {
        this.worldRenderer.dispose();
    }

    public void pause() {
    }

    public InputProcessor getInputProcessor() {
        return this.worldController;
    }
}
