package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.C0123a;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.C0129a.C0901b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fg;
import com.google.android.gms.internal.fg.C0278b;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.b */
final class C0548b implements GoogleApiClient {
    private final C0130a AL = new C05451(this);
    private final Looper AS;
    private final Lock Ba = new ReentrantLock();
    private final Condition Bb = this.Ba.newCondition();
    private final fg Bc;
    final Queue<C0132c<?>> Bd = new LinkedList();
    private ConnectionResult Be;
    private int Bf;
    private int Bg = 4;
    private int Bh = 0;
    private boolean Bi = false;
    private int Bj;
    private long Bk = 5000;
    final Handler Bl;
    private final Bundle Bm = new Bundle();
    private final Map<C0125c<?>, C0123a> Bn = new HashMap();
    private boolean Bo;
    final Set<C0132c<?>> Bp = new HashSet();
    final ConnectionCallbacks Bq = new C05462(this);
    private final C0278b Br = new C05473(this);

    /* renamed from: com.google.android.gms.common.api.b$a */
    interface C0130a {
        /* renamed from: b */
        void mo1079b(C0132c<?> c0132c);
    }

    /* renamed from: com.google.android.gms.common.api.b$b */
    class C0131b extends Handler {
        final /* synthetic */ C0548b Bs;

        C0131b(C0548b c0548b, Looper looper) {
            this.Bs = c0548b;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                this.Bs.Ba.lock();
                try {
                    if (!(this.Bs.isConnected() || this.Bs.isConnecting())) {
                        this.Bs.connect();
                    }
                    this.Bs.Ba.unlock();
                } catch (Throwable th) {
                    this.Bs.Ba.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b$c */
    interface C0132c<A extends C0123a> {
        /* renamed from: a */
        void mo2671a(C0130a c0130a);

        /* renamed from: b */
        void mo2672b(A a) throws DeadObjectException;

        void cancel();

        C0125c<A> ea();

        int ef();

        /* renamed from: k */
        void mo2676k(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.b$1 */
    class C05451 implements C0130a {
        final /* synthetic */ C0548b Bs;

        C05451(C0548b c0548b) {
            this.Bs = c0548b;
        }

        /* renamed from: b */
        public void mo1079b(C0132c<?> c0132c) {
            this.Bs.Ba.lock();
            try {
                this.Bs.Bp.remove(c0132c);
            } finally {
                this.Bs.Ba.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b$2 */
    class C05462 implements ConnectionCallbacks {
        final /* synthetic */ C0548b Bs;

        C05462(C0548b c0548b) {
            this.Bs = c0548b;
        }

        public void onConnected(Bundle connectionHint) {
            this.Bs.Ba.lock();
            try {
                if (this.Bs.Bg == 1) {
                    if (connectionHint != null) {
                        this.Bs.Bm.putAll(connectionHint);
                    }
                    this.Bs.ei();
                }
                this.Bs.Ba.unlock();
            } catch (Throwable th) {
                this.Bs.Ba.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.Bs.Ba.lock();
            try {
                this.Bs.m1659E(cause);
                switch (cause) {
                    case 1:
                        if (!this.Bs.ek()) {
                            this.Bs.Bh = 2;
                            this.Bs.Bl.sendMessageDelayed(this.Bs.Bl.obtainMessage(1), this.Bs.Bk);
                            break;
                        }
                        this.Bs.Ba.unlock();
                        return;
                    case 2:
                        this.Bs.connect();
                        break;
                }
                this.Bs.Ba.unlock();
            } catch (Throwable th) {
                this.Bs.Ba.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b$3 */
    class C05473 implements C0278b {
        final /* synthetic */ C0548b Bs;

        C05473(C0548b c0548b) {
            this.Bs = c0548b;
        }

        public Bundle dG() {
            return null;
        }

        public boolean em() {
            return this.Bs.Bo;
        }

        public boolean isConnected() {
            return this.Bs.isConnected();
        }
    }

    public C0548b(Context context, Looper looper, fc fcVar, Map<Api<?>, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.Bc = new fg(context, looper, this.Br);
        this.AS = looper;
        this.Bl = new C0131b(this, looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.Bc.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.Bc.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            final C0124b dY = api.dY();
            Object obj = map.get(api);
            this.Bn.put(api.ea(), C0548b.m1661a(dY, obj, context, looper, fcVar, this.Bq, new OnConnectionFailedListener(this) {
                final /* synthetic */ C0548b Bs;

                public void onConnectionFailed(ConnectionResult result) {
                    this.Bs.Ba.lock();
                    try {
                        if (this.Bs.Be == null || dY.getPriority() < this.Bs.Bf) {
                            this.Bs.Be = result;
                            this.Bs.Bf = dY.getPriority();
                        }
                        this.Bs.ei();
                    } finally {
                        this.Bs.Ba.unlock();
                    }
                }
            }));
        }
    }

    /* renamed from: E */
    private void m1659E(int i) {
        this.Ba.lock();
        try {
            if (this.Bg != 3) {
                if (i == -1) {
                    Iterator it;
                    C0132c c0132c;
                    if (isConnecting()) {
                        it = this.Bd.iterator();
                        while (it.hasNext()) {
                            c0132c = (C0132c) it.next();
                            if (c0132c.ef() != 1) {
                                c0132c.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.Bd.clear();
                    }
                    for (C0132c c0132c2 : this.Bp) {
                        c0132c2.cancel();
                    }
                    this.Bp.clear();
                    if (this.Be == null && !this.Bd.isEmpty()) {
                        this.Bi = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.Bg = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.Be = null;
                    }
                    this.Bb.signalAll();
                }
                this.Bo = false;
                for (C0123a c0123a : this.Bn.values()) {
                    if (c0123a.isConnected()) {
                        c0123a.disconnect();
                    }
                }
                this.Bo = true;
                this.Bg = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.Bc.m926O(i);
                    }
                    this.Bo = false;
                }
            }
            this.Ba.unlock();
        } finally {
            this.Ba.unlock();
        }
    }

    /* renamed from: a */
    private static <C extends C0123a, O> C m1661a(C0124b<C, O> c0124b, Object obj, Context context, Looper looper, fc fcVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return c0124b.mo1042a(context, looper, fcVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: a */
    private <A extends C0123a> void m1663a(C0132c<A> c0132c) throws DeadObjectException {
        boolean z = true;
        this.Ba.lock();
        try {
            boolean z2 = isConnected() || ek();
            fq.m981a(z2, "GoogleApiClient is not connected yet.");
            if (c0132c.ea() == null) {
                z = false;
            }
            fq.m985b(z, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Bp.add(c0132c);
            c0132c.mo2671a(this.AL);
            if (ek()) {
                c0132c.mo2676k(new Status(8));
                return;
            }
            c0132c.mo2672b(mo1085a(c0132c.ea()));
            this.Ba.unlock();
        } finally {
            this.Ba.unlock();
        }
    }

    private void ei() {
        this.Ba.lock();
        try {
            this.Bj--;
            if (this.Bj == 0) {
                if (this.Be != null) {
                    this.Bi = false;
                    m1659E(3);
                    if (ek()) {
                        this.Bh--;
                    }
                    if (ek()) {
                        this.Bl.sendMessageDelayed(this.Bl.obtainMessage(1), this.Bk);
                    } else {
                        this.Bc.m927a(this.Be);
                    }
                    this.Bo = false;
                } else {
                    this.Bg = 2;
                    el();
                    this.Bb.signalAll();
                    ej();
                    if (this.Bi) {
                        this.Bi = false;
                        m1659E(-1);
                    } else {
                        this.Bc.m928b(this.Bm.isEmpty() ? null : this.Bm);
                    }
                }
            }
            this.Ba.unlock();
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    private void ej() {
        boolean z = isConnected() || ek();
        fq.m981a(z, "GoogleApiClient is not connected yet.");
        this.Ba.lock();
        while (!this.Bd.isEmpty()) {
            try {
                m1663a((C0132c) this.Bd.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.Ba.unlock();
            }
        }
        this.Ba.unlock();
    }

    private boolean ek() {
        this.Ba.lock();
        try {
            boolean z = this.Bh != 0;
            this.Ba.unlock();
            return z;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    private void el() {
        this.Ba.lock();
        try {
            this.Bh = 0;
            this.Bl.removeMessages(1);
        } finally {
            this.Ba.unlock();
        }
    }

    /* renamed from: a */
    public <C extends C0123a> C mo1085a(C0125c<C> c0125c) {
        Object obj = (C0123a) this.Bn.get(c0125c);
        fq.m983b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    /* renamed from: a */
    public <A extends C0123a, T extends C0901b<? extends Result, A>> T mo1086a(T t) {
        this.Ba.lock();
        try {
            if (isConnected()) {
                mo1087b((C0901b) t);
            } else {
                this.Bd.add(t);
            }
            this.Ba.unlock();
            return t;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    /* renamed from: b */
    public <A extends C0123a, T extends C0901b<? extends Result, A>> T mo1087b(T t) {
        boolean z = isConnected() || ek();
        fq.m981a(z, "GoogleApiClient is not connected yet.");
        ej();
        try {
            m1663a((C0132c) t);
        } catch (DeadObjectException e) {
            m1659E(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        fq.m981a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.Ba.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.Bb.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Ag;
                this.Ba.unlock();
            } else if (this.Be != null) {
                connectionResult = this.Be;
                this.Ba.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.Ba.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.Ba.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.Ba.lock();
        try {
            this.Bi = false;
            if (isConnected() || isConnecting()) {
                this.Ba.unlock();
                return;
            }
            this.Bo = true;
            this.Be = null;
            this.Bg = 1;
            this.Bm.clear();
            this.Bj = this.Bn.size();
            for (C0123a connect : this.Bn.values()) {
                connect.connect();
            }
            this.Ba.unlock();
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public void disconnect() {
        el();
        m1659E(-1);
    }

    public Looper getLooper() {
        return this.AS;
    }

    public boolean isConnected() {
        this.Ba.lock();
        try {
            boolean z = this.Bg == 2;
            this.Ba.unlock();
            return z;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.Ba.lock();
        try {
            if (this.Bg != 1) {
                z = false;
            }
            this.Ba.unlock();
            return z;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.Bc.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.Bc.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.Bc.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.Bc.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.Bc.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.Bc.unregisterConnectionFailedListener(listener);
    }
}
