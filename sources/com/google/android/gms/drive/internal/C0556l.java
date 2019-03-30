package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0129a.C0127c;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.l */
public class C0556l implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.l$a */
    static class C0907a implements ContentsResult {
        private final Contents EA;
        private final Status wJ;

        public C0907a(Status status, Contents contents) {
            this.wJ = status;
            this.EA = contents;
        }

        public Contents getContents() {
            return this.EA;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$c */
    static class C0908c implements DriveIdResult {
        private final DriveId Ew;
        private final Status wJ;

        public C0908c(Status status, DriveId driveId) {
            this.wJ = status;
            this.Ew = driveId;
        }

        public DriveId getDriveId() {
            return this.Ew;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$e */
    static class C0909e implements MetadataBufferResult {
        private final MetadataBuffer Ff;
        private final boolean Fg;
        private final Status wJ;

        public C0909e(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.wJ = status;
            this.Ff = metadataBuffer;
            this.Fg = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.Ff;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$b */
    private static class C1045b extends C0905c {
        private final C0128d<DriveIdResult> wH;

        public C1045b(C0128d<DriveIdResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1151a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.wH.mo1074b(new C0908c(Status.Bv, new C0906j(onMetadataResponse.fQ()).getDriveId()));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0908c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$f */
    private static class C1046f extends C0905c {
        private final C0128d<ContentsResult> wH;

        public C1046f(C0128d<ContentsResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1146a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.wH.mo1074b(new C0907a(Status.Bv, onContentsResponse.fI()));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0907a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$h */
    static class C1047h extends C0905c {
        private final C0128d<MetadataBufferResult> wH;

        public C1047h(C0128d<MetadataBufferResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1149a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.wH.mo1074b(new C0909e(Status.Bv, new MetadataBuffer(onListEntriesResponse.fN(), null), onListEntriesResponse.fO()));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0909e(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$d */
    abstract class C1087d extends C1048m<DriveIdResult> {
        final /* synthetic */ C0556l Fc;

        C1087d(C0556l c0556l) {
            this.Fc = c0556l;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3447n(status);
        }

        /* renamed from: n */
        public DriveIdResult m3447n(Status status) {
            return new C0908c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$g */
    abstract class C1088g extends C1048m<ContentsResult> {
        final /* synthetic */ C0556l Fc;

        C1088g(C0556l c0556l) {
            this.Fc = c0556l;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3449o(status);
        }

        /* renamed from: o */
        public ContentsResult m3449o(Status status) {
            return new C0907a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$i */
    abstract class C1089i extends C1048m<MetadataBufferResult> {
        final /* synthetic */ C0556l Fc;

        C1089i(C0556l c0556l) {
            this.Fc = c0556l;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3451p(status);
        }

        /* renamed from: p */
        public MetadataBufferResult m3451p(Status status) {
            return new C0909e(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$j */
    static abstract class C1090j extends C1048m<Status> {
        C1090j() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3453f(status);
        }

        /* renamed from: f */
        public Status m3453f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$l */
    abstract class C1091l extends C1048m<Status> {
        final /* synthetic */ C0556l Fc;

        C1091l(C0556l c0556l) {
            this.Fc = c0556l;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3455f(status);
        }

        /* renamed from: f */
        public Status m3455f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$2 */
    class C11432 extends C1088g {
        final /* synthetic */ C0556l Fc;

        C11432(C0556l c0556l) {
            this.Fc = c0556l;
            super(c0556l);
        }

        /* renamed from: a */
        protected void m3625a(C0910n c0910n) throws RemoteException {
            c0910n.fE().mo1133a(new CreateContentsRequest(), new C1046f(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$5 */
    class C11465 extends C1091l {
        final /* synthetic */ C0556l Fc;

        C11465(C0556l c0556l) {
            this.Fc = c0556l;
            super(c0556l);
        }

        /* renamed from: a */
        protected void m3631a(C0910n c0910n) throws RemoteException {
            c0910n.fE().mo1144a(new al(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$k */
    static class C1147k extends C1090j {
        C1147k(GoogleApiClient googleApiClient, Status status) {
            m1654a(new C0127c(((C0910n) googleApiClient.mo1085a(Drive.wx)).getLooper()));
            m1653a((Result) status);
        }

        /* renamed from: a */
        protected void m3633a(C0910n c0910n) {
        }
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, final Contents contents) {
        return apiClient.mo1087b(new C1090j(this) {
            final /* synthetic */ C0556l Fc;

            /* renamed from: a */
            protected void m3627a(C0910n c0910n) throws RemoteException {
                c0910n.fE().mo1132a(new CloseContentsRequest(contents, false), new al(this));
            }
        });
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.mo1086a(new C1087d(this) {
            final /* synthetic */ C0556l Fc;

            /* renamed from: a */
            protected void m3629a(C0910n c0910n) throws RemoteException {
                c0910n.fE().mo1137a(new GetMetadataRequest(DriveId.aw(resourceId)), new C1045b(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId fG = ((C0910n) apiClient.mo1085a(Drive.wx)).fG();
            return fG != null ? new C0914q(fG) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0911o(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0914q(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C0914q(((C0910n) apiClient.mo1085a(Drive.wx)).fF());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.mo1086a(new C11432(this));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.mo1086a(new C1089i(this) {
                final /* synthetic */ C0556l Fc;

                /* renamed from: a */
                protected void m3623a(C0910n c0910n) throws RemoteException {
                    c0910n.fE().mo1140a(new QueryRequest(query), new C1047h(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient client) {
        return client.mo1087b(new C11465(this));
    }
}
