package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0193g;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.ap.C0586a;
import com.google.android.gms.internal.aq.C0588a;

public final class ag extends C0193g<aq> {
    private static final ag lG = new ag();

    private ag() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* renamed from: a */
    public static ap m2001a(Context context, ak akVar, String str, bp bpVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ap b = lG.m2002b(context, akVar, str, bpVar);
            if (b != null) {
                return b;
            }
        }
        dw.m820v("Using AdManager from the client jar.");
        return new C0998v(context, akVar, str, bpVar, new dx(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    /* renamed from: b */
    private ap m2002b(Context context, ak akVar, String str, bp bpVar) {
        try {
            return C0586a.m2016f(((aq) m360z(context)).mo1616a(C0926e.m2696h(context), akVar, str, bpVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            dw.m818c("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            dw.m818c("Could not create remote AdManager.", e2);
            return null;
        }
    }

    /* renamed from: c */
    protected aq m2003c(IBinder iBinder) {
        return C0588a.m2018g(iBinder);
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1596d(IBinder iBinder) {
        return m2003c(iBinder);
    }
}
