package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class StreetViewPanoramaLocationCreator implements Creator<StreetViewPanoramaLocation> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1265a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C0146b.m229a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C0146b.m220a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C0146b.m223a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C0146b.m212F(parcel, p);
    }

    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < o) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int g;
            String str2;
            int n = C0145a.m195n(parcel);
            String str3;
            switch (C0145a.m175R(n)) {
                case 1:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = C0145a.m188g(parcel, n);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C0145a.m182b(parcel, n, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    str3 = str;
                    latLng2 = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C0145a.m196n(parcel, n);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
            }
            i = g;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == o) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaLocation[] newArray(int size) {
        return new StreetViewPanoramaLocation[size];
    }
}
