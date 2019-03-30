package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class DepthShader extends DefaultShader {
    private static String defaultFragmentShader = null;
    private static String defaultVertexShader = null;
    private final FloatAttribute alphaTestAttribute;
    public final int numBones;
    public final int weights;

    public static class Config extends com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config {
        public float defaultAlphaTest;
        public boolean depthBufferOnly;

        public Config() {
            this.depthBufferOnly = false;
            this.defaultAlphaTest = 0.5f;
            this.defaultCullFace = GL20.GL_FRONT;
        }

        public Config(String vertexShader, String fragmentShader) {
            super(vertexShader, fragmentShader);
            this.depthBufferOnly = false;
            this.defaultAlphaTest = 0.5f;
        }
    }

    public static final String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public static final String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public static String createPrefix(Renderable renderable, Config config) {
        String prefix = DefaultShader.createPrefix(renderable, config);
        if (config.depthBufferOnly) {
            return prefix;
        }
        return prefix + "#define PackedDepthFlag\n";
    }

    public DepthShader(Renderable renderable) {
        this(renderable, new Config());
    }

    public DepthShader(Renderable renderable, Config config) {
        this(renderable, config, createPrefix(renderable, config));
    }

    public DepthShader(Renderable renderable, Config config, String prefix) {
        this(renderable, config, prefix, config.vertexShader != null ? config.vertexShader : getDefaultVertexShader(), config.fragmentShader != null ? config.fragmentShader : getDefaultFragmentShader());
    }

    public DepthShader(Renderable renderable, Config config, String prefix, String vertexShader, String fragmentShader) {
        this(renderable, config, new ShaderProgram(prefix + vertexShader, prefix + fragmentShader));
    }

    public DepthShader(Renderable renderable, Config config, ShaderProgram shaderProgram) {
        super(renderable, (com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config) config, shaderProgram);
        this.numBones = renderable.bones == null ? 0 : config.numBones;
        int w = 0;
        int n = renderable.mesh.getVertexAttributes().size();
        for (int i = 0; i < n; i++) {
            VertexAttribute attr = renderable.mesh.getVertexAttributes().get(i);
            if (attr.usage == 64) {
                w |= 1 << attr.unit;
            }
        }
        this.weights = w;
        this.alphaTestAttribute = new FloatAttribute(FloatAttribute.AlphaTest, config.defaultAlphaTest);
    }

    public void begin(Camera camera, RenderContext context) {
        super.begin(camera, context);
    }

    public void end() {
        super.end();
    }

    public boolean canRender(Renderable renderable) {
        if (renderable.material.has(BlendingAttribute.Type)) {
            if ((this.materialMask & BlendingAttribute.Type) != BlendingAttribute.Type) {
                return false;
            }
            if (renderable.material.has(TextureAttribute.Diffuse) != ((this.materialMask & TextureAttribute.Diffuse) == TextureAttribute.Diffuse)) {
                return false;
            }
        }
        boolean skinned = (renderable.mesh.getVertexAttributes().getMask() & 64) == 64;
        if (skinned != (this.numBones > 0)) {
            return false;
        }
        if (!skinned) {
            return true;
        }
        int w = 0;
        int n = renderable.mesh.getVertexAttributes().size();
        for (int i = 0; i < n; i++) {
            VertexAttribute attr = renderable.mesh.getVertexAttributes().get(i);
            if (attr.usage == 64) {
                w |= 1 << attr.unit;
            }
        }
        return w == this.weights;
    }

    public void render(Renderable renderable) {
        if (renderable.material.has(BlendingAttribute.Type)) {
            BlendingAttribute blending = (BlendingAttribute) renderable.material.get(BlendingAttribute.Type);
            renderable.material.remove(BlendingAttribute.Type);
            boolean hasAlphaTest = renderable.material.has(FloatAttribute.AlphaTest);
            if (!hasAlphaTest) {
                renderable.material.set(this.alphaTestAttribute);
            }
            if (blending.opacity >= ((FloatAttribute) renderable.material.get(FloatAttribute.AlphaTest)).value) {
                super.render(renderable);
            }
            if (!hasAlphaTest) {
                renderable.material.remove(FloatAttribute.AlphaTest);
            }
            renderable.material.set((Attribute) blending);
            return;
        }
        super.render(renderable);
    }
}
