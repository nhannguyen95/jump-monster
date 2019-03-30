package com.egovy.jumpmonster.screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.egovy.jumpmonster.JumpMonsterMain;
import com.egovy.jumpmonster.game.Assets;

public abstract class AbstractGameScreen implements Screen {
    protected JumpMonsterMain game;

    public abstract InputProcessor getInputProcessor();

    public abstract void hide();

    public abstract void pause();

    public abstract void render(float f);

    public abstract void resize(int i, int i2);

    public abstract void show();

    public AbstractGameScreen(JumpMonsterMain game) {
        this.game = game;
    }

    public void resume() {
        Assets.instance.restartScene2D();
    }

    public void dispose() {
        Assets.instance.dispose();
    }
}
