package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class hl implements Creator<hk> {
    /* renamed from: a */
    static void m1070a(hk hkVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, hkVar.xH);
        C0146b.m220a(parcel, 2, hkVar.hZ(), i, false);
        C0146b.m216a(parcel, 3, hkVar.getInterval());
        C0146b.m235c(parcel, 4, hkVar.getPriority());
        C0146b.m212F(parcel, p);
    }

    public hk aF(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        hg hgVar = null;
        long j = hk.OF;
        int i2 = 102;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 2:
                    hgVar = (hg) C0145a.m177a(parcel, n, hg.CREATOR);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 4:
                    i2 = C0145a.m188g(parcel, n);
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
            return new hk(i, hgVar, j, i2);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public hk[] bG(int i) {
        return new hk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bG(x0);
    }
}
