package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0556l.C0909e;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C0558r implements DriveResource {
    protected final DriveId Ew;

    /* renamed from: com.google.android.gms.drive.internal.r$e */
    private static class C0915e implements MetadataResult {
        private final Metadata Fy;
        private final Status wJ;

        public C0915e(Status status, Metadata metadata) {
            this.wJ = status;
            this.Fy = metadata;
        }

        public Metadata getMetadata() {
            return this.Fy;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$b */
    private static class C1052b extends C0905c {
        private final C0128d<MetadataBufferResult> wH;

        public C1052b(C0128d<MetadataBufferResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1150a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.wH.mo1074b(new C0909e(Status.Bv, new MetadataBuffer(onListParentsResponse.fP(), null), false));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0909e(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$d */
    private static class C1053d extends C0905c {
        private final C0128d<MetadataResult> wH;

        public C1053d(C0128d<MetadataResult> c0128d) {
            this.wH = c0128d;
        }

        /* renamed from: a */
        public void mo1151a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.wH.mo1074b(new C0915e(Status.Bv, new C0906j(onMetadataResponse.fQ())));
        }

        /* renamed from: m */
        public void mo1153m(Status status) throws RemoteException {
            this.wH.mo1074b(new C0915e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$a */
    private abstract class C1097a extends C1048m<MetadataResult> {
        final /* synthetic */ C0558r Fx;

        private C1097a(C0558r c0558r) {
            this.Fx = c0558r;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3469s(status);
        }

        /* renamed from: s */
        public MetadataResult m3469s(Status status) {
            return new C0915e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$c */
    private abstract class C1098c extends C1048m<MetadataBufferResult> {
        final /* synthetic */ C0558r Fx;

        private C1098c(C0558r c0558r) {
            this.Fx = c0558r;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3471p(status);
        }

        /* renamed from: p */
        public MetadataBufferResult m3471p(Status status) {
            return new C0909e(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$f */
    private abstract class C1099f extends C1048m<MetadataResult> {
        final /* synthetic */ C0558r Fx;

        private C1099f(C0558r c0558r) {
            this.Fx = c0558r;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3473s(status);
        }

        /* renamed from: s */
        public MetadataResult m3473s(Status status) {
            return new C0915e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$1 */
    class C11541 extends C1097a {
        final /* synthetic */ C0558r Fx;

        C11541(C0558r c0558r) {
            this.Fx = c0558r;
            super();
        }

        /* renamed from: a */
        protected void m3647a(C0910n c0910n) throws RemoteException {
            c0910n.fE().mo1137a(new GetMetadataRequest(this.Fx.Ew), new C1053d(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$2 */
    class C11552 extends C1098c {
        final /* synthetic */ C0558r Fx;

        C11552(C0558r c0558r) {
            this.Fx = c0558r;
            super();
        }

        /* renamed from: a */
        protected void m3649a(C0910n c0910n) throws RemoteException {
            c0910n.fE().mo1138a(new ListParentsRequest(this.Fx.Ew), new C1052b(this));
        }
    }

    protected C0558r(DriveId driveId) {
        this.Ew = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0910n) apiClient.mo1085a(Drive.wx)).m2651a(apiClient, this.Ew, 1, listener);
    }

    public DriveId getDriveId() {
        return this.Ew;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.mo1086a(new C11541(this));
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.mo1086a(new C11552(this));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0910n) apiClient.mo1085a(Drive.wx)).m2654b(apiClient, this.Ew, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.mo1087b(new C1099f(this) {
                final /* synthetic */ C0558r Fx;

                /* renamed from: a */
                protected void m3651a(C0910n c0910n) throws RemoteException {
                    c0910n.fE().mo1143a(new UpdateMetadataRequest(this.Fx.Ew, changeSet.fD()), new C1053d(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
