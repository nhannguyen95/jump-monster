package com.esotericsoftware.spine.attachments;

import com.esotericsoftware.spine.Skin;

public interface AttachmentLoader {
    BoundingBoxAttachment newBoundingBoxAttachment(Skin skin, String str);

    MeshAttachment newMeshAttachment(Skin skin, String str, String str2);

    RegionAttachment newRegionAttachment(Skin skin, String str, String str2);

    SkinnedMeshAttachment newSkinnedMeshAttachment(Skin skin, String str, String str2);
}
