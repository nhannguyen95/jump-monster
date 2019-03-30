package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0990c;
import java.util.HashSet;
import java.util.Set;

public class in implements Creator<C0990c> {
    /* renamed from: a */
    static void m1085a(C0990c c0990c, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0990c.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0990c.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m223a(parcel, 2, c0990c.getUrl(), true);
        }
        C0146b.m212F(parcel, p);
    }

    public C0990c aS(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0990c(hashSet, i, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0990c[] bV(int i) {
        return new C0990c[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bV(x0);
    }
}
