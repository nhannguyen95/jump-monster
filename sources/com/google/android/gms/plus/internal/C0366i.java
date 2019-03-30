package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.i */
public class C0366i {
    private String[] Um;
    private String Un;
    private String Uo;
    private String Up;
    private PlusCommonExtras Ur;
    private final ArrayList<String> Us = new ArrayList();
    private String[] Ut;
    private String wG;

    public C0366i(Context context) {
        this.Uo = context.getPackageName();
        this.Un = context.getPackageName();
        this.Ur = new PlusCommonExtras();
        this.Us.add(Scopes.PLUS_LOGIN);
    }

    public C0366i bh(String str) {
        this.wG = str;
        return this;
    }

    /* renamed from: e */
    public C0366i m1325e(String... strArr) {
        this.Us.clear();
        this.Us.addAll(Arrays.asList(strArr));
        return this;
    }

    /* renamed from: f */
    public C0366i m1326f(String... strArr) {
        this.Ut = strArr;
        return this;
    }

    public C0366i iY() {
        this.Us.clear();
        return this;
    }

    public C0808h iZ() {
        if (this.wG == null) {
            this.wG = "<<default account>>";
        }
        return new C0808h(this.wG, (String[]) this.Us.toArray(new String[this.Us.size()]), this.Ut, this.Um, this.Un, this.Uo, this.Up, this.Ur);
    }
}
