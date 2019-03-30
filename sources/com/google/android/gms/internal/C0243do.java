package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.do */
public abstract class C0243do {
    private final Runnable kW = new C02421(this);
    private volatile Thread qY;

    /* renamed from: com.google.android.gms.internal.do$1 */
    class C02421 implements Runnable {
        final /* synthetic */ C0243do qZ;

        C02421(C0243do c0243do) {
            this.qZ = c0243do;
        }

        public final void run() {
            this.qZ.qY = Thread.currentThread();
            this.qZ.aY();
        }
    }

    public abstract void aY();

    public final void cancel() {
        onStop();
        if (this.qY != null) {
            this.qY.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        dp.execute(this.kW);
    }
}
