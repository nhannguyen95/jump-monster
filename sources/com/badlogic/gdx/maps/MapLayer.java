package com.badlogic.gdx.maps;

public class MapLayer {
    private String name = "";
    private MapObjects objects = new MapObjects();
    private float opacity = 1.0f;
    private MapProperties properties = new MapProperties();
    private boolean visible = true;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public MapObjects getObjects() {
        return this.objects;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public MapProperties getProperties() {
        return this.properties;
    }
}
