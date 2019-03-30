package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    /* renamed from: a */
    static void m571a(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m234b(parcel, 1, zInvitationCluster.ho(), false);
        C0146b.m235c(parcel, 1000, zInvitationCluster.getVersionCode());
        C0146b.m212F(parcel, p);
    }

    public ZInvitationCluster as(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    arrayList = C0145a.m183c(parcel, n, InvitationEntity.CREATOR);
                    break;
                case 1000:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ZInvitationCluster(i, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ZInvitationCluster[] bi(int i) {
        return new ZInvitationCluster[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return as(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bi(x0);
    }
}
