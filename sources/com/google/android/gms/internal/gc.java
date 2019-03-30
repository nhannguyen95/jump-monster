package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ga.C0655a;
import com.google.android.gms.internal.gd.C0657b;

public class gc implements Creator<C0657b> {
    /* renamed from: a */
    static void m1014a(C0657b c0657b, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, c0657b.versionCode);
        C0146b.m223a(parcel, 2, c0657b.eM, false);
        C0146b.m220a(parcel, 3, c0657b.Em, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: W */
    public C0657b[] m1015W(int i) {
        return new C0657b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1016u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1015W(x0);
    }

    /* renamed from: u */
    public C0657b m1016u(Parcel parcel) {
        C0655a c0655a = null;
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
                    c0655a = (C0655a) C0145a.m177a(parcel, n, C0655a.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0657b(i, str, c0655a);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
