package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C0818c extends aj {
    private static final String ID = C0205a.ADVERTISING_TRACKING_ENABLED.toString();
    private final C0378a Wz;

    public C0818c(Context context) {
        this(C0378a.m1357E(context));
    }

    C0818c(C0378a c0378a) {
        super(ID, new String[0]);
        this.Wz = c0378a;
    }

    public boolean jX() {
        return false;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        return dh.m1472r(Boolean.valueOf(!this.Wz.isLimitAdTrackingEnabled()));
    }
}
