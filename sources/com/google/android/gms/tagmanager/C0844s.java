package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C0844s extends aj {
    private static final String ID = C0205a.FUNCTION_CALL.toString();
    private static final String WC = C0209b.ADDITIONAL_PARAMS.toString();
    private static final String Xn = C0209b.FUNCTION_CALL_NAME.toString();
    private final C0414a Xo;

    /* renamed from: com.google.android.gms.tagmanager.s$a */
    public interface C0414a {
        /* renamed from: b */
        Object mo2231b(String str, Map<String, Object> map);
    }

    public C0844s(C0414a c0414a) {
        super(ID, Xn);
        this.Xo = c0414a;
    }

    public boolean jX() {
        return false;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        String j = dh.m1461j((C0969a) map.get(Xn));
        Map hashMap = new HashMap();
        C0969a c0969a = (C0969a) map.get(WC);
        if (c0969a != null) {
            Object o = dh.m1469o(c0969a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m1388z("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return dh.lT();
            }
        }
        try {
            return dh.m1472r(this.Xo.mo2231b(j, hashMap));
        } catch (Exception e) {
            bh.m1388z("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return dh.lT();
        }
    }
}
