package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C0843p extends aj {
    private static final String ID = C0205a.CONTAINER_VERSION.toString();
    private final String Xl;

    public C0843p(String str) {
        super(ID, new String[0]);
        this.Xl = str;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        return this.Xl == null ? dh.lT() : dh.m1472r(this.Xl);
    }
}
