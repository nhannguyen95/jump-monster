package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C0312a;
import com.google.android.gms.location.C0312a.C0696a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class hb {
    private final hf<ha> Ok;
    private ContentProviderClient Ol = null;
    private boolean Om = false;
    private HashMap<LocationListener, C0979b> On = new HashMap();
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.hb$a */
    private static class C0286a extends Handler {
        private final LocationListener Oo;

        public C0286a(LocationListener locationListener) {
            this.Oo = locationListener;
        }

        public C0286a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.Oo = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.Oo.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hb$b */
    private static class C0979b extends C0696a {
        private Handler Op;

        C0979b(LocationListener locationListener, Looper looper) {
            this.Op = looper == null ? new C0286a(locationListener) : new C0286a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.Op == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.Op.sendMessage(obtain);
        }

        public void release() {
            this.Op = null;
        }
    }

    public hb(Context context, hf<ha> hfVar) {
        this.mContext = context;
        this.Ok = hfVar;
    }

    public Location getLastLocation() {
        this.Ok.bT();
        try {
            return ((ha) this.Ok.eM()).aW(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void hQ() {
        if (this.Om) {
            setMockMode(false);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.On) {
                for (C0312a c0312a : this.On.values()) {
                    if (c0312a != null) {
                        ((ha) this.Ok.eM()).mo1790a(c0312a);
                    }
                }
                this.On.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).mo1778a(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.Ok.bT();
        fq.m983b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.On) {
            C0312a c0312a = (C0979b) this.On.remove(listener);
            if (this.Ol != null && this.On.isEmpty()) {
                this.Ol.release();
                this.Ol = null;
            }
            if (c0312a != null) {
                c0312a.release();
                try {
                    ((ha) this.Ok.eM()).mo1790a(c0312a);
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).mo1787a(request, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.Ok.bT();
        if (looper == null) {
            fq.m983b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.On) {
            C0312a c0979b;
            C0979b c0979b2 = (C0979b) this.On.get(listener);
            if (c0979b2 == null) {
                c0979b = new C0979b(listener, looper);
            } else {
                Object obj = c0979b2;
            }
            this.On.put(listener, c0979b);
            try {
                ((ha) this.Ok.eM()).mo1789a(request, c0979b, this.mContext.getPackageName());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).setMockLocation(mockLocation);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).setMockMode(isMockMode);
            this.Om = isMockMode;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
