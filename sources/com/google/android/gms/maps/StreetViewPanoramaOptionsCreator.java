package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewPanoramaOptionsCreator implements Creator<StreetViewPanoramaOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1226a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C0146b.m220a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C0146b.m223a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C0146b.m220a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C0146b.m222a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C0146b.m213a(parcel, 6, streetViewPanoramaOptions.it());
        C0146b.m213a(parcel, 7, streetViewPanoramaOptions.il());
        C0146b.m213a(parcel, 8, streetViewPanoramaOptions.iu());
        C0146b.m213a(parcel, 9, streetViewPanoramaOptions.iv());
        C0146b.m213a(parcel, 10, streetViewPanoramaOptions.ih());
        C0146b.m212F(parcel, p);
    }

    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int o = C0145a.m197o(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0145a.m177a(parcel, n, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    latLng = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 5:
                    num = C0145a.m189h(parcel, n);
                    break;
                case 6:
                    b5 = C0145a.m186e(parcel, n);
                    break;
                case 7:
                    b4 = C0145a.m186e(parcel, n);
                    break;
                case 8:
                    b3 = C0145a.m186e(parcel, n);
                    break;
                case 9:
                    b2 = C0145a.m186e(parcel, n);
                    break;
                case 10:
                    b = C0145a.m186e(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaOptions[] newArray(int size) {
        return new StreetViewPanoramaOptions[size];
    }
}
