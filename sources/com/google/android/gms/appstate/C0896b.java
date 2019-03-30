package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0135b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0896b extends C0135b implements AppState {
    C0896b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public AppState dt() {
        return new C0895a(this);
    }

    public boolean equals(Object obj) {
        return C0895a.m2620a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return dt();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !ai("conflict_version");
    }

    public int hashCode() {
        return C0895a.m2619a(this);
    }

    public String toString() {
        return C0895a.m2621b(this);
    }
}
