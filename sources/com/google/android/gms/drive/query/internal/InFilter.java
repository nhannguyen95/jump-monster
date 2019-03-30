package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.C0918b;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T> implements SafeParcelable, Filter {
    public static final C0181f CREATOR = new C0181f();
    final MetadataBundle GH;
    private final C0918b<T> GR;
    final int xH;

    InFilter(int versionCode, MetadataBundle value) {
        this.xH = versionCode;
        this.GH = value;
        this.GR = (C0918b) C0180e.m340b(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m1736a(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0181f.m341a(this, out, flags);
    }
}
