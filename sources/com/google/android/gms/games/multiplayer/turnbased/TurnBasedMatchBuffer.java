package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C0551d<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected TurnBasedMatch getEntry(int rowIndex, int numChildren) {
        return new TurnBasedMatchRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
