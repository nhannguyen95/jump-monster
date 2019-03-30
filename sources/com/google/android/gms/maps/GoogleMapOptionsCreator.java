package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1225a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, googleMapOptions.getVersionCode());
        C0146b.m213a(parcel, 2, googleMapOptions.ig());
        C0146b.m213a(parcel, 3, googleMapOptions.ih());
        C0146b.m235c(parcel, 4, googleMapOptions.getMapType());
        C0146b.m220a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0146b.m213a(parcel, 6, googleMapOptions.ii());
        C0146b.m213a(parcel, 7, googleMapOptions.ij());
        C0146b.m213a(parcel, 8, googleMapOptions.ik());
        C0146b.m213a(parcel, 9, googleMapOptions.il());
        C0146b.m213a(parcel, 10, googleMapOptions.im());
        C0146b.m213a(parcel, 11, googleMapOptions.in());
        C0146b.m212F(parcel, p);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int o = C0145a.m197o(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    b8 = C0145a.m186e(parcel, n);
                    break;
                case 3:
                    b7 = C0145a.m186e(parcel, n);
                    break;
                case 4:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0145a.m177a(parcel, n, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = C0145a.m186e(parcel, n);
                    break;
                case 7:
                    b5 = C0145a.m186e(parcel, n);
                    break;
                case 8:
                    b4 = C0145a.m186e(parcel, n);
                    break;
                case 9:
                    b3 = C0145a.m186e(parcel, n);
                    break;
                case 10:
                    b2 = C0145a.m186e(parcel, n);
                    break;
                case 11:
                    b = C0145a.m186e(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
