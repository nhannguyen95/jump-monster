package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public abstract class Value {
    public static Value maxHeight = new C05086();
    public static Value maxWidth = new C05075();
    public static Value minHeight = new C05042();
    public static Value minWidth = new C05031();
    public static Value prefHeight = new C05064();
    public static Value prefWidth = new C05053();
    public static final Fixed zero = new Fixed(0.0f);

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$1 */
    static class C05031 extends Value {
        C05031() {
        }

        public float get(Actor context) {
            if (context instanceof Layout) {
                return ((Layout) context).getMinWidth();
            }
            return context == null ? 0.0f : context.getWidth();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$2 */
    static class C05042 extends Value {
        C05042() {
        }

        public float get(Actor context) {
            if (context instanceof Layout) {
                return ((Layout) context).getMinHeight();
            }
            return context == null ? 0.0f : context.getHeight();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$3 */
    static class C05053 extends Value {
        C05053() {
        }

        public float get(Actor context) {
            if (context instanceof Layout) {
                return ((Layout) context).getPrefWidth();
            }
            return context == null ? 0.0f : context.getWidth();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$4 */
    static class C05064 extends Value {
        C05064() {
        }

        public float get(Actor context) {
            if (context instanceof Layout) {
                return ((Layout) context).getPrefHeight();
            }
            return context == null ? 0.0f : context.getHeight();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$5 */
    static class C05075 extends Value {
        C05075() {
        }

        public float get(Actor context) {
            if (context instanceof Layout) {
                return ((Layout) context).getMaxWidth();
            }
            return context == null ? 0.0f : context.getWidth();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$6 */
    static class C05086 extends Value {
        C05086() {
        }

        public float get(Actor context) {
            if (context instanceof Layout) {
                return ((Layout) context).getMaxHeight();
            }
            return context == null ? 0.0f : context.getHeight();
        }
    }

    public static class Fixed extends Value {
        private final float value;

        public Fixed(float value) {
            this.value = value;
        }

        public float get(Actor context) {
            return this.value;
        }
    }

    public abstract float get(Actor actor);

    public static Value percentWidth(final float percent) {
        return new Value() {
            public float get(Actor actor) {
                return actor.getWidth() * percent;
            }
        };
    }

    public static Value percentHeight(final float percent) {
        return new Value() {
            public float get(Actor actor) {
                return actor.getHeight() * percent;
            }
        };
    }

    public static Value percentWidth(final float percent, final Actor actor) {
        if (actor != null) {
            return new Value() {
                public float get(Actor context) {
                    return actor.getWidth() * percent;
                }
            };
        }
        throw new IllegalArgumentException("actor cannot be null.");
    }

    public static Value percentHeight(final float percent, final Actor actor) {
        if (actor != null) {
            return new Value() {
                public float get(Actor context) {
                    return actor.getHeight() * percent;
                }
            };
        }
        throw new IllegalArgumentException("actor cannot be null.");
    }
}
