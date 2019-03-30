package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class he implements Creator<hd> {
    /* renamed from: a */
    static void m1067a(hd hdVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, hdVar.getRequestId(), false);
        C0146b.m235c(parcel, 1000, hdVar.getVersionCode());
        C0146b.m216a(parcel, 2, hdVar.getExpirationTime());
        C0146b.m225a(parcel, 3, hdVar.hS());
        C0146b.m214a(parcel, 4, hdVar.getLatitude());
        C0146b.m214a(parcel, 5, hdVar.getLongitude());
        C0146b.m215a(parcel, 6, hdVar.hT());
        C0146b.m235c(parcel, 7, hdVar.hU());
        C0146b.m235c(parcel, 8, hdVar.getNotificationResponsiveness());
        C0146b.m235c(parcel, 9, hdVar.hV());
        C0146b.m212F(parcel, p);
    }

    public hd aC(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    s = C0145a.m187f(parcel, n);
                    break;
                case 4:
                    d = C0145a.m193l(parcel, n);
                    break;
                case 5:
                    d2 = C0145a.m193l(parcel, n);
                    break;
                case 6:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 7:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 8:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 9:
                    i4 = C0145a.m188g(parcel, n);
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
            return new hd(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public hd[] bD(int i) {
        return new hd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bD(x0);
    }
}
