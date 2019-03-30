package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

abstract class dc extends cc {
    public dc(String str) {
        super(str);
    }

    /* renamed from: a */
    protected boolean mo3167a(C0969a c0969a, C0969a c0969a2, Map<String, C0969a> map) {
        String j = dh.m1461j(c0969a);
        String j2 = dh.m1461j(c0969a2);
        return (j == dh.lS() || j2 == dh.lS()) ? false : mo3246a(j, j2, (Map) map);
    }

    /* renamed from: a */
    protected abstract boolean mo3246a(String str, String str2, Map<String, C0969a> map);
}
