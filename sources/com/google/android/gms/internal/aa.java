package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.WeakHashMap;

public final class aa implements ac {
    private final Object li = new Object();
    private WeakHashMap<dh, ab> lj = new WeakHashMap();
    private ArrayList<ab> lk = new ArrayList();

    /* renamed from: a */
    public ab m1988a(ak akVar, dh dhVar) {
        ab abVar;
        synchronized (this.li) {
            if (m1990c(dhVar)) {
                abVar = (ab) this.lj.get(dhVar);
            } else {
                abVar = new ab(akVar, dhVar);
                abVar.m594a((ac) this);
                this.lj.put(dhVar, abVar);
                this.lk.add(abVar);
            }
        }
        return abVar;
    }

    /* renamed from: a */
    public void mo1587a(ab abVar) {
        synchronized (this.li) {
            if (!abVar.at()) {
                this.lk.remove(abVar);
            }
        }
    }

    /* renamed from: c */
    public boolean m1990c(dh dhVar) {
        boolean z;
        synchronized (this.li) {
            ab abVar = (ab) this.lj.get(dhVar);
            z = abVar != null && abVar.at();
        }
        return z;
    }

    /* renamed from: d */
    public void m1991d(dh dhVar) {
        synchronized (this.li) {
            ab abVar = (ab) this.lj.get(dhVar);
            if (abVar != null) {
                abVar.ar();
            }
        }
    }
}
