package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new C0173f();
    final Bundle FQ;
    final int xH;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.xH = versionCode;
        this.FQ = (Bundle) fq.m986f(valueBundle);
        this.FQ.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.FQ.keySet()) {
            if (C0172c.ax(str) == null) {
                arrayList.add(str);
                Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.FQ.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    /* renamed from: a */
    public static <T> MetadataBundle m1736a(MetadataField<T> metadataField, T t) {
        MetadataBundle fT = fT();
        fT.m1739b(metadataField, t);
        return fT;
    }

    /* renamed from: a */
    public static MetadataBundle m1737a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.FQ));
    }

    public static MetadataBundle fT() {
        return new MetadataBundle(new Bundle());
    }

    /* renamed from: a */
    public <T> T m1738a(MetadataField<T> metadataField) {
        return metadataField.mo1159d(this.FQ);
    }

    /* renamed from: b */
    public <T> void m1739b(MetadataField<T> metadataField, T t) {
        if (C0172c.ax(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.mo1158a(t, this.FQ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.FQ.keySet();
        if (!keySet.equals(metadataBundle.FQ.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!fo.equal(this.FQ.get(str), metadataBundle.FQ.get(str))) {
                return false;
            }
        }
        return true;
    }

    public Set<MetadataField<?>> fU() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String ax : this.FQ.keySet()) {
            hashSet.add(C0172c.ax(ax));
        }
        return hashSet;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.FQ.keySet()) {
            i *= 31;
            i = this.FQ.get(str).hashCode() + i;
        }
        return i;
    }

    public String toString() {
        return "MetadataBundle [values=" + this.FQ + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0173f.m332a(this, dest, flags);
    }
}
