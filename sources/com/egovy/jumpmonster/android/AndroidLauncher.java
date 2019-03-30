package com.egovy.jumpmonster.android;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.egovy.jumpmonster.ActionResolver;
import com.egovy.jumpmonster.AdsController;
import com.egovy.jumpmonster.JumpMonsterMain;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;

public class AndroidLauncher extends AndroidApplication implements GameHelperListener, ActionResolver, AdsController {
    private static final String BANNER_AD_UNIT_ID = "ca-app-pub-4785598427567346/2240668517";
    AdView bannerAd;
    private GameHelper gameHelper;

    /* renamed from: com.egovy.jumpmonster.android.AndroidLauncher$1 */
    class C00721 implements Runnable {
        C00721() {
        }

        public void run() {
            AndroidLauncher.this.gameHelper.beginUserInitiatedSignIn();
        }
    }

    /* renamed from: com.egovy.jumpmonster.android.AndroidLauncher$2 */
    class C00732 implements Runnable {
        C00732() {
        }

        public void run() {
            AndroidLauncher.this.bannerAd.setVisibility(0);
            AndroidLauncher.this.bannerAd.loadAd(new Builder().build());
        }
    }

    /* renamed from: com.egovy.jumpmonster.android.AndroidLauncher$3 */
    class C00743 implements Runnable {
        C00743() {
        }

        public void run() {
            AndroidLauncher.this.bannerAd.setVisibility(4);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View gameView = initializeForView(new JumpMonsterMain(this, this), new AndroidApplicationConfiguration());
        setupAds();
        RelativeLayout layout = new RelativeLayout(this);
        layout.addView(gameView, -1, -1);
        LayoutParams params = new LayoutParams(-1, -2);
        params.addRule(10);
        layout.addView(this.bannerAd, params);
        setContentView(layout);
        if (this.gameHelper == null) {
            this.gameHelper = new GameHelper(this, 1);
            this.gameHelper.enableDebugLog(true);
        }
        this.gameHelper.setup(this);
    }

    public void setupAds() {
        this.bannerAd = new AdView(this);
        this.bannerAd.setVisibility(4);
        this.bannerAd.setBackgroundColor(-16777216);
        this.bannerAd.setAdUnitId(BANNER_AD_UNIT_ID);
        this.bannerAd.setAdSize(AdSize.SMART_BANNER);
    }

    protected void onStart() {
        super.onStart();
        this.gameHelper.onStart(this);
    }

    protected void onStop() {
        super.onStop();
        this.gameHelper.onStop();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.gameHelper.onActivityResult(requestCode, resultCode, data);
    }

    public boolean getSignedInGPGS() {
        return this.gameHelper.isSignedIn();
    }

    public void loginGPGS() {
        try {
            runOnUiThread(new C00721());
        } catch (Exception e) {
        }
    }

    public void submitScoreGPGS(int score) {
        Games.Leaderboards.submitScore(this.gameHelper.getApiClient(), "CgkIm4ji35MLEAIQAQ", (long) score);
    }

    public void unlockAchievementGPGS(String achievementId) {
        Games.Achievements.unlock(this.gameHelper.getApiClient(), achievementId);
    }

    public void getLeaderboardGPGS() {
        if (this.gameHelper.isSignedIn()) {
            startActivityForResult(Games.Leaderboards.getLeaderboardIntent(this.gameHelper.getApiClient(), "CgkIm4ji35MLEAIQAQ"), 100);
        } else if (!this.gameHelper.isConnecting()) {
            loginGPGS();
        }
    }

    public void getAchievementsGPGS() {
        if (this.gameHelper.isSignedIn()) {
            startActivityForResult(Games.Achievements.getAchievementsIntent(this.gameHelper.getApiClient()), 101);
        } else if (!this.gameHelper.isConnecting()) {
            loginGPGS();
        }
    }

    public void onSignInFailed() {
    }

    public void onSignInSucceeded() {
    }

    public void showBannerAd() {
        runOnUiThread(new C00732());
    }

    public void hideBannerAd() {
        runOnUiThread(new C00743());
    }

    public boolean isWifiConnected() {
        NetworkInfo ni = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(1);
        if (ni == null || !ni.isConnected()) {
            return false;
        }
        return true;
    }
}
