package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C0847x implements bi {
    private int sz = 5;

    C0847x() {
    }

    /* renamed from: b */
    public void mo2298b(String str, Throwable th) {
        if (this.sz <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    /* renamed from: c */
    public void mo2299c(String str, Throwable th) {
        if (this.sz <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.sz = logLevel;
    }

    /* renamed from: v */
    public void mo2301v(String str) {
        if (this.sz <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    /* renamed from: w */
    public void mo2302w(String str) {
        if (this.sz <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    /* renamed from: x */
    public void mo2303x(String str) {
        if (this.sz <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: y */
    public void mo2304y(String str) {
        if (this.sz <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    /* renamed from: z */
    public void mo2305z(String str) {
        if (this.sz <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }
}
