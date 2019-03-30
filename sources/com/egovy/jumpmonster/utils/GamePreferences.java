package com.egovy.jumpmonster.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GamePreferences {
    public static final GamePreferences instance = new GamePreferences();
    public final String TAG = GamePreferences.class.getName();
    public int breakingWindows;
    public int bronzes;
    public int currentCharacterIndex;
    public int golds;
    public int highScore;
    private Preferences prefs = Gdx.app.getPreferences(Constants.PREFERENCES);
    public int silvers;

    private GamePreferences() {
    }

    public void load() {
        this.highScore = this.prefs.getInteger("highScore", 0);
        this.currentCharacterIndex = this.prefs.getInteger("currentCharacterIndex", 1);
        this.golds = this.prefs.getInteger("golds", 0);
        this.silvers = this.prefs.getInteger("silvers", 0);
        this.bronzes = this.prefs.getInteger("bronzes", 0);
        this.breakingWindows = this.prefs.getInteger("breakingWindows", 0);
    }

    public void saveHighScore() {
        this.prefs.putInteger("highScore", this.highScore);
        this.prefs.flush();
    }

    public void saveMedals() {
        this.prefs.putInteger("golds", this.golds);
        this.prefs.putInteger("silvers", this.silvers);
        this.prefs.putInteger("bronzes", this.bronzes);
        this.prefs.flush();
    }

    public void saveCurrentCharacterIndex() {
        this.prefs.putInteger("currentCharacterIndex", this.currentCharacterIndex);
        this.prefs.flush();
    }

    public void saveBreakingWindows() {
        this.prefs.putInteger("breakingWindows", this.breakingWindows);
        this.prefs.flush();
    }

    public void saveAll() {
        this.prefs.putInteger("highScore", this.highScore);
        this.prefs.putInteger("golds", this.golds);
        this.prefs.putInteger("silvers", this.silvers);
        this.prefs.putInteger("bronzes", this.bronzes);
        this.prefs.putInteger("currentCharacterIndex", this.currentCharacterIndex);
        this.prefs.putInteger("breakingWindows", this.breakingWindows);
        this.prefs.flush();
    }
}
