package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class jt implements Creator<js> {
    /* renamed from: a */
    static void m1113a(js jsVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, jsVar.getVersionCode());
        C0146b.m223a(parcel, 2, jsVar.adn, false);
        C0146b.m223a(parcel, 3, jsVar.pm, false);
        C0146b.m212F(parcel, p);
    }

    public js bu(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
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
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new js(i, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public js[] cI(int i) {
        return new js[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cI(x0);
    }
}
