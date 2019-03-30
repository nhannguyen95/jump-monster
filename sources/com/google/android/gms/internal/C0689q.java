package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.q */
class C0689q implements C0297o {
    private ko kk;
    private byte[] kl;
    private final int km;

    public C0689q(int i) {
        this.km = i;
        reset();
    }

    /* renamed from: b */
    public void mo1867b(int i, long j) throws IOException {
        this.kk.m1152b(i, j);
    }

    /* renamed from: b */
    public void mo1868b(int i, String str) throws IOException {
        this.kk.m1153b(i, str);
    }

    public void reset() {
        this.kl = new byte[this.km];
        this.kk = ko.m1145o(this.kl);
    }

    /* renamed from: z */
    public byte[] mo1870z() throws IOException {
        int mv = this.kk.mv();
        if (mv < 0) {
            throw new IOException();
        } else if (mv == 0) {
            return this.kl;
        } else {
            Object obj = new byte[(this.kl.length - mv)];
            System.arraycopy(this.kl, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
