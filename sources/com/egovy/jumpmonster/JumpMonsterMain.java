package com.egovy.jumpmonster;

import com.egovy.jumpmonster.screens.DirectedGame;
import com.egovy.jumpmonster.screens.LogoScreen;
import com.egovy.jumpmonster.transitions.ScreenTransitionFade;
import com.egovy.jumpmonster.utils.GamePreferences;

public class JumpMonsterMain extends DirectedGame {
    public static final String TAG = JumpMonsterMain.class.getName();

    public JumpMonsterMain(ActionResolver actionResolver, AdsController adsController) {
        this.actionResolver = actionResolver;
        this.adsController = adsController;
    }

    public void create() {
        GamePreferences.instance.load();
        setScreen(new LogoScreen(this), ScreenTransitionFade.init(0.5f));
    }
}
