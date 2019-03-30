package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C0551d<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Invitation getEntry(int rowIndex, int numChildren) {
        return new InvitationRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
