package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0994h;
import java.util.HashSet;
import java.util.Set;

public class ir implements Creator<C0994h> {
    /* renamed from: a */
    static void m1089a(C0994h c0994h, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = c0994h.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, c0994h.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m235c(parcel, 3, c0994h.jN());
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m223a(parcel, 4, c0994h.getValue(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C0146b.m223a(parcel, 5, c0994h.getLabel(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C0146b.m235c(parcel, 6, c0994h.getType());
        }
        C0146b.m212F(parcel, p);
    }

    public C0994h aW(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0994h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0994h[] bZ(int i) {
        return new C0994h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bZ(x0);
    }
}
