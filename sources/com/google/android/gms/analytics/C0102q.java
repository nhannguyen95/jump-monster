package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.analytics.q */
class C0102q extends BroadcastReceiver {
    static final String sD = C0102q.class.getName();
    private final af sE;

    C0102q(af afVar) {
        this.sE = afVar;
    }

    /* renamed from: p */
    public static void m67p(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(sD, true);
        context.sendBroadcast(intent);
    }

    /* renamed from: o */
    public void m68o(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            af afVar = this.sE;
            if (!booleanExtra) {
                z = true;
            }
            afVar.mo1024s(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(sD)) {
            this.sE.cm();
        }
    }
}
