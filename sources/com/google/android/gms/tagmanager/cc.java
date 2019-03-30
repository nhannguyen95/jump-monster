package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

abstract class cc extends aj {
    private static final String XQ = C0209b.ARG0.toString();
    private static final String YN = C0209b.ARG1.toString();

    public cc(String str) {
        super(str, XQ, YN);
    }

    /* renamed from: a */
    protected abstract boolean mo3167a(C0969a c0969a, C0969a c0969a2, Map<String, C0969a> map);

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        for (C0969a c0969a : map.values()) {
            if (c0969a == dh.lT()) {
                return dh.m1472r(Boolean.valueOf(false));
            }
        }
        C0969a c0969a2 = (C0969a) map.get(XQ);
        C0969a c0969a3 = (C0969a) map.get(YN);
        boolean a = (c0969a2 == null || c0969a3 == null) ? false : mo3167a(c0969a2, c0969a3, map);
        return dh.m1472r(Boolean.valueOf(a));
    }
}
