package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0076R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Creator<WalletFragmentStyle> CREATOR = new C0437c();
    Bundle acT;
    int acU;
    final int xH;

    public WalletFragmentStyle() {
        this.xH = 1;
        this.acT = new Bundle();
    }

    WalletFragmentStyle(int versionCode, Bundle attributes, int styleResourceId) {
        this.xH = versionCode;
        this.acT = attributes;
        this.acU = styleResourceId;
    }

    /* renamed from: a */
    private void m2608a(TypedArray typedArray, int i, String str) {
        if (!this.acT.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.acT.putLong(str, Dimension.m1496a(peekValue));
            }
        }
    }

    /* renamed from: a */
    private void m2609a(TypedArray typedArray, int i, String str, String str2) {
        if (!this.acT.containsKey(str) && !this.acT.containsKey(str2)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.acT.putInt(str2, peekValue.resourceId);
            } else {
                this.acT.putInt(str, peekValue.data);
            }
        }
    }

    /* renamed from: b */
    private void m2610b(TypedArray typedArray, int i, String str) {
        if (!this.acT.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.acT.putInt(str, peekValue.data);
            }
        }
    }

    /* renamed from: I */
    public void m2611I(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.acU <= 0 ? C0076R.style.WalletFragmentDefaultStyle : this.acU, C0076R.styleable.WalletFragmentStyle);
        m2608a(obtainStyledAttributes, 1, "buyButtonWidth");
        m2608a(obtainStyledAttributes, 0, "buyButtonHeight");
        m2610b(obtainStyledAttributes, 2, "buyButtonText");
        m2610b(obtainStyledAttributes, 3, "buyButtonAppearance");
        m2610b(obtainStyledAttributes, 4, "maskedWalletDetailsTextAppearance");
        m2610b(obtainStyledAttributes, 5, "maskedWalletDetailsHeaderTextAppearance");
        m2609a(obtainStyledAttributes, 6, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        m2610b(obtainStyledAttributes, 7, "maskedWalletDetailsButtonTextAppearance");
        m2609a(obtainStyledAttributes, 8, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        m2610b(obtainStyledAttributes, 9, "maskedWalletDetailsLogoTextColor");
        m2610b(obtainStyledAttributes, 10, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public int m2612a(String str, DisplayMetrics displayMetrics, int i) {
        return this.acT.containsKey(str) ? Dimension.m1494a(this.acT.getLong(str), displayMetrics) : i;
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int buyButtonAppearance) {
        this.acT.putInt("buyButtonAppearance", buyButtonAppearance);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int height) {
        this.acT.putLong("buyButtonHeight", Dimension.cz(height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int unit, float height) {
        this.acT.putLong("buyButtonHeight", Dimension.m1495a(unit, height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int buyButtonText) {
        this.acT.putInt("buyButtonText", buyButtonText);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int width) {
        this.acT.putLong("buyButtonWidth", Dimension.cz(width));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int unit, float width) {
        this.acT.putLong("buyButtonWidth", Dimension.m1495a(unit, width));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int color) {
        this.acT.remove("maskedWalletDetailsBackgroundResource");
        this.acT.putInt("maskedWalletDetailsBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int resourceId) {
        this.acT.remove("maskedWalletDetailsBackgroundColor");
        this.acT.putInt("maskedWalletDetailsBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int color) {
        this.acT.remove("maskedWalletDetailsButtonBackgroundResource");
        this.acT.putInt("maskedWalletDetailsButtonBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int resourceId) {
        this.acT.remove("maskedWalletDetailsButtonBackgroundColor");
        this.acT.putInt("maskedWalletDetailsButtonBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int resourceId) {
        this.acT.putInt("maskedWalletDetailsButtonTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int resourceId) {
        this.acT.putInt("maskedWalletDetailsHeaderTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int imageType) {
        this.acT.putInt("maskedWalletDetailsLogoImageType", imageType);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int color) {
        this.acT.putInt("maskedWalletDetailsLogoTextColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int resourceId) {
        this.acT.putInt("maskedWalletDetailsTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int id) {
        this.acU = id;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0437c.m1514a(this, dest, flags);
    }
}
