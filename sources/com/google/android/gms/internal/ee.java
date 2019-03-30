package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class ee extends WebViewClient {
    private final dz lC;
    private final String rM;
    private boolean rN = false;
    private final ct rO;

    public ee(ct ctVar, dz dzVar, String str) {
        this.rM = m853B(str);
        this.lC = dzVar;
        this.rO = ctVar;
    }

    /* renamed from: B */
    private String m853B(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                dw.m821w(e.getMessage());
            }
        }
        return str;
    }

    /* renamed from: A */
    protected boolean m854A(String str) {
        Object B = m853B(str);
        if (TextUtils.isEmpty(B)) {
            return false;
        }
        try {
            URI uri = new URI(B);
            if ("passback".equals(uri.getScheme())) {
                dw.m820v("Passback received");
                this.rO.bb();
                return true;
            } else if (TextUtils.isEmpty(this.rM)) {
                return false;
            } else {
                URI uri2 = new URI(this.rM);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!fo.equal(host, host2) || !fo.equal(path, path2)) {
                    return false;
                }
                dw.m820v("Passback received");
                this.rO.bb();
                return true;
            }
        } catch (URISyntaxException e) {
            dw.m821w(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        dw.m820v("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!m854A(url)) {
            this.lC.bI().onLoadResource(this.lC, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        dw.m820v("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.rN) {
            this.rO.ba();
            this.rN = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        dw.m820v("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!m854A(url)) {
            return this.lC.bI().shouldOverrideUrlLoading(this.lC, url);
        }
        dw.m820v("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
