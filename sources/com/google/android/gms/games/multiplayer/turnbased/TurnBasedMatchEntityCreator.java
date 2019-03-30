package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m581a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m220a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0146b.m223a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0146b.m223a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0146b.m216a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0146b.m223a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0146b.m216a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0146b.m223a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0146b.m235c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0146b.m235c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0146b.m235c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0146b.m227a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0146b.m234b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0146b.m223a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0146b.m227a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0146b.m217a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0146b.m235c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0146b.m235c(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        C0146b.m226a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0146b.m235c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0146b.m223a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0146b.m223a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0146b.m212F(parcel, p);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 5:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 7:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 10:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 11:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                case 12:
                    bArr = C0145a.m200q(parcel, n);
                    break;
                case 13:
                    arrayList = C0145a.m183c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 15:
                    bArr2 = C0145a.m200q(parcel, n);
                    break;
                case 16:
                    i5 = C0145a.m188g(parcel, n);
                    break;
                case 17:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 18:
                    i6 = C0145a.m188g(parcel, n);
                    break;
                case 19:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 20:
                    str6 = C0145a.m196n(parcel, n);
                    break;
                case 21:
                    str7 = C0145a.m196n(parcel, n);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
