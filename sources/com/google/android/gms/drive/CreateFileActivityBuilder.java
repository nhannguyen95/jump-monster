package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0910n;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.internal.fq;
import java.io.IOException;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private Contents EA;
    private String EB;
    private DriveId EC;
    private MetadataChangeSet Ez;

    public IntentSender build(GoogleApiClient apiClient) {
        fq.m983b(this.Ez, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        fq.m983b(this.EA, (Object) "Must provide initial contents to CreateFileActivityBuilder.");
        try {
            this.EA.getParcelFileDescriptor().close();
        } catch (IOException e) {
        }
        this.EA.close();
        fq.m981a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C0910n) apiClient.mo1085a(Drive.wx)).fE().mo1127a(new CreateFileIntentSenderRequest(this.Ez.fD(), this.EA.fA(), this.EB, this.EC));
        } catch (Throwable e2) {
            throw new RuntimeException("Unable to connect Drive Play Service", e2);
        }
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.EC = (DriveId) fq.m986f(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.EB = (String) fq.m986f(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        this.EA = (Contents) fq.m986f(contents);
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.Ez = (MetadataChangeSet) fq.m986f(metadataChangeSet);
        return this;
    }
}
