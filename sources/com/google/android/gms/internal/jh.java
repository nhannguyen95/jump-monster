package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0189c;
import com.google.android.gms.dynamic.C0193g;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.jc.C0683a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class jh extends C0193g<jc> {
    private static jh adc;

    protected jh() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    /* renamed from: a */
    public static iz m2315a(Activity activity, C0189c c0189c, WalletFragmentOptions walletFragmentOptions, ja jaVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((jc) lY().m360z(activity)).mo1853a(C0926e.m2696h(activity), c0189c, walletFragmentOptions, jaVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static jh lY() {
        if (adc == null) {
            adc = new jh();
        }
        return adc;
    }

    protected jc aZ(IBinder iBinder) {
        return C0683a.aV(iBinder);
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1596d(IBinder iBinder) {
        return aZ(iBinder);
    }
}
