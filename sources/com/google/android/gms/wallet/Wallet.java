package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.C0129a.C0901b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.ka;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api(wy, wx, new Scope[0]);
    public static final Payments Payments = new jf();
    public static final ka aco = new jj();
    public static final iu acp = new ji();
    private static final C0125c<jg> wx = new C0125c();
    private static final C0124b<jg, WalletOptions> wy = new C08501();

    /* renamed from: com.google.android.gms.wallet.Wallet$1 */
    static class C08501 implements C0124b<jg, WalletOptions> {
        C08501() {
        }

        /* renamed from: a */
        public jg m2566a(Context context, Looper looper, fc fcVar, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            fq.m985b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new jg(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, fcVar.getAccountName(), walletOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int acq = 0;
            private int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.acq = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.acq;
            this.theme = builder.mTheme;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$a */
    public static abstract class C1079a<R extends Result> extends C0901b<R, jg> {
        public C1079a() {
            super(Wallet.wx);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$b */
    public static abstract class C1117b extends C1079a<Status> {
        /* renamed from: d */
        protected /* synthetic */ Result mo2670d(Status status) {
            return m3571f(status);
        }

        /* renamed from: f */
        protected Status m3571f(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
