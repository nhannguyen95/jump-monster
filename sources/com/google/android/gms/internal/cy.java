package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class cy implements Creator<cx> {
    /* renamed from: a */
    static void m718a(cx cxVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, cxVar.versionCode);
        C0146b.m217a(parcel, 2, cxVar.pf, false);
        C0146b.m220a(parcel, 3, cxVar.pg, i, false);
        C0146b.m220a(parcel, 4, cxVar.kN, i, false);
        C0146b.m223a(parcel, 5, cxVar.kH, false);
        C0146b.m220a(parcel, 6, cxVar.applicationInfo, i, false);
        C0146b.m220a(parcel, 7, cxVar.ph, i, false);
        C0146b.m223a(parcel, 8, cxVar.pi, false);
        C0146b.m223a(parcel, 9, cxVar.pj, false);
        C0146b.m223a(parcel, 10, cxVar.pk, false);
        C0146b.m220a(parcel, 11, cxVar.kK, i, false);
        C0146b.m217a(parcel, 12, cxVar.pl, false);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m719f(x0);
    }

    /* renamed from: f */
    public cx m719f(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        Bundle bundle = null;
        ah ahVar = null;
        ak akVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        dx dxVar = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 3:
                    ahVar = (ah) C0145a.m177a(parcel, n, ah.CREATOR);
                    break;
                case 4:
                    akVar = (ak) C0145a.m177a(parcel, n, ak.CREATOR);
                    break;
                case 5:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0145a.m177a(parcel, n, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0145a.m177a(parcel, n, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 9:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 10:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 11:
                    dxVar = (dx) C0145a.m177a(parcel, n, dx.CREATOR);
                    break;
                case 12:
                    bundle2 = C0145a.m199p(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cx(i, bundle, ahVar, akVar, str, applicationInfo, packageInfo, str2, str3, str4, dxVar, bundle2);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: k */
    public cx[] m720k(int i) {
        return new cx[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m720k(x0);
    }
}
