package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class di {
    private final Object li;
    private boolean pV;
    private final String qA;
    private long qB;
    private long qC;
    private long qD;
    private long qE;
    private long qF;
    private long qG;
    private final dj qx;
    private final LinkedList<C0241a> qy;
    private final String qz;

    /* renamed from: com.google.android.gms.internal.di$a */
    private static final class C0241a {
        private long qH = -1;
        private long qI = -1;

        public long bn() {
            return this.qI;
        }

        public void bo() {
            this.qI = SystemClock.elapsedRealtime();
        }

        public void bp() {
            this.qH = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.qH);
            bundle.putLong("tclose", this.qI);
            return bundle;
        }
    }

    public di(dj djVar, String str, String str2) {
        this.li = new Object();
        this.qB = -1;
        this.qC = -1;
        this.pV = false;
        this.qD = -1;
        this.qE = 0;
        this.qF = -1;
        this.qG = -1;
        this.qx = djVar;
        this.qz = str;
        this.qA = str2;
        this.qy = new LinkedList();
    }

    public di(String str, String str2) {
        this(dj.bq(), str, str2);
    }

    public void bk() {
        synchronized (this.li) {
            if (this.qG != -1 && this.qC == -1) {
                this.qC = SystemClock.elapsedRealtime();
                this.qx.m764a(this);
            }
            dj djVar = this.qx;
            dj.bu().bk();
        }
    }

    public void bl() {
        synchronized (this.li) {
            if (this.qG != -1) {
                C0241a c0241a = new C0241a();
                c0241a.bp();
                this.qy.add(c0241a);
                this.qE++;
                dj djVar = this.qx;
                dj.bu().bl();
                this.qx.m764a(this);
            }
        }
    }

    public void bm() {
        synchronized (this.li) {
            if (!(this.qG == -1 || this.qy.isEmpty())) {
                C0241a c0241a = (C0241a) this.qy.getLast();
                if (c0241a.bn() == -1) {
                    c0241a.bo();
                    this.qx.m764a(this);
                }
            }
        }
    }

    /* renamed from: f */
    public void m757f(ah ahVar) {
        synchronized (this.li) {
            this.qF = SystemClock.elapsedRealtime();
            dj djVar = this.qx;
            dj.bu().m768b(ahVar, this.qF);
        }
    }

    /* renamed from: h */
    public void m758h(long j) {
        synchronized (this.li) {
            this.qG = j;
            if (this.qG != -1) {
                this.qx.m764a(this);
            }
        }
    }

    /* renamed from: i */
    public void m759i(long j) {
        synchronized (this.li) {
            if (this.qG != -1) {
                this.qB = j;
                this.qx.m764a(this);
            }
        }
    }

    /* renamed from: m */
    public void m760m(boolean z) {
        synchronized (this.li) {
            if (this.qG != -1) {
                this.qD = SystemClock.elapsedRealtime();
                if (!z) {
                    this.qC = this.qD;
                    this.qx.m764a(this);
                }
            }
        }
    }

    /* renamed from: n */
    public void m761n(boolean z) {
        synchronized (this.li) {
            if (this.qG != -1) {
                this.pV = z;
                this.qx.m764a(this);
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.li) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.qz);
            bundle.putString("slotid", this.qA);
            bundle.putBoolean("ismediation", this.pV);
            bundle.putLong("treq", this.qF);
            bundle.putLong("tresponse", this.qG);
            bundle.putLong("timp", this.qC);
            bundle.putLong("tload", this.qD);
            bundle.putLong("pcc", this.qE);
            bundle.putLong("tfetch", this.qB);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.qy.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0241a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
