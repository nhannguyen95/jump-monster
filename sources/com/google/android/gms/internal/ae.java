package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ad.C0207a;
import com.google.android.gms.internal.ea.C0252a;
import org.json.JSONObject;

public class ae implements ad {
    private final dz lC;

    public ae(Context context, dx dxVar) {
        this.lC = dz.m828a(context, new ak(), false, false, null, dxVar);
    }

    /* renamed from: a */
    public void mo1591a(final C0207a c0207a) {
        this.lC.bI().m842a(new C0252a(this) {
            final /* synthetic */ ae lE;

            /* renamed from: a */
            public void mo1590a(dz dzVar) {
                c0207a.ay();
            }
        });
    }

    /* renamed from: a */
    public void mo1592a(String str, bb bbVar) {
        this.lC.bI().m844a(str, bbVar);
    }

    /* renamed from: a */
    public void mo1593a(String str, JSONObject jSONObject) {
        this.lC.m834a(str, jSONObject);
    }

    /* renamed from: d */
    public void mo1594d(String str) {
        this.lC.loadUrl(str);
    }

    /* renamed from: e */
    public void mo1595e(String str) {
        this.lC.bI().m844a(str, null);
    }
}
