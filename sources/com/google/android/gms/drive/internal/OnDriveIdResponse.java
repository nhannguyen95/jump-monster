package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new ab();
    DriveId EV;
    final int xH;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.xH = versionCode;
        this.EV = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.EV;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ab.m253a(this, dest, flags);
    }
}
