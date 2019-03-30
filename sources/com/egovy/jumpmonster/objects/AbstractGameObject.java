package com.egovy.jumpmonster.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractGameObject {
    protected Vector2 dimension = new Vector2();
    protected Vector2 origin = new Vector2();
    public Vector2 position = new Vector2();
    protected TextureRegion reg = null;
    protected Vector2 scale = new Vector2();
    protected float scaleFactor = 1.0f;
    protected Texture tex = null;
    protected Vector2 velocity = new Vector2();

    public void init() {
        this.scale.set(1.0f, 1.0f);
        if (this.tex != null) {
            this.dimension.set(((float) this.tex.getWidth()) * this.scaleFactor, ((float) this.tex.getHeight()) * this.scaleFactor);
        } else if (this.reg != null) {
            this.dimension.set(((float) this.reg.getRegionWidth()) * this.scaleFactor, ((float) this.reg.getRegionHeight()) * this.scaleFactor);
        }
        this.origin.set(this.dimension.f158x * 0.5f, this.dimension.f159y * 0.5f);
    }

    public void update(float deltaTime) {
        Vector2 vector2 = this.position;
        vector2.f158x += this.velocity.f158x * deltaTime;
        vector2 = this.position;
        vector2.f159y += this.velocity.f159y * deltaTime;
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        if (this.tex != null) {
            batch.draw(this.tex, this.position.f158x, this.position.f159y, this.origin.f158x, this.origin.f159y, this.dimension.f158x, this.dimension.f159y, this.scale.f158x, this.scale.f159y, 0.0f, 0, 0, this.tex.getWidth(), this.tex.getHeight(), false, false);
        } else if (this.reg != null) {
            batch.draw(this.reg.getTexture(), this.position.f158x, this.position.f159y, this.origin.f158x, this.origin.f159y, this.dimension.f158x, this.dimension.f159y, this.scale.f158x, this.scale.f159y, 0.0f, this.reg.getRegionX(), this.reg.getRegionY(), this.reg.getRegionWidth(), this.reg.getRegionHeight(), false, false);
        }
        batch.end();
    }
}
