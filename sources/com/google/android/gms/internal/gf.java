package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.gd.C0656a;
import com.google.android.gms.internal.gd.C0657b;
import java.util.ArrayList;

public class gf implements Creator<C0656a> {
    /* renamed from: a */
    static void m1020a(C0656a c0656a, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, c0656a.versionCode);
        C0146b.m223a(parcel, 2, c0656a.className, false);
        C0146b.m234b(parcel, 3, c0656a.El, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: Y */
    public C0656a[] m1021Y(int i) {
        return new C0656a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1022w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1021Y(x0);
    }

    /* renamed from: w */
    public C0656a m1022w(Parcel parcel) {
        ArrayList arrayList = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    arrayList = C0145a.m183c(parcel, n, C0657b.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0656a(i, str, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
