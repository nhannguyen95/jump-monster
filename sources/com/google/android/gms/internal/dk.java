package com.google.android.gms.internal;

import android.os.Bundle;

public class dk {
    private final Object li = new Object();
    private final String qL;
    private int qQ = 0;
    private long qR = -1;
    private long qS = -1;
    private int qT = 0;
    private int qU = -1;

    public dk(String str) {
        this.qL = str;
    }

    /* renamed from: b */
    public void m768b(ah ahVar, long j) {
        synchronized (this.li) {
            if (this.qS == -1) {
                this.qS = j;
                this.qR = this.qS;
            } else {
                this.qR = j;
            }
            if (ahVar.extras == null || ahVar.extras.getInt("gw", 2) != 1) {
                this.qU++;
                return;
            }
        }
    }

    public void bk() {
        synchronized (this.li) {
            this.qT++;
        }
    }

    public void bl() {
        synchronized (this.li) {
            this.qQ++;
        }
    }

    public long bw() {
        return this.qS;
    }

    /* renamed from: q */
    public Bundle m769q(String str) {
        Bundle bundle;
        synchronized (this.li) {
            bundle = new Bundle();
            bundle.putString("session_id", this.qL);
            bundle.putLong("basets", this.qS);
            bundle.putLong("currts", this.qR);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.qU);
            bundle.putInt("pclick", this.qQ);
            bundle.putInt("pimp", this.qT);
        }
        return bundle;
    }
}
