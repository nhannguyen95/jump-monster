package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0556l.C0907a;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0911o extends C0558r implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.o$c */
    private static class C1049c extends C0905c {
        private final DownloadProgressListener Ft;
        private final C0128d<ContentsResult> wH;

        public C1049c(C0128d<ContentsResult> c0128d, DownloadProgressListener downloadProgressListener) {
            this.wH = c0128d;
            this.Ft = downloadProgressListener;
        }

        /* renamed from: a */
        public void mo1146a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.wH.mo1074b(new C0907a(Status.Bv, onContentsResponse.fI()));
        }

        /* renamed from: a */
        public void mo1147a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.Ft != null) {
                this.Ft.onProgress(onDownloadProgressResponse.fJ(), onDownloadProgressResponse.fK());
            }
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0907a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$a */
    private abstract class C1092a extends C1048m<Status> {
        final /* synthetic */ C0911o Fr;

        private C1092a(C0911o c0911o) {
            this.Fr = c0911o;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3457f(status);
        }

        /* renamed from: f */
        public Status m3457f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$b */
    private abstract class C1093b extends C1048m<Status> {
        final /* synthetic */ C0911o Fr;

        private C1093b(C0911o c0911o) {
            this.Fr = c0911o;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3459f(status);
        }

        /* renamed from: f */
        public Status m3459f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$d */
    private abstract class C1094d extends C1048m<ContentsResult> {
        final /* synthetic */ C0911o Fr;

        private C1094d(C0911o c0911o) {
            this.Fr = c0911o;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3461o(status);
        }

        /* renamed from: o */
        public ContentsResult m3461o(Status status) {
            return new C0907a(status, null);
        }
    }

    public C0911o(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents) {
        if (contents != null) {
            return apiClient.mo1087b(new C1093b(this) {
                final /* synthetic */ C0911o Fr;

                /* renamed from: a */
                protected void m3641a(C0910n c0910n) throws RemoteException {
                    contents.close();
                    c0910n.fE().mo1132a(new CloseContentsRequest(contents, true), new al(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents, final MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.mo1087b(new C1092a(this) {
                final /* synthetic */ C0911o Fr;

                /* renamed from: a */
                protected void m3643a(C0910n c0910n) throws RemoteException {
                    contents.close();
                    c0910n.fE().mo1131a(new CloseContentsAndUpdateMetadataRequest(this.Fr.Ew, changeSet.fD(), contents), new al(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, final int mode, final DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.mo1086a(new C1094d(this) {
                final /* synthetic */ C0911o Fr;

                /* renamed from: a */
                protected void m3639a(C0910n c0910n) throws RemoteException {
                    c0910n.fE().mo1139a(new OpenContentsRequest(this.Fr.getDriveId(), mode), new C1049c(this, listener));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
