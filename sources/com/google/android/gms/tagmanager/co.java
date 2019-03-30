package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0223c.C0966j;
import com.google.android.gms.tagmanager.C1020o.C0841e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class co implements C0841e {
    private final String WJ;
    private String Xg;
    private bg<C0966j> Zf;
    private C0413r Zg;
    private final ScheduledExecutorService Zi;
    private final C0386a Zj;
    private ScheduledFuture<?> Zk;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.co$a */
    interface C0386a {
        /* renamed from: a */
        cn mo2282a(C0413r c0413r);
    }

    /* renamed from: com.google.android.gms.tagmanager.co$b */
    interface C0387b {
        ScheduledExecutorService la();
    }

    /* renamed from: com.google.android.gms.tagmanager.co$1 */
    class C08201 implements C0387b {
        final /* synthetic */ co Zl;

        C08201(co coVar) {
            this.Zl = coVar;
        }

        public ScheduledExecutorService la() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.co$2 */
    class C08212 implements C0386a {
        final /* synthetic */ co Zl;

        C08212(co coVar) {
            this.Zl = coVar;
        }

        /* renamed from: a */
        public cn mo2282a(C0413r c0413r) {
            return new cn(this.Zl.mContext, this.Zl.WJ, c0413r);
        }
    }

    public co(Context context, String str, C0413r c0413r) {
        this(context, str, c0413r, null, null);
    }

    co(Context context, String str, C0413r c0413r, C0387b c0387b, C0386a c0386a) {
        this.Zg = c0413r;
        this.mContext = context;
        this.WJ = str;
        if (c0387b == null) {
            c0387b = new C08201(this);
        }
        this.Zi = c0387b.la();
        if (c0386a == null) {
            this.Zj = new C08212(this);
        } else {
            this.Zj = c0386a;
        }
    }

    private cn bK(String str) {
        cn a = this.Zj.mo2282a(this.Zg);
        a.m1406a(this.Zf);
        a.bu(this.Xg);
        a.bJ(str);
        return a;
    }

    private synchronized void kZ() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo3168a(bg<C0966j> bgVar) {
        kZ();
        this.Zf = bgVar;
    }

    public synchronized void bu(String str) {
        kZ();
        this.Xg = str;
    }

    /* renamed from: d */
    public synchronized void mo3170d(long j, String str) {
        bh.m1387y("loadAfterDelay: containerId=" + this.WJ + " delay=" + j);
        kZ();
        if (this.Zf == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.Zk != null) {
            this.Zk.cancel(false);
        }
        this.Zk = this.Zi.schedule(bK(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        kZ();
        if (this.Zk != null) {
            this.Zk.cancel(false);
        }
        this.Zi.shutdown();
        this.mClosed = true;
    }
}
