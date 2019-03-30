package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0223c.C0962f;
import com.google.android.gms.internal.C0223c.C0965i;
import com.google.android.gms.internal.C0223c.C0966j;
import com.google.android.gms.internal.C0239d.C0969a;
import com.google.android.gms.tagmanager.C0844s.C0414a;
import com.google.android.gms.tagmanager.cd.C0385a;
import com.google.android.gms.tagmanager.cq.C0393c;
import com.google.android.gms.tagmanager.cq.C0397g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String WJ;
    private final DataLayer WK;
    private cs WL;
    private Map<String, FunctionCallMacroCallback> WM = new HashMap();
    private Map<String, FunctionCallTagCallback> WN = new HashMap();
    private volatile long WO;
    private volatile String WP = "";
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$a */
    private class C0809a implements C0414a {
        final /* synthetic */ Container WQ;

        private C0809a(Container container) {
            this.WQ = container;
        }

        /* renamed from: b */
        public Object mo2231b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback bn = this.WQ.bn(str);
            return bn == null ? null : bn.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$b */
    private class C0810b implements C0414a {
        final /* synthetic */ Container WQ;

        private C0810b(Container container) {
            this.WQ = container;
        }

        /* renamed from: b */
        public Object mo2231b(String str, Map<String, Object> map) {
            FunctionCallTagCallback bo = this.WQ.bo(str);
            if (bo != null) {
                bo.execute(str, map);
            }
            return dh.lS();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0966j resource) {
        this.mContext = context;
        this.WK = dataLayer;
        this.WJ = containerId;
        this.WO = lastRefreshTime;
        m1328a(resource.fK);
        if (resource.fJ != null) {
            m1331a(resource.fJ);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0393c resource) {
        this.mContext = context;
        this.WK = dataLayer;
        this.WJ = containerId;
        this.WO = lastRefreshTime;
        m1329a(resource);
    }

    /* renamed from: a */
    private void m1328a(C0962f c0962f) {
        if (c0962f == null) {
            throw new NullPointerException();
        }
        try {
            m1329a(cq.m1423b(c0962f));
        } catch (C0397g e) {
            bh.m1385w("Not loading resource: " + c0962f + " because it is invalid: " + e.toString());
        }
    }

    /* renamed from: a */
    private void m1329a(C0393c c0393c) {
        this.WP = c0393c.getVersion();
        C0393c c0393c2 = c0393c;
        m1330a(new cs(this.mContext, c0393c2, this.WK, new C0809a(), new C0810b(), bq(this.WP)));
    }

    /* renamed from: a */
    private synchronized void m1330a(cs csVar) {
        this.WL = csVar;
    }

    /* renamed from: a */
    private void m1331a(C0965i[] c0965iArr) {
        List arrayList = new ArrayList();
        for (Object add : c0965iArr) {
            arrayList.add(add);
        }
        kd().m1451e(arrayList);
    }

    private synchronized cs kd() {
        return this.WL;
    }

    FunctionCallMacroCallback bn(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.WM) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.WM.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback bo(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.WN) {
            functionCallTagCallback = (FunctionCallTagCallback) this.WN.get(str);
        }
        return functionCallTagCallback;
    }

    void bp(String str) {
        kd().bp(str);
    }

    ag bq(String str) {
        if (cd.kT().kU().equals(C0385a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m1385w("getBoolean called for closed container.");
            return dh.lQ().booleanValue();
        }
        try {
            return dh.m1467n((C0969a) kd.bR(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m1385w("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lQ().booleanValue();
        }
    }

    public String getContainerId() {
        return this.WJ;
    }

    public double getDouble(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m1385w("getDouble called for closed container.");
            return dh.lP().doubleValue();
        }
        try {
            return dh.m1464m((C0969a) kd.bR(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m1385w("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lP().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.WO;
    }

    public long getLong(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m1385w("getLong called for closed container.");
            return dh.lO().longValue();
        }
        try {
            return dh.m1463l((C0969a) kd.bR(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m1385w("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lO().longValue();
        }
    }

    public String getString(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m1385w("getString called for closed container.");
            return dh.lS();
        }
        try {
            return dh.m1461j((C0969a) kd.bR(key).getObject());
        } catch (Exception e) {
            bh.m1385w("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lS();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String kc() {
        return this.WP;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.WM) {
            this.WM.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.WN) {
            this.WN.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.WL = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.WM) {
            this.WM.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.WN) {
            this.WN.remove(customTagName);
        }
    }
}
