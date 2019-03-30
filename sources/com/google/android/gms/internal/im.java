package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0989b.C0988b;
import java.util.HashSet;
import java.util.Set;

public class im implements Creator<C0988b> {
    /* renamed from: a */
    static void m1084a(C0988b c0988b, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0988b.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0988b.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m235c(parcel, 2, c0988b.getHeight());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m223a(parcel, 3, c0988b.getUrl(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m235c(parcel, 4, c0988b.getWidth());
        }
        C0146b.m212F(parcel, p);
    }

    public C0988b aR(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
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
            return new C0988b(hashSet, i3, i2, str, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0988b[] bU(int i) {
        return new C0988b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bU(x0);
    }
}
