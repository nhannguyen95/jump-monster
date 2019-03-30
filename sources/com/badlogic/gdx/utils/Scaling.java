package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Vector2;

public enum Scaling {
    fit,
    fill,
    fillX,
    fillY,
    stretch,
    stretchX,
    stretchY,
    none;
    
    private static final Vector2 temp = null;

    static {
        temp = new Vector2();
    }

    public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
        float scale;
        switch (this) {
            case fit:
                scale = targetHeight / targetWidth > sourceHeight / sourceWidth ? targetWidth / sourceWidth : targetHeight / sourceHeight;
                temp.f158x = sourceWidth * scale;
                temp.f159y = sourceHeight * scale;
                break;
            case fill:
                scale = targetHeight / targetWidth < sourceHeight / sourceWidth ? targetWidth / sourceWidth : targetHeight / sourceHeight;
                temp.f158x = sourceWidth * scale;
                temp.f159y = sourceHeight * scale;
                break;
            case fillX:
                scale = targetWidth / sourceWidth;
                temp.f158x = sourceWidth * scale;
                temp.f159y = sourceHeight * scale;
                break;
            case fillY:
                scale = targetHeight / sourceHeight;
                temp.f158x = sourceWidth * scale;
                temp.f159y = sourceHeight * scale;
                break;
            case stretch:
                temp.f158x = targetWidth;
                temp.f159y = targetHeight;
                break;
            case stretchX:
                temp.f158x = targetWidth;
                temp.f159y = sourceHeight;
                break;
            case stretchY:
                temp.f158x = sourceWidth;
                temp.f159y = targetHeight;
                break;
            case none:
                temp.f158x = sourceWidth;
                temp.f159y = sourceHeight;
                break;
        }
        return temp;
    }
}
