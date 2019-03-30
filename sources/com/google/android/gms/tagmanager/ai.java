package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0223c.C0959c;
import com.google.android.gms.internal.C0223c.C0960d;
import com.google.android.gms.internal.C0223c.C0965i;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class ai {
    /* renamed from: a */
    private static void m1361a(DataLayer dataLayer, C0960d c0960d) {
        for (C0969a j : c0960d.eS) {
            dataLayer.bv(dh.m1461j(j));
        }
    }

    /* renamed from: a */
    public static void m1362a(DataLayer dataLayer, C0965i c0965i) {
        if (c0965i.fI == null) {
            bh.m1388z("supplemental missing experimentSupplemental");
            return;
        }
        m1361a(dataLayer, c0965i.fI);
        m1363b(dataLayer, c0965i.fI);
        m1365c(dataLayer, c0965i.fI);
    }

    /* renamed from: b */
    private static void m1363b(DataLayer dataLayer, C0960d c0960d) {
        for (C0969a c : c0960d.eR) {
            Map c2 = m1364c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    /* renamed from: c */
    private static Map<String, Object> m1364c(C0969a c0969a) {
        Object o = dh.m1469o(c0969a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m1388z("value: " + o + " is not a map value, ignored.");
        return null;
    }

    /* renamed from: c */
    private static void m1365c(DataLayer dataLayer, C0960d c0960d) {
        for (C0959c c0959c : c0960d.eT) {
            if (c0959c.eM == null) {
                bh.m1388z("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c0959c.eM);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c0959c.eN;
                long j2 = c0959c.eO;
                if (!c0959c.eP || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m1388z("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bv(c0959c.eM);
                Map c = dataLayer.m1349c(c0959c.eM, obj);
                if (c0959c.eQ > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c0959c.eQ));
                        } else {
                            bh.m1388z("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c0959c.eQ)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
