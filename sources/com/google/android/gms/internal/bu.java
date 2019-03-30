package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C0078a;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.br.C0602a;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class bu extends C0602a {
    private final MediationAdapter nE;
    private final Bundle nF;

    public bu(MediationAdapter mediationAdapter, Bundle bundle) {
        this.nE = mediationAdapter;
        this.nF = bundle;
    }

    /* renamed from: a */
    private Bundle m2900a(String str, int i, String str2) throws RemoteException {
        dw.m824z("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.nE instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            dw.m818c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo1622a(C0190d c0190d, ah ahVar, String str, bs bsVar) throws RemoteException {
        mo1623a(c0190d, ahVar, str, null, bsVar);
    }

    /* renamed from: a */
    public void mo1623a(C0190d c0190d, ah ahVar, String str, String str2, bs bsVar) throws RemoteException {
        if (this.nE instanceof MediationInterstitialAdapter) {
            dw.m820v("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.nE;
                mediationInterstitialAdapter.requestInterstitialAd((Context) C0926e.m2695d(c0190d), new bv(bsVar), m2900a(str, ahVar.lL, str2), new bt(new Date(ahVar.lH), ahVar.lI, ahVar.lJ != null ? new HashSet(ahVar.lJ) : null, ahVar.lK, ahVar.lL), this.nF);
            } catch (Throwable th) {
                dw.m818c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo1624a(C0190d c0190d, ak akVar, ah ahVar, String str, bs bsVar) throws RemoteException {
        mo1625a(c0190d, akVar, ahVar, str, null, bsVar);
    }

    /* renamed from: a */
    public void mo1625a(C0190d c0190d, ak akVar, ah ahVar, String str, String str2, bs bsVar) throws RemoteException {
        if (this.nE instanceof MediationBannerAdapter) {
            dw.m820v("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.nE;
                mediationBannerAdapter.requestBannerAd((Context) C0926e.m2695d(c0190d), new bv(bsVar), m2900a(str, ahVar.lL, str2), C0078a.m6a(akVar.width, akVar.height, akVar.lS), new bt(new Date(ahVar.lH), ahVar.lI, ahVar.lJ != null ? new HashSet(ahVar.lJ) : null, ahVar.lK, ahVar.lL), this.nF);
            } catch (Throwable th) {
                dw.m818c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationBannerAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.nE.onDestroy();
        } catch (Throwable th) {
            dw.m818c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0190d getView() throws RemoteException {
        if (this.nE instanceof MediationBannerAdapter) {
            try {
                return C0926e.m2696h(((MediationBannerAdapter) this.nE).getBannerView());
            } catch (Throwable th) {
                dw.m818c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationBannerAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.nE.onPause();
        } catch (Throwable th) {
            dw.m818c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.nE.onResume();
        } catch (Throwable th) {
            dw.m818c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.nE instanceof MediationInterstitialAdapter) {
            dw.m820v("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nE).showInterstitial();
            } catch (Throwable th) {
                dw.m818c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
