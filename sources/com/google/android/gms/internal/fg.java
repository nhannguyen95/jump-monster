package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class fg {
    private final C0278b Do;
    private final ArrayList<ConnectionCallbacks> Dp = new ArrayList();
    final ArrayList<ConnectionCallbacks> Dq = new ArrayList();
    private boolean Dr = false;
    private final ArrayList<OnConnectionFailedListener> Ds = new ArrayList();
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.fg$a */
    final class C0277a extends Handler {
        final /* synthetic */ fg Dt;

        public C0277a(fg fgVar, Looper looper) {
            this.Dt = fgVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (this.Dt.Dp) {
                    if (this.Dt.Do.em() && this.Dt.Do.isConnected() && this.Dt.Dp.contains(msg.obj)) {
                        ((ConnectionCallbacks) msg.obj).onConnected(this.Dt.Do.dG());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    /* renamed from: com.google.android.gms.internal.fg$b */
    public interface C0278b {
        Bundle dG();

        boolean em();

        boolean isConnected();
    }

    public fg(Context context, Looper looper, C0278b c0278b) {
        this.Do = c0278b;
        this.mHandler = new C0277a(this, looper);
    }

    /* renamed from: O */
    public void m926O(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.Dp) {
            this.Dr = true;
            Iterator it = new ArrayList(this.Dp).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.Do.em()) {
                    break;
                } else if (this.Dp.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.Dr = false;
        }
    }

    /* renamed from: a */
    public void m927a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.Ds) {
            Iterator it = new ArrayList(this.Ds).iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (!this.Do.em()) {
                    return;
                } else if (this.Ds.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    /* renamed from: b */
    public void m928b(Bundle bundle) {
        boolean z = true;
        synchronized (this.Dp) {
            fq.m987x(!this.Dr);
            this.mHandler.removeMessages(1);
            this.Dr = true;
            if (this.Dq.size() != 0) {
                z = false;
            }
            fq.m987x(z);
            Iterator it = new ArrayList(this.Dp).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.Do.em() || !this.Do.isConnected()) {
                    break;
                } else if (!this.Dq.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.Dq.clear();
            this.Dr = false;
        }
    }

    protected void bV() {
        synchronized (this.Dp) {
            m928b(this.Do.dG());
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        fq.m986f(listener);
        synchronized (this.Dp) {
            contains = this.Dp.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        fq.m986f(listener);
        synchronized (this.Ds) {
            contains = this.Ds.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        fq.m986f(listener);
        synchronized (this.Dp) {
            if (this.Dp.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.Dp.add(listener);
            }
        }
        if (this.Do.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        fq.m986f(listener);
        synchronized (this.Ds) {
            if (this.Ds.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.Ds.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        fq.m986f(listener);
        synchronized (this.Dp) {
            if (this.Dp != null) {
                if (!this.Dp.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.Dr) {
                    this.Dq.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        fq.m986f(listener);
        synchronized (this.Ds) {
            if (!(this.Ds == null || this.Ds.remove(listener))) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }
}
