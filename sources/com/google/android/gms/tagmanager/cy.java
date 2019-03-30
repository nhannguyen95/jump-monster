package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cy {
    /* renamed from: a */
    static void m1453a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m1454a(edit);
    }

    /* renamed from: a */
    static void m1454a(final Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new Runnable() {
                public void run() {
                    editor.commit();
                }
            }).start();
        }
    }
}
