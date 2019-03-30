package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.ArrayList;

public class jn implements Creator<jm> {
    /* renamed from: a */
    static void m1110a(jm jmVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, jmVar.getVersionCode());
        C0146b.m223a(parcel, 2, jmVar.add, false);
        C0146b.m223a(parcel, 3, jmVar.ade, false);
        C0146b.m234b(parcel, 4, jmVar.adf, false);
        C0146b.m212F(parcel, p);
    }

    public jm br(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        ArrayList fs = gi.fs();
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
                    fs = C0145a.m183c(parcel, n, jk.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jm(i, str2, str, fs);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public jm[] cF(int i) {
        return new jm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return br(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cF(x0);
    }
}
