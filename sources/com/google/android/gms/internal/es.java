package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class es extends em {
    private static final String NAMESPACE = eo.m874X("com.google.cast.media");
    private static final long zG = TimeUnit.HOURS.toMillis(24);
    private static final long zH = TimeUnit.HOURS.toMillis(24);
    private static final long zI = TimeUnit.HOURS.toMillis(24);
    private static final long zJ = TimeUnit.SECONDS.toMillis(1);
    private final Handler mHandler;
    private long zK;
    private MediaStatus zL;
    private final ev zM;
    private final ev zN;
    private final ev zO;
    private final ev zP;
    private final ev zQ;
    private final ev zR;
    private final ev zS;
    private final ev zT;
    private final Runnable zU;
    private boolean zV;

    /* renamed from: com.google.android.gms.internal.es$a */
    private class C0265a implements Runnable {
        final /* synthetic */ es zW;

        private C0265a(es esVar) {
            this.zW = esVar;
        }

        public void run() {
            boolean z = false;
            this.zW.zV = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zW.zM.m908d(elapsedRealtime, 3);
            this.zW.zN.m908d(elapsedRealtime, 3);
            this.zW.zO.m908d(elapsedRealtime, 3);
            this.zW.zP.m908d(elapsedRealtime, 3);
            this.zW.zQ.m908d(elapsedRealtime, 3);
            this.zW.zR.m908d(elapsedRealtime, 3);
            this.zW.zS.m908d(elapsedRealtime, 3);
            this.zW.zT.m908d(elapsedRealtime, 3);
            synchronized (ev.Ab) {
                if (this.zW.zM.dU() || this.zW.zQ.dU() || this.zW.zR.dU() || this.zW.zS.dU() || this.zW.zT.dU()) {
                    z = true;
                }
            }
            this.zW.m2130w(z);
        }
    }

    public es() {
        this(null);
    }

    public es(String str) {
        super(NAMESPACE, "MediaControlChannel", str);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zU = new C0265a();
        this.zM = new ev(zH);
        this.zN = new ev(zG);
        this.zO = new ev(zG);
        this.zP = new ev(zG);
        this.zQ = new ev(zI);
        this.zR = new ev(zG);
        this.zS = new ev(zG);
        this.zT = new ev(zG);
        dS();
    }

    /* renamed from: a */
    private void m2120a(long j, JSONObject jSONObject) throws JSONException {
        int i = 1;
        boolean n = this.zM.m909n(j);
        int i2 = (!this.zQ.dU() || this.zQ.m909n(j)) ? 0 : 1;
        if ((!this.zR.dU() || this.zR.m909n(j)) && (!this.zS.dU() || this.zS.m909n(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (n || this.zL == null) {
            this.zL = new MediaStatus(jSONObject);
            this.zK = SystemClock.elapsedRealtime();
            i2 = 7;
        } else {
            i2 = this.zL.m97a(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.zK = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.zK = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        this.zM.m907c(j, 0);
        this.zN.m907c(j, 0);
        this.zO.m907c(j, 0);
        this.zP.m907c(j, 0);
        this.zQ.m907c(j, 0);
        this.zR.m907c(j, 0);
        this.zS.m907c(j, 0);
        this.zT.m907c(j, 0);
    }

    private void dS() {
        m2130w(false);
        this.zK = 0;
        this.zL = null;
        this.zM.clear();
        this.zQ.clear();
        this.zR.clear();
    }

    /* renamed from: w */
    private void m2130w(boolean z) {
        if (this.zV != z) {
            this.zV = z;
            if (z) {
                this.mHandler.postDelayed(this.zU, zJ);
            } else {
                this.mHandler.removeCallbacks(this.zU);
            }
        }
    }

    /* renamed from: U */
    public final void mo1716U(String str) {
        this.yY.m899b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    m2120a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zL = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.zT.m907c(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.yY.m901d("received unexpected error: Invalid Player State.", new Object[0]);
                jSONObject = jSONObject.optJSONObject("customData");
                this.zM.m906b(optLong, 1, jSONObject);
                this.zN.m906b(optLong, 1, jSONObject);
                this.zO.m906b(optLong, 1, jSONObject);
                this.zP.m906b(optLong, 1, jSONObject);
                this.zQ.m906b(optLong, 1, jSONObject);
                this.zR.m906b(optLong, 1, jSONObject);
                this.zS.m906b(optLong, 1, jSONObject);
                this.zT.m906b(optLong, 1, jSONObject);
            } else if (string.equals("LOAD_FAILED")) {
                this.zM.m906b(optLong, 1, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zM.m906b(optLong, 2, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.yY.m901d("received unexpected error: Invalid Request.", new Object[0]);
                jSONObject = jSONObject.optJSONObject("customData");
                this.zM.m906b(optLong, 1, jSONObject);
                this.zN.m906b(optLong, 1, jSONObject);
                this.zO.m906b(optLong, 1, jSONObject);
                this.zP.m906b(optLong, 1, jSONObject);
                this.zQ.m906b(optLong, 1, jSONObject);
                this.zR.m906b(optLong, 1, jSONObject);
                this.zS.m906b(optLong, 1, jSONObject);
                this.zT.m906b(optLong, 1, jSONObject);
            }
        } catch (JSONException e) {
            this.yY.m901d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* renamed from: a */
    public long m2132a(eu euVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long dE = dE();
        this.zT.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject.put("requestId", dE);
            jSONObject.put("type", "GET_STATUS");
            if (this.zL != null) {
                jSONObject.put("mediaSessionId", this.zL.dC());
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject.toString(), dE, null);
        return dE;
    }

    /* renamed from: a */
    public long m2133a(eu euVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zR.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", dC());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    /* renamed from: a */
    public long m2134a(eu euVar, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zQ.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", dC());
            jSONObject2.put("currentTime", eo.m877m(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    /* renamed from: a */
    public long m2135a(eu euVar, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zM.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.dB());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", eo.m877m(j));
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    /* renamed from: a */
    public long m2136a(eu euVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zN.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", dC());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    /* renamed from: a */
    public long m2137a(eu euVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zS.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", dC());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    /* renamed from: a */
    public void mo1717a(long j, int i) {
        this.zM.m907c(j, i);
        this.zN.m907c(j, i);
        this.zO.m907c(j, i);
        this.zP.m907c(j, i);
        this.zQ.m907c(j, i);
        this.zR.m907c(j, i);
        this.zS.m907c(j, i);
        this.zT.m907c(j, i);
    }

    /* renamed from: b */
    public long m2139b(eu euVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zP.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", dC());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    /* renamed from: c */
    public long m2140c(eu euVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zO.m905a(dE, euVar);
        m2130w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", dC());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m872a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long dC() throws IllegalStateException {
        if (this.zL != null) {
            return this.zL.dC();
        }
        throw new IllegalStateException("No current media session");
    }

    public void dF() {
        dS();
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zK == 0) {
            return 0;
        }
        double playbackRate = this.zL.getPlaybackRate();
        long streamPosition = this.zL.getStreamPosition();
        int playerState = this.zL.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zK;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.zL == null ? null : this.zL.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zL;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }
}
