package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1256a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0146b.m218a(parcel, 2, groundOverlayOptions.iD(), false);
        C0146b.m220a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0146b.m215a(parcel, 4, groundOverlayOptions.getWidth());
        C0146b.m215a(parcel, 5, groundOverlayOptions.getHeight());
        C0146b.m220a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0146b.m215a(parcel, 7, groundOverlayOptions.getBearing());
        C0146b.m215a(parcel, 8, groundOverlayOptions.getZIndex());
        C0146b.m226a(parcel, 9, groundOverlayOptions.isVisible());
        C0146b.m215a(parcel, 10, groundOverlayOptions.getTransparency());
        C0146b.m215a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0146b.m215a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0146b.m212F(parcel, p);
    }

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    iBinder = C0145a.m198o(parcel, n);
                    break;
                case 3:
                    latLng = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 5:
                    f2 = C0145a.m192k(parcel, n);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0145a.m177a(parcel, n, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0145a.m192k(parcel, n);
                    break;
                case 8:
                    f4 = C0145a.m192k(parcel, n);
                    break;
                case 9:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 10:
                    f5 = C0145a.m192k(parcel, n);
                    break;
                case 11:
                    f6 = C0145a.m192k(parcel, n);
                    break;
                case 12:
                    f7 = C0145a.m192k(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
