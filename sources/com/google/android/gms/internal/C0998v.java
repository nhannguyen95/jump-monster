package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.ap.C0586a;
import com.google.android.gms.internal.cr.C0230a;
import com.google.android.gms.internal.cx.C0238a;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.google.android.gms.internal.v */
public class C0998v extends C0586a implements az, bc, bk, cf, ci, C0230a, dl, C0303u {
    private final C0309x kA;
    private final aa kB;
    private boolean kC;
    private final ComponentCallbacks kD = new C03041(this);
    private final bq ky;
    private final C0306b kz;

    /* renamed from: com.google.android.gms.internal.v$1 */
    class C03041 implements ComponentCallbacks {
        final /* synthetic */ C0998v kE;

        C03041(C0998v c0998v) {
            this.kE = c0998v;
        }

        public void onConfigurationChanged(Configuration newConfig) {
            if (this.kE.kz != null && this.kE.kz.kO != null && this.kE.kz.kO.oj != null) {
                this.kE.kz.kO.oj.bE();
            }
        }

        public void onLowMemory() {
        }
    }

    /* renamed from: com.google.android.gms.internal.v$a */
    private static final class C0305a extends ViewSwitcher {
        private final dr kF;

        public C0305a(Context context) {
            super(context);
            this.kF = new dr(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.kF.m800c(event);
            return false;
        }
    }

    /* renamed from: com.google.android.gms.internal.v$b */
    private static final class C0306b {
        public final C0305a kG;
        public final String kH;
        public final Context kI;
        public final C0294l kJ;
        public final dx kK;
        public ao kL;
        public C0243do kM;
        public ak kN;
        public dh kO;
        public di kP;
        public ar kQ;
        public co kR;
        public dm kS = null;
        private HashSet<di> kT = null;

        public C0306b(Context context, ak akVar, String str, dx dxVar) {
            if (akVar.lT) {
                this.kG = null;
            } else {
                this.kG = new C0305a(context);
                this.kG.setMinimumWidth(akVar.widthPixels);
                this.kG.setMinimumHeight(akVar.heightPixels);
                this.kG.setVisibility(4);
            }
            this.kN = akVar;
            this.kH = str;
            this.kI = context;
            this.kJ = new C0294l(C1072k.m3418a(dxVar.rq, context));
            this.kK = dxVar;
        }

        /* renamed from: a */
        public void m1213a(HashSet<di> hashSet) {
            this.kT = hashSet;
        }

        public HashSet<di> ak() {
            return this.kT;
        }
    }

    public C0998v(Context context, ak akVar, String str, bq bqVar, dx dxVar) {
        this.kz = new C0306b(context, akVar, str, dxVar);
        this.ky = bqVar;
        this.kA = new C0309x(this);
        this.kB = new aa();
        dw.m822x("Use AdRequest.Builder.addTestDevice(\"" + dv.m814l(context) + "\") to get test ads on this device.");
        dq.m791i(context);
        m3131S();
    }

    /* renamed from: S */
    private void m3131S() {
        if (VERSION.SDK_INT >= 14 && this.kz != null && this.kz.kI != null) {
            this.kz.kI.registerComponentCallbacks(this.kD);
        }
    }

    /* renamed from: T */
    private void m3132T() {
        if (VERSION.SDK_INT >= 14 && this.kz != null && this.kz.kI != null) {
            this.kz.kI.unregisterComponentCallbacks(this.kD);
        }
    }

    /* renamed from: a */
    private void m3134a(int i) {
        dw.m824z("Failed to load ad: " + i);
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdFailedToLoad(i);
            } catch (Throwable e) {
                dw.m818c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void ad() {
        dw.m822x("Ad closing.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdClosed();
            } catch (Throwable e) {
                dw.m818c("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void ae() {
        dw.m822x("Ad leaving application.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdLeftApplication();
            } catch (Throwable e) {
                dw.m818c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void af() {
        dw.m822x("Ad opening.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdOpened();
            } catch (Throwable e) {
                dw.m818c("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void ag() {
        dw.m822x("Ad finished loading.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdLoaded();
            } catch (Throwable e) {
                dw.m818c("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private boolean ah() {
        boolean z = true;
        if (!dq.m785a(this.kz.kI.getPackageManager(), this.kz.kI.getPackageName(), "android.permission.INTERNET")) {
            if (!this.kz.kN.lT) {
                dv.m813a(this.kz.kG, this.kz.kN, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!dq.m790h(this.kz.kI)) {
            if (!this.kz.kN.lT) {
                dv.m813a(this.kz.kG, this.kz.kN, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.kz.kN.lT)) {
            this.kz.kG.setVisibility(0);
        }
        return z;
    }

    private void ai() {
        if (this.kz.kO == null) {
            dw.m824z("Ad state was null when trying to ping click URLs.");
            return;
        }
        dw.m820v("Pinging click URLs.");
        this.kz.kP.bl();
        if (this.kz.kO.ne != null) {
            dq.m780a(this.kz.kI, this.kz.kK.rq, this.kz.kO.ne);
        }
        if (this.kz.kO.qt != null && this.kz.kO.qt.ne != null) {
            bo.m668a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, false, this.kz.kO.qt.ne);
        }
    }

    private void aj() {
        if (this.kz.kO != null) {
            this.kz.kO.oj.destroy();
            this.kz.kO = null;
        }
    }

    /* renamed from: b */
    private void m3135b(View view) {
        this.kz.kG.addView(view, new LayoutParams(-2, -2));
    }

    /* renamed from: b */
    private void m3136b(boolean z) {
        if (this.kz.kO == null) {
            dw.m824z("Ad state was null when trying to ping impression URLs.");
            return;
        }
        dw.m820v("Pinging Impression URLs.");
        this.kz.kP.bk();
        if (this.kz.kO.nf != null) {
            dq.m780a(this.kz.kI, this.kz.kK.rq, this.kz.kO.nf);
        }
        if (!(this.kz.kO.qt == null || this.kz.kO.qt.nf == null)) {
            bo.m668a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, z, this.kz.kO.qt.nf);
        }
        if (this.kz.kO.nx != null && this.kz.kO.nx.na != null) {
            bo.m668a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, z, this.kz.kO.nx.na);
        }
    }

    /* renamed from: b */
    private boolean m3137b(dh dhVar) {
        View view;
        if (dhVar.po) {
            try {
                view = (View) C0926e.m2695d(dhVar.ny.getView());
                View nextView = this.kz.kG.getNextView();
                if (nextView != null) {
                    this.kz.kG.removeView(nextView);
                }
                try {
                    m3135b(view);
                } catch (Throwable th) {
                    dw.m818c("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                dw.m818c("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (dhVar.qu != null) {
            dhVar.oj.m831a(dhVar.qu);
            this.kz.kG.removeAllViews();
            this.kz.kG.setMinimumWidth(dhVar.qu.widthPixels);
            this.kz.kG.setMinimumHeight(dhVar.qu.heightPixels);
            m3135b(dhVar.oj);
        }
        if (this.kz.kG.getChildCount() > 1) {
            this.kz.kG.showNext();
        }
        if (this.kz.kO != null) {
            view = this.kz.kG.getNextView();
            if (view instanceof dz) {
                ((dz) view).m830a(this.kz.kI, this.kz.kN);
            } else if (view != null) {
                this.kz.kG.removeView(view);
            }
            if (this.kz.kO.ny != null) {
                try {
                    this.kz.kO.ny.destroy();
                } catch (RemoteException e) {
                    dw.m824z("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.kz.kG.setVisibility(0);
        return true;
    }

    /* renamed from: c */
    private C0238a m3138c(ah ahVar) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.kz.kI.getApplicationInfo();
        try {
            packageInfo = this.kz.kI.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.kz.kN.lT || this.kz.kG.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.kz.kG.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.kz.kI.getResources().getDisplayMetrics();
            int width = this.kz.kG.getWidth();
            int height = this.kz.kG.getHeight();
            int i3 = (!this.kz.kG.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            bundle.putInt("visible", i3);
        }
        String bs = dj.bs();
        this.kz.kP = new di(bs, this.kz.kH);
        this.kz.kP.m757f(ahVar);
        return new C0238a(bundle, ahVar, this.kz.kN, this.kz.kH, applicationInfo, packageInfo, bs, dj.qK, this.kz.kK, dj.m762a((dl) this, bs));
    }

    /* renamed from: P */
    public void mo3154P() {
        ai();
    }

    /* renamed from: Q */
    public C0190d mo1602Q() {
        fq.aj("getAdFrame must be called on the main UI thread.");
        return C0926e.m2696h(this.kz.kG);
    }

    /* renamed from: R */
    public ak mo1603R() {
        fq.aj("getAdSize must be called on the main UI thread.");
        return this.kz.kN;
    }

    /* renamed from: U */
    public void mo3155U() {
        ae();
    }

    /* renamed from: V */
    public void mo3156V() {
        this.kB.m1991d(this.kz.kO);
        if (this.kz.kN.lT) {
            aj();
        }
        this.kC = false;
        ad();
        this.kz.kP.bm();
    }

    /* renamed from: W */
    public void mo3157W() {
        if (this.kz.kN.lT) {
            m3136b(false);
        }
        this.kC = true;
        af();
    }

    /* renamed from: X */
    public void mo3158X() {
        mo3154P();
    }

    /* renamed from: Y */
    public void mo3159Y() {
        mo3156V();
    }

    /* renamed from: Z */
    public void mo3160Z() {
        mo3155U();
    }

    /* renamed from: a */
    public void mo1604a(ak akVar) {
        fq.aj("setAdSize must be called on the main UI thread.");
        this.kz.kN = akVar;
        if (this.kz.kO != null) {
            this.kz.kO.oj.m831a(akVar);
        }
        if (this.kz.kG.getChildCount() > 1) {
            this.kz.kG.removeView(this.kz.kG.getNextView());
        }
        this.kz.kG.setMinimumWidth(akVar.widthPixels);
        this.kz.kG.setMinimumHeight(akVar.heightPixels);
        this.kz.kG.requestLayout();
    }

    /* renamed from: a */
    public void mo1605a(ao aoVar) {
        fq.aj("setAdListener must be called on the main UI thread.");
        this.kz.kL = aoVar;
    }

    /* renamed from: a */
    public void mo1606a(ar arVar) {
        fq.aj("setAppEventListener must be called on the main UI thread.");
        this.kz.kQ = arVar;
    }

    /* renamed from: a */
    public void mo1607a(co coVar) {
        fq.aj("setInAppPurchaseListener must be called on the main UI thread.");
        this.kz.kR = coVar;
    }

    /* renamed from: a */
    public void mo3161a(dh dhVar) {
        int i = 0;
        this.kz.kM = null;
        if (!(dhVar.errorCode == -2 || dhVar.errorCode == 3)) {
            dj.m763b(this.kz.ak());
        }
        if (dhVar.errorCode != -1) {
            boolean z = dhVar.pg.extras != null ? dhVar.pg.extras.getBoolean("_noRefresh", false) : false;
            if (this.kz.kN.lT) {
                dq.m782a(dhVar.oj);
            } else if (!z) {
                if (dhVar.ni > 0) {
                    this.kA.m1216a(dhVar.pg, dhVar.ni);
                } else if (dhVar.qt != null && dhVar.qt.ni > 0) {
                    this.kA.m1216a(dhVar.pg, dhVar.qt.ni);
                } else if (!dhVar.po && dhVar.errorCode == 2) {
                    this.kA.m1217d(dhVar.pg);
                }
            }
            if (!(dhVar.errorCode != 3 || dhVar.qt == null || dhVar.qt.ng == null)) {
                dw.m820v("Pinging no fill URLs.");
                bo.m668a(this.kz.kI, this.kz.kK.rq, dhVar, this.kz.kH, false, dhVar.qt.ng);
            }
            if (dhVar.errorCode != -2) {
                m3134a(dhVar.errorCode);
                return;
            }
            int i2;
            if (!this.kz.kN.lT) {
                if (!m3137b(dhVar)) {
                    m3134a(0);
                    return;
                } else if (this.kz.kG != null) {
                    this.kz.kG.kF.m801t(dhVar.pt);
                }
            }
            if (!(this.kz.kO == null || this.kz.kO.nA == null)) {
                this.kz.kO.nA.m2894a(null);
            }
            if (dhVar.nA != null) {
                dhVar.nA.m2894a((bk) this);
            }
            this.kB.m1991d(this.kz.kO);
            this.kz.kO = dhVar;
            if (dhVar.qu != null) {
                this.kz.kN = dhVar.qu;
            }
            this.kz.kP.m758h(dhVar.qv);
            this.kz.kP.m759i(dhVar.qw);
            this.kz.kP.m760m(this.kz.kN.lT);
            this.kz.kP.m761n(dhVar.po);
            if (!this.kz.kN.lT) {
                m3136b(false);
            }
            if (this.kz.kS == null) {
                this.kz.kS = new dm(this.kz.kH);
            }
            if (dhVar.qt != null) {
                i2 = dhVar.qt.nj;
                i = dhVar.qt.nk;
            } else {
                i2 = 0;
            }
            this.kz.kS.m771a(i2, i);
            if (!(this.kz.kN.lT || dhVar.oj == null || (!dhVar.oj.bI().bP() && dhVar.qs == null))) {
                ab a = this.kB.m1988a(this.kz.kN, this.kz.kO);
                if (dhVar.oj.bI().bP() && a != null) {
                    a.m597a(new C0694w(dhVar.oj));
                }
            }
            this.kz.kO.oj.bE();
            ag();
        }
    }

    /* renamed from: a */
    public void mo3162a(String str, ArrayList<String> arrayList) {
        if (this.kz.kR == null) {
            dw.m824z("InAppPurchaseListener is not set");
            return;
        }
        try {
            this.kz.kR.mo1677a(new cm(str, arrayList, this.kz.kI, this.kz.kK.rq));
        } catch (RemoteException e) {
            dw.m824z("Could not start In-App purchase.");
        }
    }

    /* renamed from: a */
    public void mo3163a(HashSet<di> hashSet) {
        this.kz.m1213a(hashSet);
    }

    /* renamed from: a */
    public boolean mo1608a(ah ahVar) {
        fq.aj("loadAd must be called on the main UI thread.");
        if (this.kz.kM != null) {
            dw.m824z("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.kz.kN.lT && this.kz.kO != null) {
            dw.m824z("An interstitial is already loading. Aborting.");
            return false;
        } else if (!ah()) {
            return false;
        } else {
            dz dzVar;
            dw.m822x("Starting ad request.");
            this.kA.cancel();
            C0238a c = m3138c(ahVar);
            if (this.kz.kN.lT) {
                dz a = dz.m828a(this.kz.kI, this.kz.kN, false, false, this.kz.kJ, this.kz.kK);
                a.bI().m843a(this, null, this, this, true, this);
                dzVar = a;
            } else {
                dz dzVar2;
                View nextView = this.kz.kG.getNextView();
                if (nextView instanceof dz) {
                    dzVar2 = (dz) nextView;
                    dzVar2.m830a(this.kz.kI, this.kz.kN);
                } else {
                    if (nextView != null) {
                        this.kz.kG.removeView(nextView);
                    }
                    nextView = dz.m828a(this.kz.kI, this.kz.kN, false, false, this.kz.kJ, this.kz.kK);
                    if (this.kz.kN.lU == null) {
                        m3135b(nextView);
                    }
                }
                dzVar2.bI().m843a(this, this, this, this, false, this);
                dzVar = dzVar2;
            }
            this.kz.kM = cr.m702a(this.kz.kI, c, this.kz.kJ, dzVar, this.ky, this);
            return true;
        }
    }

    public void aa() {
        mo3157W();
    }

    public void ab() {
        if (this.kz.kO != null) {
            dw.m824z("Mediation adapter " + this.kz.kO.nz + " refreshed, but mediation adapters should never refresh.");
        }
        m3136b(true);
        ag();
    }

    public void ac() {
        fq.aj("recordManualImpression must be called on the main UI thread.");
        if (this.kz.kO == null) {
            dw.m824z("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        dw.m820v("Pinging manual tracking URLs.");
        if (this.kz.kO.pq != null) {
            dq.m780a(this.kz.kI, this.kz.kK.rq, this.kz.kO.pq);
        }
    }

    /* renamed from: b */
    public void m3156b(ah ahVar) {
        ViewParent parent = this.kz.kG.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && dq.by() && !this.kC) {
            mo1608a(ahVar);
            return;
        }
        dw.m822x("Ad is not visible. Not refreshing ad.");
        this.kA.m1217d(ahVar);
    }

    public void destroy() {
        fq.aj("destroy must be called on the main UI thread.");
        m3132T();
        this.kz.kL = null;
        this.kz.kQ = null;
        this.kA.cancel();
        stopLoading();
        if (this.kz.kG != null) {
            this.kz.kG.removeAllViews();
        }
        if (!(this.kz.kO == null || this.kz.kO.oj == null)) {
            this.kz.kO.oj.destroy();
        }
        if (this.kz.kO != null && this.kz.kO.ny != null) {
            try {
                this.kz.kO.ny.destroy();
            } catch (RemoteException e) {
                dw.m824z("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean isReady() {
        fq.aj("isLoaded must be called on the main UI thread.");
        return this.kz.kM == null && this.kz.kO != null;
    }

    public void onAppEvent(String name, String info) {
        if (this.kz.kQ != null) {
            try {
                this.kz.kQ.onAppEvent(name, info);
            } catch (Throwable e) {
                dw.m818c("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        fq.aj("pause must be called on the main UI thread.");
        if (this.kz.kO != null) {
            dq.m782a(this.kz.kO.oj);
        }
        if (!(this.kz.kO == null || this.kz.kO.ny == null)) {
            try {
                this.kz.kO.ny.pause();
            } catch (RemoteException e) {
                dw.m824z("Could not pause mediation adapter.");
            }
        }
        this.kA.pause();
    }

    public void resume() {
        fq.aj("resume must be called on the main UI thread.");
        if (this.kz.kO != null) {
            dq.m789b(this.kz.kO.oj);
        }
        if (!(this.kz.kO == null || this.kz.kO.ny == null)) {
            try {
                this.kz.kO.ny.resume();
            } catch (RemoteException e) {
                dw.m824z("Could not resume mediation adapter.");
            }
        }
        this.kA.resume();
    }

    public void showInterstitial() {
        fq.aj("showInterstitial must be called on the main UI thread.");
        if (!this.kz.kN.lT) {
            dw.m824z("Cannot call showInterstitial on a banner ad.");
        } else if (this.kz.kO == null) {
            dw.m824z("The interstitial has not loaded.");
        } else if (this.kz.kO.oj.bL()) {
            dw.m824z("The interstitial is already showing.");
        } else {
            this.kz.kO.oj.m836p(true);
            if (this.kz.kO.oj.bI().bP() || this.kz.kO.qs != null) {
                ab a = this.kB.m1988a(this.kz.kN, this.kz.kO);
                if (this.kz.kO.oj.bI().bP() && a != null) {
                    a.m597a(new C0694w(this.kz.kO.oj));
                }
            }
            if (this.kz.kO.po) {
                try {
                    this.kz.kO.ny.showInterstitial();
                    return;
                } catch (Throwable e) {
                    dw.m818c("Could not show interstitial.", e);
                    aj();
                    return;
                }
            }
            cc.m2968a(this.kz.kI, new ce((C0303u) this, (cf) this, (ci) this, this.kz.kO.oj, this.kz.kO.orientation, this.kz.kK, this.kz.kO.pt));
        }
    }

    public void stopLoading() {
        fq.aj("stopLoading must be called on the main UI thread.");
        if (this.kz.kO != null) {
            this.kz.kO.oj.stopLoading();
            this.kz.kO = null;
        }
        if (this.kz.kM != null) {
            this.kz.kM.cancel();
        }
    }
}
