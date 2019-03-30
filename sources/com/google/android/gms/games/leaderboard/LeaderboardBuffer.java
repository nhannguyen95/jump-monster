package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C0551d<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Leaderboard getEntry(int rowIndex, int numChildren) {
        return new LeaderboardRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
