package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    /* renamed from: a */
    static void m576a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m220a(parcel, 1, invitationEntity.getGame(), i, false);
        C0146b.m235c(parcel, 1000, invitationEntity.getVersionCode());
        C0146b.m223a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0146b.m216a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0146b.m235c(parcel, 4, invitationEntity.getInvitationType());
        C0146b.m220a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0146b.m234b(parcel, 6, invitationEntity.getParticipants(), false);
        C0146b.m235c(parcel, 7, invitationEntity.getVariant());
        C0146b.m235c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0146b.m212F(parcel, p);
    }

    public InvitationEntity au(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    gameEntity = (GameEntity) C0145a.m177a(parcel, n, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 4:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0145a.m177a(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0145a.m183c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 8:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public InvitationEntity[] bn(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bn(x0);
    }
}
