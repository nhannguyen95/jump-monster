package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class jz implements Creator<jy> {
    /* renamed from: a */
    static void m1116a(jy jyVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, jyVar.getVersionCode());
        C0146b.m223a(parcel, 2, jyVar.adn, false);
        C0146b.m223a(parcel, 3, jyVar.pm, false);
        C0146b.m220a(parcel, 4, jyVar.adr, i, false);
        C0146b.m220a(parcel, 5, jyVar.ads, i, false);
        C0146b.m220a(parcel, 6, jyVar.adt, i, false);
        C0146b.m212F(parcel, p);
    }

    public jy bx(Parcel parcel) {
        jw jwVar = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        jw jwVar2 = null;
        ju juVar = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    juVar = (ju) C0145a.m177a(parcel, n, ju.CREATOR);
                    break;
                case 5:
                    jwVar2 = (jw) C0145a.m177a(parcel, n, jw.CREATOR);
                    break;
                case 6:
                    jwVar = (jw) C0145a.m177a(parcel, n, jw.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jy(i, str2, str, juVar, jwVar2, jwVar);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public jy[] cL(int i) {
        return new jy[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cL(x0);
    }
}
