package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.C0275b;
import com.google.android.gms.internal.ff.C0643c;
import com.google.android.gms.internal.ff.C0644d;
import com.google.android.gms.internal.ff.C0976e;
import com.google.android.gms.internal.ff.C0977g;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.ih;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0362d.C0805a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1017e extends ff<C0362d> implements GooglePlayServicesClient {
    private Person Ub;
    private final C0808h Uc;

    /* renamed from: com.google.android.gms.plus.internal.e$d */
    final class C0806d extends C0275b<C0128d<Status>> {
        final /* synthetic */ C1017e Ud;
        private final Status wJ;

        public C0806d(C1017e c1017e, C0128d<Status> c0128d, Status status) {
            this.Ud = c1017e;
            super(c1017e, c0128d);
            this.wJ = status;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2428c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2428c(C0128d<Status> c0128d) {
            if (c0128d != null) {
                c0128d.mo1074b(this.wJ);
            }
        }

        protected void dx() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$h */
    final class C0807h extends C0275b<C0128d<Status>> {
        final /* synthetic */ C1017e Ud;
        private final Status wJ;

        public C0807h(C1017e c1017e, C0128d<Status> c0128d, Status status) {
            this.Ud = c1017e;
            super(c1017e, c0128d);
            this.wJ = status;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2430c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2430c(C0128d<Status> c0128d) {
            this.Ud.disconnect();
            if (c0128d != null) {
                c0128d.mo1074b(this.wJ);
            }
        }

        protected void dx() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$c */
    final class C1015c extends C0644d<C0128d<LoadMomentsResult>> implements LoadMomentsResult {
        private final String EM;
        final /* synthetic */ C1017e Ud;
        private final String Ue;
        private MomentBuffer Uf;
        private final Status wJ;

        public C1015c(C1017e c1017e, C0128d<LoadMomentsResult> c0128d, Status status, DataHolder dataHolder, String str, String str2) {
            this.Ud = c1017e;
            super(c1017e, c0128d, dataHolder);
            this.wJ = status;
            this.EM = str;
            this.Ue = str2;
        }

        /* renamed from: a */
        protected void m3175a(C0128d<LoadMomentsResult> c0128d, DataHolder dataHolder) {
            this.Uf = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0128d.mo1074b(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.Uf;
        }

        public String getNextPageToken() {
            return this.EM;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public String getUpdated() {
            return this.Ue;
        }

        public void release() {
            if (this.Uf != null) {
                this.Uf.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$f */
    final class C1016f extends C0644d<C0128d<LoadPeopleResult>> implements LoadPeopleResult {
        private final String EM;
        final /* synthetic */ C1017e Ud;
        private PersonBuffer Ug;
        private final Status wJ;

        public C1016f(C1017e c1017e, C0128d<LoadPeopleResult> c0128d, Status status, DataHolder dataHolder, String str) {
            this.Ud = c1017e;
            super(c1017e, c0128d, dataHolder);
            this.wJ = status;
            this.EM = str;
        }

        /* renamed from: a */
        protected void m3177a(C0128d<LoadPeopleResult> c0128d, DataHolder dataHolder) {
            this.Ug = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0128d.mo1074b(this);
        }

        public String getNextPageToken() {
            return this.EM;
        }

        public PersonBuffer getPersonBuffer() {
            return this.Ug;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            if (this.Ug != null) {
                this.Ug.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$a */
    final class C1074a extends C1014a {
        private final C0128d<Status> TG;
        final /* synthetic */ C1017e Ud;

        public C1074a(C1017e c1017e, C0128d<Status> c0128d) {
            this.Ud = c1017e;
            this.TG = c0128d;
        }

        /* renamed from: Z */
        public void mo2199Z(Status status) {
            this.Ud.m2169a(new C0806d(this.Ud, this.TG, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$b */
    final class C1075b extends C1014a {
        private final C0128d<LoadMomentsResult> TG;
        final /* synthetic */ C1017e Ud;

        public C1075b(C1017e c1017e, C0128d<LoadMomentsResult> c0128d) {
            this.Ud = c1017e;
            this.TG = c0128d;
        }

        /* renamed from: a */
        public void mo2205a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Ud.m2169a(new C1015c(this.Ud, this.TG, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$e */
    final class C1076e extends C1014a {
        private final C0128d<LoadPeopleResult> TG;
        final /* synthetic */ C1017e Ud;

        public C1076e(C1017e c1017e, C0128d<LoadPeopleResult> c0128d) {
            this.Ud = c1017e;
            this.TG = c0128d;
        }

        /* renamed from: a */
        public void mo2204a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Ud.m2169a(new C1016f(this.Ud, this.TG, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$g */
    final class C1077g extends C1014a {
        private final C0128d<Status> TG;
        final /* synthetic */ C1017e Ud;

        public C1077g(C1017e c1017e, C0128d<Status> c0128d) {
            this.Ud = c1017e;
            this.TG = c0128d;
        }

        /* renamed from: e */
        public void mo2208e(int i, Bundle bundle) {
            this.Ud.m2169a(new C0807h(this.Ud, this.TG, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    public C1017e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C0808h c0808h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c0808h.iP());
        this.Uc = c0808h;
    }

    @Deprecated
    public C1017e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C0808h c0808h) {
        this(context, context.getMainLooper(), new C0643c(connectionCallbacks), new C0977g(onConnectionFailedListener), c0808h);
    }

    /* renamed from: a */
    public fk m3179a(C0128d<LoadPeopleResult> c0128d, int i, String str) {
        bT();
        Object c1076e = new C1076e(this, c0128d);
        try {
            return ((C0362d) eM()).mo2211a(c1076e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1076e.mo2204a(DataHolder.empty(8), null);
            return null;
        }
    }

    /* renamed from: a */
    protected void mo2683a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.Ub = ih.m3098i(bundle.getByteArray("loaded_person"));
        }
        super.mo2683a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void m3181a(C0128d<LoadMomentsResult> c0128d, int i, String str, Uri uri, String str2, String str3) {
        bT();
        Object c1075b = c0128d != null ? new C1075b(this, c0128d) : null;
        try {
            ((C0362d) eM()).mo2214a(c1075b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1075b.mo2205a(DataHolder.empty(8), null, null);
        }
    }

    /* renamed from: a */
    public void m3182a(C0128d<Status> c0128d, Moment moment) {
        bT();
        C0360b c1074a = c0128d != null ? new C1074a(this, c0128d) : null;
        try {
            ((C0362d) eM()).mo2216a(c1074a, gg.m2232a((ie) moment));
        } catch (Throwable e) {
            if (c1074a == null) {
                throw new IllegalStateException(e);
            }
            c1074a.mo2199Z(new Status(8, null, null));
        }
    }

    /* renamed from: a */
    public void m3183a(C0128d<LoadPeopleResult> c0128d, Collection<String> collection) {
        bT();
        C0360b c1076e = new C1076e(this, c0128d);
        try {
            ((C0362d) eM()).mo2219a(c1076e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1076e.mo2204a(DataHolder.empty(8), null);
        }
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        Bundle iX = this.Uc.iX();
        iX.putStringArray("request_visible_actions", this.Uc.iQ());
        fmVar.mo1740a(c0976e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.Uc.iT(), this.Uc.iS(), eL(), this.Uc.getAccountName(), iX);
    }

    protected C0362d aR(IBinder iBinder) {
        return C0805a.aQ(iBinder);
    }

    protected String bg() {
        return "com.google.android.gms.plus.service.START";
    }

    public boolean bg(String str) {
        return Arrays.asList(eL()).contains(str);
    }

    protected String bh() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void clearDefaultAccount() {
        bT();
        try {
            this.Ub = null;
            ((C0362d) eM()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: d */
    public void m3185d(C0128d<LoadPeopleResult> c0128d, String[] strArr) {
        m3183a((C0128d) c0128d, Arrays.asList(strArr));
    }

    public String getAccountName() {
        bT();
        try {
            return ((C0362d) eM()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        bT();
        return this.Ub;
    }

    /* renamed from: l */
    public void m3186l(C0128d<LoadMomentsResult> c0128d) {
        m3181a(c0128d, 20, null, null, null, "me");
    }

    /* renamed from: m */
    public void m3187m(C0128d<LoadPeopleResult> c0128d) {
        bT();
        Object c1076e = new C1076e(this, c0128d);
        try {
            ((C0362d) eM()).mo2211a(c1076e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1076e.mo2204a(DataHolder.empty(8), null);
        }
    }

    /* renamed from: n */
    public void m3188n(C0128d<Status> c0128d) {
        bT();
        clearDefaultAccount();
        Object c1077g = new C1077g(this, c0128d);
        try {
            ((C0362d) eM()).mo2220b(c1077g);
        } catch (RemoteException e) {
            c1077g.mo2208e(8, null);
        }
    }

    /* renamed from: o */
    public fk m3189o(C0128d<LoadPeopleResult> c0128d, String str) {
        return m3179a((C0128d) c0128d, 0, str);
    }

    /* renamed from: r */
    protected /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return aR(iBinder);
    }

    public void removeMoment(String momentId) {
        bT();
        try {
            ((C0362d) eM()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
