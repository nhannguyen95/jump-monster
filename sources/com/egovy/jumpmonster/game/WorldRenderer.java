package com.egovy.jumpmonster.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.net.HttpStatus;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.egovy.jumpmonster.game.WorldController.GameState;
import com.egovy.jumpmonster.objects.Circle;
import com.egovy.jumpmonster.screens.MenuScreen;
import com.egovy.jumpmonster.transitions.ScreenTransitionFade;
import com.egovy.jumpmonster.utils.CharacterSelector;
import com.egovy.jumpmonster.utils.CharacterSelector.Character;
import com.egovy.jumpmonster.utils.ExtendActions;
import com.egovy.jumpmonster.utils.GamePreferences;
import com.egovy.jumpmonster.utils.GlobeInput;

public class WorldRenderer implements Disposable {
    /* renamed from: $SWITCH_TABLE$com$egovy$jumpmonster$game$WorldController$GameState */
    private static /* synthetic */ int[] f166x47d80a83;
    public static final String TAG = WorldRenderer.class.getName();
    public static boolean isStartGlassEffect;
    private float alphaInstruction;
    private SpriteBatch batch;
    private Button btnBack;
    private Button btnSmallPlay;
    private Button btnSmallPlayChar;
    private Button btnSmallRank;
    private OrthographicCamera camera;
    private OrthographicCamera cameraGUI;
    private Character character1;
    private Character character2;
    private Character character3;
    private Character character4;
    private Character character5;
    private CharacterSelector characterSelector;
    private Stage charactersStage;
    private ParticleEffect flash;
    private ParticleEffect glassBroke;
    private Image imgBronze;
    private Image imgGold;
    private Image imgNewBest;
    private Image imgNon;
    private Image imgScoreBoard;
    private Image imgSilver;
    private Texture instruction;
    private Label lbBest;
    private Label lbScore;
    private boolean playedScoreBoardSound;
    private BitmapFont scoreActiveFont;
    private Texture scoreCircle;
    private ShapeRenderer shapeRenderer;
    private Stage stage;
    Vector3 touch = new Vector3();
    private float waitingTime;
    private WorldController worldController;

    /* renamed from: com.egovy.jumpmonster.game.WorldRenderer$1 */
    class C10331 extends ClickListener {
        C10331() {
        }

        public void clicked(InputEvent event, float x, float y) {
            WorldRenderer.this.btnSmallPlay.addAction(ExtendActions.popAction());
            WorldRenderer.this.submitScore();
            WorldRenderer.this.setCharacterSelectorImages();
            WorldController.currentState = GameState.READY;
            WorldRenderer.this.worldController.restart();
            WorldRenderer.this.worldController.comeFromSmallPlayCharBtn = false;
        }
    }

    /* renamed from: com.egovy.jumpmonster.game.WorldRenderer$2 */
    class C10342 extends ClickListener {
        C10342() {
        }

        public void clicked(InputEvent event, float x, float y) {
            WorldRenderer.this.btnSmallPlayChar.addAction(ExtendActions.popAction());
            WorldRenderer.this.submitScore();
            WorldRenderer.this.setCharacterSelectorImages();
            WorldController.currentState = GameState.SELECT_CHARACTER;
            WorldRenderer.this.worldController.comeFromSmallPlayCharBtn = true;
            WorldRenderer.this.worldController.restart();
        }
    }

    /* renamed from: com.egovy.jumpmonster.game.WorldRenderer$3 */
    class C10353 extends ClickListener {
        C10353() {
        }

        public void clicked(InputEvent event, float x, float y) {
            WorldRenderer.this.btnSmallRank.addAction(ExtendActions.popAction());
            if (WorldRenderer.this.worldController.game.actionResolver.getSignedInGPGS()) {
                WorldRenderer.this.worldController.game.actionResolver.getLeaderboardGPGS();
            } else {
                WorldRenderer.this.worldController.game.actionResolver.loginGPGS();
            }
        }
    }

    /* renamed from: com.egovy.jumpmonster.game.WorldRenderer$4 */
    class C10364 extends ClickListener {
        C10364() {
        }

        public void clicked(InputEvent event, float x, float y) {
            WorldRenderer.this.btnBack.addAction(ExtendActions.popAction());
            WorldRenderer.this.submitScore();
            GamePreferences.instance.currentCharacterIndex = WorldRenderer.this.worldController.getCharacterSelector().getCurrentCharacterIndex() + 1;
            GlobeInput.instance.clear();
            WorldRenderer.this.worldController.game.setScreen(new MenuScreen(WorldRenderer.this.worldController.game), ScreenTransitionFade.init(0.5f));
        }
    }

    /* renamed from: com.egovy.jumpmonster.game.WorldRenderer$5 */
    class C10375 extends ClickListener {
        C10375() {
        }

        public void clicked(InputEvent event, float x, float y) {
            if (((Character) WorldRenderer.this.worldController.getCharacterSelector().getCharacters().get(WorldRenderer.this.worldController.getCharacterSelector().getCurrentCharacterIndex())).getImage() != Assets.instance.characters.character0) {
                WorldController.currentState = GameState.READY;
                WorldRenderer.this.charactersStage.addAction(Actions.fadeOut(0.15f));
            }
        }
    }

    /* renamed from: $SWITCH_TABLE$com$egovy$jumpmonster$game$WorldController$GameState */
    static /* synthetic */ int[] m1529x47d80a83() {
        int[] iArr = f166x47d80a83;
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
            f166x47d80a83 = iArr;
        }
        return iArr;
    }

    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
    }

    public void init() {
        this.batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        if (this.camera == null) {
            this.camera = new OrthographicCamera(4.8f, 4.8f);
        }
        this.camera.position.set(0.0f, 0.0f, 0.0f);
        this.camera.update();
        if (this.cameraGUI == null) {
            this.cameraGUI = new OrthographicCamera(480.0f, 800.0f);
        }
        this.cameraGUI.position.set(0.0f, 0.0f, 0.0f);
        this.cameraGUI.setToOrtho(false);
        this.cameraGUI.update();
        this.scoreActiveFont = Assets.instance.fonts.activeScore;
        this.scoreActiveFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.flash = Assets.instance.effects.flash;
        this.flash.setPosition(331.0f, 403.0f);
        this.flash.start();
        this.glassBroke = Assets.instance.effects.glassBreaking;
        this.glassBroke.setPosition(0.0f, 0.0f);
        isStartGlassEffect = false;
        this.stage = new Stage();
        this.stage.getViewport().setCamera(this.cameraGUI);
        rebuildStage();
        this.charactersStage = new Stage();
        this.charactersStage.getViewport().setCamera(this.cameraGUI);
        rebuildCharactersStage();
        this.waitingTime = 0.0f;
        this.playedScoreBoardSound = false;
        this.instruction = Assets.instance.instruction;
        this.alphaInstruction = 1.0f;
        this.scoreCircle = Assets.instance.scoreCircle;
    }

    private void rebuildStage() {
        Table layerScoreBoard = new Table();
        this.imgScoreBoard = Assets.instance.scene2D.imgScoreBoard;
        this.imgNewBest = Assets.instance.scene2D.imgNewHighscore;
        this.imgGold = Assets.instance.scene2D.imgGold;
        this.imgSilver = Assets.instance.scene2D.imgSilver;
        this.imgBronze = Assets.instance.scene2D.imgBronze;
        this.imgNon = Assets.instance.scene2D.imgNon;
        this.btnSmallPlay = Assets.instance.scene2D.btnSmallPlay;
        this.btnSmallPlayChar = Assets.instance.scene2D.btnSmallPlayChar;
        this.btnSmallRank = Assets.instance.scene2D.btnSmallRank;
        this.btnBack = Assets.instance.scene2D.btnBack;
        LabelStyle style = new LabelStyle(Assets.instance.fonts.boardScore, new Color(0.0f, 0.0f, 0.33333334f, 1.0f));
        this.lbScore = new Label((CharSequence) "", style);
        this.lbBest = new Label((CharSequence) "", style);
        layerScoreBoard.addActor(this.imgScoreBoard);
        layerScoreBoard.addActor(this.btnSmallPlay);
        layerScoreBoard.addActor(this.btnSmallPlayChar);
        layerScoreBoard.addActor(this.btnSmallRank);
        layerScoreBoard.addActor(this.lbScore);
        layerScoreBoard.addActor(this.lbBest);
        layerScoreBoard.addActor(this.btnBack);
        layerScoreBoard.addActor(this.imgNewBest);
        layerScoreBoard.addActor(this.imgGold);
        layerScoreBoard.addActor(this.imgSilver);
        layerScoreBoard.addActor(this.imgBronze);
        layerScoreBoard.addActor(this.imgNon);
        resetButtonsPosition();
        this.btnSmallPlay.addListener(new C10331());
        this.btnSmallPlayChar.addListener(new C10342());
        this.btnSmallRank.addListener(new C10353());
        this.btnBack.addListener(new C10364());
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(480.0f, 800.0f);
        stack.add(layerScoreBoard);
    }

    private void rebuildCharactersStage() {
        Table layer = new Table();
        this.characterSelector = this.worldController.getCharacterSelector();
        Array<Character> characters = new Array();
        this.character1 = Assets.instance.skinCharactorSelector.skinCharacter1;
        this.character2 = Assets.instance.skinCharactorSelector.skinCharacter2;
        this.character3 = Assets.instance.skinCharactorSelector.skinCharacter3;
        this.character4 = Assets.instance.skinCharactorSelector.skinCharacter4;
        this.character5 = Assets.instance.skinCharactorSelector.skinCharacter5;
        setCharacterSelectorImages();
        characters.addAll(this.character1, this.character2, this.character3, this.character4, this.character5);
        this.characterSelector.addCharacters(characters);
        this.characterSelector.setPosition(120.0f, -5.0f);
        Image imgInstruction2 = Assets.instance.imgInstruction2;
        imgInstruction2.setPosition(62.0f, 400.0f);
        imgInstruction2.addListener(new C10375());
        layer.addActor(this.characterSelector);
        layer.addActor(imgInstruction2);
        layer.setFillParent(true);
        layer.pack();
        this.charactersStage.addActor(layer);
    }

    public void setCharacterSelectorImages() {
        this.character1.setImage(Assets.instance.characters.character1);
        if (GamePreferences.instance.bronzes >= 2) {
            this.character2.setImage(Assets.instance.characters.character2);
        } else {
            this.character2.setImage(Assets.instance.characters.character0);
        }
        if (GamePreferences.instance.silvers >= 2) {
            this.character3.setImage(Assets.instance.characters.character3);
        } else {
            this.character3.setImage(Assets.instance.characters.character0);
        }
        if (GamePreferences.instance.breakingWindows >= HttpStatus.SC_OK) {
            this.character4.setImage(Assets.instance.characters.character4);
        } else {
            this.character4.setImage(Assets.instance.characters.character0);
        }
        if (GamePreferences.instance.golds >= 2) {
            this.character5.setImage(Assets.instance.characters.character5);
        } else {
            this.character5.setImage(Assets.instance.characters.character0);
        }
    }

    private void submitScore() {
        if (this.worldController.game.actionResolver.getSignedInGPGS()) {
            this.worldController.game.actionResolver.submitScoreGPGS(WorldController.score);
        }
    }

    public void render() {
        renderWorld(this.batch);
        if (this.worldController.level.scrollHandler.collidedWithGreenZone() && !isStartGlassEffect) {
            this.glassBroke.start();
            Circle circle = this.worldController.level.scrollHandler.circle_0;
            if (!circle.hasMonsterCollidedWithGreenZone() || circle.isScored()) {
                circle = this.worldController.level.scrollHandler.circle_1;
                if (!circle.hasMonsterCollidedWithGreenZone() || circle.isScored()) {
                    circle = this.worldController.level.scrollHandler.circle_2;
                    if (circle.hasMonsterCollidedWithGreenZone() && !circle.isScored()) {
                        this.glassBroke.setPosition(circle.position.f158x + 0.1f, circle.position.f159y + 0.5f);
                    }
                } else {
                    this.glassBroke.setPosition(circle.position.f158x + 0.1f, circle.position.f159y + 0.5f);
                }
            } else {
                this.glassBroke.setPosition(circle.position.f158x + 0.1f, circle.position.f159y + 0.5f);
            }
            isStartGlassEffect = true;
        }
        this.batch.begin();
        this.glassBroke.draw(this.batch, Gdx.graphics.getDeltaTime());
        this.batch.end();
        renderRectanglesForDebugging(this.shapeRenderer);
        renderGUI(this.batch);
    }

    private void renderGUI(SpriteBatch batch) {
        float f = 0.0f;
        batch.setProjectionMatrix(this.cameraGUI.combined);
        switch (m1529x47d80a83()[WorldController.currentState.ordinal()]) {
            case 1:
                renderInstruction(batch);
                resetGameOverArguments();
                this.alphaInstruction = 1.0f;
                renderStatsAchivement(batch);
                renderCharacterSelector();
                return;
            case 2:
                resetGameOverArguments();
                if (this.alphaInstruction > 0.0f) {
                    f = this.alphaInstruction - 0.05f;
                }
                this.alphaInstruction = f;
                renderInstruction(batch);
                batch.begin();
                renderGuiScore(batch);
                batch.end();
                renderStatsAchivement(batch);
                return;
            case 3:
                if (this.worldController.level.monster.isDieByCollition()) {
                    if (this.worldController.level.monster.isHitGround()) {
                        this.waitingTime += Gdx.graphics.getDeltaTime();
                        if (this.waitingTime >= 0.3f) {
                            renderScoreBoard();
                            GlobeInput.instance.addProcessor(this.stage);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (this.worldController.level.monster.isDieByReachLimitLine()) {
                    this.waitingTime += Gdx.graphics.getDeltaTime();
                    if (this.waitingTime >= 0.5f) {
                        renderScoreBoard();
                        GlobeInput.instance.addProcessor(this.stage);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 4:
                GlobeInput.instance.addProcessor(this.charactersStage);
                this.charactersStage.addAction(Actions.fadeIn(0.15f));
                renderCharacterSelector();
                return;
            default:
                return;
        }
    }

    private void renderStatsAchivement(SpriteBatch batch) {
        batch.begin();
        Assets.instance.fonts.statsAchivement.draw(batch, "BREAKING WINDOWS: " + Integer.toString(GamePreferences.instance.breakingWindows), 10.0f, 20.0f);
        batch.draw(Assets.instance.smallGoldMedal, 300.0f + 0.0f, 0.0f);
        Assets.instance.fonts.statsAchivement.draw(batch, Integer.toString(GamePreferences.instance.golds), 329.0f + 0.0f, 20.0f);
        batch.draw(Assets.instance.smallSilverMedal, 360.0f + 0.0f, 0.0f);
        Assets.instance.fonts.statsAchivement.draw(batch, Integer.toString(GamePreferences.instance.silvers), 389.0f + 0.0f, 20.0f);
        batch.draw(Assets.instance.smallBronzeMedal, 420.0f + 0.0f, 0.0f);
        Assets.instance.fonts.statsAchivement.draw(batch, Integer.toString(GamePreferences.instance.bronzes), 449.0f + 0.0f, 20.0f);
        batch.end();
    }

    private void renderInstruction(SpriteBatch batch) {
        if (this.alphaInstruction != 0.0f) {
            Color currColor = batch.getColor();
            batch.setColor(currColor.f40r, currColor.f39g, currColor.f38b, this.alphaInstruction);
            batch.begin();
            batch.draw(this.instruction, 64.0f, this.cameraGUI.viewportHeight - 300.0f);
            batch.end();
            batch.setColor(currColor);
        }
    }

    private void renderCharacterSelector() {
        if (this.worldController.comeFromSmallPlayCharBtn) {
            this.charactersStage.act(Gdx.graphics.getDeltaTime());
            this.charactersStage.draw();
        }
    }

    private void resetGameOverArguments() {
        this.waitingTime = 0.0f;
        this.playedScoreBoardSound = false;
        GlobeInput.instance.clear();
        resetButtonsPosition();
    }

    private void resetButtonsPosition() {
        this.imgScoreBoard.setPosition(240.0f - (this.imgScoreBoard.getWidth() * 0.5f), -300.0f);
        this.btnSmallPlay.setPosition((240.0f - this.btnSmallPlay.getWidth()) - 75.0f, -420.0f);
        this.btnSmallPlayChar.setPosition(240.0f - (this.btnSmallPlayChar.getWidth() * 0.5f), -420.0f);
        this.btnSmallRank.setPosition(240.0f + 75.0f, -420.0f);
        this.lbScore.setPosition(102.0f, -140.0f);
        this.lbBest.setPosition(102.0f, -225.0f);
        this.btnBack.setPosition(0.0f, 0.0f);
        this.imgNewBest.setPosition(183.0f, 500.0f);
        this.imgNewBest.getColor().f37a = 0.0f;
        this.imgGold.setPosition(295.0f, 380.0f);
        this.imgGold.getColor().f37a = 0.0f;
        this.imgSilver.setPosition(295.0f, 380.0f);
        this.imgSilver.getColor().f37a = 0.0f;
        this.imgBronze.setPosition(295.0f, 380.0f);
        this.imgBronze.getColor().f37a = 0.0f;
        this.imgNon.setPosition(295.0f, 380.0f);
        this.imgNon.getColor().f37a = 0.0f;
        this.imgScoreBoard.clearActions();
        this.btnSmallPlay.clearActions();
        this.btnSmallPlayChar.clearActions();
        this.btnSmallRank.clearActions();
        this.lbScore.clearActions();
        this.lbBest.clearActions();
        this.imgNewBest.clearActions();
        this.imgGold.clearActions();
        this.imgSilver.clearActions();
        this.imgBronze.clearActions();
        this.imgNon.clearActions();
    }

    private void renderScoreBoard() {
        this.lbScore.setText(Integer.toString(WorldController.score));
        if (WorldController.score > GamePreferences.instance.highScore) {
            this.imgNewBest.addAction(Actions.sequence(Actions.delay(0.25f), Actions.alpha(1.0f, 0.5f)));
            GamePreferences.instance.highScore = WorldController.score;
        }
        this.lbBest.setText(Integer.toString(GamePreferences.instance.highScore));
        this.imgScoreBoard.addAction(Actions.moveTo(240.0f - (this.imgScoreBoard.getWidth() * 0.5f), 300.0f, 0.2f));
        this.btnSmallPlay.addAction(Actions.moveTo((240.0f - this.btnSmallPlay.getWidth()) - 75.0f, 180.0f, 0.2f));
        this.btnSmallPlayChar.addAction(Actions.moveTo(240.0f - (this.btnSmallPlayChar.getWidth() * 0.5f), 180.0f, 0.2f));
        this.btnSmallRank.addAction(Actions.moveTo(240.0f + 75.0f, 180.0f, 0.2f));
        this.lbScore.addAction(Actions.moveTo(102.0f, 460.0f, 0.2f));
        this.lbBest.addAction(Actions.moveTo(102.0f, 375.0f, 0.2f));
        if (!this.playedScoreBoardSound) {
            Assets.instance.sounds.wing.play();
            this.playedScoreBoardSound = true;
        }
        this.stage.act(Gdx.graphics.getDeltaTime());
        this.stage.draw();
        setMedals();
    }

    private void setMedals() {
        int tmpScore = WorldController.score - (WorldController.score % 10);
        if (tmpScore < 10) {
            this.imgNon.addAction(Actions.sequence(Actions.delay(0.25f), Actions.alpha(1.0f, 0.5f)));
            return;
        }
        GamePreferences gamePreferences;
        if ((tmpScore + 20) % 30 == 0) {
            this.imgBronze.addAction(Actions.sequence(Actions.delay(0.25f), Actions.alpha(1.0f, 0.5f)));
            if (!this.worldController.updateMedals) {
                gamePreferences = GamePreferences.instance;
                gamePreferences.bronzes++;
                this.worldController.updateMedals = true;
                GamePreferences.instance.saveAll();
            }
        } else if ((tmpScore + 10) % 30 == 0) {
            this.imgSilver.addAction(Actions.sequence(Actions.delay(0.25f), Actions.alpha(1.0f, 0.5f)));
            if (!this.worldController.updateMedals) {
                gamePreferences = GamePreferences.instance;
                gamePreferences.silvers++;
                this.worldController.updateMedals = true;
                GamePreferences.instance.saveAll();
            }
        } else if (tmpScore % 30 == 0) {
            this.imgGold.addAction(Actions.sequence(Actions.delay(0.25f), Actions.alpha(1.0f, 0.5f)));
            if (!this.worldController.updateMedals) {
                gamePreferences = GamePreferences.instance;
                gamePreferences.golds++;
                this.worldController.updateMedals = true;
                GamePreferences.instance.saveAll();
            }
        }
        this.batch.begin();
        this.flash.draw(this.batch, Gdx.graphics.getDeltaTime());
        this.batch.end();
    }

    private void renderGuiScore(SpriteBatch batch) {
        TextBounds textBounds = this.scoreActiveFont.getBounds(Integer.toString(WorldController.score));
        float x = 240.0f - (0.5f * textBounds.width);
        float y = this.cameraGUI.viewportHeight - 60.0f;
        batch.draw(this.scoreCircle, (float) (((double) x) - (((double) (((float) this.scoreCircle.getWidth()) - textBounds.width)) * 0.5d)), (float) (((double) y) - (((double) (((float) this.scoreCircle.getHeight()) + textBounds.height)) * 0.5d)));
        this.scoreActiveFont.draw(batch, Integer.toString(WorldController.score), x, y);
    }

    private void renderWorld(SpriteBatch batch) {
        batch.setProjectionMatrix(this.camera.combined);
        this.worldController.level.render(batch);
    }

    private void renderRectanglesForDebugging(ShapeRenderer shapeRenderer) {
    }

    public void resize(int width, int height) {
        this.camera.viewportHeight = (4.8f / ((float) width)) * ((float) height);
        this.camera.update();
        this.cameraGUI.viewportWidth = 480.0f;
        this.cameraGUI.viewportHeight = (480.0f / ((float) width)) * ((float) height);
        this.cameraGUI.position.set(this.cameraGUI.viewportWidth / 2.0f, this.cameraGUI.viewportHeight / 2.0f, 0.0f);
        this.cameraGUI.update();
    }

    public void dispose() {
        this.stage.dispose();
        this.charactersStage.dispose();
        this.batch.dispose();
        this.shapeRenderer.dispose();
    }
}
