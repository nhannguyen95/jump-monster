package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class er {
    private static boolean zC = false;
    private final String mTag;
    private boolean zD;
    private boolean zE;
    private String zF;

    public er(String str) {
        this(str, dR());
    }

    public er(String str, boolean z) {
        this.mTag = str;
        this.zD = z;
        this.zE = false;
    }

    public static boolean dR() {
        return zC;
    }

    /* renamed from: e */
    private String m896e(String str, Object... objArr) {
        String format = String.format(str, objArr);
        return !TextUtils.isEmpty(this.zF) ? this.zF + format : format;
    }

    /* renamed from: a */
    public void m897a(String str, Object... objArr) {
        if (dQ()) {
            Log.v(this.mTag, m896e(str, objArr));
        }
    }

    /* renamed from: a */
    public void m898a(Throwable th, String str, Object... objArr) {
        if (dP() || zC) {
            Log.d(this.mTag, m896e(str, objArr), th);
        }
    }

    public void ab(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = String.format("[%s] ", new Object[]{str});
        }
        this.zF = str2;
    }

    /* renamed from: b */
    public void m899b(String str, Object... objArr) {
        if (dP() || zC) {
            Log.d(this.mTag, m896e(str, objArr));
        }
    }

    /* renamed from: c */
    public void m900c(String str, Object... objArr) {
        Log.i(this.mTag, m896e(str, objArr));
    }

    /* renamed from: d */
    public void m901d(String str, Object... objArr) {
        Log.w(this.mTag, m896e(str, objArr));
    }

    public boolean dP() {
        return this.zD;
    }

    public boolean dQ() {
        return this.zE;
    }
}
