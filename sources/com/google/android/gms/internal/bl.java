package com.google.android.gms.internal;

import com.google.android.gms.internal.bn.C0212a;
import com.google.android.gms.internal.bs.C0604a;

public final class bl extends C0604a {
    private final Object li = new Object();
    private C0212a nl;
    private bk nm;

    /* renamed from: P */
    public void mo1631P() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.mo3158X();
            }
        }
    }

    /* renamed from: a */
    public void m2894a(bk bkVar) {
        synchronized (this.li) {
            this.nm = bkVar;
        }
    }

    /* renamed from: a */
    public void m2895a(C0212a c0212a) {
        synchronized (this.li) {
            this.nl = c0212a;
        }
    }

    public void onAdClosed() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.mo3159Y();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.li) {
            if (this.nl != null) {
                this.nl.mo1620f(error == 3 ? 1 : 2);
                this.nl = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.mo3160Z();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.li;
        monitor-enter(r1);
        r0 = r3.nl;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.nl;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo1620f(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.nl = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.nm;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.nm;	 Catch:{ all -> 0x001d }
        r0.ab();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bl.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.aa();
            }
        }
    }
}
