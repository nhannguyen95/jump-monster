package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C1021w extends df {
    private static final String ID = C0205a.DATA_LAYER_WRITE.toString();
    private static final String VALUE = C0209b.VALUE.toString();
    private static final String XL = C0209b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer WK;

    public C1021w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.WK = dataLayer;
    }

    /* renamed from: a */
    private void m3229a(C0969a c0969a) {
        if (c0969a != null && c0969a != dh.lN()) {
            String j = dh.m1461j(c0969a);
            if (j != dh.lS()) {
                this.WK.bv(j);
            }
        }
    }

    /* renamed from: b */
    private void m3230b(C0969a c0969a) {
        if (c0969a != null && c0969a != dh.lN()) {
            Object o = dh.m1469o(c0969a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.WK.push((Map) o2);
                    }
                }
            }
        }
    }

    /* renamed from: z */
    public void mo3175z(Map<String, C0969a> map) {
        m3230b((C0969a) map.get(VALUE));
        m3229a((C0969a) map.get(XL));
    }
}
