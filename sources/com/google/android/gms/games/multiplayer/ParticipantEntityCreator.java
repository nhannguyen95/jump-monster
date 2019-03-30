package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    /* renamed from: a */
    static void m577a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, participantEntity.getParticipantId(), false);
        C0146b.m223a(parcel, 2, participantEntity.getDisplayName(), false);
        C0146b.m220a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0146b.m220a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0146b.m235c(parcel, 5, participantEntity.getStatus());
        C0146b.m223a(parcel, 6, participantEntity.gi(), false);
        C0146b.m226a(parcel, 7, participantEntity.isConnectedToRoom());
        C0146b.m220a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0146b.m235c(parcel, 9, participantEntity.getCapabilities());
        C0146b.m220a(parcel, 10, participantEntity.getResult(), i, false);
        C0146b.m223a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0146b.m223a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0146b.m235c(parcel, 1000, participantEntity.getVersionCode());
        C0146b.m212F(parcel, p);
    }

    public ParticipantEntity av(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 6:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0145a.m177a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 10:
                    participantResult = (ParticipantResult) C0145a.m177a(parcel, n, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 12:
                    str5 = C0145a.m196n(parcel, n);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ParticipantEntity[] bo(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return av(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bo(x0);
    }
}
