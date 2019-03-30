package com.google.android.gms.internal;

import android.text.TextUtils;

public final class eo {
    /* renamed from: W */
    public static void m873W(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    /* renamed from: X */
    public static String m874X(String str) {
        return "urn:x-cast:" + str;
    }

    /* renamed from: a */
    public static <T> boolean m875a(T t, T t2) {
        return (t == null && t2 == null) || !(t == null || t2 == null || !t.equals(t2));
    }

    /* renamed from: b */
    public static long m876b(double d) {
        return (long) (1000.0d * d);
    }

    /* renamed from: m */
    public static double m877m(long j) {
        return ((double) j) / 1000.0d;
    }
}
