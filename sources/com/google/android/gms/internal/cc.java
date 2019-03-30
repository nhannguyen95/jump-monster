package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ck.C0607a;
import com.google.android.gms.internal.ea.C0252a;

public class cc extends C0607a {
    private dz lC;
    private final Activity nS;
    private ce nT;
    private cg nU;
    private C0226c nV;
    private ch nW;
    private boolean nX;
    private FrameLayout nY;
    private CustomViewCallback nZ;
    private boolean oa = false;
    private boolean ob = false;
    private RelativeLayout oc;

    /* renamed from: com.google.android.gms.internal.cc$a */
    private static final class C0224a extends Exception {
        public C0224a(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$b */
    private static final class C0225b extends RelativeLayout {
        private final dr kF;

        public C0225b(Context context, String str) {
            super(context);
            this.kF = new dr(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.kF.m800c(event);
            return false;
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$c */
    private static final class C0226c {
        public final int index;
        public final LayoutParams oe;
        public final ViewGroup of;

        public C0226c(dz dzVar) throws C0224a {
            this.oe = dzVar.getLayoutParams();
            ViewParent parent = dzVar.getParent();
            if (parent instanceof ViewGroup) {
                this.of = (ViewGroup) parent;
                this.index = this.of.indexOfChild(dzVar);
                this.of.removeView(dzVar);
                dzVar.m836p(true);
                return;
            }
            throw new C0224a("Could not get the parent of the WebView for an overlay.");
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$1 */
    class C06051 implements C0252a {
        final /* synthetic */ cc od;

        C06051(cc ccVar) {
            this.od = ccVar;
        }

        /* renamed from: a */
        public void mo1590a(dz dzVar) {
            dzVar.bG();
        }
    }

    public cc(Activity activity) {
        this.nS = activity;
    }

    /* renamed from: a */
    private static RelativeLayout.LayoutParams m2967a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    /* renamed from: a */
    public static void m2968a(Context context, ce ceVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", ceVar.kK.rt);
        ce.m2058a(intent, ceVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    private void aN() {
        if (this.nS.isFinishing() && !this.ob) {
            this.ob = true;
            if (this.nS.isFinishing()) {
                if (this.lC != null) {
                    this.lC.bF();
                    this.oc.removeView(this.lC);
                    if (this.nV != null) {
                        this.lC.m836p(false);
                        this.nV.of.addView(this.lC, this.nV.index, this.nV.oe);
                    }
                }
                if (this.nT != null && this.nT.oi != null) {
                    this.nT.oi.mo3156V();
                }
            }
        }
    }

    /* renamed from: j */
    private void m2969j(boolean z) throws C0224a {
        if (!this.nX) {
            this.nS.requestWindowFeature(1);
        }
        Window window = this.nS.getWindow();
        window.setFlags(1024, 1024);
        setRequestedOrientation(this.nT.orientation);
        if (VERSION.SDK_INT >= 11) {
            dw.m820v("Enabling hardware acceleration on the AdActivity window.");
            ds.m803a(window);
        }
        this.oc = new C0225b(this.nS, this.nT.or);
        this.oc.setBackgroundColor(-16777216);
        this.nS.setContentView(this.oc);
        mo1664N();
        boolean bP = this.nT.oj.bI().bP();
        if (z) {
            this.lC = dz.m828a(this.nS, this.nT.oj.m829R(), true, bP, null, this.nT.kK);
            this.lC.bI().m843a(null, null, this.nT.ok, this.nT.oo, true, this.nT.oq);
            this.lC.bI().m842a(new C06051(this));
            if (this.nT.nO != null) {
                this.lC.loadUrl(this.nT.nO);
            } else if (this.nT.on != null) {
                this.lC.loadDataWithBaseURL(this.nT.ol, this.nT.on, "text/html", "UTF-8", null);
            } else {
                throw new C0224a("No URL or HTML to display in ad overlay.");
            }
        }
        this.lC = this.nT.oj;
        this.lC.setContext(this.nS);
        this.lC.m832a(this);
        ViewParent parent = this.lC.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.lC);
        }
        this.oc.addView(this.lC, -1, -1);
        if (!z) {
            this.lC.bG();
        }
        m2974h(bP);
    }

    /* renamed from: N */
    public void mo1664N() {
        this.nX = true;
    }

    /* renamed from: a */
    public void m2971a(View view, CustomViewCallback customViewCallback) {
        this.nY = new FrameLayout(this.nS);
        this.nY.setBackgroundColor(-16777216);
        this.nY.addView(view, -1, -1);
        this.nS.setContentView(this.nY);
        mo1664N();
        this.nZ = customViewCallback;
    }

    public cg aK() {
        return this.nU;
    }

    public void aL() {
        if (this.nT != null) {
            setRequestedOrientation(this.nT.orientation);
        }
        if (this.nY != null) {
            this.nS.setContentView(this.oc);
            mo1664N();
            this.nY.removeAllViews();
            this.nY = null;
        }
        if (this.nZ != null) {
            this.nZ.onCustomViewHidden();
            this.nZ = null;
        }
    }

    public void aM() {
        this.oc.removeView(this.nW);
        m2974h(true);
    }

    /* renamed from: b */
    public void m2972b(int i, int i2, int i3, int i4) {
        if (this.nU != null) {
            this.nU.setLayoutParams(m2967a(i, i2, i3, i4));
        }
    }

    /* renamed from: c */
    public void m2973c(int i, int i2, int i3, int i4) {
        if (this.nU == null) {
            this.nU = new cg(this.nS, this.lC);
            this.oc.addView(this.nU, 0, m2967a(i, i2, i3, i4));
            this.lC.bI().m848q(false);
        }
    }

    public void close() {
        this.nS.finish();
    }

    /* renamed from: h */
    public void m2974h(boolean z) {
        this.nW = new ch(this.nS, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.nW.m696i(this.nT.om);
        this.oc.addView(this.nW, layoutParams);
    }

    /* renamed from: i */
    public void m2975i(boolean z) {
        if (this.nW != null) {
            this.nW.m696i(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.oa = z;
        try {
            this.nT = ce.m2057a(this.nS.getIntent());
            if (this.nT == null) {
                throw new C0224a("Could not get info for ad overlay.");
            }
            if (savedInstanceState == null) {
                if (this.nT.oi != null) {
                    this.nT.oi.mo3157W();
                }
                if (!(this.nT.op == 1 || this.nT.oh == null)) {
                    this.nT.oh.mo3154P();
                }
            }
            switch (this.nT.op) {
                case 1:
                    m2969j(false);
                    return;
                case 2:
                    this.nV = new C0226c(this.nT.oj);
                    m2969j(false);
                    return;
                case 3:
                    m2969j(true);
                    return;
                case 4:
                    if (this.oa) {
                        this.nS.finish();
                        return;
                    } else if (!bz.m679a(this.nS, this.nT.og, this.nT.oo)) {
                        this.nS.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C0224a("Could not determine ad overlay type.");
            }
        } catch (C0224a e) {
            dw.m824z(e.getMessage());
            this.nS.finish();
        }
    }

    public void onDestroy() {
        if (this.nU != null) {
            this.nU.destroy();
        }
        if (this.lC != null) {
            this.oc.removeView(this.lC);
        }
        aN();
    }

    public void onPause() {
        if (this.nU != null) {
            this.nU.pause();
        }
        aL();
        if (this.lC != null && (!this.nS.isFinishing() || this.nV == null)) {
            dq.m782a(this.lC);
        }
        aN();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.nT != null && this.nT.op == 4) {
            if (this.oa) {
                this.nS.finish();
            } else {
                this.oa = true;
            }
        }
        if (this.lC != null) {
            dq.m789b(this.lC);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.oa);
    }

    public void onStart() {
    }

    public void onStop() {
        aN();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.nS.setRequestedOrientation(requestedOrientation);
    }
}
