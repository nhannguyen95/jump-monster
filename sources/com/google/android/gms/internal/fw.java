package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class fw implements Creator<fv> {
    /* renamed from: a */
    static void m996a(fv fvVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, fvVar.getVersionCode());
        C0146b.m220a(parcel, 2, fvVar.eT(), i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: S */
    public fv[] m997S(int i) {
        return new fv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m998q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m997S(x0);
    }

    /* renamed from: q */
    public fv m998q(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        fx fxVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    fxVar = (fx) C0145a.m177a(parcel, n, fx.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new fv(i, fxVar);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
