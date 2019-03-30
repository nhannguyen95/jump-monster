package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0524c.C0088b;
import com.google.android.gms.analytics.C0524c.C0089c;
import com.google.android.gms.internal.ef;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C0531s implements ag, C0088b, C0089c {
    private final Context mContext;
    private C0090d sG;
    private final C0092f sH;
    private boolean sJ;
    private volatile long sT;
    private volatile C0106a sU;
    private volatile C0086b sV;
    private C0090d sW;
    private final GoogleAnalytics sX;
    private final Queue<C0109d> sY;
    private volatile int sZ;
    private volatile Timer ta;
    private volatile Timer tb;
    private volatile Timer tc;
    private boolean td;
    private boolean te;
    private boolean tf;
    private C0094i tg;
    private long th;

    /* renamed from: com.google.android.gms.analytics.s$2 */
    class C01042 implements Runnable {
        final /* synthetic */ C0531s ti;

        C01042(C0531s c0531s) {
            this.ti = c0531s;
        }

        public void run() {
            this.ti.cq();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$a */
    private enum C0106a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.s$b */
    private class C0107b extends TimerTask {
        final /* synthetic */ C0531s ti;

        private C0107b(C0531s c0531s) {
            this.ti = c0531s;
        }

        public void run() {
            if (this.ti.sU == C0106a.CONNECTED_SERVICE && this.ti.sY.isEmpty() && this.ti.sT + this.ti.th < this.ti.tg.currentTimeMillis()) {
                aa.m35y("Disconnecting due to inactivity");
                this.ti.be();
                return;
            }
            this.ti.tc.schedule(new C0107b(this.ti), this.ti.th);
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$c */
    private class C0108c extends TimerTask {
        final /* synthetic */ C0531s ti;

        private C0108c(C0531s c0531s) {
            this.ti = c0531s;
        }

        public void run() {
            if (this.ti.sU == C0106a.CONNECTING) {
                this.ti.cs();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$d */
    private static class C0109d {
        private final Map<String, String> ts;
        private final long tt;
        private final String tu;
        private final List<ef> tv;

        public C0109d(Map<String, String> map, long j, String str, List<ef> list) {
            this.ts = map;
            this.tt = j;
            this.tu = str;
            this.tv = list;
        }

        public Map<String, String> cv() {
            return this.ts;
        }

        public long cw() {
            return this.tt;
        }

        public List<ef> cx() {
            return this.tv;
        }

        public String getPath() {
            return this.tu;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.tu);
            if (this.ts != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.ts.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$e */
    private class C0110e extends TimerTask {
        final /* synthetic */ C0531s ti;

        private C0110e(C0531s c0531s) {
            this.ti = c0531s;
        }

        public void run() {
            this.ti.ct();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$1 */
    class C05301 implements C0094i {
        final /* synthetic */ C0531s ti;

        C05301(C0531s c0531s) {
            this.ti = c0531s;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    C0531s(Context context, C0092f c0092f) {
        this(context, c0092f, null, GoogleAnalytics.getInstance(context));
    }

    C0531s(Context context, C0092f c0092f, C0090d c0090d, GoogleAnalytics googleAnalytics) {
        this.sY = new ConcurrentLinkedQueue();
        this.th = 300000;
        this.sW = c0090d;
        this.mContext = context;
        this.sH = c0092f;
        this.sX = googleAnalytics;
        this.tg = new C05301(this);
        this.sZ = 0;
        this.sU = C0106a.DISCONNECTED;
    }

    /* renamed from: a */
    private Timer m1597a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void be() {
        if (this.sV != null && this.sU == C0106a.CONNECTED_SERVICE) {
            this.sU = C0106a.PENDING_DISCONNECT;
            this.sV.disconnect();
        }
    }

    private void co() {
        this.ta = m1597a(this.ta);
        this.tb = m1597a(this.tb);
        this.tc = m1597a(this.tc);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void cq() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r2 = r7.sH;	 Catch:{ all -> 0x0074 }
        r2 = r2.getThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.sH;	 Catch:{ all -> 0x0074 }
        r1 = r1.bZ();	 Catch:{ all -> 0x0074 }
        r2 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r2.<init>(r7);	 Catch:{ all -> 0x0074 }
        r1.add(r2);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.td;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.bR();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r1 = com.google.android.gms.analytics.C0531s.C01053.tj;	 Catch:{ all -> 0x0074 }
        r2 = r7.sU;	 Catch:{ all -> 0x0074 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0074 }
        r1 = r1[r2];	 Catch:{ all -> 0x0074 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.sY;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0077;
    L_0x003e:
        r1 = r7.sY;	 Catch:{ all -> 0x0074 }
        r1 = r1.poll();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0531s.C0109d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to store  ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m35y(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.sG;	 Catch:{ all -> 0x0074 }
        r2 = r6.cv();	 Catch:{ all -> 0x0074 }
        r3 = r6.cw();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.cx();	 Catch:{ all -> 0x0074 }
        r1.mo998a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0077:
        r1 = r7.sJ;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x001f;
    L_0x007b:
        r7.cr();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r1 = r7.sY;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00d0;
    L_0x0087:
        r1 = r7.sY;	 Catch:{ all -> 0x0074 }
        r1 = r1.peek();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0531s.C0109d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to service   ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m35y(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.sX;	 Catch:{ all -> 0x0074 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00af:
        r1 = r7.sV;	 Catch:{ all -> 0x0074 }
        r2 = r6.cv();	 Catch:{ all -> 0x0074 }
        r3 = r6.cw();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.cx();	 Catch:{ all -> 0x0074 }
        r1.mo1010a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r1 = r7.sY;	 Catch:{ all -> 0x0074 }
        r1.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.m35y(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r1 = r7.tg;	 Catch:{ all -> 0x0074 }
        r1 = r1.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r7.sT = r1;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r1 = "Need to reconnect";
        com.google.android.gms.analytics.aa.m35y(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.sY;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x001f;
    L_0x00e7:
        r7.ct();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.cq():void");
    }

    private void cr() {
        this.sG.bW();
        this.sJ = false;
    }

    private synchronized void cs() {
        if (this.sU != C0106a.CONNECTED_LOCAL) {
            co();
            aa.m35y("falling back to local store");
            if (this.sW != null) {
                this.sG = this.sW;
            } else {
                C0529r ci = C0529r.ci();
                ci.m1594a(this.mContext, this.sH);
                this.sG = ci.cl();
            }
            this.sU = C0106a.CONNECTED_LOCAL;
            cq();
        }
    }

    private synchronized void ct() {
        if (this.tf || this.sV == null || this.sU == C0106a.CONNECTED_LOCAL) {
            aa.m36z("client not initialized.");
            cs();
        } else {
            try {
                this.sZ++;
                m1597a(this.tb);
                this.sU = C0106a.CONNECTING;
                this.tb = new Timer("Failed Connect");
                this.tb.schedule(new C0108c(), 3000);
                aa.m35y("connecting to Analytics service");
                this.sV.connect();
            } catch (SecurityException e) {
                aa.m36z("security exception on connectToService");
                cs();
            }
        }
    }

    private void cu() {
        this.ta = m1597a(this.ta);
        this.ta = new Timer("Service Reconnect");
        this.ta.schedule(new C0110e(), 5000);
    }

    /* renamed from: a */
    public synchronized void mo1026a(int i, Intent intent) {
        this.sU = C0106a.PENDING_CONNECTION;
        if (this.sZ < 2) {
            aa.m36z("Service unavailable (code=" + i + "), will retry.");
            cu();
        } else {
            aa.m36z("Service unavailable (code=" + i + "), using local store.");
            cs();
        }
    }

    /* renamed from: b */
    public void mo1027b(Map<String, String> map, long j, String str, List<ef> list) {
        aa.m35y("putHit called");
        this.sY.add(new C0109d(map, j, str, list));
        cq();
    }

    public void bR() {
        aa.m35y("clearHits called");
        this.sY.clear();
        switch (this.sU) {
            case CONNECTED_LOCAL:
                this.sG.mo1001j(0);
                this.td = false;
                return;
            case CONNECTED_SERVICE:
                this.sV.bR();
                this.td = false;
                return;
            default:
                this.td = true;
                return;
        }
    }

    public void bW() {
        switch (this.sU) {
            case CONNECTED_LOCAL:
                cr();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.sJ = true;
                return;
        }
    }

    public synchronized void bY() {
        if (!this.tf) {
            aa.m35y("setForceLocalDispatch called.");
            this.tf = true;
            switch (this.sU) {
                case CONNECTED_LOCAL:
                case PENDING_CONNECTION:
                case PENDING_DISCONNECT:
                case DISCONNECTED:
                    break;
                case CONNECTED_SERVICE:
                    be();
                    break;
                case CONNECTING:
                    this.te = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void cp() {
        if (this.sV == null) {
            this.sV = new C0524c(this.mContext, this, this);
            ct();
        }
    }

    public synchronized void onConnected() {
        this.tb = m1597a(this.tb);
        this.sZ = 0;
        aa.m35y("Connected to service");
        this.sU = C0106a.CONNECTED_SERVICE;
        if (this.te) {
            be();
            this.te = false;
        } else {
            cq();
            this.tc = m1597a(this.tc);
            this.tc = new Timer("disconnect check");
            this.tc.schedule(new C0107b(), this.th);
        }
    }

    public synchronized void onDisconnected() {
        if (this.sU == C0106a.PENDING_DISCONNECT) {
            aa.m35y("Disconnected from service");
            co();
            this.sU = C0106a.DISCONNECTED;
        } else {
            aa.m35y("Unexpected disconnect.");
            this.sU = C0106a.PENDING_CONNECTION;
            if (this.sZ < 2) {
                cu();
            } else {
                cs();
            }
        }
    }
}
