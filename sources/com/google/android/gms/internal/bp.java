package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bq.C0600a;
import java.util.Map;

public final class bp extends C0600a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> nB;
    private Map<Class<? extends MediationAdapter>, Bundle> nC;

    /* renamed from: n */
    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> br m2896n(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, bp.class.getClassLoader());
            if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                com.google.ads.mediation.MediationAdapter mediationAdapter = (com.google.ads.mediation.MediationAdapter) cls.newInstance();
                return new bw(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.nB.get(mediationAdapter.getAdditionalParametersType()));
            } else if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new bu((MediationAdapter) cls.newInstance(), (Bundle) this.nC.get(cls));
            } else {
                dw.m824z("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            dw.m824z("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: c */
    public void m2897c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.nB = map;
    }

    /* renamed from: d */
    public void m2898d(Map<Class<? extends MediationAdapter>, Bundle> map) {
        this.nC = map;
    }

    /* renamed from: m */
    public br mo1621m(String str) throws RemoteException {
        return m2896n(str);
    }
}
