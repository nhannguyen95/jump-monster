package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    /* renamed from: a */
    static void m363a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, playerEntity.getPlayerId(), false);
        C0146b.m235c(parcel, 1000, playerEntity.getVersionCode());
        C0146b.m223a(parcel, 2, playerEntity.getDisplayName(), false);
        C0146b.m220a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0146b.m220a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0146b.m216a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0146b.m235c(parcel, 6, playerEntity.gh());
        C0146b.m216a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0146b.m223a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0146b.m223a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0146b.m212F(parcel, p);
    }

    public PlayerEntity[] aT(int i) {
        return new PlayerEntity[i];
    }

    public PlayerEntity ao(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
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
                    uri = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                case 5:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 6:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 8:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 9:
                    str4 = C0145a.m196n(parcel, n);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ao(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aT(x0);
    }
}
