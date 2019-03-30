package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

/* renamed from: com.google.android.gms.tagmanager.n */
class C1019n implements ContainerHolder {
    private final Looper AS;
    private Container WR;
    private Container WS;
    private C0411b WT;
    private C0410a WU;
    private boolean WV;
    private TagManager WW;
    private Status wJ;

    /* renamed from: com.google.android.gms.tagmanager.n$a */
    public interface C0410a {
        void br(String str);

        String ke();

        void kg();
    }

    /* renamed from: com.google.android.gms.tagmanager.n$b */
    private class C0411b extends Handler {
        private final ContainerAvailableListener WX;
        final /* synthetic */ C1019n WY;

        public C0411b(C1019n c1019n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.WY = c1019n;
            super(looper);
            this.WX = containerAvailableListener;
        }

        public void bs(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void bt(String str) {
            this.WX.onContainerAvailable(this.WY, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    bt((String) msg.obj);
                    return;
                default:
                    bh.m1385w("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public C1019n(Status status) {
        this.wJ = status;
        this.AS = null;
    }

    public C1019n(TagManager tagManager, Looper looper, Container container, C0410a c0410a) {
        this.WW = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.AS = looper;
        this.WR = container;
        this.WU = c0410a;
        this.wJ = Status.Bv;
        tagManager.m1354a(this);
    }

    private void kf() {
        if (this.WT != null) {
            this.WT.bs(this.WS.kc());
        }
    }

    /* renamed from: a */
    public synchronized void m3213a(Container container) {
        if (!this.WV) {
            if (container == null) {
                bh.m1385w("Unexpected null container.");
            } else {
                this.WS = container;
                kf();
            }
        }
    }

    public synchronized void bp(String str) {
        if (!this.WV) {
            this.WR.bp(str);
        }
    }

    void br(String str) {
        if (this.WV) {
            bh.m1385w("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.WU.br(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.WV) {
                bh.m1385w("ContainerHolder is released.");
            } else {
                if (this.WS != null) {
                    this.WR = this.WS;
                    this.WS = null;
                }
                container = this.WR;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.WV) {
            return this.WR.getContainerId();
        }
        bh.m1385w("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.wJ;
    }

    String ke() {
        if (!this.WV) {
            return this.WU.ke();
        }
        bh.m1385w("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.WV) {
            bh.m1385w("Refreshing a released ContainerHolder.");
        } else {
            this.WU.kg();
        }
    }

    public synchronized void release() {
        if (this.WV) {
            bh.m1385w("Releasing a released ContainerHolder.");
        } else {
            this.WV = true;
            this.WW.m1355b(this);
            this.WR.release();
            this.WR = null;
            this.WS = null;
            this.WU = null;
            this.WT = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.WV) {
            bh.m1385w("ContainerHolder is released.");
        } else if (listener == null) {
            this.WT = null;
        } else {
            this.WT = new C0411b(this, listener, this.AS);
            if (this.WS != null) {
                kf();
            }
        }
    }
}
