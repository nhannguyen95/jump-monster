package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ek.C0626a;
import com.google.android.gms.internal.ff.C0275b;
import com.google.android.gms.internal.ff.C0644d;
import com.google.android.gms.internal.ff.C0976e;

public final class ei extends ff<ek> {
    private final String wG;

    /* renamed from: com.google.android.gms.internal.ei$h */
    final class C0622h extends C0275b<C0128d<Status>> {
        final /* synthetic */ ei wI;
        private final Status wJ;

        public C0622h(ei eiVar, C0128d<Status> c0128d, Status status) {
            this.wI = eiVar;
            super(eiVar, c0128d);
            this.wJ = status;
        }

        /* renamed from: a */
        public /* synthetic */ void mo1214a(Object obj) {
            m2096c((C0128d) obj);
        }

        /* renamed from: c */
        public void m2096c(C0128d<Status> c0128d) {
            c0128d.mo1074b(this.wJ);
        }

        protected void dx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$b */
    final class C0970b extends C0275b<C0128d<StateDeletedResult>> implements StateDeletedResult {
        final /* synthetic */ ei wI;
        private final Status wJ;
        private final int wK;

        public C0970b(ei eiVar, C0128d<StateDeletedResult> c0128d, Status status, int i) {
            this.wI = eiVar;
            super(eiVar, c0128d);
            this.wJ = status;
            this.wK = i;
        }

        /* renamed from: a */
        public /* synthetic */ void mo1214a(Object obj) {
            m2999c((C0128d) obj);
        }

        /* renamed from: c */
        public void m2999c(C0128d<StateDeletedResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public int getStateKey() {
            return this.wK;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$d */
    final class C0971d extends C0644d<C0128d<StateListResult>> implements StateListResult {
        final /* synthetic */ ei wI;
        private final Status wJ;
        private final AppStateBuffer wL;

        public C0971d(ei eiVar, C0128d<StateListResult> c0128d, Status status, DataHolder dataHolder) {
            this.wI = eiVar;
            super(eiVar, c0128d, dataHolder);
            this.wJ = status;
            this.wL = new AppStateBuffer(dataHolder);
        }

        /* renamed from: a */
        public void m3000a(C0128d<StateListResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public AppStateBuffer getStateBuffer() {
            return this.wL;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$f */
    final class C0972f extends C0644d<C0128d<StateResult>> implements StateConflictResult, StateLoadedResult, StateResult {
        final /* synthetic */ ei wI;
        private final Status wJ;
        private final int wK;
        private final AppStateBuffer wL;

        public C0972f(ei eiVar, C0128d<StateResult> c0128d, int i, DataHolder dataHolder) {
            this.wI = eiVar;
            super(eiVar, c0128d, dataHolder);
            this.wK = i;
            this.wJ = new Status(dataHolder.getStatusCode());
            this.wL = new AppStateBuffer(dataHolder);
        }

        private boolean dy() {
            return this.wJ.getStatusCode() == 2000;
        }

        /* renamed from: a */
        public void m3002a(C0128d<StateResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public StateConflictResult getConflictResult() {
            return dy() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return dy() ? null : this;
        }

        public byte[] getLocalData() {
            return this.wL.getCount() == 0 ? null : this.wL.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.wL.getCount() == 0 ? null : this.wL.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.wL.getCount() == 0 ? null : this.wL.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.wK;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            this.wL.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$a */
    final class C1058a extends eh {
        private final C0128d<StateDeletedResult> wH;
        final /* synthetic */ ei wI;

        public C1058a(ei eiVar, C0128d<StateDeletedResult> c0128d) {
            this.wI = eiVar;
            this.wH = (C0128d) fq.m983b((Object) c0128d, (Object) "Result holder must not be null");
        }

        /* renamed from: b */
        public void mo1692b(int i, int i2) {
            this.wI.m2169a(new C0970b(this.wI, this.wH, new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$c */
    final class C1059c extends eh {
        private final C0128d<StateListResult> wH;
        final /* synthetic */ ei wI;

        public C1059c(ei eiVar, C0128d<StateListResult> c0128d) {
            this.wI = eiVar;
            this.wH = (C0128d) fq.m983b((Object) c0128d, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo1691a(DataHolder dataHolder) {
            this.wI.m2169a(new C0971d(this.wI, this.wH, new Status(dataHolder.getStatusCode()), dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$e */
    final class C1060e extends eh {
        private final C0128d<StateResult> wH;
        final /* synthetic */ ei wI;

        public C1060e(ei eiVar, C0128d<StateResult> c0128d) {
            this.wI = eiVar;
            this.wH = (C0128d) fq.m983b((Object) c0128d, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo1690a(int i, DataHolder dataHolder) {
            this.wI.m2169a(new C0972f(this.wI, this.wH, i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$g */
    final class C1061g extends eh {
        C0128d<Status> wH;
        final /* synthetic */ ei wI;

        public C1061g(ei eiVar, C0128d<Status> c0128d) {
            this.wI = eiVar;
            this.wH = (C0128d) fq.m983b((Object) c0128d, (Object) "Holder must not be null");
        }

        public void du() {
            this.wI.m2169a(new C0622h(this.wI, this.wH, new Status(0)));
        }
    }

    public ei(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.wG = (String) fq.m986f(str);
    }

    /* renamed from: a */
    public void m3004a(C0128d<StateListResult> c0128d) {
        try {
            ((ek) eM()).mo1695a(new C1059c(this, c0128d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void m3005a(C0128d<StateDeletedResult> c0128d, int i) {
        try {
            ((ek) eM()).mo1700b(new C1058a(this, c0128d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void m3006a(C0128d<StateResult> c0128d, int i, String str, byte[] bArr) {
        try {
            ((ek) eM()).mo1697a(new C1060e(this, c0128d), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void m3007a(C0128d<StateResult> c0128d, int i, byte[] bArr) {
        if (c0128d == null) {
            ej ejVar = null;
        } else {
            Object c1060e = new C1060e(this, c0128d);
        }
        try {
            ((ek) eM()).mo1698a(ejVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        fmVar.mo1739a((fl) c0976e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.wG, eL());
    }

    /* renamed from: b */
    public void m3009b(C0128d<Status> c0128d) {
        try {
            ((ek) eM()).mo1699b(new C1061g(this, c0128d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: b */
    public void m3010b(C0128d<StateResult> c0128d, int i) {
        try {
            ((ek) eM()).mo1696a(new C1060e(this, c0128d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: b */
    protected void mo2747b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        fq.m981a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    protected String bg() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public int dv() {
        try {
            return ((ek) eM()).dv();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int dw() {
        try {
            return ((ek) eM()).dw();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    /* renamed from: r */
    protected /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return m3013u(iBinder);
    }

    /* renamed from: u */
    protected ek m3013u(IBinder iBinder) {
        return C0626a.m2109w(iBinder);
    }
}
