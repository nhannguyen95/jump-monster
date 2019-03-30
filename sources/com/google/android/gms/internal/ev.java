package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class ev {
    public static final Object Ab = new Object();
    private static final er zb = new er("RequestTracker");
    private eu Aa;
    private long zX;
    private long zY = -1;
    private long zZ = 0;

    public ev(long j) {
        this.zX = j;
    }

    private void dT() {
        this.zY = -1;
        this.Aa = null;
        this.zZ = 0;
    }

    /* renamed from: a */
    public void m905a(long j, eu euVar) {
        synchronized (Ab) {
            eu euVar2 = this.Aa;
            long j2 = this.zY;
            this.zY = j;
            this.Aa = euVar;
            this.zZ = SystemClock.elapsedRealtime();
        }
        if (euVar2 != null) {
            euVar2.mo1066l(j2);
        }
    }

    /* renamed from: b */
    public boolean m906b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        eu euVar = null;
        synchronized (Ab) {
            if (this.zY == -1 || this.zY != j) {
                z = false;
            } else {
                zb.m899b("request %d completed", Long.valueOf(this.zY));
                euVar = this.Aa;
                dT();
            }
        }
        if (euVar != null) {
            euVar.mo1065a(j, i, jSONObject);
        }
        return z;
    }

    /* renamed from: c */
    public boolean m907c(long j, int i) {
        return m906b(j, i, null);
    }

    public void clear() {
        synchronized (Ab) {
            if (this.zY != -1) {
                dT();
            }
        }
    }

    /* renamed from: d */
    public boolean m908d(long j, int i) {
        eu euVar;
        boolean z = true;
        long j2 = 0;
        synchronized (Ab) {
            if (this.zY == -1 || j - this.zZ < this.zX) {
                z = false;
                euVar = null;
            } else {
                zb.m899b("request %d timed out", Long.valueOf(this.zY));
                j2 = this.zY;
                euVar = this.Aa;
                dT();
            }
        }
        if (euVar != null) {
            euVar.mo1065a(j2, i, null);
        }
        return z;
    }

    public boolean dU() {
        boolean z;
        synchronized (Ab) {
            z = this.zY != -1;
        }
        return z;
    }

    /* renamed from: n */
    public boolean m909n(long j) {
        boolean z;
        synchronized (Ab) {
            z = this.zY != -1 && this.zY == j;
        }
        return z;
    }
}
