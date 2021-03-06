package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

public class IsometricStaggeredTiledMapRenderer extends BatchTiledMapRenderer {
    public IsometricStaggeredTiledMapRenderer(TiledMap map) {
        super(map);
    }

    public IsometricStaggeredTiledMapRenderer(TiledMap map, Batch batch) {
        super(map, batch);
    }

    public IsometricStaggeredTiledMapRenderer(TiledMap map, float unitScale) {
        super(map, unitScale);
    }

    public IsometricStaggeredTiledMapRenderer(TiledMap map, float unitScale, Batch batch) {
        super(map, unitScale, batch);
    }

    public void renderTileLayer(TiledMapTileLayer layer) {
        Color batchColor = this.batch.getColor();
        float color = Color.toFloatBits(batchColor.f40r, batchColor.f39g, batchColor.f38b, batchColor.f37a * layer.getOpacity());
        int layerWidth = layer.getWidth();
        int layerHeight = layer.getHeight();
        float layerTileWidth = layer.getTileWidth() * this.unitScale;
        float layerTileHeight = layer.getTileHeight() * this.unitScale;
        float layerTileWidth50 = layerTileWidth * 0.5f;
        float layerTileHeight50 = layerTileHeight * 0.5f;
        int minX = Math.max(0, (int) ((this.viewBounds.f154x - layerTileWidth50) / layerTileWidth));
        int maxX = Math.min(layerWidth, (int) ((((this.viewBounds.f154x + this.viewBounds.width) + layerTileWidth) + layerTileWidth50) / layerTileWidth));
        int minY = Math.max(0, (int) ((this.viewBounds.f155y - layerTileHeight) / layerTileHeight));
        for (int y = Math.min(layerHeight, (int) (((this.viewBounds.f155y + this.viewBounds.height) + layerTileHeight) / layerTileHeight50)) - 1; y >= minY; y--) {
            float offsetX = y % 2 == 1 ? layerTileWidth50 : 0.0f;
            for (int x = maxX - 1; x >= minX; x--) {
                Cell cell = layer.getCell(x, y);
                if (cell != null) {
                    TiledMapTile tile = cell.getTile();
                    if (tile != null) {
                        float temp;
                        boolean flipX = cell.getFlipHorizontally();
                        boolean flipY = cell.getFlipVertically();
                        int rotations = cell.getRotation();
                        TextureRegion region = tile.getTextureRegion();
                        float x1 = ((((float) x) * layerTileWidth) - offsetX) + (tile.getOffsetX() * this.unitScale);
                        float y1 = (((float) y) * layerTileHeight50) + (tile.getOffsetY() * this.unitScale);
                        float x2 = x1 + (((float) region.getRegionWidth()) * this.unitScale);
                        float y2 = y1 + (((float) region.getRegionHeight()) * this.unitScale);
                        float u1 = region.getU();
                        float v1 = region.getV2();
                        float u2 = region.getU2();
                        float v2 = region.getV();
                        this.vertices[0] = x1;
                        this.vertices[1] = y1;
                        this.vertices[2] = color;
                        this.vertices[3] = u1;
                        this.vertices[4] = v1;
                        this.vertices[5] = x1;
                        this.vertices[6] = y2;
                        this.vertices[7] = color;
                        this.vertices[8] = u1;
                        this.vertices[9] = v2;
                        this.vertices[10] = x2;
                        this.vertices[11] = y2;
                        this.vertices[12] = color;
                        this.vertices[13] = u2;
                        this.vertices[14] = v2;
                        this.vertices[15] = x2;
                        this.vertices[16] = y1;
                        this.vertices[17] = color;
                        this.vertices[18] = u2;
                        this.vertices[19] = v1;
                        if (flipX) {
                            temp = this.vertices[3];
                            this.vertices[3] = this.vertices[13];
                            this.vertices[13] = temp;
                            temp = this.vertices[8];
                            this.vertices[8] = this.vertices[18];
                            this.vertices[18] = temp;
                        }
                        if (flipY) {
                            temp = this.vertices[4];
                            this.vertices[4] = this.vertices[14];
                            this.vertices[14] = temp;
                            temp = this.vertices[9];
                            this.vertices[9] = this.vertices[19];
                            this.vertices[19] = temp;
                        }
                        if (rotations != 0) {
                            float tempV;
                            float tempU;
                            switch (rotations) {
                                case 1:
                                    tempV = this.vertices[4];
                                    this.vertices[4] = this.vertices[9];
                                    this.vertices[9] = this.vertices[14];
                                    this.vertices[14] = this.vertices[19];
                                    this.vertices[19] = tempV;
                                    tempU = this.vertices[3];
                                    this.vertices[3] = this.vertices[8];
                                    this.vertices[8] = this.vertices[13];
                                    this.vertices[13] = this.vertices[18];
                                    this.vertices[18] = tempU;
                                    break;
                                case 2:
                                    tempU = this.vertices[3];
                                    this.vertices[3] = this.vertices[13];
                                    this.vertices[13] = tempU;
                                    tempU = this.vertices[8];
                                    this.vertices[8] = this.vertices[18];
                                    this.vertices[18] = tempU;
                                    tempV = this.vertices[4];
                                    this.vertices[4] = this.vertices[14];
                                    this.vertices[14] = tempV;
                                    tempV = this.vertices[9];
                                    this.vertices[9] = this.vertices[19];
                                    this.vertices[19] = tempV;
                                    break;
                                case 3:
                                    tempV = this.vertices[4];
                                    this.vertices[4] = this.vertices[19];
                                    this.vertices[19] = this.vertices[14];
                                    this.vertices[14] = this.vertices[9];
                                    this.vertices[9] = tempV;
                                    tempU = this.vertices[3];
                                    this.vertices[3] = this.vertices[18];
                                    this.vertices[18] = this.vertices[13];
                                    this.vertices[13] = this.vertices[8];
                                    this.vertices[8] = tempU;
                                    break;
                            }
                        }
                        this.batch.draw(region.getTexture(), this.vertices, 0, 20);
                    }
                }
            }
        }
    }
}
