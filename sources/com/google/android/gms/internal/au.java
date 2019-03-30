package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class au {
    private AdListener lF;
    private AppEventListener lV;
    private String lX;
    private final Context mContext;
    private final bp ml;
    private final aj mm;
    private ap mn;
    private InAppPurchaseListener mp;

    public au(Context context) {
        this(context, aj.az());
    }

    public au(Context context, aj ajVar) {
        this.ml = new bp();
        this.mContext = context;
        this.mm = ajVar;
    }

    /* renamed from: k */
    private void m652k(String str) throws RemoteException {
        if (this.lX == null) {
            m653l(str);
        }
        this.mn = ag.m2001a(this.mContext, new ak(), this.lX, this.ml);
        if (this.lF != null) {
            this.mn.mo1605a(new af(this.lF));
        }
        if (this.lV != null) {
            this.mn.mo1606a(new am(this.lV));
        }
        if (this.mp != null) {
            this.mn.mo1607a(new cp(this.mp));
        }
    }

    /* renamed from: l */
    private void m653l(String str) {
        if (this.mn == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    /* renamed from: a */
    public void m654a(as asVar) {
        try {
            if (this.mn == null) {
                m652k("loadAd");
            }
            if (this.mn.mo1608a(this.mm.m614a(this.mContext, asVar))) {
                this.ml.m2897c(asVar.aC());
                this.ml.m2898d(asVar.aD());
            }
        } catch (Throwable e) {
            dw.m818c("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lF;
    }

    public String getAdUnitId() {
        return this.lX;
    }

    public AppEventListener getAppEventListener() {
        return this.lV;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.mp;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.mn != null) {
                z = this.mn.isReady();
            }
        } catch (Throwable e) {
            dw.m818c("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.lF = adListener;
            if (this.mn != null) {
                this.mn.mo1605a(adListener != null ? new af(adListener) : null);
            }
        } catch (Throwable e) {
            dw.m818c("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.lX != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.lX = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.lV = appEventListener;
            if (this.mn != null) {
                this.mn.mo1606a(appEventListener != null ? new am(appEventListener) : null);
            }
        } catch (Throwable e) {
            dw.m818c("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        try {
            this.mp = inAppPurchaseListener;
            if (this.mn != null) {
                this.mn.mo1607a(inAppPurchaseListener != null ? new cp(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            dw.m818c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void show() {
        try {
            m653l("show");
            this.mn.showInterstitial();
        } catch (Throwable e) {
            dw.m818c("Failed to show interstitial.", e);
        }
    }
}
