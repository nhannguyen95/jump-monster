package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ff.C0276f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class fh implements Callback {
    private static final Object Du = new Object();
    private static fh Dv;
    private final HashMap<String, C0280a> Dw = new HashMap();
    private final Context lp;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.fh$a */
    final class C0280a {
        private boolean DA;
        private IBinder DB;
        private ComponentName DC;
        final /* synthetic */ fh DD;
        private final String Dx;
        private final C0279a Dy = new C0279a(this);
        private final HashSet<C0276f> Dz = new HashSet();
        private int mState = 0;

        /* renamed from: com.google.android.gms.internal.fh$a$a */
        public class C0279a implements ServiceConnection {
            final /* synthetic */ C0280a DE;

            public C0279a(C0280a c0280a) {
                this.DE = c0280a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.DE.DD.Dw) {
                    this.DE.DB = binder;
                    this.DE.DC = component;
                    Iterator it = this.DE.Dz.iterator();
                    while (it.hasNext()) {
                        ((C0276f) it.next()).onServiceConnected(component, binder);
                    }
                    this.DE.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.DE.DD.Dw) {
                    this.DE.DB = null;
                    this.DE.DC = component;
                    Iterator it = this.DE.Dz.iterator();
                    while (it.hasNext()) {
                        ((C0276f) it.next()).onServiceDisconnected(component);
                    }
                    this.DE.mState = 2;
                }
            }
        }

        public C0280a(fh fhVar, String str) {
            this.DD = fhVar;
            this.Dx = str;
        }

        /* renamed from: a */
        public void m933a(C0276f c0276f) {
            this.Dz.add(c0276f);
        }

        /* renamed from: b */
        public void m934b(C0276f c0276f) {
            this.Dz.remove(c0276f);
        }

        /* renamed from: c */
        public boolean m935c(C0276f c0276f) {
            return this.Dz.contains(c0276f);
        }

        public C0279a eP() {
            return this.Dy;
        }

        public String eQ() {
            return this.Dx;
        }

        public boolean eR() {
            return this.Dz.isEmpty();
        }

        public IBinder getBinder() {
            return this.DB;
        }

        public ComponentName getComponentName() {
            return this.DC;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.DA;
        }

        /* renamed from: y */
        public void m936y(boolean z) {
            this.DA = z;
        }
    }

    private fh(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.lp = context.getApplicationContext();
    }

    /* renamed from: x */
    public static fh m938x(Context context) {
        synchronized (Du) {
            if (Dv == null) {
                Dv = new fh(context.getApplicationContext());
            }
        }
        return Dv;
    }

    /* renamed from: a */
    public boolean m939a(String str, C0276f c0276f) {
        boolean isBound;
        synchronized (this.Dw) {
            C0280a c0280a = (C0280a) this.Dw.get(str);
            if (c0280a != null) {
                this.mHandler.removeMessages(0, c0280a);
                if (!c0280a.m935c(c0276f)) {
                    c0280a.m933a((C0276f) c0276f);
                    switch (c0280a.getState()) {
                        case 1:
                            c0276f.onServiceConnected(c0280a.getComponentName(), c0280a.getBinder());
                            break;
                        case 2:
                            c0280a.m936y(this.lp.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0280a.eP(), Keys.CONTROL_LEFT));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0280a = new C0280a(this, str);
            c0280a.m933a((C0276f) c0276f);
            c0280a.m936y(this.lp.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0280a.eP(), Keys.CONTROL_LEFT));
            this.Dw.put(str, c0280a);
            isBound = c0280a.isBound();
        }
        return isBound;
    }

    /* renamed from: b */
    public void m940b(String str, C0276f c0276f) {
        synchronized (this.Dw) {
            C0280a c0280a = (C0280a) this.Dw.get(str);
            if (c0280a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0280a.m935c(c0276f)) {
                c0280a.m934b(c0276f);
                if (c0280a.eR()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0280a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0280a c0280a = (C0280a) msg.obj;
                synchronized (this.Dw) {
                    if (c0280a.eR()) {
                        this.lp.unbindService(c0280a.eP());
                        this.Dw.remove(c0280a.eQ());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
