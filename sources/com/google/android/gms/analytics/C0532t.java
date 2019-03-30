package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.ef;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.t */
class C0532t extends Thread implements C0092f {
    private static C0532t tA;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile String su;
    private volatile ag tB;
    private final LinkedBlockingQueue<Runnable> tw = new LinkedBlockingQueue();
    private volatile boolean tx = false;
    private volatile List<ef> ty;
    private volatile String tz;

    /* renamed from: com.google.android.gms.analytics.t$2 */
    class C01122 implements Runnable {
        final /* synthetic */ C0532t tD;

        C01122(C0532t c0532t) {
            this.tD = c0532t;
        }

        public void run() {
            this.tD.tB.bW();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t$3 */
    class C01133 implements Runnable {
        final /* synthetic */ C0532t tD;

        C01133(C0532t c0532t) {
            this.tD = c0532t;
        }

        public void run() {
            this.tD.tB.bR();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t$4 */
    class C01144 implements Runnable {
        final /* synthetic */ C0532t tD;

        C01144(C0532t c0532t) {
            this.tD = c0532t;
        }

        public void run() {
            this.tD.tB.bY();
        }
    }

    private C0532t(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: H */
    static int m1610H(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private String m1613a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: q */
    static C0532t m1622q(Context context) {
        if (tA == null) {
            tA = new C0532t(context);
        }
        return tA;
    }

    /* renamed from: r */
    static String m1623r(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                aa.m33w("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.m36z("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.m34x("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.m34x("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.m33w("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    /* renamed from: r */
    private String m1624r(Map<String, String> map) {
        return map.containsKey("useSecure") ? ak.m47d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    /* renamed from: s */
    private boolean m1625s(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = ak.m44a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (C0532t.m1610H((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? "unknown" : (String) map.get("&t");
        aa.m35y(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    /* renamed from: t */
    private void m1626t(Map<String, String> map) {
        C0098m m = C0521a.m1543m(this.mContext);
        ak.m46a(map, "&adid", m.getValue("&adid"));
        ak.m46a(map, "&ate", m.getValue("&ate"));
    }

    /* renamed from: u */
    private void m1627u(Map<String, String> map) {
        C0098m ca = C0525g.ca();
        ak.m46a(map, "&an", ca.getValue("&an"));
        ak.m46a(map, "&av", ca.getValue("&av"));
        ak.m46a(map, "&aid", ca.getValue("&aid"));
        ak.m46a(map, "&aiid", ca.getValue("&aiid"));
        map.put("&v", "1");
    }

    /* renamed from: a */
    void m1628a(Runnable runnable) {
        this.tw.add(runnable);
    }

    public void bR() {
        m1628a(new C01133(this));
    }

    public void bW() {
        m1628a(new C01122(this));
    }

    public void bY() {
        m1628a(new C01144(this));
    }

    public LinkedBlockingQueue<Runnable> bZ() {
        return this.tw;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.tB.cp();
        this.ty = new ArrayList();
        this.ty.add(new ef("appendVersion", "&_v".substring(1), "ma4.0.1"));
        this.ty.add(new ef("appendQueueTime", "&qt".substring(1), null));
        this.ty.add(new ef("appendCacheBuster", "&z".substring(1), null));
    }

    /* renamed from: q */
    public void mo1039q(Map<String, String> map) {
        final Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m1628a(new Runnable(this) {
            final /* synthetic */ C0532t tD;

            public void run() {
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&cid"))) {
                    hashMap.put("&cid", this.tD.su);
                }
                if (!GoogleAnalytics.getInstance(this.tD.mContext).getAppOptOut() && !this.tD.m1625s(hashMap)) {
                    if (!TextUtils.isEmpty(this.tD.tz)) {
                        C0116u.cy().m70t(true);
                        hashMap.putAll(new HitBuilder().setCampaignParamsFromUrl(this.tD.tz).build());
                        C0116u.cy().m70t(false);
                        this.tD.tz = null;
                    }
                    this.tD.m1627u(hashMap);
                    this.tD.m1626t(hashMap);
                    this.tD.tB.mo1027b(C0118y.m74v(hashMap), Long.valueOf((String) hashMap.get("&ht")).longValue(), this.tD.m1624r(hashMap), this.tD.ty);
                }
            }
        });
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.m36z("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.tB == null) {
                this.tB = new C0531s(this.mContext, this);
            }
            init();
            this.su = C0526h.cb().getValue("&cid");
            if (this.su == null) {
                this.tx = true;
            }
            this.tz = C0532t.m1623r(this.mContext);
            aa.m35y("Initialized GA Thread");
        } catch (Throwable th) {
            aa.m33w("Error initializing the GAThread: " + m1613a(th));
            aa.m33w("Google Analytics will not start up.");
            this.tx = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.tw.take();
                if (!this.tx) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.m34x(e2.toString());
            } catch (Throwable th2) {
                aa.m33w("Error on GAThread: " + m1613a(th2));
                aa.m33w("Google Analytics is shutting down.");
                this.tx = true;
            }
        }
    }
}
