package com.google.android.gms.wallet.fragment;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.badlogic.gdx.Input.Keys;

public class Dimension {
    public static final int MATCH_PARENT = -1;
    public static final int UNIT_DIP = 1;
    public static final int UNIT_IN = 4;
    public static final int UNIT_MM = 5;
    public static final int UNIT_PT = 3;
    public static final int UNIT_PX = 0;
    public static final int UNIT_SP = 2;
    public static final int WRAP_CONTENT = -2;

    private Dimension() {
    }

    /* renamed from: a */
    public static int m1494a(long j, DisplayMetrics displayMetrics) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        switch (i) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 128:
                return TypedValue.complexToDimensionPixelSize(i2, displayMetrics);
            case Keys.CONTROL_LEFT /*129*/:
                return i2;
            default:
                throw new IllegalStateException("Unexpected unit or type: " + i);
        }
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(i2), displayMetrics));
    }

    /* renamed from: a */
    public static long m1495a(int i, float f) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return m1497f(i, Float.floatToIntBits(f));
            default:
                throw new IllegalArgumentException("Unrecognized unit: " + i);
        }
    }

    /* renamed from: a */
    public static long m1496a(TypedValue typedValue) {
        switch (typedValue.type) {
            case 5:
                return m1497f(128, typedValue.data);
            case 16:
                return cz(typedValue.data);
            default:
                throw new IllegalArgumentException("Unexpected dimension type: " + typedValue.type);
        }
    }

    public static long cz(int i) {
        if (i >= 0) {
            return m1495a(0, (float) i);
        }
        if (i == -1 || i == -2) {
            return m1497f(Keys.CONTROL_LEFT, i);
        }
        throw new IllegalArgumentException("Unexpected dimension value: " + i);
    }

    /* renamed from: f */
    private static long m1497f(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }
}
