package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay {
    private static String Yk;
    static Map<String, String> Yl = new HashMap();

    ay() {
    }

    static void bF(String str) {
        synchronized (ay.class) {
            Yk = str;
        }
    }

    /* renamed from: c */
    static void m1373c(Context context, String str) {
        cy.m1453a(context, "gtm_install_referrer", "referrer", str);
        m1376e(context, str);
    }

    /* renamed from: d */
    static String m1374d(Context context, String str) {
        if (Yk == null) {
            synchronized (ay.class) {
                if (Yk == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        Yk = sharedPreferences.getString("referrer", "");
                    } else {
                        Yk = "";
                    }
                }
            }
        }
        return m1377m(Yk, str);
    }

    /* renamed from: e */
    static String m1375e(Context context, String str, String str2) {
        String str3 = (String) Yl.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            Yl.put(str, str3);
        }
        return m1377m(str3, str2);
    }

    /* renamed from: e */
    static void m1376e(Context context, String str) {
        String m = m1377m(str, "conv");
        if (m != null && m.length() > 0) {
            Yl.put(m, str);
            cy.m1453a(context, "gtm_click_referrers", m, str);
        }
    }

    /* renamed from: m */
    static String m1377m(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }
}
