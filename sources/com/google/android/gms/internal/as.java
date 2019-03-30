package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class as {
    public static final String DEVICE_ID_EMULATOR = dv.m815u("emulator");
    /* renamed from: d */
    private final Date f135d;
    /* renamed from: f */
    private final Set<String> f136f;
    /* renamed from: h */
    private final Location f137h;
    private final String lY;
    private final int lZ;
    private final boolean ma;
    private final Map<Class<? extends MediationAdapter>, Bundle> mb;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> mc;
    private final String md;
    private final SearchAdRequest me;
    private final int mf;
    private final Set<String> mg;

    /* renamed from: com.google.android.gms.internal.as$a */
    public static final class C0208a {
        /* renamed from: d */
        private Date f133d;
        /* renamed from: h */
        private Location f134h;
        private String lY;
        private int lZ = -1;
        private boolean ma = false;
        private String md;
        private int mf = -1;
        private final HashSet<String> mh = new HashSet();
        private final HashMap<Class<? extends MediationAdapter>, Bundle> mi = new HashMap();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> mj = new HashMap();
        private final HashSet<String> mk = new HashSet();

        /* renamed from: a */
        public void m639a(Location location) {
            this.f134h = location;
        }

        @Deprecated
        /* renamed from: a */
        public void m640a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m641a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.mj.put(networkExtras.getClass(), networkExtras);
            }
        }

        /* renamed from: a */
        public void m641a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.mi.put(cls, bundle);
        }

        /* renamed from: a */
        public void m642a(Date date) {
            this.f133d = date;
        }

        /* renamed from: d */
        public void m643d(int i) {
            this.lZ = i;
        }

        /* renamed from: f */
        public void m644f(boolean z) {
            this.ma = z;
        }

        /* renamed from: g */
        public void m645g(String str) {
            this.mh.add(str);
        }

        /* renamed from: g */
        public void m646g(boolean z) {
            this.mf = z ? 1 : 0;
        }

        /* renamed from: h */
        public void m647h(String str) {
            this.mk.add(str);
        }

        /* renamed from: i */
        public void m648i(String str) {
            this.lY = str;
        }

        /* renamed from: j */
        public void m649j(String str) {
            this.md = str;
        }
    }

    public as(C0208a c0208a) {
        this(c0208a, null);
    }

    public as(C0208a c0208a, SearchAdRequest searchAdRequest) {
        this.f135d = c0208a.f133d;
        this.lY = c0208a.lY;
        this.lZ = c0208a.lZ;
        this.f136f = Collections.unmodifiableSet(c0208a.mh);
        this.f137h = c0208a.f134h;
        this.ma = c0208a.ma;
        this.mb = Collections.unmodifiableMap(c0208a.mi);
        this.mc = Collections.unmodifiableMap(c0208a.mj);
        this.md = c0208a.md;
        this.me = searchAdRequest;
        this.mf = c0208a.mf;
        this.mg = Collections.unmodifiableSet(c0208a.mk);
    }

    public SearchAdRequest aB() {
        return this.me;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> aC() {
        return this.mc;
    }

    public Map<Class<? extends MediationAdapter>, Bundle> aD() {
        return this.mb;
    }

    public int aE() {
        return this.mf;
    }

    public Date getBirthday() {
        return this.f135d;
    }

    public String getContentUrl() {
        return this.lY;
    }

    public int getGender() {
        return this.lZ;
    }

    public Set<String> getKeywords() {
        return this.f136f;
    }

    public Location getLocation() {
        return this.f137h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.ma;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.mc.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return (Bundle) this.mb.get(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.md;
    }

    public boolean isTestDevice(Context context) {
        return this.mg.contains(dv.m814l(context));
    }
}
