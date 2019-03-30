package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public abstract class BatchTiledMapRenderer implements TiledMapRenderer, Disposable {
    protected Batch batch;
    protected TiledMap map;
    protected boolean ownsBatch;
    protected float unitScale;
    protected float[] vertices;
    protected Rectangle viewBounds;

    public TiledMap getMap() {
        return this.map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public float getUnitScale() {
        return this.unitScale;
    }

    public Batch getBatch() {
        return this.batch;
    }

    public Rectangle getViewBounds() {
        return this.viewBounds;
    }

    public BatchTiledMapRenderer(TiledMap map) {
        this(map, 1.0f);
    }

    public BatchTiledMapRenderer(TiledMap map, float unitScale) {
        this.vertices = new float[20];
        this.map = map;
        this.unitScale = unitScale;
        this.viewBounds = new Rectangle();
        this.batch = new SpriteBatch();
        this.ownsBatch = true;
    }

    public BatchTiledMapRenderer(TiledMap map, Batch batch) {
        this(map, 1.0f, batch);
    }

    public BatchTiledMapRenderer(TiledMap map, float unitScale, Batch batch) {
        this.vertices = new float[20];
        this.map = map;
        this.unitScale = unitScale;
        this.viewBounds = new Rectangle();
        this.batch = batch;
        this.ownsBatch = false;
    }

    public void setView(OrthographicCamera camera) {
        this.batch.setProjectionMatrix(camera.combined);
        float width = camera.viewportWidth * camera.zoom;
        float height = camera.viewportHeight * camera.zoom;
        this.viewBounds.set(camera.position.f163x - (width / 2.0f), camera.position.f164y - (height / 2.0f), width, height);
    }

    public void setView(Matrix4 projection, float x, float y, float width, float height) {
        this.batch.setProjectionMatrix(projection);
        this.viewBounds.set(x, y, width, height);
    }

    public void render() {
        beginRender();
        Iterator i$ = this.map.getLayers().iterator();
        while (i$.hasNext()) {
            MapLayer layer = (MapLayer) i$.next();
            if (layer.isVisible()) {
                if (layer instanceof TiledMapTileLayer) {
                    renderTileLayer((TiledMapTileLayer) layer);
                } else {
                    renderObjects(layer);
                }
            }
        }
        endRender();
    }

    public void render(int[] layers) {
        beginRender();
        for (int layerIdx : layers) {
            MapLayer layer = this.map.getLayers().get(layerIdx);
            if (layer.isVisible()) {
                if (layer instanceof TiledMapTileLayer) {
                    renderTileLayer((TiledMapTileLayer) layer);
                } else {
                    renderObjects(layer);
                }
            }
        }
        endRender();
    }

    public void renderObjects(MapLayer layer) {
        Iterator i$ = layer.getObjects().iterator();
        while (i$.hasNext()) {
            renderObject((MapObject) i$.next());
        }
    }

    public void renderObject(MapObject object) {
    }

    protected void beginRender() {
        AnimatedTiledMapTile.updateAnimationBaseTime();
        this.batch.begin();
    }

    protected void endRender() {
        this.batch.end();
    }

    public void dispose() {
        if (this.ownsBatch) {
            this.batch.dispose();
        }
    }
}
