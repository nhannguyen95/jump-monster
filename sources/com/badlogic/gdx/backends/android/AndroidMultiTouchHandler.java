package com.badlogic.gdx.backends.android;

import android.content.Context;
import com.badlogic.gdx.Gdx;

public class AndroidMultiTouchHandler implements AndroidTouchHandler {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTouch(android.view.MotionEvent r26, com.badlogic.gdx.backends.android.AndroidInput r27) {
        /*
        r25 = this;
        r2 = r26.getAction();
        r0 = r2 & 255;
        r20 = r0;
        r2 = r26.getAction();
        r3 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r2 = r2 & r3;
        r24 = r2 >> 8;
        r0 = r26;
        r1 = r24;
        r23 = r0.getPointerId(r1);
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = java.lang.System.nanoTime();
        monitor-enter(r27);
        switch(r20) {
            case 0: goto L_0x0031;
            case 1: goto L_0x009c;
            case 2: goto L_0x00ff;
            case 3: goto L_0x009c;
            case 4: goto L_0x009c;
            case 5: goto L_0x0031;
            case 6: goto L_0x009c;
            default: goto L_0x0026;
        };
    L_0x0026:
        monitor-exit(r27);	 Catch:{ all -> 0x0097 }
        r2 = com.badlogic.gdx.Gdx.app;
        r2 = r2.getGraphics();
        r2.requestRendering();
        return;
    L_0x0031:
        r7 = r27.getFreePointerIndex();	 Catch:{ all -> 0x0097 }
        r2 = 20;
        if (r7 >= r2) goto L_0x0026;
    L_0x0039:
        r0 = r27;
        r2 = r0.realId;	 Catch:{ all -> 0x0097 }
        r2[r7] = r23;	 Catch:{ all -> 0x0097 }
        r0 = r26;
        r1 = r24;
        r2 = r0.getX(r1);	 Catch:{ all -> 0x0097 }
        r5 = (int) r2;	 Catch:{ all -> 0x0097 }
        r0 = r26;
        r1 = r24;
        r2 = r0.getY(r1);	 Catch:{ all -> 0x0097 }
        r6 = (int) r2;	 Catch:{ all -> 0x0097 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0097 }
        r3 = 14;
        if (r2 < r3) goto L_0x0061;
    L_0x0057:
        r2 = r26.getButtonState();	 Catch:{ all -> 0x0097 }
        r0 = r25;
        r8 = r0.toGdxButton(r2);	 Catch:{ all -> 0x0097 }
    L_0x0061:
        r2 = -1;
        if (r8 == r2) goto L_0x006c;
    L_0x0064:
        r4 = 0;
        r2 = r25;
        r3 = r27;
        r2.postTouchEvent(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0097 }
    L_0x006c:
        r0 = r27;
        r2 = r0.touchX;	 Catch:{ all -> 0x0097 }
        r2[r7] = r5;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.touchY;	 Catch:{ all -> 0x0097 }
        r2[r7] = r6;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.deltaX;	 Catch:{ all -> 0x0097 }
        r3 = 0;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.deltaY;	 Catch:{ all -> 0x0097 }
        r3 = 0;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r3 = r0.touched;	 Catch:{ all -> 0x0097 }
        r2 = -1;
        if (r8 == r2) goto L_0x009a;
    L_0x008d:
        r2 = 1;
    L_0x008e:
        r3[r7] = r2;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.button;	 Catch:{ all -> 0x0097 }
        r2[r7] = r8;	 Catch:{ all -> 0x0097 }
        goto L_0x0026;
    L_0x0097:
        r2 = move-exception;
        monitor-exit(r27);	 Catch:{ all -> 0x0097 }
        throw r2;
    L_0x009a:
        r2 = 0;
        goto L_0x008e;
    L_0x009c:
        r0 = r27;
        r1 = r23;
        r7 = r0.lookUpPointerIndex(r1);	 Catch:{ all -> 0x0097 }
        r2 = -1;
        if (r7 == r2) goto L_0x0026;
    L_0x00a7:
        r2 = 20;
        if (r7 >= r2) goto L_0x0026;
    L_0x00ab:
        r0 = r27;
        r2 = r0.realId;	 Catch:{ all -> 0x0097 }
        r3 = -1;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r26;
        r1 = r24;
        r2 = r0.getX(r1);	 Catch:{ all -> 0x0097 }
        r5 = (int) r2;	 Catch:{ all -> 0x0097 }
        r0 = r26;
        r1 = r24;
        r2 = r0.getY(r1);	 Catch:{ all -> 0x0097 }
        r6 = (int) r2;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.button;	 Catch:{ all -> 0x0097 }
        r8 = r2[r7];	 Catch:{ all -> 0x0097 }
        r2 = -1;
        if (r8 == r2) goto L_0x00d5;
    L_0x00cd:
        r4 = 1;
        r2 = r25;
        r3 = r27;
        r2.postTouchEvent(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0097 }
    L_0x00d5:
        r0 = r27;
        r2 = r0.touchX;	 Catch:{ all -> 0x0097 }
        r2[r7] = r5;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.touchY;	 Catch:{ all -> 0x0097 }
        r2[r7] = r6;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.deltaX;	 Catch:{ all -> 0x0097 }
        r3 = 0;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.deltaY;	 Catch:{ all -> 0x0097 }
        r3 = 0;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.touched;	 Catch:{ all -> 0x0097 }
        r3 = 0;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.button;	 Catch:{ all -> 0x0097 }
        r3 = 0;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        goto L_0x0026;
    L_0x00ff:
        r22 = r26.getPointerCount();	 Catch:{ all -> 0x0097 }
        r21 = 0;
    L_0x0105:
        r0 = r21;
        r1 = r22;
        if (r0 >= r1) goto L_0x0026;
    L_0x010b:
        r24 = r21;
        r0 = r26;
        r1 = r24;
        r23 = r0.getPointerId(r1);	 Catch:{ all -> 0x0097 }
        r0 = r26;
        r1 = r24;
        r2 = r0.getX(r1);	 Catch:{ all -> 0x0097 }
        r5 = (int) r2;	 Catch:{ all -> 0x0097 }
        r0 = r26;
        r1 = r24;
        r2 = r0.getY(r1);	 Catch:{ all -> 0x0097 }
        r6 = (int) r2;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r1 = r23;
        r7 = r0.lookUpPointerIndex(r1);	 Catch:{ all -> 0x0097 }
        r2 = -1;
        if (r7 != r2) goto L_0x0135;
    L_0x0132:
        r21 = r21 + 1;
        goto L_0x0105;
    L_0x0135:
        r2 = 20;
        if (r7 >= r2) goto L_0x0026;
    L_0x0139:
        r0 = r27;
        r2 = r0.button;	 Catch:{ all -> 0x0097 }
        r8 = r2[r7];	 Catch:{ all -> 0x0097 }
        r2 = -1;
        if (r8 == r2) goto L_0x0173;
    L_0x0142:
        r4 = 2;
        r2 = r25;
        r3 = r27;
        r2.postTouchEvent(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0097 }
    L_0x014a:
        r0 = r27;
        r2 = r0.deltaX;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r3 = r0.touchX;	 Catch:{ all -> 0x0097 }
        r3 = r3[r7];	 Catch:{ all -> 0x0097 }
        r3 = r5 - r3;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.deltaY;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r3 = r0.touchY;	 Catch:{ all -> 0x0097 }
        r3 = r3[r7];	 Catch:{ all -> 0x0097 }
        r3 = r6 - r3;
        r2[r7] = r3;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.touchX;	 Catch:{ all -> 0x0097 }
        r2[r7] = r5;	 Catch:{ all -> 0x0097 }
        r0 = r27;
        r2 = r0.touchY;	 Catch:{ all -> 0x0097 }
        r2[r7] = r6;	 Catch:{ all -> 0x0097 }
        goto L_0x0132;
    L_0x0173:
        r13 = 4;
        r17 = 0;
        r11 = r25;
        r12 = r27;
        r14 = r5;
        r15 = r6;
        r16 = r7;
        r18 = r9;
        r11.postTouchEvent(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ all -> 0x0097 }
        goto L_0x014a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidMultiTouchHandler.onTouch(android.view.MotionEvent, com.badlogic.gdx.backends.android.AndroidInput):void");
    }

    private void logAction(int action, int pointer) {
        String actionStr = "";
        if (action == 0) {
            actionStr = "DOWN";
        } else if (action == 5) {
            actionStr = "POINTER DOWN";
        } else if (action == 1) {
            actionStr = "UP";
        } else if (action == 6) {
            actionStr = "POINTER UP";
        } else if (action == 4) {
            actionStr = "OUTSIDE";
        } else if (action == 3) {
            actionStr = "CANCEL";
        } else if (action == 2) {
            actionStr = "MOVE";
        } else {
            actionStr = "UNKNOWN (" + action + ")";
        }
        Gdx.app.log("AndroidMultiTouchHandler", "action " + actionStr + ", Android pointer id: " + pointer);
    }

    private int toGdxButton(int button) {
        if (button == 0 || button == 1) {
            return 0;
        }
        if (button == 2) {
            return 1;
        }
        if (button == 4) {
            return 2;
        }
        if (button == 8) {
            return 3;
        }
        if (button == 16) {
            return 4;
        }
        return -1;
    }

    private void postTouchEvent(AndroidInput input, int type, int x, int y, int pointer, int button, long timeStamp) {
        TouchEvent event = (TouchEvent) input.usedTouchEvents.obtain();
        event.timeStamp = timeStamp;
        event.pointer = pointer;
        event.f35x = x;
        event.f36y = y;
        event.type = type;
        event.button = button;
        input.touchEvents.add(event);
    }

    public boolean supportsMultitouch(Context activity) {
        return activity.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
    }
}
