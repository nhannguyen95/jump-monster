package com.egovy.jumpmonster.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.egovy.jumpmonster.utils.CharacterSelector.Character;
import com.egovy.jumpmonster.utils.Constants;
import com.google.android.gms.plus.PlusShare;

public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    public AssetManager assetManager;
    public AssetCharacterAtlas characterAtlases;
    public AssetCharacters characters;
    public Texture circle_s;
    public Texture circle_t;
    public AssetEffect effects;
    public AssetFont fonts;
    public Texture glass;
    public Image imgInstruction2;
    public Texture instruction;
    public Texture instruction2;
    public Texture leftArrow;
    public AssetLevelDecoration levelDecoration;
    public Texture loading;
    public Texture rightArrow;
    public Scene2D scene2D;
    public Texture scoreCircle;
    public AssetSkeletonFile skeletonFiles;
    private Skin skin;
    public AssetSkinCharactorSelector skinCharactorSelector;
    public Texture smallBronzeMedal;
    public Texture smallGoldMedal;
    public Texture smallSilverMedal;
    public AssetSound sounds;

    public class AssetCharacterAtlas {
        public final TextureAtlas characterAtlas1;
        public final TextureAtlas characterAtlas2;
        public final TextureAtlas characterAtlas3;
        public final TextureAtlas characterAtlas4;
        public final TextureAtlas characterAtlas5;

        public AssetCharacterAtlas() {
            this.characterAtlas1 = (TextureAtlas) Assets.this.assetManager.get("data/monster/character1.atlas");
            this.characterAtlas2 = (TextureAtlas) Assets.this.assetManager.get("data/monster/character2.atlas");
            this.characterAtlas3 = (TextureAtlas) Assets.this.assetManager.get("data/monster/character3.atlas");
            this.characterAtlas4 = (TextureAtlas) Assets.this.assetManager.get("data/monster/character4.atlas");
            this.characterAtlas5 = (TextureAtlas) Assets.this.assetManager.get("data/monster/character5.atlas");
        }
    }

    public class AssetCharacters {
        public final Image character0;
        public final Image character1;
        public final Image character2;
        public final Image character3;
        public final Image character4;
        public final Image character5;

        public AssetCharacters(TextureAtlas atlas) {
            this.character0 = new Image(new TextureRegionDrawable(atlas.findRegion("character0")));
            this.character1 = new Image(new TextureRegionDrawable(atlas.findRegion("character1")));
            this.character2 = new Image(new TextureRegionDrawable(atlas.findRegion("character2")));
            this.character3 = new Image(new TextureRegionDrawable(atlas.findRegion("character3")));
            this.character4 = new Image(new TextureRegionDrawable(atlas.findRegion("character4")));
            this.character5 = new Image(new TextureRegionDrawable(atlas.findRegion("character5")));
        }
    }

    public class AssetEffect {
        public final ParticleEffect flash;
        public final ParticleEffect glassBreaking;

        public AssetEffect() {
            this.flash = (ParticleEffect) Assets.this.assetManager.get("data/effects/flashEffect.p");
            this.glassBreaking = (ParticleEffect) Assets.this.assetManager.get("data/effects/glassBreaking.p");
            this.glassBreaking.scaleEffect(0.01f);
        }
    }

    public class AssetFont {
        public final BitmapFont activeScore;
        public final BitmapFont boardScore;
        public final BitmapFont statsAchivement;

        public AssetFont() {
            this.activeScore = (BitmapFont) Assets.this.assetManager.get("data/fonts/BebasBold.fnt");
            this.boardScore = (BitmapFont) Assets.this.assetManager.get("data/fonts/BebasBold2.fnt");
            this.statsAchivement = (BitmapFont) Assets.this.assetManager.get("data/fonts/VnVogue.fnt");
            this.activeScore.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
            this.boardScore.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
            this.statsAchivement.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        }
    }

    public class AssetLevelDecoration {
        public final AtlasRegion background0;
        public final AtlasRegion background1;
        public final AtlasRegion bigStreet;
        public final AtlasRegion city0;
        public final AtlasRegion city1;
        public final AtlasRegion cloud_0;
        public final AtlasRegion cloud_1;
        public final AtlasRegion grass_0;
        public final AtlasRegion grass_1;
        public final AtlasRegion smallStreet;

        public AssetLevelDecoration(TextureAtlas atlas) {
            this.background0 = atlas.findRegion("background0");
            this.background1 = atlas.findRegion("background1");
            this.smallStreet = atlas.findRegion("small-street");
            this.bigStreet = atlas.findRegion("big-street");
            this.city0 = atlas.findRegion("city0");
            this.city1 = atlas.findRegion("city1");
            this.cloud_0 = atlas.findRegion("cloud0");
            this.cloud_1 = atlas.findRegion("cloud1");
            this.grass_0 = atlas.findRegion("grass0");
            this.grass_1 = atlas.findRegion("grass1");
        }
    }

    public class AssetSkeletonFile {
        public final FileHandle skeletonCharacter1 = Gdx.files.internal("data/monster/character1.json");
        public final FileHandle skeletonCharacter2 = Gdx.files.internal("data/monster/character2.json");
        public final FileHandle skeletonCharacter3 = Gdx.files.internal("data/monster/character3.json");
        public final FileHandle skeletonCharacter4 = Gdx.files.internal("data/monster/character4.json");
        public final FileHandle skeletonCharacter5 = Gdx.files.internal("data/monster/character5.json");
    }

    public class AssetSkinCharactorSelector {
        public Character skinCharacter1 = new Character("Install Game");
        public Character skinCharacter2 = new Character("x2 Bronze Medals");
        public Character skinCharacter3 = new Character("x2 Silver Medals");
        public Character skinCharacter4 = new Character("Break 200 windows");
        public Character skinCharacter5 = new Character("x2 Gold Medals");
    }

    public class AssetSound {
        public final Sound collide;
        public final Sound glass;
        public final Sound hitGround;
        public final Sound jump;
        public final Sound wing;

        public AssetSound() {
            this.collide = (Sound) Assets.this.assetManager.get("data/sounds/dead.wav");
            this.jump = (Sound) Assets.this.assetManager.get("data/sounds/jump.wav");
            this.hitGround = (Sound) Assets.this.assetManager.get("data/sounds/hitGround.wav");
            this.wing = (Sound) Assets.this.assetManager.get("data/sounds/wing.wav");
            this.glass = (Sound) Assets.this.assetManager.get("data/sounds/glass.wav");
        }
    }

    public class Scene2D {
        public final Button btnBack;
        public final Button btnFb;
        public final Button btnPlay;
        public final Button btnRank;
        public final Button btnRate;
        public final Button btnSmallPlay;
        public final Button btnSmallPlayChar;
        public final Button btnSmallRank;
        public final Image imgBronze;
        public final Image imgGold;
        public final Image imgNewHighscore;
        public final Image imgNon;
        public final Image imgScoreBoard;
        public final Image imgSilver;
        public final Image imgTitle;

        public Scene2D(Skin skin) {
            this.imgTitle = new Image(skin, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            this.imgScoreBoard = new Image(skin, "score-board");
            this.imgNewHighscore = new Image(skin, "new-highscore");
            this.imgGold = new Image(skin, "gold");
            this.imgSilver = new Image(skin, "silver");
            this.imgBronze = new Image(skin, "bronze");
            this.imgNon = new Image(skin, "non");
            this.btnPlay = new Button(skin, "play");
            this.btnSmallPlay = new Button(skin, "smallplay");
            this.btnSmallPlayChar = new Button(skin, "smallplaychar");
            this.btnRank = new Button(skin, "rank");
            this.btnSmallRank = new Button(skin, "smallrank");
            this.btnRate = new Button(skin, "rate");
            this.btnFb = new Button(skin, "facebook");
            this.btnBack = new Button(skin, "back");
        }
    }

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load("data/loading.png", Texture.class);
        assetManager.load(Constants.SKIN_UI, Skin.class);
        assetManager.finishLoading();
        this.loading = (Texture) assetManager.get("data/loading.png");
        this.skin = (Skin) assetManager.get(Constants.SKIN_UI);
        assetManager.load("data/instruction2.png", Texture.class);
        assetManager.load("data/smallGoldMedal.png", Texture.class);
        assetManager.load("data/smallSilverMedal.png", Texture.class);
        assetManager.load("data/smallBronzeMedal.png", Texture.class);
        assetManager.load("data/score-circle.png", Texture.class);
        assetManager.load("data/left-arrow.png", Texture.class);
        assetManager.load("data/right-arrow.png", Texture.class);
        assetManager.load("data/instruction.png", Texture.class);
        assetManager.load("data/circle-s.png", Texture.class);
        assetManager.load("data/circle-t.png", Texture.class);
        assetManager.load("data/glass.png", Texture.class);
        assetManager.load(Constants.LEVEL_DECORATION_ATLAS, TextureAtlas.class);
        assetManager.load(Constants.CHARACTERS_ATLAS, TextureAtlas.class);
        assetManager.load("data/monster/character1.atlas", TextureAtlas.class);
        assetManager.load("data/monster/character2.atlas", TextureAtlas.class);
        assetManager.load("data/monster/character3.atlas", TextureAtlas.class);
        assetManager.load("data/monster/character4.atlas", TextureAtlas.class);
        assetManager.load("data/monster/character5.atlas", TextureAtlas.class);
        assetManager.load("data/sounds/dead.wav", Sound.class);
        assetManager.load("data/sounds/jump.wav", Sound.class);
        assetManager.load("data/sounds/hitGround.wav", Sound.class);
        assetManager.load("data/sounds/wing.wav", Sound.class);
        assetManager.load("data/sounds/glass.wav", Sound.class);
        assetManager.load("data/fonts/BebasBold.fnt", BitmapFont.class);
        assetManager.load("data/fonts/BebasBold2.fnt", BitmapFont.class);
        assetManager.load("data/fonts/VnVogue.fnt", BitmapFont.class);
        assetManager.load("data/effects/flashEffect.p", ParticleEffect.class);
        assetManager.load("data/effects/glassBreaking.p", ParticleEffect.class);
        this.scene2D = new Scene2D(this.skin);
    }

    public void getAssets() {
        this.instruction2 = (Texture) this.assetManager.get("data/instruction2.png");
        this.imgInstruction2 = new Image(new TextureRegionDrawable(new TextureRegion(this.instruction2)));
        this.scoreCircle = (Texture) this.assetManager.get("data/score-circle.png");
        this.leftArrow = (Texture) this.assetManager.get("data/left-arrow.png");
        this.rightArrow = (Texture) this.assetManager.get("data/right-arrow.png");
        this.circle_s = (Texture) this.assetManager.get("data/circle-s.png");
        this.circle_t = (Texture) this.assetManager.get("data/circle-t.png");
        this.glass = (Texture) this.assetManager.get("data/glass.png");
        this.instruction = (Texture) this.assetManager.get("data/instruction.png");
        this.smallGoldMedal = (Texture) this.assetManager.get("data/smallGoldMedal.png");
        this.smallSilverMedal = (Texture) this.assetManager.get("data/smallSilverMedal.png");
        this.smallBronzeMedal = (Texture) this.assetManager.get("data/smallBronzeMedal.png");
        TextureAtlas charactersAtlas = (TextureAtlas) this.assetManager.get(Constants.CHARACTERS_ATLAS);
        this.levelDecoration = new AssetLevelDecoration((TextureAtlas) this.assetManager.get(Constants.LEVEL_DECORATION_ATLAS));
        this.characters = new AssetCharacters(charactersAtlas);
        this.sounds = new AssetSound();
        this.fonts = new AssetFont();
        this.effects = new AssetEffect();
        this.skinCharactorSelector = new AssetSkinCharactorSelector();
        this.skeletonFiles = new AssetSkeletonFile();
        this.characterAtlases = new AssetCharacterAtlas();
    }

    public void restartScene2D() {
        this.scene2D = new Scene2D(this.skin);
    }

    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception) throwable);
    }

    public void dispose() {
        this.assetManager.dispose();
        this.skin.dispose();
    }
}
