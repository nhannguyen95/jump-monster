package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class ah extends aj {
    private static final String ID = C0205a.EVENT.toString();
    private final cs WL;

    public ah(cs csVar) {
        super(ID, new String[0]);
        this.WL = csVar;
    }

    public boolean jX() {
        return false;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        String lx = this.WL.lx();
        return lx == null ? dh.lT() : dh.m1472r(lx);
    }
}
