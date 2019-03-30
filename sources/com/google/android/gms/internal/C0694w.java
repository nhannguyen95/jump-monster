package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.w */
class C0694w implements C0310y {
    private dz kU;

    public C0694w(dz dzVar) {
        this.kU = dzVar;
    }

    /* renamed from: a */
    public void mo1877a(ab abVar, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        this.kU.m833a("onAdVisibilityChanged", hashMap);
    }
}
