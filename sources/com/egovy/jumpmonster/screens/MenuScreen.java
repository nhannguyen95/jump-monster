package com.egovy.jumpmonster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.egovy.jumpmonster.JumpMonsterMain;
import com.egovy.jumpmonster.game.Assets;
import com.egovy.jumpmonster.objects.Background;
import com.egovy.jumpmonster.objects.Clouds;
import com.egovy.jumpmonster.objects.Monster;
import com.egovy.jumpmonster.objects.SmallStreet;
import com.egovy.jumpmonster.transitions.ScreenTransitionFade;
import com.egovy.jumpmonster.utils.ExtendActions;
import com.egovy.jumpmonster.utils.GamePreferences;
import com.egovy.jumpmonster.utils.GlobeInput;
import com.egovy.jumpmonster.utils.MultipleVirtualViewportBuilder;
import com.egovy.jumpmonster.utils.OrthographicCameraWithVirtualViewport;
import com.egovy.jumpmonster.utils.VirtualViewport;

public class MenuScreen extends AbstractGameScreen {
    public static final String TAG = MenuScreen.class.getName();
    private Background background;
    private SpriteBatch batch;
    private Button btnPlay;
    private Button btnRank;
    private Button btnRate;
    private OrthographicCameraWithVirtualViewport camera;
    private Image imgTitle;
    private Clouds menuClouds;
    private Monster monster;
    private MultipleVirtualViewportBuilder multipleVirtualViewportBuilder;
    private SmallStreet smallStreet_s;
    private SmallStreet smallStreet_t;
    private Stage stage;
    private VirtualViewport virtualViewport;

    /* renamed from: com.egovy.jumpmonster.screens.MenuScreen$1 */
    class C10381 extends ClickListener {
        C10381() {
        }

        public void clicked(InputEvent event, float x, float y) {
            MenuScreen.this.onPlayClicked();
        }
    }

    /* renamed from: com.egovy.jumpmonster.screens.MenuScreen$2 */
    class C10392 extends ClickListener {
        C10392() {
        }

        public void clicked(InputEvent event, float x, float y) {
            MenuScreen.this.btnRank.addAction(ExtendActions.popAction());
            if (MenuScreen.this.game.actionResolver.getSignedInGPGS()) {
                MenuScreen.this.game.actionResolver.getLeaderboardGPGS();
            } else {
                MenuScreen.this.game.actionResolver.loginGPGS();
            }
        }
    }

    /* renamed from: com.egovy.jumpmonster.screens.MenuScreen$3 */
    class C10403 extends ClickListener {
        C10403() {
        }

        public void clicked(InputEvent event, float x, float y) {
            MenuScreen.this.btnRate.addAction(ExtendActions.popAction());
            Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.egovy.jumpmonster.android");
        }
    }

    public MenuScreen(JumpMonsterMain game) {
        super(game);
    }

    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        this.camera.update();
        handleExitEvent();
        this.stage.act(deltaTime);
        this.menuClouds.update(deltaTime);
        this.smallStreet_t.update(deltaTime);
        this.smallStreet_s.update(deltaTime);
        if (this.smallStreet_t.disappear()) {
            this.smallStreet_t.resetX(this.smallStreet_s.getTailX() - 2.0f);
        } else if (this.smallStreet_s.disappear()) {
            this.smallStreet_s.resetX(this.smallStreet_t.getTailX() - 2.0f);
        }
        this.monster.update(deltaTime);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.background.render(this.batch);
        this.menuClouds.render(this.batch);
        this.smallStreet_t.render(this.batch);
        this.smallStreet_s.render(this.batch);
        this.monster.render(this.batch);
        this.stage.draw();
    }

    private void handleExitEvent() {
        if (Gdx.input.isKeyPressed(4)) {
            dispose();
            GamePreferences.instance.saveAll();
            Gdx.app.exit();
        }
    }

    public void resize(int width, int height) {
        this.camera.setVirtualViewport(this.multipleVirtualViewportBuilder.getVirtualViewport((float) width, (float) height));
        this.camera.updateViewport();
        this.camera.position.set(0.0f, 0.0f, 0.0f);
    }

    public void show() {
        this.batch = new SpriteBatch();
        if (this.multipleVirtualViewportBuilder == null) {
            this.multipleVirtualViewportBuilder = new MultipleVirtualViewportBuilder();
        }
        this.multipleVirtualViewportBuilder.init(480.0f, 800.0f, 600.0f, 854.0f);
        this.virtualViewport = this.multipleVirtualViewportBuilder.getVirtualViewport((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
        if (this.camera == null) {
            this.camera = new OrthographicCameraWithVirtualViewport();
        }
        this.camera.init(this.virtualViewport);
        this.camera.updateViewport();
        this.camera.position.set(0.0f, 0.0f, 0.0f);
        this.stage = new Stage();
        this.stage.getViewport().setCamera(this.camera);
        rebuildStage();
        if (this.background == null) {
            this.background = new Background();
        }
        this.background.init2(-300.0f, -427.0f, 1.0f, false);
        if (this.menuClouds == null) {
            this.menuClouds = new Clouds();
        }
        this.menuClouds.init2(1.0f, 300.0f, this.virtualViewport.getHeight() * 0.5f);
        if (this.smallStreet_t == null) {
            this.smallStreet_t = new SmallStreet();
        }
        this.smallStreet_t.init2(-300.0f, 0.0f, -69.0f, 0.0f, 1.0f, -300.0f);
        if (this.smallStreet_s == null) {
            this.smallStreet_s = new SmallStreet();
        }
        this.smallStreet_s.init2(this.smallStreet_t.getTailX() - 2.0f, 0.0f, -69.0f, 0.0f, 1.0f, -300.0f);
        if (this.monster == null) {
            this.monster = new Monster();
        }
        this.monster.init(0.0f, 32.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        GlobeInput.instance.clear();
        GlobeInput.instance.addProcessor(this.stage);
        Gdx.input.setCatchBackKey(true);
    }

    private void rebuildStage() {
        Table layerText = buildLayerText();
        Table layerButtons = buildButtonLayer();
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(600.0f, 854.0f);
        stack.add(layerText);
        stack.add(layerButtons);
    }

    private Table buildLayerText() {
        Table layer = new Table();
        this.imgTitle = Assets.instance.scene2D.imgTitle;
        layer.addActor(this.imgTitle);
        this.imgTitle.setPosition((-this.imgTitle.getWidth()) * 0.5f, ((this.virtualViewport.getHeight() * 0.5f) - this.imgTitle.getHeight()) - (51200.0f / this.virtualViewport.getHeight()));
        return layer;
    }

    private Table buildButtonLayer() {
        Table layer = new Table();
        this.btnPlay = Assets.instance.scene2D.btnPlay;
        this.btnRank = Assets.instance.scene2D.btnRank;
        this.btnRate = Assets.instance.scene2D.btnRate;
        layer.addActor(this.btnPlay);
        layer.addActor(this.btnRank);
        layer.addActor(this.btnRate);
        float offsetX = (21.5f * this.virtualViewport.getWidth()) / 480.0f;
        float offsetY = (132.0f * this.virtualViewport.getHeight()) / 800.0f;
        this.btnPlay.setPosition((0.0f - offsetX) - this.btnPlay.getWidth(), (-offsetY) - this.btnPlay.getHeight());
        this.btnRank.setPosition(0.0f + offsetX, (-offsetY) - this.btnPlay.getHeight());
        this.btnRate.setPosition((-this.btnRate.getWidth()) * 0.5f, (-((46.5f * this.virtualViewport.getHeight()) / 800.0f)) - this.btnRate.getHeight());
        this.btnPlay.addListener(new C10381());
        this.btnRank.addListener(new C10392());
        this.btnRate.addListener(new C10403());
        return layer;
    }

    private void onPlayClicked() {
        GlobeInput.instance.clear();
        this.btnPlay.addAction(ExtendActions.popAction());
        this.game.setScreen(new GameScreen(this.game), ScreenTransitionFade.init(0.5f));
    }

    public void hide() {
        this.stage.dispose();
        this.batch.dispose();
    }

    public void pause() {
    }

    public InputProcessor getInputProcessor() {
        return this.stage;
    }
}
