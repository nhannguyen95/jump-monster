package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.fc.C0642a;
import java.util.List;

public class fp implements Creator<C0642a> {
    /* renamed from: a */
    static void m978a(C0642a c0642a, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, c0642a.getAccountName(), false);
        C0146b.m235c(parcel, 1000, c0642a.getVersionCode());
        C0146b.m224a(parcel, 2, c0642a.eE(), false);
        C0146b.m235c(parcel, 3, c0642a.eD());
        C0146b.m223a(parcel, 4, c0642a.eG(), false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: Q */
    public C0642a[] m979Q(int i) {
        return new C0642a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m980m(x0);
    }

    /* renamed from: m */
    public C0642a m980m(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0145a.m197o(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    list = C0145a.m172A(parcel, n);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 1000:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0642a(i2, str2, list, i, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m979Q(x0);
    }
}
