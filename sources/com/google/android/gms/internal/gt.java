package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C1054b;
import java.util.Date;

public class gt {
    public static final C1105a Gs = new C1105a("created", 4100000);
    public static final C1106b Gt = new C1106b("lastOpenedTime", 4300000);
    public static final C1108d Gu = new C1108d("modified", 4100000);
    public static final C1107c Gv = new C1107c("modifiedByMe", 4100000);
    public static final C1109e Gw = new C1109e("sharedWithMe", 4100000);

    /* renamed from: com.google.android.gms.internal.gt$a */
    public static class C1105a extends C1054b implements SortableMetadataField<Date> {
        public C1105a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt$b */
    public static class C1106b extends C1054b implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1106b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt$c */
    public static class C1107c extends C1054b implements SortableMetadataField<Date> {
        public C1107c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt$d */
    public static class C1108d extends C1054b implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1108d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt$e */
    public static class C1109e extends C1054b implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1109e(String str, int i) {
            super(str, i);
        }
    }
}
