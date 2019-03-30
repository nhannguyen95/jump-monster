package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class hp implements Creator<ho> {
    /* renamed from: a */
    static void m1072a(ho hoVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, hoVar.getName(), false);
        C0146b.m235c(parcel, 1000, hoVar.xH);
        C0146b.m220a(parcel, 2, hoVar.ia(), i, false);
        C0146b.m223a(parcel, 3, hoVar.getAddress(), false);
        C0146b.m234b(parcel, 4, hoVar.ib(), false);
        C0146b.m223a(parcel, 5, hoVar.getPhoneNumber(), false);
        C0146b.m223a(parcel, 6, hoVar.ic(), false);
        C0146b.m212F(parcel, p);
    }

    public ho aH(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    latLng = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    list = C0145a.m183c(parcel, n, hm.CREATOR);
                    break;
                case 5:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 6:
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
            return new ho(i, str4, latLng, str3, list, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ho[] bI(int i) {
        return new ho[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bI(x0);
    }
}
