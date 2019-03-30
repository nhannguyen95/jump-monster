package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0123a;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.C0548b.C0130a;
import com.google.android.gms.common.api.C0548b.C0132c;
import com.google.android.gms.common.api.PendingResult.C0126a;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a */
public class C0129a {

    /* renamed from: com.google.android.gms.common.api.a$c */
    public static class C0127c<R extends Result> extends Handler {
        public C0127c() {
            this(Looper.getMainLooper());
        }

        public C0127c(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m130a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* renamed from: a */
        public void m131a(C0544a<R> c0544a, long j) {
            sendMessageDelayed(obtainMessage(2, c0544a), j);
        }

        /* renamed from: b */
        protected void m132b(ResultCallback<R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        public void eg() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    m132b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((C0544a) msg.obj).ee();
                    return;
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a$d */
    public interface C0128d<R> {
        /* renamed from: b */
        void mo1074b(R r);
    }

    /* renamed from: com.google.android.gms.common.api.a$a */
    public static abstract class C0544a<R extends Result> implements PendingResult<R>, C0128d<R> {
        private final Object AB = new Object();
        private C0127c<R> AC;
        private final CountDownLatch AD = new CountDownLatch(1);
        private final ArrayList<C0126a> AE = new ArrayList();
        private ResultCallback<R> AF;
        private volatile R AG;
        private volatile boolean AH;
        private boolean AI;
        private boolean AJ;
        private fk AK;

        C0544a() {
        }

        public C0544a(Looper looper) {
            this.AC = new C0127c(looper);
        }

        public C0544a(C0127c<R> c0127c) {
            this.AC = c0127c;
        }

        /* renamed from: b */
        private void m1650b(R r) {
            this.AG = r;
            this.AK = null;
            this.AD.countDown();
            Status status = this.AG.getStatus();
            if (this.AF != null) {
                this.AC.eg();
                if (!this.AI) {
                    this.AC.m130a(this.AF, eb());
                }
            }
            Iterator it = this.AE.iterator();
            while (it.hasNext()) {
                ((C0126a) it.next()).mo1068l(status);
            }
            this.AE.clear();
        }

        /* renamed from: c */
        private void m1651c(Result result) {
            if (result instanceof Releasable) {
                try {
                    ((Releasable) result).release();
                } catch (Throwable e) {
                    Log.w("AbstractPendingResult", "Unable to release " + this, e);
                }
            }
        }

        private R eb() {
            R r;
            synchronized (this.AB) {
                fq.m981a(!this.AH, "Result has already been consumed.");
                fq.m981a(isReady(), "Result is not ready.");
                r = this.AG;
                ec();
            }
            return r;
        }

        private void ed() {
            synchronized (this.AB) {
                if (!isReady()) {
                    m1653a(mo2670d(Status.Bw));
                    this.AJ = true;
                }
            }
        }

        private void ee() {
            synchronized (this.AB) {
                if (!isReady()) {
                    m1653a(mo2670d(Status.By));
                    this.AJ = true;
                }
            }
        }

        /* renamed from: a */
        public final void mo1071a(C0126a c0126a) {
            fq.m981a(!this.AH, "Result has already been consumed.");
            synchronized (this.AB) {
                if (isReady()) {
                    c0126a.mo1068l(this.AG.getStatus());
                } else {
                    this.AE.add(c0126a);
                }
            }
        }

        /* renamed from: a */
        public final void m1653a(R r) {
            boolean z = true;
            synchronized (this.AB) {
                if (this.AJ || this.AI) {
                    m1651c(r);
                    return;
                }
                fq.m981a(!isReady(), "Results have already been set");
                if (this.AH) {
                    z = false;
                }
                fq.m981a(z, "Result has already been consumed");
                m1650b((Result) r);
            }
        }

        /* renamed from: a */
        protected void m1654a(C0127c<R> c0127c) {
            this.AC = c0127c;
        }

        /* renamed from: a */
        protected final void m1655a(fk fkVar) {
            synchronized (this.AB) {
                this.AK = fkVar;
            }
        }

        public final R await() {
            boolean z = false;
            fq.m981a(!this.AH, "Result has already been consumed");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            fq.m981a(z, "await must not be called on the UI thread");
            try {
                this.AD.await();
            } catch (InterruptedException e) {
                ed();
            }
            fq.m981a(isReady(), "Result is not ready.");
            return eb();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = false;
            fq.m981a(!this.AH, "Result has already been consumed.");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            fq.m981a(z, "await must not be called on the UI thread");
            try {
                if (!this.AD.await(time, units)) {
                    ee();
                }
            } catch (InterruptedException e) {
                ed();
            }
            fq.m981a(isReady(), "Result is not ready.");
            return eb();
        }

        /* renamed from: b */
        public /* synthetic */ void mo1074b(Object obj) {
            m1653a((Result) obj);
        }

        public void cancel() {
            synchronized (this.AB) {
                if (this.AI) {
                    return;
                }
                if (this.AK != null) {
                    try {
                        this.AK.cancel();
                    } catch (RemoteException e) {
                    }
                }
                m1651c(this.AG);
                this.AF = null;
                this.AI = true;
                m1650b(mo2670d(Status.Bz));
            }
        }

        /* renamed from: d */
        protected abstract R mo2670d(Status status);

        protected void ec() {
            this.AH = true;
            this.AG = null;
            this.AF = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.AB) {
                z = this.AI;
            }
            return z;
        }

        public final boolean isReady() {
            return this.AD.getCount() == 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
            /*
            r3 = this;
            r0 = r3.AH;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.fq.m981a(r0, r1);
            r1 = r3.AB;
            monitor-enter(r1);
            r0 = r3.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r3.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r3.AC;	 Catch:{ all -> 0x0028 }
            r2 = r3.eb();	 Catch:{ all -> 0x0028 }
            r0.m130a(r4, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r3.AF = r4;	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, java.util.concurrent.TimeUnit r8) {
            /*
            r4 = this;
            r0 = r4.AH;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.fq.m981a(r0, r1);
            r1 = r4.AB;
            monitor-enter(r1);
            r0 = r4.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r4.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r4.AC;	 Catch:{ all -> 0x0028 }
            r2 = r4.eb();	 Catch:{ all -> 0x0028 }
            r0.m130a(r5, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r4.AF = r5;	 Catch:{ all -> 0x0028 }
            r0 = r4.AC;	 Catch:{ all -> 0x0028 }
            r2 = r8.toMillis(r6);	 Catch:{ all -> 0x0028 }
            r0.m131a(r4, r2);	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
        }
    }

    /* renamed from: com.google.android.gms.common.api.a$b */
    public static abstract class C0901b<R extends Result, A extends C0123a> extends C0544a<R> implements C0132c<A> {
        private C0130a AL;
        private final C0125c<A> Az;

        protected C0901b(C0125c<A> c0125c) {
            this.Az = (C0125c) fq.m986f(c0125c);
        }

        /* renamed from: a */
        private void m2633a(RemoteException remoteException) {
            mo2676k(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        /* renamed from: a */
        protected abstract void mo3258a(A a) throws RemoteException;

        /* renamed from: a */
        public void mo2671a(C0130a c0130a) {
            this.AL = c0130a;
        }

        /* renamed from: b */
        public final void mo2672b(A a) throws DeadObjectException {
            m1654a(new C0127c(a.getLooper()));
            try {
                mo3258a((C0123a) a);
            } catch (RemoteException e) {
                m2633a(e);
                throw e;
            } catch (RemoteException e2) {
                m2633a(e2);
            }
        }

        public final C0125c<A> ea() {
            return this.Az;
        }

        protected void ec() {
            super.ec();
            if (this.AL != null) {
                this.AL.mo1079b(this);
                this.AL = null;
            }
        }

        public int ef() {
            return 0;
        }

        /* renamed from: k */
        public final void mo2676k(Status status) {
            fq.m985b(!status.isSuccess(), (Object) "Failed result must not be success");
            m1653a(mo2670d(status));
        }
    }
}
