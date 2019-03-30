package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0239d.C0969a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dk {
    /* renamed from: a */
    private static by<C0969a> m1476a(by<C0969a> byVar) {
        try {
            return new by(dh.m1472r(cd(dh.m1461j((C0969a) byVar.getObject()))), byVar.kQ());
        } catch (Throwable e) {
            bh.m1382b("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    /* renamed from: a */
    private static by<C0969a> m1477a(by<C0969a> byVar, int i) {
        if (m1479q((C0969a) byVar.getObject())) {
            switch (i) {
                case 12:
                    return m1476a(byVar);
                default:
                    bh.m1385w("Unsupported Value Escaping: " + i);
                    return byVar;
            }
        }
        bh.m1385w("Escaping can only be applied to strings.");
        return byVar;
    }

    /* renamed from: a */
    static by<C0969a> m1478a(by<C0969a> byVar, int... iArr) {
        by a;
        for (int a2 : iArr) {
            a = m1477a(a, a2);
        }
        return a;
    }

    static String cd(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    /* renamed from: q */
    private static boolean m1479q(C0969a c0969a) {
        return dh.m1469o(c0969a) instanceof String;
    }
}
