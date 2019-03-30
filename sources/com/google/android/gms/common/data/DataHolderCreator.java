package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class DataHolderCreator implements Creator<DataHolder> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m142a(DataHolder dataHolder, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m230a(parcel, 1, dataHolder.er(), false);
        C0146b.m235c(parcel, 1000, dataHolder.getVersionCode());
        C0146b.m229a(parcel, 2, dataHolder.es(), i, false);
        C0146b.m235c(parcel, 3, dataHolder.getStatusCode());
        C0146b.m217a(parcel, 4, dataHolder.getMetadata(), false);
        C0146b.m212F(parcel, p);
    }

    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int o = C0145a.m197o(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    strArr = C0145a.m209z(parcel, n);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0145a.m182b(parcel, n, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 1000:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0144a("Overread allowed size end=" + o, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.validateContents();
        return dataHolder;
    }

    public DataHolder[] newArray(int size) {
        return new DataHolder[size];
    }
}
