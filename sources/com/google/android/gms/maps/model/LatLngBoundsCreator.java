package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1258a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, latLngBounds.getVersionCode());
        C0146b.m220a(parcel, 2, latLngBounds.southwest, i, false);
        C0146b.m220a(parcel, 3, latLngBounds.northeast, i, false);
        C0146b.m212F(parcel, p);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < o) {
            int g;
            LatLng latLng3;
            int n = C0145a.m195n(parcel);
            LatLng latLng4;
            switch (C0145a.m175R(n)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C0145a.m188g(parcel, n);
                    latLng3 = latLng4;
                    break;
                case 2:
                    g = i;
                    latLng4 = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == o) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
