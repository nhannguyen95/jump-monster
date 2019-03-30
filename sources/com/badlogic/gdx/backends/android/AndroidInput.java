package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Orientation;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Pool;
import java.util.ArrayList;
import java.util.Arrays;

public class AndroidInput implements Input, OnKeyListener, OnTouchListener {
    public static final int NUM_TOUCHES = 20;
    /* renamed from: R */
    final float[] f141R = new float[9];
    public boolean accelerometerAvailable = false;
    private SensorEventListener accelerometerListener;
    private final float[] accelerometerValues = new float[3];
    final Application app;
    private float azimuth = 0.0f;
    int[] button = new int[20];
    private boolean catchBack = false;
    private boolean catchMenu = false;
    private boolean compassAvailable = false;
    private SensorEventListener compassListener;
    private final AndroidApplicationConfiguration config;
    final Context context;
    private long currentEventTimeStamp = System.nanoTime();
    int[] deltaX = new int[20];
    int[] deltaY = new int[20];
    private Handler handle;
    final boolean hasMultitouch;
    private float inclination = 0.0f;
    private boolean[] justPressedKeys = new boolean[256];
    private boolean justTouched = false;
    private int keyCount = 0;
    ArrayList<KeyEvent> keyEvents = new ArrayList();
    private boolean keyJustPressed = false;
    ArrayList<OnKeyListener> keyListeners = new ArrayList();
    boolean keyboardAvailable;
    private boolean[] keys = new boolean[256];
    private final float[] magneticFieldValues = new float[3];
    private SensorManager manager;
    private final Orientation nativeOrientation;
    private final AndroidOnscreenKeyboard onscreenKeyboard;
    final float[] orientation = new float[3];
    private float pitch = 0.0f;
    private InputProcessor processor;
    int[] realId = new int[20];
    boolean requestFocus = true;
    private float roll = 0.0f;
    private int sleepTime = 0;
    private String text = null;
    private TextInputListener textListener = null;
    ArrayList<TouchEvent> touchEvents = new ArrayList();
    private final AndroidTouchHandler touchHandler;
    int[] touchX = new int[20];
    int[] touchY = new int[20];
    boolean[] touched = new boolean[20];
    Pool<KeyEvent> usedKeyEvents = new Pool<KeyEvent>(16, 1000) {
        protected KeyEvent newObject() {
            return new KeyEvent();
        }
    };
    Pool<TouchEvent> usedTouchEvents = new Pool<TouchEvent>(16, 1000) {
        protected TouchEvent newObject() {
            return new TouchEvent();
        }
    };
    protected final Vibrator vibrator;

    static class KeyEvent {
        static final int KEY_DOWN = 0;
        static final int KEY_TYPED = 2;
        static final int KEY_UP = 1;
        char keyChar;
        int keyCode;
        long timeStamp;
        int type;

        KeyEvent() {
        }
    }

    private class SensorListener implements SensorEventListener {
        final float[] accelerometerValues;
        final float[] magneticFieldValues;
        final Orientation nativeOrientation;

        SensorListener(Orientation nativeOrientation, float[] accelerometerValues, float[] magneticFieldValues) {
            this.accelerometerValues = accelerometerValues;
            this.magneticFieldValues = magneticFieldValues;
            this.nativeOrientation = nativeOrientation;
        }

        public void onAccuracyChanged(Sensor arg0, int arg1) {
        }

        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == 1) {
                if (this.nativeOrientation == Orientation.Portrait) {
                    System.arraycopy(event.values, 0, this.accelerometerValues, 0, this.accelerometerValues.length);
                } else {
                    this.accelerometerValues[0] = event.values[1];
                    this.accelerometerValues[1] = -event.values[0];
                    this.accelerometerValues[2] = event.values[2];
                }
            }
            if (event.sensor.getType() == 2) {
                System.arraycopy(event.values, 0, this.magneticFieldValues, 0, this.magneticFieldValues.length);
            }
        }
    }

    static class TouchEvent {
        static final int TOUCH_DOWN = 0;
        static final int TOUCH_DRAGGED = 2;
        static final int TOUCH_MOVED = 4;
        static final int TOUCH_SCROLLED = 3;
        static final int TOUCH_UP = 1;
        int button;
        int pointer;
        int scrollAmount;
        long timeStamp;
        int type;
        /* renamed from: x */
        int f35x;
        /* renamed from: y */
        int f36y;

        TouchEvent() {
        }
    }

    public AndroidInput(Application activity, Context context, Object view, AndroidApplicationConfiguration config) {
        if (view instanceof View) {
            View v = (View) view;
            v.setOnKeyListener(this);
            v.setOnTouchListener(this);
            v.setFocusable(true);
            v.setFocusableInTouchMode(true);
            v.requestFocus();
        }
        this.config = config;
        this.onscreenKeyboard = new AndroidOnscreenKeyboard(context, new Handler(), this);
        for (int i = 0; i < this.realId.length; i++) {
            this.realId[i] = -1;
        }
        this.handle = new Handler();
        this.app = activity;
        this.context = context;
        this.sleepTime = config.touchSleepTime;
        this.touchHandler = new AndroidMultiTouchHandler();
        this.hasMultitouch = this.touchHandler.supportsMultitouch(context);
        this.vibrator = (Vibrator) context.getSystemService("vibrator");
        int rotation = getRotation();
        DisplayMode mode = this.app.getGraphics().getDesktopDisplayMode();
        if (((rotation == 0 || rotation == 180) && mode.width >= mode.height) || ((rotation == 90 || rotation == 270) && mode.width <= mode.height)) {
            this.nativeOrientation = Orientation.Landscape;
        } else {
            this.nativeOrientation = Orientation.Portrait;
        }
    }

    public float getAccelerometerX() {
        return this.accelerometerValues[0];
    }

    public float getAccelerometerY() {
        return this.accelerometerValues[1];
    }

    public float getAccelerometerZ() {
        return this.accelerometerValues[2];
    }

    public void getTextInput(TextInputListener listener, String title, String text, String hint) {
        final String str = title;
        final String str2 = hint;
        final String str3 = text;
        final TextInputListener textInputListener = listener;
        this.handle.post(new Runnable() {

            /* renamed from: com.badlogic.gdx.backends.android.AndroidInput$3$2 */
            class C00392 implements OnClickListener {

                /* renamed from: com.badlogic.gdx.backends.android.AndroidInput$3$2$1 */
                class C00381 implements Runnable {
                    C00381() {
                    }

                    public void run() {
                        textInputListener.canceled();
                    }
                }

                C00392() {
                }

                public void onClick(DialogInterface dialog, int whichButton) {
                    Gdx.app.postRunnable(new C00381());
                }
            }

            /* renamed from: com.badlogic.gdx.backends.android.AndroidInput$3$3 */
            class C00413 implements OnCancelListener {

                /* renamed from: com.badlogic.gdx.backends.android.AndroidInput$3$3$1 */
                class C00401 implements Runnable {
                    C00401() {
                    }

                    public void run() {
                        textInputListener.canceled();
                    }
                }

                C00413() {
                }

                public void onCancel(DialogInterface arg0) {
                    Gdx.app.postRunnable(new C00401());
                }
            }

            public void run() {
                Builder alert = new Builder(AndroidInput.this.context);
                alert.setTitle(str);
                final EditText input = new EditText(AndroidInput.this.context);
                input.setHint(str2);
                input.setText(str3);
                input.setSingleLine();
                alert.setView(input);
                alert.setPositiveButton(AndroidInput.this.context.getString(17039370), new OnClickListener() {

                    /* renamed from: com.badlogic.gdx.backends.android.AndroidInput$3$1$1 */
                    class C00361 implements Runnable {
                        C00361() {
                        }

                        public void run() {
                            textInputListener.input(input.getText().toString());
                        }
                    }

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Gdx.app.postRunnable(new C00361());
                    }
                });
                alert.setNegativeButton(AndroidInput.this.context.getString(17039360), new C00392());
                alert.setOnCancelListener(new C00413());
                alert.show();
            }
        });
    }

    public int getX() {
        int i;
        synchronized (this) {
            i = this.touchX[0];
        }
        return i;
    }

    public int getY() {
        int i;
        synchronized (this) {
            i = this.touchY[0];
        }
        return i;
    }

    public int getX(int pointer) {
        int i;
        synchronized (this) {
            i = this.touchX[pointer];
        }
        return i;
    }

    public int getY(int pointer) {
        int i;
        synchronized (this) {
            i = this.touchY[pointer];
        }
        return i;
    }

    public boolean isTouched(int pointer) {
        boolean z;
        synchronized (this) {
            z = this.touched[pointer];
        }
        return z;
    }

    public synchronized boolean isKeyPressed(int key) {
        boolean z = false;
        synchronized (this) {
            if (key == -1) {
                if (this.keyCount > 0) {
                    z = true;
                }
            } else if (key >= 0 && key <= 255) {
                z = this.keys[key];
            }
        }
        return z;
    }

    public synchronized boolean isKeyJustPressed(int key) {
        boolean z;
        if (key == -1) {
            z = this.keyJustPressed;
        } else if (key < 0 || key > 255) {
            z = false;
        } else {
            z = this.justPressedKeys[key];
        }
        return z;
    }

    public boolean isTouched() {
        boolean z;
        synchronized (this) {
            if (this.hasMultitouch) {
                for (int pointer = 0; pointer < 20; pointer++) {
                    if (this.touched[pointer]) {
                        z = true;
                        break;
                    }
                }
            }
            z = this.touched[0];
        }
        return z;
    }

    public void setInputProcessor(InputProcessor processor) {
        synchronized (this) {
            this.processor = processor;
        }
    }

    void processEvents() {
        synchronized (this) {
            int i;
            this.justTouched = false;
            if (this.keyJustPressed) {
                this.keyJustPressed = false;
                for (i = 0; i < this.justPressedKeys.length; i++) {
                    this.justPressedKeys[i] = false;
                }
            }
            int len;
            TouchEvent e;
            if (this.processor != null) {
                InputProcessor processor = this.processor;
                len = this.keyEvents.size();
                for (i = 0; i < len; i++) {
                    KeyEvent e2 = (KeyEvent) this.keyEvents.get(i);
                    this.currentEventTimeStamp = e2.timeStamp;
                    switch (e2.type) {
                        case 0:
                            processor.keyDown(e2.keyCode);
                            this.keyJustPressed = true;
                            this.justPressedKeys[e2.keyCode] = true;
                            break;
                        case 1:
                            processor.keyUp(e2.keyCode);
                            break;
                        case 2:
                            processor.keyTyped(e2.keyChar);
                            break;
                        default:
                            break;
                    }
                    this.usedKeyEvents.free(e2);
                }
                len = this.touchEvents.size();
                for (i = 0; i < len; i++) {
                    e = (TouchEvent) this.touchEvents.get(i);
                    this.currentEventTimeStamp = e.timeStamp;
                    switch (e.type) {
                        case 0:
                            processor.touchDown(e.f35x, e.f36y, e.pointer, e.button);
                            this.justTouched = true;
                            break;
                        case 1:
                            processor.touchUp(e.f35x, e.f36y, e.pointer, e.button);
                            break;
                        case 2:
                            processor.touchDragged(e.f35x, e.f36y, e.pointer);
                            break;
                        case 3:
                            processor.scrolled(e.scrollAmount);
                            break;
                        case 4:
                            processor.mouseMoved(e.f35x, e.f36y);
                            break;
                        default:
                            break;
                    }
                    this.usedTouchEvents.free(e);
                }
            } else {
                len = this.touchEvents.size();
                for (i = 0; i < len; i++) {
                    e = (TouchEvent) this.touchEvents.get(i);
                    if (e.type == 0) {
                        this.justTouched = true;
                    }
                    this.usedTouchEvents.free(e);
                }
                len = this.keyEvents.size();
                for (i = 0; i < len; i++) {
                    this.usedKeyEvents.free(this.keyEvents.get(i));
                }
            }
            if (this.touchEvents.size() == 0) {
                for (i = 0; i < this.deltaX.length; i++) {
                    this.deltaX[0] = 0;
                    this.deltaY[0] = 0;
                }
            }
            this.keyEvents.clear();
            this.touchEvents.clear();
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        if (this.requestFocus && view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            this.requestFocus = false;
        }
        this.touchHandler.onTouch(event, this);
        if (this.sleepTime != 0) {
            try {
                Thread.sleep((long) this.sleepTime);
            } catch (InterruptedException e) {
            }
        }
        return true;
    }

    public void onTap(int x, int y) {
        postTap(x, y);
    }

    public void onDrop(int x, int y) {
        postTap(x, y);
    }

    protected void postTap(int x, int y) {
        synchronized (this) {
            TouchEvent event = (TouchEvent) this.usedTouchEvents.obtain();
            event.timeStamp = System.nanoTime();
            event.pointer = 0;
            event.f35x = x;
            event.f36y = y;
            event.type = 0;
            this.touchEvents.add(event);
            event = (TouchEvent) this.usedTouchEvents.obtain();
            event.timeStamp = System.nanoTime();
            event.pointer = 0;
            event.f35x = x;
            event.f36y = y;
            event.type = 1;
            this.touchEvents.add(event);
        }
        Gdx.app.getGraphics().requestRendering();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKey(android.view.View r12, int r13, android.view.KeyEvent r14) {
        /*
        r11 = this;
        r4 = 0;
        r8 = r11.keyListeners;
        r5 = r8.size();
    L_0x0007:
        if (r4 >= r5) goto L_0x001c;
    L_0x0009:
        r8 = r11.keyListeners;
        r8 = r8.get(r4);
        r8 = (android.view.View.OnKeyListener) r8;
        r8 = r8.onKey(r12, r13, r14);
        if (r8 == 0) goto L_0x0019;
    L_0x0017:
        r8 = 1;
    L_0x0018:
        return r8;
    L_0x0019:
        r4 = r4 + 1;
        goto L_0x0007;
    L_0x001c:
        monitor-enter(r11);
        r3 = 0;
        r8 = r14.getKeyCode();	 Catch:{ all -> 0x005d }
        if (r8 != 0) goto L_0x0060;
    L_0x0024:
        r8 = r14.getAction();	 Catch:{ all -> 0x005d }
        r9 = 2;
        if (r8 != r9) goto L_0x0060;
    L_0x002b:
        r2 = r14.getCharacters();	 Catch:{ all -> 0x005d }
        r4 = 0;
    L_0x0030:
        r8 = r2.length();	 Catch:{ all -> 0x005d }
        if (r4 >= r8) goto L_0x005a;
    L_0x0036:
        r8 = r11.usedKeyEvents;	 Catch:{ all -> 0x005d }
        r8 = r8.obtain();	 Catch:{ all -> 0x005d }
        r0 = r8;
        r0 = (com.badlogic.gdx.backends.android.AndroidInput.KeyEvent) r0;	 Catch:{ all -> 0x005d }
        r3 = r0;
        r8 = java.lang.System.nanoTime();	 Catch:{ all -> 0x005d }
        r3.timeStamp = r8;	 Catch:{ all -> 0x005d }
        r8 = 0;
        r3.keyCode = r8;	 Catch:{ all -> 0x005d }
        r8 = r2.charAt(r4);	 Catch:{ all -> 0x005d }
        r3.keyChar = r8;	 Catch:{ all -> 0x005d }
        r8 = 2;
        r3.type = r8;	 Catch:{ all -> 0x005d }
        r8 = r11.keyEvents;	 Catch:{ all -> 0x005d }
        r8.add(r3);	 Catch:{ all -> 0x005d }
        r4 = r4 + 1;
        goto L_0x0030;
    L_0x005a:
        r8 = 0;
        monitor-exit(r11);	 Catch:{ all -> 0x005d }
        goto L_0x0018;
    L_0x005d:
        r8 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x005d }
        throw r8;
    L_0x0060:
        r8 = r14.getUnicodeChar();	 Catch:{ all -> 0x005d }
        r1 = (char) r8;	 Catch:{ all -> 0x005d }
        r8 = 67;
        if (r13 != r8) goto L_0x006b;
    L_0x0069:
        r1 = 8;
    L_0x006b:
        r8 = r14.getAction();	 Catch:{ all -> 0x005d }
        switch(r8) {
            case 0: goto L_0x0082;
            case 1: goto L_0x00c6;
            default: goto L_0x0072;
        };	 Catch:{ all -> 0x005d }
    L_0x0072:
        r8 = r11.app;	 Catch:{ all -> 0x005d }
        r8 = r8.getGraphics();	 Catch:{ all -> 0x005d }
        r8.requestRendering();	 Catch:{ all -> 0x005d }
        monitor-exit(r11);	 Catch:{ all -> 0x005d }
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r13 != r8) goto L_0x0143;
    L_0x0080:
        r8 = 1;
        goto L_0x0018;
    L_0x0082:
        r8 = r11.usedKeyEvents;	 Catch:{ all -> 0x005d }
        r8 = r8.obtain();	 Catch:{ all -> 0x005d }
        r0 = r8;
        r0 = (com.badlogic.gdx.backends.android.AndroidInput.KeyEvent) r0;	 Catch:{ all -> 0x005d }
        r3 = r0;
        r8 = java.lang.System.nanoTime();	 Catch:{ all -> 0x005d }
        r3.timeStamp = r8;	 Catch:{ all -> 0x005d }
        r8 = 0;
        r3.keyChar = r8;	 Catch:{ all -> 0x005d }
        r8 = r14.getKeyCode();	 Catch:{ all -> 0x005d }
        r3.keyCode = r8;	 Catch:{ all -> 0x005d }
        r8 = 0;
        r3.type = r8;	 Catch:{ all -> 0x005d }
        r8 = 4;
        if (r13 != r8) goto L_0x00ab;
    L_0x00a1:
        r8 = r14.isAltPressed();	 Catch:{ all -> 0x005d }
        if (r8 == 0) goto L_0x00ab;
    L_0x00a7:
        r13 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r3.keyCode = r13;	 Catch:{ all -> 0x005d }
    L_0x00ab:
        r8 = r11.keyEvents;	 Catch:{ all -> 0x005d }
        r8.add(r3);	 Catch:{ all -> 0x005d }
        r8 = r11.keys;	 Catch:{ all -> 0x005d }
        r9 = r3.keyCode;	 Catch:{ all -> 0x005d }
        r8 = r8[r9];	 Catch:{ all -> 0x005d }
        if (r8 != 0) goto L_0x0072;
    L_0x00b8:
        r8 = r11.keyCount;	 Catch:{ all -> 0x005d }
        r8 = r8 + 1;
        r11.keyCount = r8;	 Catch:{ all -> 0x005d }
        r8 = r11.keys;	 Catch:{ all -> 0x005d }
        r9 = r3.keyCode;	 Catch:{ all -> 0x005d }
        r10 = 1;
        r8[r9] = r10;	 Catch:{ all -> 0x005d }
        goto L_0x0072;
    L_0x00c6:
        r6 = java.lang.System.nanoTime();	 Catch:{ all -> 0x005d }
        r8 = r11.usedKeyEvents;	 Catch:{ all -> 0x005d }
        r8 = r8.obtain();	 Catch:{ all -> 0x005d }
        r0 = r8;
        r0 = (com.badlogic.gdx.backends.android.AndroidInput.KeyEvent) r0;	 Catch:{ all -> 0x005d }
        r3 = r0;
        r3.timeStamp = r6;	 Catch:{ all -> 0x005d }
        r8 = 0;
        r3.keyChar = r8;	 Catch:{ all -> 0x005d }
        r8 = r14.getKeyCode();	 Catch:{ all -> 0x005d }
        r3.keyCode = r8;	 Catch:{ all -> 0x005d }
        r8 = 1;
        r3.type = r8;	 Catch:{ all -> 0x005d }
        r8 = 4;
        if (r13 != r8) goto L_0x00ef;
    L_0x00e5:
        r8 = r14.isAltPressed();	 Catch:{ all -> 0x005d }
        if (r8 == 0) goto L_0x00ef;
    L_0x00eb:
        r13 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r3.keyCode = r13;	 Catch:{ all -> 0x005d }
    L_0x00ef:
        r8 = r11.keyEvents;	 Catch:{ all -> 0x005d }
        r8.add(r3);	 Catch:{ all -> 0x005d }
        r8 = r11.usedKeyEvents;	 Catch:{ all -> 0x005d }
        r8 = r8.obtain();	 Catch:{ all -> 0x005d }
        r0 = r8;
        r0 = (com.badlogic.gdx.backends.android.AndroidInput.KeyEvent) r0;	 Catch:{ all -> 0x005d }
        r3 = r0;
        r3.timeStamp = r6;	 Catch:{ all -> 0x005d }
        r3.keyChar = r1;	 Catch:{ all -> 0x005d }
        r8 = 0;
        r3.keyCode = r8;	 Catch:{ all -> 0x005d }
        r8 = 2;
        r3.type = r8;	 Catch:{ all -> 0x005d }
        r8 = r11.keyEvents;	 Catch:{ all -> 0x005d }
        r8.add(r3);	 Catch:{ all -> 0x005d }
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r13 != r8) goto L_0x0128;
    L_0x0111:
        r8 = r11.keys;	 Catch:{ all -> 0x005d }
        r9 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r8 = r8[r9];	 Catch:{ all -> 0x005d }
        if (r8 == 0) goto L_0x0072;
    L_0x0119:
        r8 = r11.keyCount;	 Catch:{ all -> 0x005d }
        r8 = r8 + -1;
        r11.keyCount = r8;	 Catch:{ all -> 0x005d }
        r8 = r11.keys;	 Catch:{ all -> 0x005d }
        r9 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r10 = 0;
        r8[r9] = r10;	 Catch:{ all -> 0x005d }
        goto L_0x0072;
    L_0x0128:
        r8 = r11.keys;	 Catch:{ all -> 0x005d }
        r9 = r14.getKeyCode();	 Catch:{ all -> 0x005d }
        r8 = r8[r9];	 Catch:{ all -> 0x005d }
        if (r8 == 0) goto L_0x0072;
    L_0x0132:
        r8 = r11.keyCount;	 Catch:{ all -> 0x005d }
        r8 = r8 + -1;
        r11.keyCount = r8;	 Catch:{ all -> 0x005d }
        r8 = r11.keys;	 Catch:{ all -> 0x005d }
        r9 = r14.getKeyCode();	 Catch:{ all -> 0x005d }
        r10 = 0;
        r8[r9] = r10;	 Catch:{ all -> 0x005d }
        goto L_0x0072;
    L_0x0143:
        r8 = r11.catchBack;
        if (r8 == 0) goto L_0x014d;
    L_0x0147:
        r8 = 4;
        if (r13 != r8) goto L_0x014d;
    L_0x014a:
        r8 = 1;
        goto L_0x0018;
    L_0x014d:
        r8 = r11.catchMenu;
        if (r8 == 0) goto L_0x0158;
    L_0x0151:
        r8 = 82;
        if (r13 != r8) goto L_0x0158;
    L_0x0155:
        r8 = 1;
        goto L_0x0018;
    L_0x0158:
        r8 = 0;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidInput.onKey(android.view.View, int, android.view.KeyEvent):boolean");
    }

    public void setOnscreenKeyboardVisible(final boolean visible) {
        this.handle.post(new Runnable() {
            public void run() {
                InputMethodManager manager = (InputMethodManager) AndroidInput.this.context.getSystemService("input_method");
                if (visible) {
                    View view = ((AndroidGraphics) AndroidInput.this.app.getGraphics()).getView();
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                    manager.showSoftInput(((AndroidGraphics) AndroidInput.this.app.getGraphics()).getView(), 0);
                    return;
                }
                manager.hideSoftInputFromWindow(((AndroidGraphics) AndroidInput.this.app.getGraphics()).getView().getWindowToken(), 0);
            }
        });
    }

    public void setCatchBackKey(boolean catchBack) {
        this.catchBack = catchBack;
    }

    public boolean isCatchBackKey() {
        return this.catchBack;
    }

    public void setCatchMenuKey(boolean catchMenu) {
        this.catchMenu = catchMenu;
    }

    public void vibrate(int milliseconds) {
        this.vibrator.vibrate((long) milliseconds);
    }

    public void vibrate(long[] pattern, int repeat) {
        this.vibrator.vibrate(pattern, repeat);
    }

    public void cancelVibrate() {
        this.vibrator.cancel();
    }

    public boolean justTouched() {
        return this.justTouched;
    }

    public boolean isButtonPressed(int button) {
        boolean z = true;
        synchronized (this) {
            if (this.hasMultitouch) {
                int pointer = 0;
                while (pointer < 20) {
                    if (this.touched[pointer] && this.button[pointer] == button) {
                        break;
                    }
                    pointer++;
                }
            }
            if (!(this.touched[0] && this.button[0] == button)) {
                z = false;
            }
        }
        return z;
    }

    private void updateOrientation() {
        if (SensorManager.getRotationMatrix(this.f141R, null, this.accelerometerValues, this.magneticFieldValues)) {
            SensorManager.getOrientation(this.f141R, this.orientation);
            this.azimuth = (float) Math.toDegrees((double) this.orientation[0]);
            this.pitch = (float) Math.toDegrees((double) this.orientation[1]);
            this.roll = (float) Math.toDegrees((double) this.orientation[2]);
        }
    }

    public void getRotationMatrix(float[] matrix) {
        SensorManager.getRotationMatrix(matrix, null, this.accelerometerValues, this.magneticFieldValues);
    }

    public float getAzimuth() {
        if (!this.compassAvailable) {
            return 0.0f;
        }
        updateOrientation();
        return this.azimuth;
    }

    public float getPitch() {
        if (!this.compassAvailable) {
            return 0.0f;
        }
        updateOrientation();
        return this.pitch;
    }

    public float getRoll() {
        if (!this.compassAvailable) {
            return 0.0f;
        }
        updateOrientation();
        return this.roll;
    }

    void registerSensorListeners() {
        if (this.config.useAccelerometer) {
            this.manager = (SensorManager) this.context.getSystemService("sensor");
            if (this.manager.getSensorList(1).size() == 0) {
                this.accelerometerAvailable = false;
            } else {
                Sensor accelerometer = (Sensor) this.manager.getSensorList(1).get(0);
                this.accelerometerListener = new SensorListener(this.nativeOrientation, this.accelerometerValues, this.magneticFieldValues);
                this.accelerometerAvailable = this.manager.registerListener(this.accelerometerListener, accelerometer, 1);
            }
        } else {
            this.accelerometerAvailable = false;
        }
        if (this.config.useCompass) {
            if (this.manager == null) {
                this.manager = (SensorManager) this.context.getSystemService("sensor");
            }
            Sensor sensor = this.manager.getDefaultSensor(2);
            if (sensor != null) {
                this.compassAvailable = this.accelerometerAvailable;
                if (this.compassAvailable) {
                    this.compassListener = new SensorListener(this.nativeOrientation, this.accelerometerValues, this.magneticFieldValues);
                    this.compassAvailable = this.manager.registerListener(this.compassListener, sensor, 1);
                }
            } else {
                this.compassAvailable = false;
            }
        } else {
            this.compassAvailable = false;
        }
        Gdx.app.log("AndroidInput", "sensor listener setup");
    }

    void unregisterSensorListeners() {
        if (this.manager != null) {
            if (this.accelerometerListener != null) {
                this.manager.unregisterListener(this.accelerometerListener);
                this.accelerometerListener = null;
            }
            if (this.compassListener != null) {
                this.manager.unregisterListener(this.compassListener);
                this.compassListener = null;
            }
            this.manager = null;
        }
        Gdx.app.log("AndroidInput", "sensor listener tear down");
    }

    public InputProcessor getInputProcessor() {
        return this.processor;
    }

    public boolean isPeripheralAvailable(Peripheral peripheral) {
        if (peripheral == Peripheral.Accelerometer) {
            return this.accelerometerAvailable;
        }
        if (peripheral == Peripheral.Compass) {
            return this.compassAvailable;
        }
        if (peripheral == Peripheral.HardwareKeyboard) {
            return this.keyboardAvailable;
        }
        if (peripheral == Peripheral.OnscreenKeyboard) {
            return true;
        }
        if (peripheral != Peripheral.Vibrator) {
            return peripheral == Peripheral.MultitouchScreen ? this.hasMultitouch : false;
        } else {
            if (this.vibrator == null) {
                return false;
            }
            return true;
        }
    }

    public int getFreePointerIndex() {
        int len = this.realId.length;
        for (int i = 0; i < len; i++) {
            if (this.realId[i] == -1) {
                return i;
            }
        }
        this.realId = resize(this.realId);
        this.touchX = resize(this.touchX);
        this.touchY = resize(this.touchY);
        this.deltaX = resize(this.deltaX);
        this.deltaY = resize(this.deltaY);
        this.touched = resize(this.touched);
        this.button = resize(this.button);
        return len;
    }

    private int[] resize(int[] orig) {
        int[] tmp = new int[(orig.length + 2)];
        System.arraycopy(orig, 0, tmp, 0, orig.length);
        return tmp;
    }

    private boolean[] resize(boolean[] orig) {
        boolean[] tmp = new boolean[(orig.length + 2)];
        System.arraycopy(orig, 0, tmp, 0, orig.length);
        return tmp;
    }

    public int lookUpPointerIndex(int pointerId) {
        int i;
        int len = this.realId.length;
        for (i = 0; i < len; i++) {
            if (this.realId[i] == pointerId) {
                return i;
            }
        }
        StringBuffer buf = new StringBuffer();
        for (i = 0; i < len; i++) {
            buf.append(i + ":" + this.realId[i] + " ");
        }
        Gdx.app.log("AndroidInput", "Pointer ID lookup failed: " + pointerId + ", " + buf.toString());
        return -1;
    }

    public int getRotation() {
        int orientation;
        if (this.context instanceof Activity) {
            orientation = ((Activity) this.context).getWindowManager().getDefaultDisplay().getRotation();
        } else {
            orientation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
        }
        switch (orientation) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    public Orientation getNativeOrientation() {
        return this.nativeOrientation;
    }

    public void setCursorCatched(boolean catched) {
    }

    public boolean isCursorCatched() {
        return false;
    }

    public int getDeltaX() {
        return this.deltaX[0];
    }

    public int getDeltaX(int pointer) {
        return this.deltaX[pointer];
    }

    public int getDeltaY() {
        return this.deltaY[0];
    }

    public int getDeltaY(int pointer) {
        return this.deltaY[pointer];
    }

    public void setCursorPosition(int x, int y) {
    }

    public void setCursorImage(Pixmap pixmap, int xHotspot, int yHotspot) {
    }

    public long getCurrentEventTime() {
        return this.currentEventTimeStamp;
    }

    public void addKeyListener(OnKeyListener listener) {
        this.keyListeners.add(listener);
    }

    public void onPause() {
        unregisterSensorListeners();
        Arrays.fill(this.realId, -1);
        Arrays.fill(this.touched, false);
    }

    public void onResume() {
        registerSensorListeners();
    }
}
