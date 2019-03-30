package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.ea.C0252a;

public class ct implements Runnable {
    private final int kr;
    private final int ks;
    protected final dz lC;
    private final Handler oT;
    private final long oU;
    private long oV;
    private C0252a oW;
    protected boolean oX;
    protected boolean oY;

    /* renamed from: com.google.android.gms.internal.ct$a */
    protected final class C0236a extends AsyncTask<Void, Void, Boolean> {
        private final WebView oZ;
        private Bitmap pa;
        final /* synthetic */ ct pb;

        public C0236a(ct ctVar, WebView webView) {
            this.pb = ctVar;
            this.oZ = webView;
        }

        /* renamed from: a */
        protected synchronized Boolean m703a(Void... voidArr) {
            Boolean valueOf;
            int width = this.pa.getWidth();
            int height = this.pa.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.pa.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        /* renamed from: a */
        protected void m704a(Boolean bool) {
            ct.m707c(this.pb);
            if (bool.booleanValue() || this.pb.bc() || this.pb.oV <= 0) {
                this.pb.oY = bool.booleanValue();
                this.pb.oW.mo1590a(this.pb.lC);
            } else if (this.pb.oV > 0) {
                if (dw.m819n(2)) {
                    dw.m820v("Ad not detected, scheduling another run.");
                }
                this.pb.oT.postDelayed(this.pb, this.pb.oU);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return m703a((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            m704a((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.pa = Bitmap.createBitmap(this.pb.kr, this.pb.ks, Config.ARGB_8888);
            this.oZ.setVisibility(0);
            this.oZ.measure(MeasureSpec.makeMeasureSpec(this.pb.kr, 0), MeasureSpec.makeMeasureSpec(this.pb.ks, 0));
            this.oZ.layout(0, 0, this.pb.kr, this.pb.ks);
            this.oZ.draw(new Canvas(this.pa));
            this.oZ.invalidate();
        }
    }

    public ct(C0252a c0252a, dz dzVar, int i, int i2) {
        this(c0252a, dzVar, i, i2, 200, 50);
    }

    public ct(C0252a c0252a, dz dzVar, int i, int i2, long j, long j2) {
        this.oU = j;
        this.oV = j2;
        this.oT = new Handler(Looper.getMainLooper());
        this.lC = dzVar;
        this.oW = c0252a;
        this.oX = false;
        this.oY = false;
        this.ks = i2;
        this.kr = i;
    }

    /* renamed from: c */
    static /* synthetic */ long m707c(ct ctVar) {
        long j = ctVar.oV - 1;
        ctVar.oV = j;
        return j;
    }

    /* renamed from: a */
    public void m712a(cz czVar, ee eeVar) {
        this.lC.setWebViewClient(eeVar);
        this.lC.loadDataWithBaseURL(TextUtils.isEmpty(czVar.ol) ? null : dq.m796r(czVar.ol), czVar.pm, "text/html", "UTF-8", null);
    }

    /* renamed from: b */
    public void m713b(cz czVar) {
        m712a(czVar, new ee(this, this.lC, czVar.pv));
    }

    public void ba() {
        this.oT.postDelayed(this, this.oU);
    }

    public synchronized void bb() {
        this.oX = true;
    }

    public synchronized boolean bc() {
        return this.oX;
    }

    public boolean bd() {
        return this.oY;
    }

    public void run() {
        if (this.lC == null || bc()) {
            this.oW.mo1590a(this.lC);
        } else {
            new C0236a(this, this.lC).execute(new Void[0]);
        }
    }
}
