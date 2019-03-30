package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C0284b;

public class fv implements SafeParcelable {
    public static final fw CREATOR = new fw();
    private final fx DS;
    private final int xH;

    fv(int i, fx fxVar) {
        this.xH = i;
        this.DS = fxVar;
    }

    private fv(fx fxVar) {
        this.xH = 1;
        this.DS = fxVar;
    }

    /* renamed from: a */
    public static fv m2212a(C0284b<?, ?> c0284b) {
        if (c0284b instanceof fx) {
            return new fv((fx) c0284b);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        fw fwVar = CREATOR;
        return 0;
    }

    fx eT() {
        return this.DS;
    }

    public C0284b<?, ?> eU() {
        if (this.DS != null) {
            return this.DS;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel out, int flags) {
        fw fwVar = CREATOR;
        fw.m996a(this, out, flags);
    }
}
