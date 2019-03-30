package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new ag();
    final boolean Fg;
    final int xH;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.xH = versionCode;
        this.Fg = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ag.m263a(this, dest, flags);
    }
}
