package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    /* renamed from: a */
    static void m572a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m234b(parcel, 1, gameRequestCluster.hz(), false);
        C0146b.m235c(parcel, 1000, gameRequestCluster.getVersionCode());
        C0146b.m212F(parcel, p);
    }

    public GameRequestCluster at(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    arrayList = C0145a.m183c(parcel, n, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestCluster[] bl(int i) {
        return new GameRequestCluster[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return at(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bl(x0);
    }
}
