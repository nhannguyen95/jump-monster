package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0336v;

public final class Tile implements SafeParcelable {
    public static final TileCreator CREATOR = new TileCreator();
    public final byte[] data;
    public final int height;
    public final int width;
    private final int xH;

    Tile(int versionCode, int width, int height, byte[] data) {
        this.xH = versionCode;
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Tile(int width, int height, byte[] data) {
        this(1, width, height, data);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0336v.iB()) {
            C0345i.m1278a(this, out, flags);
        } else {
            TileCreator.m1267a(this, out, flags);
        }
    }
}
