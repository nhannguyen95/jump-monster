package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

public class hh implements Creator<hg> {
    /* renamed from: a */
    static void m1068a(hg hgVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m234b(parcel, 1, hgVar.OA, false);
        C0146b.m235c(parcel, 1000, hgVar.xH);
        C0146b.m223a(parcel, 2, hgVar.hW(), false);
        C0146b.m226a(parcel, 3, hgVar.hX());
        C0146b.m212F(parcel, p);
    }

    public hg aD(Parcel parcel) {
        String str = null;
        boolean z = false;
        int o = C0145a.m197o(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    list = C0145a.m183c(parcel, n, hm.CREATOR);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 1000:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new hg(i, list, str, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public hg[] bE(int i) {
        return new hg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
