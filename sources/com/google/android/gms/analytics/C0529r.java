package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0116u.C0115a;

/* renamed from: com.google.android.gms.analytics.r */
class C0529r extends af {
    private static final Object sF = new Object();
    private static C0529r sR;
    private Context mContext;
    private Handler mHandler;
    private C0090d sG;
    private volatile C0092f sH;
    private int sI = 1800;
    private boolean sJ = true;
    private boolean sK;
    private String sL;
    private boolean sM = true;
    private boolean sN = true;
    private C0091e sO = new C05281(this);
    private C0102q sP;
    private boolean sQ = false;

    /* renamed from: com.google.android.gms.analytics.r$2 */
    class C01032 implements Callback {
        final /* synthetic */ C0529r sS;

        C01032(C0529r c0529r) {
            this.sS = c0529r;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C0529r.sF.equals(msg.obj)) {
                C0116u.cy().m70t(true);
                this.sS.dispatchLocalHits();
                C0116u.cy().m70t(false);
                if (this.sS.sI > 0 && !this.sS.sQ) {
                    this.sS.mHandler.sendMessageDelayed(this.sS.mHandler.obtainMessage(1, C0529r.sF), (long) (this.sS.sI * 1000));
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.analytics.r$1 */
    class C05281 implements C0091e {
        final /* synthetic */ C0529r sS;

        C05281(C0529r c0529r) {
            this.sS = c0529r;
        }

        /* renamed from: r */
        public void mo1021r(boolean z) {
            this.sS.m1595a(z, this.sS.sM);
        }
    }

    private C0529r() {
    }

    public static C0529r ci() {
        if (sR == null) {
            sR = new C0529r();
        }
        return sR;
    }

    private void cj() {
        this.sP = new C0102q(this);
        this.sP.m68o(this.mContext);
    }

    private void ck() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C01032(this));
        if (this.sI > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), (long) (this.sI * 1000));
        }
    }

    /* renamed from: a */
    synchronized void m1594a(Context context, C0092f c0092f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.sH == null) {
                this.sH = c0092f;
                if (this.sJ) {
                    dispatchLocalHits();
                    this.sJ = false;
                }
                if (this.sK) {
                    bY();
                    this.sK = false;
                }
            }
        }
    }

    /* renamed from: a */
    synchronized void m1595a(boolean z, boolean z2) {
        if (!(this.sQ == z && this.sM == z2)) {
            if (z || !z2) {
                if (this.sI > 0) {
                    this.mHandler.removeMessages(1, sF);
                }
            }
            if (!z && z2 && this.sI > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), (long) (this.sI * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.m35y(append.append(str).toString());
            this.sQ = z;
            this.sM = z2;
        }
    }

    void bY() {
        if (this.sH == null) {
            aa.m35y("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.sK = true;
            return;
        }
        C0116u.cy().m69a(C0115a.SET_FORCE_LOCAL_DISPATCH);
        this.sH.bY();
    }

    synchronized C0090d cl() {
        if (this.sG == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.sG = new ac(this.sO, this.mContext);
            if (this.sL != null) {
                this.sG.bX().mo1002F(this.sL);
                this.sL = null;
            }
        }
        if (this.mHandler == null) {
            ck();
        }
        if (this.sP == null && this.sN) {
            cj();
        }
        return this.sG;
    }

    synchronized void cm() {
        if (!this.sQ && this.sM && this.sI > 0) {
            this.mHandler.removeMessages(1, sF);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, sF));
        }
    }

    synchronized void dispatchLocalHits() {
        if (this.sH == null) {
            aa.m35y("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.sJ = true;
        } else {
            C0116u.cy().m69a(C0115a.DISPATCH);
            this.sH.bW();
        }
    }

    /* renamed from: s */
    synchronized void mo1024s(boolean z) {
        m1595a(this.sQ, z);
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.m35y("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.sI = dispatchPeriodInSeconds;
        } else {
            C0116u.cy().m69a(C0115a.SET_DISPATCH_PERIOD);
            if (!this.sQ && this.sM && this.sI > 0) {
                this.mHandler.removeMessages(1, sF);
            }
            this.sI = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.sQ && this.sM) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), (long) (dispatchPeriodInSeconds * 1000));
            }
        }
    }
}
