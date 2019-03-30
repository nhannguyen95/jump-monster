package com.esotericsoftware.spine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.attachments.AtlasAttachmentLoader;
import com.esotericsoftware.spine.attachments.RegionAttachment;
import java.util.Iterator;

public class Box2DExample extends ApplicationAdapter {
    Animation animation;
    TextureAtlas atlas;
    SpriteBatch batch;
    Box2DDebugRenderer box2dRenderer;
    OrthographicCamera camera;
    Array<Event> events = new Array();
    Body groundBody;
    ShapeRenderer renderer;
    Skeleton skeleton;
    SkeletonRenderer skeletonRenderer;
    float time;
    Matrix4 transform = new Matrix4();
    Vector2 vector = new Vector2();
    World world;

    static class Box2dAttachment extends RegionAttachment {
        Body body;

        public Box2dAttachment(String name) {
            super(name);
        }
    }

    public void create() {
        this.batch = new SpriteBatch();
        this.renderer = new ShapeRenderer();
        this.skeletonRenderer = new SkeletonRenderer();
        this.skeletonRenderer.setPremultipliedAlpha(true);
        this.atlas = new TextureAtlas(Gdx.files.internal("spineboy/spineboy.atlas"));
        SkeletonJson json = new SkeletonJson(new AtlasAttachmentLoader(this.atlas) {
            public RegionAttachment newRegionAttachment(Skin skin, String name, String path) {
                Box2dAttachment attachment = new Box2dAttachment(name);
                AtlasRegion region = Box2DExample.this.atlas.findRegion(attachment.getName());
                if (region == null) {
                    throw new RuntimeException("Region not found in atlas: " + attachment);
                }
                attachment.setRegion(region);
                return attachment;
            }
        });
        json.setScale(0.030000001f);
        SkeletonData skeletonData = json.readSkeletonData(Gdx.files.internal("spineboy/spineboy.json"));
        this.animation = skeletonData.findAnimation("walk");
        this.skeleton = new Skeleton(skeletonData);
        this.skeleton.f88x = -32.0f;
        this.skeleton.f89y = 1.0f;
        this.skeleton.updateWorldTransform();
        this.camera = new OrthographicCamera(48.0f, 32.0f);
        this.camera.position.set(0.0f, 16.0f, 0.0f);
        this.box2dRenderer = new Box2DDebugRenderer();
        createWorld();
        Iterator it = this.skeleton.getSlots().iterator();
        while (it.hasNext()) {
            Slot slot = (Slot) it.next();
            if (slot.getAttachment() instanceof Box2dAttachment) {
                Box2dAttachment attachment = (Box2dAttachment) slot.getAttachment();
                PolygonShape boxPoly = new PolygonShape();
                boxPoly.setAsBox((attachment.getWidth() / 2.0f) * attachment.getScaleX(), (attachment.getHeight() / 2.0f) * attachment.getScaleY(), this.vector.set(attachment.getX(), attachment.getY()), attachment.getRotation() * 0.017453292f);
                BodyDef boxBodyDef = new BodyDef();
                boxBodyDef.type = BodyType.StaticBody;
                attachment.body = this.world.createBody(boxBodyDef);
                attachment.body.createFixture(boxPoly, 1.0f);
                boxPoly.dispose();
            }
        }
    }

    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        float remaining = delta;
        while (remaining > 0.0f) {
            float d = Math.min(0.016f, remaining);
            this.world.step(d, 8, 3);
            this.time += d;
            remaining -= d;
        }
        this.camera.update();
        Gdx.gl.glClear(16384);
        this.batch.setProjectionMatrix(this.camera.projection);
        this.batch.setTransformMatrix(this.camera.view);
        this.batch.begin();
        this.animation.apply(this.skeleton, this.time, this.time, true, this.events);
        Skeleton skeleton = this.skeleton;
        skeleton.f88x += 8.0f * delta;
        this.skeleton.updateWorldTransform();
        this.skeletonRenderer.draw(this.batch, this.skeleton);
        this.batch.end();
        Iterator it = this.skeleton.getSlots().iterator();
        while (it.hasNext()) {
            Slot slot = (Slot) it.next();
            if (slot.getAttachment() instanceof Box2dAttachment) {
                Box2dAttachment attachment = (Box2dAttachment) slot.getAttachment();
                if (attachment.body != null) {
                    attachment.body.setTransform(this.skeleton.f88x + slot.getBone().getWorldX(), this.skeleton.f89y + slot.getBone().getWorldY(), 0.017453292f * slot.getBone().getWorldRotation());
                }
            }
        }
        this.box2dRenderer.render(this.world, this.camera.combined);
    }

    public void resize(int width, int height) {
        this.batch.setProjectionMatrix(this.camera.projection);
        this.renderer.setProjectionMatrix(this.camera.projection);
    }

    private void createWorld() {
        this.world = new World(new Vector2(0.0f, -10.0f), true);
        new PolygonShape().set(new float[]{-0.07421887f, -0.16276085f, -0.12109375f, -0.22786504f, -0.157552f, -0.7122401f, 0.04296875f, -0.7122401f, 0.110677004f, -0.6419276f, 0.13151026f, -0.49869835f, 0.08984375f, -0.3190109f});
        PolygonShape groundPoly = new PolygonShape();
        groundPoly.setAsBox(50.0f, 1.0f);
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyType.StaticBody;
        this.groundBody = this.world.createBody(groundBodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = groundPoly;
        fixtureDef.filter.groupIndex = (short) 0;
        this.groundBody.createFixture(fixtureDef);
        groundPoly.dispose();
        PolygonShape boxPoly = new PolygonShape();
        boxPoly.setAsBox(1.0f, 1.0f);
        for (int i = 0; i < 20; i++) {
            BodyDef boxBodyDef = new BodyDef();
            boxBodyDef.type = BodyType.DynamicBody;
            boxBodyDef.position.f158x = -24.0f + ((float) (Math.random() * 48.0d));
            boxBodyDef.position.f159y = 10.0f + ((float) (Math.random() * 100.0d));
            this.world.createBody(boxBodyDef).createFixture(boxPoly, 1.0f);
        }
        boxPoly.dispose();
    }

    public void dispose() {
        this.atlas.dispose();
    }

    public static void main(String[] strArr) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tLwjglApplicationConfiguration cannot be resolved to a type\n\tLwjglApplicationConfiguration cannot be resolved to a type\n\tLwjglApplication cannot be resolved to a type\n");
    }
}
