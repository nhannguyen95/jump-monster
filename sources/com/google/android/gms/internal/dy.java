package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class dy implements Creator<dx> {
    /* renamed from: a */
    static void m825a(dx dxVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, dxVar.versionCode);
        C0146b.m223a(parcel, 2, dxVar.rq, false);
        C0146b.m235c(parcel, 3, dxVar.rr);
        C0146b.m235c(parcel, 4, dxVar.rs);
        C0146b.m226a(parcel, 5, dxVar.rt);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m826h(x0);
    }

    /* renamed from: h */
    public dx m826h(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    z = C0145a.m184c(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new dx(i3, str, i2, i, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m827o(x0);
    }

    /* renamed from: o */
    public dx[] m827o(int i) {
        return new dx[i];
    }
}
