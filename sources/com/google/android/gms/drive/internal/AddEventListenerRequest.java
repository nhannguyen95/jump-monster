package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR = new C0155a();
    final int ES;
    final PendingIntent ET;
    final DriveId Ew;
    final int xH;

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType, PendingIntent subscriptionIntent) {
        this.xH = versionCode;
        this.Ew = driveId;
        this.ES = eventType;
        this.ET = subscriptionIntent;
    }

    public AddEventListenerRequest(DriveId id, int eventType, PendingIntent subscriptionIntent) {
        this(1, id, eventType, subscriptionIntent);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0155a.m249a(this, dest, flags);
    }
}
