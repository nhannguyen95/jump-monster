package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.x */
public final class C0309x {
    private final C0308a kV;
    private final Runnable kW;
    private ah kX;
    private boolean kY;
    private boolean kZ;
    private long la;

    /* renamed from: com.google.android.gms.internal.x$a */
    public static class C0308a {
        private final Handler mHandler;

        public C0308a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public C0309x(C0998v c0998v) {
        this(c0998v, new C0308a(dv.rp));
    }

    C0309x(final C0998v c0998v, C0308a c0308a) {
        this.kY = false;
        this.kZ = false;
        this.la = 0;
        this.kV = c0308a;
        this.kW = new Runnable(this) {
            private final WeakReference<C0998v> lb = new WeakReference(c0998v);
            final /* synthetic */ C0309x ld;

            public void run() {
                this.ld.kY = false;
                C0998v c0998v = (C0998v) this.lb.get();
                if (c0998v != null) {
                    c0998v.m3156b(this.ld.kX);
                }
            }
        };
    }

    /* renamed from: a */
    public void m1216a(ah ahVar, long j) {
        if (this.kY) {
            dw.m824z("An ad refresh is already scheduled.");
            return;
        }
        this.kX = ahVar;
        this.kY = true;
        this.la = j;
        if (!this.kZ) {
            dw.m822x("Scheduling ad refresh " + j + " milliseconds from now.");
            this.kV.postDelayed(this.kW, j);
        }
    }

    public void cancel() {
        this.kY = false;
        this.kV.removeCallbacks(this.kW);
    }

    /* renamed from: d */
    public void m1217d(ah ahVar) {
        m1216a(ahVar, 60000);
    }

    public void pause() {
        this.kZ = true;
        if (this.kY) {
            this.kV.removeCallbacks(this.kW);
        }
    }

    public void resume() {
        this.kZ = false;
        if (this.kY) {
            this.kY = false;
            m1216a(this.kX, this.la);
        }
    }
}
