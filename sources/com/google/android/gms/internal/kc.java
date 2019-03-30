package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0135b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C0856a;
import com.google.android.gms.wearable.C0857c;

public final class kc extends C0135b implements C0856a {
    private final int LE;

    public kc(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.LE = i2;
    }

    public /* synthetic */ Object freeze() {
        return me();
    }

    public int getType() {
        return getInteger("event_type");
    }

    public C0857c lZ() {
        return new kg(this.BB, this.BD, this.LE);
    }

    public C0856a me() {
        return new kb(this);
    }
}
