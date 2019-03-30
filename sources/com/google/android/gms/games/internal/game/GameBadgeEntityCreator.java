package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    /* renamed from: a */
    static void m570a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, gameBadgeEntity.getType());
        C0146b.m235c(parcel, 1000, gameBadgeEntity.getVersionCode());
        C0146b.m223a(parcel, 2, gameBadgeEntity.getTitle(), false);
        C0146b.m223a(parcel, 3, gameBadgeEntity.getDescription(), false);
        C0146b.m220a(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        C0146b.m212F(parcel, p);
    }

    public GameBadgeEntity ar(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int o = C0145a.m197o(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    uri = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                case 1000:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public GameBadgeEntity[] bg(int i) {
        return new GameBadgeEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ar(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
