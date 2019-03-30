package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C0808h implements SafeParcelable {
    public static final C0367j CREATOR = new C0367j();
    private final String[] Uk;
    private final String[] Ul;
    private final String[] Um;
    private final String Un;
    private final String Uo;
    private final String Up;
    private final String Uq;
    private final PlusCommonExtras Ur;
    private final String wG;
    private final int xH;

    C0808h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.xH = i;
        this.wG = str;
        this.Uk = strArr;
        this.Ul = strArr2;
        this.Um = strArr3;
        this.Un = str2;
        this.Uo = str3;
        this.Up = str4;
        this.Uq = str5;
        this.Ur = plusCommonExtras;
    }

    public C0808h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.xH = 1;
        this.wG = str;
        this.Uk = strArr;
        this.Ul = strArr2;
        this.Um = strArr3;
        this.Un = str2;
        this.Uo = str3;
        this.Up = str4;
        this.Uq = null;
        this.Ur = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0808h)) {
            return false;
        }
        C0808h c0808h = (C0808h) obj;
        return this.xH == c0808h.xH && fo.equal(this.wG, c0808h.wG) && Arrays.equals(this.Uk, c0808h.Uk) && Arrays.equals(this.Ul, c0808h.Ul) && Arrays.equals(this.Um, c0808h.Um) && fo.equal(this.Un, c0808h.Un) && fo.equal(this.Uo, c0808h.Uo) && fo.equal(this.Up, c0808h.Up) && fo.equal(this.Uq, c0808h.Uq) && fo.equal(this.Ur, c0808h.Ur);
    }

    public String getAccountName() {
        return this.wG;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.xH), this.wG, this.Uk, this.Ul, this.Um, this.Un, this.Uo, this.Up, this.Uq, this.Ur);
    }

    public String[] iP() {
        return this.Uk;
    }

    public String[] iQ() {
        return this.Ul;
    }

    public String[] iR() {
        return this.Um;
    }

    public String iS() {
        return this.Un;
    }

    public String iT() {
        return this.Uo;
    }

    public String iU() {
        return this.Up;
    }

    public String iV() {
        return this.Uq;
    }

    public PlusCommonExtras iW() {
        return this.Ur;
    }

    public Bundle iX() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.Ur.m2402m(bundle);
        return bundle;
    }

    public String toString() {
        return fo.m977e(this).m976a("versionCode", Integer.valueOf(this.xH)).m976a("accountName", this.wG).m976a("requestedScopes", this.Uk).m976a("visibleActivities", this.Ul).m976a("requiredFeatures", this.Um).m976a("packageNameForAuth", this.Un).m976a("callingPackageName", this.Uo).m976a("applicationName", this.Up).m976a("extra", this.Ur.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0367j.m1327a(this, out, flags);
    }
}
