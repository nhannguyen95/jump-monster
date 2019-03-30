package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class ce extends aj {
    private static final String ID = C0205a.RANDOM.toString();
    private static final String YX = C0209b.MIN.toString();
    private static final String YY = C0209b.MAX.toString();

    public ce() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return false;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        double doubleValue;
        double d;
        C0969a c0969a = (C0969a) map.get(YX);
        C0969a c0969a2 = (C0969a) map.get(YY);
        if (!(c0969a == null || c0969a == dh.lT() || c0969a2 == null || c0969a2 == dh.lT())) {
            dg k = dh.m1462k(c0969a);
            dg k2 = dh.m1462k(c0969a2);
            if (!(k == dh.lR() || k2 == dh.lR())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return dh.m1472r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return dh.m1472r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
