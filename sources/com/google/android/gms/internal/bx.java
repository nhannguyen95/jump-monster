package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class bx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final bs nG;

    /* renamed from: com.google.android.gms.internal.bx$1 */
    class C02131 implements Runnable {
        final /* synthetic */ bx nJ;

        C02131(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.mo1631P();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$2 */
    class C02142 implements Runnable {
        final /* synthetic */ bx nJ;

        C02142(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdOpened();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$3 */
    class C02153 implements Runnable {
        final /* synthetic */ bx nJ;

        C02153(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdLoaded();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$4 */
    class C02164 implements Runnable {
        final /* synthetic */ bx nJ;

        C02164(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdClosed();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$6 */
    class C02186 implements Runnable {
        final /* synthetic */ bx nJ;

        C02186(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdLeftApplication();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$7 */
    class C02197 implements Runnable {
        final /* synthetic */ bx nJ;

        C02197(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdOpened();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$8 */
    class C02208 implements Runnable {
        final /* synthetic */ bx nJ;

        C02208(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdLoaded();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx$9 */
    class C02219 implements Runnable {
        final /* synthetic */ bx nJ;

        C02219(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdClosed();
            } catch (Throwable e) {
                dw.m818c("Could not call onAdClosed.", e);
            }
        }
    }

    public bx(bs bsVar) {
        this.nG = bsVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dw.m820v("Adapter called onClick.");
        if (dv.bD()) {
            try {
                this.nG.mo1631P();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdClicked.", e);
                return;
            }
        }
        dw.m824z("onClick must be called on the main UI thread.");
        dv.rp.post(new C02131(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dw.m820v("Adapter called onDismissScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdClosed();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdClosed.", e);
                return;
            }
        }
        dw.m824z("onDismissScreen must be called on the main UI thread.");
        dv.rp.post(new C02164(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dw.m820v("Adapter called onDismissScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdClosed();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdClosed.", e);
                return;
            }
        }
        dw.m824z("onDismissScreen must be called on the main UI thread.");
        dv.rp.post(new C02219(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        dw.m820v("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (dv.bD()) {
            try {
                this.nG.onAdFailedToLoad(by.m675a(errorCode));
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        dw.m824z("onFailedToReceiveAd must be called on the main UI thread.");
        dv.rp.post(new Runnable(this) {
            final /* synthetic */ bx nJ;

            public void run() {
                try {
                    this.nJ.nG.onAdFailedToLoad(by.m675a(errorCode));
                } catch (Throwable e) {
                    dw.m818c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        dw.m820v("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (dv.bD()) {
            try {
                this.nG.onAdFailedToLoad(by.m675a(errorCode));
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        dw.m824z("onFailedToReceiveAd must be called on the main UI thread.");
        dv.rp.post(new Runnable(this) {
            final /* synthetic */ bx nJ;

            public void run() {
                try {
                    this.nJ.nG.onAdFailedToLoad(by.m675a(errorCode));
                } catch (Throwable e) {
                    dw.m818c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dw.m820v("Adapter called onLeaveApplication.");
        if (dv.bD()) {
            try {
                this.nG.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        dw.m824z("onLeaveApplication must be called on the main UI thread.");
        dv.rp.post(new C02186(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dw.m820v("Adapter called onLeaveApplication.");
        if (dv.bD()) {
            try {
                this.nG.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        dw.m824z("onLeaveApplication must be called on the main UI thread.");
        dv.rp.post(new Runnable(this) {
            final /* synthetic */ bx nJ;

            {
                this.nJ = r1;
            }

            public void run() {
                try {
                    this.nJ.nG.onAdLeftApplication();
                } catch (Throwable e) {
                    dw.m818c("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dw.m820v("Adapter called onPresentScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdOpened();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdOpened.", e);
                return;
            }
        }
        dw.m824z("onPresentScreen must be called on the main UI thread.");
        dv.rp.post(new C02197(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dw.m820v("Adapter called onPresentScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdOpened();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdOpened.", e);
                return;
            }
        }
        dw.m824z("onPresentScreen must be called on the main UI thread.");
        dv.rp.post(new C02142(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dw.m820v("Adapter called onReceivedAd.");
        if (dv.bD()) {
            try {
                this.nG.onAdLoaded();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLoaded.", e);
                return;
            }
        }
        dw.m824z("onReceivedAd must be called on the main UI thread.");
        dv.rp.post(new C02208(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dw.m820v("Adapter called onReceivedAd.");
        if (dv.bD()) {
            try {
                this.nG.onAdLoaded();
                return;
            } catch (Throwable e) {
                dw.m818c("Could not call onAdLoaded.", e);
                return;
            }
        }
        dw.m824z("onReceivedAd must be called on the main UI thread.");
        dv.rp.post(new C02153(this));
    }
}
