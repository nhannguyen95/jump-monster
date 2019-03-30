package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cx extends cw {
    private static cx aam;
    private static final Object sF = new Object();
    private Context aac;
    private at aad;
    private volatile ar aae;
    private int aaf = 1800000;
    private boolean aag = true;
    private boolean aah = false;
    private boolean aai = true;
    private au aaj = new C08261(this);
    private bn aak;
    private boolean aal = false;
    private boolean connected = true;
    private Handler handler;

    /* renamed from: com.google.android.gms.tagmanager.cx$2 */
    class C04012 implements Callback {
        final /* synthetic */ cx aan;

        C04012(cx cxVar) {
            this.aan = cxVar;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && cx.sF.equals(msg.obj)) {
                this.aan.bW();
                if (this.aan.aaf > 0 && !this.aan.aal) {
                    this.aan.handler.sendMessageDelayed(this.aan.handler.obtainMessage(1, cx.sF), (long) this.aan.aaf);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cx$3 */
    class C04023 implements Runnable {
        final /* synthetic */ cx aan;

        C04023(cx cxVar) {
            this.aan = cxVar;
        }

        public void run() {
            this.aan.aad.bW();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cx$1 */
    class C08261 implements au {
        final /* synthetic */ cx aan;

        C08261(cx cxVar) {
            this.aan = cxVar;
        }

        /* renamed from: r */
        public void mo2285r(boolean z) {
            this.aan.m2508a(z, this.aan.connected);
        }
    }

    private cx() {
    }

    private void cj() {
        this.aak = new bn(this);
        this.aak.m1397o(this.aac);
    }

    private void ck() {
        this.handler = new Handler(this.aac.getMainLooper(), new C04012(this));
        if (this.aaf > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, sF), (long) this.aaf);
        }
    }

    public static cx lG() {
        if (aam == null) {
            aam = new cx();
        }
        return aam;
    }

    /* renamed from: a */
    synchronized void m2507a(Context context, ar arVar) {
        if (this.aac == null) {
            this.aac = context.getApplicationContext();
            if (this.aae == null) {
                this.aae = arVar;
            }
        }
    }

    /* renamed from: a */
    synchronized void m2508a(boolean z, boolean z2) {
        if (!(this.aal == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.aaf > 0) {
                    this.handler.removeMessages(1, sF);
                }
            }
            if (!z && z2 && this.aaf > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, sF), (long) this.aaf);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.m1387y(append.append(str).toString());
            this.aal = z;
            this.connected = z2;
        }
    }

    public synchronized void bW() {
        if (this.aah) {
            this.aae.mo2241a(new C04023(this));
        } else {
            bh.m1387y("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.aag = true;
        }
    }

    synchronized void cm() {
        if (!this.aal && this.connected && this.aaf > 0) {
            this.handler.removeMessages(1, sF);
            this.handler.sendMessage(this.handler.obtainMessage(1, sF));
        }
    }

    synchronized at lH() {
        if (this.aad == null) {
            if (this.aac == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.aad = new ca(this.aaj, this.aac);
        }
        if (this.handler == null) {
            ck();
        }
        this.aah = true;
        if (this.aag) {
            bW();
            this.aag = false;
        }
        if (this.aak == null && this.aai) {
            cj();
        }
        return this.aad;
    }

    /* renamed from: s */
    synchronized void mo2287s(boolean z) {
        m2508a(this.aal, z);
    }
}
