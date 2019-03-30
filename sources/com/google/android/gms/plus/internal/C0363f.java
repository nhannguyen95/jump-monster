package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.plus.internal.f */
public class C0363f implements Creator<PlusCommonExtras> {
    /* renamed from: a */
    static void m1322a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, plusCommonExtras.iN(), false);
        C0146b.m235c(parcel, 1000, plusCommonExtras.getVersionCode());
        C0146b.m223a(parcel, 2, plusCommonExtras.iO(), false);
        C0146b.m212F(parcel, p);
    }

    public PlusCommonExtras aJ(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 1000:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PlusCommonExtras(i, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public PlusCommonExtras[] bM(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bM(x0);
    }
}
