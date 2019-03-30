package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadExtendedPlayersResult;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.player.ExtendedPlayerBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.C0275b;
import com.google.android.gms.internal.ff.C0644d;
import com.google.android.gms.internal.ff.C0976e;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends ff<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    private boolean IA = false;
    private int IB;
    private final Binder IC;
    private final long IE;
    private final boolean IF;
    private final int IG;
    private final boolean IH;
    private final String Iu;
    private final Map<String, RealTimeSocket> Iv;
    private PlayerEntity Iw;
    private GameEntity Ix;
    private final PopupManager Iy;
    private boolean Iz = false;
    private final String wG;

    final class ContactSettingsUpdatedCallback extends C0275b<C0128d<Status>> {
        final /* synthetic */ GamesClientImpl IJ;
        private final Status wJ;

        ContactSettingsUpdatedCallback(GamesClientImpl gamesClientImpl, C0128d<Status> resultHolder, int statusCode) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1753c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m1753c(C0128d<Status> c0128d) {
            c0128d.mo1074b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class InvitationReceivedCallback extends C0275b<OnInvitationReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final Invitation IU;

        InvitationReceivedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, Invitation invitation) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.IU = invitation;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1755b((OnInvitationReceivedListener) obj);
        }

        /* renamed from: b */
        protected void m1755b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.IU);
        }

        protected void dx() {
        }
    }

    final class InvitationRemovedCallback extends C0275b<OnInvitationReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IV;

        InvitationRemovedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, String invitationId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.IV = invitationId;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1757b((OnInvitationReceivedListener) obj);
        }

        /* renamed from: b */
        protected void m1757b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.IV);
        }

        protected void dx() {
        }
    }

    final class LeftRoomCallback extends C0275b<RoomUpdateListener> {
        private final int Ah;
        final /* synthetic */ GamesClientImpl IJ;
        private final String Ja;

        LeftRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, int statusCode, String roomId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ah = statusCode;
            this.Ja = roomId;
        }

        /* renamed from: a */
        public void m1758a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.Ah, this.Ja);
        }

        protected void dx() {
        }
    }

    final class MatchRemovedCallback extends C0275b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jb;

        MatchRemovedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, String matchId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jb = matchId;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1761b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        /* renamed from: b */
        protected void m1761b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Jb);
        }

        protected void dx() {
        }
    }

    final class MatchUpdateReceivedCallback extends C0275b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final TurnBasedMatch Jd;

        MatchUpdateReceivedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, TurnBasedMatch match) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jd = match;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1763b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        /* renamed from: b */
        protected void m1763b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Jd);
        }

        protected void dx() {
        }
    }

    final class MessageReceivedCallback extends C0275b<RealTimeMessageReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final RealTimeMessage Je;

        MessageReceivedCallback(GamesClientImpl gamesClientImpl, RealTimeMessageReceivedListener listener, RealTimeMessage message) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Je = message;
        }

        /* renamed from: a */
        public void m1764a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Je);
            }
        }

        protected void dx() {
        }
    }

    final class NotifyAclUpdatedCallback extends C0275b<C0128d<Status>> {
        final /* synthetic */ GamesClientImpl IJ;
        private final Status wJ;

        NotifyAclUpdatedCallback(GamesClientImpl gamesClientImpl, C0128d<Status> resultHolder, int statusCode) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1767c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m1767c(C0128d<Status> c0128d) {
            c0128d.mo1074b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class P2PConnectedCallback extends C0275b<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jg;

        P2PConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jg = participantId;
        }

        /* renamed from: a */
        public void m1768a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.Jg);
            }
        }

        protected void dx() {
        }
    }

    final class P2PDisconnectedCallback extends C0275b<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jg;

        P2PDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jg = participantId;
        }

        /* renamed from: a */
        public void m1770a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.Jg);
            }
        }

        protected void dx() {
        }
    }

    final class RealTimeMessageSentCallback extends C0275b<ReliableMessageSentCallback> {
        private final int Ah;
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jj;
        private final int Jk;

        RealTimeMessageSentCallback(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback listener, int statusCode, int token, String recipientParticipantId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ah = statusCode;
            this.Jk = token;
            this.Jj = recipientParticipantId;
        }

        /* renamed from: a */
        public void m1772a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.Ah, this.Jk, this.Jj);
            }
        }

        protected void dx() {
        }
    }

    final class RequestReceivedCallback extends C0275b<OnRequestReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameRequest Jn;

        RequestReceivedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, GameRequest request) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jn = request;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1775b((OnRequestReceivedListener) obj);
        }

        /* renamed from: b */
        protected void m1775b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Jn);
        }

        protected void dx() {
        }
    }

    final class RequestRemovedCallback extends C0275b<OnRequestReceivedListener> {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jo;

        RequestRemovedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, String requestId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jo = requestId;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m1777b((OnRequestReceivedListener) obj);
        }

        /* renamed from: b */
        protected void m1777b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Jo);
        }

        protected void dx() {
        }
    }

    final class SignOutCompleteCallback extends C0275b<C0128d<Status>> {
        final /* synthetic */ GamesClientImpl IJ;
        private final Status wJ;

        public SignOutCompleteCallback(GamesClientImpl gamesClientImpl, C0128d<Status> resultHolder, Status status) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
        }

        /* renamed from: a */
        public /* synthetic */ void mo1214a(Object obj) {
            m1779c((C0128d) obj);
        }

        /* renamed from: c */
        public void m1779c(C0128d<Status> c0128d) {
            c0128d.mo1074b(this.wJ);
        }

        protected void dx() {
        }
    }

    abstract class AbstractRoomCallback extends C0644d<RoomUpdateListener> {
        final /* synthetic */ GamesClientImpl IJ;

        AbstractRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        protected void m2746a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            mo3244a(roomUpdateListener, this.IJ.m2768G(dataHolder), dataHolder.getStatusCode());
        }

        /* renamed from: a */
        protected abstract void mo3244a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    abstract class AbstractRoomStatusCallback extends C0644d<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl IJ;

        AbstractRoomStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        protected void m2749a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            mo3243a(roomStatusUpdateListener, this.IJ.m2768G(dataHolder));
        }

        /* renamed from: a */
        protected abstract void mo3243a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    final class AchievementUpdatedCallback extends C0275b<C0128d<UpdateAchievementResult>> implements UpdateAchievementResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IK;
        private final Status wJ;

        AchievementUpdatedCallback(GamesClientImpl gamesClientImpl, C0128d<UpdateAchievementResult> resultHolder, int statusCode, String achievementId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
            this.IK = achievementId;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2753c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2753c(C0128d<UpdateAchievementResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public String getAchievementId() {
            return this.IK;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class GameMuteStatusChangedCallback extends C0275b<C0128d<GameMuteStatusChangeResult>> implements GameMuteStatusChangeResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IP;
        private final boolean IQ;
        private final Status wJ;

        public GameMuteStatusChangedCallback(GamesClientImpl gamesClientImpl, C0128d<GameMuteStatusChangeResult> resultHolder, int statusCode, String externalGameId, boolean isMuted) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
            this.IP = externalGameId;
            this.IQ = isMuted;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2755c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2755c(C0128d<GameMuteStatusChangeResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class GameMuteStatusLoadedCallback extends C0275b<C0128d<GameMuteStatusLoadResult>> implements GameMuteStatusLoadResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IP;
        private final boolean IQ;
        private final Status wJ;

        public GameMuteStatusLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<GameMuteStatusLoadResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            try {
                this.wJ = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.IP = dataHolder.getString("external_game_id", 0, 0);
                    this.IQ = dataHolder.getBoolean("muted", 0, 0);
                } else {
                    this.IP = null;
                    this.IQ = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2757c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2757c(C0128d<GameMuteStatusLoadResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class OwnerCoverPhotoUrisLoadedCallback extends C0275b<C0128d<LoadOwnerCoverPhotoUrisResult>> implements LoadOwnerCoverPhotoUrisResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final Bundle Jf;
        private final Status wJ;

        OwnerCoverPhotoUrisLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadOwnerCoverPhotoUrisResult> resultHolder, int statusCode, Bundle bundle) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
            this.Jf = bundle;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2759c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2759c(C0128d<LoadOwnerCoverPhotoUrisResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class PlayerLeaderboardScoreLoadedCallback extends C0644d<C0128d<LoadPlayerScoreResult>> implements LoadPlayerScoreResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LeaderboardScoreEntity Jh;
        private final Status wJ;

        PlayerLeaderboardScoreLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadPlayerScoreResult> resultHolder, DataHolder scoreHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, scoreHolder);
            this.wJ = new Status(scoreHolder.getStatusCode());
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.Jh = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.Jh = null;
                }
                leaderboardScoreBuffer.close();
            } catch (Throwable th) {
                leaderboardScoreBuffer.close();
            }
        }

        /* renamed from: a */
        protected void m2760a(C0128d<LoadPlayerScoreResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public LeaderboardScore getScore() {
            return this.Jh;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class RequestsLoadedCallback extends C0275b<C0128d<LoadRequestsResult>> implements LoadRequestsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final Bundle Js;
        private final Status wJ;

        RequestsLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadRequestsResult> resultHolder, Status status, Bundle requestData) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
            this.Js = requestData;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2763c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2763c(C0128d<LoadRequestsResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
            release();
        }

        public GameRequestBuffer getRequests(int requestType) {
            String bd = RequestType.bd(requestType);
            return !this.Js.containsKey(bd) ? null : new GameRequestBuffer((DataHolder) this.Js.get(bd));
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            for (String parcelable : this.Js.keySet()) {
                DataHolder dataHolder = (DataHolder) this.Js.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    abstract class ResultDataHolderCallback<R extends C0128d<?>> extends C0644d<R> implements Releasable, Result {
        final DataHolder BB;
        final /* synthetic */ GamesClientImpl IJ;
        final Status wJ;

        public ResultDataHolderCallback(GamesClientImpl gamesClientImpl, R resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.wJ = new Status(dataHolder.getStatusCode());
            this.BB = dataHolder;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            if (this.BB != null) {
                this.BB.close();
            }
        }
    }

    final class TurnBasedMatchCanceledCallback extends C0275b<C0128d<CancelMatchResult>> implements CancelMatchResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String JA;
        private final Status wJ;

        TurnBasedMatchCanceledCallback(GamesClientImpl gamesClientImpl, C0128d<CancelMatchResult> resultHolder, Status status, String externalMatchId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
            this.JA = externalMatchId;
        }

        /* renamed from: a */
        public /* synthetic */ void mo1214a(Object obj) {
            m2765c((C0128d) obj);
        }

        /* renamed from: c */
        public void m2765c(C0128d<CancelMatchResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public String getMatchId() {
            return this.JA;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class TurnBasedMatchesLoadedCallback extends C0275b<C0128d<LoadMatchesResult>> implements LoadMatchesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LoadMatchesResponse JG;
        private final Status wJ;

        TurnBasedMatchesLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadMatchesResult> resultHolder, Status status, Bundle matchData) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
            this.JG = new LoadMatchesResponse(matchData);
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m2767c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m2767c(C0128d<LoadMatchesResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public LoadMatchesResponse getMatches() {
            return this.JG;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            this.JG.close();
        }
    }

    abstract class AbstractPeerStatusCallback extends AbstractRoomStatusCallback {
        private final ArrayList<String> II = new ArrayList();
        final /* synthetic */ GamesClientImpl IJ;

        AbstractPeerStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
            for (Object add : participantIds) {
                this.II.add(add);
            }
        }

        /* renamed from: a */
        protected void mo3243a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo3259a(roomStatusUpdateListener, room, this.II);
        }

        /* renamed from: a */
        protected abstract void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<UpdateAchievementResult> wH;

        AchievementUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<UpdateAchievementResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo1239e(int i, String str) {
            this.IJ.m2169a(new AchievementUpdatedCallback(this.IJ, this.wH, i, str));
        }
    }

    final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadAchievementsResult> wH;

        AchievementsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadAchievementsResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: b */
        public void mo1230b(DataHolder dataHolder) {
            this.IJ.m2169a(new AchievementsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class AchievementsLoadedCallback extends ResultDataHolderCallback<C0128d<LoadAchievementsResult>> implements LoadAchievementsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final AchievementBuffer IL;

        AchievementsLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadAchievementsResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IL = new AchievementBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3290a(C0128d<LoadAchievementsResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public AchievementBuffer getAchievements() {
            return this.IL;
        }
    }

    final class ConnectedToRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        ConnectedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3243a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<ContactSettingLoadResult> wH;

        ContactSettingsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<ContactSettingLoadResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: B */
        public void mo1217B(DataHolder dataHolder) {
            this.IJ.m2169a(new ContactSettingsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class ContactSettingsLoadedCallback extends ResultDataHolderCallback<C0128d<ContactSettingLoadResult>> implements ContactSettingLoadResult {
        final /* synthetic */ GamesClientImpl IJ;

        ContactSettingsLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<ContactSettingLoadResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: a */
        protected void m3294a(C0128d<ContactSettingLoadResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<Status> wH;

        ContactSettingsUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<Status> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        public void aV(int i) {
            this.IJ.m2169a(new ContactSettingsUpdatedCallback(this.IJ, this.wH, i));
        }
    }

    final class DisconnectedFromRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        DisconnectedFromRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3243a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadExtendedGamesResult> wH;

        ExtendedGamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadExtendedGamesResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: h */
        public void mo1246h(DataHolder dataHolder) {
            this.IJ.m2169a(new ExtendedGamesLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class ExtendedGamesLoadedCallback extends ResultDataHolderCallback<C0128d<LoadExtendedGamesResult>> implements LoadExtendedGamesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final ExtendedGameBuffer IM;

        ExtendedGamesLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadExtendedGamesResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IM = new ExtendedGameBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3298a(C0128d<LoadExtendedGamesResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class ExtendedPlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadExtendedPlayersResult> wH;

        ExtendedPlayersLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadExtendedPlayersResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo1243f(DataHolder dataHolder) {
            this.IJ.m2169a(new ExtendedPlayersLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class ExtendedPlayersLoadedCallback extends ResultDataHolderCallback<C0128d<LoadExtendedPlayersResult>> implements LoadExtendedPlayersResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final ExtendedPlayerBuffer IN;

        ExtendedPlayersLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadExtendedPlayersResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IN = new ExtendedPlayerBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3301a(C0128d<LoadExtendedPlayersResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadGameInstancesResult> wH;

        GameInstancesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadGameInstancesResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: i */
        public void mo1247i(DataHolder dataHolder) {
            this.IJ.m2169a(new GameInstancesLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GameInstancesLoadedCallback extends ResultDataHolderCallback<C0128d<LoadGameInstancesResult>> implements LoadGameInstancesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameInstanceBuffer IO;

        GameInstancesLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadGameInstancesResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IO = new GameInstanceBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3304a(C0128d<LoadGameInstancesResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<GameMuteStatusChangeResult> wH;

        GameMuteStatusChangedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<GameMuteStatusChangeResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1223a(int i, String str, boolean z) {
            this.IJ.m2169a(new GameMuteStatusChangedCallback(this.IJ, this.wH, i, str, z));
        }
    }

    final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<GameMuteStatusLoadResult> wH;

        GameMuteStatusLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<GameMuteStatusLoadResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: z */
        public void mo1271z(DataHolder dataHolder) {
            this.IJ.m2169a(new GameMuteStatusLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadGameSearchSuggestionsResult> wH;

        GameSearchSuggestionsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadGameSearchSuggestionsResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: j */
        public void mo1248j(DataHolder dataHolder) {
            this.IJ.m2169a(new GameSearchSuggestionsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GameSearchSuggestionsLoadedCallback extends ResultDataHolderCallback<C0128d<LoadGameSearchSuggestionsResult>> implements LoadGameSearchSuggestionsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final DataHolder IR;

        GameSearchSuggestionsLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadGameSearchSuggestionsResult> resultHolder, DataHolder data) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, data);
            this.IR = data;
        }

        /* renamed from: a */
        protected void m3309a(C0128d<LoadGameSearchSuggestionsResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadGamesResult> wH;

        GamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadGamesResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: g */
        public void mo1245g(DataHolder dataHolder) {
            this.IJ.m2169a(new GamesLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GamesLoadedCallback extends ResultDataHolderCallback<C0128d<LoadGamesResult>> implements LoadGamesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameBuffer IS;

        GamesLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadGamesResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IS = new GameBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3312a(C0128d<LoadGamesResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public GameBuffer getGames() {
            return this.IS;
        }
    }

    final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final OnInvitationReceivedListener IT;

        InvitationReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener) {
            this.IJ = gamesClientImpl;
            this.IT = listener;
        }

        /* renamed from: l */
        public void mo1250l(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.IJ.m2169a(new InvitationReceivedCallback(this.IJ, this.IT, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.IJ.m2169a(new InvitationRemovedCallback(this.IJ, this.IT, invitationId));
        }
    }

    final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadInvitationsResult> wH;

        InvitationsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadInvitationsResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: k */
        public void mo1249k(DataHolder dataHolder) {
            this.IJ.m2169a(new InvitationsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class InvitationsLoadedCallback extends ResultDataHolderCallback<C0128d<LoadInvitationsResult>> implements LoadInvitationsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final InvitationBuffer IW;

        InvitationsLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadInvitationsResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IW = new InvitationBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3316a(C0128d<LoadInvitationsResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public InvitationBuffer getInvitations() {
            return this.IW;
        }
    }

    final class JoinedRoomCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl IJ;

        public JoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3244a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadScoresResult> wH;

        LeaderboardScoresLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadScoresResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1224a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.IJ.m2169a(new LeaderboardScoresLoadedCallback(this.IJ, this.wH, dataHolder, dataHolder2));
        }
    }

    final class LeaderboardScoresLoadedCallback extends ResultDataHolderCallback<C0128d<LoadScoresResult>> implements LoadScoresResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LeaderboardEntity IX;
        private final LeaderboardScoreBuffer IY;

        LeaderboardScoresLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadScoresResult> resultHolder, DataHolder leaderboard, DataHolder scores) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.IX = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.IX = null;
                }
                leaderboardBuffer.close();
                this.IY = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.close();
            }
        }

        /* renamed from: a */
        protected void m3320a(C0128d<LoadScoresResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public Leaderboard getLeaderboard() {
            return this.IX;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.IY;
        }
    }

    final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LeaderboardMetadataResult> wH;

        LeaderboardsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LeaderboardMetadataResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo1233c(DataHolder dataHolder) {
            this.IJ.m2169a(new LeaderboardsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class LeaderboardsLoadedCallback extends ResultDataHolderCallback<C0128d<LeaderboardMetadataResult>> implements LeaderboardMetadataResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LeaderboardBuffer IZ;

        LeaderboardsLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LeaderboardMetadataResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IZ = new LeaderboardBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3323a(C0128d<LeaderboardMetadataResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.IZ;
        }
    }

    final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final OnTurnBasedMatchUpdateReceivedListener Jc;

        MatchUpdateReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener) {
            this.IJ = gamesClientImpl;
            this.Jc = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.IJ.m2169a(new MatchRemovedCallback(this.IJ, this.Jc, matchId));
        }

        /* renamed from: r */
        public void mo1263r(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.close();
                if (turnBasedMatch != null) {
                    this.IJ.m2169a(new MatchUpdateReceivedCallback(this.IJ, this.Jc, turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }
    }

    final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadAclResult> wH;

        NotifyAclLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadAclResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: A */
        public void mo1216A(DataHolder dataHolder) {
            this.IJ.m2169a(new NotifyAclLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class NotifyAclLoadedCallback extends ResultDataHolderCallback<C0128d<LoadAclResult>> implements LoadAclResult {
        final /* synthetic */ GamesClientImpl IJ;

        NotifyAclLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadAclResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: a */
        protected void m3327a(C0128d<LoadAclResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<Status> wH;

        NotifyAclUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<Status> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void aU(int i) {
            this.IJ.m2169a(new NotifyAclUpdatedCallback(this.IJ, this.wH, i));
        }
    }

    final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadOwnerCoverPhotoUrisResult> wH;

        OwnerCoverPhotoUrisLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadOwnerCoverPhotoUrisResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo1232c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IJ.m2169a(new OwnerCoverPhotoUrisLoadedCallback(this.IJ, this.wH, i, bundle));
        }
    }

    final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadPlayerScoreResult> wH;

        PlayerLeaderboardScoreLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadPlayerScoreResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: C */
        public void mo1218C(DataHolder dataHolder) {
            this.IJ.m2169a(new PlayerLeaderboardScoreLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadPlayersResult> wH;

        PlayersLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0128d<LoadPlayersResult> holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo1240e(DataHolder dataHolder) {
            this.IJ.m2169a(new PlayersLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class PlayersLoadedCallback extends ResultDataHolderCallback<C0128d<LoadPlayersResult>> implements LoadPlayersResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final PlayerBuffer Ji;

        PlayersLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadPlayersResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.Ji = new PlayerBuffer(dataHolder);
        }

        /* renamed from: a */
        protected void m3332a(C0128d<LoadPlayersResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public PlayerBuffer getPlayers() {
            return this.Ji;
        }
    }

    final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        final ReliableMessageSentCallback Jl;

        public RealTimeReliableMessageBinderCallbacks(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback messageSentCallbacks) {
            this.IJ = gamesClientImpl;
            this.Jl = messageSentCallbacks;
        }

        /* renamed from: b */
        public void mo1228b(int i, int i2, String str) {
            this.IJ.m2169a(new RealTimeMessageSentCallback(this.IJ, this.Jl, i, i2, str));
        }
    }

    final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final OnRequestReceivedListener Jm;

        RequestReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener) {
            this.IJ = gamesClientImpl;
            this.Jm = listener;
        }

        /* renamed from: m */
        public void mo1251m(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.close();
                if (gameRequest != null) {
                    this.IJ.m2169a(new RequestReceivedCallback(this.IJ, this.Jm, gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.IJ.m2169a(new RequestRemovedCallback(this.IJ, this.Jm, requestId));
        }
    }

    final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<SendRequestResult> Jp;

        public RequestSentBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<SendRequestResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jp = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: E */
        public void mo1220E(DataHolder dataHolder) {
            this.IJ.m2169a(new RequestSentCallback(this.IJ, this.Jp, dataHolder));
        }
    }

    final class RequestSentCallback extends ResultDataHolderCallback<C0128d<SendRequestResult>> implements SendRequestResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameRequest Jn;

        RequestSentCallback(GamesClientImpl gamesClientImpl, C0128d<SendRequestResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.Jn = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.Jn = null;
                }
                gameRequestBuffer.close();
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        /* renamed from: a */
        protected void m3337a(C0128d<SendRequestResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadRequestSummariesResult> Jq;

        public RequestSummariesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<LoadRequestSummariesResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jq = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: F */
        public void mo1221F(DataHolder dataHolder) {
            this.IJ.m2169a(new RequestSummariesLoadedCallback(this.IJ, this.Jq, dataHolder));
        }
    }

    final class RequestSummariesLoadedCallback extends ResultDataHolderCallback<C0128d<LoadRequestSummariesResult>> implements LoadRequestSummariesResult {
        final /* synthetic */ GamesClientImpl IJ;

        RequestSummariesLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadRequestSummariesResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: a */
        protected void m3340a(C0128d<LoadRequestSummariesResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }
    }

    final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadRequestsResult> Jr;

        public RequestsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<LoadRequestsResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jr = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: b */
        public void mo1229b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IJ.m2169a(new RequestsLoadedCallback(this.IJ, this.Jr, new Status(i), bundle));
        }
    }

    final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<UpdateRequestsResult> Jt;

        public RequestsUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<UpdateRequestsResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jt = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: D */
        public void mo1219D(DataHolder dataHolder) {
            this.IJ.m2169a(new RequestsUpdatedCallback(this.IJ, this.Jt, dataHolder));
        }
    }

    final class RequestsUpdatedCallback extends ResultDataHolderCallback<C0128d<UpdateRequestsResult>> implements UpdateRequestsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final RequestUpdateOutcomes Ju;

        RequestsUpdatedCallback(GamesClientImpl gamesClientImpl, C0128d<UpdateRequestsResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.Ju = RequestUpdateOutcomes.m574J(dataHolder);
        }

        /* renamed from: a */
        protected void m3344a(C0128d<UpdateRequestsResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public Set<String> getRequestIds() {
            return this.Ju.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.Ju.getRequestOutcome(requestId);
        }
    }

    final class RoomAutoMatchingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        RoomAutoMatchingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3243a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final RoomUpdateListener Jv;
        private final RoomStatusUpdateListener Jw;
        private final RealTimeMessageReceivedListener Jx;

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks) {
            this.IJ = gamesClientImpl;
            this.Jv = (RoomUpdateListener) fq.m983b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Jw = null;
            this.Jx = null;
        }

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks, RoomStatusUpdateListener roomStatusCallbacks, RealTimeMessageReceivedListener realTimeMessageReceivedCallbacks) {
            this.IJ = gamesClientImpl;
            this.Jv = (RoomUpdateListener) fq.m983b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Jw = roomStatusCallbacks;
            this.Jx = realTimeMessageReceivedCallbacks;
        }

        /* renamed from: a */
        public void mo1225a(DataHolder dataHolder, String[] strArr) {
            this.IJ.m2169a(new PeerInvitedToRoomCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        /* renamed from: b */
        public void mo1231b(DataHolder dataHolder, String[] strArr) {
            this.IJ.m2169a(new PeerJoinedRoomCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        /* renamed from: c */
        public void mo1234c(DataHolder dataHolder, String[] strArr) {
            this.IJ.m2169a(new PeerLeftRoomCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        /* renamed from: d */
        public void mo1237d(DataHolder dataHolder, String[] strArr) {
            this.IJ.m2169a(new PeerDeclinedCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        /* renamed from: e */
        public void mo1241e(DataHolder dataHolder, String[] strArr) {
            this.IJ.m2169a(new PeerConnectedCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        /* renamed from: f */
        public void mo1244f(DataHolder dataHolder, String[] strArr) {
            this.IJ.m2169a(new PeerDisconnectedCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.IJ.m2169a(new LeftRoomCallback(this.IJ, this.Jv, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.IJ.m2169a(new P2PConnectedCallback(this.IJ, this.Jw, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.IJ.m2169a(new P2PDisconnectedCallback(this.IJ, this.Jw, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            this.IJ.m2169a(new MessageReceivedCallback(this.IJ, this.Jx, message));
        }

        /* renamed from: s */
        public void mo1264s(DataHolder dataHolder) {
            this.IJ.m2169a(new RoomCreatedCallback(this.IJ, this.Jv, dataHolder));
        }

        /* renamed from: t */
        public void mo1265t(DataHolder dataHolder) {
            this.IJ.m2169a(new JoinedRoomCallback(this.IJ, this.Jv, dataHolder));
        }

        /* renamed from: u */
        public void mo1266u(DataHolder dataHolder) {
            this.IJ.m2169a(new RoomConnectingCallback(this.IJ, this.Jw, dataHolder));
        }

        /* renamed from: v */
        public void mo1267v(DataHolder dataHolder) {
            this.IJ.m2169a(new RoomAutoMatchingCallback(this.IJ, this.Jw, dataHolder));
        }

        /* renamed from: w */
        public void mo1268w(DataHolder dataHolder) {
            this.IJ.m2169a(new RoomConnectedCallback(this.IJ, this.Jv, dataHolder));
        }

        /* renamed from: x */
        public void mo1269x(DataHolder dataHolder) {
            this.IJ.m2169a(new ConnectedToRoomCallback(this.IJ, this.Jw, dataHolder));
        }

        /* renamed from: y */
        public void mo1270y(DataHolder dataHolder) {
            this.IJ.m2169a(new DisconnectedFromRoomCallback(this.IJ, this.Jw, dataHolder));
        }
    }

    final class RoomConnectedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl IJ;

        RoomConnectedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3244a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class RoomConnectingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        RoomConnectingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3243a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class RoomCreatedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl IJ;

        public RoomCreatedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        /* renamed from: a */
        public void mo3244a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<Status> wH;

        public SignOutCompleteBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<Status> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void du() {
            this.IJ.m2169a(new SignOutCompleteCallback(this.IJ, this.wH, new Status(0)));
        }
    }

    final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<SubmitScoreResult> wH;

        public SubmitScoreBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<SubmitScoreResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: d */
        public void mo1236d(DataHolder dataHolder) {
            this.IJ.m2169a(new SubmitScoreCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class SubmitScoreCallback extends ResultDataHolderCallback<C0128d<SubmitScoreResult>> implements SubmitScoreResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final ScoreSubmissionData Jy;

        public SubmitScoreCallback(GamesClientImpl gamesClientImpl, C0128d<SubmitScoreResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            try {
                this.Jy = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        /* renamed from: a */
        public void m3364a(C0128d<SubmitScoreResult> c0128d, DataHolder dataHolder) {
            c0128d.mo1074b(this);
        }

        public ScoreSubmissionData getScoreData() {
            return this.Jy;
        }
    }

    abstract class TurnBasedMatchCallback<T extends C0128d<?>> extends ResultDataHolderCallback<T> {
        final /* synthetic */ GamesClientImpl IJ;
        final TurnBasedMatch Jd;

        TurnBasedMatchCallback(GamesClientImpl gamesClientImpl, T listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Jd = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Jd = null;
                }
                turnBasedMatchBuffer.close();
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }

        /* renamed from: a */
        protected void m3366a(T t, DataHolder dataHolder) {
            mo3260k(t);
        }

        public TurnBasedMatch getMatch() {
            return this.Jd;
        }

        /* renamed from: k */
        abstract void mo3260k(T t);
    }

    final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<CancelMatchResult> Jz;

        public TurnBasedMatchCanceledBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<CancelMatchResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jz = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo1242f(int i, String str) {
            this.IJ.m2169a(new TurnBasedMatchCanceledCallback(this.IJ, this.Jz, new Status(i), str));
        }
    }

    final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<InitiateMatchResult> JB;

        public TurnBasedMatchInitiatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<InitiateMatchResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.JB = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: o */
        public void mo1253o(DataHolder dataHolder) {
            this.IJ.m2169a(new TurnBasedMatchInitiatedCallback(this.IJ, this.JB, dataHolder));
        }
    }

    final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LeaveMatchResult> JC;

        public TurnBasedMatchLeftBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<LeaveMatchResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.JC = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: q */
        public void mo1262q(DataHolder dataHolder) {
            this.IJ.m2169a(new TurnBasedMatchLeftCallback(this.IJ, this.JC, dataHolder));
        }
    }

    final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadMatchResult> JD;

        public TurnBasedMatchLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<LoadMatchResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.JD = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: n */
        public void mo1252n(DataHolder dataHolder) {
            this.IJ.m2169a(new TurnBasedMatchLoadedCallback(this.IJ, this.JD, dataHolder));
        }
    }

    final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<UpdateMatchResult> JE;

        public TurnBasedMatchUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<UpdateMatchResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.JE = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: p */
        public void mo1261p(DataHolder dataHolder) {
            this.IJ.m2169a(new TurnBasedMatchUpdatedCallback(this.IJ, this.JE, dataHolder));
        }
    }

    final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C0128d<LoadMatchesResult> JF;

        public TurnBasedMatchesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0128d<LoadMatchesResult> resultHolder) {
            this.IJ = gamesClientImpl;
            this.JF = (C0128d) fq.m983b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1222a(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IJ.m2169a(new TurnBasedMatchesLoadedCallback(this.IJ, this.JF, new Status(i), bundle));
        }
    }

    final class PeerConnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class PeerDeclinedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerDeclinedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class PeerDisconnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class PeerInvitedToRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerInvitedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class PeerJoinedRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerJoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class PeerLeftRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerLeftRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3259a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class TurnBasedMatchInitiatedCallback extends TurnBasedMatchCallback<C0128d<InitiateMatchResult>> implements InitiateMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchInitiatedCallback(GamesClientImpl gamesClientImpl, C0128d<InitiateMatchResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: k */
        protected void mo3260k(C0128d<InitiateMatchResult> c0128d) {
            c0128d.mo1074b(this);
        }
    }

    final class TurnBasedMatchLeftCallback extends TurnBasedMatchCallback<C0128d<LeaveMatchResult>> implements LeaveMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchLeftCallback(GamesClientImpl gamesClientImpl, C0128d<LeaveMatchResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: k */
        protected void mo3260k(C0128d<LeaveMatchResult> c0128d) {
            c0128d.mo1074b(this);
        }
    }

    final class TurnBasedMatchLoadedCallback extends TurnBasedMatchCallback<C0128d<LoadMatchResult>> implements LoadMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchLoadedCallback(GamesClientImpl gamesClientImpl, C0128d<LoadMatchResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: k */
        protected void mo3260k(C0128d<LoadMatchResult> c0128d) {
            c0128d.mo1074b(this);
        }
    }

    final class TurnBasedMatchUpdatedCallback extends TurnBasedMatchCallback<C0128d<UpdateMatchResult>> implements UpdateMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchUpdatedCallback(GamesClientImpl gamesClientImpl, C0128d<UpdateMatchResult> resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        /* renamed from: k */
        protected void mo3260k(C0128d<UpdateMatchResult> c0128d) {
            c0128d.mo1074b(this);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, boolean isHeadless, boolean showConnectingPopup, int connectingPopupGravity, boolean retryingSignIn, int sdkVariant) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.Iu = gamePackageName;
        this.wG = (String) fq.m986f(accountName);
        this.IC = new Binder();
        this.Iv = new HashMap();
        this.Iy = PopupManager.m567a(this, gravity);
        m2843f(gamesContentView);
        this.IA = showConnectingPopup;
        this.IB = connectingPopupGravity;
        this.IE = (long) hashCode();
        this.IF = isHeadless;
        this.IH = retryingSignIn;
        this.IG = sdkVariant;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    /* renamed from: G */
    private Room m2768G(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.close();
            return room;
        } catch (Throwable th) {
            roomBuffer.close();
        }
    }

    private RealTimeSocket aC(String str) {
        try {
            ParcelFileDescriptor aJ = ((IGamesService) eM()).aJ(str);
            RealTimeSocket libjingleNativeSocket;
            if (aJ != null) {
                GamesLog.m366f("GamesClientImpl", "Created native libjingle socket.");
                libjingleNativeSocket = new LibjingleNativeSocket(aJ);
                this.Iv.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            }
            GamesLog.m366f("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String aE = ((IGamesService) eM()).aE(str);
            if (aE == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(aE));
                libjingleNativeSocket = new RealTimeSocketImpl(localSocket, str);
                this.Iv.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            } catch (IOException e) {
                GamesLog.m368h("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            GamesLog.m368h("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void gE() {
        for (RealTimeSocket close : this.Iv.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.m365a("GamesClientImpl", "IOException:", e);
            }
        }
        this.Iv.clear();
    }

    private void gk() {
        this.Iw = null;
    }

    /* renamed from: L */
    protected IGamesService m2770L(IBinder iBinder) {
        return Stub.m1946N(iBinder);
    }

    /* renamed from: a */
    public int m2771a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) eM()).mo1273a(new RealTimeReliableMessageBinderCallbacks(this, reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public int m2772a(byte[] bArr, String str, String[] strArr) {
        fq.m983b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) eM()).mo1330b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public Intent m2773a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) eM()).mo1274a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent m2774a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) eM()).mo1275a(i, bArr, i2, str);
            fq.m983b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent m2775a(Room room, int i) {
        try {
            return ((IGamesService) eM()).mo1278a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    protected void mo2683a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Iz = bundle.getBoolean("show_welcome_popup");
        }
        super.mo2683a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void m2777a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) eM()).mo1281a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m367g("GamesClientImpl", "service died");
            }
        }
    }

    /* renamed from: a */
    public void m2778a(C0128d<LoadRequestsResult> c0128d, int i, int i2, int i3) {
        try {
            ((IGamesService) eM()).mo1284a(new RequestsLoadedBinderCallbacks(this, c0128d), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2779a(C0128d<LoadExtendedGamesResult> c0128d, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1285a(new ExtendedGamesLoadedBinderCallback(this, c0128d), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2780a(C0128d<LoadPlayersResult> c0128d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1287a(new PlayersLoadedBinderCallback(this, c0128d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2781a(C0128d<LoadMatchesResult> c0128d, int i, int[] iArr) {
        try {
            ((IGamesService) eM()).mo1288a(new TurnBasedMatchesLoadedBinderCallbacks(this, c0128d), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2782a(C0128d<LoadScoresResult> c0128d, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) eM()).mo1291a(new LeaderboardScoresLoadedBinderCallback(this, c0128d), leaderboardScoreBuffer.hD().hE(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2783a(C0128d<InitiateMatchResult> c0128d, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) eM()).mo1286a(new TurnBasedMatchInitiatedBinderCallbacks(this, c0128d), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.getMinPlayers(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2784a(C0128d<LoadPlayersResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1294a(new PlayersLoadedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2785a(C0128d<UpdateAchievementResult> c0128d, String str, int i) {
        try {
            ((IGamesService) eM()).mo1297a(c0128d == null ? null : new AchievementUpdatedBinderCallback(this, c0128d), str, i, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2786a(C0128d<LoadScoresResult> c0128d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).mo1296a(new LeaderboardScoresLoadedBinderCallback(this, c0128d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2787a(C0128d<LoadPlayersResult> c0128d, String str, int i, boolean z) {
        try {
            ((IGamesService) eM()).mo1298a(new PlayersLoadedBinderCallback(this, c0128d), str, i, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2788a(C0128d<LoadPlayersResult> c0128d, String str, int i, boolean z, boolean z2) {
        if (str.equals("playedWith")) {
            try {
                ((IGamesService) eM()).mo1365d(new PlayersLoadedBinderCallback(this, c0128d), str, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m367g("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    /* renamed from: a */
    public void m2789a(C0128d<LoadExtendedGamesResult> c0128d, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) eM()).mo1300a(new ExtendedGamesLoadedBinderCallback(this, c0128d), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2790a(C0128d<LoadMatchesResult> c0128d, String str, int i, int[] iArr) {
        try {
            ((IGamesService) eM()).mo1301a(new TurnBasedMatchesLoadedBinderCallbacks(this, c0128d), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2791a(C0128d<SubmitScoreResult> c0128d, String str, long j, String str2) {
        try {
            ((IGamesService) eM()).mo1303a(c0128d == null ? null : new SubmitScoreBinderCallbacks(this, c0128d), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2792a(C0128d<LeaveMatchResult> c0128d, String str, String str2) {
        try {
            ((IGamesService) eM()).mo1357c(new TurnBasedMatchLeftBinderCallbacks(this, c0128d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2793a(C0128d<LoadPlayerScoreResult> c0128d, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) eM()).mo1306a(new PlayerLeaderboardScoreLoadedBinderCallback(this, c0128d), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2794a(C0128d<LoadRequestsResult> c0128d, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) eM()).mo1307a(new RequestsLoadedBinderCallbacks(this, c0128d), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2795a(C0128d<LoadScoresResult> c0128d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).mo1308a(new LeaderboardScoresLoadedBinderCallback(this, c0128d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2796a(C0128d<LoadPlayersResult> c0128d, String str, String str2, int i, boolean z, boolean z2) {
        if (str.equals("playedWith") || str.equals("circled")) {
            try {
                ((IGamesService) eM()).mo1309a(new PlayersLoadedBinderCallback(this, c0128d), str, str2, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m367g("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    /* renamed from: a */
    public void m2797a(C0128d<LeaderboardMetadataResult> c0128d, String str, String str2, boolean z) {
        try {
            ((IGamesService) eM()).mo1345b(new LeaderboardsLoadedBinderCallback(this, c0128d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2798a(C0128d<UpdateRequestsResult> c0128d, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) eM()).mo1311a(new RequestsUpdatedBinderCallbacks(this, c0128d), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2799a(C0128d<LeaderboardMetadataResult> c0128d, String str, boolean z) {
        try {
            ((IGamesService) eM()).mo1358c(new LeaderboardsLoadedBinderCallback(this, c0128d), str, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2800a(C0128d<UpdateMatchResult> c0128d, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) eM()).mo1313a(new TurnBasedMatchUpdatedBinderCallbacks(this, c0128d), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2801a(C0128d<UpdateMatchResult> c0128d, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) eM()).mo1314a(new TurnBasedMatchUpdatedBinderCallbacks(this, c0128d), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2802a(C0128d<SendRequestResult> c0128d, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) eM()).mo1316a(new RequestSentBinderCallbacks(this, c0128d), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2803a(C0128d<LoadPlayersResult> c0128d, boolean z) {
        try {
            ((IGamesService) eM()).mo1359c(new PlayersLoadedBinderCallback(this, c0128d), z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2804a(C0128d<Status> c0128d, boolean z, Bundle bundle) {
        try {
            ((IGamesService) eM()).mo1318a(new ContactSettingsUpdatedBinderCallback(this, c0128d), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2805a(C0128d<LoadPlayersResult> c0128d, String[] strArr) {
        try {
            ((IGamesService) eM()).mo1360c(new PlayersLoadedBinderCallback(this, c0128d), strArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2806a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((IGamesService) eM()).mo1289a(new InvitationReceivedBinderCallback(this, onInvitationReceivedListener), this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2807a(RoomConfig roomConfig) {
        try {
            ((IGamesService) eM()).mo1292a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.IC, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2808a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((IGamesService) eM()).mo1355c(new RoomBinderCallbacks(this, roomUpdateListener), str);
            gE();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2809a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) eM()).mo1335b(new MatchUpdateReceivedBinderCallback(this, onTurnBasedMatchUpdateReceivedListener), this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m2810a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((IGamesService) eM()).mo1353c(new RequestReceivedBinderCallback(this, onRequestReceivedListener), this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.IF);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.IA);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.IB);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.IH);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.IG);
        fmVar.mo1741a(c0976e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.wG, eL(), this.Iu, this.Iy.gU(), locale, bundle);
    }

    public Intent aA(String str) {
        try {
            return ((IGamesService) eM()).aA(str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void aB(String str) {
        try {
            ((IGamesService) eM()).aI(str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public void aX(int i) {
        this.Iy.setGravity(i);
    }

    public void aY(int i) {
        try {
            ((IGamesService) eM()).aY(i);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public Intent m2812b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) eM()).mo1331b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: b */
    public void m2813b(C0128d<Status> c0128d) {
        try {
            ((IGamesService) eM()).mo1282a(new SignOutCompleteBinderCallbacks(this, c0128d));
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2814b(C0128d<LoadPlayersResult> c0128d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1334b(new PlayersLoadedBinderCallback(this, c0128d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2815b(C0128d<UpdateAchievementResult> c0128d, String str) {
        if (c0128d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c0128d);
        }
        try {
            ((IGamesService) eM()).mo1304a(iGamesCallbacks, str, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2816b(C0128d<UpdateAchievementResult> c0128d, String str, int i) {
        try {
            ((IGamesService) eM()).mo1339b(c0128d == null ? null : new AchievementUpdatedBinderCallback(this, c0128d), str, i, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2817b(C0128d<LoadScoresResult> c0128d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).mo1338b(new LeaderboardScoresLoadedBinderCallback(this, c0128d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2818b(C0128d<LoadExtendedGamesResult> c0128d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1299a(new ExtendedGamesLoadedBinderCallback(this, c0128d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2819b(C0128d<InitiateMatchResult> c0128d, String str, String str2) {
        try {
            ((IGamesService) eM()).mo1366d(new TurnBasedMatchInitiatedBinderCallbacks(this, c0128d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2820b(C0128d<LoadScoresResult> c0128d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).mo1344b(new LeaderboardScoresLoadedBinderCallback(this, c0128d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2821b(C0128d<LoadAchievementsResult> c0128d, String str, String str2, boolean z) {
        try {
            ((IGamesService) eM()).mo1310a(new AchievementsLoadedBinderCallback(this, c0128d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2822b(C0128d<LeaderboardMetadataResult> c0128d, String str, boolean z) {
        try {
            ((IGamesService) eM()).mo1367d(new LeaderboardsLoadedBinderCallback(this, c0128d), str, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2823b(C0128d<LeaderboardMetadataResult> c0128d, boolean z) {
        try {
            ((IGamesService) eM()).mo1347b(new LeaderboardsLoadedBinderCallback(this, c0128d), z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2824b(C0128d<UpdateRequestsResult> c0128d, String[] strArr) {
        try {
            ((IGamesService) eM()).mo1320a(new RequestsUpdatedBinderCallbacks(this, c0128d), strArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m2825b(RoomConfig roomConfig) {
        try {
            ((IGamesService) eM()).mo1293a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.IC, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    protected void mo2747b(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            fq.m981a(!z, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        fq.m981a(z, String.format("Games APIs requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    protected String bg() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* renamed from: c */
    public void m2827c(C0128d<LoadInvitationsResult> c0128d, int i) {
        try {
            ((IGamesService) eM()).mo1283a(new InvitationsLoadedBinderCallback(this, c0128d), i);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2828c(C0128d<LoadPlayersResult> c0128d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1352c(new PlayersLoadedBinderCallback(this, c0128d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2829c(C0128d<UpdateAchievementResult> c0128d, String str) {
        if (c0128d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c0128d);
        }
        try {
            ((IGamesService) eM()).mo1342b(iGamesCallbacks, str, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2830c(C0128d<LoadInvitationsResult> c0128d, String str, int i) {
        try {
            ((IGamesService) eM()).mo1340b(new InvitationsLoadedBinderCallback(this, c0128d), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2831c(C0128d<LoadExtendedGamesResult> c0128d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1356c(new ExtendedGamesLoadedBinderCallback(this, c0128d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2832c(C0128d<InitiateMatchResult> c0128d, String str, String str2) {
        try {
            ((IGamesService) eM()).mo1372e(new TurnBasedMatchInitiatedBinderCallbacks(this, c0128d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2833c(C0128d<GameMuteStatusChangeResult> c0128d, String str, boolean z) {
        try {
            ((IGamesService) eM()).mo1312a(new GameMuteStatusChangedBinderCallback(this, c0128d), str, z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2834c(C0128d<LoadAchievementsResult> c0128d, boolean z) {
        try {
            ((IGamesService) eM()).mo1317a(new AchievementsLoadedBinderCallback(this, c0128d), z);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m2835c(C0128d<UpdateRequestsResult> c0128d, String[] strArr) {
        try {
            ((IGamesService) eM()).mo1348b(new RequestsUpdatedBinderCallbacks(this, c0128d), strArr);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public void connect() {
        gk();
        super.connect();
    }

    /* renamed from: d */
    public int m2836d(byte[] bArr, String str) {
        try {
            return ((IGamesService) eM()).mo1330b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: d */
    public void m2837d(C0128d<LoadPlayersResult> c0128d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1370e(new PlayersLoadedBinderCallback(this, c0128d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m2838d(C0128d<InitiateMatchResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1408l(new TurnBasedMatchInitiatedBinderCallbacks(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m2839d(C0128d<LoadRequestSummariesResult> c0128d, String str, int i) {
        try {
            ((IGamesService) eM()).mo1295a(new RequestSummariesLoadedBinderCallbacks(this, c0128d), str, i);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m2840d(C0128d<LoadPlayersResult> c0128d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1341b(new PlayersLoadedBinderCallback(this, c0128d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public Bundle dG() {
        try {
            Bundle dG = ((IGamesService) eM()).dG();
            if (dG == null) {
                return dG;
            }
            dG.setClassLoader(GamesClientImpl.class.getClassLoader());
            return dG;
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void disconnect() {
        this.Iz = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) eM();
                iGamesService.gF();
                iGamesService.mo1414o(this.IE);
            } catch (RemoteException e) {
                GamesLog.m367g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        gE();
        super.disconnect();
    }

    /* renamed from: e */
    public void m2841e(C0128d<LoadExtendedPlayersResult> c0128d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).mo1363d(new ExtendedPlayersLoadedBinderCallback(this, c0128d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void m2842e(C0128d<InitiateMatchResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1410m(new TurnBasedMatchInitiatedBinderCallbacks(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void m2843f(View view) {
        this.Iy.mo1483g(view);
    }

    /* renamed from: f */
    public void m2844f(C0128d<LeaveMatchResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1415o(new TurnBasedMatchLeftBinderCallbacks(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void m2845g(C0128d<LoadGamesResult> c0128d) {
        try {
            ((IGamesService) eM()).mo1362d(new GamesLoadedBinderCallback(this, c0128d));
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void m2846g(C0128d<CancelMatchResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1412n(new TurnBasedMatchCanceledBinderCallbacks(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public int gA() {
        try {
            return ((IGamesService) eM()).gA();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public Intent gB() {
        try {
            return ((IGamesService) eM()).gB();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int gC() {
        try {
            return ((IGamesService) eM()).gC();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public int gD() {
        try {
            return ((IGamesService) eM()).gD();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public void gF() {
        if (isConnected()) {
            try {
                ((IGamesService) eM()).gF();
            } catch (RemoteException e) {
                GamesLog.m367g("GamesClientImpl", "service died");
            }
        }
    }

    public String gl() {
        try {
            return ((IGamesService) eM()).gl();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public String gm() {
        try {
            return ((IGamesService) eM()).gm();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player gn() {
        PlayerBuffer playerBuffer;
        bT();
        synchronized (this) {
            if (this.Iw == null) {
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) eM()).gG());
                    if (playerBuffer.getCount() > 0) {
                        this.Iw = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m367g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.Iw;
    }

    public Game go() {
        GameBuffer gameBuffer;
        bT();
        synchronized (this) {
            if (this.Ix == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) eM()).gI());
                    if (gameBuffer.getCount() > 0) {
                        this.Ix = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m367g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.Ix;
    }

    public Intent gp() {
        try {
            return ((IGamesService) eM()).gp();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gq() {
        try {
            return ((IGamesService) eM()).gq();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gr() {
        try {
            return ((IGamesService) eM()).gr();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gs() {
        try {
            return ((IGamesService) eM()).gs();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void gt() {
        try {
            ((IGamesService) eM()).mo1417p(this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public void gu() {
        try {
            ((IGamesService) eM()).mo1419q(this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public void gv() {
        try {
            ((IGamesService) eM()).mo1421r(this.IE);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public Intent gw() {
        try {
            return ((IGamesService) eM()).gw();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gx() {
        try {
            return ((IGamesService) eM()).gx();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int gy() {
        try {
            return ((IGamesService) eM()).gy();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String gz() {
        try {
            return ((IGamesService) eM()).gz();
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: h */
    public void m2847h(C0128d<LoadOwnerCoverPhotoUrisResult> c0128d) {
        try {
            ((IGamesService) eM()).mo1403j(new OwnerCoverPhotoUrisLoadedBinderCallback(this, c0128d));
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void m2848h(C0128d<LoadMatchResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1418p(new TurnBasedMatchLoadedBinderCallbacks(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: i */
    public RealTimeSocket m2849i(String str, String str2) {
        if (str2 == null || !ParticipantUtils.aV(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Iv.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? aC(str2) : realTimeSocket;
    }

    /* renamed from: i */
    public void m2850i(C0128d<LoadAclResult> c0128d) {
        try {
            ((IGamesService) eM()).mo1400h(new NotifyAclLoadedBinderCallback(this, c0128d));
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: i */
    public void m2851i(C0128d<LoadExtendedGamesResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1371e(new ExtendedGamesLoadedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: j */
    public void m2852j(C0128d<ContactSettingLoadResult> c0128d) {
        try {
            ((IGamesService) eM()).mo1401i(new ContactSettingsLoadedBinderCallback(this, c0128d));
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: j */
    public void m2853j(C0128d<LoadGameInstancesResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1375f(new GameInstancesLoadedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: k */
    public void m2854k(C0128d<LoadGameSearchSuggestionsResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1420q(new GameSearchSuggestionsLoadedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: l */
    public void m2855l(C0128d<LoadInvitationsResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1406k(new InvitationsLoadedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: l */
    public void m2856l(String str, int i) {
        try {
            ((IGamesService) eM()).mo1409l(str, i);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: m */
    public void m2857m(C0128d<Status> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1404j(new NotifyAclUpdatedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: m */
    public void m2858m(String str, int i) {
        try {
            ((IGamesService) eM()).mo1411m(str, i);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: n */
    public void m2859n(C0128d<GameMuteStatusLoadResult> c0128d, String str) {
        try {
            ((IGamesService) eM()).mo1402i(new GameMuteStatusLoadedBinderCallback(this, c0128d), str);
        } catch (RemoteException e) {
            GamesLog.m367g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.Iz) {
            this.Iy.gS();
            this.Iz = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Iz = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    /* renamed from: r */
    protected /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return m2770L(iBinder);
    }
}
