package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class ComparisonFilter<T> implements SafeParcelable, Filter {
    public static final C0176a CREATOR = new C0176a();
    final Operator GG;
    final MetadataBundle GH;
    final MetadataField<T> GI;
    final int xH;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.xH = versionCode;
        this.GG = operator;
        this.GH = value;
        this.GI = C0180e.m340b(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.m1736a(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0176a.m336a(this, out, flags);
    }
}
