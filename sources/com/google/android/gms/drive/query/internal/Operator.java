package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new C0185j();
    public static final Operator GU = new Operator("=");
    public static final Operator GV = new Operator("<");
    public static final Operator GW = new Operator("<=");
    public static final Operator GX = new Operator(">");
    public static final Operator GY = new Operator(">=");
    public static final Operator GZ = new Operator("and");
    public static final Operator Ha = new Operator("or");
    public static final Operator Hb = new Operator("not");
    public static final Operator Hc = new Operator("contains");
    final String mTag;
    final int xH;

    Operator(int versionCode, String tag) {
        this.xH = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0185j.m345a(this, out, flags);
    }
}
