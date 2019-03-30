package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

public final class dw {
    /* renamed from: a */
    public static void m816a(String str, Throwable th) {
        if (m819n(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: b */
    public static void m817b(String str, Throwable th) {
        if (m819n(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: c */
    public static void m818c(String str, Throwable th) {
        if (m819n(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: n */
    public static boolean m819n(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    /* renamed from: v */
    public static void m820v(String str) {
        if (m819n(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: w */
    public static void m821w(String str) {
        if (m819n(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: x */
    public static void m822x(String str) {
        if (m819n(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: y */
    public static void m823y(String str) {
        if (m819n(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: z */
    public static void m824z(String str) {
        if (m819n(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
