package com.google.android.gms.tagmanager;

import com.badlogic.gdx.net.HttpStatus;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class aw implements bl {
    private HttpURLConnection Yh;

    aw() {
    }

    /* renamed from: a */
    private InputStream m2453a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpStatus.SC_OK) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: b */
    private void m2454b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public InputStream bD(String str) throws IOException {
        this.Yh = bE(str);
        return m2453a(this.Yh);
    }

    HttpURLConnection bE(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }

    public void close() {
        m2454b(this.Yh);
    }
}
