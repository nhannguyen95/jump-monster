package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0986a;
import java.util.HashSet;
import java.util.Set;

public class ij implements Creator<C0986a> {
    /* renamed from: a */
    static void m1081a(C0986a c0986a, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0986a.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0986a.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m235c(parcel, 2, c0986a.getMax());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m235c(parcel, 3, c0986a.getMin());
        }
        C0146b.m212F(parcel, p);
    }

    public C0986a aO(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0986a(hashSet, i3, i2, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0986a[] bR(int i) {
        return new C0986a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bR(x0);
    }
}
