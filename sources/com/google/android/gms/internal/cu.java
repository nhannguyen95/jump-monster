package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.cv.C0967a;
import com.google.android.gms.internal.cv.C0968b;

public final class cu {

    /* renamed from: com.google.android.gms.internal.cu$a */
    public interface C0237a {
        /* renamed from: a */
        void mo1681a(cz czVar);
    }

    /* renamed from: a */
    public static C0243do m715a(Context context, cx cxVar, C0237a c0237a) {
        return cxVar.kK.rt ? m716b(context, cxVar, c0237a) : m717c(context, cxVar, c0237a);
    }

    /* renamed from: b */
    private static C0243do m716b(Context context, cx cxVar, C0237a c0237a) {
        dw.m820v("Fetching ad response from local ad request service.");
        C0243do c0967a = new C0967a(context, cxVar, c0237a);
        c0967a.start();
        return c0967a;
    }

    /* renamed from: c */
    private static C0243do m717c(Context context, cx cxVar, C0237a c0237a) {
        dw.m820v("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0968b(context, cxVar, c0237a);
        }
        dw.m824z("Failed to connect to remote ad request service.");
        return null;
    }
}
