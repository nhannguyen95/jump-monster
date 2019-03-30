package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.net.HttpRequestHeader;
import com.badlogic.gdx.net.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class da implements ab {
    private final Context aac;
    private final String aat = m2515a("GoogleTagManager", "4.00", VERSION.RELEASE, m2514b(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient aau;
    private C0404a aav;

    /* renamed from: com.google.android.gms.tagmanager.da$a */
    public interface C0404a {
        /* renamed from: a */
        void mo2276a(ap apVar);

        /* renamed from: b */
        void mo2277b(ap apVar);

        /* renamed from: c */
        void mo2278c(ap apVar);
    }

    da(HttpClient httpClient, Context context, C0404a c0404a) {
        this.aac = context.getApplicationContext();
        this.aau = httpClient;
        this.aav = c0404a;
    }

    /* renamed from: a */
    private HttpEntityEnclosingRequest m2512a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest(HttpMethods.GET, url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader(HttpRequestHeader.UserAgent, this.aat);
            } catch (URISyntaxException e2) {
                e = e2;
                bh.m1388z("Exception sending hit: " + e.getClass().getSimpleName());
                bh.m1388z(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bh.m1388z("Exception sending hit: " + e.getClass().getSimpleName());
            bh.m1388z(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    /* renamed from: a */
    private void m2513a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                bh.m1387y("Error Writing hit to log...");
            }
        }
        bh.m1387y(stringBuffer.toString());
    }

    /* renamed from: b */
    static String m2514b(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    String m2515a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public boolean ch() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.aac.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1387y("...no network connectivity");
        return false;
    }

    /* renamed from: d */
    URL m2516d(ap apVar) {
        try {
            return new URL(apVar.kE());
        } catch (MalformedURLException e) {
            bh.m1385w("Error trying to parse the GTM url.");
            return null;
        }
    }

    /* renamed from: d */
    public void mo2289d(List<ap> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            ap apVar = (ap) list.get(i);
            URL d = m2516d(apVar);
            if (d == null) {
                bh.m1388z("No destination: discarding hit.");
                this.aav.mo2277b(apVar);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest a = m2512a(d);
                if (a == null) {
                    this.aav.mo2277b(apVar);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader(HttpRequestHeader.Host, httpHost.toHostString());
                    m2513a(a);
                    if (obj != null) {
                        try {
                            bn.m1396p(this.aac);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bh.m1388z("ClientProtocolException sending hit; discarding hit...");
                            this.aav.mo2277b(apVar);
                            obj2 = obj;
                        } catch (IOException e2) {
                            bh.m1388z("Exception sending hit: " + e2.getClass().getSimpleName());
                            bh.m1388z(e2.getMessage());
                            this.aav.mo2278c(apVar);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.aau.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != HttpStatus.SC_OK) {
                        bh.m1388z("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.aav.mo2278c(apVar);
                    } else {
                        this.aav.mo2276a(apVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }
}
