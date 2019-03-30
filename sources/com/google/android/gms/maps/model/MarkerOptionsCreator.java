package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1260a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, markerOptions.getVersionCode());
        C0146b.m220a(parcel, 2, markerOptions.getPosition(), i, false);
        C0146b.m223a(parcel, 3, markerOptions.getTitle(), false);
        C0146b.m223a(parcel, 4, markerOptions.getSnippet(), false);
        C0146b.m218a(parcel, 5, markerOptions.iE(), false);
        C0146b.m215a(parcel, 6, markerOptions.getAnchorU());
        C0146b.m215a(parcel, 7, markerOptions.getAnchorV());
        C0146b.m226a(parcel, 8, markerOptions.isDraggable());
        C0146b.m226a(parcel, 9, markerOptions.isVisible());
        C0146b.m226a(parcel, 10, markerOptions.isFlat());
        C0146b.m215a(parcel, 11, markerOptions.getRotation());
        C0146b.m215a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0146b.m215a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0146b.m215a(parcel, 14, markerOptions.getAlpha());
        C0146b.m212F(parcel, p);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    latLng = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    iBinder = C0145a.m198o(parcel, n);
                    break;
                case 6:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 7:
                    f2 = C0145a.m192k(parcel, n);
                    break;
                case 8:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 9:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 10:
                    z3 = C0145a.m184c(parcel, n);
                    break;
                case 11:
                    f3 = C0145a.m192k(parcel, n);
                    break;
                case 12:
                    f4 = C0145a.m192k(parcel, n);
                    break;
                case 13:
                    f5 = C0145a.m192k(parcel, n);
                    break;
                case 14:
                    f6 = C0145a.m192k(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
