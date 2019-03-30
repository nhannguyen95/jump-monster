package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C0317c;
import com.google.android.gms.maps.internal.C0335u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        fq.m986f(context);
        try {
            C0317c A = C0335u.m1248A(context);
            try {
                CameraUpdateFactory.m1223a(A.ix());
                BitmapDescriptorFactory.m1253a(A.iy());
                return 0;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
            return e2.errorCode;
        }
    }
}
