package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class iy implements Creator<ix> {
    /* renamed from: a */
    static void m1091a(ix ixVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, ixVar.getVersionCode());
        C0146b.m230a(parcel, 2, ixVar.act, false);
        C0146b.m231a(parcel, 3, ixVar.acu, false);
        C0146b.m212F(parcel, p);
    }

    public ix bm(Parcel parcel) {
        String[] strArr = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    strArr = C0145a.m209z(parcel, n);
                    break;
                case 3:
                    bArr = C0145a.m201r(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ix(i, strArr, bArr);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bm(x0);
    }

    public ix[] cy(int i) {
        return new ix[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cy(x0);
    }
}
