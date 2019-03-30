package com.google.android.gms.internal;

import android.content.Context;

public final class bh {
    private final bq ky;
    private final Object li = new Object();
    private final Context mContext;
    private final cx mQ;
    private final bj mR;
    private boolean mS = false;
    private bm mT;

    public bh(Context context, cx cxVar, bq bqVar, bj bjVar) {
        this.mContext = context;
        this.mQ = cxVar;
        this.ky = bqVar;
        this.mR = bjVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public com.google.android.gms.internal.bn m661a(long r17, long r19) {
        /*
        r16 = this;
        r4 = "Starting mediation.";
        com.google.android.gms.internal.dw.m820v(r4);
        r0 = r16;
        r4 = r0.mR;
        r4 = r4.nc;
        r13 = r4.iterator();
    L_0x000f:
        r4 = r13.hasNext();
        if (r4 == 0) goto L_0x00aa;
    L_0x0015:
        r9 = r13.next();
        r9 = (com.google.android.gms.internal.bi) r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Trying mediation network: ";
        r4 = r4.append(r5);
        r5 = r9.mX;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.internal.dw.m822x(r4);
        r4 = r9.mY;
        r14 = r4.iterator();
    L_0x0039:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x000f;
    L_0x003f:
        r6 = r14.next();
        r6 = (java.lang.String) r6;
        r0 = r16;
        r15 = r0.li;
        monitor-enter(r15);
        r0 = r16;
        r4 = r0.mS;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0058;
    L_0x0050:
        r4 = new com.google.android.gms.internal.bn;	 Catch:{ all -> 0x0096 }
        r5 = -1;
        r4.<init>(r5);	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = new com.google.android.gms.internal.bm;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r5 = r0.mContext;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r7 = r0.ky;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r8 = r0.mR;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r10 = r0.mQ;	 Catch:{ all -> 0x0096 }
        r10 = r10.pg;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r11 = r0.mQ;	 Catch:{ all -> 0x0096 }
        r11 = r11.kN;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r12 = r0.mQ;	 Catch:{ all -> 0x0096 }
        r12 = r12.kK;	 Catch:{ all -> 0x0096 }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r0.mT = r4;	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r4 = r0.mT;
        r0 = r17;
        r2 = r19;
        r4 = r4.m2044b(r0, r2);
        r5 = r4.nw;
        if (r5 != 0) goto L_0x0099;
    L_0x0090:
        r5 = "Adapter succeeded.";
        com.google.android.gms.internal.dw.m820v(r5);
        goto L_0x0057;
    L_0x0096:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        throw r4;
    L_0x0099:
        r5 = r4.ny;
        if (r5 == 0) goto L_0x0039;
    L_0x009d:
        r5 = com.google.android.gms.internal.dv.rp;
        r6 = new com.google.android.gms.internal.bh$1;
        r0 = r16;
        r6.<init>(r0, r4);
        r5.post(r6);
        goto L_0x0039;
    L_0x00aa:
        r4 = new com.google.android.gms.internal.bn;
        r5 = 1;
        r4.<init>(r5);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bh.a(long, long):com.google.android.gms.internal.bn");
    }

    public void cancel() {
        synchronized (this.li) {
            this.mS = true;
            if (this.mT != null) {
                this.mT.cancel();
            }
        }
    }
}
