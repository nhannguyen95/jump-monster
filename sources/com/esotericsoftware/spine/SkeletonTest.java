package com.esotericsoftware.spine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class SkeletonTest extends ApplicationAdapter {
    static final float checkModifiedInterval = 0.25f;
    static final float reloadDelay = 1.0f;
    PolygonSpriteBatch batch;
    SkeletonRendererDebug debugRenderer;
    long lastModified;
    float lastModifiedCheck;
    float reloadTimer;
    SkeletonRenderer renderer;
    Skeleton skeleton;
    SkeletonData skeletonData;
    FileHandle skeletonFile;
    int skeletonX;
    int skeletonY;
    AnimationState state;
    UI ui;

    class UI {
        List<String> animationList;
        TextButton bonesSetupPoseButton;
        TextButton browseButton;
        CheckBox debugBonesCheckbox;
        CheckBox debugBoundingBoxesCheckbox;
        CheckBox debugMeshHullCheckbox;
        CheckBox debugMeshTrianglesCheckbox;
        CheckBox debugRegionsCheckbox;
        CheckBox flipXCheckbox;
        CheckBox flipYCheckbox;
        CheckBox loopCheckbox;
        TextButton minimizeButton;
        Label mixLabel;
        Slider mixSlider;
        TextButton pauseButton;
        CheckBox premultipliedCheckbox;
        Table root;
        Label scaleLabel;
        Slider scaleSlider;
        TextButton setupPoseButton;
        Label skeletonLabel;
        Skin skin;
        List<String> skinList;
        TextButton slotsSetupPoseButton;
        Label speedLabel;
        Slider speedSlider;
        Stage stage;
        final /* synthetic */ SkeletonTest this$0;
        WidgetGroup toasts;
        Window window;

        public UI(SkeletonTest skeletonTest) {
            throw new Error("Unresolved compilation problems: \n\tThe import com.badlogic.gdx.backends cannot be resolved\n\tLwjglApplication cannot be resolved to a type\n");
        }

        private Table table(Actor... actorArr) {
            throw new Error("Unresolved compilation problem: \n");
        }

        void toast(String str) {
            throw new Error("Unresolved compilation problem: \n");
        }
    }

    public SkeletonTest() {
        throw new Error("Unresolved compilation problems: \n\tThe import com.badlogic.gdx.backends cannot be resolved\n\tLwjglApplication cannot be resolved to a type\n");
    }

    public void create() {
        throw new Error("Unresolved compilation problem: \n");
    }

    void loadSkeleton(FileHandle fileHandle, boolean z) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void render() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void resize(int i, int i2) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static void main(String[] strArr) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tLwjglApplication cannot be resolved to a type\n");
    }
}
