package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0122a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0302t;
import com.google.android.gms.internal.C0302t.C0693a;
import com.google.android.gms.internal.fq;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String kw;
        private final boolean kx;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.kw = advertisingId;
            this.kx = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.kw;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kx;
        }
    }

    /* renamed from: a */
    static Info m9a(Context context, C0122a c0122a) throws IOException {
        try {
            C0302t b = C0693a.m2329b(c0122a.dV());
            Info info = new Info(b.getId(), b.mo1873a(true));
            try {
                context.unbindService(c0122a);
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (Throwable e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(c0122a);
            } catch (Throwable e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
        }
    }

    /* renamed from: g */
    static C0122a m10g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m118s(context);
                Object c0122a = new C0122a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0122a, 1)) {
                    return c0122a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        fq.ak("Calling this from your main thread can lead to deadlock");
        return m9a(context, m10g(context));
    }
}
