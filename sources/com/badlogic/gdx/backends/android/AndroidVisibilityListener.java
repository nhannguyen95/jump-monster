package com.badlogic.gdx.backends.android;

import android.view.View.OnSystemUiVisibilityChangeListener;

public class AndroidVisibilityListener {
    public void createListener(final AndroidApplicationBase application) {
        try {
            application.getApplicationWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {

                /* renamed from: com.badlogic.gdx.backends.android.AndroidVisibilityListener$1$1 */
                class C00521 implements Runnable {
                    C00521() {
                    }

                    public void run() {
                        application.useImmersiveMode(true);
                    }
                }

                public void onSystemUiVisibilityChange(int arg0) {
                    application.getHandler().post(new C00521());
                }
            });
        } catch (Throwable t) {
            application.log("AndroidApplication", "Can't create OnSystemUiVisibilityChangeListener, unable to use immersive mode.", t);
        }
    }
}
