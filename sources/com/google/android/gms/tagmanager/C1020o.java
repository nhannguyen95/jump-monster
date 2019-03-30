package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0129a.C0544a;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0223c.C0962f;
import com.google.android.gms.internal.C0223c.C0966j;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.it.C0995a;
import com.google.android.gms.tagmanager.C1019n.C0410a;
import com.google.android.gms.tagmanager.bg.C0383a;
import com.google.android.gms.tagmanager.cd.C0385a;
import com.google.android.gms.tagmanager.cq.C0393c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C1020o extends C0544a<ContainerHolder> {
    private final Looper AS;
    private final String WJ;
    private long WO;
    private final TagManager WW;
    private final C0840d WZ;
    private final gl Wv;
    private final cf Xa;
    private final int Xb;
    private C0842f Xc;
    private volatile C1019n Xd;
    private volatile boolean Xe;
    private C0966j Xf;
    private String Xg;
    private C0841e Xh;
    private C0412a Xi;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.o$a */
    interface C0412a {
        /* renamed from: b */
        boolean mo2294b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$1 */
    class C08361 implements C0410a {
        final /* synthetic */ C1020o Xj;

        C08361(C1020o c1020o) {
            this.Xj = c1020o;
        }

        public void br(String str) {
            this.Xj.br(str);
        }

        public String ke() {
            return this.Xj.ke();
        }

        public void kg() {
            bh.m1388z("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$b */
    private class C0838b implements bg<C0995a> {
        final /* synthetic */ C1020o Xj;

        private C0838b(C1020o c1020o) {
            this.Xj = c1020o;
        }

        /* renamed from: a */
        public void m2527a(C0995a c0995a) {
            C0966j c0966j;
            if (c0995a.aaZ != null) {
                c0966j = c0995a.aaZ;
            } else {
                C0962f c0962f = c0995a.fK;
                c0966j = new C0966j();
                c0966j.fK = c0962f;
                c0966j.fJ = null;
                c0966j.fL = c0962f.fg;
            }
            this.Xj.m3217a(c0966j, c0995a.aaY, true);
        }

        /* renamed from: a */
        public void mo2295a(C0383a c0383a) {
            if (!this.Xj.Xe) {
                this.Xj.m3227t(0);
            }
        }

        /* renamed from: i */
        public /* synthetic */ void mo2296i(Object obj) {
            m2527a((C0995a) obj);
        }

        public void kl() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$c */
    private class C0839c implements bg<C0966j> {
        final /* synthetic */ C1020o Xj;

        private C0839c(C1020o c1020o) {
            this.Xj = c1020o;
        }

        /* renamed from: a */
        public void mo2295a(C0383a c0383a) {
            if (this.Xj.Xd != null) {
                this.Xj.m1653a(this.Xj.Xd);
            } else {
                this.Xj.m1653a(this.Xj.ac(Status.By));
            }
            this.Xj.m3227t(3600000);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public void m2531b(com.google.android.gms.internal.C0223c.C0966j r6) {
            /*
            r5 = this;
            r1 = r5.Xj;
            monitor-enter(r1);
            r0 = r6.fK;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r0 = r0.Xf;	 Catch:{ all -> 0x0065 }
            r0 = r0.fK;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.bh.m1385w(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.m3227t(r2);	 Catch:{ all -> 0x0065 }
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r0 = r0.Xf;	 Catch:{ all -> 0x0065 }
            r0 = r0.fK;	 Catch:{ all -> 0x0065 }
            r6.fK = r0;	 Catch:{ all -> 0x0065 }
        L_0x002a:
            r0 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r2 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r2 = r2.Wv;	 Catch:{ all -> 0x0065 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0065 }
            r4 = 0;
            r0.m3217a(r6, r2, r4);	 Catch:{ all -> 0x0065 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r0.<init>();	 Catch:{ all -> 0x0065 }
            r2 = "setting refresh time to current time: ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r2 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r2 = r2.WO;	 Catch:{ all -> 0x0065 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r0 = r0.toString();	 Catch:{ all -> 0x0065 }
            com.google.android.gms.tagmanager.bh.m1387y(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r0 = r0.kk();	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0063;
        L_0x005e:
            r0 = r5.Xj;	 Catch:{ all -> 0x0065 }
            r0.m3216a(r6);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x001f;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.c.b(com.google.android.gms.internal.c$j):void");
        }

        /* renamed from: i */
        public /* synthetic */ void mo2296i(Object obj) {
            m2531b((C0966j) obj);
        }

        public void kl() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$d */
    private class C0840d implements C0410a {
        final /* synthetic */ C1020o Xj;

        private C0840d(C1020o c1020o) {
            this.Xj = c1020o;
        }

        public void br(String str) {
            this.Xj.br(str);
        }

        public String ke() {
            return this.Xj.ke();
        }

        public void kg() {
            if (this.Xj.Xa.cS()) {
                this.Xj.m3227t(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$e */
    interface C0841e extends Releasable {
        /* renamed from: a */
        void mo3168a(bg<C0966j> bgVar);

        void bu(String str);

        /* renamed from: d */
        void mo3170d(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$f */
    interface C0842f extends Releasable {
        /* renamed from: a */
        void mo3171a(bg<C0995a> bgVar);

        /* renamed from: b */
        void mo3172b(C0995a c0995a);

        C0393c ca(int i);

        void km();
    }

    C1020o(Context context, TagManager tagManager, Looper looper, String str, int i, C0842f c0842f, C0841e c0841e, gl glVar, cf cfVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.WW = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.AS = looper;
        this.WJ = str;
        this.Xb = i;
        this.Xc = c0842f;
        this.Xh = c0841e;
        this.WZ = new C0840d();
        this.Xf = new C0966j();
        this.Wv = glVar;
        this.Xa = cfVar;
        if (kk()) {
            br(cd.kT().kV());
        }
    }

    public C1020o(Context context, TagManager tagManager, Looper looper, String str, int i, C0413r c0413r) {
        this(context, tagManager, looper, str, i, new cp(context, str), new co(context, str, c0413r), gn.ft(), new bf(30, 900000, 5000, "refreshing", gn.ft()));
    }

    /* renamed from: C */
    private void m3214C(final boolean z) {
        this.Xc.mo3171a(new C0838b());
        this.Xh.mo3168a(new C0839c());
        C0393c ca = this.Xc.ca(this.Xb);
        if (ca != null) {
            this.Xd = new C1019n(this.WW, this.AS, new Container(this.mContext, this.WW.getDataLayer(), this.WJ, 0, ca), this.WZ);
        }
        this.Xi = new C0412a(this) {
            final /* synthetic */ C1020o Xj;

            /* renamed from: b */
            public boolean mo2294b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= this.Xj.Wv.currentTimeMillis() : !container.isDefault();
            }
        };
        if (kk()) {
            this.Xh.mo3170d(0, "");
        } else {
            this.Xc.km();
        }
    }

    /* renamed from: a */
    private synchronized void m3216a(C0966j c0966j) {
        if (this.Xc != null) {
            C0995a c0995a = new C0995a();
            c0995a.aaY = this.WO;
            c0995a.fK = new C0962f();
            c0995a.aaZ = c0966j;
            this.Xc.mo3172b(c0995a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized void m3217a(com.google.android.gms.internal.C0223c.C0966j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.Xe;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.Xd;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.Xf = r9;	 Catch:{ all -> 0x006a }
        r8.WO = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.WO;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.Wv;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m3227t(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.WW;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.WJ;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.Xd;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.WW;	 Catch:{ all -> 0x006a }
        r3 = r8.AS;	 Catch:{ all -> 0x006a }
        r4 = r8.WZ;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.Xd = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.Xi;	 Catch:{ all -> 0x006a }
        r0 = r1.mo2294b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.Xd;	 Catch:{ all -> 0x006a }
        r8.m1653a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.Xd;	 Catch:{ all -> 0x006a }
        r1.m3213a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean kk() {
        cd kT = cd.kT();
        return (kT.kU() == C0385a.CONTAINER || kT.kU() == C0385a.CONTAINER_DEBUG) && this.WJ.equals(kT.getContainerId());
    }

    /* renamed from: t */
    private synchronized void m3227t(long j) {
        if (this.Xh == null) {
            bh.m1388z("Refresh requested, but no network load scheduler.");
        } else {
            this.Xh.mo3170d(j, this.Xf.fL);
        }
    }

    protected ContainerHolder ac(Status status) {
        if (this.Xd != null) {
            return this.Xd;
        }
        if (status == Status.By) {
            bh.m1385w("timer expired: setting result to failure");
        }
        return new C1019n(status);
    }

    synchronized void br(String str) {
        this.Xg = str;
        if (this.Xh != null) {
            this.Xh.bu(str);
        }
    }

    /* renamed from: d */
    protected /* synthetic */ Result mo2670d(Status status) {
        return ac(status);
    }

    synchronized String ke() {
        return this.Xg;
    }

    public void kh() {
        C0393c ca = this.Xc.ca(this.Xb);
        if (ca != null) {
            m1653a(new C1019n(this.WW, this.AS, new Container(this.mContext, this.WW.getDataLayer(), this.WJ, 0, ca), new C08361(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m1385w(str);
            m1653a(ac(new Status(10, str, null)));
        }
        this.Xh = null;
        this.Xc = null;
    }

    public void ki() {
        m3214C(false);
    }

    public void kj() {
        m3214C(true);
    }
}
