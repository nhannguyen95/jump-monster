package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public final class C0172c {
    private static Map<String, MetadataField<?>> FP = new HashMap();

    static {
        C0172c.m331b(gs.FR);
        C0172c.m331b(gs.Go);
        C0172c.m331b(gs.Gh);
        C0172c.m331b(gs.Gm);
        C0172c.m331b(gs.Gp);
        C0172c.m331b(gs.Gb);
        C0172c.m331b(gs.Gc);
        C0172c.m331b(gs.FZ);
        C0172c.m331b(gs.Ge);
        C0172c.m331b(gs.Gk);
        C0172c.m331b(gs.FS);
        C0172c.m331b(gs.Gj);
        C0172c.m331b(gs.FT);
        C0172c.m331b(gs.Ga);
        C0172c.m331b(gs.FU);
        C0172c.m331b(gs.FV);
        C0172c.m331b(gs.FW);
        C0172c.m331b(gs.Gg);
        C0172c.m331b(gs.Gd);
        C0172c.m331b(gs.Gi);
        C0172c.m331b(gs.Gl);
        C0172c.m331b(gs.Gq);
        C0172c.m331b(gs.Gr);
        C0172c.m331b(gs.FY);
        C0172c.m331b(gs.FX);
        C0172c.m331b(gs.Gn);
        C0172c.m331b(gs.Gf);
        C0172c.m331b(gt.Gs);
        C0172c.m331b(gt.Gu);
        C0172c.m331b(gt.Gv);
        C0172c.m331b(gt.Gw);
        C0172c.m331b(gt.Gt);
        C0172c.m331b(gv.Gy);
        C0172c.m331b(gv.Gz);
    }

    public static MetadataField<?> ax(String str) {
        return (MetadataField) FP.get(str);
    }

    /* renamed from: b */
    private static void m331b(MetadataField<?> metadataField) {
        if (FP.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        FP.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> fS() {
        return Collections.unmodifiableCollection(FP.values());
    }
}
