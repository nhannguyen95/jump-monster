package com.google.android.gms.internal;

import android.graphics.Bitmap;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.C0918b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C0920a;
import com.google.android.gms.drive.metadata.internal.C0922e;
import com.google.android.gms.drive.metadata.internal.C0923h;
import com.google.android.gms.drive.metadata.internal.C0924j;
import com.google.android.gms.drive.metadata.internal.C1055g;
import com.google.android.gms.drive.metadata.internal.C1056i;
import com.google.android.gms.plus.PlusShare;

public class gs {
    public static final MetadataField<DriveId> FR = gu.Gx;
    public static final MetadataField<String> FS = new C0924j("alternateLink", 4300000);
    public static final MetadataField<String> FT = new C0924j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField<String> FU = new C0924j("embedLink", 4300000);
    public static final MetadataField<String> FV = new C0924j("fileExtension", 4300000);
    public static final MetadataField<Long> FW = new C0922e("fileSize", 4300000);
    public static final MetadataField<Boolean> FX = new C0920a("hasThumbnail", 4300000);
    public static final MetadataField<String> FY = new C0924j("indexableText", 4300000);
    public static final MetadataField<Boolean> FZ = new C0920a("isAppData", 4300000);
    public static final MetadataField<Boolean> Ga = new C0920a("isCopyable", 4300000);
    public static final MetadataField<Boolean> Gb = new C0920a("isEditable", 4100000);
    public static final C1063a Gc = new C1063a("isPinned", 4100000);
    public static final MetadataField<Boolean> Gd = new C0920a("isRestricted", 4300000);
    public static final MetadataField<Boolean> Ge = new C0920a("isShared", 4300000);
    public static final MetadataField<Boolean> Gf = new C0920a("isTrashable", 4400000);
    public static final MetadataField<Boolean> Gg = new C0920a("isViewed", 4300000);
    public static final C1064b Gh = new C1064b("mimeType", 4100000);
    public static final MetadataField<String> Gi = new C0924j("originalFilename", 4300000);
    public static final C0918b<String> Gj = new C1056i("ownerNames", 4300000);
    public static final C1104c Gk = new C1104c("parents", 4100000);
    public static final C1065d Gl = new C1065d("quotaBytesUsed", 4300000);
    public static final C1066e Gm = new C1066e("starred", 4100000);
    public static final MetadataField<Bitmap> Gn = new C0923h<Bitmap>("thumbnail", 4400000) {
        /* renamed from: b */
        protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
            return m3405i(dataHolder, i, i2);
        }

        /* renamed from: i */
        protected Bitmap m3405i(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final C1067f Go = new C1067f(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final C1068g Gp = new C1068g("trashed", 4100000);
    public static final MetadataField<String> Gq = new C0924j("webContentLink", 4300000);
    public static final MetadataField<String> Gr = new C0924j("webViewLink", 4300000);

    /* renamed from: com.google.android.gms.internal.gs$a */
    public static class C1063a extends C0920a implements SearchableMetadataField<Boolean> {
        public C1063a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs$b */
    public static class C1064b extends C0924j implements SearchableMetadataField<String> {
        public C1064b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs$d */
    public static class C1065d extends C0922e implements SortableMetadataField<Long> {
        public C1065d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs$e */
    public static class C1066e extends C0920a implements SearchableMetadataField<Boolean> {
        public C1066e(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs$f */
    public static class C1067f extends C0924j implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public C1067f(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs$g */
    public static class C1068g extends C0920a implements SearchableMetadataField<Boolean> {
        public C1068g(String str, int i) {
            super(str, i);
        }

        /* renamed from: b */
        protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
            return mo3245d(dataHolder, i, i2);
        }

        /* renamed from: d */
        protected Boolean mo3245d(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs$c */
    public static class C1104c extends C1055g<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public C1104c(String str, int i) {
            super(str, i);
        }
    }
}
