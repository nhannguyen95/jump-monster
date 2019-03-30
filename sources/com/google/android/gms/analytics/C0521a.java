package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.analytics.a */
class C0521a implements C0098m {
    private static Object sf = new Object();
    private static C0521a sg;
    private Context mContext;
    private Info sh;
    private long si;

    C0521a(Context context) {
        this.mContext = context;
    }

    private Info bQ() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            aa.m36z("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (GooglePlayServicesRepairableException e2) {
            aa.m36z("GooglePlayServicesRepairableException getting Ad Id Info");
        } catch (IOException e3) {
            aa.m36z("IOException getting Ad Id Info");
        } catch (GooglePlayServicesNotAvailableException e4) {
            aa.m36z("GooglePlayServicesNotAvailableException getting Ad Id Info");
        } catch (Exception e5) {
            aa.m36z("Unknown exception. Could not get the ad Id.");
        }
        return info;
    }

    /* renamed from: m */
    public static C0098m m1543m(Context context) {
        if (sg == null) {
            synchronized (sf) {
                if (sg == null) {
                    sg = new C0521a(context);
                }
            }
        }
        return sg;
    }

    public String getValue(String field) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.si > 1000) {
            this.sh = bQ();
            this.si = currentTimeMillis;
        }
        if (this.sh != null) {
            if ("&adid".equals(field)) {
                return this.sh.getId();
            }
            if ("&ate".equals(field)) {
                return this.sh.isLimitAdTrackingEnabled() ? "0" : "1";
            }
        }
        return null;
    }
}
