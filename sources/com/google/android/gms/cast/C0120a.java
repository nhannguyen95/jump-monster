package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0120a implements Creator<ApplicationMetadata> {
    /* renamed from: a */
    static void m98a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, applicationMetadata.getVersionCode());
        C0146b.m223a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0146b.m223a(parcel, 3, applicationMetadata.getName(), false);
        C0146b.m234b(parcel, 4, applicationMetadata.getImages(), false);
        C0146b.m224a(parcel, 5, applicationMetadata.xK, false);
        C0146b.m223a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0146b.m220a(parcel, 7, applicationMetadata.dz(), i, false);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m99j(x0);
    }

    /* renamed from: j */
    public ApplicationMetadata m99j(Parcel parcel) {
        Uri uri = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    list2 = C0145a.m183c(parcel, n, WebImage.CREATOR);
                    break;
                case 5:
                    list = C0145a.m172A(parcel, n);
                    break;
                case 6:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    uri = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m100w(x0);
    }

    /* renamed from: w */
    public ApplicationMetadata[] m100w(int i) {
        return new ApplicationMetadata[i];
    }
}
