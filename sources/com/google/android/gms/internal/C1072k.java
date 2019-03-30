package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.k */
public class C1072k extends C0996j {

    /* renamed from: com.google.android.gms.internal.k$a */
    class C0292a {
        private String ka;
        private boolean kb;
        final /* synthetic */ C1072k kc;

        public C0292a(C1072k c1072k, String str, boolean z) {
            this.kc = c1072k;
            this.ka = str;
            this.kb = z;
        }

        public String getId() {
            return this.ka;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kb;
        }
    }

    private C1072k(Context context, C0296n c0296n, C0297o c0297o) {
        super(context, c0296n, c0297o);
    }

    /* renamed from: a */
    public static C1072k m3418a(String str, Context context) {
        C0296n c0619e = new C0619e();
        C0996j.m3108a(str, context, c0619e);
        return new C1072k(context, c0619e, new C0689q(239));
    }

    /* renamed from: b */
    protected void mo3144b(Context context) {
        long j = 1;
        super.mo3144b(context);
        try {
            C0292a f = m3420f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m2292a(28, j);
                String id = f.getId();
                if (id != null) {
                    m2293a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            m2292a(28, 1);
        }
    }

    /* renamed from: f */
    C0292a m3420f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.jP.mo1685a(bArr, true);
            }
            return new C0292a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
