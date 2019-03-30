package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class em {
    protected final er yY;
    private final String yZ;
    private et za;

    protected em(String str, String str2, String str3) {
        eo.m873W(str);
        this.yZ = str;
        this.yY = new er(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.yY.ab(str3);
        }
    }

    /* renamed from: U */
    public void mo1716U(String str) {
    }

    /* renamed from: a */
    public void mo1717a(long j, int i) {
    }

    /* renamed from: a */
    public final void m871a(et etVar) {
        this.za = etVar;
        if (this.za == null) {
            dF();
        }
    }

    /* renamed from: a */
    protected final void m872a(String str, long j, String str2) throws IOException {
        this.yY.m897a("Sending text message: %s to: %s", str, str2);
        this.za.mo1063a(this.yZ, str, j, str2);
    }

    protected final long dE() {
        return this.za.dD();
    }

    public void dF() {
    }

    public final String getNamespace() {
        return this.yZ;
    }
}
