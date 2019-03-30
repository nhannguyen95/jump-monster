package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder implements SafeParcelable {
    public static final C0178c CREATOR = new C0178c();
    final String FM;
    final boolean GJ;
    final int xH;

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.xH = versionCode;
        this.FM = fieldName;
        this.GJ = isSortAscending;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0178c.m338a(this, out, flags);
    }
}
