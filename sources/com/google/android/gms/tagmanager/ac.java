package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class ac extends aj {
    private static final String ID = C0205a.ENCODE.toString();
    private static final String XQ = C0209b.ARG0.toString();
    private static final String XR = C0209b.NO_PADDING.toString();
    private static final String XS = C0209b.INPUT_FORMAT.toString();
    private static final String XT = C0209b.OUTPUT_FORMAT.toString();

    public ac() {
        super(ID, XQ);
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(XQ);
        if (c0969a == null || c0969a == dh.lT()) {
            return dh.lT();
        }
        String j = dh.m1461j(c0969a);
        c0969a = (C0969a) map.get(XS);
        String j2 = c0969a == null ? "text" : dh.m1461j(c0969a);
        c0969a = (C0969a) map.get(XT);
        String j3 = c0969a == null ? "base16" : dh.m1461j(c0969a);
        c0969a = (C0969a) map.get(XR);
        int i = (c0969a == null || !dh.m1467n(c0969a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C0406j.bm(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m1385w("Encode: unknown input format: " + j2);
                return dh.lT();
            }
            if ("base16".equals(j3)) {
                d = C0406j.m1480d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m1385w("Encode: unknown output format: " + j3);
                return dh.lT();
            }
            return dh.m1472r(d);
        } catch (IllegalArgumentException e) {
            bh.m1385w("Encode: invalid input:");
            return dh.lT();
        }
    }
}
