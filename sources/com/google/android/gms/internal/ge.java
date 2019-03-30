package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.gd.C0656a;
import java.util.ArrayList;

public class ge implements Creator<gd> {
    /* renamed from: a */
    static void m1017a(gd gdVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, gdVar.getVersionCode());
        C0146b.m234b(parcel, 2, gdVar.fn(), false);
        C0146b.m223a(parcel, 3, gdVar.fo(), false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: X */
    public gd[] m1018X(int i) {
        return new gd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1019v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1018X(x0);
    }

    /* renamed from: v */
    public gd m1019v(Parcel parcel) {
        String str = null;
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
                    arrayList = C0145a.m183c(parcel, n, C0656a.CREATOR);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new gd(i, arrayList, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
