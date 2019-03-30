package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.ad.C0207a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab implements OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long lw = TimeUnit.MILLISECONDS.toNanos(100);
    private HashSet<C0310y> lA;
    private final Object li;
    private final WeakReference<dh> ll;
    private WeakReference<ViewTreeObserver> lm;
    private final WeakReference<View> ln;
    private final C0311z lo;
    private final Context lp;
    private final ad lq;
    private boolean lr;
    private final WindowManager ls;
    private final PowerManager lt;
    private final KeyguardManager lu;
    private ac lv;
    private long lx;
    private boolean ly;
    private BroadcastReceiver lz;

    /* renamed from: com.google.android.gms.internal.ab$2 */
    class C02062 extends BroadcastReceiver {
        final /* synthetic */ ab lB;

        C02062(ab abVar) {
            this.lB = abVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.lB.m604d(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.ab$1 */
    class C05781 implements C0207a {
        final /* synthetic */ ab lB;

        C05781(ab abVar) {
            this.lB = abVar;
        }

        public void ay() {
            this.lB.lr = true;
            this.lB.m604d(false);
            this.lB.ap();
        }
    }

    /* renamed from: com.google.android.gms.internal.ab$3 */
    class C05793 implements bb {
        final /* synthetic */ ab lB;

        C05793(ab abVar) {
            this.lB = abVar;
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            this.lB.m596a(dzVar, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.ab$4 */
    class C05804 implements bb {
        final /* synthetic */ ab lB;

        C05804(ab abVar) {
            this.lB = abVar;
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType"))) {
                this.lB.m602c(this.lB.lq);
                dw.m822x("Unregistered GMSG handlers for: " + this.lB.lo.ao());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ab$5 */
    class C05815 implements bb {
        final /* synthetic */ ab lB;

        C05815(ab abVar) {
            this.lB = abVar;
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            if (map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.lB.m603c(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public ab(ak akVar, dh dhVar) {
        this(akVar, dhVar, dhVar.oj.bK(), dhVar.oj, new ae(dhVar.oj.getContext(), dhVar.oj.bK()));
    }

    public ab(ak akVar, dh dhVar, dx dxVar, View view, ad adVar) {
        this.li = new Object();
        this.lx = Long.MIN_VALUE;
        this.lA = new HashSet();
        this.ll = new WeakReference(dhVar);
        this.ln = new WeakReference(view);
        this.lm = new WeakReference(null);
        this.ly = true;
        this.lo = new C0311z(Integer.toString(dhVar.hashCode()), dxVar, akVar.lS, dhVar.qs);
        this.lq = adVar;
        this.ls = (WindowManager) view.getContext().getSystemService("window");
        this.lt = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.lu = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.lp = view.getContext().getApplicationContext();
        m595a(adVar);
        this.lq.mo1591a(new C05781(this));
        m600b(this.lq);
        dw.m822x("Tracking ad unit: " + this.lo.ao());
    }

    /* renamed from: a */
    protected int m593a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* renamed from: a */
    public void m594a(ac acVar) {
        synchronized (this.li) {
            this.lv = acVar;
        }
    }

    /* renamed from: a */
    protected void m595a(ad adVar) {
        adVar.mo1594d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    /* renamed from: a */
    protected void m596a(dz dzVar, Map<String, String> map) {
        m604d(false);
    }

    /* renamed from: a */
    public void m597a(C0310y c0310y) {
        this.lA.add(c0310y);
    }

    /* renamed from: a */
    protected void m598a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        this.lq.mo1593a("AFMA_updateActiveView", jSONObject2);
    }

    /* renamed from: a */
    protected boolean m599a(View view, boolean z) {
        return view.getVisibility() == 0 && z && view.isShown() && this.lt.isScreenOn() && !this.lu.inKeyguardRestrictedInputMode();
    }

    protected void ap() {
        synchronized (this.li) {
            if (this.lz != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.lz = new C02062(this);
            this.lp.registerReceiver(this.lz, intentFilter);
        }
    }

    protected void aq() {
        synchronized (this.li) {
            if (this.lz != null) {
                this.lp.unregisterReceiver(this.lz);
                this.lz = null;
            }
        }
    }

    public void ar() {
        synchronized (this.li) {
            if (this.ly) {
                av();
                aq();
                try {
                    m598a(ax());
                } catch (Throwable e) {
                    dw.m817b("JSON Failure while processing active view data.", e);
                }
                this.ly = false;
                as();
                dw.m822x("Untracked ad unit: " + this.lo.ao());
            }
        }
    }

    protected void as() {
        if (this.lv != null) {
            this.lv.mo1587a(this);
        }
    }

    public boolean at() {
        boolean z;
        synchronized (this.li) {
            z = this.ly;
        }
        return z;
    }

    protected void au() {
        View view = (View) this.ln.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lm.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.lm = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void av() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lm.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject aw() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.lo.am()).put("activeViewJSON", this.lo.an()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.lo.al()).put("hashCode", this.lo.ao());
        return jSONObject;
    }

    protected JSONObject ax() throws JSONException {
        JSONObject aw = aw();
        aw.put("doneReasonCode", "u");
        return aw;
    }

    /* renamed from: b */
    protected void m600b(ad adVar) {
        adVar.mo1592a("/updateActiveView", new C05793(this));
        adVar.mo1592a("/activeViewPingSent", new C05804(this));
        adVar.mo1592a("/visibilityChanged", new C05815(this));
        adVar.mo1592a("/viewabilityChanged", ba.mG);
    }

    /* renamed from: c */
    protected JSONObject m601c(View view) throws JSONException {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aw = aw();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.ls.getDefaultDisplay().getWidth();
        rect2.bottom = this.ls.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        view.getLocalVisibleRect(rect4);
        aw.put("viewBox", new JSONObject().put("top", m593a(rect2.top, displayMetrics)).put("bottom", m593a(rect2.bottom, displayMetrics)).put("left", m593a(rect2.left, displayMetrics)).put("right", m593a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m593a(rect.top, displayMetrics)).put("bottom", m593a(rect.bottom, displayMetrics)).put("left", m593a(rect.left, displayMetrics)).put("right", m593a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m593a(rect3.top, displayMetrics)).put("bottom", m593a(rect3.bottom, displayMetrics)).put("left", m593a(rect3.left, displayMetrics)).put("right", m593a(rect3.right, displayMetrics))).put("localVisibleBox", new JSONObject().put("top", m593a(rect4.top, displayMetrics)).put("bottom", m593a(rect4.bottom, displayMetrics)).put("left", m593a(rect4.left, displayMetrics)).put("right", m593a(rect4.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", m599a(view, globalVisibleRect));
        return aw;
    }

    /* renamed from: c */
    protected void m602c(ad adVar) {
        adVar.mo1595e("/viewabilityChanged");
        adVar.mo1595e("/visibilityChanged");
        adVar.mo1595e("/activeViewPingSent");
        adVar.mo1595e("/updateActiveView");
    }

    /* renamed from: c */
    protected void m603c(boolean z) {
        Iterator it = this.lA.iterator();
        while (it.hasNext()) {
            ((C0310y) it.next()).mo1877a(this, z);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    protected void m604d(boolean r8) {
        /*
        r7 = this;
        r2 = r7.li;
        monitor-enter(r2);
        r0 = r7.lr;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r7.ly;	 Catch:{ all -> 0x001e }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
    L_0x000c:
        return;
    L_0x000d:
        r0 = java.lang.System.nanoTime();	 Catch:{ all -> 0x001e }
        if (r8 == 0) goto L_0x0021;
    L_0x0013:
        r3 = r7.lx;	 Catch:{ all -> 0x001e }
        r5 = lw;	 Catch:{ all -> 0x001e }
        r3 = r3 + r5;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0021;
    L_0x001c:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        throw r0;
    L_0x0021:
        r7.lx = r0;	 Catch:{ all -> 0x001e }
        r0 = r7.ll;	 Catch:{ all -> 0x001e }
        r0 = r0.get();	 Catch:{ all -> 0x001e }
        r0 = (com.google.android.gms.internal.dh) r0;	 Catch:{ all -> 0x001e }
        r1 = r7.ln;	 Catch:{ all -> 0x001e }
        r1 = r1.get();	 Catch:{ all -> 0x001e }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x001e }
        if (r1 == 0) goto L_0x0037;
    L_0x0035:
        if (r0 != 0) goto L_0x003f;
    L_0x0037:
        r0 = 1;
    L_0x0038:
        if (r0 == 0) goto L_0x0041;
    L_0x003a:
        r7.ar();	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x003f:
        r0 = 0;
        goto L_0x0038;
    L_0x0041:
        r0 = r7.m601c(r1);	 Catch:{ JSONException -> 0x0050 }
        r7.m598a(r0);	 Catch:{ JSONException -> 0x0050 }
    L_0x0048:
        r7.au();	 Catch:{ all -> 0x001e }
        r7.as();	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x0050:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.dw.m817b(r1, r0);	 Catch:{ all -> 0x001e }
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ab.d(boolean):void");
    }

    public void onGlobalLayout() {
        m604d(false);
    }

    public void onScrollChanged() {
        m604d(true);
    }
}
