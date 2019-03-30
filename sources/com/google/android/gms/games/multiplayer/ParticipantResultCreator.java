package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m578a(ParticipantResult participantResult, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, participantResult.getParticipantId(), false);
        C0146b.m235c(parcel, 1000, participantResult.getVersionCode());
        C0146b.m235c(parcel, 2, participantResult.getResult());
        C0146b.m235c(parcel, 3, participantResult.getPlacing());
        C0146b.m212F(parcel, p);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 1000:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ParticipantResult[] newArray(int size) {
        return new ParticipantResult[size];
    }
}
