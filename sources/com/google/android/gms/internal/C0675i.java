package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.i */
public abstract class C0675i implements C0285h {
    protected MotionEvent jN;
    protected DisplayMetrics jO;
    protected C0296n jP;
    private C0297o jQ;

    protected C0675i(Context context, C0296n c0296n, C0297o c0297o) {
        this.jP = c0296n;
        this.jQ = c0297o;
        try {
            this.jO = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.jO = new DisplayMetrics();
            this.jO.density = 1.0f;
        }
    }

    /* renamed from: a */
    private String m2285a(Context context, String str, boolean z) {
        try {
            byte[] u;
            synchronized (this) {
                m2286t();
                if (z) {
                    mo3145c(context);
                } else {
                    mo3144b(context);
                }
                u = m2287u();
            }
            return u.length == 0 ? Integer.toString(5) : m2290a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* renamed from: t */
    private void m2286t() {
        this.jQ.reset();
    }

    /* renamed from: u */
    private byte[] m2287u() throws IOException {
        return this.jQ.mo1870z();
    }

    /* renamed from: a */
    public String mo1817a(Context context) {
        return m2285a(context, null, false);
    }

    /* renamed from: a */
    public String mo1818a(Context context, String str) {
        return m2285a(context, str, true);
    }

    /* renamed from: a */
    String m2290a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m2286t();
            m2292a(20, 1);
            bArr = m2287u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(256).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[256];
        new C0272f().m919a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m2295a(str, bArr3);
        }
        return this.jP.mo1685a(bArr3, true);
    }

    /* renamed from: a */
    public void mo1819a(int i, int i2, int i3) {
        if (this.jN != null) {
            this.jN.recycle();
        }
        this.jN = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.jO.density, ((float) i2) * this.jO.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    /* renamed from: a */
    protected void m2292a(int i, long j) throws IOException {
        this.jQ.mo1867b(i, j);
    }

    /* renamed from: a */
    protected void m2293a(int i, String str) throws IOException {
        this.jQ.mo1868b(i, str);
    }

    /* renamed from: a */
    public void mo1820a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jN != null) {
                this.jN.recycle();
            }
            this.jN = MotionEvent.obtain(motionEvent);
        }
    }

    /* renamed from: a */
    void m2295a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new km(str.getBytes("UTF-8")).m1123m(bArr);
    }

    /* renamed from: b */
    protected abstract void mo3144b(Context context);

    /* renamed from: c */
    protected abstract void mo3145c(Context context);
}
