package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0223c.C0966j;
import com.google.android.gms.tagmanager.bg.C0383a;
import com.google.android.gms.tagmanager.cd.C0385a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class cn implements Runnable {
    private final String WJ;
    private volatile String Xg;
    private final bm Zd;
    private final String Ze;
    private bg<C0966j> Zf;
    private volatile C0413r Zg;
    private volatile String Zh;
    private final Context mContext;

    cn(Context context, String str, bm bmVar, C0413r c0413r) {
        this.mContext = context;
        this.Zd = bmVar;
        this.WJ = str;
        this.Zg = c0413r;
        this.Ze = "/r?id=" + str;
        this.Xg = this.Ze;
        this.Zh = null;
    }

    public cn(Context context, String str, C0413r c0413r) {
        this(context, str, new bm(), c0413r);
    }

    private boolean kW() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1387y("...no network connectivity");
        return false;
    }

    private void kX() {
        if (kW()) {
            bh.m1387y("Start loading resource from network ...");
            String kY = kY();
            bl kH = this.Zd.kH();
            try {
                InputStream bD = kH.bD(kY);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cq.m1424b(bD, byteArrayOutputStream);
                    C0966j b = C0966j.m2961b(byteArrayOutputStream.toByteArray());
                    bh.m1387y("Successfully loaded supplemented resource: " + b);
                    if (b.fK == null && b.fJ.length == 0) {
                        bh.m1387y("No change for container: " + this.WJ);
                    }
                    this.Zf.mo2296i(b);
                    bh.m1387y("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m1383c("Error when parsing downloaded resources from url: " + kY + " " + e.getMessage(), e);
                    this.Zf.mo2295a(C0383a.SERVER_ERROR);
                    kH.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m1388z("No data is retrieved from the given url: " + kY + ". Make sure container_id: " + this.WJ + " is correct.");
                this.Zf.mo2295a(C0383a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m1383c("Error when loading resources from url: " + kY + " " + e3.getMessage(), e3);
                this.Zf.mo2295a(C0383a.IO_ERROR);
            } finally {
                kH.close();
            }
        } else {
            this.Zf.mo2295a(C0383a.NOT_AVAILABLE);
        }
    }

    /* renamed from: a */
    void m1406a(bg<C0966j> bgVar) {
        this.Zf = bgVar;
    }

    void bJ(String str) {
        bh.m1384v("Setting previous container version: " + str);
        this.Zh = str;
    }

    void bu(String str) {
        if (str == null) {
            this.Xg = this.Ze;
            return;
        }
        bh.m1384v("Setting CTFE URL path: " + str);
        this.Xg = str;
    }

    String kY() {
        String str = this.Zg.kn() + this.Xg + "&v=a65833898";
        if (!(this.Zh == null || this.Zh.trim().equals(""))) {
            str = str + "&pv=" + this.Zh;
        }
        return cd.kT().kU().equals(C0385a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.Zf == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.Zf.kl();
        kX();
    }
}
