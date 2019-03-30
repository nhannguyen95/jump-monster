package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.kh.C0688a;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kk;

public abstract class WearableListenerService extends Service {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private IBinder DB;
    private volatile int adu = -1;
    private String adv;
    private Handler adw;

    /* renamed from: com.google.android.gms.wearable.WearableListenerService$a */
    private class C1024a extends C0688a {
        final /* synthetic */ WearableListenerService adx;

        private C1024a(WearableListenerService wearableListenerService) {
            this.adx = wearableListenerService;
        }

        /* renamed from: M */
        public void mo3179M(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.adx.adv + ": " + dataHolder);
            }
            this.adx.md();
            this.adx.adw.post(new Runnable(this) {
                final /* synthetic */ C1024a adz;

                public void run() {
                    C1025b c1025b = new C1025b(dataHolder);
                    try {
                        this.adz.adx.onDataChanged(c1025b);
                    } finally {
                        c1025b.close();
                    }
                }
            });
        }

        /* renamed from: a */
        public void mo3180a(final ki kiVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + kiVar);
            }
            this.adx.md();
            this.adx.adw.post(new Runnable(this) {
                final /* synthetic */ C1024a adz;

                public void run() {
                    this.adz.adx.onMessageReceived(kiVar);
                }
            });
        }

        /* renamed from: a */
        public void mo3181a(final kk kkVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.adx.adv + ": " + kkVar);
            }
            this.adx.md();
            this.adx.adw.post(new Runnable(this) {
                final /* synthetic */ C1024a adz;

                public void run() {
                    this.adz.adx.onPeerConnected(kkVar);
                }
            });
        }

        /* renamed from: b */
        public void mo3182b(final kk kkVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.adx.adv + ": " + kkVar);
            }
            this.adx.md();
            this.adx.adw.post(new Runnable(this) {
                final /* synthetic */ C1024a adz;

                public void run() {
                    this.adz.adx.onPeerDisconnected(kkVar);
                }
            });
        }
    }

    private boolean cM(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void md() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.adu) {
            if (GooglePlayServicesUtil.m112b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && cM(callingUid)) {
                this.adu = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.DB : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.adv = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.adw = new Handler(handlerThread.getLooper());
        this.DB = new C1024a();
    }

    public void onDataChanged(C1025b dataEvents) {
    }

    public void onDestroy() {
        this.adw.getLooper().quit();
        super.onDestroy();
    }

    public void onMessageReceived(C0452e messageEvent) {
    }

    public void onPeerConnected(C0453f peer) {
    }

    public void onPeerDisconnected(C0453f peer) {
    }
}
