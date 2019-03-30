package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    /* renamed from: a */
    static void m569a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m220a(parcel, 1, extendedGameEntity.hf(), i, false);
        C0146b.m235c(parcel, 1000, extendedGameEntity.getVersionCode());
        C0146b.m235c(parcel, 2, extendedGameEntity.gX());
        C0146b.m226a(parcel, 3, extendedGameEntity.gY());
        C0146b.m235c(parcel, 4, extendedGameEntity.gZ());
        C0146b.m216a(parcel, 5, extendedGameEntity.ha());
        C0146b.m216a(parcel, 6, extendedGameEntity.hb());
        C0146b.m223a(parcel, 7, extendedGameEntity.hc(), false);
        C0146b.m216a(parcel, 8, extendedGameEntity.hd());
        C0146b.m223a(parcel, 9, extendedGameEntity.he(), false);
        C0146b.m234b(parcel, 10, extendedGameEntity.gW(), false);
        C0146b.m212F(parcel, p);
    }

    public ExtendedGameEntity aq(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    gameEntity = (GameEntity) C0145a.m177a(parcel, n, GameEntity.CREATOR);
                    break;
                case 2:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 4:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 6:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 7:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    j3 = C0145a.m190i(parcel, n);
                    break;
                case 9:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 10:
                    arrayList = C0145a.m183c(parcel, n, GameBadgeEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ExtendedGameEntity[] be(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
