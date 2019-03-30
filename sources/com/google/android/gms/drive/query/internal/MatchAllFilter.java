package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class MatchAllFilter implements SafeParcelable, Filter {
    public static final C0183h CREATOR = new C0183h();
    final int xH;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.xH = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0183h.m343a(this, out, flags);
    }
}
