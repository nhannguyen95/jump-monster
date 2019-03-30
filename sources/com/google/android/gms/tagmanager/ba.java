package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import com.google.android.gms.tagmanager.cq.C0391a;
import com.google.android.gms.tagmanager.cq.C0393c;
import com.google.android.gms.tagmanager.cq.C0394d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static C0393c bG(String str) throws JSONException {
        C0969a k = m1378k(new JSONObject(str));
        C0394d lh = C0393c.lh();
        for (int i = 0; i < k.fP.length; i++) {
            lh.m1411a(C0391a.ld().m1409b(C0209b.INSTANCE_NAME.toString(), k.fP[i]).m1409b(C0209b.FUNCTION.toString(), dh.bX(C0835m.ka())).m1409b(C0835m.kb(), k.fQ[i]).lg());
        }
        return lh.lk();
    }

    /* renamed from: k */
    private static C0969a m1378k(Object obj) throws JSONException {
        return dh.m1472r(m1379l(obj));
    }

    /* renamed from: l */
    static Object m1379l(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m1379l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
