package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dz extends WebView implements DownloadListener {
    private final Object li = new Object();
    private final WindowManager ls;
    private ak nq;
    private final dx nr;
    private final C0294l oJ;
    private final ea ru;
    private final C0250a rv;
    private cc rw;
    private boolean rx;
    private boolean ry;

    /* renamed from: com.google.android.gms.internal.dz$a */
    private static class C0250a extends MutableContextWrapper {
        private Context lp;
        private Activity rz;

        public C0250a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public void setBaseContext(Context base) {
            this.lp = base.getApplicationContext();
            this.rz = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.lp);
        }

        public void startActivity(Intent intent) {
            if (this.rz != null) {
                this.rz.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.lp.startActivity(intent);
        }
    }

    private dz(C0250a c0250a, ak akVar, boolean z, boolean z2, C0294l c0294l, dx dxVar) {
        super(c0250a);
        this.rv = c0250a;
        this.nq = akVar;
        this.rx = z;
        this.oJ = c0294l;
        this.nr = dxVar;
        this.ls = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        dq.m779a((Context) c0250a, dxVar.rq, settings);
        if (VERSION.SDK_INT >= 17) {
            dt.m808a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            ds.m802a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.ru = new ec(this, z2);
        } else {
            this.ru = new ea(this, z2);
        }
        setWebViewClient(this.ru);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new ed(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new eb(this));
        }
        bM();
    }

    /* renamed from: a */
    public static dz m828a(Context context, ak akVar, boolean z, boolean z2, C0294l c0294l, dx dxVar) {
        return new dz(new C0250a(context), akVar, z, z2, c0294l, dxVar);
    }

    private void bM() {
        synchronized (this.li) {
            if (this.rx || this.nq.lT) {
                if (VERSION.SDK_INT < 14) {
                    dw.m820v("Disabling hardware acceleration on an overlay.");
                    bN();
                } else {
                    dw.m820v("Enabling hardware acceleration on an overlay.");
                    bO();
                }
            } else if (VERSION.SDK_INT < 18) {
                dw.m820v("Disabling hardware acceleration on an AdView.");
                bN();
            } else {
                dw.m820v("Enabling hardware acceleration on an AdView.");
                bO();
            }
        }
    }

    private void bN() {
        synchronized (this.li) {
            if (!this.ry && VERSION.SDK_INT >= 11) {
                ds.m806d(this);
            }
            this.ry = true;
        }
    }

    private void bO() {
        synchronized (this.li) {
            if (this.ry && VERSION.SDK_INT >= 11) {
                ds.m807e(this);
            }
            this.ry = false;
        }
    }

    /* renamed from: R */
    public ak m829R() {
        ak akVar;
        synchronized (this.li) {
            akVar = this.nq;
        }
        return akVar;
    }

    /* renamed from: a */
    public void m830a(Context context, ak akVar) {
        synchronized (this.li) {
            this.rv.setBaseContext(context);
            this.rw = null;
            this.nq = akVar;
            this.rx = false;
            dq.m789b((WebView) this);
            loadUrl("about:blank");
            this.ru.reset();
        }
    }

    /* renamed from: a */
    public void m831a(ak akVar) {
        synchronized (this.li) {
            this.nq = akVar;
            requestLayout();
        }
    }

    /* renamed from: a */
    public void m832a(cc ccVar) {
        synchronized (this.li) {
            this.rw = ccVar;
        }
    }

    /* renamed from: a */
    public void m833a(String str, Map<String, ?> map) {
        try {
            m835b(str, dq.m795p(map));
        } catch (JSONException e) {
            dw.m824z("Could not convert parameters to JSON.");
        }
    }

    /* renamed from: a */
    public void m834a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        loadUrl(stringBuilder.toString());
    }

    /* renamed from: b */
    public void m835b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        dw.m823y("Dispatching AFMA event: " + stringBuilder);
        loadUrl(stringBuilder.toString());
    }

    public void bE() {
        if (bI().bP()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.ls.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            try {
                m835b("onScreenInfoChanged", new JSONObject().put("width", displayMetrics.widthPixels).put("height", displayMetrics.heightPixels).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                dw.m817b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void bF() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nr.rq);
        m833a("onhide", hashMap);
    }

    public void bG() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nr.rq);
        m833a("onshow", hashMap);
    }

    public cc bH() {
        cc ccVar;
        synchronized (this.li) {
            ccVar = this.rw;
        }
        return ccVar;
    }

    public ea bI() {
        return this.ru;
    }

    public C0294l bJ() {
        return this.oJ;
    }

    public dx bK() {
        return this.nr;
    }

    public boolean bL() {
        boolean z;
        synchronized (this.li) {
            z = this.rx;
        }
        return z;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            dw.m820v("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.li;
        monitor-enter(r4);
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x0094 }
        if (r1 != 0) goto L_0x0016;
    L_0x0012:
        r1 = r9.rx;	 Catch:{ all -> 0x0094 }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x0094 }
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
    L_0x001a:
        return;
    L_0x001b:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x0094 }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x0094 }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x0094 }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x0094 }
        if (r2 == r6) goto L_0x002f;
    L_0x002d:
        if (r2 != r8) goto L_0x00ad;
    L_0x002f:
        r2 = r3;
    L_0x0030:
        if (r5 == r6) goto L_0x0034;
    L_0x0032:
        if (r5 != r8) goto L_0x0035;
    L_0x0034:
        r0 = r1;
    L_0x0035:
        r5 = r9.nq;	 Catch:{ all -> 0x0094 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0094 }
        if (r5 > r2) goto L_0x0041;
    L_0x003b:
        r2 = r9.nq;	 Catch:{ all -> 0x0094 }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x0094 }
        if (r2 <= r0) goto L_0x0097;
    L_0x0041:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0094 }
        r0.<init>();	 Catch:{ all -> 0x0094 }
        r2 = "Not enough space to show ad. Needs ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0094 }
        r2 = r9.nq;	 Catch:{ all -> 0x0094 }
        r2 = r2.widthPixels;	 Catch:{ all -> 0x0094 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0094 }
        r2 = "x";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0094 }
        r2 = r9.nq;	 Catch:{ all -> 0x0094 }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x0094 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0094 }
        r2 = " pixels, but only has ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0094 }
        r0 = r0.append(r3);	 Catch:{ all -> 0x0094 }
        r2 = "x";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0094 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0094 }
        r1 = " pixels.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0094 }
        r0 = r0.toString();	 Catch:{ all -> 0x0094 }
        com.google.android.gms.internal.dw.m824z(r0);	 Catch:{ all -> 0x0094 }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0094 }
        if (r0 == r7) goto L_0x008d;
    L_0x0089:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0094 }
    L_0x008d:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0094 }
    L_0x0092:
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        goto L_0x001a;
    L_0x0094:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        throw r0;
    L_0x0097:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0094 }
        if (r0 == r7) goto L_0x00a1;
    L_0x009d:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0094 }
    L_0x00a1:
        r0 = r9.nq;	 Catch:{ all -> 0x0094 }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x0094 }
        r1 = r9.nq;	 Catch:{ all -> 0x0094 }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x0094 }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0094 }
        goto L_0x0092;
    L_0x00ad:
        r2 = r0;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dz.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.oJ != null) {
            this.oJ.m1182a(event);
        }
        return super.onTouchEvent(event);
    }

    /* renamed from: p */
    public void m836p(boolean z) {
        synchronized (this.li) {
            this.rx = z;
            bM();
        }
    }

    public void setContext(Context context) {
        this.rv.setBaseContext(context);
    }
}
