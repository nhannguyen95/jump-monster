package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
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
import com.google.android.gms.internal.gw;

public final class Address {
    public static final Api<AddressOptions> API = new Api(wy, wx, new Scope[0]);
    static final C0125c<gw> wx = new C0125c();
    private static final C0124b<gw, AddressOptions> wy = new C05771();

    /* renamed from: com.google.android.gms.identity.intents.Address$1 */
    static class C05771 implements C0124b<gw, AddressOptions> {
        C05771() {
        }

        /* renamed from: a */
        public gw m1987a(Context context, Looper looper, fc fcVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            fq.m985b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new gw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, fcVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address$a */
    private static abstract class C1057a extends C0901b<Status, gw> {
        public C1057a() {
            super(Address.wx);
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3400f(status);
        }

        /* renamed from: f */
        public Status m3400f(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.mo1086a(new C1057a() {
            /* renamed from: a */
            protected void m3557a(gw gwVar) throws RemoteException {
                gwVar.m3061a(request, requestCode);
                m1653a(Status.Bv);
            }
        });
    }
}
