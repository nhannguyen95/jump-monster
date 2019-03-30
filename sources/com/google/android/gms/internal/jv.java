package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class jv implements Creator<ju> {
    /* renamed from: a */
    static void m1114a(ju juVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, juVar.getVersionCode());
        C0146b.m216a(parcel, 2, juVar.ado);
        C0146b.m216a(parcel, 3, juVar.adp);
        C0146b.m212F(parcel, p);
    }

    public ju bv(Parcel parcel) {
        long j = 0;
        int o = C0145a.m197o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ju(i, j2, j);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ju[] cJ(int i) {
        return new ju[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cJ(x0);
    }
}
