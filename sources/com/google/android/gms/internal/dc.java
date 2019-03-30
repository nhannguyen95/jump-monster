package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.badlogic.gdx.net.HttpResponseHeader;
import com.badlogic.gdx.net.HttpStatus;
import com.google.android.gms.internal.db.C0615a;
import com.google.android.gms.internal.ea.C0252a;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class dc extends C0615a {
    private static final Object px = new Object();
    private static dc py;
    private final Context mContext;
    private final ax pA;
    private final bf pz;

    private dc(Context context, ax axVar, bf bfVar) {
        this.mContext = context;
        this.pz = bfVar;
        this.pA = axVar;
    }

    /* renamed from: a */
    private static cz m2988a(Context context, ax axVar, bf bfVar, cx cxVar) {
        dw.m820v("Starting ad request from service.");
        bfVar.init();
        dg dgVar = new dg(context);
        if (dgVar.qk == -1) {
            dw.m820v("Device is offline.");
            return new cz(2);
        }
        final de deVar = new de(cxVar.applicationInfo.packageName);
        if (cxVar.pg.extras != null) {
            String string = cxVar.pg.extras.getString("_ad");
            if (string != null) {
                return dd.m725a(context, cxVar, string);
            }
        }
        Location a = bfVar.mo1618a(250);
        final String aH = axVar.aH();
        String a2 = dd.m726a(cxVar, dgVar, a, axVar.aI());
        if (a2 == null) {
            return new cz(0);
        }
        final C0252a p = m2992p(a2);
        final Context context2 = context;
        final cx cxVar2 = cxVar;
        dv.rp.post(new Runnable() {
            public void run() {
                dz a = dz.m828a(context2, new ak(), false, false, null, cxVar2.kK);
                a.setWillNotDraw(true);
                deVar.m737b(a);
                ea bI = a.bI();
                bI.m844a("/invalidRequest", deVar.pK);
                bI.m844a("/loadAdURL", deVar.pL);
                bI.m844a("/log", ba.mM);
                bI.m842a(p);
                dw.m820v("Loading the JS library.");
                a.loadUrl(aH);
            }
        });
        a2 = deVar.bj();
        return TextUtils.isEmpty(a2) ? new cz(deVar.getErrorCode()) : m2989a(context, cxVar.kK.rq, a2);
    }

    /* renamed from: a */
    public static cz m2989a(Context context, String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            cz czVar;
            df dfVar = new df();
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                dq.m781a(context, str, false, httpURLConnection);
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < HttpStatus.SC_OK || responseCode >= HttpStatus.SC_MULTIPLE_CHOICES) {
                    m2991a(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < HttpStatus.SC_MULTIPLE_CHOICES || responseCode >= HttpStatus.SC_BAD_REQUEST) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField(HttpResponseHeader.Location);
                    if (TextUtils.isEmpty(headerField)) {
                        dw.m824z("No location header to follow redirect.");
                        czVar = new cz(0);
                        httpURLConnection.disconnect();
                        return czVar;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        dw.m824z("Too many redirects.");
                        czVar = new cz(0);
                        httpURLConnection.disconnect();
                        return czVar;
                    }
                    dfVar.m752e(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String a = dq.m775a(new InputStreamReader(httpURLConnection.getInputStream()));
                    m2991a(url3, headerFields, a, responseCode);
                    dfVar.m751a(url3, headerFields, a);
                    czVar = dfVar.m753g(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return czVar;
                }
            }
            dw.m824z("Received error HTTP response code: " + responseCode);
            czVar = new cz(0);
            httpURLConnection.disconnect();
            return czVar;
        } catch (IOException e) {
            dw.m824z("Error while connecting to ad server: " + e.getMessage());
            return new cz(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: a */
    public static dc m2990a(Context context, ax axVar, bf bfVar) {
        dc dcVar;
        synchronized (px) {
            if (py == null) {
                py = new dc(context.getApplicationContext(), axVar, bfVar);
            }
            dcVar = py;
        }
        return dcVar;
    }

    /* renamed from: a */
    private static void m2991a(String str, Map<String, List<String>> map, String str2, int i) {
        if (dw.m819n(2)) {
            dw.m823y("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    dw.m823y("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        dw.m823y("      " + str32);
                    }
                }
            }
            dw.m823y("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    dw.m823y(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                dw.m823y("    null");
            }
            dw.m823y("  Response Code:\n    " + i + "\n}");
        }
    }

    /* renamed from: p */
    private static C0252a m2992p(final String str) {
        return new C0252a() {
            /* renamed from: a */
            public void mo1590a(dz dzVar) {
                String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", str});
                dw.m823y("About to execute: " + format);
                dzVar.loadUrl(format);
            }
        };
    }

    /* renamed from: b */
    public cz mo1684b(cx cxVar) {
        return m2988a(this.mContext, this.pA, this.pz, cxVar);
    }
}
