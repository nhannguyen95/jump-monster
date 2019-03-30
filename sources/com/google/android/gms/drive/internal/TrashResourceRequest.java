package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new am();
    final DriveId EV;
    final int xH;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.xH = versionCode;
        this.EV = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        am.m273a(this, dest, flags);
    }
}
