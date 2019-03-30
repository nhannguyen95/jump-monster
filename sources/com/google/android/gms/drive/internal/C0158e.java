package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0158e implements Creator<CloseContentsRequest> {
    /* renamed from: a */
    static void m280a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, closeContentsRequest.xH);
        C0146b.m220a(parcel, 2, closeContentsRequest.EX, i, false);
        C0146b.m221a(parcel, 3, closeContentsRequest.EY, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: F */
    public CloseContentsRequest m281F(Parcel parcel) {
        Boolean bool = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            Contents contents2;
            int g;
            Boolean bool2;
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C0145a.m188g(parcel, n);
                    bool2 = bool3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) C0145a.m177a(parcel, n, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case 3:
                    bool2 = C0145a.m185d(parcel, n);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public CloseContentsRequest[] aj(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m281F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aj(x0);
    }
}
