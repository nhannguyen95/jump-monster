package com.egovy.jumpmonster.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.egovy.jumpmonster.JumpMonsterMain;
import com.egovy.jumpmonster.utils.CharacterSelector;
import com.egovy.jumpmonster.utils.GlobeInput;

public class WorldController extends InputAdapter {
    /* renamed from: $SWITCH_TABLE$com$egovy$jumpmonster$game$WorldController$GameState */
    private static /* synthetic */ int[] f177x47d80a83;
    public static final String TAG = WorldController.class.getName();
    public static GameState currentState;
    public static int score;
    public int characterNumber;
    private CharacterSelector characterSelector;
    public boolean comeFromSmallPlayCharBtn;
    public JumpMonsterMain game;
    private boolean isAlive;
    private boolean isChangeCharacter;
    public Level level;
    public boolean updateMedals;

    public enum GameState {
        READY,
        RUNNING,
        GAMEOVER,
        SELECT_CHARACTER
    }

    /* renamed from: $SWITCH_TABLE$com$egovy$jumpmonster$game$WorldController$GameState */
    static /* synthetic */ int[] m2613x47d80a83() {
        int[] iArr = f177x47d80a83;
        if (iArr == null) {
            iArr = new int[GameState.values().length];
            try {
                iArr[GameState.GAMEOVER.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GameState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GameState.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[GameState.SELECT_CHARACTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f177x47d80a83 = iArr;
        }
        return iArr;
    }

    public WorldController(JumpMonsterMain game) {
        this.game = game;
        if (this.characterSelector == null) {
            this.characterSelector = new CharacterSelector();
        }
        init();
    }

    public void init() {
        this.comeFromSmallPlayCharBtn = true;
        this.updateMedals = false;
        this.characterNumber = 1;
        currentState = GameState.SELECT_CHARACTER;
        if (this.level == null) {
            this.level = new Level();
        }
        score = 0;
        this.isAlive = true;
        this.isChangeCharacter = false;
    }

    public void update(float deltaTime) {
        handleInputGame();
        switch (m2613x47d80a83()[currentState.ordinal()]) {
            case 1:
                updateCharacter();
                updateReady(deltaTime);
                return;
            case 2:
                if (this.game.adsController.isWifiConnected()) {
                    this.game.adsController.hideBannerAd();
                }
                updateRunning(deltaTime);
                return;
            case 3:
                if (this.game.adsController.isWifiConnected()) {
                    this.game.adsController.showBannerAd();
                }
                this.level.monster.update(deltaTime);
                return;
            case 4:
                updateReady(deltaTime);
                return;
            default:
                return;
        }
    }

    private void updateCharacter() {
        if (!this.isChangeCharacter) {
            switch (this.characterSelector.getCurrentCharacterIndex() + 1) {
                case 1:
                    this.level.monster.loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter1, Assets.instance.characterAtlases.characterAtlas1, false);
                    break;
                case 2:
                    this.level.monster.loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter2, Assets.instance.characterAtlases.characterAtlas2, false);
                    break;
                case 3:
                    this.level.monster.loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter3, Assets.instance.characterAtlases.characterAtlas3, false);
                    break;
                case 4:
                    this.level.monster.loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter4, Assets.instance.characterAtlases.characterAtlas4, false);
                    break;
                case 5:
                    this.level.monster.loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter5, Assets.instance.characterAtlases.characterAtlas5, false);
                    break;
            }
            this.isChangeCharacter = false;
        }
    }

    public void updateReady(float deltaTime) {
        this.level.update(deltaTime);
    }

    public void updateRunning(float deltaTime) {
        this.level.update(deltaTime);
        this.level.scrollHandler.traceCollidesWithGreenZone(this.level.monster);
        handleDieEvent();
        handleIncreaseScoreEvent();
    }

    private void handleDieEvent() {
        if (this.level.scrollHandler.collidesWithDeadBox(this.level.monster) && this.isAlive) {
            this.level.monster.dieByCollition();
            this.level.monster.setDeadAnimation();
            this.level.scrollHandler.stop();
            Assets.instance.sounds.collide.play();
            currentState = GameState.GAMEOVER;
            this.isAlive = false;
        }
        int temp = this.level.scrollHandler.collidesWithLimitLine(this.level.monster);
        if (temp >= 0 && this.isAlive && !this.level.scrollHandler.collidedWithGreenZone()) {
            this.level.monster.dieByReachLimitLine();
            this.level.monster.clearAnimation();
            this.level.scrollHandler.stop();
            this.level.scrollHandler.setFlashCircle(temp);
            currentState = GameState.GAMEOVER;
            this.isAlive = false;
        }
    }

    private void handleIncreaseScoreEvent() {
        this.level.scrollHandler.isMonsterGetScore(this.level.monster);
    }

    private void handleInputGame() {
        switch (m2613x47d80a83()[currentState.ordinal()]) {
            case 1:
                if (Gdx.input.isTouched()) {
                    currentState = GameState.RUNNING;
                    return;
                }
                return;
            case 2:
                if (!Gdx.input.isTouched() || this.level.monster.hasDied()) {
                    this.level.monster.setJumping(false);
                    return;
                } else {
                    this.level.monster.setJumping(true);
                    return;
                }
            default:
                return;
        }
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        GlobeInput.instance.clear();
        this.isChangeCharacter = false;
        score = 0;
        this.isAlive = true;
        this.level.randomDecoration();
        this.level.monster.onRestart();
        this.level.scrollHandler.onRestart();
        WorldRenderer.isStartGlassEffect = false;
        this.updateMedals = false;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public CharacterSelector getCharacterSelector() {
        return this.characterSelector;
    }
}
