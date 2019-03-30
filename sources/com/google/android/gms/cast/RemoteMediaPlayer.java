package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C1044a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.es;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final Object li = new Object();
    private final es yE = new C08981(this);
    private final C0541a yF = new C0541a(this);
    private OnMetadataUpdatedListener yG;
    private OnStatusUpdatedListener yH;

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a */
    private class C0541a implements et {
        final /* synthetic */ RemoteMediaPlayer yI;
        private GoogleApiClient yS;
        private long yT = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a$a */
        private final class C0540a implements ResultCallback<Status> {
            private final long yU;
            final /* synthetic */ C0541a yV;

            C0540a(C0541a c0541a, long j) {
                this.yV = c0541a;
                this.yU = j;
            }

            /* renamed from: i */
            public void m1638i(Status status) {
                if (!status.isSuccess()) {
                    this.yV.yI.yE.mo1717a(this.yU, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m1638i((Status) x0);
            }
        }

        public C0541a(RemoteMediaPlayer remoteMediaPlayer) {
            this.yI = remoteMediaPlayer;
        }

        /* renamed from: a */
        public void mo1063a(String str, String str2, long j, String str3) throws IOException {
            if (this.yS == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.yS, str, str2).setResultCallback(new C0540a(this, j));
        }

        /* renamed from: b */
        public void m1640b(GoogleApiClient googleApiClient) {
            this.yS = googleApiClient;
        }

        public long dD() {
            long j = this.yT + 1;
            this.yT = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$1 */
    class C08981 extends es {
        final /* synthetic */ RemoteMediaPlayer yI;

        C08981(RemoteMediaPlayer remoteMediaPlayer) {
            this.yI = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.yI.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.yI.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$c */
    private static final class C0900c implements MediaChannelResult {
        private final Status wJ;
        private final JSONObject yn;

        C0900c(Status status, JSONObject jSONObject) {
            this.wJ = status;
            this.yn = jSONObject;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$b */
    private static abstract class C1086b extends C1044a<MediaChannelResult> {
        eu yW = new C05421(this);

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$b$1 */
        class C05421 implements eu {
            final /* synthetic */ C1086b yX;

            C05421(C1086b c1086b) {
                this.yX = c1086b;
            }

            /* renamed from: a */
            public void mo1065a(long j, int i, JSONObject jSONObject) {
                this.yX.m1653a(new C0900c(new Status(i), jSONObject));
            }

            /* renamed from: l */
            public void mo1066l(long j) {
                this.yX.m1653a(this.yX.m3445j(new Status(4)));
            }
        }

        C1086b() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3445j(status);
        }

        /* renamed from: j */
        public MediaChannelResult m3445j(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ C1086b yX;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public RemoteMediaPlayer() {
        this.yE.m871a(this.yF);
    }

    private void onMetadataUpdated() {
        if (this.yG != null) {
            this.yG.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.yH != null) {
            this.yH.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.li) {
            approximateStreamPosition = this.yE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.li) {
            mediaInfo = this.yE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.li) {
            mediaStatus = this.yE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.yE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.li) {
            streamDuration = this.yE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3607a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(googleApiClient);
                    try {
                        this.yI.yE.m2135a(this.yW, mediaInfo2, z, j, jSONObject);
                        this.yI.yF.m1640b(null);
                    } catch (IOException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.yE.mo1716U(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3609a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(apiClient);
                    try {
                        this.yI.yE.m2136a(this.yW, customData);
                        this.yI.yF.m1640b(null);
                    } catch (IOException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3613a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(apiClient);
                    try {
                        this.yI.yE.m2140c(this.yW, customData);
                        this.yI.yF.m1640b(null);
                    } catch (IOException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3621a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(apiClient);
                    try {
                        this.yI.yE.m2132a(this.yW);
                        this.yI.yF.m1640b(null);
                    } catch (IOException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3615a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(googleApiClient);
                    try {
                        this.yI.yE.m2134a(this.yW, j, i, jSONObject);
                        this.yI.yF.m1640b(null);
                    } catch (IOException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.yG = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.yH = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3619a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(apiClient);
                    try {
                        this.yI.yE.m2137a(this.yW, muteState, customData);
                        this.yI.yF.m1640b(null);
                    } catch (IllegalStateException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (IOException e2) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3617a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(googleApiClient);
                    try {
                        this.yI.yE.m2133a(this.yW, d, jSONObject);
                        this.yI.yF.m1640b(null);
                    } catch (IllegalStateException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (IllegalArgumentException e2) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (IOException e3) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo1087b(new C1086b(this) {
            final /* synthetic */ RemoteMediaPlayer yI;

            /* renamed from: a */
            protected void m3611a(en enVar) {
                synchronized (this.yI.li) {
                    this.yI.yF.m1640b(apiClient);
                    try {
                        this.yI.yE.m2139b(this.yW, customData);
                        this.yI.yF.m1640b(null);
                    } catch (IOException e) {
                        m1653a(m3445j(new Status(1)));
                        this.yI.yF.m1640b(null);
                    } catch (Throwable th) {
                        this.yI.yF.m1640b(null);
                    }
                }
            }
        });
    }
}
