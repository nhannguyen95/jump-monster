package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0169w.C0564a;
import com.google.android.gms.internal.fq;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0916s<C extends DriveEvent> extends C0564a {
    private final int ES;
    private final C0165a<C> FA;
    private final Listener<C> Fz;

    /* renamed from: com.google.android.gms.drive.internal.s$a */
    private static class C0165a<E extends DriveEvent> extends Handler {
        private C0165a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m292a(Listener<E> listener, E e) {
            sendMessage(obtainMessage(1, new Pair(listener, e)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                    return;
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    public C0916s(Looper looper, int i, Listener<C> listener) {
        this.ES = i;
        this.Fz = listener;
        this.FA = new C0165a(looper);
    }

    /* renamed from: a */
    public void mo1155a(OnEventResponse onEventResponse) throws RemoteException {
        fq.m987x(this.ES == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case 1:
                this.FA.m292a(this.Fz, onEventResponse.fL());
                return;
            case 2:
                this.FA.m292a(this.Fz, onEventResponse.fM());
                return;
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
                return;
        }
    }
}
