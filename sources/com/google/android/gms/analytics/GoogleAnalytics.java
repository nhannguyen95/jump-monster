package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.analytics.C0116u.C0115a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean uY;
    private static GoogleAnalytics vf;
    private Context mContext;
    private C0092f sH;
    private String so;
    private String sp;
    private boolean uZ;
    private af va;
    private volatile Boolean vb;
    private Logger vc;
    private Set<C0081a> vd;
    private boolean ve;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$a */
    interface C0081a {
        /* renamed from: f */
        void mo995f(Activity activity);

        /* renamed from: g */
        void mo996g(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$b */
    class C0082b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics vg;

        C0082b(GoogleAnalytics googleAnalytics) {
            this.vg = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.vg.m1534d(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.vg.m1535e(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0532t.m1622q(context), C0529r.ci());
    }

    private GoogleAnalytics(Context context, C0092f thread, af serviceManager) {
        this.vb = Boolean.valueOf(false);
        this.ve = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.sH = thread;
        this.va = serviceManager;
        C0525g.m1580n(this.mContext);
        ae.m1557n(this.mContext);
        C0526h.m1586n(this.mContext);
        this.vc = new C0527l();
        this.vd = new HashSet();
        cN();
    }

    /* renamed from: I */
    private int m1530I(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    /* renamed from: a */
    private Tracker m1531a(Tracker tracker) {
        if (this.so != null) {
            tracker.set("&an", this.so);
        }
        if (this.sp != null) {
            tracker.set("&av", this.sp);
        }
        return tracker;
    }

    static GoogleAnalytics cM() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = vf;
        }
        return googleAnalytics;
    }

    private void cN() {
        if (!uY) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), Keys.CONTROL_LEFT);
            } catch (NameNotFoundException e) {
                aa.m35y("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aa.m36z("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    C0535w c0535w = (C0535w) new C0534v(this.mContext).m60p(i);
                    if (c0535w != null) {
                        m1537a(c0535w);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m1534d(Activity activity) {
        for (C0081a f : this.vd) {
            f.mo995f(activity);
        }
    }

    /* renamed from: e */
    private void m1535e(Activity activity) {
        for (C0081a g : this.vd) {
            g.mo996g(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (vf == null) {
                vf = new GoogleAnalytics(context);
            }
            googleAnalytics = vf;
        }
        return googleAnalytics;
    }

    /* renamed from: a */
    void m1536a(C0081a c0081a) {
        this.vd.add(c0081a);
    }

    /* renamed from: a */
    void m1537a(C0535w c0535w) {
        aa.m35y("Loading global config values.");
        if (c0535w.cC()) {
            this.so = c0535w.cD();
            aa.m35y("app name loaded: " + this.so);
        }
        if (c0535w.cE()) {
            this.sp = c0535w.cF();
            aa.m35y("app version loaded: " + this.sp);
        }
        if (c0535w.cG()) {
            int I = m1530I(c0535w.cH());
            if (I >= 0) {
                aa.m35y("log level loaded: " + I);
                getLogger().setLogLevel(I);
            }
        }
        if (c0535w.cI()) {
            this.va.setLocalDispatchPeriod(c0535w.cJ());
        }
        if (c0535w.cK()) {
            setDryRun(c0535w.cL());
        }
    }

    /* renamed from: b */
    void m1538b(C0081a c0081a) {
        this.vd.remove(c0081a);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.va.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.ve) {
            application.registerActivityLifecycleCallbacks(new C0082b(this));
            this.ve = true;
        }
    }

    public boolean getAppOptOut() {
        C0116u.cy().m69a(C0115a.GET_APP_OPT_OUT);
        return this.vb.booleanValue();
    }

    public Logger getLogger() {
        return this.vc;
    }

    public boolean isDryRunEnabled() {
        C0116u.cy().m69a(C0115a.GET_DRY_RUN);
        return this.uZ;
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C0116u.cy().m69a(C0115a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this);
            if (configResId > 0) {
                aj ajVar = (aj) new ai(this.mContext).m60p(configResId);
                if (ajVar != null) {
                    tracker.m31a(this.mContext, ajVar);
                }
            }
            a = m1531a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0116u.cy().m69a(C0115a.GET_TRACKER);
            a = m1531a(new Tracker(trackingId, this));
        }
        return a;
    }

    /* renamed from: q */
    void mo991q(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ak.m46a(map, "&ul", ak.m45a(Locale.getDefault()));
            ak.m46a(map, "&sr", ae.cZ().getValue("&sr"));
            map.put("&_u", C0116u.cy().cA());
            C0116u.cy().cz();
            this.sH.mo1039q(map);
        }
    }

    public void reportActivityStart(Activity activity) {
        if (!this.ve) {
            m1534d(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.ve) {
            m1535e(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0116u.cy().m69a(C0115a.SET_APP_OPT_OUT);
        this.vb = Boolean.valueOf(optOut);
        if (this.vb.booleanValue()) {
            this.sH.bR();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0116u.cy().m69a(C0115a.SET_DRY_RUN);
        this.uZ = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.va.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0116u.cy().m69a(C0115a.SET_LOGGER);
        this.vc = logger;
    }
}
