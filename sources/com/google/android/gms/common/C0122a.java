package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0122a implements ServiceConnection {
    boolean Ae = false;
    private final BlockingQueue<IBinder> Af = new LinkedBlockingQueue();

    public IBinder dV() throws InterruptedException {
        if (this.Ae) {
            throw new IllegalStateException();
        }
        this.Ae = true;
        return (IBinder) this.Af.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.Af.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
