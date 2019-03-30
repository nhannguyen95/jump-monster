package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C0848y implements aq {
    private static C0848y XM;
    private static final Object sf = new Object();
    private String XN;
    private String XO;
    private ar XP;
    private cf Xa;

    private C0848y(Context context) {
        this(as.m2444H(context), new cv());
    }

    C0848y(ar arVar, cf cfVar) {
        this.XP = arVar;
        this.Xa = cfVar;
    }

    /* renamed from: F */
    public static aq m2562F(Context context) {
        aq aqVar;
        synchronized (sf) {
            if (XM == null) {
                XM = new C0848y(context);
            }
            aqVar = XM;
        }
        return aqVar;
    }

    public boolean bz(String str) {
        if (this.Xa.cS()) {
            if (!(this.XN == null || this.XO == null)) {
                try {
                    str = this.XN + "?" + this.XO + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.m1387y("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.m1383c("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.XP.bC(str);
            return true;
        }
        bh.m1388z("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
