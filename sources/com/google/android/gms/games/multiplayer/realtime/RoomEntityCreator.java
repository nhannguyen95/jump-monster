package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    /* renamed from: a */
    static void m579a(RoomEntity roomEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, roomEntity.getRoomId(), false);
        C0146b.m235c(parcel, 1000, roomEntity.getVersionCode());
        C0146b.m223a(parcel, 2, roomEntity.getCreatorId(), false);
        C0146b.m216a(parcel, 3, roomEntity.getCreationTimestamp());
        C0146b.m235c(parcel, 4, roomEntity.getStatus());
        C0146b.m223a(parcel, 5, roomEntity.getDescription(), false);
        C0146b.m235c(parcel, 6, roomEntity.getVariant());
        C0146b.m217a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0146b.m234b(parcel, 8, roomEntity.getParticipants(), false);
        C0146b.m235c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0146b.m212F(parcel, p);
    }

    public RoomEntity ax(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int o = C0145a.m197o(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 4:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 8:
                    arrayList = C0145a.m183c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 1000:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public RoomEntity[] bq(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ax(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bq(x0);
    }
}
