package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.fx.C0654a;

public class fz implements Creator<C0654a> {
    /* renamed from: a */
    static void m1002a(C0654a c0654a, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, c0654a.versionCode);
        C0146b.m223a(parcel, 2, c0654a.DW, false);
        C0146b.m235c(parcel, 3, c0654a.DX);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: U */
    public C0654a[] m1003U(int i) {
        return new C0654a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1004s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1003U(x0);
    }

    /* renamed from: s */
    public C0654a m1004s(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0654a(i2, str, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
