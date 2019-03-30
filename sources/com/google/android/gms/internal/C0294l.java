package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.l */
public class C0294l {
    private String kd = "googleads.g.doubleclick.net";
    private String ke = "/pagead/ads";
    private String[] kf = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private C0285h kg;
    private final C0283g kh = new C0283g();

    public C0294l(C0285h c0285h) {
        this.kg = c0285h;
    }

    /* renamed from: a */
    private Uri m1179a(Uri uri, Context context, String str, boolean z) throws C0295m {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C0295m("Query parameter already exists: ms");
            }
            return m1180a(uri, "ms", z ? this.kg.mo1818a(context, str) : this.kg.mo1817a(context));
        } catch (UnsupportedOperationException e) {
            throw new C0295m("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m1180a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: a */
    public Uri m1181a(Uri uri, Context context) throws C0295m {
        try {
            return m1179a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0295m("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    public void m1182a(MotionEvent motionEvent) {
        this.kg.mo1820a(motionEvent);
    }

    /* renamed from: a */
    public boolean m1183a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kf) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: y */
    public C0285h m1184y() {
        return this.kg;
    }
}
