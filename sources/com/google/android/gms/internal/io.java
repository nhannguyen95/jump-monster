package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0991d;
import java.util.HashSet;
import java.util.Set;

public class io implements Creator<C0991d> {
    /* renamed from: a */
    static void m1086a(C0991d c0991d, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0991d.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0991d.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m223a(parcel, 2, c0991d.getFamilyName(), true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m223a(parcel, 3, c0991d.getFormatted(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m223a(parcel, 4, c0991d.getGivenName(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C0146b.m223a(parcel, 5, c0991d.getHonorificPrefix(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C0146b.m223a(parcel, 6, c0991d.getHonorificSuffix(), true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C0146b.m223a(parcel, 7, c0991d.getMiddleName(), true);
        }
        C0146b.m212F(parcel, p);
    }

    public C0991d aT(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0991d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0991d[] bW(int i) {
        return new C0991d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bW(x0);
    }
}
