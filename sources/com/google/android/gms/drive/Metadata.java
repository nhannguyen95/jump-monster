package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    /* renamed from: a */
    protected abstract <T> T mo2677a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) mo2677a(gs.FS);
    }

    public int getContentAvailability() {
        Integer num = (Integer) mo2677a(gv.Gy);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) mo2677a(gt.Gs);
    }

    public String getDescription() {
        return (String) mo2677a(gs.FT);
    }

    public DriveId getDriveId() {
        return (DriveId) mo2677a(gs.FR);
    }

    public String getEmbedLink() {
        return (String) mo2677a(gs.FU);
    }

    public String getFileExtension() {
        return (String) mo2677a(gs.FV);
    }

    public long getFileSize() {
        return ((Long) mo2677a(gs.FW)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) mo2677a(gt.Gt);
    }

    public String getMimeType() {
        return (String) mo2677a(gs.Gh);
    }

    public Date getModifiedByMeDate() {
        return (Date) mo2677a(gt.Gv);
    }

    public Date getModifiedDate() {
        return (Date) mo2677a(gt.Gu);
    }

    public String getOriginalFilename() {
        return (String) mo2677a(gs.Gi);
    }

    public long getQuotaBytesUsed() {
        return ((Long) mo2677a(gs.Gl)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) mo2677a(gt.Gw);
    }

    public String getTitle() {
        return (String) mo2677a(gs.Go);
    }

    public String getWebContentLink() {
        return (String) mo2677a(gs.Gq);
    }

    public String getWebViewLink() {
        return (String) mo2677a(gs.Gr);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) mo2677a(gs.Gb);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) mo2677a(gs.FZ);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) mo2677a(gv.Gz);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) mo2677a(gs.Gc);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) mo2677a(gs.Gd);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) mo2677a(gs.Ge);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) mo2677a(gs.Gm);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) mo2677a(gs.Gp);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) mo2677a(gs.Gg);
        return bool == null ? false : bool.booleanValue();
    }
}
