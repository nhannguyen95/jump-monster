package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.b */
public final class C0904b extends Metadata {
    private final MetadataBundle ED;

    public C0904b(MetadataBundle metadataBundle) {
        this.ED = metadataBundle;
    }

    /* renamed from: a */
    protected <T> T mo2677a(MetadataField<T> metadataField) {
        return this.ED.m1738a((MetadataField) metadataField);
    }

    public Metadata fB() {
        return new C0904b(MetadataBundle.m1737a(this.ED));
    }

    public /* synthetic */ Object freeze() {
        return fB();
    }

    public boolean isDataValid() {
        return this.ED != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.ED + "]";
    }
}
