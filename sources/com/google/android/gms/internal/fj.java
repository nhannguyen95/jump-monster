package com.google.android.gms.internal;

import android.util.Log;

public final class fj {
    private final String DH;

    public fj(String str) {
        this.DH = (String) fq.m986f(str);
    }

    /* renamed from: P */
    public boolean m941P(int i) {
        return Log.isLoggable(this.DH, i);
    }

    /* renamed from: a */
    public void m942a(String str, String str2, Throwable th) {
        if (m941P(6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: f */
    public void m943f(String str, String str2) {
        if (m941P(2)) {
            Log.v(str, str2);
        }
    }

    /* renamed from: g */
    public void m944g(String str, String str2) {
        if (m941P(5)) {
            Log.w(str, str2);
        }
    }

    /* renamed from: h */
    public void m945h(String str, String str2) {
        if (m941P(6)) {
            Log.e(str, str2);
        }
    }
}
