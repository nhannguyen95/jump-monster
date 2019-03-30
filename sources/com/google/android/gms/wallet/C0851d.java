package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C0851d implements SafeParcelable {
    public static final Creator<C0851d> CREATOR = new C0429e();
    LoyaltyWalletObject abg;
    private final int xH;

    C0851d() {
        this.xH = 1;
    }

    C0851d(int i, LoyaltyWalletObject loyaltyWalletObject) {
        this.xH = i;
        this.abg = loyaltyWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0429e.m1492a(this, dest, flags);
    }
}
