package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0910n;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.fq;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String EB;
    private DriveId EC;
    private String[] EQ;

    public IntentSender build(GoogleApiClient apiClient) {
        fq.m983b(this.EQ, (Object) "setMimeType(String[]) must be called on this builder before calling build()");
        fq.m981a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C0910n) apiClient.mo1085a(Drive.wx)).fE().mo1128a(new OpenFileIntentSenderRequest(this.EB, this.EQ, this.EC));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.EC = (DriveId) fq.m986f(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.EB = (String) fq.m986f(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        boolean z = mimeTypes != null && mimeTypes.length > 0;
        fq.m985b(z, (Object) "mimeTypes may not be null and must contain at least one value");
        this.EQ = mimeTypes;
        return this;
    }
}
