package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService Yi;
    Context Yj;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String name) {
        super(name);
    }

    /* renamed from: a */
    private void m1350a(Context context, Intent intent) {
        if (this.Yi == null) {
            this.Yi = new CampaignTrackingService();
        }
        this.Yi.processIntent(context, intent);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.Yj != null ? this.Yj : getApplicationContext();
        ay.m1373c(applicationContext, stringExtra);
        m1350a(applicationContext, intent);
    }
}
