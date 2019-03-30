package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m582a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m220a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0146b.m235c(parcel, 1000, gameRequestEntity.getVersionCode());
        C0146b.m220a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0146b.m227a(parcel, 3, gameRequestEntity.getData(), false);
        C0146b.m223a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0146b.m234b(parcel, 5, gameRequestEntity.getRecipients(), false);
        C0146b.m235c(parcel, 7, gameRequestEntity.getType());
        C0146b.m216a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0146b.m216a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0146b.m217a(parcel, 11, gameRequestEntity.hK(), false);
        C0146b.m235c(parcel, 12, gameRequestEntity.getStatus());
        C0146b.m212F(parcel, p);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    gameEntity = (GameEntity) C0145a.m177a(parcel, n, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) C0145a.m177a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = C0145a.m200q(parcel, n);
                    break;
                case 4:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    arrayList = C0145a.m183c(parcel, n, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 9:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 10:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 11:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 12:
                    i3 = C0145a.m188g(parcel, n);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
