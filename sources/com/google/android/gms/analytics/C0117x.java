package com.google.android.gms.analytics;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.x */
class C0117x {
    private String vh;
    private final long vi;
    private final long vj;
    private String vk = "https:";

    C0117x(String str, long j, long j2) {
        this.vh = str;
        this.vi = j;
        this.vj = j2;
    }

    /* renamed from: J */
    void m71J(String str) {
        this.vh = str;
    }

    /* renamed from: K */
    void m72K(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.vk = "http:";
        }
    }

    String cO() {
        return this.vh;
    }

    long cP() {
        return this.vi;
    }

    long cQ() {
        return this.vj;
    }

    String cR() {
        return this.vk;
    }
}
