package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C0378a {
    private static C0378a Wx;
    private static Object sf = new Object();
    private volatile long Ws;
    private volatile long Wt;
    private volatile long Wu;
    private final gl Wv;
    private C0377a Ww;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread qY;
    private volatile Info sh;

    /* renamed from: com.google.android.gms.tagmanager.a$2 */
    class C03762 implements Runnable {
        final /* synthetic */ C0378a Wy;

        C03762(C0378a c0378a) {
            this.Wy = c0378a;
        }

        public void run() {
            this.Wy.jU();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a$a */
    public interface C0377a {
        Info jW();
    }

    /* renamed from: com.google.android.gms.tagmanager.a$1 */
    class C08151 implements C0377a {
        final /* synthetic */ C0378a Wy;

        C08151(C0378a c0378a) {
            this.Wy = c0378a;
        }

        public Info jW() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.Wy.mContext);
            } catch (IllegalStateException e) {
                bh.m1388z("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m1388z("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m1388z("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m1388z("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m1388z("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    private C0378a(Context context) {
        this(context, null, gn.ft());
    }

    C0378a(Context context, C0377a c0377a, gl glVar) {
        this.Ws = 900000;
        this.Wt = 30000;
        this.mClosed = false;
        this.Ww = new C08151(this);
        this.Wv = glVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c0377a != null) {
            this.Ww = c0377a;
        }
        this.qY = new Thread(new C03762(this));
    }

    /* renamed from: E */
    static C0378a m1357E(Context context) {
        if (Wx == null) {
            synchronized (sf) {
                if (Wx == null) {
                    Wx = new C0378a(context);
                    Wx.start();
                }
            }
        }
        return Wx;
    }

    private void jU() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.sh = this.Ww.jW();
                Thread.sleep(this.Ws);
            } catch (InterruptedException e) {
                bh.m1386x("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void jV() {
        if (this.Wv.currentTimeMillis() - this.Wu >= this.Wt) {
            interrupt();
            this.Wu = this.Wv.currentTimeMillis();
        }
    }

    void interrupt() {
        this.qY.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        jV();
        return this.sh == null ? true : this.sh.isLimitAdTrackingEnabled();
    }

    public String jT() {
        jV();
        return this.sh == null ? null : this.sh.getId();
    }

    void start() {
        this.qY.start();
    }
}
