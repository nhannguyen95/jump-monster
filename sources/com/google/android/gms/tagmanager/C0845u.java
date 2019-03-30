package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C0845u extends aj {
    private static final String ID = C0205a.CUSTOM_VAR.toString();
    private static final String NAME = C0209b.NAME.toString();
    private static final String XA = C0209b.DEFAULT_VALUE.toString();
    private final DataLayer WK;

    public C0845u(DataLayer dataLayer) {
        super(ID, NAME);
        this.WK = dataLayer;
    }

    public boolean jX() {
        return false;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        Object obj = this.WK.get(dh.m1461j((C0969a) map.get(NAME)));
        if (obj != null) {
            return dh.m1472r(obj);
        }
        C0969a c0969a = (C0969a) map.get(XA);
        return c0969a != null ? c0969a : dh.lT();
    }
}
