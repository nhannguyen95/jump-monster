package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.cr.C0230a;
import com.google.android.gms.internal.cu.C0237a;
import com.google.android.gms.internal.cx.C0238a;
import com.google.android.gms.internal.ea.C0252a;
import org.json.JSONException;
import org.json.JSONObject;

public class cs extends C0243do implements C0237a, C0252a {
    private final bq ky;
    private final dz lC;
    private final Object li = new Object();
    private final Context mContext;
    private bj mR;
    private final C0230a oG;
    private final Object oH = new Object();
    private final C0238a oI;
    private final C0294l oJ;
    private C0243do oK;
    private cz oL;
    private boolean oM = false;
    private bh oN;
    private bn oO;

    /* renamed from: com.google.android.gms.internal.cs$1 */
    class C02311 implements Runnable {
        final /* synthetic */ cs oP;

        C02311(cs csVar) {
            this.oP = csVar;
        }

        public void run() {
            this.oP.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs$3 */
    class C02333 implements Runnable {
        final /* synthetic */ cs oP;

        C02333(cs csVar) {
            this.oP = csVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r0 = r7.oP;
            r6 = r0.li;
            monitor-enter(r6);
            r0 = r7.oP;	 Catch:{ all -> 0x005f }
            r0 = r0.oL;	 Catch:{ all -> 0x005f }
            r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
            r1 = -2;
            if (r0 == r1) goto L_0x0014;
        L_0x0012:
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
        L_0x0013:
            return;
        L_0x0014:
            r0 = r7.oP;	 Catch:{ all -> 0x005f }
            r0 = r0.lC;	 Catch:{ all -> 0x005f }
            r0 = r0.bI();	 Catch:{ all -> 0x005f }
            r1 = r7.oP;	 Catch:{ all -> 0x005f }
            r0.m842a(r1);	 Catch:{ all -> 0x005f }
            r0 = r7.oP;	 Catch:{ all -> 0x005f }
            r0 = r0.oL;	 Catch:{ all -> 0x005f }
            r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
            r1 = -3;
            if (r0 != r1) goto L_0x0062;
        L_0x002e:
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
            r0.<init>();	 Catch:{ all -> 0x005f }
            r1 = "Loading URL in WebView: ";
            r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
            r1 = r7.oP;	 Catch:{ all -> 0x005f }
            r1 = r1.oL;	 Catch:{ all -> 0x005f }
            r1 = r1.ol;	 Catch:{ all -> 0x005f }
            r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
            r0 = r0.toString();	 Catch:{ all -> 0x005f }
            com.google.android.gms.internal.dw.m823y(r0);	 Catch:{ all -> 0x005f }
            r0 = r7.oP;	 Catch:{ all -> 0x005f }
            r0 = r0.lC;	 Catch:{ all -> 0x005f }
            r1 = r7.oP;	 Catch:{ all -> 0x005f }
            r1 = r1.oL;	 Catch:{ all -> 0x005f }
            r1 = r1.ol;	 Catch:{ all -> 0x005f }
            r0.loadUrl(r1);	 Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
            goto L_0x0013;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r0 = "Loading HTML in WebView.";
            com.google.android.gms.internal.dw.m823y(r0);	 Catch:{ all -> 0x005f }
            r0 = r7.oP;	 Catch:{ all -> 0x005f }
            r0 = r0.lC;	 Catch:{ all -> 0x005f }
            r1 = r7.oP;	 Catch:{ all -> 0x005f }
            r1 = r1.oL;	 Catch:{ all -> 0x005f }
            r1 = r1.ol;	 Catch:{ all -> 0x005f }
            r1 = com.google.android.gms.internal.dq.m796r(r1);	 Catch:{ all -> 0x005f }
            r2 = r7.oP;	 Catch:{ all -> 0x005f }
            r2 = r2.oL;	 Catch:{ all -> 0x005f }
            r2 = r2.pm;	 Catch:{ all -> 0x005f }
            r3 = "text/html";
            r4 = "UTF-8";
            r5 = 0;
            r0.loadDataWithBaseURL(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005f }
            goto L_0x005d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cs.3.run():void");
        }
    }

    /* renamed from: com.google.android.gms.internal.cs$a */
    private static final class C0235a extends Exception {
        private final int oS;

        public C0235a(String str, int i) {
            super(str);
            this.oS = i;
        }

        public int getErrorCode() {
            return this.oS;
        }
    }

    public cs(Context context, C0238a c0238a, C0294l c0294l, dz dzVar, bq bqVar, C0230a c0230a) {
        this.ky = bqVar;
        this.oG = c0230a;
        this.lC = dzVar;
        this.mContext = context;
        this.oI = c0238a;
        this.oJ = c0294l;
    }

    /* renamed from: a */
    private ak m2071a(cx cxVar) throws C0235a {
        if (this.oL.pr == null) {
            throw new C0235a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.oL.pr.split("x");
        if (split.length != 2) {
            throw new C0235a("Could not parse the ad size from the ad response: " + this.oL.pr, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ak akVar : cxVar.kN.lU) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = akVar.width == -1 ? (int) (((float) akVar.widthPixels) / f) : akVar.width;
                int i2 = akVar.height == -2 ? (int) (((float) akVar.heightPixels) / f) : akVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ak(akVar, cxVar.kN.lU);
                }
            }
            throw new C0235a("The ad size from the ad response was not one of the requested sizes: " + this.oL.pr, 0);
        } catch (NumberFormatException e) {
            throw new C0235a("Could not parse the ad size from the ad response: " + this.oL.pr, 0);
        }
    }

    /* renamed from: a */
    private void m2073a(cx cxVar, long j) throws C0235a {
        synchronized (this.oH) {
            this.oN = new bh(this.mContext, cxVar, this.ky, this.mR);
        }
        this.oO = this.oN.m661a(j, 60000);
        switch (this.oO.nw) {
            case 0:
                return;
            case 1:
                throw new C0235a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0235a("Unexpected mediation result: " + this.oO.nw, 0);
        }
    }

    private void aZ() throws C0235a {
        if (this.oL.errorCode != -3) {
            if (TextUtils.isEmpty(this.oL.pm)) {
                throw new C0235a("No fill from ad server.", 3);
            } else if (this.oL.po) {
                try {
                    this.mR = new bj(this.oL.pm);
                } catch (JSONException e) {
                    throw new C0235a("Could not parse mediation config: " + this.oL.pm, 0);
                }
            }
        }
    }

    /* renamed from: b */
    private void m2075b(long j) throws C0235a {
        dv.rp.post(new C02333(this));
        m2079e(j);
    }

    /* renamed from: d */
    private void m2078d(long j) throws C0235a {
        while (m2080f(j)) {
            if (this.oL != null) {
                synchronized (this.oH) {
                    this.oK = null;
                }
                if (this.oL.errorCode != -2 && this.oL.errorCode != -3) {
                    throw new C0235a("There was a problem getting an ad response. ErrorCode: " + this.oL.errorCode, this.oL.errorCode);
                }
                return;
            }
        }
        throw new C0235a("Timed out waiting for ad response.", 2);
    }

    /* renamed from: e */
    private void m2079e(long j) throws C0235a {
        while (m2080f(j)) {
            if (this.oM) {
                return;
            }
        }
        throw new C0235a("Timed out waiting for WebView to finish loading.", 2);
    }

    /* renamed from: f */
    private boolean m2080f(long j) throws C0235a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.li.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0235a("Ad request cancelled.", -1);
        }
    }

    /* renamed from: a */
    public void mo1681a(cz czVar) {
        synchronized (this.li) {
            dw.m820v("Received ad response.");
            this.oL = czVar;
            this.li.notify();
        }
    }

    /* renamed from: a */
    public void mo1590a(dz dzVar) {
        synchronized (this.li) {
            dw.m820v("WebView finished loading.");
            this.oM = true;
            this.li.notify();
        }
    }

    public void aY() {
        synchronized (this.li) {
            long j;
            ak akVar;
            final dh dhVar;
            dw.m820v("AdLoaderBackgroundTask started.");
            cx cxVar = new cx(this.oI, this.oJ.m1184y().mo1817a(this.mContext));
            ak akVar2 = null;
            int i = -2;
            long j2 = -1;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C0243do a = cu.m715a(this.mContext, cxVar, this);
                synchronized (this.oH) {
                    this.oK = a;
                    if (this.oK == null) {
                        throw new C0235a("Could not start the ad request service.", 0);
                    }
                }
                m2078d(elapsedRealtime);
                j2 = SystemClock.elapsedRealtime();
                aZ();
                if (cxVar.kN.lU != null) {
                    akVar2 = m2071a(cxVar);
                }
                if (this.oL.po) {
                    m2073a(cxVar, elapsedRealtime);
                } else if (this.oL.pu) {
                    m2083c(elapsedRealtime);
                } else {
                    m2075b(elapsedRealtime);
                }
                j = j2;
                akVar = akVar2;
            } catch (C0235a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    dw.m822x(e.getMessage());
                } else {
                    dw.m824z(e.getMessage());
                }
                if (this.oL == null) {
                    this.oL = new cz(i);
                } else {
                    this.oL = new cz(i, this.oL.ni);
                }
                dv.rp.post(new C02311(this));
                j = j2;
                akVar = akVar2;
            }
            if (!TextUtils.isEmpty(this.oL.pw)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.oL.pw);
                } catch (Throwable e2) {
                    dw.m817b("Error parsing the JSON for Active View.", e2);
                }
                dhVar = new dh(cxVar.pg, this.lC, this.oL.ne, i, this.oL.nf, this.oL.pq, this.oL.orientation, this.oL.ni, cxVar.pj, this.oL.po, this.oO == null ? this.oO.nx : null, this.oO == null ? this.oO.ny : null, this.oO == null ? this.oO.nz : null, this.mR, this.oO == null ? this.oO.nA : null, this.oL.pp, akVar, this.oL.pn, j, this.oL.ps, this.oL.pt, r29);
                dv.rp.post(new Runnable(this) {
                    final /* synthetic */ cs oP;

                    public void run() {
                        synchronized (this.oP.li) {
                            this.oP.oG.mo3161a(dhVar);
                        }
                    }
                });
            }
            JSONObject jSONObject2 = null;
            if (this.oO == null) {
            }
            if (this.oO == null) {
            }
            if (this.oO == null) {
            }
            if (this.oO == null) {
            }
            dhVar = new dh(cxVar.pg, this.lC, this.oL.ne, i, this.oL.nf, this.oL.pq, this.oL.orientation, this.oL.ni, cxVar.pj, this.oL.po, this.oO == null ? this.oO.nx : null, this.oO == null ? this.oO.ny : null, this.oO == null ? this.oO.nz : null, this.mR, this.oO == null ? this.oO.nA : null, this.oL.pp, akVar, this.oL.pn, j, this.oL.ps, this.oL.pt, jSONObject2);
            dv.rp.post(/* anonymous class already generated */);
        }
    }

    /* renamed from: c */
    protected void m2083c(long j) throws C0235a {
        int i;
        int i2;
        ak R = this.lC.m829R();
        if (R.lT) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = R.widthPixels;
            i2 = R.heightPixels;
        }
        final ct ctVar = new ct(this, this.lC, i, i2);
        dv.rp.post(new Runnable(this) {
            final /* synthetic */ cs oP;

            public void run() {
                synchronized (this.oP.li) {
                    if (this.oP.oL.errorCode != -2) {
                        return;
                    }
                    this.oP.lC.bI().m842a(this.oP);
                    ctVar.m713b(this.oP.oL);
                }
            }
        });
        m2079e(j);
        if (ctVar.bc()) {
            dw.m820v("Ad-Network indicated no fill with passback URL.");
            throw new C0235a("AdNetwork sent passback url", 3);
        } else if (!ctVar.bd()) {
            throw new C0235a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.oH) {
            if (this.oK != null) {
                this.oK.cancel();
            }
            this.lC.stopLoading();
            dq.m782a(this.lC);
            if (this.oN != null) {
                this.oN.cancel();
            }
        }
    }
}
