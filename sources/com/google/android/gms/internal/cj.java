package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0193g;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.ck.C0607a;
import com.google.android.gms.internal.cl.C0609a;

public final class cj extends C0193g<cl> {
    private static final cj oC = new cj();

    /* renamed from: com.google.android.gms.internal.cj$a */
    private static final class C0229a extends Exception {
        public C0229a(String str) {
            super(str);
        }
    }

    private cj() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: a */
    public static ck m2059a(Activity activity) {
        try {
            if (!m2060b(activity)) {
                return oC.m2061c(activity);
            }
            dw.m820v("Using AdOverlay from the client jar.");
            return new cc(activity);
        } catch (C0229a e) {
            dw.m824z(e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m2060b(Activity activity) throws C0229a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0229a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    /* renamed from: c */
    private ck m2061c(Activity activity) {
        try {
            return C0607a.m2065m(((cl) m360z(activity)).mo1673a(C0926e.m2696h(activity)));
        } catch (Throwable e) {
            dw.m818c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            dw.m818c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1596d(IBinder iBinder) {
        return m2063l(iBinder);
    }

    /* renamed from: l */
    protected cl m2063l(IBinder iBinder) {
        return C0609a.m2067n(iBinder);
    }
}
