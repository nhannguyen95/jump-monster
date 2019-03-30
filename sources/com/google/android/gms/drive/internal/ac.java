package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;

public class ac implements Creator<OnEventResponse> {
    /* renamed from: a */
    static void m255a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onEventResponse.xH);
        C0146b.m235c(parcel, 2, onEventResponse.ES);
        C0146b.m220a(parcel, 3, onEventResponse.FH, i, false);
        C0146b.m220a(parcel, 4, onEventResponse.FI, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: Q */
    public OnEventResponse m256Q(Parcel parcel) {
        ConflictEvent conflictEvent = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            ChangeEvent changeEvent2;
            int i3;
            ConflictEvent conflictEvent2;
            int n = C0145a.m195n(parcel);
            ConflictEvent conflictEvent3;
            switch (C0145a.m175R(n)) {
                case 1:
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = C0145a.m188g(parcel, n);
                    conflictEvent2 = conflictEvent3;
                    break;
                case 2:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = C0145a.m188g(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = (ChangeEvent) C0145a.m177a(parcel, n, ChangeEvent.CREATOR);
                    conflictEvent2 = conflictEvent3;
                    break;
                case 4:
                    conflictEvent2 = (ConflictEvent) C0145a.m177a(parcel, n, ConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            conflictEvent = conflictEvent2;
        }
        if (parcel.dataPosition() == o) {
            return new OnEventResponse(i2, i, changeEvent, conflictEvent);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnEventResponse[] au(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m256Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return au(x0);
    }
}
