package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class TextField extends Widget implements Disableable {
    private static final char BACKSPACE = '\b';
    private static final char BULLET = '';
    private static final char DELETE = '';
    protected static final char ENTER_ANDROID = '\n';
    protected static final char ENTER_DESKTOP = '\r';
    private static final char TAB = '\t';
    public static float keyRepeatInitialTime = 0.4f;
    public static float keyRepeatTime = 0.1f;
    private static final Vector2 tmp1 = new Vector2();
    private static final Vector2 tmp2 = new Vector2();
    private static final Vector2 tmp3 = new Vector2();
    private float blinkTime;
    private Clipboard clipboard;
    protected int cursor;
    boolean cursorOn;
    boolean disabled;
    protected CharSequence displayText;
    TextFieldFilter filter;
    boolean focusTraversal;
    protected final FloatArray glyphAdvances;
    protected final FloatArray glyphPositions;
    protected boolean hasSelection;
    InputListener inputListener;
    KeyRepeatTask keyRepeatTask;
    OnscreenKeyboard keyboard;
    long lastBlink;
    TextFieldListener listener;
    private int maxLength;
    private String messageText;
    boolean onlyFontChars;
    private StringBuilder passwordBuffer;
    private char passwordCharacter;
    boolean passwordMode;
    float renderOffset;
    protected int selectionStart;
    private float selectionWidth;
    private float selectionX;
    TextFieldStyle style;
    protected String text;
    private int textHAlign;
    protected float textHeight;
    protected float textOffset;
    private int visibleTextEnd;
    private int visibleTextStart;
    protected boolean writeEnters;

    public interface OnscreenKeyboard {
        void show(boolean z);
    }

    public interface TextFieldFilter {

        public static class DigitsOnlyFilter implements TextFieldFilter {
            public boolean acceptChar(TextField textField, char c) {
                return Character.isDigit(c);
            }
        }

        boolean acceptChar(TextField textField, char c);
    }

    public interface TextFieldListener {
        void keyTyped(TextField textField, char c);
    }

    public static class TextFieldStyle {
        public Drawable background;
        public Drawable cursor;
        public Drawable disabledBackground;
        public Color disabledFontColor;
        public Drawable focusedBackground;
        public Color focusedFontColor;
        public BitmapFont font;
        public Color fontColor;
        public BitmapFont messageFont;
        public Color messageFontColor;
        public Drawable selection;

        public TextFieldStyle(BitmapFont font, Color fontColor, Drawable cursor, Drawable selection, Drawable background) {
            this.background = background;
            this.cursor = cursor;
            this.font = font;
            this.fontColor = fontColor;
            this.selection = selection;
        }

        public TextFieldStyle(TextFieldStyle style) {
            this.messageFont = style.messageFont;
            if (style.messageFontColor != null) {
                this.messageFontColor = new Color(style.messageFontColor);
            }
            this.background = style.background;
            this.focusedBackground = style.focusedBackground;
            this.disabledBackground = style.disabledBackground;
            this.cursor = style.cursor;
            this.font = style.font;
            if (style.fontColor != null) {
                this.fontColor = new Color(style.fontColor);
            }
            if (style.focusedFontColor != null) {
                this.focusedFontColor = new Color(style.focusedFontColor);
            }
            if (style.disabledFontColor != null) {
                this.disabledFontColor = new Color(style.disabledFontColor);
            }
            this.selection = style.selection;
        }
    }

    public static class DefaultOnscreenKeyboard implements OnscreenKeyboard {
        public void show(boolean visible) {
            Gdx.input.setOnscreenKeyboardVisible(visible);
        }
    }

    class KeyRepeatTask extends Task {
        int keycode;

        KeyRepeatTask() {
        }

        public void run() {
            TextField.this.inputListener.keyDown(null, this.keycode);
        }
    }

    public class TextFieldClickListener extends ClickListener {
        public void clicked(InputEvent event, float x, float y) {
            int count = getTapCount() % 4;
            if (count == 0) {
                TextField.this.clearSelection();
            }
            if (count == 2) {
                int[] array = TextField.this.wordUnderCursor(x);
                TextField.this.setSelection(array[0], array[1]);
            }
            if (count == 3) {
                TextField.this.selectAll();
            }
        }

        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if (!super.touchDown(event, x, y, pointer, button)) {
                return false;
            }
            if (pointer == 0 && button != 0) {
                return false;
            }
            if (TextField.this.disabled) {
                return true;
            }
            setCursorPosition(x, y);
            TextField.this.selectionStart = TextField.this.cursor;
            Stage stage = TextField.this.getStage();
            if (stage != null) {
                stage.setKeyboardFocus(TextField.this);
            }
            TextField.this.keyboard.show(true);
            TextField.this.hasSelection = true;
            return true;
        }

        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            super.touchDragged(event, x, y, pointer);
            setCursorPosition(x, y);
        }

        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            if (TextField.this.selectionStart == TextField.this.cursor) {
                TextField.this.hasSelection = false;
            }
            super.touchUp(event, x, y, pointer, button);
        }

        protected void setCursorPosition(float x, float y) {
            TextField.this.lastBlink = 0;
            TextField.this.cursorOn = false;
            TextField.this.cursor = TextField.this.letterUnderCursor(x);
        }

        protected void goHome(boolean jump) {
            TextField.this.cursor = 0;
        }

        protected void goEnd(boolean jump) {
            TextField.this.cursor = TextField.this.text.length();
        }

        public boolean keyDown(InputEvent event, int keycode) {
            if (TextField.this.disabled) {
                return false;
            }
            TextField.this.lastBlink = 0;
            TextField.this.cursorOn = false;
            Stage stage = TextField.this.getStage();
            if (stage == null || stage.getKeyboardFocus() != TextField.this) {
                return false;
            }
            boolean jump;
            boolean repeat = false;
            boolean ctrl = UIUtils.ctrl();
            if (!ctrl || TextField.this.passwordMode) {
                jump = false;
            } else {
                jump = true;
            }
            if (ctrl) {
                if (keycode == 50) {
                    TextField.this.paste();
                    repeat = true;
                }
                if (keycode == 31 || keycode == Keys.INSERT) {
                    TextField.this.copy();
                    return true;
                } else if (keycode == 52 || keycode == 67) {
                    TextField.this.cut();
                    return true;
                } else if (keycode == 29) {
                    TextField.this.selectAll();
                    return true;
                }
            }
            if (UIUtils.shift()) {
                if (keycode == Keys.INSERT) {
                    TextField.this.paste();
                }
                if (keycode == Keys.FORWARD_DEL && TextField.this.hasSelection) {
                    TextField.this.copy();
                    TextField.this.delete();
                }
                int temp = TextField.this.cursor;
                if (keycode == 21) {
                    TextField.this.moveCursor(false, jump);
                    repeat = true;
                } else if (keycode == 22) {
                    TextField.this.moveCursor(true, jump);
                    repeat = true;
                } else if (keycode == 3) {
                    goHome(jump);
                } else if (keycode == Keys.END) {
                    goEnd(jump);
                }
                if (!TextField.this.hasSelection) {
                    TextField.this.selectionStart = temp;
                    TextField.this.hasSelection = true;
                }
            } else {
                if (keycode == 21) {
                    TextField.this.moveCursor(false, jump);
                    TextField.this.clearSelection();
                    repeat = true;
                }
                if (keycode == 22) {
                    TextField.this.moveCursor(true, jump);
                    TextField.this.clearSelection();
                    repeat = true;
                }
                if (keycode == 3) {
                    goHome(jump);
                    TextField.this.clearSelection();
                }
                if (keycode == Keys.END) {
                    goEnd(jump);
                    TextField.this.clearSelection();
                }
            }
            TextField.this.cursor = MathUtils.clamp(TextField.this.cursor, 0, TextField.this.text.length());
            if (repeat) {
                scheduleKeyRepeatTask(keycode);
            }
            return true;
        }

        protected void scheduleKeyRepeatTask(int keycode) {
            if (!TextField.this.keyRepeatTask.isScheduled() || TextField.this.keyRepeatTask.keycode != keycode) {
                TextField.this.keyRepeatTask.keycode = keycode;
                TextField.this.keyRepeatTask.cancel();
                Timer.schedule(TextField.this.keyRepeatTask, TextField.keyRepeatInitialTime, TextField.keyRepeatTime);
            }
        }

        public boolean keyUp(InputEvent event, int keycode) {
            if (TextField.this.disabled) {
                return false;
            }
            TextField.this.keyRepeatTask.cancel();
            return true;
        }

        public boolean keyTyped(InputEvent event, char character) {
            if (TextField.this.disabled) {
                return false;
            }
            if (character == '\u0000') {
                return false;
            }
            Stage stage = TextField.this.getStage();
            if (stage == null || stage.getKeyboardFocus() != TextField.this) {
                return false;
            }
            if ((character == TextField.TAB || character == TextField.ENTER_ANDROID) && TextField.this.focusTraversal) {
                TextField.this.next(UIUtils.shift());
            } else {
                boolean delete = character == TextField.DELETE;
                boolean backspace = character == TextField.BACKSPACE;
                boolean add = TextField.this.style.font.containsCharacter(character) || (TextField.this.writeEnters && (character == TextField.ENTER_ANDROID || character == TextField.ENTER_DESKTOP));
                boolean remove = backspace || delete;
                if (add || remove) {
                    TextField textField;
                    if (TextField.this.hasSelection) {
                        TextField.this.cursor = TextField.this.delete(false);
                    } else {
                        if (backspace && TextField.this.cursor > 0) {
                            textField = TextField.this;
                            StringBuilder append = new StringBuilder().append(TextField.this.text.substring(0, TextField.this.cursor - 1));
                            String str = TextField.this.text;
                            TextField textField2 = TextField.this;
                            int i = textField2.cursor;
                            textField2.cursor = i - 1;
                            textField.text = append.append(str.substring(i)).toString();
                            TextField.this.renderOffset = 0.0f;
                        }
                        if (delete && TextField.this.cursor < TextField.this.text.length()) {
                            TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor) + TextField.this.text.substring(TextField.this.cursor + 1);
                        }
                    }
                    if (add && !remove) {
                        boolean isEnter = character == TextField.ENTER_DESKTOP || character == TextField.ENTER_ANDROID;
                        if (!isEnter && TextField.this.filter != null && !TextField.this.filter.acceptChar(TextField.this, character)) {
                            return true;
                        }
                        if (!TextField.this.withinMaxLength(TextField.this.text.length())) {
                            return true;
                        }
                        String insertion = isEnter ? "\n" : String.valueOf(character);
                        textField = TextField.this;
                        TextField textField3 = TextField.this;
                        TextField textField4 = TextField.this;
                        int i2 = textField4.cursor;
                        textField4.cursor = i2 + 1;
                        textField.text = textField3.insert(i2, insertion, TextField.this.text);
                    }
                    TextField.this.updateDisplayText();
                }
            }
            if (TextField.this.listener != null) {
                TextField.this.listener.keyTyped(TextField.this, character);
            }
            return true;
        }
    }

    public TextField(String text, Skin skin) {
        this(text, (TextFieldStyle) skin.get(TextFieldStyle.class));
    }

    public TextField(String text, Skin skin, String styleName) {
        this(text, (TextFieldStyle) skin.get(styleName, TextFieldStyle.class));
    }

    public TextField(String text, TextFieldStyle style) {
        this.glyphAdvances = new FloatArray();
        this.glyphPositions = new FloatArray();
        this.keyboard = new DefaultOnscreenKeyboard();
        this.focusTraversal = true;
        this.onlyFontChars = true;
        this.textHAlign = 8;
        this.passwordCharacter = BULLET;
        this.maxLength = 0;
        this.blinkTime = 0.32f;
        this.cursorOn = true;
        this.keyRepeatTask = new KeyRepeatTask();
        setStyle(style);
        this.clipboard = Gdx.app.getClipboard();
        initialize();
        setText(text);
        setSize(getPrefWidth(), getPrefHeight());
    }

    protected void initialize() {
        this.writeEnters = false;
        EventListener createInputListener = createInputListener();
        this.inputListener = createInputListener;
        addListener(createInputListener);
    }

    protected InputListener createInputListener() {
        return new TextFieldClickListener();
    }

    protected int letterUnderCursor(float x) {
        x -= this.renderOffset + this.textOffset;
        int index = this.glyphPositions.size - 1;
        float[] glyphPositions = this.glyphPositions.items;
        int n = this.glyphPositions.size;
        for (int i = 0; i < n; i++) {
            if (glyphPositions[i] > x) {
                index = i - 1;
                break;
            }
        }
        return Math.max(0, index);
    }

    protected boolean isWordCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

    protected int[] wordUnderCursor(int at) {
        int index;
        String text = this.text;
        int start = at;
        int right = text.length();
        int left = 0;
        for (index = start; index < right; index++) {
            if (!isWordCharacter(text.charAt(index))) {
                right = index;
                break;
            }
        }
        for (index = start - 1; index > -1; index--) {
            if (!isWordCharacter(text.charAt(index))) {
                left = index + 1;
                break;
            }
        }
        return new int[]{left, right};
    }

    int[] wordUnderCursor(float x) {
        return wordUnderCursor(letterUnderCursor(x));
    }

    boolean withinMaxLength(int size) {
        return this.maxLength <= 0 || size < this.maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setOnlyFontChars(boolean onlyFontChars) {
        this.onlyFontChars = onlyFontChars;
    }

    public void setStyle(TextFieldStyle style) {
        if (style == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = style;
        this.textHeight = style.font.getCapHeight() - (style.font.getDescent() * 2.0f);
        invalidateHierarchy();
    }

    public TextFieldStyle getStyle() {
        return this.style;
    }

    protected void calculateOffsets() {
        float visibleWidth = getWidth();
        if (this.style.background != null) {
            visibleWidth -= this.style.background.getLeftWidth() + this.style.background.getRightWidth();
        }
        float distance = this.glyphPositions.get(this.cursor) - Math.abs(this.renderOffset);
        if (distance <= 0.0f) {
            if (this.cursor > 0) {
                this.renderOffset = -this.glyphPositions.get(this.cursor - 1);
            } else {
                this.renderOffset = 0.0f;
            }
        } else if (distance > visibleWidth) {
            this.renderOffset -= distance - visibleWidth;
        }
        this.visibleTextStart = 0;
        this.textOffset = 0.0f;
        float start = Math.abs(this.renderOffset);
        int glyphCount = this.glyphPositions.size;
        float[] glyphPositions = this.glyphPositions.items;
        float startPos = 0.0f;
        for (int i = 0; i < glyphCount; i++) {
            if (glyphPositions[i] >= start) {
                this.visibleTextStart = i;
                startPos = glyphPositions[i];
                this.textOffset = startPos - start;
                break;
            }
        }
        this.visibleTextEnd = Math.min(this.displayText.length(), this.cursor + 1);
        while (this.visibleTextEnd <= this.displayText.length() && glyphPositions[this.visibleTextEnd] - startPos <= visibleWidth) {
            this.visibleTextEnd++;
        }
        this.visibleTextEnd = Math.max(0, this.visibleTextEnd - 1);
        if (this.hasSelection) {
            int minIndex = Math.min(this.cursor, this.selectionStart);
            int maxIndex = Math.max(this.cursor, this.selectionStart);
            float minX = Math.max(glyphPositions[minIndex], startPos);
            float maxX = Math.min(glyphPositions[maxIndex], glyphPositions[this.visibleTextEnd]);
            this.selectionX = minX;
            this.selectionWidth = maxX - minX;
        }
        if (this.textHAlign == 1 || this.textHAlign == 16) {
            this.textOffset = visibleWidth - (glyphPositions[this.visibleTextEnd] - startPos);
            if (this.textHAlign == 1) {
                this.textOffset = (float) Math.round(this.textOffset * 0.5f);
            }
            if (this.hasSelection) {
                this.selectionX += this.textOffset;
            }
        }
    }

    public void draw(Batch batch, float parentAlpha) {
        Stage stage = getStage();
        boolean focused = stage != null && stage.getKeyboardFocus() == this;
        BitmapFont font = this.style.font;
        Color fontColor = (!this.disabled || this.style.disabledFontColor == null) ? (!focused || this.style.focusedFontColor == null) ? this.style.fontColor : this.style.focusedFontColor : this.style.disabledFontColor;
        Drawable selection = this.style.selection;
        Drawable cursorPatch = this.style.cursor;
        Drawable background = (!this.disabled || this.style.disabledBackground == null) ? (!focused || this.style.focusedBackground == null) ? this.style.background : this.style.focusedBackground : this.style.disabledBackground;
        Color color = getColor();
        float x = getX();
        float y = getY();
        float width = getWidth();
        float height = getHeight();
        batch.setColor(color.f40r, color.f39g, color.f38b, color.f37a * parentAlpha);
        float bgLeftWidth = 0.0f;
        if (background != null) {
            background.draw(batch, x, y, width, height);
            bgLeftWidth = background.getLeftWidth();
        }
        float textY = getTextY(font, background);
        calculateOffsets();
        if (focused && this.hasSelection && selection != null) {
            drawSelection(selection, batch, font, x + bgLeftWidth, y + textY);
        }
        float yOffset = font.isFlipped() ? -this.textHeight : 0.0f;
        if (this.displayText.length() != 0) {
            font.setColor(fontColor.f40r, fontColor.f39g, fontColor.f38b, fontColor.f37a * parentAlpha);
            drawText(batch, font, x + bgLeftWidth, (y + textY) + yOffset);
        } else if (!(focused || this.messageText == null)) {
            BitmapFont messageFont;
            if (this.style.messageFontColor != null) {
                font.setColor(this.style.messageFontColor.f40r, this.style.messageFontColor.f39g, this.style.messageFontColor.f38b, this.style.messageFontColor.f37a * parentAlpha);
            } else {
                font.setColor(0.7f, 0.7f, 0.7f, parentAlpha);
            }
            if (this.style.messageFont != null) {
                messageFont = this.style.messageFont;
            } else {
                messageFont = font;
            }
            messageFont.draw(batch, this.messageText, x + bgLeftWidth, (y + textY) + yOffset);
        }
        if (focused && !this.disabled) {
            blink();
            if (this.cursorOn && cursorPatch != null) {
                drawCursor(cursorPatch, batch, font, x + bgLeftWidth, y + textY);
            }
        }
    }

    protected float getTextY(BitmapFont font, Drawable background) {
        float height = getHeight();
        float textY = (this.textHeight / 2.0f) + font.getDescent();
        if (background == null) {
            return (float) ((int) ((height / 2.0f) + textY));
        }
        float bottom = background.getBottomHeight();
        return (float) ((int) (((((height - background.getTopHeight()) - bottom) / 2.0f) + textY) + bottom));
    }

    protected void drawSelection(Drawable selection, Batch batch, BitmapFont font, float x, float y) {
        selection.draw(batch, (this.selectionX + x) + this.renderOffset, (y - this.textHeight) - font.getDescent(), this.selectionWidth, this.textHeight + (font.getDescent() / 2.0f));
    }

    protected void drawText(Batch batch, BitmapFont font, float x, float y) {
        font.draw(batch, this.displayText, x + this.textOffset, y, this.visibleTextStart, this.visibleTextEnd);
    }

    protected void drawCursor(Drawable cursorPatch, Batch batch, BitmapFont font, float x, float y) {
        cursorPatch.draw(batch, (((this.textOffset + x) + this.glyphPositions.get(this.cursor)) - this.glyphPositions.items[this.visibleTextStart]) - 1.0f, (y - this.textHeight) - font.getDescent(), cursorPatch.getMinWidth(), this.textHeight + (font.getDescent() / 2.0f));
    }

    void updateDisplayText() {
        int i;
        BitmapFont font = this.style.font;
        String text = this.text;
        int textLength = text.length();
        StringBuilder buffer = new StringBuilder();
        for (i = 0; i < textLength; i++) {
            char c = text.charAt(i);
            if (!font.containsCharacter(c)) {
                c = ' ';
            }
            buffer.append(c);
        }
        String newDisplayText = buffer.toString();
        if (this.passwordMode && font.containsCharacter(this.passwordCharacter)) {
            if (this.passwordBuffer == null) {
                this.passwordBuffer = new StringBuilder(newDisplayText.length());
            }
            if (this.passwordBuffer.length() > textLength) {
                this.passwordBuffer.setLength(textLength);
            } else {
                for (i = this.passwordBuffer.length(); i < textLength; i++) {
                    this.passwordBuffer.append(this.passwordCharacter);
                }
            }
            this.displayText = this.passwordBuffer;
        } else {
            this.displayText = newDisplayText;
        }
        font.computeGlyphAdvancesAndPositions(this.displayText, this.glyphAdvances, this.glyphPositions);
        if (this.selectionStart > newDisplayText.length()) {
            this.selectionStart = textLength;
        }
    }

    private void blink() {
        boolean z = true;
        if (Gdx.graphics.isContinuousRendering()) {
            long time = TimeUtils.nanoTime();
            if (((float) (time - this.lastBlink)) / 1.0E9f > this.blinkTime) {
                if (this.cursorOn) {
                    z = false;
                }
                this.cursorOn = z;
                this.lastBlink = time;
                return;
            }
            return;
        }
        this.cursorOn = true;
    }

    public void copy() {
        if (this.hasSelection && !this.passwordMode) {
            this.clipboard.setContents(this.text.substring(Math.min(this.cursor, this.selectionStart), Math.max(this.cursor, this.selectionStart)));
        }
    }

    public void cut() {
        if (this.hasSelection && !this.passwordMode) {
            copy();
            this.cursor = delete();
        }
    }

    void paste() {
        paste(this.clipboard.getContents(), true);
    }

    void paste(String content, boolean onlyFontChars) {
        if (content != null) {
            StringBuilder buffer = new StringBuilder();
            int textLength = this.text.length();
            int n = content.length();
            for (int i = 0; i < n && withinMaxLength(buffer.length() + textLength); i++) {
                char c = content.charAt(i);
                if ((this.writeEnters && (c == ENTER_ANDROID || c == ENTER_DESKTOP)) || ((!onlyFontChars || this.style.font.containsCharacter(c)) && (this.filter == null || this.filter.acceptChar(this, c)))) {
                    buffer.append(c);
                }
            }
            content = buffer.toString();
            if (this.hasSelection) {
                this.cursor = delete(false);
            }
            this.text = insert(this.cursor, content, this.text);
            updateDisplayText();
            this.cursor += content.length();
        }
    }

    String insert(int position, CharSequence text, String to) {
        if (to.length() == 0) {
            return text.toString();
        }
        return to.substring(0, position) + text + to.substring(position, to.length());
    }

    int delete() {
        return delete(true);
    }

    int delete(boolean updateText) {
        return delete(this.selectionStart, this.cursor, updateText);
    }

    int delete(int from, int to, boolean updateText) {
        int minIndex = Math.min(from, to);
        int maxIndex = Math.max(from, to);
        this.text = (minIndex > 0 ? this.text.substring(0, minIndex) : "") + (maxIndex < this.text.length() ? this.text.substring(maxIndex, this.text.length()) : "");
        if (updateText) {
            updateDisplayText();
        }
        clearSelection();
        return minIndex;
    }

    public void next(boolean up) {
        Stage stage = getStage();
        if (stage != null) {
            getParent().localToStageCoordinates(tmp1.set(getX(), getY()));
            TextField textField = findNextTextField(stage.getActors(), null, tmp2, tmp1, up);
            if (textField == null) {
                if (up) {
                    tmp1.set(Float.MIN_VALUE, Float.MIN_VALUE);
                } else {
                    tmp1.set(Float.MAX_VALUE, Float.MAX_VALUE);
                }
                textField = findNextTextField(getStage().getActors(), null, tmp2, tmp1, up);
            }
            if (textField != null) {
                stage.setKeyboardFocus(textField);
            } else {
                Gdx.input.setOnscreenKeyboardVisible(false);
            }
        }
    }

    private TextField findNextTextField(Array<Actor> actors, TextField best, Vector2 bestCoords, Vector2 currentCoords, boolean up) {
        int n = actors.size;
        for (int i = 0; i < n; i++) {
            Actor actor = (Actor) actors.get(i);
            if (actor != this) {
                if (actor instanceof TextField) {
                    TextField textField = (TextField) actor;
                    if (!textField.isDisabled() && textField.focusTraversal) {
                        Vector2 actorCoords = actor.getParent().localToStageCoordinates(tmp3.set(actor.getX(), actor.getY()));
                        int i2 = (actorCoords.f159y < currentCoords.f159y || (actorCoords.f159y == currentCoords.f159y && actorCoords.f158x > currentCoords.f158x)) ? 1 : 0;
                        if ((i2 ^ up) != 0) {
                            if (best != null) {
                                i2 = (actorCoords.f159y > bestCoords.f159y || (actorCoords.f159y == bestCoords.f159y && actorCoords.f158x < bestCoords.f158x)) ? 1 : 0;
                                if ((i2 ^ up) == 0) {
                                }
                            }
                            best = (TextField) actor;
                            bestCoords.set(actorCoords);
                        }
                    }
                } else if (actor instanceof Group) {
                    best = findNextTextField(((Group) actor).getChildren(), best, bestCoords, currentCoords, up);
                }
            }
        }
        return best;
    }

    public InputListener getDefaultInputListener() {
        return this.inputListener;
    }

    public void setTextFieldListener(TextFieldListener listener) {
        this.listener = listener;
    }

    public void setTextFieldFilter(TextFieldFilter filter) {
        this.filter = filter;
    }

    public TextFieldFilter getTextFieldFilter() {
        return this.filter;
    }

    public void setFocusTraversal(boolean focusTraversal) {
        this.focusTraversal = focusTraversal;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void appendText(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        clearSelection();
        this.cursor = this.text.length();
        paste(str, this.onlyFontChars);
    }

    public void setText(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null.");
        } else if (!str.equals(this.text)) {
            clearSelection();
            this.text = "";
            paste(str, this.onlyFontChars);
            this.cursor = 0;
        }
    }

    public String getText() {
        return this.text;
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public String getSelection() {
        return this.hasSelection ? this.text.substring(Math.min(this.selectionStart, this.cursor), Math.max(this.selectionStart, this.cursor)) : "";
    }

    public void setSelection(int selectionStart, int selectionEnd) {
        if (selectionStart < 0) {
            throw new IllegalArgumentException("selectionStart must be >= 0");
        } else if (selectionEnd < 0) {
            throw new IllegalArgumentException("selectionEnd must be >= 0");
        } else {
            selectionStart = Math.min(this.text.length(), selectionStart);
            selectionEnd = Math.min(this.text.length(), selectionEnd);
            if (selectionEnd == selectionStart) {
                clearSelection();
                return;
            }
            if (selectionEnd < selectionStart) {
                int temp = selectionEnd;
                selectionEnd = selectionStart;
                selectionStart = temp;
            }
            this.hasSelection = true;
            this.selectionStart = selectionStart;
            this.cursor = selectionEnd;
        }
    }

    public void selectAll() {
        setSelection(0, this.text.length());
    }

    public void clearSelection() {
        this.hasSelection = false;
    }

    public void setCursorPosition(int cursorPosition) {
        if (cursorPosition < 0) {
            throw new IllegalArgumentException("cursorPosition must be >= 0");
        }
        clearSelection();
        this.cursor = Math.min(cursorPosition, this.text.length());
    }

    public int getCursorPosition() {
        return this.cursor;
    }

    public OnscreenKeyboard getOnscreenKeyboard() {
        return this.keyboard;
    }

    public void setOnscreenKeyboard(OnscreenKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setClipboard(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    public float getPrefWidth() {
        return 150.0f;
    }

    public float getPrefHeight() {
        float prefHeight = this.textHeight;
        if (this.style.background != null) {
            return Math.max((this.style.background.getBottomHeight() + prefHeight) + this.style.background.getTopHeight(), this.style.background.getMinHeight());
        }
        return prefHeight;
    }

    public void setAlignment(int alignment) {
        if (alignment == 8 || alignment == 1 || alignment == 16) {
            this.textHAlign = alignment;
        }
    }

    public void setPasswordMode(boolean passwordMode) {
        this.passwordMode = passwordMode;
        updateDisplayText();
    }

    public boolean isPasswordMode() {
        return this.passwordMode;
    }

    public void setPasswordCharacter(char passwordCharacter) {
        this.passwordCharacter = passwordCharacter;
        if (this.passwordMode) {
            updateDisplayText();
        }
    }

    public void setBlinkTime(float blinkTime) {
        this.blinkTime = blinkTime;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    protected void moveCursor(boolean forward, boolean jump) {
        int limit;
        int charOffset = 0;
        if (forward) {
            limit = this.text.length();
        } else {
            limit = 0;
        }
        if (!forward) {
            charOffset = -1;
        }
        do {
            int i;
            if (forward) {
                i = this.cursor + 1;
                this.cursor = i;
                if (i >= limit) {
                    return;
                }
            }
            i = this.cursor - 1;
            this.cursor = i;
            if (i <= limit) {
                return;
            }
            if (!jump) {
                return;
            }
        } while (continueCursor(this.cursor, charOffset));
    }

    protected boolean continueCursor(int index, int offset) {
        return isWordCharacter(this.text.charAt(index + offset));
    }
}
