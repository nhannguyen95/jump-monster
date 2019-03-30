package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1259a(LatLng latLng, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, latLng.getVersionCode());
        C0146b.m214a(parcel, 2, latLng.latitude);
        C0146b.m214a(parcel, 3, latLng.longitude);
        C0146b.m212F(parcel, p);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int o = C0145a.m197o(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    d2 = C0145a.m193l(parcel, n);
                    break;
                case 3:
                    d = C0145a.m193l(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LatLng(i, d2, d);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
