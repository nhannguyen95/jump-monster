package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jk implements SafeParcelable {
    public static final Creator<jk> CREATOR = new jl();
    String label;
    String value;
    private final int xH;

    jk() {
        this.xH = 1;
    }

    jk(int i, String str, String str2) {
        this.xH = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        jl.m1109a(this, dest, flags);
    }
}
