package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.dw;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    /* renamed from: n */
    private View f186n;
    /* renamed from: o */
    private CustomEventBanner f187o;
    /* renamed from: p */
    private CustomEventInterstitial f188p;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C0890a implements CustomEventBannerListener {
        /* renamed from: q */
        private final CustomEventAdapter f181q;
        /* renamed from: r */
        private final MediationBannerListener f182r;

        public C0890a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f181q = customEventAdapter;
            this.f182r = mediationBannerListener;
        }

        public void onClick() {
            dw.m820v("Custom event adapter called onFailedToReceiveAd.");
            this.f182r.onClick(this.f181q);
        }

        public void onDismissScreen() {
            dw.m820v("Custom event adapter called onFailedToReceiveAd.");
            this.f182r.onDismissScreen(this.f181q);
        }

        public void onFailedToReceiveAd() {
            dw.m820v("Custom event adapter called onFailedToReceiveAd.");
            this.f182r.onFailedToReceiveAd(this.f181q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            dw.m820v("Custom event adapter called onFailedToReceiveAd.");
            this.f182r.onLeaveApplication(this.f181q);
        }

        public void onPresentScreen() {
            dw.m820v("Custom event adapter called onFailedToReceiveAd.");
            this.f182r.onPresentScreen(this.f181q);
        }

        public void onReceivedAd(View view) {
            dw.m820v("Custom event adapter called onReceivedAd.");
            this.f181q.m2617a(view);
            this.f182r.onReceivedAd(this.f181q);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0891b implements CustomEventInterstitialListener {
        /* renamed from: q */
        private final CustomEventAdapter f183q;
        /* renamed from: s */
        private final MediationInterstitialListener f184s;
        /* renamed from: t */
        final /* synthetic */ CustomEventAdapter f185t;

        public C0891b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f185t = customEventAdapter;
            this.f183q = customEventAdapter2;
            this.f184s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            dw.m820v("Custom event adapter called onDismissScreen.");
            this.f184s.onDismissScreen(this.f183q);
        }

        public void onFailedToReceiveAd() {
            dw.m820v("Custom event adapter called onFailedToReceiveAd.");
            this.f184s.onFailedToReceiveAd(this.f183q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            dw.m820v("Custom event adapter called onLeaveApplication.");
            this.f184s.onLeaveApplication(this.f183q);
        }

        public void onPresentScreen() {
            dw.m820v("Custom event adapter called onPresentScreen.");
            this.f184s.onPresentScreen(this.f183q);
        }

        public void onReceivedAd() {
            dw.m820v("Custom event adapter called onReceivedAd.");
            this.f184s.onReceivedAd(this.f185t);
        }
    }

    /* renamed from: a */
    private static <T> T m2616a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            dw.m824z("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private void m2617a(View view) {
        this.f186n = view;
    }

    public void destroy() {
        if (this.f187o != null) {
            this.f187o.destroy();
        }
        if (this.f188p != null) {
            this.f188p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f186n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f187o = (CustomEventBanner) m2616a(serverParameters.className);
        if (this.f187o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f187o.requestBannerAd(new C0890a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f188p = (CustomEventInterstitial) m2616a(serverParameters.className);
        if (this.f188p == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f188p.requestInterstitialAd(new C0891b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f188p.showInterstitial();
    }
}
