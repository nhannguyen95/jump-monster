package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C0370b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager aay;
    private final DataLayer WK;
    private final C0413r Zg;
    private final C0375a aaw;
    private final ConcurrentMap<C1019n, Boolean> aax;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager$a */
    interface C0375a {
        /* renamed from: a */
        C1020o mo2237a(Context context, TagManager tagManager, Looper looper, String str, int i, C0413r c0413r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$1 */
    class C08131 implements C0370b {
        final /* synthetic */ TagManager aaz;

        C08131(TagManager tagManager) {
            this.aaz = tagManager;
        }

        /* renamed from: y */
        public void mo2236y(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.aaz.bT(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$2 */
    static class C08142 implements C0375a {
        C08142() {
        }

        /* renamed from: a */
        public C1020o mo2237a(Context context, TagManager tagManager, Looper looper, String str, int i, C0413r c0413r) {
            return new C1020o(context, tagManager, looper, str, i, c0413r);
        }
    }

    TagManager(Context context, C0375a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aaw = containerHolderLoaderProvider;
        this.aax = new ConcurrentHashMap();
        this.WK = dataLayer;
        this.WK.m1346a(new C08131(this));
        this.WK.m1346a(new C0827d(this.mContext));
        this.Zg = new C0413r();
    }

    private void bT(String str) {
        for (C1019n bp : this.aax.keySet()) {
            bp.bp(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (aay == null) {
                if (context == null) {
                    bh.m1385w("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                aay = new TagManager(context, new C08142(), new DataLayer(new C0846v(context)));
            }
            tagManager = aay;
        }
        return tagManager;
    }

    /* renamed from: a */
    void m1354a(C1019n c1019n) {
        this.aax.put(c1019n, Boolean.valueOf(true));
    }

    /* renamed from: b */
    boolean m1355b(C1019n c1019n) {
        return this.aax.remove(c1019n) != null;
    }

    /* renamed from: g */
    synchronized boolean m1356g(Uri uri) {
        boolean z;
        cd kT = cd.kT();
        if (kT.m1401g(uri)) {
            String containerId = kT.getContainerId();
            switch (kT.kU()) {
                case NONE:
                    for (C1019n c1019n : this.aax.keySet()) {
                        if (c1019n.getContainerId().equals(containerId)) {
                            c1019n.br(null);
                            c1019n.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (C1019n c1019n2 : this.aax.keySet()) {
                        if (c1019n2.getContainerId().equals(containerId)) {
                            c1019n2.br(kT.kV());
                            c1019n2.refresh();
                        } else if (c1019n2.ke() != null) {
                            c1019n2.br(null);
                            c1019n2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public DataLayer getDataLayer() {
        return this.WK;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aaw.mo2237a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Zg);
        a.kh();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aaw.mo2237a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Zg);
        a.kh();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aaw.mo2237a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Zg);
        a.kj();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aaw.mo2237a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Zg);
        a.kj();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aaw.mo2237a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Zg);
        a.ki();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aaw.mo2237a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Zg);
        a.ki();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
