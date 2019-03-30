package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0918b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.android.gms.drive.metadata.internal.i */
public class C1056i extends C0918b<String> {
    public C1056i(String str, int i) {
        super(str, i);
    }

    public static final Collection<String> ay(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* renamed from: a */
    protected void m3273a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return mo3242c(dataHolder, i, i2);
    }

    /* renamed from: c */
    protected Collection<String> mo3242c(DataHolder dataHolder, int i, int i2) {
        try {
            return C1056i.ay(dataHolder.getString(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m3277j(bundle);
    }

    /* renamed from: j */
    protected Collection<String> m3277j(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
