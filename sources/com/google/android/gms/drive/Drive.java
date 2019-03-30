package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0123a;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0556l;
import com.google.android.gms.drive.internal.C0557p;
import com.google.android.gms.drive.internal.C0910n;
import com.google.android.gms.internal.fc;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API = new Api(wy, wx, new Scope[0]);
    public static final DriveApi DriveApi = new C0556l();
    public static final Scope EE = new Scope(Scopes.DRIVE_FULL);
    public static final Scope EF = new Scope(Scopes.DRIVE_APPS);
    public static final C0150c EG = new C0557p();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final C0125c<C0910n> wx = new C0125c();
    public static final C0124b<C0910n, NoOptions> wy = new C05551();

    /* renamed from: com.google.android.gms.drive.Drive$1 */
    static class C05551 implements C0124b<C0910n, NoOptions> {
        C05551() {
        }

        /* renamed from: a */
        public /* synthetic */ C0123a mo1042a(Context context, Looper looper, fc fcVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1695b(context, looper, fcVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: b */
        public C0910n m1695b(Context context, Looper looper, fc fcVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List eE = fcVar.eE();
            return new C0910n(context, looper, fcVar, connectionCallbacks, onConnectionFailedListener, (String[]) eE.toArray(new String[eE.size()]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    private Drive() {
    }
}
