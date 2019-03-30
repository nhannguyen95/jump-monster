package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.o */
public final class C0100o {
    /* renamed from: b */
    private static String m63b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        aa.m33w("index out of range for " + str + " (" + i + ")");
        return "";
    }

    /* renamed from: q */
    static String m64q(int i) {
        return C0100o.m63b("&cd", i);
    }

    /* renamed from: r */
    static String m65r(int i) {
        return C0100o.m63b("&cm", i);
    }
}
