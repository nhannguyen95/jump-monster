package com.egovy.jumpmonster.utils;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public class ExtendActions {
    private static final float DISTANCE = 4.5f;
    private static final float DURATION = 0.05f;

    public static SequenceAction popAction() {
        System.out.println("4.5 0.05");
        return Actions.sequence(Actions.moveBy(0.0f, -4.5f, DURATION), Actions.moveBy(0.0f, DISTANCE, DURATION));
    }
}
