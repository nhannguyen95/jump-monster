package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class jr implements Creator<jo> {
    /* renamed from: a */
    static void m1112a(jo joVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, joVar.getVersionCode());
        C0146b.m223a(parcel, 2, joVar.label, false);
        C0146b.m220a(parcel, 3, joVar.adg, i, false);
        C0146b.m223a(parcel, 4, joVar.type, false);
        C0146b.m220a(parcel, 5, joVar.abJ, i, false);
        C0146b.m212F(parcel, p);
    }

    public jo bt(Parcel parcel) {
        ju juVar = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        jp jpVar = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    jpVar = (jp) C0145a.m177a(parcel, n, jp.CREATOR);
                    break;
                case 4:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    juVar = (ju) C0145a.m177a(parcel, n, ju.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jo(i, str2, jpVar, str, juVar);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public jo[] cH(int i) {
        return new jo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cH(x0);
    }
}
