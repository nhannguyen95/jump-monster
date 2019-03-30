package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C0526h implements C0098m {
    private static final Object sf = new Object();
    private static C0526h st;
    private final Context mContext;
    private String su;
    private boolean sv = false;
    private final Object sw = new Object();

    protected C0526h(Context context) {
        this.mContext = context;
        ce();
    }

    /* renamed from: D */
    private boolean m1582D(String str) {
        try {
            aa.m35y("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.m33w("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.m33w("Error writing to clientId file.");
            return false;
        }
    }

    public static C0526h cb() {
        C0526h c0526h;
        synchronized (sf) {
            c0526h = st;
        }
        return c0526h;
    }

    private String cc() {
        if (!this.sv) {
            synchronized (this.sw) {
                if (!this.sv) {
                    aa.m35y("Waiting for clientId to load");
                    do {
                        try {
                            this.sw.wait();
                        } catch (InterruptedException e) {
                            aa.m33w("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.sv);
                }
            }
        }
        aa.m35y("Loaded clientId");
        return this.su;
    }

    private void ce() {
        new Thread(this, "client_id_fetcher") {
            final /* synthetic */ C0526h sx;

            public void run() {
                synchronized (this.sx.sw) {
                    this.sx.su = this.sx.cf();
                    this.sx.sv = true;
                    this.sx.sw.notifyAll();
                }
            }
        }.start();
    }

    /* renamed from: n */
    public static void m1586n(Context context) {
        synchronized (sf) {
            if (st == null) {
                st = new C0526h(context);
            }
        }
    }

    /* renamed from: C */
    public boolean m1587C(String str) {
        return "&cid".equals(str);
    }

    protected String cd() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m1582D(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    String cf() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                aa.m33w("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.m33w("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m33w("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.m33w("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? cd() : str;
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? cc() : null;
    }
}
