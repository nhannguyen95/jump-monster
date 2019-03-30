package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0202a implements Creator<UserAddressRequest> {
    /* renamed from: a */
    static void m587a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, userAddressRequest.getVersionCode());
        C0146b.m234b(parcel, 2, userAddressRequest.Ny, false);
        C0146b.m212F(parcel, p);
    }

    public UserAddressRequest ay(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    list = C0145a.m183c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddressRequest(i, list);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public UserAddressRequest[] bs(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
