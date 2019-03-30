package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0135b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C0858d;

public class ke extends C0135b implements C0858d {
    public ke(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return mf();
    }

    public String getId() {
        return getString("asset_id");
    }

    public String mc() {
        return getString("asset_key");
    }

    public C0858d mf() {
        return new kd(this);
    }
}
