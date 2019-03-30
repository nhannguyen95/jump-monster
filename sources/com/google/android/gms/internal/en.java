package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ep.C0628a;
import com.google.android.gms.internal.eq.C0629a;
import com.google.android.gms.internal.ff.C0976e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class en extends ff<ep> {
    private static final er zb = new er("CastClientImpl");
    private static final Object zs = new Object();
    private static final Object zt = new Object();
    private final Handler mHandler;
    private final Listener xX;
    private double yC = 0.0d;
    private boolean yD = false;
    private ApplicationMetadata zc = null;
    private final CastDevice zd;
    private final eq ze;
    private final Map<String, MessageReceivedCallback> zf = new HashMap();
    private final long zg;
    private String zh = null;
    private boolean zi;
    private boolean zj = false;
    private final AtomicLong zk = new AtomicLong(0);
    private String zl;
    private String zm;
    private Bundle zn;
    private Map<Long, C0128d<Status>> zo = new HashMap();
    private C0975b zp = new C0975b();
    private C0128d<ApplicationConnectionResult> zq;
    private C0128d<Status> zr;

    /* renamed from: com.google.android.gms.internal.en$1 */
    class C09731 extends C0629a {
        final /* synthetic */ en zu;

        C09731(en enVar) {
            this.zu = enVar;
        }

        /* renamed from: D */
        private boolean m3014D(int i) {
            synchronized (en.zt) {
                if (this.zu.zr != null) {
                    this.zu.zr.mo1074b(new Status(i));
                    this.zu.zr = null;
                    return true;
                }
                return false;
            }
        }

        /* renamed from: b */
        private void m3015b(long j, int i) {
            synchronized (this.zu.zo) {
                C0128d c0128d = (C0128d) this.zu.zo.remove(Long.valueOf(j));
            }
            if (c0128d != null) {
                c0128d.mo1074b(new Status(i));
            }
        }

        /* renamed from: A */
        public void mo2897A(int i) {
            synchronized (en.zs) {
                if (this.zu.zq != null) {
                    this.zu.zq.mo1074b(new C0974a(new Status(i)));
                    this.zu.zq = null;
                }
            }
        }

        /* renamed from: B */
        public void mo2898B(int i) {
            m3014D(i);
        }

        /* renamed from: C */
        public void mo2899C(int i) {
            m3014D(i);
        }

        /* renamed from: a */
        public void mo2900a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zu.zc = applicationMetadata;
            this.zu.zl = applicationMetadata.getApplicationId();
            this.zu.zm = str2;
            synchronized (en.zs) {
                if (this.zu.zq != null) {
                    this.zu.zq.mo1074b(new C0974a(new Status(0), applicationMetadata, str, str2, z));
                    this.zu.zq = null;
                }
            }
        }

        /* renamed from: a */
        public void mo2901a(String str, long j) {
            m3015b(j, 0);
        }

        /* renamed from: a */
        public void mo2902a(String str, long j, int i) {
            m3015b(j, i);
        }

        /* renamed from: b */
        public void mo2903b(String str, double d, boolean z) {
            final String str2 = str;
            final double d2 = d;
            final boolean z2 = z;
            this.zu.mHandler.post(new Runnable(this) {
                final /* synthetic */ C09731 zw;

                public void run() {
                    this.zw.zu.m3030a(str2, d2, z2);
                }
            });
        }

        /* renamed from: b */
        public void mo2904b(String str, byte[] bArr) {
            en.zb.m899b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        /* renamed from: d */
        public void mo2905d(final String str, final String str2) {
            en.zb.m899b("Receive (type=text, ns=%s) %s", str, str2);
            this.zu.mHandler.post(new Runnable(this) {
                final /* synthetic */ C09731 zw;

                public void run() {
                    synchronized (this.zw.zu.zf) {
                        MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zw.zu.zf.get(str);
                    }
                    if (messageReceivedCallback != null) {
                        messageReceivedCallback.onMessageReceived(this.zw.zu.zd, str, str2);
                        return;
                    }
                    en.zb.m899b("Discarded message for unknown namespace '%s'", str);
                }
            });
        }

        public void onApplicationDisconnected(final int statusCode) {
            this.zu.zl = null;
            this.zu.zm = null;
            if (!m3014D(statusCode) && this.zu.xX != null) {
                this.zu.mHandler.post(new Runnable(this) {
                    final /* synthetic */ C09731 zw;

                    public void run() {
                        if (this.zw.zu.xX != null) {
                            this.zw.zu.xX.onApplicationDisconnected(statusCode);
                        }
                    }
                });
            }
        }

        /* renamed from: z */
        public void mo2907z(int i) {
            en.zb.m899b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            this.zu.zj = false;
            this.zu.zc = null;
            if (i != 0) {
                this.zu.m2167N(2);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.en$a */
    private static final class C0974a implements ApplicationConnectionResult {
        private final String qL;
        private final Status wJ;
        private final String zA;
        private final boolean zB;
        private final ApplicationMetadata zz;

        public C0974a(Status status) {
            this(status, null, null, null, false);
        }

        public C0974a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.wJ = status;
            this.zz = applicationMetadata;
            this.zA = str;
            this.qL = str2;
            this.zB = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zz;
        }

        public String getApplicationStatus() {
            return this.zA;
        }

        public String getSessionId() {
            return this.qL;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public boolean getWasLaunched() {
            return this.zB;
        }
    }

    /* renamed from: com.google.android.gms.internal.en$b */
    private class C0975b implements OnConnectionFailedListener {
        final /* synthetic */ en zu;

        private C0975b(en enVar) {
            this.zu = enVar;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zu.dJ();
        }
    }

    public en(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.zd = castDevice;
        this.xX = listener;
        this.zg = j;
        this.mHandler = new Handler(looper);
        registerConnectionFailedListener(this.zp);
        this.ze = new C09731(this);
    }

    /* renamed from: a */
    private void m3030a(String str, double d, boolean z) {
        boolean z2;
        if (eo.m875a(str, this.zh)) {
            z2 = false;
        } else {
            this.zh = str;
            int i = 1;
        }
        if (this.xX != null && (r0 != 0 || this.zi)) {
            this.xX.onApplicationStatusChanged();
        }
        if (d != this.yC) {
            this.yC = d;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != this.yD) {
            this.yD = z;
            z2 = true;
        }
        zb.m899b("hasChange=%b, mFirstStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zi));
        if (this.xX != null && (z2 || this.zi)) {
            this.xX.onVolumeChanged();
        }
        this.zi = false;
    }

    /* renamed from: d */
    private void m3037d(C0128d<ApplicationConnectionResult> c0128d) {
        synchronized (zs) {
            if (this.zq != null) {
                this.zq.mo1074b(new C0974a(new Status(2002)));
            }
            this.zq = c0128d;
        }
    }

    private void dJ() {
        zb.m899b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zf) {
            this.zf.clear();
        }
    }

    private void dK() throws IllegalStateException {
        if (!this.zj) {
            throw new IllegalStateException("not connected to a device");
        }
    }

    /* renamed from: f */
    private void m3040f(C0128d<Status> c0128d) {
        synchronized (zt) {
            if (this.zr != null) {
                c0128d.mo1074b(new Status(2001));
                return;
            }
            this.zr = c0128d;
        }
    }

    /* renamed from: V */
    public void m3044V(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zf) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zf.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((ep) eM()).aa(str);
            } catch (Throwable e) {
                zb.m898a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void m3045a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((ep) eM()).mo1706a(d, this.yC, this.yD);
    }

    /* renamed from: a */
    protected void mo2683a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 || i == 1001) {
            this.zj = true;
            this.zi = true;
        } else {
            this.zj = false;
        }
        if (i == 1001) {
            this.zn = new Bundle();
            this.zn.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.mo2683a(i, iBinder, bundle);
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        Bundle bundle = new Bundle();
        zb.m899b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.zl, this.zm);
        this.zd.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zg);
        if (this.zl != null) {
            bundle.putString("last_application_id", this.zl);
            if (this.zm != null) {
                bundle.putString("last_session_id", this.zm);
            }
        }
        fmVar.mo1738a((fl) c0976e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.ze.asBinder(), bundle);
    }

    /* renamed from: a */
    public void m3048a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        eo.m873W(str);
        m3044V(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zf) {
                this.zf.put(str, messageReceivedCallback);
            }
            ((ep) eM()).mo1705Z(str);
        }
    }

    /* renamed from: a */
    public void m3049a(String str, C0128d<Status> c0128d) throws IllegalStateException, RemoteException {
        m3040f((C0128d) c0128d);
        ((ep) eM()).mo1704Y(str);
    }

    /* renamed from: a */
    public void m3050a(String str, String str2, C0128d<Status> c0128d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            eo.m873W(str);
            dK();
            long incrementAndGet = this.zk.incrementAndGet();
            ((ep) eM()).mo1707a(str, str2, incrementAndGet);
            this.zo.put(Long.valueOf(incrementAndGet), c0128d);
        }
    }

    /* renamed from: a */
    public void m3051a(String str, boolean z, C0128d<ApplicationConnectionResult> c0128d) throws IllegalStateException, RemoteException {
        m3037d((C0128d) c0128d);
        ((ep) eM()).mo1715e(str, z);
    }

    /* renamed from: b */
    public void m3052b(String str, String str2, C0128d<ApplicationConnectionResult> c0128d) throws IllegalStateException, RemoteException {
        m3037d((C0128d) c0128d);
        ((ep) eM()).mo1714e(str, str2);
    }

    protected String bg() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bh() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public Bundle dG() {
        if (this.zn == null) {
            return super.dG();
        }
        Bundle bundle = this.zn;
        this.zn = null;
        return bundle;
    }

    public void dH() throws IllegalStateException, RemoteException {
        ((ep) eM()).dH();
    }

    public double dI() throws IllegalStateException {
        dK();
        return this.yC;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r5 = this;
        r5.dJ();
        r0 = r5.isConnected();	 Catch:{ RemoteException -> 0x0016 }
        if (r0 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r5.eM();	 Catch:{ RemoteException -> 0x0016 }
        r0 = (com.google.android.gms.internal.ep) r0;	 Catch:{ RemoteException -> 0x0016 }
        r0.disconnect();	 Catch:{ RemoteException -> 0x0016 }
    L_0x0012:
        super.disconnect();
    L_0x0015:
        return;
    L_0x0016:
        r0 = move-exception;
        r1 = zb;	 Catch:{ all -> 0x002c }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x002c }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x002c }
        r3[r4] = r0;	 Catch:{ all -> 0x002c }
        r1.m899b(r2, r3);	 Catch:{ all -> 0x002c }
        super.disconnect();
        goto L_0x0015;
    L_0x002c:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.en.disconnect():void");
    }

    /* renamed from: e */
    public void m3053e(C0128d<Status> c0128d) throws IllegalStateException, RemoteException {
        m3040f((C0128d) c0128d);
        ((ep) eM()).dO();
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        dK();
        return this.zc;
    }

    public String getApplicationStatus() throws IllegalStateException {
        dK();
        return this.zh;
    }

    public boolean isMute() throws IllegalStateException {
        dK();
        return this.yD;
    }

    /* renamed from: r */
    protected /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return m3056x(iBinder);
    }

    /* renamed from: v */
    public void m3055v(boolean z) throws IllegalStateException, RemoteException {
        ((ep) eM()).mo1709a(z, this.yC, this.yD);
    }

    /* renamed from: x */
    protected ep m3056x(IBinder iBinder) {
        return C0628a.m2118y(iBinder);
    }
}
