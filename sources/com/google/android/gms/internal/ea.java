package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class ea extends WebViewClient {
    protected final dz lC;
    private final Object li = new Object();
    private az mF;
    private bc mP;
    private C0252a oW;
    private final HashMap<String, bb> rA = new HashMap();
    private C0303u rB;
    private cf rC;
    private boolean rD = false;
    private boolean rE;
    private ci rF;

    /* renamed from: com.google.android.gms.internal.ea$a */
    public interface C0252a {
        /* renamed from: a */
        void mo1590a(dz dzVar);
    }

    public ea(dz dzVar, boolean z) {
        this.lC = dzVar;
        this.rE = z;
    }

    /* renamed from: c */
    private static boolean m838c(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* renamed from: d */
    private void m839d(Uri uri) {
        String path = uri.getPath();
        bb bbVar = (bb) this.rA.get(path);
        if (bbVar != null) {
            Map b = dq.m788b(uri);
            if (dw.m819n(2)) {
                dw.m823y("Received GMSG: " + path);
                for (String path2 : b.keySet()) {
                    dw.m823y("  " + path2 + ": " + ((String) b.get(path2)));
                }
            }
            bbVar.mo1589b(this.lC, b);
            return;
        }
        dw.m823y("No GMSG handler found for GMSG: " + uri);
    }

    /* renamed from: a */
    public final void m840a(cb cbVar) {
        cf cfVar = null;
        boolean bL = this.lC.bL();
        C0303u c0303u = (!bL || this.lC.m829R().lT) ? this.rB : null;
        if (!bL) {
            cfVar = this.rC;
        }
        m841a(new ce(cbVar, c0303u, cfVar, this.rF, this.lC.bK()));
    }

    /* renamed from: a */
    protected void m841a(ce ceVar) {
        cc.m2968a(this.lC.getContext(), ceVar);
    }

    /* renamed from: a */
    public final void m842a(C0252a c0252a) {
        this.oW = c0252a;
    }

    /* renamed from: a */
    public void m843a(C0303u c0303u, cf cfVar, az azVar, ci ciVar, boolean z, bc bcVar) {
        m844a("/appEvent", new ay(azVar));
        m844a("/canOpenURLs", ba.mH);
        m844a("/click", ba.mI);
        m844a("/close", ba.mJ);
        m844a("/customClose", ba.mK);
        m844a("/httpTrack", ba.mL);
        m844a("/log", ba.mM);
        m844a("/open", new bd(bcVar));
        m844a("/touch", ba.mN);
        m844a("/video", ba.mO);
        this.rB = c0303u;
        this.rC = cfVar;
        this.mF = azVar;
        this.mP = bcVar;
        this.rF = ciVar;
        m848q(z);
    }

    /* renamed from: a */
    public final void m844a(String str, bb bbVar) {
        this.rA.put(str, bbVar);
    }

    /* renamed from: a */
    public final void m845a(boolean z, int i) {
        C0303u c0303u = (!this.lC.bL() || this.lC.m829R().lT) ? this.rB : null;
        m841a(new ce(c0303u, this.rC, this.rF, this.lC, z, i, this.lC.bK()));
    }

    /* renamed from: a */
    public final void m846a(boolean z, int i, String str) {
        cf cfVar = null;
        boolean bL = this.lC.bL();
        C0303u c0303u = (!bL || this.lC.m829R().lT) ? this.rB : null;
        if (!bL) {
            cfVar = this.rC;
        }
        m841a(new ce(c0303u, cfVar, this.mF, this.rF, this.lC, z, i, str, this.lC.bK(), this.mP));
    }

    /* renamed from: a */
    public final void m847a(boolean z, int i, String str, String str2) {
        boolean bL = this.lC.bL();
        C0303u c0303u = (!bL || this.lC.m829R().lT) ? this.rB : null;
        m841a(new ce(c0303u, bL ? null : this.rC, this.mF, this.rF, this.lC, z, i, str, str2, this.lC.bK(), this.mP));
    }

    public final void aM() {
        synchronized (this.li) {
            this.rD = false;
            this.rE = true;
            final cc bH = this.lC.bH();
            if (bH != null) {
                if (dv.bD()) {
                    bH.aM();
                } else {
                    dv.rp.post(new Runnable(this) {
                        final /* synthetic */ ea rH;

                        public void run() {
                            bH.aM();
                        }
                    });
                }
            }
        }
    }

    public boolean bP() {
        boolean z;
        synchronized (this.li) {
            z = this.rE;
        }
        return z;
    }

    public final void onLoadResource(WebView webView, String url) {
        dw.m823y("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m839d(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.oW != null) {
            this.oW.mo1590a(this.lC);
            this.oW = null;
        }
    }

    /* renamed from: q */
    public final void m848q(boolean z) {
        this.rD = z;
    }

    public final void reset() {
        synchronized (this.li) {
            this.rA.clear();
            this.rB = null;
            this.rC = null;
            this.oW = null;
            this.mF = null;
            this.rD = false;
            this.rE = false;
            this.mP = null;
            this.rF = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        dw.m823y("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m839d(parse);
        } else if (this.rD && webView == this.lC && m838c(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.lC.willNotDraw()) {
                dw.m824z("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    C0294l bJ = this.lC.bJ();
                    if (bJ != null && bJ.m1183a(parse)) {
                        parse = bJ.m1181a(parse, this.lC.getContext());
                    }
                    uri = parse;
                } catch (C0295m e) {
                    dw.m824z("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                m840a(new cb("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
