package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jy implements SafeParcelable {
    public static final Creator<jy> CREATOR = new jz();
    String adn;
    ju adr;
    jw ads;
    jw adt;
    String pm;
    private final int xH;

    jy() {
        this.xH = 1;
    }

    jy(int i, String str, String str2, ju juVar, jw jwVar, jw jwVar2) {
        this.xH = i;
        this.adn = str;
        this.pm = str2;
        this.adr = juVar;
        this.ads = jwVar;
        this.adt = jwVar2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        jz.m1116a(this, dest, flags);
    }
}
