package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.location.c */
public class C0313c implements Creator<C0697b> {
    /* renamed from: a */
    static void m1222a(C0697b c0697b, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, c0697b.Oh);
        C0146b.m235c(parcel, 1000, c0697b.getVersionCode());
        C0146b.m235c(parcel, 2, c0697b.Oi);
        C0146b.m216a(parcel, 3, c0697b.Oj);
        C0146b.m212F(parcel, p);
    }

    public C0697b aB(Parcel parcel) {
        int i = 1;
        int o = C0145a.m197o(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
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
            return new C0697b(i2, i3, i, j);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0697b[] bA(int i) {
        return new C0697b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bA(x0);
    }
}
