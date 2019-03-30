package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0992f;
import java.util.HashSet;
import java.util.Set;

public class ip implements Creator<C0992f> {
    /* renamed from: a */
    static void m1087a(C0992f c0992f, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0992f.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0992f.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m223a(parcel, 2, c0992f.getDepartment(), true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m223a(parcel, 3, c0992f.getDescription(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m223a(parcel, 4, c0992f.getEndDate(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C0146b.m223a(parcel, 5, c0992f.getLocation(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C0146b.m223a(parcel, 6, c0992f.getName(), true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C0146b.m226a(parcel, 7, c0992f.isPrimary());
        }
        if (ja.contains(Integer.valueOf(8))) {
            C0146b.m223a(parcel, 8, c0992f.getStartDate(), true);
        }
        if (ja.contains(Integer.valueOf(9))) {
            C0146b.m223a(parcel, 9, c0992f.getTitle(), true);
        }
        if (ja.contains(Integer.valueOf(10))) {
            C0146b.m235c(parcel, 10, c0992f.getType());
        }
        C0146b.m212F(parcel, p);
    }

    public C0992f aU(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = C0145a.m184c(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0992f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0992f[] bX(int i) {
        return new C0992f[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bX(x0);
    }
}
