package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as Ya;
    private final LinkedBlockingQueue<Runnable> XZ = new LinkedBlockingQueue();
    private volatile at Yb;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean tx = false;

    private as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: H */
    static as m2444H(Context context) {
        if (Ya == null) {
            Ya = new as(context);
        }
        return Ya;
    }

    /* renamed from: a */
    private String m2447a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    public void mo2241a(Runnable runnable) {
        this.XZ.add(runnable);
    }

    /* renamed from: b */
    void m2450b(String str, long j) {
        final as asVar = this;
        final long j2 = j;
        final String str2 = str;
        mo2241a(new Runnable(this) {
            final /* synthetic */ as Yf;

            public void run() {
                if (this.Yf.Yb == null) {
                    cx lG = cx.lG();
                    lG.m2507a(this.Yf.mContext, asVar);
                    this.Yf.Yb = lG.lH();
                }
                this.Yf.Yb.mo2280e(j2, str2);
            }
        });
    }

    public void bC(String str) {
        m2450b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.XZ.take();
                if (!this.tx) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.m1386x(e.toString());
            } catch (Throwable th) {
                bh.m1385w("Error on GAThread: " + m2447a(th));
                bh.m1385w("Google Analytics is shutting down.");
                this.tx = true;
            }
        }
    }
}
