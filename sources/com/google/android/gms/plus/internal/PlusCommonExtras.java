package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0147c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;

public class PlusCommonExtras implements SafeParcelable {
    public static final C0363f CREATOR = new C0363f();
    public static String TAG = "PlusCommonExtras";
    private String Uh;
    private String Ui;
    private final int xH;

    public PlusCommonExtras() {
        this.xH = 1;
        this.Uh = "";
        this.Ui = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.xH = versionCode;
        this.Uh = gpsrc;
        this.Ui = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.xH == plusCommonExtras.xH && fo.equal(this.Uh, plusCommonExtras.Uh) && fo.equal(this.Ui, plusCommonExtras.Ui);
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.xH), this.Uh, this.Ui);
    }

    public String iN() {
        return this.Uh;
    }

    public String iO() {
        return this.Ui;
    }

    /* renamed from: m */
    public void m2402m(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", C0147c.m238a(this));
    }

    public String toString() {
        return fo.m977e(this).m976a("versionCode", Integer.valueOf(this.xH)).m976a("Gpsrc", this.Uh).m976a("ClientCallingPackage", this.Ui).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0363f.m1322a(this, out, flags);
    }
}
