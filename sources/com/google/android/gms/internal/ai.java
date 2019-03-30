package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

public class ai implements Creator<ah> {
    /* renamed from: a */
    static void m611a(ah ahVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, ahVar.versionCode);
        C0146b.m216a(parcel, 2, ahVar.lH);
        C0146b.m217a(parcel, 3, ahVar.extras, false);
        C0146b.m235c(parcel, 4, ahVar.lI);
        C0146b.m224a(parcel, 5, ahVar.lJ, false);
        C0146b.m226a(parcel, 6, ahVar.lK);
        C0146b.m235c(parcel, 7, ahVar.lL);
        C0146b.m226a(parcel, 8, ahVar.lM);
        C0146b.m223a(parcel, 9, ahVar.lN, false);
        C0146b.m220a(parcel, 10, ahVar.lO, i, false);
        C0146b.m220a(parcel, 11, ahVar.lP, i, false);
        C0146b.m223a(parcel, 12, ahVar.lQ, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: a */
    public ah m612a(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        av avVar = null;
        Location location = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 4:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    list = C0145a.m172A(parcel, n);
                    break;
                case 6:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 7:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 8:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 9:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 10:
                    avVar = (av) C0145a.m177a(parcel, n, av.CREATOR);
                    break;
                case 11:
                    location = (Location) C0145a.m177a(parcel, n, Location.CREATOR);
                    break;
                case 12:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ah(i, j, bundle, i2, list, z, i3, z2, str, avVar, location, str2);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: b */
    public ah[] m613b(int i) {
        return new ah[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m612a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m613b(x0);
    }
}
