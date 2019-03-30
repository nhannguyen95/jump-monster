package com.esotericsoftware.spine;

public class EventData {
    float floatValue;
    int intValue;
    final String name;
    String stringValue;

    public EventData(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        this.name = name;
    }

    public int getInt() {
        return this.intValue;
    }

    public void setInt(int intValue) {
        this.intValue = intValue;
    }

    public float getFloat() {
        return this.floatValue;
    }

    public void setFloat(float floatValue) {
        this.floatValue = floatValue;
    }

    public String getString() {
        return this.stringValue;
    }

    public void setString(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
