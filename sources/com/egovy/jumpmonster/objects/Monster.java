package com.egovy.jumpmonster.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.egovy.jumpmonster.game.Assets;
import com.egovy.jumpmonster.utils.GamePreferences;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonBinary;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.esotericsoftware.spine.Skin;

public class Monster extends AbstractGameObject {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE;
    public static final String TAG = Monster.class.getName();
    private final float JUMP_LENGTH_MAX = 2.75f;
    private final float JUMP_LENGTH_MIN = 0.1f;
    private final float JUMP_VELOCITY_DOWN = -10.5f;
    private final float JUMP_VELOCITY_UP = 5.0f;
    private float accelerationY;
    private Rectangle boundingRect = new Rectangle();
    private boolean dieByCollition;
    private boolean dieByReachLimitLine;
    private boolean isDead;
    private boolean isPlayHitGroundSound;
    private JUMP_STATE jumpState;
    private float lengthJumping;
    private SkeletonRenderer renderer = new SkeletonRenderer();
    private Skeleton skeleton;
    private SkeletonData skeletonData;
    private AnimationState state;
    private AnimationStateData stateData;
    private float yGround;

    public enum JUMP_STATE {
        GROUNDED,
        FALLING,
        JUMP_RISING,
        JUMP_FALLING
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE() {
        int[] iArr = $SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE;
        if (iArr == null) {
            iArr = new int[JUMP_STATE.values().length];
            try {
                iArr[JUMP_STATE.FALLING.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[JUMP_STATE.GROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[JUMP_STATE.JUMP_FALLING.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[JUMP_STATE.JUMP_RISING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE = iArr;
        }
        return iArr;
    }

    public void init(float x, float y, float vX, float vY, float accelerationY, float scaleFactor) {
        this.velocity.set(vX, vY);
        this.position.set(x, y);
        this.scaleFactor = scaleFactor;
        this.dimension.set(0.453f, 0.6182f);
        this.lengthJumping = 0.0f;
        this.jumpState = JUMP_STATE.FALLING;
        this.accelerationY = accelerationY;
        this.yGround = (((-(4.8f / ((float) Gdx.graphics.getWidth()))) * ((float) Gdx.graphics.getHeight())) * 0.5f) + 2.15f;
        this.isDead = false;
        this.isPlayHitGroundSound = false;
        this.dieByCollition = false;
        this.dieByReachLimitLine = false;
        switch (GamePreferences.instance.currentCharacterIndex) {
            case 2:
                loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter2, Assets.instance.characterAtlases.characterAtlas2, false);
                return;
            case 3:
                loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter3, Assets.instance.characterAtlases.characterAtlas3, false);
                return;
            case 4:
                loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter4, Assets.instance.characterAtlases.characterAtlas4, false);
                return;
            case 5:
                loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter5, Assets.instance.characterAtlases.characterAtlas5, false);
                return;
            default:
                loadSkeleton(Assets.instance.skeletonFiles.skeletonCharacter1, Assets.instance.characterAtlases.characterAtlas1, false);
                return;
        }
    }

    public void loadSkeleton(FileHandle skeletonFile, TextureAtlas atlasFile, boolean reload) {
        if (skeletonFile != null) {
            TextureAtlas atlas = atlasFile;
            try {
                if (skeletonFile.extension().equalsIgnoreCase("json")) {
                    SkeletonJson json = new SkeletonJson(atlas);
                    json.setScale(this.scaleFactor);
                    this.skeletonData = json.readSkeletonData(skeletonFile);
                } else {
                    SkeletonBinary binary = new SkeletonBinary(atlas);
                    binary.setScale(this.scaleFactor);
                    this.skeletonData = binary.readSkeletonData(skeletonFile);
                }
                this.skeleton = new Skeleton(this.skeletonData);
                this.skeleton.setX(this.position.f158x);
                this.skeleton.setY(this.position.f159y);
                this.skeleton.updateWorldTransform();
                this.stateData = new AnimationStateData(this.skeletonData);
                this.state = new AnimationState(this.stateData);
                this.skeleton.setSkin((Skin) this.skeletonData.getSkins().first());
                this.state.clearTracks();
                this.skeleton.setToSetupPose();
                this.state.setAnimation(0, "walk", true);
            } catch (Exception ex) {
                ex.printStackTrace();
                Gdx.app.log(TAG, "Error loading skeleton: " + skeletonFile.name());
            }
        }
    }

    public void update(float deltaTime) {
        float offsetHeight;
        handleJumping(deltaTime);
        super.update(deltaTime);
        if (this.isDead) {
            offsetHeight = -0.33f;
        } else {
            offsetHeight = 0.0f;
        }
        if (this.position.f159y <= this.yGround + offsetHeight) {
            this.position.f159y = this.yGround + offsetHeight;
            if (this.isDead && !this.isPlayHitGroundSound) {
                Assets.instance.sounds.hitGround.play();
                this.isPlayHitGroundSound = true;
            }
            switch ($SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE()[this.jumpState.ordinal()]) {
                case 2:
                case 4:
                    this.jumpState = JUMP_STATE.GROUNDED;
                    break;
            }
        }
        this.boundingRect.set(this.position.f158x - 0.17f, this.position.f159y + 0.02f, 0.33f, 0.55f);
        this.skeleton.setX(this.position.f158x);
        this.skeleton.setY(this.position.f159y);
        this.state.update(deltaTime);
        this.state.apply(this.skeleton);
        this.skeleton.updateWorldTransform();
    }

    public void setDeadAnimation() {
        this.state.setAnimation(0, "dead", false);
        this.isDead = true;
    }

    public void clearAnimation() {
        this.state.clearTracks();
    }

    private void handleJumping(float deltaTime) {
        switch ($SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE()[this.jumpState.ordinal()]) {
            case 1:
                this.jumpState = JUMP_STATE.FALLING;
                break;
            case 3:
                this.lengthJumping = this.position.f159y - this.yGround;
                if (this.lengthJumping > 2.75f) {
                    this.jumpState = JUMP_STATE.FALLING;
                    break;
                } else {
                    this.velocity.f159y = 5.0f;
                    break;
                }
            case 4:
                this.lengthJumping = this.position.f159y - this.yGround;
                if (this.lengthJumping > 0.0f) {
                    break;
                }
                break;
        }
        if (this.jumpState != JUMP_STATE.GROUNDED) {
            updateMotionY(deltaTime);
        }
    }

    private void updateMotionY(float deltaTime) {
        if (this.velocity.f159y != 0.0f) {
            if (this.velocity.f159y > 0.0f) {
                this.velocity.f159y = Math.max(this.velocity.f159y, 0.0f);
            } else {
                this.velocity.f159y = Math.min(this.velocity.f159y, 0.0f);
            }
        }
        Vector2 vector2;
        if (this.velocity.f159y >= 0.0f) {
            vector2 = this.velocity;
            vector2.f159y += (0.9f * this.accelerationY) * deltaTime;
        } else if (this.velocity.f159y < 0.0f) {
            vector2 = this.velocity;
            vector2.f159y += (1.9f * this.accelerationY) * deltaTime;
        }
        this.velocity.f159y = MathUtils.clamp(this.velocity.f159y, -10.5f, 5.0f);
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        this.renderer.draw((Batch) batch, this.skeleton);
        batch.end();
    }

    public void setJumping(boolean touch) {
        switch ($SWITCH_TABLE$com$egovy$jumpmonster$objects$Monster$JUMP_STATE()[this.jumpState.ordinal()]) {
            case 1:
                if (touch) {
                    this.lengthJumping = 0.0f;
                    this.jumpState = JUMP_STATE.JUMP_RISING;
                    Assets.instance.sounds.jump.play();
                    return;
                }
                return;
            case 3:
                if (!touch) {
                    this.jumpState = JUMP_STATE.JUMP_FALLING;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void renderRectangleForDebugging(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(this.boundingRect.f154x, this.boundingRect.f155y, this.boundingRect.width, this.boundingRect.height);
        shapeRenderer.end();
    }

    public float getX() {
        return this.position.f158x;
    }

    public float getWidth() {
        return this.dimension.f158x;
    }

    public Rectangle getBoundingRect() {
        return this.boundingRect;
    }

    public boolean hasDied() {
        return this.isDead;
    }

    public void onRestart() {
        this.position.f158x = -1.0f;
        this.position.f159y = -0.8f;
        this.isDead = false;
        this.isPlayHitGroundSound = false;
        this.state.setAnimation(0, "walk", true);
        this.dieByCollition = false;
        this.dieByReachLimitLine = false;
    }

    public boolean isHitGround() {
        return this.isPlayHitGroundSound;
    }

    public void dieByCollition() {
        this.dieByCollition = true;
    }

    public void dieByReachLimitLine() {
        this.dieByReachLimitLine = true;
    }

    public boolean isDieByCollition() {
        return this.dieByCollition;
    }

    public boolean isDieByReachLimitLine() {
        return this.dieByReachLimitLine;
    }
}
