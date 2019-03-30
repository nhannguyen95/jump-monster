package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;

public final class RoomBuffer extends C0551d<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return m2879e(i, i2);
    }

    /* renamed from: e */
    protected Room m2879e(int i, int i2) {
        return new RoomRef(this.BB, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
