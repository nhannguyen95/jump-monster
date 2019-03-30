package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class GameEntityCreator implements Creator<GameEntity> {
    /* renamed from: a */
    static void m361a(GameEntity gameEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, gameEntity.getApplicationId(), false);
        C0146b.m223a(parcel, 2, gameEntity.getDisplayName(), false);
        C0146b.m223a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0146b.m223a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0146b.m223a(parcel, 5, gameEntity.getDescription(), false);
        C0146b.m223a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0146b.m220a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0146b.m220a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0146b.m220a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0146b.m226a(parcel, 10, gameEntity.gb());
        C0146b.m226a(parcel, 11, gameEntity.gd());
        C0146b.m223a(parcel, 12, gameEntity.ge(), false);
        C0146b.m235c(parcel, 13, gameEntity.gf());
        C0146b.m235c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0146b.m235c(parcel, 15, gameEntity.getLeaderboardCount());
        C0146b.m226a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0146b.m226a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0146b.m235c(parcel, 1000, gameEntity.getVersionCode());
        C0146b.m223a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0146b.m223a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0146b.m226a(parcel, 21, gameEntity.isMuted());
        C0146b.m223a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0146b.m226a(parcel, 22, gameEntity.gc());
        C0146b.m212F(parcel, p);
    }

    public GameEntity[] aS(int i) {
        return new GameEntity[i];
    }

    public GameEntity an(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    str6 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    uri = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                case 10:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 11:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 12:
                    str7 = C0145a.m196n(parcel, n);
                    break;
                case 13:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 14:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 15:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                case 16:
                    z3 = C0145a.m184c(parcel, n);
                    break;
                case 17:
                    z4 = C0145a.m184c(parcel, n);
                    break;
                case 18:
                    str8 = C0145a.m196n(parcel, n);
                    break;
                case 19:
                    str9 = C0145a.m196n(parcel, n);
                    break;
                case 20:
                    str10 = C0145a.m196n(parcel, n);
                    break;
                case 21:
                    z5 = C0145a.m184c(parcel, n);
                    break;
                case 22:
                    z6 = C0145a.m184c(parcel, n);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aS(x0);
    }
}
