package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.fq;
import com.google.android.gms.tagmanager.DataLayer;

public abstract class DriveEventService extends IntentService {
    private final String mName;

    protected DriveEventService(String name) {
        super(name);
        this.mName = name;
    }

    /* renamed from: a */
    public void m243a(ConflictEvent conflictEvent) {
        Log.w("DriveEventService", "Unhandled ConflictEvent: " + conflictEvent);
    }

    public void onChangeEvent(ChangeEvent event) {
        Log.w("DriveEventService", "Unhandled ChangeEvent: " + event);
    }

    protected final void onHandleIntent(Intent intent) {
        intent.setExtrasClassLoader(getClassLoader());
        DriveEvent driveEvent = (DriveEvent) intent.getParcelableExtra(DataLayer.EVENT_KEY);
        try {
            switch (driveEvent.getType()) {
                case 1:
                    fq.m981a(driveEvent instanceof ChangeEvent, "Unexpected event type: " + driveEvent);
                    onChangeEvent((ChangeEvent) driveEvent);
                    return;
                case 2:
                    fq.m981a(driveEvent instanceof ConflictEvent, "Unexpected event type: " + driveEvent);
                    m243a((ConflictEvent) driveEvent);
                    return;
                default:
                    Log.w(this.mName, "Unrecognized event: " + intent);
                    return;
            }
        } catch (Throwable e) {
            Log.wtf(this.mName, "Service does not implement listener for type:" + driveEvent.getType(), e);
        } catch (Throwable e2) {
            Log.w(this.mName, "Error handling event: " + intent, e2);
        }
    }
}
