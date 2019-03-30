package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0172c;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;
import java.util.List;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private static final String[] EL;
    private final String EM;
    private C0903a EN;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer$a */
    private static class C0903a extends Metadata {
        private final DataHolder BB;
        private final int BE;
        private final int EO;

        public C0903a(DataHolder dataHolder, int i) {
            this.BB = dataHolder;
            this.EO = i;
            this.BE = dataHolder.m1681G(i);
        }

        /* renamed from: a */
        protected <T> T mo2677a(MetadataField<T> metadataField) {
            return metadataField.mo1156a(this.BB, this.EO, this.BE);
        }

        public Metadata fB() {
            MetadataBundle fT = MetadataBundle.fT();
            for (MetadataField a : C0172c.fS()) {
                a.mo1157a(this.BB, fT, this.EO, this.BE);
            }
            return new C0904b(fT);
        }

        public /* synthetic */ Object freeze() {
            return fB();
        }

        public boolean isDataValid() {
            return !this.BB.isClosed();
        }
    }

    static {
        List arrayList = new ArrayList();
        for (MetadataField fR : C0172c.fS()) {
            arrayList.addAll(fR.fR());
        }
        EL = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.EM = nextPageToken;
    }

    public Metadata get(int row) {
        C0903a c0903a = this.EN;
        if (c0903a != null && c0903a.EO == row) {
            return c0903a;
        }
        Metadata c0903a2 = new C0903a(this.BB, row);
        this.EN = c0903a2;
        return c0903a2;
    }

    public String getNextPageToken() {
        return this.EM;
    }
}
