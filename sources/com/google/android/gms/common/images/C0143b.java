package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.common.images.b */
public class C0143b implements Creator<WebImage> {
    /* renamed from: a */
    static void m169a(WebImage webImage, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, webImage.getVersionCode());
        C0146b.m220a(parcel, 2, webImage.getUrl(), i, false);
        C0146b.m235c(parcel, 3, webImage.getWidth());
        C0146b.m235c(parcel, 4, webImage.getHeight());
        C0146b.m212F(parcel, p);
    }

    /* renamed from: K */
    public WebImage[] m170K(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m171l(x0);
    }

    /* renamed from: l */
    public WebImage m171l(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            Uri uri2;
            int g;
            int n = C0145a.m195n(parcel);
            int i4;
            switch (C0145a.m175R(n)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C0145a.m188g(parcel, n);
                    n = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C0145a.m177a(parcel, n, Uri.CREATOR);
                    n = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C0145a.m188g(parcel, n);
                    n = i4;
                    break;
                case 4:
                    n = C0145a.m188g(parcel, n);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    n = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m170K(x0);
    }
}
