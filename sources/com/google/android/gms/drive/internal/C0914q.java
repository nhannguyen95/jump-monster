package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.q */
public class C0914q extends C0558r implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.q$d */
    private static class C0912d implements DriveFileResult {
        private final DriveFile Fv;
        private final Status wJ;

        public C0912d(Status status, DriveFile driveFile) {
            this.wJ = status;
            this.Fv = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Fv;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$e */
    private static class C0913e implements DriveFolderResult {
        private final DriveFolder Fw;
        private final Status wJ;

        public C0913e(Status status, DriveFolder driveFolder) {
            this.wJ = status;
            this.Fw = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Fw;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$a */
    private static class C1050a extends C0905c {
        private final C0128d<DriveFileResult> wH;

        public C1050a(C0128d<DriveFileResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1148a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.wH.mo1074b(new C0912d(Status.Bv, new C0911o(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0912d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$b */
    private static class C1051b extends C0905c {
        private final C0128d<DriveFolderResult> wH;

        public C1051b(C0128d<DriveFolderResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1148a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.wH.mo1074b(new C0913e(Status.Bv, new C0914q(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0913e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$c */
    private abstract class C1096c extends C1048m<DriveFolderResult> {
        final /* synthetic */ C0914q Fu;

        private C1096c(C0914q c0914q) {
            this.Fu = c0914q;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3467r(status);
        }

        /* renamed from: r */
        public DriveFolderResult m3467r(Status status) {
            return new C0913e(status, null);
        }
    }

    public C0914q(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, final MetadataChangeSet changeSet, final Contents contents) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(changeSet.getMimeType())) {
            return apiClient.mo1087b(new C1048m<DriveFileResult>(this) {
                final /* synthetic */ C0914q Fu;

                /* renamed from: a */
                protected void m3463a(C0910n c0910n) throws RemoteException {
                    contents.close();
                    c0910n.fE().mo1134a(new CreateFileRequest(this.Fu.getDriveId(), changeSet.fD(), contents), new C1050a(this));
                }

                /* renamed from: d */
                public /* synthetic */ Result mo2670d(Status status) {
                    return m3465q(status);
                }

                /* renamed from: q */
                public DriveFileResult m3465q(Status status) {
                    return new C0912d(status, null);
                }
            });
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.mo1087b(new C1096c(this) {
                final /* synthetic */ C0914q Fu;

                /* renamed from: a */
                protected void m3645a(C0910n c0910n) throws RemoteException {
                    c0910n.fE().mo1135a(new CreateFolderRequest(this.Fu.getDriveId(), changeSet.fD()), new C1051b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.m333a(query.fV());
        }
        return new C0556l().query(apiClient, addFilter.build());
    }
}
