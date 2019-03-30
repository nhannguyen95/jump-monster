package com.esotericsoftware.spine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class NormalMapTest extends ApplicationAdapter {
    final Vector3 ambientColor;
    Animation animation;
    String animationName;
    Texture atlasTexture;
    final Vector3 attenuation;
    SpriteBatch batch;
    final Vector3 lightColor;
    final Vector3 lightPosition;
    Texture normalMapTexture;
    ShaderProgram program;
    SkeletonRenderer renderer;
    final Vector2 resolution;
    Skeleton skeleton;
    SkeletonData skeletonData;
    String skeletonPath;
    float time;
    UI ui;

    class UI {
        Slider ambientColorB;
        Slider ambientColorG;
        Slider ambientColorR;
        Slider ambientIntensity;
        Slider attenuationX;
        Slider attenuationY;
        Slider attenuationZ;
        Slider lightColorB;
        Slider lightColorG;
        Slider lightColorR;
        Slider lightZ;
        Preferences prefs;
        Table root;
        Skin skin;
        Stage stage;
        Slider strength;
        final /* synthetic */ NormalMapTest this$0;
        CheckBox useNormals;
        CheckBox useShadow;
        Window window;
        CheckBox yInvert;

        public UI(NormalMapTest normalMapTest) {
            throw new Error("Unresolved compilation problems: \n\tThe import com.badlogic.gdx.backends cannot be resolved\n\tLwjglApplication cannot be resolved to a type\n");
        }

        public void create() {
            throw new Error("Unresolved compilation problem: \n");
        }

        private CheckBox checkbox(String str, boolean z) {
            throw new Error("Unresolved compilation problem: \n");
        }

        private Slider slider(String str, float f) {
            throw new Error("Unresolved compilation problem: \n");
        }
    }

    public NormalMapTest(String str, String str2) {
        throw new Error("Unresolved compilation problems: \n\tThe import com.badlogic.gdx.backends cannot be resolved\n\tLwjglApplication cannot be resolved to a type\n");
    }

    public void create() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void render() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void resize(int i, int i2) {
        throw new Error("Unresolved compilation problem: \n");
    }

    private ShaderProgram createShader() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static void main(String[] strArr) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tLwjglApplication cannot be resolved to a type\n");
    }
}
