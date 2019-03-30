package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class cd implements Creator<ce> {
    /* renamed from: a */
    static void m683a(ce ceVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, ceVar.versionCode);
        C0146b.m220a(parcel, 2, ceVar.og, i, false);
        C0146b.m218a(parcel, 3, ceVar.aO(), false);
        C0146b.m218a(parcel, 4, ceVar.aP(), false);
        C0146b.m218a(parcel, 5, ceVar.aQ(), false);
        C0146b.m218a(parcel, 6, ceVar.aR(), false);
        C0146b.m223a(parcel, 7, ceVar.ol, false);
        C0146b.m226a(parcel, 8, ceVar.om);
        C0146b.m223a(parcel, 9, ceVar.on, false);
        C0146b.m218a(parcel, 10, ceVar.aT(), false);
        C0146b.m235c(parcel, 11, ceVar.orientation);
        C0146b.m235c(parcel, 12, ceVar.op);
        C0146b.m223a(parcel, 13, ceVar.nO, false);
        C0146b.m220a(parcel, 14, ceVar.kK, i, false);
        C0146b.m218a(parcel, 15, ceVar.aS(), false);
        C0146b.m223a(parcel, 16, ceVar.or, false);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m684e(x0);
    }

    /* renamed from: e */
    public ce m684e(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        cb cbVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        dx dxVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    cbVar = (cb) C0145a.m177a(parcel, n, cb.CREATOR);
                    break;
                case 3:
                    iBinder = C0145a.m198o(parcel, n);
                    break;
                case 4:
                    iBinder2 = C0145a.m198o(parcel, n);
                    break;
                case 5:
                    iBinder3 = C0145a.m198o(parcel, n);
                    break;
                case 6:
                    iBinder4 = C0145a.m198o(parcel, n);
                    break;
                case 7:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 9:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 10:
                    iBinder5 = C0145a.m198o(parcel, n);
                    break;
                case 11:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 12:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 13:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 14:
                    dxVar = (dx) C0145a.m177a(parcel, n, dx.CREATOR);
                    break;
                case 15:
                    iBinder6 = C0145a.m198o(parcel, n);
                    break;
                case 16:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ce(i, cbVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, dxVar, iBinder6, str4);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: i */
    public ce[] m685i(int i) {
        return new ce[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m685i(x0);
    }
}
