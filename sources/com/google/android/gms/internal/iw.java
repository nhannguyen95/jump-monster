package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class iw implements Creator<iv> {
    /* renamed from: a */
    static void m1090a(iv ivVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, ivVar.getVersionCode());
        C0146b.m228a(parcel, 2, ivVar.acs, false);
        C0146b.m212F(parcel, p);
    }

    public iv bl(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    iArr = C0145a.m203t(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new iv(i, iArr);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bl(x0);
    }

    public iv[] cx(int i) {
        return new iv[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cx(x0);
    }
}
