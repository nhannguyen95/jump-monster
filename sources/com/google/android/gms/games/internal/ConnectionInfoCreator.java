package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    /* renamed from: a */
    static void m364a(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, connectionInfo.gi(), false);
        C0146b.m235c(parcel, 1000, connectionInfo.getVersionCode());
        C0146b.m235c(parcel, 2, connectionInfo.gj());
        C0146b.m212F(parcel, p);
    }

    public ConnectionInfo[] aW(int i) {
        return new ConnectionInfo[i];
    }

    public ConnectionInfo ap(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    i = C0145a.m188g(parcel, n);
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
            return new ConnectionInfo(i2, str, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ap(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aW(x0);
    }
}
