package com.google.android.gms.internal;

import com.google.android.gms.wearable.C0856a;
import com.google.android.gms.wearable.C0857c;

public class kb implements C0856a {
    private int LF;
    private C0857c adC;

    public kb(C0856a c0856a) {
        this.LF = c0856a.getType();
        this.adC = (C0857c) c0856a.lZ().freeze();
    }

    public /* synthetic */ Object freeze() {
        return me();
    }

    public int getType() {
        return this.LF;
    }

    public boolean isDataValid() {
        return true;
    }

    public C0857c lZ() {
        return this.adC;
    }

    public C0856a me() {
        return this;
    }
}
