package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;

public class SelectBox<T> extends Widget implements Disableable {
    static final Vector2 temp = new Vector2();
    private final TextBounds bounds;
    private ClickListener clickListener;
    boolean disabled;
    final Array<T> items;
    private float prefHeight;
    private float prefWidth;
    SelectBoxList<T> selectBoxList;
    final ArraySelection<T> selection;
    SelectBoxStyle style;

    public static class SelectBoxStyle {
        public Drawable background;
        public Drawable backgroundDisabled;
        public Drawable backgroundOpen;
        public Drawable backgroundOver;
        public Color disabledFontColor;
        public BitmapFont font;
        public Color fontColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        public ListStyle listStyle;
        public ScrollPaneStyle scrollStyle;

        public SelectBoxStyle(BitmapFont font, Color fontColor, Drawable background, ScrollPaneStyle scrollStyle, ListStyle listStyle) {
            this.font = font;
            this.fontColor.set(fontColor);
            this.background = background;
            this.scrollStyle = scrollStyle;
            this.listStyle = listStyle;
        }

        public SelectBoxStyle(SelectBoxStyle style) {
            this.font = style.font;
            this.fontColor.set(style.fontColor);
            if (style.disabledFontColor != null) {
                this.disabledFontColor = new Color(style.disabledFontColor);
            }
            this.background = style.background;
            this.backgroundOver = style.backgroundOver;
            this.backgroundOpen = style.backgroundOpen;
            this.backgroundDisabled = style.backgroundDisabled;
            this.scrollStyle = new ScrollPaneStyle(style.scrollStyle);
            this.listStyle = new ListStyle(style.listStyle);
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.SelectBox$1 */
    class C10291 extends ClickListener {
        C10291() {
        }

        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if ((pointer == 0 && button != 0) || SelectBox.this.disabled) {
                return false;
            }
            if (SelectBox.this.selectBoxList.hasParent()) {
                SelectBox.this.hideList();
            } else {
                SelectBox.this.showList();
            }
            return true;
        }
    }

    static class SelectBoxList<T> extends ScrollPane {
        private InputListener hideListener;
        final List<T> list;
        int maxListCount;
        private Actor previousScrollFocus;
        private final Vector2 screenPosition = new Vector2();
        private final SelectBox<T> selectBox;

        public SelectBoxList(final SelectBox<T> selectBox) {
            super(null, selectBox.style.scrollStyle);
            this.selectBox = selectBox;
            setOverscroll(false, false);
            setFadeScrollBars(false);
            this.list = new List(selectBox.style.listStyle);
            this.list.setTouchable(Touchable.disabled);
            setWidget(this.list);
            this.list.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    selectBox.selection.choose(SelectBoxList.this.list.getSelected());
                    SelectBoxList.this.hide();
                }

                public boolean mouseMoved(InputEvent event, float x, float y) {
                    SelectBoxList.this.list.setSelectedIndex(Math.min(selectBox.items.size - 1, (int) ((SelectBoxList.this.list.getHeight() - y) / SelectBoxList.this.list.getItemHeight())));
                    return true;
                }
            });
            addListener(new InputListener() {
                public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                    if (toActor == null || !SelectBoxList.this.isAscendantOf(toActor)) {
                        SelectBoxList.this.list.selection.set(selectBox.getSelected());
                    }
                }
            });
            this.hideListener = new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    if (!SelectBoxList.this.isAscendantOf(event.getTarget())) {
                        SelectBoxList.this.list.selection.set(selectBox.getSelected());
                        SelectBoxList.this.hide();
                    }
                    return false;
                }

                public boolean keyDown(InputEvent event, int keycode) {
                    if (keycode == Keys.ESCAPE) {
                        SelectBoxList.this.hide();
                    }
                    return false;
                }
            };
        }

        public void show(Stage stage) {
            if (!this.list.isTouchable()) {
                int i;
                stage.removeCaptureListener(this.hideListener);
                stage.addCaptureListener(this.hideListener);
                stage.addActor(this);
                this.selectBox.localToStageCoordinates(this.screenPosition.set(0.0f, 0.0f));
                float itemHeight = this.list.getItemHeight();
                if (this.maxListCount <= 0) {
                    i = this.selectBox.items.size;
                } else {
                    i = Math.min(this.maxListCount, this.selectBox.items.size);
                }
                float height = itemHeight * ((float) i);
                Drawable scrollPaneBackground = getStyle().background;
                if (scrollPaneBackground != null) {
                    height += scrollPaneBackground.getTopHeight() + scrollPaneBackground.getBottomHeight();
                }
                Drawable listBackground = this.list.getStyle().background;
                if (listBackground != null) {
                    height += listBackground.getTopHeight() + listBackground.getBottomHeight();
                }
                float heightBelow = this.screenPosition.f159y;
                float heightAbove = (stage.getCamera().viewportHeight - this.screenPosition.f159y) - this.selectBox.getHeight();
                boolean below = true;
                if (height > heightBelow) {
                    if (heightAbove > heightBelow) {
                        below = false;
                        height = Math.min(height, heightAbove);
                    } else {
                        height = heightBelow;
                    }
                }
                if (below) {
                    setY(this.screenPosition.f159y - height);
                } else {
                    setY(this.screenPosition.f159y + this.selectBox.getHeight());
                }
                setX(this.screenPosition.f158x);
                setSize(Math.max(getPrefWidth(), this.selectBox.getWidth()), height);
                validate();
                scrollTo(0.0f, (this.list.getHeight() - (((float) this.selectBox.getSelectedIndex()) * itemHeight)) - (itemHeight / 2.0f), 0.0f, 0.0f, true, true);
                updateVisualScroll();
                this.previousScrollFocus = null;
                Actor actor = stage.getScrollFocus();
                if (!(actor == null || actor.isDescendantOf(this))) {
                    this.previousScrollFocus = actor;
                }
                stage.setScrollFocus(this);
                this.list.selection.set(this.selectBox.getSelected());
                this.list.setTouchable(Touchable.enabled);
                clearActions();
                this.selectBox.onShow(this, below);
            }
        }

        public void hide() {
            if (this.list.isTouchable() && hasParent()) {
                this.list.setTouchable(Touchable.disabled);
                Stage stage = getStage();
                if (stage != null) {
                    stage.removeCaptureListener(this.hideListener);
                    if (this.previousScrollFocus != null && this.previousScrollFocus.getStage() == null) {
                        this.previousScrollFocus = null;
                    }
                    Actor actor = stage.getScrollFocus();
                    if (actor == null || isAscendantOf(actor)) {
                        stage.setScrollFocus(this.previousScrollFocus);
                    }
                }
                clearActions();
                this.selectBox.onHide(this);
            }
        }

        public void draw(Batch batch, float parentAlpha) {
            this.selectBox.localToStageCoordinates(SelectBox.temp.set(0.0f, 0.0f));
            if (!SelectBox.temp.equals(this.screenPosition)) {
                hide();
            }
            super.draw(batch, parentAlpha);
        }

        public void act(float delta) {
            super.act(delta);
            toFront();
        }
    }

    public SelectBox(Skin skin) {
        this((SelectBoxStyle) skin.get(SelectBoxStyle.class));
    }

    public SelectBox(Skin skin, String styleName) {
        this((SelectBoxStyle) skin.get(styleName, SelectBoxStyle.class));
    }

    public SelectBox(SelectBoxStyle style) {
        this.items = new Array();
        this.selection = new ArraySelection(this.items);
        this.bounds = new TextBounds();
        setStyle(style);
        setSize(getPrefWidth(), getPrefHeight());
        this.selection.setActor(this);
        this.selection.setRequired(true);
        this.selectBoxList = new SelectBoxList(this);
        EventListener c10291 = new C10291();
        this.clickListener = c10291;
        addListener(c10291);
    }

    public void setMaxListCount(int maxListCount) {
        this.selectBoxList.maxListCount = maxListCount;
    }

    public int getMaxListCount() {
        return this.selectBoxList.maxListCount;
    }

    protected void setStage(Stage stage) {
        if (stage == null) {
            this.selectBoxList.hide();
        }
        super.setStage(stage);
    }

    public void setStyle(SelectBoxStyle style) {
        if (style == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = style;
        invalidateHierarchy();
    }

    public SelectBoxStyle getStyle() {
        return this.style;
    }

    public void setItems(T... newItems) {
        if (newItems == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float oldPrefWidth = getPrefWidth();
        this.items.clear();
        this.items.addAll((Object[]) newItems);
        this.selection.validate();
        this.selectBoxList.list.setItems(this.items);
        invalidate();
        if (oldPrefWidth != getPrefWidth()) {
            invalidateHierarchy();
        }
    }

    public void setItems(Array<T> newItems) {
        if (newItems == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float oldPrefWidth = getPrefWidth();
        this.items.clear();
        this.items.addAll((Array) newItems);
        this.selection.validate();
        this.selectBoxList.list.setItems(this.items);
        invalidate();
        if (oldPrefWidth != getPrefWidth()) {
            invalidateHierarchy();
        }
    }

    public void clearItems() {
        if (this.items.size != 0) {
            this.items.clear();
            this.selection.clear();
            invalidateHierarchy();
        }
    }

    public Array<T> getItems() {
        return this.items;
    }

    public void layout() {
        float f = 0.0f;
        Drawable bg = this.style.background;
        BitmapFont font = this.style.font;
        if (bg != null) {
            this.prefHeight = Math.max(((bg.getTopHeight() + bg.getBottomHeight()) + font.getCapHeight()) - (font.getDescent() * 2.0f), bg.getMinHeight());
        } else {
            this.prefHeight = font.getCapHeight() - (font.getDescent() * 2.0f);
        }
        float maxItemWidth = 0.0f;
        for (int i = 0; i < this.items.size; i++) {
            maxItemWidth = Math.max(font.getBounds(this.items.get(i).toString()).width, maxItemWidth);
        }
        this.prefWidth = maxItemWidth;
        if (bg != null) {
            this.prefWidth += bg.getLeftWidth() + bg.getRightWidth();
        }
        ListStyle listStyle = this.style.listStyle;
        ScrollPaneStyle scrollStyle = this.style.scrollStyle;
        float f2 = this.prefWidth;
        float rightWidth = listStyle.selection.getRightWidth() + (((scrollStyle.background == null ? 0.0f : scrollStyle.background.getLeftWidth() + scrollStyle.background.getRightWidth()) + maxItemWidth) + listStyle.selection.getLeftWidth());
        float minWidth = this.style.scrollStyle.vScroll != null ? this.style.scrollStyle.vScroll.getMinWidth() : 0.0f;
        if (this.style.scrollStyle.vScrollKnob != null) {
            f = this.style.scrollStyle.vScrollKnob.getMinWidth();
        }
        this.prefWidth = Math.max(f2, Math.max(minWidth, f) + rightWidth);
    }

    public void draw(Batch batch, float parentAlpha) {
        Drawable background;
        Color fontColor;
        validate();
        if (this.disabled && this.style.backgroundDisabled != null) {
            background = this.style.backgroundDisabled;
        } else if (this.selectBoxList.hasParent() && this.style.backgroundOpen != null) {
            background = this.style.backgroundOpen;
        } else if (this.clickListener.isOver() && this.style.backgroundOver != null) {
            background = this.style.backgroundOver;
        } else if (this.style.background != null) {
            background = this.style.background;
        } else {
            background = null;
        }
        BitmapFont font = this.style.font;
        if (!this.disabled || this.style.disabledFontColor == null) {
            fontColor = this.style.fontColor;
        } else {
            fontColor = this.style.disabledFontColor;
        }
        Color color = getColor();
        float x = getX();
        float y = getY();
        float width = getWidth();
        float height = getHeight();
        batch.setColor(color.f40r, color.f39g, color.f38b, color.f37a * parentAlpha);
        if (background != null) {
            background.draw(batch, x, y, width, height);
        }
        T selected = this.selection.first();
        if (selected != null) {
            String string = selected.toString();
            this.bounds.set(font.getBounds(string));
            if (background != null) {
                width -= background.getLeftWidth() + background.getRightWidth();
                x += background.getLeftWidth();
                y += (float) ((int) ((((height - (background.getBottomHeight() + background.getTopHeight())) / 2.0f) + background.getBottomHeight()) + (this.bounds.height / 2.0f)));
            } else {
                y += (float) ((int) ((height / 2.0f) + (this.bounds.height / 2.0f)));
            }
            int numGlyphs = font.computeVisibleGlyphs(string, 0, string.length(), width);
            font.setColor(fontColor.f40r, fontColor.f39g, fontColor.f38b, fontColor.f37a * parentAlpha);
            font.draw(batch, string, x, y, 0, numGlyphs);
        }
    }

    public ArraySelection<T> getSelection() {
        return this.selection;
    }

    public T getSelected() {
        return this.selection.first();
    }

    public void setSelected(T item) {
        if (this.items.contains(item, false)) {
            this.selection.set(item);
        } else if (this.items.size > 0) {
            this.selection.set(this.items.first());
        } else {
            this.selection.clear();
        }
    }

    public int getSelectedIndex() {
        ObjectSet<T> selected = this.selection.items();
        return selected.size == 0 ? -1 : this.items.indexOf(selected.first(), false);
    }

    public void setSelectedIndex(int index) {
        this.selection.set(this.items.get(index));
    }

    public void setDisabled(boolean disabled) {
        if (disabled && !this.disabled) {
            hideList();
        }
        this.disabled = disabled;
    }

    public float getPrefWidth() {
        validate();
        return this.prefWidth;
    }

    public float getPrefHeight() {
        validate();
        return this.prefHeight;
    }

    public void showList() {
        if (this.items.size != 0) {
            this.selectBoxList.show(getStage());
        }
    }

    public void hideList() {
        this.selectBoxList.hide();
    }

    public List<T> getList() {
        return this.selectBoxList.list;
    }

    public ScrollPane getScrollPane() {
        return this.selectBoxList;
    }

    protected void onShow(Actor selectBoxList, boolean below) {
        selectBoxList.getColor().f37a = 0.0f;
        selectBoxList.addAction(Actions.fadeIn(0.3f, Interpolation.fade));
    }

    protected void onHide(Actor selectBoxList) {
        selectBoxList.getColor().f37a = 1.0f;
        selectBoxList.addAction(Actions.sequence(Actions.fadeOut(0.15f, Interpolation.fade), Actions.removeActor()));
    }
}
