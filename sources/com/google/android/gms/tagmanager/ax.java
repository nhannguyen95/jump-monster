package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class ax extends aj {
    private static final String ID = C0205a.INSTALL_REFERRER.toString();
    private static final String WA = C0209b.COMPONENT.toString();
    private final Context kI;

    public ax(Context context) {
        super(ID, new String[0]);
        this.kI = context;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        String d = ay.m1374d(this.kI, ((C0969a) map.get(WA)) != null ? dh.m1461j((C0969a) map.get(WA)) : null);
        return d != null ? dh.m1472r(d) : dh.lT();
    }
}
