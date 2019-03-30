package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.C0129a.C0127c;
import com.google.android.gms.common.api.C0129a.C0544a;
import com.google.android.gms.common.api.PendingResult.C0126a;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends C0544a<BatchResult> {
    private int AM;
    private boolean AN;
    private boolean AO;
    private final PendingResult<?>[] AP;
    private final Object li;

    public static final class Builder {
        private List<PendingResult<?>> AR = new ArrayList();
        private Looper AS;

        public Builder(GoogleApiClient googleApiClient) {
            this.AS = googleApiClient.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.AR.size());
            this.AR.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.AR, this.AS);
        }
    }

    /* renamed from: com.google.android.gms.common.api.Batch$1 */
    class C05431 implements C0126a {
        final /* synthetic */ Batch AQ;

        C05431(Batch batch) {
            this.AQ = batch;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: l */
        public void mo1068l(com.google.android.gms.common.api.Status r6) {
            /*
            r5 = this;
            r0 = r5.AQ;
            r1 = r0.li;
            monitor-enter(r1);
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r0 = r0.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0017:
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.AO = r2;	 Catch:{ all -> 0x0039 }
        L_0x001d:
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r0.AM = r0.AM - 1;	 Catch:{ all -> 0x0039 }
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r0 = r0.AM;	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037;
        L_0x002a:
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r0 = r0.AO;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0049;
        L_0x0032:
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            super.cancel();	 Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0010;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = r6.isSuccess();	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x001d;
        L_0x0042:
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.AN = r2;	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0049:
            r0 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r0 = r0.AN;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0069;
        L_0x0051:
            r0 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0039 }
            r2 = 13;
            r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        L_0x0058:
            r2 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r3 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0039 }
            r4 = r5.AQ;	 Catch:{ all -> 0x0039 }
            r4 = r4.AP;	 Catch:{ all -> 0x0039 }
            r3.<init>(r0, r4);	 Catch:{ all -> 0x0039 }
            r2.m1653a(r3);	 Catch:{ all -> 0x0039 }
            goto L_0x0037;
        L_0x0069:
            r0 = com.google.android.gms.common.api.Status.Bv;	 Catch:{ all -> 0x0039 }
            goto L_0x0058;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.1.l(com.google.android.gms.common.api.Status):void");
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, Looper looper) {
        super(new C0127c(looper));
        this.li = new Object();
        this.AM = pendingResultList.size();
        this.AP = new PendingResult[this.AM];
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.AP[i] = pendingResult;
            pendingResult.mo1071a(new C05431(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.AP) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.AP);
    }

    /* renamed from: d */
    public /* synthetic */ Result mo2670d(Status status) {
        return createFailedResult(status);
    }
}
