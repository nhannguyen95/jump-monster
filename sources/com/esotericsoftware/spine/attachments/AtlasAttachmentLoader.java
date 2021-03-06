package com.esotericsoftware.spine.attachments;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.esotericsoftware.spine.Skin;

public class AtlasAttachmentLoader implements AttachmentLoader {
    private TextureAtlas atlas;

    public AtlasAttachmentLoader(TextureAtlas atlas) {
        if (atlas == null) {
            throw new IllegalArgumentException("atlas cannot be null.");
        }
        this.atlas = atlas;
    }

    public RegionAttachment newRegionAttachment(Skin skin, String name, String path) {
        AtlasRegion region = this.atlas.findRegion(path);
        if (region == null) {
            throw new RuntimeException("Region not found in atlas: " + path + " (region attachment: " + name + ")");
        }
        RegionAttachment attachment = new RegionAttachment(name);
        attachment.setRegion(region);
        return attachment;
    }

    public MeshAttachment newMeshAttachment(Skin skin, String name, String path) {
        AtlasRegion region = this.atlas.findRegion(path);
        if (region == null) {
            throw new RuntimeException("Region not found in atlas: " + path + " (mesh attachment: " + name + ")");
        }
        MeshAttachment attachment = new MeshAttachment(name);
        attachment.setRegion(region);
        return attachment;
    }

    public SkinnedMeshAttachment newSkinnedMeshAttachment(Skin skin, String name, String path) {
        AtlasRegion region = this.atlas.findRegion(path);
        if (region == null) {
            throw new RuntimeException("Region not found in atlas: " + path + " (skinned mesh attachment: " + name + ")");
        }
        SkinnedMeshAttachment attachment = new SkinnedMeshAttachment(name);
        attachment.setRegion(region);
        return attachment;
    }

    public BoundingBoxAttachment newBoundingBoxAttachment(Skin skin, String name) {
        return new BoundingBoxAttachment(name);
    }
}
