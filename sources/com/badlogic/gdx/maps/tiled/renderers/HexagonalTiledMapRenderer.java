package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;

public class HexagonalTiledMapRenderer extends BatchTiledMapRenderer {
    public HexagonalTiledMapRenderer(TiledMap map) {
        super(map);
    }

    public HexagonalTiledMapRenderer(TiledMap map, float unitScale) {
        super(map, unitScale);
    }

    public HexagonalTiledMapRenderer(TiledMap map, Batch batch) {
        super(map, batch);
    }

    public HexagonalTiledMapRenderer(TiledMap map, float unitScale, Batch batch) {
        super(map, unitScale, batch);
    }

    public void renderTileLayer(TiledMapTileLayer layer) {
        Color batchColor = this.batch.getColor();
        float color = Color.toFloatBits(batchColor.f40r, batchColor.f39g, batchColor.f38b, batchColor.f37a * layer.getOpacity());
        int layerWidth = layer.getWidth();
        int layerHeight = layer.getHeight();
        float layerTileWidth = layer.getTileWidth() * this.unitScale;
        float layerTileHeight = layer.getTileHeight() * this.unitScale;
        float layerTileWidth75 = layerTileWidth * 0.75f;
        float layerTileHeight50 = layerTileHeight * 0.5f;
        float layerTileHeight150 = layerTileHeight * 1.5f;
        int col1 = Math.max(0, (int) ((this.viewBounds.f154x - (layerTileWidth * 0.25f)) / layerTileWidth75));
        int col2 = Math.min(layerWidth, (int) (((this.viewBounds.f154x + this.viewBounds.width) + layerTileWidth75) / layerTileWidth75));
        int row1 = Math.max(0, (int) (this.viewBounds.f155y / layerTileHeight150));
        int row2 = Math.min(layerHeight, (int) (((this.viewBounds.f155y + this.viewBounds.height) + layerTileHeight150) / layerTileHeight));
        float[] vertices = this.vertices;
        for (int row = row1; row < row2; row++) {
            for (int col = col1; col < col2; col++) {
                float f;
                float x = layerTileWidth75 * ((float) col);
                if (col % 2 == 1) {
                    f = 0.0f;
                } else {
                    f = layerTileHeight50;
                }
                float y = f + (((float) row) * layerTileHeight);
                Cell cell = layer.getCell(col, row);
                if (cell == null) {
                    x += layerTileWidth;
                } else {
                    TiledMapTile tile = cell.getTile();
                    if (!(tile == null || (tile instanceof AnimatedTiledMapTile))) {
                        float temp;
                        boolean flipX = cell.getFlipHorizontally();
                        boolean flipY = cell.getFlipVertically();
                        int rotations = cell.getRotation();
                        TextureRegion region = tile.getTextureRegion();
                        float x1 = x + (tile.getOffsetX() * this.unitScale);
                        float y1 = y + (tile.getOffsetY() * this.unitScale);
                        float x2 = x1 + (((float) region.getRegionWidth()) * this.unitScale);
                        float y2 = y1 + (((float) region.getRegionHeight()) * this.unitScale);
                        float u1 = region.getU();
                        float v1 = region.getV2();
                        float u2 = region.getU2();
                        float v2 = region.getV();
                        vertices[0] = x1;
                        vertices[1] = y1;
                        vertices[2] = color;
                        vertices[3] = u1;
                        vertices[4] = v1;
                        vertices[5] = x1;
                        vertices[6] = y2;
                        vertices[7] = color;
                        vertices[8] = u1;
                        vertices[9] = v2;
                        vertices[10] = x2;
                        vertices[11] = y2;
                        vertices[12] = color;
                        vertices[13] = u2;
                        vertices[14] = v2;
                        vertices[15] = x2;
                        vertices[16] = y1;
                        vertices[17] = color;
                        vertices[18] = u2;
                        vertices[19] = v1;
                        if (flipX) {
                            temp = vertices[3];
                            vertices[3] = vertices[13];
                            vertices[13] = temp;
                            temp = vertices[8];
                            vertices[8] = vertices[18];
                            vertices[18] = temp;
                        }
                        if (flipY) {
                            temp = vertices[4];
                            vertices[4] = vertices[14];
                            vertices[14] = temp;
                            temp = vertices[9];
                            vertices[9] = vertices[19];
                            vertices[19] = temp;
                        }
                        if (rotations == 2) {
                            float tempU = vertices[3];
                            vertices[3] = vertices[13];
                            vertices[13] = tempU;
                            tempU = vertices[8];
                            vertices[8] = vertices[18];
                            vertices[18] = tempU;
                            float tempV = vertices[4];
                            vertices[4] = vertices[14];
                            vertices[14] = tempV;
                            tempV = vertices[9];
                            vertices[9] = vertices[19];
                            vertices[19] = tempV;
                            break;
                        }
                        this.batch.draw(region.getTexture(), vertices, 0, 20);
                    }
                }
            }
        }
    }
}
