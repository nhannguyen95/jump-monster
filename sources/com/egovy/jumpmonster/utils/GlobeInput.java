package com.egovy.jumpmonster.utils;

import com.badlogic.gdx.InputMultiplexer;

public class GlobeInput extends InputMultiplexer {
    public static final String TAG = GlobeInput.class.getName();
    public static final GlobeInput instance = new GlobeInput();

    private GlobeInput() {
    }
}
