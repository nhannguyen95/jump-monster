package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0078a;
import java.util.Date;
import java.util.HashSet;

public final class by {

    /* renamed from: com.google.android.gms.internal.by$1 */
    static /* synthetic */ class C02221 {
        static final /* synthetic */ int[] nL = new int[Gender.values().length];

        static {
            nM = new int[ErrorCode.values().length];
            try {
                nM[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nM[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nM[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nM[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                nL[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                nL[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                nL[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* renamed from: a */
    public static int m675a(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static AdSize m676b(ak akVar) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == akVar.width && adSizeArr[i].getHeight() == akVar.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(C0078a.m6a(akVar.width, akVar.height, akVar.lS));
    }

    /* renamed from: e */
    public static MediationAdRequest m677e(ah ahVar) {
        return new MediationAdRequest(new Date(ahVar.lH), m678g(ahVar.lI), ahVar.lJ != null ? new HashSet(ahVar.lJ) : null, ahVar.lK, ahVar.lP);
    }

    /* renamed from: g */
    public static Gender m678g(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
