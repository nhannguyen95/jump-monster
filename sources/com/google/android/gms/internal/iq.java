package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0993g;
import java.util.HashSet;
import java.util.Set;

public class iq implements Creator<C0993g> {
    /* renamed from: a */
    static void m1088a(C0993g c0993g, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0993g.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0993g.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m226a(parcel, 2, c0993g.isPrimary());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m223a(parcel, 3, c0993g.getValue(), true);
        }
        C0146b.m212F(parcel, p);
    }

    public C0993g aV(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = C0145a.m184c(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0993g(hashSet, i, z, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0993g[] bY(int i) {
        return new C0993g[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bY(x0);
    }
}
