package com.badlogic.gdx.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GestureDetector extends InputAdapter {
    private long gestureStartTime;
    private boolean inTapSquare;
    private final Vector2 initialPointer1;
    private final Vector2 initialPointer2;
    private int lastTapButton;
    private int lastTapPointer;
    private long lastTapTime;
    private float lastTapX;
    private float lastTapY;
    final GestureListener listener;
    boolean longPressFired;
    private float longPressSeconds;
    private final Task longPressTask;
    private long maxFlingDelay;
    private boolean panning;
    private boolean pinching;
    Vector2 pointer1;
    private final Vector2 pointer2;
    private int tapCount;
    private long tapCountInterval;
    private float tapSquareCenterX;
    private float tapSquareCenterY;
    private float tapSquareSize;
    private final VelocityTracker tracker;

    public interface GestureListener {
        boolean fling(float f, float f2, int i);

        boolean longPress(float f, float f2);

        boolean pan(float f, float f2, float f3, float f4);

        boolean panStop(float f, float f2, int i, int i2);

        boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24);

        boolean tap(float f, float f2, int i, int i2);

        boolean touchDown(float f, float f2, int i, int i2);

        boolean zoom(float f, float f2);
    }

    static class VelocityTracker {
        float deltaX;
        float deltaY;
        long lastTime;
        float lastX;
        float lastY;
        long[] meanTime = new long[this.sampleSize];
        float[] meanX = new float[this.sampleSize];
        float[] meanY = new float[this.sampleSize];
        int numSamples;
        int sampleSize = 10;

        VelocityTracker() {
        }

        public void start(float x, float y, long timeStamp) {
            this.lastX = x;
            this.lastY = y;
            this.deltaX = 0.0f;
            this.deltaY = 0.0f;
            this.numSamples = 0;
            for (int i = 0; i < this.sampleSize; i++) {
                this.meanX[i] = 0.0f;
                this.meanY[i] = 0.0f;
                this.meanTime[i] = 0;
            }
            this.lastTime = timeStamp;
        }

        public void update(float x, float y, long timeStamp) {
            long currTime = timeStamp;
            this.deltaX = x - this.lastX;
            this.deltaY = y - this.lastY;
            this.lastX = x;
            this.lastY = y;
            long deltaTime = currTime - this.lastTime;
            this.lastTime = currTime;
            int index = this.numSamples % this.sampleSize;
            this.meanX[index] = this.deltaX;
            this.meanY[index] = this.deltaY;
            this.meanTime[index] = deltaTime;
            this.numSamples++;
        }

        public float getVelocityX() {
            float meanX = getAverage(this.meanX, this.numSamples);
            float meanTime = ((float) getAverage(this.meanTime, this.numSamples)) / 1.0E9f;
            if (meanTime == 0.0f) {
                return 0.0f;
            }
            return meanX / meanTime;
        }

        public float getVelocityY() {
            float meanY = getAverage(this.meanY, this.numSamples);
            float meanTime = ((float) getAverage(this.meanTime, this.numSamples)) / 1.0E9f;
            if (meanTime == 0.0f) {
                return 0.0f;
            }
            return meanY / meanTime;
        }

        private float getAverage(float[] values, int numSamples) {
            numSamples = Math.min(this.sampleSize, numSamples);
            float sum = 0.0f;
            for (int i = 0; i < numSamples; i++) {
                sum += values[i];
            }
            return sum / ((float) numSamples);
        }

        private long getAverage(long[] values, int numSamples) {
            numSamples = Math.min(this.sampleSize, numSamples);
            long sum = 0;
            for (int i = 0; i < numSamples; i++) {
                sum += values[i];
            }
            if (numSamples == 0) {
                return 0;
            }
            return sum / ((long) numSamples);
        }

        private float getSum(float[] values, int numSamples) {
            numSamples = Math.min(this.sampleSize, numSamples);
            float sum = 0.0f;
            for (int i = 0; i < numSamples; i++) {
                sum += values[i];
            }
            if (numSamples == 0) {
                return 0.0f;
            }
            return sum;
        }
    }

    /* renamed from: com.badlogic.gdx.input.GestureDetector$1 */
    class C04861 extends Task {
        C04861() {
        }

        public void run() {
            if (!GestureDetector.this.longPressFired) {
                GestureDetector.this.longPressFired = GestureDetector.this.listener.longPress(GestureDetector.this.pointer1.f158x, GestureDetector.this.pointer1.f159y);
            }
        }
    }

    public static class GestureAdapter implements GestureListener {
        public boolean touchDown(float x, float y, int pointer, int button) {
            return false;
        }

        public boolean tap(float x, float y, int count, int button) {
            return false;
        }

        public boolean longPress(float x, float y) {
            return false;
        }

        public boolean fling(float velocityX, float velocityY, int button) {
            return false;
        }

        public boolean pan(float x, float y, float deltaX, float deltaY) {
            return false;
        }

        public boolean panStop(float x, float y, int pointer, int button) {
            return false;
        }

        public boolean zoom(float initialDistance, float distance) {
            return false;
        }

        public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
            return false;
        }
    }

    public GestureDetector(GestureListener listener) {
        this(20.0f, 0.4f, 1.1f, 0.15f, listener);
    }

    public GestureDetector(float halfTapSquareSize, float tapCountInterval, float longPressDuration, float maxFlingDelay, GestureListener listener) {
        this.tracker = new VelocityTracker();
        this.pointer1 = new Vector2();
        this.pointer2 = new Vector2();
        this.initialPointer1 = new Vector2();
        this.initialPointer2 = new Vector2();
        this.longPressTask = new C04861();
        this.tapSquareSize = halfTapSquareSize;
        this.tapCountInterval = (long) (tapCountInterval * 1.0E9f);
        this.longPressSeconds = longPressDuration;
        this.maxFlingDelay = (long) (maxFlingDelay * 1.0E9f);
        this.listener = listener;
    }

    public boolean touchDown(int x, int y, int pointer, int button) {
        return touchDown((float) x, (float) y, pointer, button);
    }

    public boolean touchDown(float x, float y, int pointer, int button) {
        if (pointer > 1) {
            return false;
        }
        if (pointer == 0) {
            this.pointer1.set(x, y);
            this.gestureStartTime = Gdx.input.getCurrentEventTime();
            this.tracker.start(x, y, this.gestureStartTime);
            if (Gdx.input.isTouched(1)) {
                this.inTapSquare = false;
                this.pinching = true;
                this.initialPointer1.set(this.pointer1);
                this.initialPointer2.set(this.pointer2);
                this.longPressTask.cancel();
            } else {
                this.inTapSquare = true;
                this.pinching = false;
                this.longPressFired = false;
                this.tapSquareCenterX = x;
                this.tapSquareCenterY = y;
                if (!this.longPressTask.isScheduled()) {
                    Timer.schedule(this.longPressTask, this.longPressSeconds);
                }
            }
        } else {
            this.pointer2.set(x, y);
            this.inTapSquare = false;
            this.pinching = true;
            this.initialPointer1.set(this.pointer1);
            this.initialPointer2.set(this.pointer2);
            this.longPressTask.cancel();
        }
        return this.listener.touchDown(x, y, pointer, button);
    }

    public boolean touchDragged(int x, int y, int pointer) {
        return touchDragged((float) x, (float) y, pointer);
    }

    public boolean touchDragged(float x, float y, int pointer) {
        if (pointer > 1 || this.longPressFired) {
            return false;
        }
        if (pointer == 0) {
            this.pointer1.set(x, y);
        } else {
            this.pointer2.set(x, y);
        }
        if (!this.pinching) {
            this.tracker.update(x, y, Gdx.input.getCurrentEventTime());
            if (this.inTapSquare && !isWithinTapSquare(x, y, this.tapSquareCenterX, this.tapSquareCenterY)) {
                this.longPressTask.cancel();
                this.inTapSquare = false;
            }
            if (this.inTapSquare) {
                return false;
            }
            this.panning = true;
            return this.listener.pan(x, y, this.tracker.deltaX, this.tracker.deltaY);
        } else if (this.listener == null) {
            return false;
        } else {
            boolean result = this.listener.pinch(this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
            if (this.listener.zoom(this.initialPointer1.dst(this.initialPointer2), this.pointer1.dst(this.pointer2)) || result) {
                return true;
            }
            return false;
        }
    }

    public boolean touchUp(int x, int y, int pointer, int button) {
        return touchUp((float) x, (float) y, pointer, button);
    }

    public boolean touchUp(float x, float y, int pointer, int button) {
        if (pointer > 1) {
            return false;
        }
        if (this.inTapSquare && !isWithinTapSquare(x, y, this.tapSquareCenterX, this.tapSquareCenterY)) {
            this.inTapSquare = false;
        }
        boolean wasPanning = this.panning;
        this.panning = false;
        this.longPressTask.cancel();
        if (this.longPressFired) {
            return false;
        }
        if (this.inTapSquare) {
            if (!(this.lastTapButton == button && this.lastTapPointer == pointer && TimeUtils.nanoTime() - this.lastTapTime <= this.tapCountInterval && isWithinTapSquare(x, y, this.lastTapX, this.lastTapY))) {
                this.tapCount = 0;
            }
            this.tapCount++;
            this.lastTapTime = TimeUtils.nanoTime();
            this.lastTapX = x;
            this.lastTapY = y;
            this.lastTapButton = button;
            this.lastTapPointer = pointer;
            this.gestureStartTime = 0;
            return this.listener.tap(x, y, this.tapCount, button);
        } else if (this.pinching) {
            this.pinching = false;
            this.panning = true;
            if (pointer == 0) {
                this.tracker.start(this.pointer2.f158x, this.pointer2.f159y, Gdx.input.getCurrentEventTime());
                return false;
            }
            this.tracker.start(this.pointer1.f158x, this.pointer1.f159y, Gdx.input.getCurrentEventTime());
            return false;
        } else {
            boolean handled = false;
            if (wasPanning && !this.panning) {
                handled = this.listener.panStop(x, y, pointer, button);
            }
            this.gestureStartTime = 0;
            long time = Gdx.input.getCurrentEventTime();
            if (time - this.tracker.lastTime < this.maxFlingDelay) {
                this.tracker.update(x, y, time);
                if (this.listener.fling(this.tracker.getVelocityX(), this.tracker.getVelocityY(), button) || handled) {
                    handled = true;
                } else {
                    handled = false;
                }
            }
            return handled;
        }
    }

    public void cancel() {
        this.longPressTask.cancel();
        this.longPressFired = true;
    }

    public boolean isLongPressed() {
        return isLongPressed(this.longPressSeconds);
    }

    public boolean isLongPressed(float duration) {
        if (this.gestureStartTime != 0 && TimeUtils.nanoTime() - this.gestureStartTime > ((long) (1.0E9f * duration))) {
            return true;
        }
        return false;
    }

    public boolean isPanning() {
        return this.panning;
    }

    public void reset() {
        this.gestureStartTime = 0;
        this.panning = false;
        this.inTapSquare = false;
    }

    private boolean isWithinTapSquare(float x, float y, float centerX, float centerY) {
        return Math.abs(x - centerX) < this.tapSquareSize && Math.abs(y - centerY) < this.tapSquareSize;
    }

    public void invalidateTapSquare() {
        this.inTapSquare = false;
    }

    public void setTapSquareSize(float halfTapSquareSize) {
        this.tapSquareSize = halfTapSquareSize;
    }

    public void setTapCountInterval(float tapCountInterval) {
        this.tapCountInterval = (long) (1.0E9f * tapCountInterval);
    }

    public void setLongPressSeconds(float longPressSeconds) {
        this.longPressSeconds = longPressSeconds;
    }

    public void setMaxFlingDelay(long maxFlingDelay) {
        this.maxFlingDelay = maxFlingDelay;
    }
}
