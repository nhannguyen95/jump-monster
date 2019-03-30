package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.JsonWriter.OutputType;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class JsonValue implements Iterable<JsonValue> {
    public JsonValue child;
    private double doubleValue;
    private long longValue;
    public String name;
    public JsonValue next;
    public JsonValue prev;
    public int size;
    private String stringValue;
    private ValueType type;

    public class JsonIterator implements Iterator<JsonValue>, Iterable<JsonValue> {
        JsonValue current;
        JsonValue entry = JsonValue.this.child;

        public boolean hasNext() {
            return this.entry != null;
        }

        public JsonValue next() {
            this.current = this.entry;
            if (this.current == null) {
                throw new NoSuchElementException();
            }
            this.entry = this.current.next;
            return this.current;
        }

        public void remove() {
            if (this.current.prev == null) {
                JsonValue.this.child = this.current.next;
                if (JsonValue.this.child != null) {
                    JsonValue.this.child.prev = null;
                }
            } else {
                this.current.prev.next = this.current.next;
                if (this.current.next != null) {
                    this.current.next.prev = this.current.prev;
                }
            }
            JsonValue jsonValue = JsonValue.this;
            jsonValue.size--;
        }

        public Iterator<JsonValue> iterator() {
            return this;
        }
    }

    public static class PrettyPrintSettings {
        public OutputType outputType;
        public int singleLineColumns;
        public boolean wrapNumericArrays;
    }

    public enum ValueType {
        object,
        array,
        stringValue,
        doubleValue,
        longValue,
        booleanValue,
        nullValue
    }

    public JsonValue(ValueType type) {
        this.type = type;
    }

    public JsonValue(String value) {
        set(value);
    }

    public JsonValue(double value) {
        set(value);
    }

    public JsonValue(long value) {
        set(value);
    }

    public JsonValue(boolean value) {
        set(value);
    }

    public JsonValue get(int index) {
        JsonValue current = this.child;
        while (current != null && index > 0) {
            index--;
            current = current.next;
        }
        return current;
    }

    public JsonValue get(String name) {
        JsonValue current = this.child;
        while (current != null && !current.name.equalsIgnoreCase(name)) {
            current = current.next;
        }
        return current;
    }

    public boolean has(String name) {
        return get(name) != null;
    }

    public JsonValue require(int index) {
        JsonValue current = this.child;
        while (current != null && index > 0) {
            index--;
            current = current.next;
        }
        if (current != null) {
            return current;
        }
        throw new IllegalArgumentException("Child not found with index: " + index);
    }

    public JsonValue require(String name) {
        JsonValue current = this.child;
        while (current != null && !current.name.equalsIgnoreCase(name)) {
            current = current.next;
        }
        if (current != null) {
            return current;
        }
        throw new IllegalArgumentException("Child not found with name: " + name);
    }

    public JsonValue remove(int index) {
        JsonValue child = get(index);
        if (child == null) {
            return null;
        }
        if (child.prev == null) {
            this.child = child.next;
            if (this.child != null) {
                this.child.prev = null;
            }
        } else {
            child.prev.next = child.next;
            if (child.next != null) {
                child.next.prev = child.prev;
            }
        }
        this.size--;
        return child;
    }

    public JsonValue remove(String name) {
        JsonValue child = get(name);
        if (child == null) {
            return null;
        }
        if (child.prev == null) {
            this.child = child.next;
            if (this.child != null) {
                this.child.prev = null;
            }
        } else {
            child.prev.next = child.next;
            if (child.next != null) {
                child.next.prev = child.prev;
            }
        }
        this.size--;
        return child;
    }

    @Deprecated
    public int size() {
        return this.size;
    }

    public String asString() {
        switch (this.type) {
            case stringValue:
                return this.stringValue;
            case doubleValue:
                return Double.toString(this.doubleValue);
            case longValue:
                return Long.toString(this.longValue);
            case booleanValue:
                return this.longValue != 0 ? "true" : "false";
            case nullValue:
                return null;
            default:
                throw new IllegalStateException("Value cannot be converted to string: " + this.type);
        }
    }

    public float asFloat() {
        switch (this.type) {
            case stringValue:
                return Float.parseFloat(this.stringValue);
            case doubleValue:
                return (float) this.doubleValue;
            case longValue:
                return (float) this.longValue;
            case booleanValue:
                return this.longValue != 0 ? 1.0f : 0.0f;
            default:
                throw new IllegalStateException("Value cannot be converted to float: " + this.type);
        }
    }

    public double asDouble() {
        switch (this.type) {
            case stringValue:
                return Double.parseDouble(this.stringValue);
            case doubleValue:
                return this.doubleValue;
            case longValue:
                return (double) this.longValue;
            case booleanValue:
                return this.longValue != 0 ? 1.0d : 0.0d;
            default:
                throw new IllegalStateException("Value cannot be converted to double: " + this.type);
        }
    }

    public long asLong() {
        switch (this.type) {
            case stringValue:
                return Long.parseLong(this.stringValue);
            case doubleValue:
                return (long) this.doubleValue;
            case longValue:
                return this.longValue;
            case booleanValue:
                return this.longValue != 0 ? 1 : 0;
            default:
                throw new IllegalStateException("Value cannot be converted to long: " + this.type);
        }
    }

    public int asInt() {
        switch (this.type) {
            case stringValue:
                return Integer.parseInt(this.stringValue);
            case doubleValue:
                return (int) this.doubleValue;
            case longValue:
                return (int) this.longValue;
            case booleanValue:
                return this.longValue != 0 ? 1 : 0;
            default:
                throw new IllegalStateException("Value cannot be converted to int: " + this.type);
        }
    }

    public boolean asBoolean() {
        switch (this.type) {
            case stringValue:
                return this.stringValue.equalsIgnoreCase("true");
            case doubleValue:
                if (this.doubleValue == 0.0d) {
                    return false;
                }
                return true;
            case longValue:
                if (this.longValue == 0) {
                    return false;
                }
                return true;
            case booleanValue:
                return this.longValue != 0;
            default:
                throw new IllegalStateException("Value cannot be converted to boolean: " + this.type);
        }
    }

    public byte asByte() {
        switch (this.type) {
            case stringValue:
                return Byte.parseByte(this.stringValue);
            case doubleValue:
                return (byte) ((int) this.doubleValue);
            case longValue:
                return (byte) ((int) this.longValue);
            case booleanValue:
                return this.longValue != 0 ? (byte) 1 : (byte) 0;
            default:
                throw new IllegalStateException("Value cannot be converted to byte: " + this.type);
        }
    }

    public short asShort() {
        switch (this.type) {
            case stringValue:
                return Short.parseShort(this.stringValue);
            case doubleValue:
                return (short) ((int) this.doubleValue);
            case longValue:
                return (short) ((int) this.longValue);
            case booleanValue:
                return this.longValue != 0 ? (short) 1 : (short) 0;
            default:
                throw new IllegalStateException("Value cannot be converted to short: " + this.type);
        }
    }

    public char asChar() {
        switch (this.type) {
            case stringValue:
                if (this.stringValue.length() == 0) {
                    return '\u0000';
                }
                return this.stringValue.charAt(0);
            case doubleValue:
                return (char) ((int) this.doubleValue);
            case longValue:
                return (char) ((int) this.longValue);
            case booleanValue:
                return this.longValue != 0 ? '\u0001' : '\u0000';
            default:
                throw new IllegalStateException("Value cannot be converted to char: " + this.type);
        }
    }

    public String[] asStringArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        String[] array = new String[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            String v;
            switch (value.type) {
                case stringValue:
                    v = value.stringValue;
                    break;
                case doubleValue:
                    v = Double.toString(value.doubleValue);
                    break;
                case longValue:
                    v = Long.toString(value.longValue);
                    break;
                case booleanValue:
                    v = value.longValue != 0 ? "true" : "false";
                    break;
                case nullValue:
                    v = null;
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to string: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public float[] asFloatArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        float[] array = new float[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            float v;
            switch (value.type) {
                case stringValue:
                    v = Float.parseFloat(value.stringValue);
                    break;
                case doubleValue:
                    v = (float) value.doubleValue;
                    break;
                case longValue:
                    v = (float) value.longValue;
                    break;
                case booleanValue:
                    v = value.longValue != 0 ? 1.0f : 0.0f;
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to float: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public double[] asDoubleArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        double[] array = new double[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            double v;
            switch (value.type) {
                case stringValue:
                    v = Double.parseDouble(value.stringValue);
                    break;
                case doubleValue:
                    v = value.doubleValue;
                    break;
                case longValue:
                    v = (double) value.longValue;
                    break;
                case booleanValue:
                    v = value.longValue != 0 ? 1.0d : 0.0d;
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to double: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public long[] asLongArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        long[] array = new long[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            long v;
            switch (value.type) {
                case stringValue:
                    v = Long.parseLong(value.stringValue);
                    break;
                case doubleValue:
                    v = (long) value.doubleValue;
                    break;
                case longValue:
                    v = value.longValue;
                    break;
                case booleanValue:
                    if (value.longValue != 0) {
                        v = 1;
                    } else {
                        v = 0;
                    }
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to long: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public int[] asIntArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        int[] array = new int[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            int v;
            switch (value.type) {
                case stringValue:
                    v = Integer.parseInt(value.stringValue);
                    break;
                case doubleValue:
                    v = (int) value.doubleValue;
                    break;
                case longValue:
                    v = (int) value.longValue;
                    break;
                case booleanValue:
                    v = value.longValue != 0 ? 1 : 0;
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to int: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public boolean[] asBooleanArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        boolean[] array = new boolean[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            boolean v;
            switch (value.type) {
                case stringValue:
                    v = Boolean.parseBoolean(value.stringValue);
                    break;
                case doubleValue:
                    if (value.doubleValue == 0.0d) {
                        v = true;
                    } else {
                        v = false;
                    }
                    break;
                case longValue:
                    if (value.longValue == 0) {
                        v = true;
                    } else {
                        v = false;
                    }
                    break;
                case booleanValue:
                    if (value.longValue != 0) {
                        v = true;
                    } else {
                        v = false;
                    }
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to boolean: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public byte[] asByteArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        byte[] array = new byte[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            byte v;
            switch (value.type) {
                case stringValue:
                    v = Byte.parseByte(value.stringValue);
                    break;
                case doubleValue:
                    v = (byte) ((int) value.doubleValue);
                    break;
                case longValue:
                    v = (byte) ((int) value.longValue);
                    break;
                case booleanValue:
                    v = value.longValue != 0 ? (byte) 1 : (byte) 0;
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to byte: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public short[] asShortArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        short[] array = new short[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            short v;
            switch (value.type) {
                case stringValue:
                    v = Short.parseShort(value.stringValue);
                    break;
                case doubleValue:
                    v = (short) ((int) value.doubleValue);
                    break;
                case longValue:
                    v = (short) ((int) value.longValue);
                    break;
                case booleanValue:
                    v = value.longValue != 0 ? (short) 1 : (short) 0;
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to short: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public char[] asCharArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + this.type);
        }
        char[] array = new char[this.size];
        int i = 0;
        JsonValue value = this.child;
        while (value != null) {
            char v;
            switch (value.type) {
                case stringValue:
                    if (value.stringValue.length() != 0) {
                        v = value.stringValue.charAt(0);
                        break;
                    }
                    v = '\u0000';
                    break;
                case doubleValue:
                    v = (char) ((int) value.doubleValue);
                    break;
                case longValue:
                    v = (char) ((int) value.longValue);
                    break;
                case booleanValue:
                    if (value.longValue != 0) {
                        v = '\u0001';
                    } else {
                        v = '\u0000';
                    }
                    break;
                default:
                    throw new IllegalStateException("Value cannot be converted to char: " + value.type);
            }
            array[i] = v;
            value = value.next;
            i++;
        }
        return array;
    }

    public boolean hasChild(String name) {
        return getChild(name) != null;
    }

    public JsonValue getChild(String name) {
        JsonValue child = get(name);
        return child == null ? null : child.child;
    }

    public String getString(String name, String defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue() || child.isNull()) ? defaultValue : child.asString();
    }

    public float getFloat(String name, float defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asFloat();
    }

    public double getDouble(String name, double defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asDouble();
    }

    public long getLong(String name, long defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asLong();
    }

    public int getInt(String name, int defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asInt();
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asBoolean();
    }

    public byte getByte(String name, byte defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asByte();
    }

    public short getShort(String name, short defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asShort();
    }

    public char getChar(String name, char defaultValue) {
        JsonValue child = get(name);
        return (child == null || !child.isValue()) ? defaultValue : child.asChar();
    }

    public String getString(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asString();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public float getFloat(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asFloat();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public double getDouble(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asDouble();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public long getLong(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asLong();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public int getInt(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asInt();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public boolean getBoolean(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asBoolean();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public byte getByte(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asByte();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public short getShort(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asShort();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public char getChar(String name) {
        JsonValue child = get(name);
        if (child != null) {
            return child.asChar();
        }
        throw new IllegalArgumentException("Named value not found: " + name);
    }

    public String getString(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asString();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public float getFloat(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asFloat();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public double getDouble(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asDouble();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public long getLong(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asLong();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public int getInt(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asInt();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public boolean getBoolean(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asBoolean();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public byte getByte(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asByte();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public short getShort(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asShort();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public char getChar(int index) {
        JsonValue child = get(index);
        if (child != null) {
            return child.asChar();
        }
        throw new IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public ValueType type() {
        return this.type;
    }

    public void setType(ValueType type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        this.type = type;
    }

    public boolean isArray() {
        return this.type == ValueType.array;
    }

    public boolean isObject() {
        return this.type == ValueType.object;
    }

    public boolean isString() {
        return this.type == ValueType.stringValue;
    }

    public boolean isNumber() {
        return this.type == ValueType.doubleValue || this.type == ValueType.longValue;
    }

    public boolean isDouble() {
        return this.type == ValueType.doubleValue;
    }

    public boolean isLong() {
        return this.type == ValueType.longValue;
    }

    public boolean isBoolean() {
        return this.type == ValueType.booleanValue;
    }

    public boolean isNull() {
        return this.type == ValueType.nullValue;
    }

    public boolean isValue() {
        switch (this.type) {
            case stringValue:
            case doubleValue:
            case longValue:
            case booleanValue:
            case nullValue:
                return true;
            default:
                return false;
        }
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonValue child() {
        return this.child;
    }

    public JsonValue next() {
        return this.next;
    }

    public void setNext(JsonValue next) {
        this.next = next;
    }

    public JsonValue prev() {
        return this.prev;
    }

    public void setPrev(JsonValue prev) {
        this.prev = prev;
    }

    public void set(String value) {
        this.stringValue = value;
        this.type = value == null ? ValueType.nullValue : ValueType.stringValue;
    }

    public void set(double value) {
        this.doubleValue = value;
        this.longValue = (long) value;
        this.type = ValueType.doubleValue;
    }

    public void set(long value) {
        this.longValue = value;
        this.doubleValue = (double) value;
        this.type = ValueType.longValue;
    }

    public void set(boolean value) {
        this.longValue = value ? 1 : 0;
        this.type = ValueType.booleanValue;
    }

    public String toString() {
        if (isValue()) {
            return this.name == null ? asString() : this.name + ": " + asString();
        } else {
            return (this.name == null ? "" : this.name + ": ") + prettyPrint(OutputType.minimal, 0);
        }
    }

    public String prettyPrint(OutputType outputType, int singleLineColumns) {
        PrettyPrintSettings settings = new PrettyPrintSettings();
        settings.outputType = outputType;
        settings.singleLineColumns = singleLineColumns;
        return prettyPrint(settings);
    }

    public String prettyPrint(PrettyPrintSettings settings) {
        StringBuilder buffer = new StringBuilder(512);
        prettyPrint(this, buffer, 0, settings);
        return buffer.toString();
    }

    private void prettyPrint(JsonValue object, StringBuilder buffer, int indent, PrettyPrintSettings settings) {
        OutputType outputType = settings.outputType;
        boolean newLines;
        int start;
        JsonValue child;
        if (object.isObject()) {
            if (object.child == null) {
                buffer.append("{}");
                return;
            }
            newLines = !isFlat(object);
            start = buffer.length();
            loop0:
            while (true) {
                buffer.append(newLines ? "{\n" : "{ ");
                child = object.child;
                while (child != null) {
                    if (newLines) {
                        indent(indent, buffer);
                    }
                    buffer.append(outputType.quoteName(child.name));
                    buffer.append(": ");
                    prettyPrint(child, buffer, indent + 1, settings);
                    if (!((newLines && outputType == OutputType.minimal) || child.next == null)) {
                        buffer.append(',');
                    }
                    buffer.append(newLines ? '\n' : ' ');
                    if (newLines || buffer.length() - start <= settings.singleLineColumns) {
                        child = child.next;
                    } else {
                        buffer.setLength(start);
                        newLines = true;
                    }
                }
                break loop0;
            }
            if (newLines) {
                indent(indent - 1, buffer);
            }
            buffer.append('}');
        } else if (object.isArray()) {
            if (object.child == null) {
                buffer.append("[]");
                return;
            }
            newLines = !isFlat(object);
            boolean wrap = settings.wrapNumericArrays || !isNumeric(object);
            start = buffer.length();
            loop2:
            while (true) {
                buffer.append(newLines ? "[\n" : "[ ");
                child = object.child;
                while (child != null) {
                    if (newLines) {
                        indent(indent, buffer);
                    }
                    prettyPrint(child, buffer, indent + 1, settings);
                    if (!((newLines && outputType == OutputType.minimal) || child.next == null)) {
                        buffer.append(',');
                    }
                    buffer.append(newLines ? '\n' : ' ');
                    if (!wrap || newLines || buffer.length() - start <= settings.singleLineColumns) {
                        child = child.next;
                    } else {
                        buffer.setLength(start);
                        newLines = true;
                    }
                }
                break loop2;
            }
            if (newLines) {
                indent(indent - 1, buffer);
            }
            buffer.append(']');
        } else if (object.isString()) {
            buffer.append(outputType.quoteValue(object.asString()));
        } else if (object.isDouble()) {
            double doubleValue = object.asDouble();
            long longValue = object.asLong();
            if (doubleValue == ((double) longValue)) {
                doubleValue = (double) longValue;
            }
            buffer.append(doubleValue);
        } else if (object.isLong()) {
            buffer.append(object.asLong());
        } else if (object.isBoolean()) {
            buffer.append(object.asBoolean());
        } else if (object.isNull()) {
            buffer.append("null");
        } else {
            throw new SerializationException("Unknown object type: " + object);
        }
    }

    private static boolean isFlat(JsonValue object) {
        JsonValue child = object.child;
        while (child != null) {
            if (child.isObject() || child.isArray()) {
                return false;
            }
            child = child.next;
        }
        return true;
    }

    private static boolean isNumeric(JsonValue object) {
        for (JsonValue child = object.child; child != null; child = child.next) {
            if (!child.isNumber()) {
                return false;
            }
        }
        return true;
    }

    private static void indent(int count, StringBuilder buffer) {
        for (int i = 0; i < count; i++) {
            buffer.append('\t');
        }
    }

    public JsonIterator iterator() {
        return new JsonIterator();
    }
}
