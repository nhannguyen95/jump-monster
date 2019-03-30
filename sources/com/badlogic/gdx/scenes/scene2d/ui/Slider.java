package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Pools;

public class Slider extends ProgressBar {
    int draggingPointer;

    public static class SliderStyle extends ProgressBarStyle {
        public SliderStyle(Drawable background, Drawable knob) {
            super(background, knob);
        }

        public SliderStyle(SliderStyle style) {
            super(style);
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Slider$1 */
    class C08831 extends InputListener {
        C08831() {
        }

        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if (Slider.this.disabled || Slider.this.draggingPointer != -1) {
                return false;
            }
            Slider.this.draggingPointer = pointer;
            Slider.this.calculatePositionAndValue(x, y);
            return true;
        }

        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            if (pointer == Slider.this.draggingPointer) {
                Slider.this.draggingPointer = -1;
                if (!Slider.this.calculatePositionAndValue(x, y)) {
                    ChangeEvent changeEvent = (ChangeEvent) Pools.obtain(ChangeEvent.class);
                    Slider.this.fire(changeEvent);
                    Pools.free(changeEvent);
                }
            }
        }

        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            Slider.this.calculatePositionAndValue(x, y);
        }
    }

    public Slider(float min, float max, float stepSize, boolean vertical, Skin skin) {
        this(min, max, stepSize, vertical, (SliderStyle) skin.get("default-" + (vertical ? "vertical" : "horizontal"), SliderStyle.class));
    }

    public Slider(float min, float max, float stepSize, boolean vertical, Skin skin, String styleName) {
        this(min, max, stepSize, vertical, (SliderStyle) skin.get(styleName, SliderStyle.class));
    }

    public Slider(float min, float max, float stepSize, boolean vertical, SliderStyle style) {
        super(min, max, stepSize, vertical, (ProgressBarStyle) style);
        this.draggingPointer = -1;
        this.shiftIgnoresSnap = true;
        addListener(new C08831());
    }

    public void setStyle(SliderStyle style) {
        if (style == null) {
            throw new NullPointerException("style cannot be null");
        } else if (style instanceof SliderStyle) {
            super.setStyle(style);
        } else {
            throw new IllegalArgumentException("style must be a SliderStyle.");
        }
    }

    public SliderStyle getStyle() {
        return (SliderStyle) super.getStyle();
    }

    boolean calculatePositionAndValue(float x, float y) {
        float value;
        SliderStyle style = getStyle();
        Drawable knob = (!this.disabled || style.disabledKnob == null) ? style.knob : style.disabledKnob;
        Drawable bg = (!this.disabled || style.disabledBackground == null) ? style.background : style.disabledBackground;
        float oldPosition = this.position;
        float min = getMinValue();
        float max = getMaxValue();
        if (this.vertical) {
            float height = (getHeight() - bg.getTopHeight()) - bg.getBottomHeight();
            float knobHeight = knob == null ? 0.0f : knob.getMinHeight();
            this.position = (y - bg.getBottomHeight()) - (0.5f * knobHeight);
            value = min + ((max - min) * (this.position / (height - knobHeight)));
            this.position = Math.max(0.0f, this.position);
            this.position = Math.min(height - knobHeight, this.position);
        } else {
            float width = (getWidth() - bg.getLeftWidth()) - bg.getRightWidth();
            float knobWidth = knob == null ? 0.0f : knob.getMinWidth();
            this.position = (x - bg.getLeftWidth()) - (0.5f * knobWidth);
            value = min + ((max - min) * (this.position / (width - knobWidth)));
            this.position = Math.max(0.0f, this.position);
            this.position = Math.min(width - knobWidth, this.position);
        }
        float oldValue = value;
        boolean valueSet = setValue(value);
        if (value == oldValue) {
            this.position = oldPosition;
        }
        return valueSet;
    }

    public boolean isDragging() {
        return this.draggingPointer != -1;
    }
}
