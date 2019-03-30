package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.C0923h;
import java.util.Arrays;

public class gu extends C0923h<DriveId> {
    public static final gu Gx = new gu();

    private gu() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), 4100000);
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return m3409j(dataHolder, i, i2);
    }

    /* renamed from: j */
    protected DriveId m3409j(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.getMetadata().getLong("dbInstanceId");
        String string = dataHolder.getString("resourceId", i, i2);
        if (string != null && string.startsWith("generated-android-")) {
            string = null;
        }
        return new DriveId(string, Long.valueOf(dataHolder.getLong("sqlId", i, i2)).longValue(), j);
    }
}
