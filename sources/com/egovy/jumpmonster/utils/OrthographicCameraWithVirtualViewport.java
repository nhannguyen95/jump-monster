package com.egovy.jumpmonster.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class OrthographicCameraWithVirtualViewport extends OrthographicCamera {
    Vector2 origin = new Vector2();
    Vector3 tmp = new Vector3();
    VirtualViewport virtualViewport;

    public void init(VirtualViewport virtualViewport) {
        init(virtualViewport, 0.0f, 0.0f);
    }

    public void init(VirtualViewport virtualViewport, float cx, float cy) {
        this.virtualViewport = virtualViewport;
        this.origin.set(cx, cy);
    }

    public void setVirtualViewport(VirtualViewport virtualViewport) {
        this.virtualViewport = virtualViewport;
    }

    public void setPosition(float x, float y) {
        this.position.set(x - (this.viewportWidth * this.origin.f158x), y - (this.viewportHeight * this.origin.f159y), 0.0f);
    }

    public void update() {
        float bottom = ((this.zoom * (-this.viewportHeight)) / 2.0f) + (this.virtualViewport.getVirtualHeight() * this.origin.f159y);
        this.projection.setToOrtho(((this.zoom * (-this.viewportWidth)) / 2.0f) + (this.virtualViewport.getVirtualWidth() * this.origin.f158x), ((this.zoom * this.viewportWidth) / 2.0f) + (this.virtualViewport.getVirtualWidth() * this.origin.f158x), bottom, ((this.zoom * this.viewportHeight) / 2.0f) + (this.virtualViewport.getVirtualHeight() * this.origin.f159y), Math.abs(this.near), Math.abs(this.far));
        this.view.setToLookAt(this.position, this.tmp.set(this.position).add(this.direction), this.up);
        this.combined.set(this.projection);
        Matrix4.mul(this.combined.val, this.view.val);
        this.invProjectionView.set(this.combined);
        Matrix4.inv(this.invProjectionView.val);
        this.frustum.update(this.invProjectionView);
    }

    public void updateViewport() {
        setToOrtho(false, this.virtualViewport.getWidth(), this.virtualViewport.getHeight());
    }
}
