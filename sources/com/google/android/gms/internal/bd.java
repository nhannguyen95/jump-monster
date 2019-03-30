package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bd implements bb {
    private final bc mP;

    public bd(bc bcVar) {
        this.mP = bcVar;
    }

    /* renamed from: a */
    private static boolean m2029a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: b */
    private static int m2030b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return dq.bA();
            }
            if ("l".equalsIgnoreCase(str)) {
                return dq.bz();
            }
        }
        return -1;
    }

    /* renamed from: b */
    public void mo1589b(dz dzVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            dw.m824z("Action missing from an open GMSG.");
            return;
        }
        ea bI = dzVar.bI();
        if ("expand".equalsIgnoreCase(str)) {
            if (dzVar.bL()) {
                dw.m824z("Cannot expand WebView that is already expanded.");
            } else {
                bI.m845a(m2029a(map), m2030b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get("u");
            if (str != null) {
                bI.m846a(m2029a(map), m2030b(map), str);
            } else {
                bI.m847a(m2029a(map), m2030b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("in_app_purchase".equalsIgnoreCase(str)) {
            str = (String) map.get("product_id");
            String str2 = (String) map.get("report_urls");
            if (this.mP == null) {
                return;
            }
            if (str2 == null || str2.isEmpty()) {
                this.mP.mo3162a(str, new ArrayList());
                return;
            }
            this.mP.mo3162a(str, new ArrayList(Arrays.asList(str2.split(" "))));
        } else {
            bI.m840a(new cb((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
