package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C0829e extends aj {
    private static final String ID = C0205a.ADWORDS_CLICK_REFERRER.toString();
    private static final String WA = C0209b.COMPONENT.toString();
    private static final String WB = C0209b.CONVERSION_ID.toString();
    private final Context kI;

    public C0829e(Context context) {
        super(ID, WB);
        this.kI = context;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(WB);
        if (c0969a == null) {
            return dh.lT();
        }
        String j = dh.m1461j(c0969a);
        c0969a = (C0969a) map.get(WA);
        String e = ay.m1375e(this.kI, j, c0969a != null ? dh.m1461j(c0969a) : null);
        return e != null ? dh.m1472r(e) : dh.lT();
    }
}
