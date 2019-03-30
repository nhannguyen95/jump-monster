package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0926e;

public final class at {
    private AdListener lF;
    private AppEventListener lV;
    private AdSize[] lW;
    private String lX;
    private final bp ml;
    private final aj mm;
    private ap mn;
    private ViewGroup mo;
    private InAppPurchaseListener mp;

    public at(ViewGroup viewGroup) {
        this(viewGroup, null, false, aj.az());
    }

    public at(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, aj.az());
    }

    at(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, aj ajVar) {
        this.ml = new bp();
        this.mo = viewGroup;
        this.mm = ajVar;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                an anVar = new an(context, attributeSet);
                this.lW = anVar.m619e(z);
                this.lX = anVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    dv.m811a(viewGroup, new ak(context, this.lW[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                dv.m813a(viewGroup, new ak(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private void aF() {
        try {
            C0190d Q = this.mn.mo1602Q();
            if (Q != null) {
                this.mo.addView((View) C0926e.m2695d(Q));
            }
        } catch (Throwable e) {
            dw.m818c("Failed to get an ad frame.", e);
        }
    }

    private void aG() throws RemoteException {
        if ((this.lW == null || this.lX == null) && this.mn == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.mo.getContext();
        this.mn = ag.m2001a(context, new ak(context, this.lW), this.lX, this.ml);
        if (this.lF != null) {
            this.mn.mo1605a(new af(this.lF));
        }
        if (this.lV != null) {
            this.mn.mo1606a(new am(this.lV));
        }
        if (this.mp != null) {
            this.mn.mo1607a(new cp(this.mp));
        }
        aF();
    }

    /* renamed from: a */
    public void m650a(as asVar) {
        try {
            if (this.mn == null) {
                aG();
            }
            if (this.mn.mo1608a(this.mm.m614a(this.mo.getContext(), asVar))) {
                this.ml.m2897c(asVar.aC());
                this.ml.m2898d(asVar.aD());
            }
        } catch (Throwable e) {
            dw.m818c("Failed to load ad.", e);
        }
    }

    /* renamed from: a */
    public void m651a(AdSize... adSizeArr) {
        this.lW = adSizeArr;
        try {
            if (this.mn != null) {
                this.mn.mo1604a(new ak(this.mo.getContext(), this.lW));
            }
        } catch (Throwable e) {
            dw.m818c("Failed to set the ad size.", e);
        }
        this.mo.requestLayout();
    }

    public void destroy() {
        try {
            if (this.mn != null) {
                this.mn.destroy();
            }
        } catch (Throwable e) {
            dw.m818c("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lF;
    }

    public AdSize getAdSize() {
        try {
            if (this.mn != null) {
                return this.mn.mo1603R().aA();
            }
        } catch (Throwable e) {
            dw.m818c("Failed to get the current AdSize.", e);
        }
        return this.lW != null ? this.lW[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.lW;
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

    public void pause() {
        try {
            if (this.mn != null) {
                this.mn.pause();
            }
        } catch (Throwable e) {
            dw.m818c("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        try {
            this.mn.ac();
        } catch (Throwable e) {
            dw.m818c("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.mn != null) {
                this.mn.resume();
            }
        } catch (Throwable e) {
            dw.m818c("Failed to call resume.", e);
        }
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

    public void setAdSizes(AdSize... adSizes) {
        if (this.lW != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m651a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.lX != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
}
