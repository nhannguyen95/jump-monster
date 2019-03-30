package com.egovy.jumpmonster.transitions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ScreenTransition {
    float getDuration();

    void render(SpriteBatch spriteBatch, Texture texture, Texture texture2, float f);
}
