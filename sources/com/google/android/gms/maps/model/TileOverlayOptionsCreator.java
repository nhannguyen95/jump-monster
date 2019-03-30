package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1268a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0146b.m218a(parcel, 2, tileOverlayOptions.iG(), false);
        C0146b.m226a(parcel, 3, tileOverlayOptions.isVisible());
        C0146b.m215a(parcel, 4, tileOverlayOptions.getZIndex());
        C0146b.m226a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0146b.m212F(parcel, p);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
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
                    z = C0145a.m184c(parcel, n);
                    break;
                case 4:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 5:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
