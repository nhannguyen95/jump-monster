package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0989b;
import com.google.android.gms.internal.ih.C0989b.C0987a;
import com.google.android.gms.internal.ih.C0989b.C0988b;
import java.util.HashSet;
import java.util.Set;

public class ik implements Creator<C0989b> {
    /* renamed from: a */
    static void m1082a(C0989b c0989b, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0989b.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0989b.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m220a(parcel, 2, c0989b.jE(), i, true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m220a(parcel, 3, c0989b.jF(), i, true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m235c(parcel, 4, c0989b.getLayout());
        }
        C0146b.m212F(parcel, p);
    }

    public C0989b aP(Parcel parcel) {
        C0988b c0988b = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        C0987a c0987a = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    C0987a c0987a2 = (C0987a) C0145a.m177a(parcel, n, C0987a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c0987a = c0987a2;
                    break;
                case 3:
                    C0988b c0988b2 = (C0988b) C0145a.m177a(parcel, n, C0988b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0988b = c0988b2;
                    break;
                case 4:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0989b(hashSet, i2, c0987a, c0988b, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0989b[] bS(int i) {
        return new C0989b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bS(x0);
    }
}
