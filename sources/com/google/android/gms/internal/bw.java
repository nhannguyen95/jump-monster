package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.br.C0602a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bw<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0602a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nH;
    private final NETWORK_EXTRAS nI;

    public bw(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.nH = mediationAdapter;
        this.nI = network_extras;
    }

    /* renamed from: b */
    private SERVER_PARAMETERS m2905b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                dw.m818c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.nH.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    /* renamed from: a */
    public void mo1622a(C0190d c0190d, ah ahVar, String str, bs bsVar) throws RemoteException {
        mo1623a(c0190d, ahVar, str, null, bsVar);
    }

    /* renamed from: a */
    public void mo1623a(C0190d c0190d, ah ahVar, String str, String str2, bs bsVar) throws RemoteException {
        if (this.nH instanceof MediationInterstitialAdapter) {
            dw.m820v("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nH).requestInterstitialAd(new bx(bsVar), (Activity) C0926e.m2695d(c0190d), m2905b(str, ahVar.lL, str2), by.m677e(ahVar), this.nI);
            } catch (Throwable th) {
                dw.m818c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo1624a(C0190d c0190d, ak akVar, ah ahVar, String str, bs bsVar) throws RemoteException {
        mo1625a(c0190d, akVar, ahVar, str, null, bsVar);
    }

    /* renamed from: a */
    public void mo1625a(C0190d c0190d, ak akVar, ah ahVar, String str, String str2, bs bsVar) throws RemoteException {
        if (this.nH instanceof MediationBannerAdapter) {
            dw.m820v("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.nH).requestBannerAd(new bx(bsVar), (Activity) C0926e.m2695d(c0190d), m2905b(str, ahVar.lL, str2), by.m676b(akVar), by.m677e(ahVar), this.nI);
            } catch (Throwable th) {
                dw.m818c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationBannerAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.nH.destroy();
        } catch (Throwable th) {
            dw.m818c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0190d getView() throws RemoteException {
        if (this.nH instanceof MediationBannerAdapter) {
            try {
                return C0926e.m2696h(((MediationBannerAdapter) this.nH).getBannerView());
            } catch (Throwable th) {
                dw.m818c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationBannerAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.nH instanceof MediationInterstitialAdapter) {
            dw.m820v("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nH).showInterstitial();
            } catch (Throwable th) {
                dw.m818c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m824z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
