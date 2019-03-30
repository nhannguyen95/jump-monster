package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedGameBuffer extends C0551d<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return m2863d(i, i2);
    }

    /* renamed from: d */
    protected ExtendedGame m2863d(int i, int i2) {
        return new ExtendedGameRef(this.BB, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_game_id";
    }
}
