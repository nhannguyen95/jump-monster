package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapRenderer;

public interface TiledMapRenderer extends MapRenderer {
    void renderObject(MapObject mapObject);

    void renderObjects(MapLayer mapLayer);

    void renderTileLayer(TiledMapTileLayer tiledMapTileLayer);
}
