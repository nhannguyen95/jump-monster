package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class ad extends dc {
    private static final String ID = C0205a.ENDS_WITH.toString();

    public ad() {
        super(ID);
    }

    /* renamed from: a */
    protected boolean mo3246a(String str, String str2, Map<String, C0969a> map) {
        return str.endsWith(str2);
    }
}
