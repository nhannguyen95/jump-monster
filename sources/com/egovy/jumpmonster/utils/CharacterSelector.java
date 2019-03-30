package com.egovy.jumpmonster.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.egovy.jumpmonster.game.Assets;
import java.util.Iterator;

public class CharacterSelector extends Table {
    public Image buttonLeft = new Image(new TextureRegionDrawable(new TextureRegion(Assets.instance.leftArrow)));
    public Image buttonRight = new Image(new TextureRegionDrawable(new TextureRegion(Assets.instance.rightArrow)));
    private Array<Character> characters;
    private int currentCharacterIndex = 0;
    private float imageHeight = 71.0f;
    private float imageWidth = 67.0f;

    public static class Character {
        private Image image;
        private Label title;

        public Character(CharSequence unlock_condition) {
            LabelStyle style = new LabelStyle();
            style.font = new BitmapFont(Gdx.files.internal(Constants.CHARACTER_UNLOCK_FONT));
            style.fontColor = Color.WHITE;
            this.title = new Label(unlock_condition, style);
        }

        public void setImage(Image img) {
            this.image = img;
        }

        public Label getTitle() {
            return this.title;
        }

        public Image getImage() {
            return this.image;
        }
    }

    /* renamed from: com.egovy.jumpmonster.utils.CharacterSelector$1 */
    class C10411 extends ClickListener {
        C10411() {
        }

        public void clicked(InputEvent event, float x, float y) {
            CharacterSelector.this.showPreviousCharacter();
        }
    }

    /* renamed from: com.egovy.jumpmonster.utils.CharacterSelector$2 */
    class C10422 extends ClickListener {
        C10422() {
        }

        public void clicked(InputEvent event, float x, float y) {
            CharacterSelector.this.showNextCharacter();
        }
    }

    public CharacterSelector() {
        invalidateHierarchy();
        initialize();
        setSize(getPrefWidth(), getPrefHeight());
    }

    private void showPreviousCharacter() {
        if (this.currentCharacterIndex > 0) {
            this.currentCharacterIndex--;
            update();
        }
    }

    private void showNextCharacter() {
        if (this.currentCharacterIndex + 1 < this.characters.size) {
            this.currentCharacterIndex++;
            update();
        }
    }

    private void initialize() {
        setTouchable(Touchable.enabled);
        this.characters = new Array();
        this.buttonLeft.addListener(new C10411());
        this.buttonRight.addListener(new C10422());
    }

    private void update() {
        if (this.characters.size != 0) {
            clearChildren();
            Character currentCharacter = (Character) this.characters.get(this.currentCharacterIndex);
            add(this.buttonLeft).colspan(1).padRight(20.0f);
            add(currentCharacter.getImage()).colspan(1).size(this.imageWidth, this.imageHeight);
            add(this.buttonRight).colspan(1).padLeft(20.0f);
            row();
            add(currentCharacter.getTitle()).colspan(3).expand();
            pad(20.0f);
            pack();
        }
    }

    public void addCharacter(Character character) {
        if (!(character == null || this.characters.contains(character, false))) {
            this.characters.add(character);
        }
        update();
    }

    public void addCharacters(Array<Character> array) {
        Iterator it = array.iterator();
        while (it.hasNext()) {
            addCharacter((Character) it.next());
        }
        update();
    }

    public Array<Character> getCharacters() {
        return this.characters;
    }

    public int getCurrentCharacterIndex() {
        return this.currentCharacterIndex;
    }
}
