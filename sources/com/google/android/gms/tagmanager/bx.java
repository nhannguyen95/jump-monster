package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

abstract class bx extends cc {
    public bx(String str) {
        super(str);
    }

    /* renamed from: a */
    protected boolean mo3167a(C0969a c0969a, C0969a c0969a2, Map<String, C0969a> map) {
        dg k = dh.m1462k(c0969a);
        dg k2 = dh.m1462k(c0969a2);
        return (k == dh.lR() || k2 == dh.lR()) ? false : mo3247a(k, k2, (Map) map);
    }

    /* renamed from: a */
    protected abstract boolean mo3247a(dg dgVar, dg dgVar2, Map<String, C0969a> map);
}
