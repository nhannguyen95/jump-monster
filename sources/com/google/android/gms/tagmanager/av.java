package com.google.android.gms.tagmanager;

import com.badlogic.gdx.net.HttpStatus;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class av implements bl {
    private HttpClient Yg;

    av() {
    }

    /* renamed from: a */
    private InputStream m2451a(HttpClient httpClient, HttpResponse httpResponse) throws IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            bh.m1387y("Success response");
            return httpResponse.getEntity().getContent();
        }
        String str = "Bad response: " + statusCode;
        if (statusCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: a */
    private void m2452a(HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public InputStream bD(String str) throws IOException {
        this.Yg = kF();
        return m2451a(this.Yg, this.Yg.execute(new HttpGet(str)));
    }

    public void close() {
        m2452a(this.Yg);
    }

    HttpClient kF() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        return new DefaultHttpClient(basicHttpParams);
    }
}
