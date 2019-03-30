package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class jq implements Creator<jp> {
    /* renamed from: a */
    static void m1111a(jp jpVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, jpVar.getVersionCode());
        C0146b.m235c(parcel, 2, jpVar.adh);
        C0146b.m223a(parcel, 3, jpVar.adi, false);
        C0146b.m214a(parcel, 4, jpVar.adj);
        C0146b.m223a(parcel, 5, jpVar.adk, false);
        C0146b.m216a(parcel, 6, jpVar.adl);
        C0146b.m235c(parcel, 7, jpVar.adm);
        C0146b.m212F(parcel, p);
    }

    public jp bs(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    d = C0145a.m193l(parcel, n);
                    break;
                case 5:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 7:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jp(i3, i, str2, d, str, j, i2);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public jp[] cG(int i) {
        return new jp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cG(x0);
    }
}
