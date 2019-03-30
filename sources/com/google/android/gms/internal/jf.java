package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.C1117b;

public class jf implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String googleTransactionId, final String merchantTransactionId, final int requestCode) {
        googleApiClient.mo1086a(new C1117b(this) {
            final /* synthetic */ jf acV;

            /* renamed from: a */
            protected void m3851a(jg jgVar) {
                jgVar.m3129d(googleTransactionId, merchantTransactionId, requestCode);
                m1653a(Status.Bv);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.mo1086a(new C1117b(this) {
            final /* synthetic */ jf acV;

            /* renamed from: a */
            protected void m3845a(jg jgVar) {
                jgVar.cD(requestCode);
                m1653a(Status.Bv);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.mo1086a(new C1117b(this) {
            final /* synthetic */ jf acV;

            /* renamed from: a */
            protected void m3849a(jg jgVar) {
                jgVar.m3126a(request, requestCode);
                m1653a(Status.Bv);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.mo1086a(new C1117b(this) {
            final /* synthetic */ jf acV;

            /* renamed from: a */
            protected void m3847a(jg jgVar) {
                jgVar.m3127a(request, requestCode);
                m1653a(Status.Bv);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.mo1086a(new C1117b(this) {
            final /* synthetic */ jf acV;

            /* renamed from: a */
            protected void m3853a(jg jgVar) {
                jgVar.m3128a(request);
                m1653a(Status.Bv);
            }
        });
    }
}
