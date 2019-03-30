package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C0123a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.fg.C0278b;
import com.google.android.gms.internal.fl.C0649a;
import com.google.android.gms.internal.fm.C0651a;
import java.util.ArrayList;

public abstract class ff<T extends IInterface> implements GooglePlayServicesClient, C0123a, C0278b {
    public static final String[] Dg = new String[]{"service_esmobile", "service_googleme"};
    private final Looper AS;
    private final fg Bc;
    private T Da;
    private final ArrayList<C0275b<?>> Db;
    private C0276f Dc;
    private volatile int Dd;
    private final String[] De;
    boolean Df;
    private final Context mContext;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.ff$a */
    final class C0274a extends Handler {
        final /* synthetic */ ff Dh;

        public C0274a(ff ffVar, Looper looper) {
            this.Dh = ffVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            C0275b c0275b;
            if (msg.what == 1 && !this.Dh.isConnecting()) {
                c0275b = (C0275b) msg.obj;
                c0275b.dx();
                c0275b.unregister();
            } else if (msg.what == 3) {
                this.Dh.Bc.m927a(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.Dh.m2158M(1);
                this.Dh.Da = null;
                this.Dh.Bc.m926O(((Integer) msg.obj).intValue());
            } else if (msg.what == 2 && !this.Dh.isConnected()) {
                c0275b = (C0275b) msg.obj;
                c0275b.dx();
                c0275b.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C0275b) msg.obj).eN();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$b */
    protected abstract class C0275b<TListener> {
        final /* synthetic */ ff Dh;
        private boolean Di = false;
        private TListener mListener;

        public C0275b(ff ffVar, TListener tListener) {
            this.Dh = ffVar;
            this.mListener = tListener;
        }

        /* renamed from: a */
        protected abstract void mo1214a(TListener tListener);

        protected abstract void dx();

        public void eN() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.Di) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    mo1214a(obj);
                } catch (RuntimeException e) {
                    dx();
                    throw e;
                }
            }
            dx();
            synchronized (this) {
                this.Di = true;
            }
            unregister();
        }

        public void eO() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            eO();
            synchronized (this.Dh.Db) {
                this.Dh.Db.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$f */
    final class C0276f implements ServiceConnection {
        final /* synthetic */ ff Dh;

        C0276f(ff ffVar) {
            this.Dh = ffVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.Dh.m2173z(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.Dh.mHandler.sendMessage(this.Dh.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$c */
    public static final class C0643c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks Dj;

        public C0643c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.Dj = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C0643c ? this.Dj.equals(((C0643c) other).Dj) : this.Dj.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.Dj.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.Dj.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$d */
    public abstract class C0644d<TListener> extends C0275b<TListener> {
        private final DataHolder BB;
        final /* synthetic */ ff Dh;

        public C0644d(ff ffVar, TListener tListener, DataHolder dataHolder) {
            this.Dh = ffVar;
            super(ffVar, tListener);
            this.BB = dataHolder;
        }

        /* renamed from: a */
        protected final void mo1214a(TListener tListener) {
            mo2741a(tListener, this.BB);
        }

        /* renamed from: a */
        protected abstract void mo2741a(TListener tListener, DataHolder dataHolder);

        protected void dx() {
            if (this.BB != null) {
                this.BB.close();
            }
        }

        public /* bridge */ /* synthetic */ void eN() {
            super.eN();
        }

        public /* bridge */ /* synthetic */ void eO() {
            super.eO();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$h */
    protected final class C0645h extends C0275b<Boolean> {
        final /* synthetic */ ff Dh;
        public final Bundle Dm;
        public final IBinder Dn;
        public final int statusCode;

        public C0645h(ff ffVar, int i, IBinder iBinder, Bundle bundle) {
            this.Dh = ffVar;
            super(ffVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.Dn = iBinder;
            this.Dm = bundle;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2157b((Boolean) obj);
        }

        /* renamed from: b */
        protected void m2157b(Boolean bool) {
            if (bool == null) {
                this.Dh.m2158M(1);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    try {
                        if (this.Dh.bh().equals(this.Dn.getInterfaceDescriptor())) {
                            this.Dh.Da = this.Dh.mo2687r(this.Dn);
                            if (this.Dh.Da != null) {
                                this.Dh.m2158M(3);
                                this.Dh.Bc.bV();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    fh.m938x(this.Dh.mContext).m940b(this.Dh.bg(), this.Dh.Dc);
                    this.Dh.Dc = null;
                    this.Dh.m2158M(1);
                    this.Dh.Da = null;
                    this.Dh.Bc.m927a(new ConnectionResult(8, null));
                    return;
                case 10:
                    this.Dh.m2158M(1);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.Dm != null ? (PendingIntent) this.Dm.getParcelable("pendingIntent") : null;
                    if (this.Dh.Dc != null) {
                        fh.m938x(this.Dh.mContext).m940b(this.Dh.bg(), this.Dh.Dc);
                        this.Dh.Dc = null;
                    }
                    this.Dh.m2158M(1);
                    this.Dh.Da = null;
                    this.Dh.Bc.m927a(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected void dx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$e */
    public static final class C0976e extends C0649a {
        private ff Dk;

        public C0976e(ff ffVar) {
            this.Dk = ffVar;
        }

        /* renamed from: b */
        public void mo1734b(int i, IBinder iBinder, Bundle bundle) {
            fq.m983b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.Dk);
            this.Dk.mo2683a(i, iBinder, bundle);
            this.Dk = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$g */
    public static final class C0977g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener Dl;

        public C0977g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.Dl = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C0977g ? this.Dl.equals(((C0977g) other).Dl) : this.Dl.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Dl.onConnectionFailed(result);
        }
    }

    protected ff(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.Db = new ArrayList();
        this.Dd = 1;
        this.Df = false;
        this.mContext = (Context) fq.m986f(context);
        this.AS = (Looper) fq.m983b((Object) looper, (Object) "Looper must not be null");
        this.Bc = new fg(context, looper, this);
        this.mHandler = new C0274a(this, looper);
        mo2747b(strArr);
        this.De = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) fq.m986f(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) fq.m986f(onConnectionFailedListener));
    }

    protected ff(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C0643c(connectionCallbacks), new C0977g(onConnectionFailedListener), strArr);
    }

    /* renamed from: M */
    private void m2158M(int i) {
        int i2 = this.Dd;
        this.Dd = i;
        if (i2 == i) {
            return;
        }
        if (i == 3) {
            onConnected();
        } else if (i2 == 3 && i == 1) {
            onDisconnected();
        }
    }

    /* renamed from: N */
    public void m2167N(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    /* renamed from: a */
    protected void mo2683a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0645h(this, i, iBinder, bundle)));
    }

    /* renamed from: a */
    public final void m2169a(C0275b<?> c0275b) {
        synchronized (this.Db) {
            this.Db.add(c0275b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c0275b));
    }

    /* renamed from: a */
    protected abstract void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException;

    /* renamed from: b */
    protected void mo2747b(String... strArr) {
    }

    protected final void bT() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract String bg();

    protected abstract String bh();

    public void connect() {
        this.Df = true;
        m2158M(2);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            m2158M(1);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.Dc != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.Da = null;
            fh.m938x(this.mContext).m940b(bg(), this.Dc);
        }
        this.Dc = new C0276f(this);
        if (!fh.m938x(this.mContext).m939a(bg(), this.Dc)) {
            Log.e("GmsClient", "unable to connect to service: " + bg());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public Bundle dG() {
        return null;
    }

    public void disconnect() {
        this.Df = false;
        synchronized (this.Db) {
            int size = this.Db.size();
            for (int i = 0; i < size; i++) {
                ((C0275b) this.Db.get(i)).eO();
            }
            this.Db.clear();
        }
        m2158M(1);
        this.Da = null;
        if (this.Dc != null) {
            fh.m938x(this.mContext).m940b(bg(), this.Dc);
            this.Dc = null;
        }
    }

    public final String[] eL() {
        return this.De;
    }

    protected final T eM() {
        bT();
        return this.Da;
    }

    public boolean em() {
        return this.Df;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.AS;
    }

    public boolean isConnected() {
        return this.Dd == 3;
    }

    public boolean isConnecting() {
        return this.Dd == 2;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.Bc.isConnectionCallbacksRegistered(new C0643c(listener));
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.Bc.isConnectionFailedListenerRegistered(listener);
    }

    protected void onConnected() {
    }

    protected void onDisconnected() {
    }

    /* renamed from: r */
    protected abstract T mo2687r(IBinder iBinder);

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.Bc.registerConnectionCallbacks(new C0643c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.Bc.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.Bc.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.Bc.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.Bc.unregisterConnectionCallbacks(new C0643c(listener));
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.Bc.unregisterConnectionFailedListener(listener);
    }

    /* renamed from: z */
    protected final void m2173z(IBinder iBinder) {
        try {
            mo2684a(C0651a.m2205C(iBinder), new C0976e(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }
}
