package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.dv;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    /* renamed from: i */
    private AdView f179i;
    /* renamed from: j */
    private InterstitialAd f180j;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private static final class C0517a extends AdListener {
        /* renamed from: k */
        private final AdMobAdapter f170k;
        /* renamed from: l */
        private final MediationBannerListener f171l;

        public C0517a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f170k = adMobAdapter;
            this.f171l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f171l.onAdClosed(this.f170k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f171l.onAdFailedToLoad(this.f170k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f171l.onAdLeftApplication(this.f170k);
        }

        public void onAdLoaded() {
            this.f171l.onAdLoaded(this.f170k);
        }

        public void onAdOpened() {
            this.f171l.onAdClicked(this.f170k);
            this.f171l.onAdOpened(this.f170k);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private static final class C0518b extends AdListener {
        /* renamed from: k */
        private final AdMobAdapter f172k;
        /* renamed from: m */
        private final MediationInterstitialListener f173m;

        public C0518b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f172k = adMobAdapter;
            this.f173m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f173m.onAdClosed(this.f172k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f173m.onAdFailedToLoad(this.f172k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f173m.onAdLeftApplication(this.f172k);
        }

        public void onAdLoaded() {
            this.f173m.onAdLoaded(this.f172k);
        }

        public void onAdOpened() {
            this.f173m.onAdOpened(this.f172k);
        }
    }

    /* renamed from: a */
    private static AdRequest m2615a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(dv.m814l(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f179i;
    }

    public void onDestroy() {
        if (this.f179i != null) {
            this.f179i.destroy();
            this.f179i = null;
        }
        if (this.f180j != null) {
            this.f180j = null;
        }
    }

    public void onPause() {
        if (this.f179i != null) {
            this.f179i.pause();
        }
    }

    public void onResume() {
        if (this.f179i != null) {
            this.f179i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f179i = new AdView(context);
        this.f179i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f179i.setAdUnitId(serverParameters.getString("pubid"));
        this.f179i.setAdListener(new C0517a(this, bannerListener));
        this.f179i.loadAd(m2615a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f180j = new InterstitialAd(context);
        this.f180j.setAdUnitId(serverParameters.getString("pubid"));
        this.f180j.setAdListener(new C0518b(this, interstitialListener));
        this.f180j.loadAd(m2615a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f180j.show();
    }
}
