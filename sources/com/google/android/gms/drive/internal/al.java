package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.Status;

public class al extends C0905c {
    private final C0128d<Status> wH;

    public al(C0128d<Status> c0128d) {
        this.wH = c0128d;
    }

    /* renamed from: m */
    public void mo1153m(Status status) throws RemoteException {
        this.wH.mo1074b(status);
    }

    public void onSuccess() throws RemoteException {
        this.wH.mo1074b(Status.Bv);
    }
}
