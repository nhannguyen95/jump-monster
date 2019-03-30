package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class gh implements Creator<gg> {
    /* renamed from: a */
    static void m1023a(gg ggVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, ggVar.getVersionCode());
        C0146b.m219a(parcel, 2, ggVar.fq(), false);
        C0146b.m220a(parcel, 3, ggVar.fr(), i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: Z */
    public gg[] m1024Z(int i) {
        return new gg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1025x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1024Z(x0);
    }

    /* renamed from: x */
    public gg m1025x(Parcel parcel) {
        gd gdVar = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    parcel2 = C0145a.m173B(parcel, n);
                    break;
                case 3:
                    gdVar = (gd) C0145a.m177a(parcel, n, gd.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new gg(i, parcel2, gdVar);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
