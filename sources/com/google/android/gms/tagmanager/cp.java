package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C0223c.C0962f;
import com.google.android.gms.internal.it.C0995a;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.kt;
import com.google.android.gms.tagmanager.C1020o.C0842f;
import com.google.android.gms.tagmanager.bg.C0383a;
import com.google.android.gms.tagmanager.cd.C0385a;
import com.google.android.gms.tagmanager.cq.C0393c;
import com.google.android.gms.tagmanager.cq.C0397g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cp implements C0842f {
    private final String WJ;
    private bg<C0995a> Zf;
    private final ExecutorService Zm = Executors.newSingleThreadExecutor();
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp$1 */
    class C03881 implements Runnable {
        final /* synthetic */ cp Zn;

        C03881(cp cpVar) {
            this.Zn = cpVar;
        }

        public void run() {
            this.Zn.lb();
        }
    }

    cp(Context context, String str) {
        this.mContext = context;
        this.WJ = str;
    }

    /* renamed from: a */
    private C0393c m3197a(ByteArrayOutputStream byteArrayOutputStream) {
        C0393c c0393c = null;
        try {
            c0393c = ba.bG(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.m1384v("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
        } catch (JSONException e2) {
            bh.m1388z("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return c0393c;
    }

    /* renamed from: k */
    private C0393c m3198k(byte[] bArr) {
        C0393c c0393c = null;
        try {
            c0393c = cq.m1423b(C0962f.m2938a(bArr));
        } catch (ks e) {
            bh.m1388z("Resource doesn't contain a binary container");
        } catch (C0397g e2) {
            bh.m1388z("Resource doesn't contain a binary container");
        }
        return c0393c;
    }

    /* renamed from: a */
    public void mo3171a(bg<C0995a> bgVar) {
        this.Zf = bgVar;
    }

    /* renamed from: b */
    public void mo3172b(final C0995a c0995a) {
        this.Zm.execute(new Runnable(this) {
            final /* synthetic */ cp Zn;

            public void run() {
                this.Zn.m3201c(c0995a);
            }
        });
    }

    /* renamed from: c */
    boolean m3201c(C0995a c0995a) {
        boolean z = false;
        File lc = lc();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(lc);
            try {
                fileOutputStream.write(kt.m1170d(c0995a));
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    bh.m1388z("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                bh.m1388z("Error writing resource to disk. Removing resource from disk.");
                lc.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    bh.m1388z("error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    bh.m1388z("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            bh.m1385w("Error opening resource file for writing");
        }
        return z;
    }

    public C0393c ca(int i) {
        bh.m1387y("Atttempting to load container from resource ID " + i);
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            cq.m1424b(openRawResource, byteArrayOutputStream);
            C0393c a = m3197a(byteArrayOutputStream);
            return a != null ? a : m3198k(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            bh.m1388z("Error reading default container resource with ID " + i);
            return null;
        } catch (NotFoundException e2) {
            bh.m1388z("No default container resource found.");
            return null;
        }
    }

    public void km() {
        this.Zm.execute(new C03881(this));
    }

    void lb() {
        if (this.Zf == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.Zf.kl();
        bh.m1387y("Start loading resource from disk ...");
        if ((cd.kT().kU() == C0385a.CONTAINER || cd.kT().kU() == C0385a.CONTAINER_DEBUG) && this.WJ.equals(cd.kT().getContainerId())) {
            this.Zf.mo2295a(C0383a.NOT_AVAILABLE);
            return;
        }
        try {
            InputStream fileInputStream = new FileInputStream(lc());
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                cq.m1424b(fileInputStream, byteArrayOutputStream);
                this.Zf.mo2296i(C0995a.m3101l(byteArrayOutputStream.toByteArray()));
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    bh.m1388z("error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                bh.m1388z("error reading resource from disk");
                this.Zf.mo2295a(C0383a.IO_ERROR);
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    bh.m1388z("error closing stream for reading resource from disk");
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    bh.m1388z("error closing stream for reading resource from disk");
                }
                throw th;
            }
            bh.m1387y("Load resource from disk finished.");
        } catch (FileNotFoundException e5) {
            bh.m1384v("resource not on disk");
            this.Zf.mo2295a(C0383a.NOT_AVAILABLE);
        }
    }

    File lc() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.WJ);
    }

    public synchronized void release() {
        this.Zm.shutdown();
    }
}
