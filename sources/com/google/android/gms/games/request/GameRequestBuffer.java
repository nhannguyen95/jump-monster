package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C0551d<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected GameRequest getEntry(int rowIndex, int numChildren) {
        return new GameRequestRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_request_id";
    }
}
