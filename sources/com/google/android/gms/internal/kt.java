package com.google.android.gms.internal;

import java.io.IOException;

public abstract class kt {
    protected volatile int adY = -1;

    /* renamed from: a */
    public static final <T extends kt> T m1167a(T t, byte[] bArr) throws ks {
        return m1169b(t, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static final void m1168a(kt ktVar, byte[] bArr, int i, int i2) {
        try {
            ko b = ko.m1137b(bArr, i, i2);
            ktVar.mo1865a(b);
            b.mw();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: b */
    public static final <T extends kt> T m1169b(T t, byte[] bArr, int i, int i2) throws ks {
        try {
            kn a = kn.m1124a(bArr, i, i2);
            t.mo2699b(a);
            a.cP(0);
            return t;
        } catch (ks e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: d */
    public static final byte[] m1170d(kt ktVar) {
        byte[] bArr = new byte[ktVar.mo2700c()];
        m1168a(ktVar, bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: a */
    public void mo1865a(ko koVar) throws IOException {
    }

    /* renamed from: b */
    public abstract kt mo2699b(kn knVar) throws IOException;

    /* renamed from: c */
    public int mo2700c() {
        int mx = mx();
        this.adY = mx;
        return mx;
    }

    public int mF() {
        if (this.adY < 0) {
            mo2700c();
        }
        return this.adY;
    }

    protected int mx() {
        return 0;
    }

    public String toString() {
        return ku.m1176e(this);
    }
}
