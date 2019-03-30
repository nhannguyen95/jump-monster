package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.Gdx;

public class AndroidMouseHandler {
    private int deltaX = 0;
    private int deltaY = 0;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onGenericMotion(android.view.MotionEvent r19, com.badlogic.gdx.backends.android.AndroidInput r20) {
        /*
        r18 = this;
        r1 = r19.getSource();
        r1 = r1 & 2;
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        r1 = 0;
    L_0x0009:
        return r1;
    L_0x000a:
        r1 = r19.getAction();
        r0 = r1 & 255;
        r17 = r0;
        r4 = 0;
        r5 = 0;
        r14 = 0;
        r7 = java.lang.System.nanoTime();
        monitor-enter(r20);
        switch(r17) {
            case 7: goto L_0x0029;
            case 8: goto L_0x0054;
            default: goto L_0x001d;
        };
    L_0x001d:
        monitor-exit(r20);	 Catch:{ all -> 0x0051 }
        r1 = com.badlogic.gdx.Gdx.app;
        r1 = r1.getGraphics();
        r1.requestRendering();
        r1 = 1;
        goto L_0x0009;
    L_0x0029:
        r1 = r19.getX();	 Catch:{ all -> 0x0051 }
        r4 = (int) r1;	 Catch:{ all -> 0x0051 }
        r1 = r19.getY();	 Catch:{ all -> 0x0051 }
        r5 = (int) r1;	 Catch:{ all -> 0x0051 }
        r0 = r18;
        r1 = r0.deltaX;	 Catch:{ all -> 0x0051 }
        if (r4 != r1) goto L_0x003f;
    L_0x0039:
        r0 = r18;
        r1 = r0.deltaY;	 Catch:{ all -> 0x0051 }
        if (r5 == r1) goto L_0x001d;
    L_0x003f:
        r3 = 4;
        r6 = 0;
        r1 = r18;
        r2 = r20;
        r1.postTouchEvent(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0051 }
        r0 = r18;
        r0.deltaX = r4;	 Catch:{ all -> 0x0051 }
        r0 = r18;
        r0.deltaY = r5;	 Catch:{ all -> 0x0051 }
        goto L_0x001d;
    L_0x0051:
        r1 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x0051 }
        throw r1;
    L_0x0054:
        r1 = 9;
        r0 = r19;
        r1 = r0.getAxisValue(r1);	 Catch:{ all -> 0x0051 }
        r1 = java.lang.Math.signum(r1);	 Catch:{ all -> 0x0051 }
        r1 = -r1;
        r14 = (int) r1;	 Catch:{ all -> 0x0051 }
        r11 = 3;
        r12 = 0;
        r13 = 0;
        r9 = r18;
        r10 = r20;
        r15 = r7;
        r9.postTouchEvent(r10, r11, r12, r13, r14, r15);	 Catch:{ all -> 0x0051 }
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidMouseHandler.onGenericMotion(android.view.MotionEvent, com.badlogic.gdx.backends.android.AndroidInput):boolean");
    }

    private void logAction(int action) {
        String actionStr = "";
        if (action == 9) {
            actionStr = "HOVER_ENTER";
        } else if (action == 7) {
            actionStr = "HOVER_MOVE";
        } else if (action == 10) {
            actionStr = "HOVER_EXIT";
        } else if (action == 8) {
            actionStr = "SCROLL";
        } else {
            actionStr = "UNKNOWN (" + action + ")";
        }
        Gdx.app.log("AndroidMouseHandler", "action " + actionStr);
    }

    private void postTouchEvent(AndroidInput input, int type, int x, int y, int scrollAmount, long timeStamp) {
        TouchEvent event = (TouchEvent) input.usedTouchEvents.obtain();
        event.timeStamp = timeStamp;
        event.f35x = x;
        event.f36y = y;
        event.type = type;
        event.scrollAmount = scrollAmount;
        input.touchEvents.add(event);
    }
}
