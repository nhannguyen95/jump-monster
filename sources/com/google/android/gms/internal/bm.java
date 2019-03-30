package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.bn.C0212a;

public final class bm implements C0212a {
    private final ah kX;
    private final bq ky;
    private final Object li = new Object();
    private final Context mContext;
    private final String nn;
    private final long no;
    private final bi np;
    private final ak nq;
    private final dx nr;
    private br ns;
    private int nt = -2;

    public bm(Context context, String str, bq bqVar, bj bjVar, bi biVar, ah ahVar, ak akVar, dx dxVar) {
        this.mContext = context;
        this.nn = str;
        this.ky = bqVar;
        this.no = bjVar.nd != -1 ? bjVar.nd : 10000;
        this.np = biVar;
        this.kX = ahVar;
        this.nq = akVar;
        this.nr = dxVar;
    }

    /* renamed from: a */
    private void m2037a(long j, long j2, long j3, long j4) {
        while (this.nt == -2) {
            m2041b(j, j2, j3, j4);
        }
    }

    /* renamed from: a */
    private void m2038a(bl blVar) {
        try {
            if (this.nr.rs < 4100000) {
                if (this.nq.lT) {
                    this.ns.mo1622a(C0926e.m2696h(this.mContext), this.kX, this.np.nb, blVar);
                } else {
                    this.ns.mo1624a(C0926e.m2696h(this.mContext), this.nq, this.kX, this.np.nb, (bs) blVar);
                }
            } else if (this.nq.lT) {
                this.ns.mo1623a(C0926e.m2696h(this.mContext), this.kX, this.np.nb, this.np.mW, (bs) blVar);
            } else {
                this.ns.mo1625a(C0926e.m2696h(this.mContext), this.nq, this.kX, this.np.nb, this.np.mW, blVar);
            }
        } catch (Throwable e) {
            dw.m818c("Could not request ad from mediation adapter.", e);
            mo1620f(5);
        }
    }

    private br aJ() {
        dw.m822x("Instantiating mediation adapter: " + this.nn);
        try {
            return this.ky.mo1621m(this.nn);
        } catch (Throwable e) {
            dw.m816a("Could not instantiate mediation adapter: " + this.nn, e);
            return null;
        }
    }

    /* renamed from: b */
    private void m2041b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            dw.m822x("Timed out waiting for adapter.");
            this.nt = 3;
            return;
        }
        try {
            this.li.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.nt = -1;
        }
    }

    /* renamed from: b */
    public bn m2044b(long j, long j2) {
        bn bnVar;
        synchronized (this.li) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final bl blVar = new bl();
            dv.rp.post(new Runnable(this) {
                final /* synthetic */ bm nv;

                public void run() {
                    synchronized (this.nv.li) {
                        if (this.nv.nt != -2) {
                            return;
                        }
                        this.nv.ns = this.nv.aJ();
                        if (this.nv.ns == null) {
                            this.nv.mo1620f(4);
                            return;
                        }
                        blVar.m2895a(this.nv);
                        this.nv.m2038a(blVar);
                    }
                }
            });
            m2037a(elapsedRealtime, this.no, j, j2);
            bnVar = new bn(this.np, this.ns, this.nn, blVar, this.nt);
        }
        return bnVar;
    }

    public void cancel() {
        synchronized (this.li) {
            try {
                if (this.ns != null) {
                    this.ns.destroy();
                }
            } catch (Throwable e) {
                dw.m818c("Could not destroy mediation adapter.", e);
            }
            this.nt = -1;
            this.li.notify();
        }
    }

    /* renamed from: f */
    public void mo1620f(int i) {
        synchronized (this.li) {
            this.nt = i;
            this.li.notify();
        }
    }
}
