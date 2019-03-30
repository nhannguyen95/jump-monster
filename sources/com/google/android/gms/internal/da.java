package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

public class da implements Creator<cz> {
    /* renamed from: a */
    static void m721a(cz czVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, czVar.versionCode);
        C0146b.m223a(parcel, 2, czVar.ol, false);
        C0146b.m223a(parcel, 3, czVar.pm, false);
        C0146b.m224a(parcel, 4, czVar.ne, false);
        C0146b.m235c(parcel, 5, czVar.errorCode);
        C0146b.m224a(parcel, 6, czVar.nf, false);
        C0146b.m216a(parcel, 7, czVar.pn);
        C0146b.m226a(parcel, 8, czVar.po);
        C0146b.m216a(parcel, 9, czVar.pp);
        C0146b.m224a(parcel, 10, czVar.pq, false);
        C0146b.m216a(parcel, 11, czVar.ni);
        C0146b.m235c(parcel, 12, czVar.orientation);
        C0146b.m223a(parcel, 13, czVar.pr, false);
        C0146b.m216a(parcel, 14, czVar.ps);
        C0146b.m223a(parcel, 15, czVar.pt, false);
        C0146b.m223a(parcel, 19, czVar.pv, false);
        C0146b.m226a(parcel, 18, czVar.pu);
        C0146b.m223a(parcel, 21, czVar.pw, false);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m722g(x0);
    }

    /* renamed from: g */
    public cz m722g(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    list = C0145a.m172A(parcel, n);
                    break;
                case 5:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 6:
                    list2 = C0145a.m172A(parcel, n);
                    break;
                case 7:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 8:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 9:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 10:
                    list3 = C0145a.m172A(parcel, n);
                    break;
                case 11:
                    j3 = C0145a.m190i(parcel, n);
                    break;
                case 12:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 13:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 14:
                    j4 = C0145a.m190i(parcel, n);
                    break;
                case 15:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 18:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 19:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 21:
                    str6 = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cz(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: l */
    public cz[] m723l(int i) {
        return new cz[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m723l(x0);
    }
}
