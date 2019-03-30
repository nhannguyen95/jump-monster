package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.as.C0208a;
import com.google.android.gms.internal.fq;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = as.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final as kp;

    public static final class Builder {
        private final C0208a kq = new C0208a();

        public Builder addKeyword(String keyword) {
            this.kq.m645g(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.kq.m640a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.kq.m641a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.kq.m647h(deviceId);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.kq.m642a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            fq.m983b((Object) contentUrl, (Object) "Content URL must be non-null.");
            fq.m984b(contentUrl, (Object) "Content URL must be non-empty.");
            fq.m982a(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(contentUrl.length()));
            this.kq.m648i(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.kq.m643d(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.kq.m639a(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.kq.m644f(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.kq.m649j(publisherProvidedId);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.kq.m646g(tagForChildDirectedTreatment);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.kp = new as(builder.kq);
    }

    /* renamed from: O */
    as m8O() {
        return this.kp;
    }

    public Date getBirthday() {
        return this.kp.getBirthday();
    }

    public String getContentUrl() {
        return this.kp.getContentUrl();
    }

    public int getGender() {
        return this.kp.getGender();
    }

    public Set<String> getKeywords() {
        return this.kp.getKeywords();
    }

    public Location getLocation() {
        return this.kp.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.kp.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.kp.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.kp.getNetworkExtrasBundle(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.kp.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.kp.isTestDevice(context);
    }
}
