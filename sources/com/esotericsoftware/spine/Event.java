package com.esotericsoftware.spine;

public class Event {
    private final EventData data;
    float floatValue;
    int intValue;
    String stringValue;

    public Event(EventData data) {
        this.data = data;
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

    public EventData getData() {
        return this.data;
    }

    public String toString() {
        return this.data.name;
    }
}
