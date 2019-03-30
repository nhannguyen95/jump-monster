package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C0121b implements Creator<CastDevice> {
    /* renamed from: a */
    static void m101a(CastDevice castDevice, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, castDevice.getVersionCode());
        C0146b.m223a(parcel, 2, castDevice.getDeviceId(), false);
        C0146b.m223a(parcel, 3, castDevice.yb, false);
        C0146b.m223a(parcel, 4, castDevice.getFriendlyName(), false);
        C0146b.m223a(parcel, 5, castDevice.getModelName(), false);
        C0146b.m223a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0146b.m235c(parcel, 7, castDevice.getServicePort());
        C0146b.m234b(parcel, 8, castDevice.getIcons(), false);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m102k(x0);
    }

    /* renamed from: k */
    public CastDevice m102k(Parcel parcel) {
        int i = 0;
        List list = null;
        int o = C0145a.m197o(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 8:
                    list = C0145a.m183c(parcel, n, WebImage.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CastDevice(i2, str5, str4, str3, str2, str, i, list);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m103y(x0);
    }

    /* renamed from: y */
    public CastDevice[] m103y(int i) {
        return new CastDevice[i];
    }
}
