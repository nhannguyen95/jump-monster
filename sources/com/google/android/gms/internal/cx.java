package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cx implements SafeParcelable {
    public static final cy CREATOR = new cy();
    public final ApplicationInfo applicationInfo;
    public final String kH;
    public final dx kK;
    public final ak kN;
    public final Bundle pf;
    public final ah pg;
    public final PackageInfo ph;
    public final String pi;
    public final String pj;
    public final String pk;
    public final Bundle pl;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.cx$a */
    public static final class C0238a {
        public final ApplicationInfo applicationInfo;
        public final String kH;
        public final dx kK;
        public final ak kN;
        public final Bundle pf;
        public final ah pg;
        public final PackageInfo ph;
        public final String pj;
        public final String pk;
        public final Bundle pl;

        public C0238a(Bundle bundle, ah ahVar, ak akVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, dx dxVar, Bundle bundle2) {
            this.pf = bundle;
            this.pg = ahVar;
            this.kN = akVar;
            this.kH = str;
            this.applicationInfo = applicationInfo;
            this.ph = packageInfo;
            this.pj = str2;
            this.pk = str3;
            this.kK = dxVar;
            this.pl = bundle2;
        }
    }

    cx(int i, Bundle bundle, ah ahVar, ak akVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, dx dxVar, Bundle bundle2) {
        this.versionCode = i;
        this.pf = bundle;
        this.pg = ahVar;
        this.kN = akVar;
        this.kH = str;
        this.applicationInfo = applicationInfo;
        this.ph = packageInfo;
        this.pi = str2;
        this.pj = str3;
        this.pk = str4;
        this.kK = dxVar;
        this.pl = bundle2;
    }

    public cx(Bundle bundle, ah ahVar, ak akVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, dx dxVar, Bundle bundle2) {
        this(2, bundle, ahVar, akVar, str, applicationInfo, packageInfo, str2, str3, str4, dxVar, bundle2);
    }

    public cx(C0238a c0238a, String str) {
        this(c0238a.pf, c0238a.pg, c0238a.kN, c0238a.kH, c0238a.applicationInfo, c0238a.ph, str, c0238a.pj, c0238a.pk, c0238a.kK, c0238a.pl);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        cy.m718a(this, out, flags);
    }
}
