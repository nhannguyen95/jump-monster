package com.google.ads;

import android.content.Context;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.net.HttpStatus;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(HttpStatus.SC_MULTIPLE_CHOICES, Keys.F7, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    /* renamed from: c */
    private final com.google.android.gms.ads.AdSize f94c;

    public AdSize(int width, int height) {
        this(new com.google.android.gms.ads.AdSize(width, height));
    }

    private AdSize(int width, int height, String type) {
        this(new com.google.android.gms.ads.AdSize(width, height));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f94c = adSize;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdSize)) {
            return false;
        }
        return this.f94c.equals(((AdSize) other).f94c);
    }

    public AdSize findBestSize(AdSize... options) {
        AdSize adSize = null;
        if (options != null) {
            float f = 0.0f;
            int width = getWidth();
            int height = getHeight();
            int length = options.length;
            int i = 0;
            while (i < length) {
                float f2;
                AdSize adSize2;
                AdSize adSize3 = options[i];
                int width2 = adSize3.getWidth();
                int height2 = adSize3.getHeight();
                if (isSizeAppropriate(width2, height2)) {
                    f2 = ((float) (width2 * height2)) / ((float) (width * height));
                    if (f2 > 1.0f) {
                        f2 = 1.0f / f2;
                    }
                    if (f2 > f) {
                        adSize2 = adSize3;
                        i++;
                        adSize = adSize2;
                        f = f2;
                    }
                }
                f2 = f;
                adSize2 = adSize;
                i++;
                adSize = adSize2;
                f = f2;
            }
        }
        return adSize;
    }

    public int getHeight() {
        return this.f94c.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.f94c.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.f94c.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.f94c.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.f94c.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f94c.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.f94c.isFullWidth();
    }

    public boolean isSizeAppropriate(int width, int height) {
        int width2 = getWidth();
        int height2 = getHeight();
        return ((float) width) <= ((float) width2) * 1.25f && ((float) width) >= ((float) width2) * 0.8f && ((float) height) <= ((float) height2) * 1.25f && ((float) height) >= ((float) height2) * 0.8f;
    }

    public String toString() {
        return this.f94c.toString();
    }
}
