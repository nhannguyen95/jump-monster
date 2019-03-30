package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ga.C0655a;

public class gb implements Creator<C0655a> {
    /* renamed from: a */
    static void m1011a(C0655a c0655a, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, c0655a.getVersionCode());
        C0146b.m235c(parcel, 2, c0655a.eW());
        C0146b.m226a(parcel, 3, c0655a.fc());
        C0146b.m235c(parcel, 4, c0655a.eX());
        C0146b.m226a(parcel, 5, c0655a.fd());
        C0146b.m223a(parcel, 6, c0655a.fe(), false);
        C0146b.m235c(parcel, 7, c0655a.ff());
        C0146b.m223a(parcel, 8, c0655a.fh(), false);
        C0146b.m220a(parcel, 9, c0655a.fj(), i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: V */
    public C0655a[] m1012V(int i) {
        return new C0655a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1013t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1012V(x0);
    }

    /* renamed from: t */
    public C0655a m1013t(Parcel parcel) {
        fv fvVar = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 4:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 6:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 8:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 9:
                    fvVar = (fv) C0145a.m177a(parcel, n, fv.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0655a(i4, i3, z2, i2, z, str2, i, str, fvVar);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
