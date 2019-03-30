package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.db.C0615a;
import com.google.android.gms.internal.ff.C0976e;

public class cw extends ff<db> {
    final int pe;

    public cw(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.pe = i;
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        fmVar.mo1753g(c0976e, this.pe, getContext().getPackageName(), new Bundle());
    }

    protected String bg() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public db bi() {
        return (db) super.eM();
    }

    /* renamed from: q */
    protected db m2980q(IBinder iBinder) {
        return C0615a.m2086s(iBinder);
    }

    /* renamed from: r */
    protected /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return m2980q(iBinder);
    }
}
