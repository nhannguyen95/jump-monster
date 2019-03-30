package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final ArrayList<Scope> AA;
    private final C0124b<?, O> Ay;
    private final C0125c<?> Az;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* renamed from: com.google.android.gms.common.api.Api$a */
    public interface C0123a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api$b */
    public interface C0124b<T extends C0123a, O> {
        /* renamed from: a */
        T mo1042a(Context context, Looper looper, fc fcVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    /* renamed from: com.google.android.gms.common.api.Api$c */
    public static final class C0125c<C extends C0123a> {
    }

    public <C extends C0123a> Api(C0124b<C, O> clientBuilder, C0125c<C> clientKey, Scope... impliedScopes) {
        this.Ay = clientBuilder;
        this.Az = clientKey;
        this.AA = new ArrayList(Arrays.asList(impliedScopes));
    }

    public C0124b<?, O> dY() {
        return this.Ay;
    }

    public List<Scope> dZ() {
        return this.AA;
    }

    public C0125c<?> ea() {
        return this.Az;
    }
}
