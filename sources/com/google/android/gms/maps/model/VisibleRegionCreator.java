package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1269a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, visibleRegion.getVersionCode());
        C0146b.m220a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0146b.m220a(parcel, 3, visibleRegion.nearRight, i, false);
        C0146b.m220a(parcel, 4, visibleRegion.farLeft, i, false);
        C0146b.m220a(parcel, 5, visibleRegion.farRight, i, false);
        C0146b.m220a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0146b.m212F(parcel, p);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    latLng4 = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0145a.m177a(parcel, n, LatLngBounds.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
