package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.fx.C0654a;
import java.util.ArrayList;

public class fy implements Creator<fx> {
    /* renamed from: a */
    static void m999a(fx fxVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, fxVar.getVersionCode());
        C0146b.m234b(parcel, 2, fxVar.eV(), false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: T */
    public fx[] m1000T(int i) {
        return new fx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1001r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1000T(x0);
    }

    /* renamed from: r */
    public fx m1001r(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    arrayList = C0145a.m183c(parcel, n, C0654a.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new fx(i, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
