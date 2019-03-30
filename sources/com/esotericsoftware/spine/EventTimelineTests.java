package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StringBuilder;
import com.esotericsoftware.spine.Animation.EventTimeline;
import java.util.Arrays;

public class EventTimelineTests {
    private char[] events;
    private final Array<Event> firedEvents = new Array();
    private float[] frames;
    private final Skeleton skeleton = new Skeleton(this.skeletonData);
    private final SkeletonData skeletonData = new SkeletonData();
    private EventTimeline timeline = new EventTimeline(0);

    static class FailException extends RuntimeException {
        public FailException(String message) {
            super(message);
        }
    }

    public EventTimelineTests() {
        test(0.0f);
        test(1.0f);
        test(1.0f, 1.0f);
        test(1.0f, 2.0f);
        test(1.0f, 2.0f);
        test(1.0f, 2.0f, 3.0f);
        test(1.0f, 2.0f, 3.0f);
        test(0.0f, 0.0f, 0.0f);
        test(0.0f, 0.0f, 1.0f);
        test(0.0f, 1.0f, 1.0f);
        test(1.0f, 1.0f, 1.0f);
        test(1.0f, 2.0f, 3.0f, 4.0f);
        test(0.0f, 2.0f, 3.0f, 4.0f);
        test(0.0f, 2.0f, 2.0f, 4.0f);
        test(0.0f, 0.0f, 0.0f, 0.0f);
        test(2.0f, 2.0f, 2.0f, 2.0f);
        test(0.1f);
        test(0.1f, 0.1f);
        test(0.1f, 50.0f);
        test(0.1f, 0.2f, 0.3f, 0.4f);
        test(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 6.0f, 7.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 11.01f, 12.0f, 12.0f, 12.0f, 12.0f);
        System.out.println("All tests passed.");
    }

    private void test(float... frames) {
        int i;
        int eventCount = frames.length;
        StringBuilder buffer = new StringBuilder();
        for (i = 0; i < eventCount; i++) {
            buffer.append((char) (i + 97));
        }
        this.events = buffer.toString().toCharArray();
        this.frames = frames;
        this.timeline = new EventTimeline(eventCount);
        float maxFrame = 0.0f;
        int distinctCount = 0;
        float lastFrame = -1.0f;
        for (i = 0; i < eventCount; i++) {
            float frame = frames[i];
            this.timeline.setFrame(i, frame, new Event(new EventData(this.events[i])));
            maxFrame = Math.max(maxFrame, frame);
            if (lastFrame != frame) {
                distinctCount++;
            }
            lastFrame = frame;
        }
        run(0.0f, 99.0f, 0.1f);
        run(0.0f, maxFrame, 0.1f);
        run(frames[0], 999.0f, 2.0f);
        run(frames[0], maxFrame, 0.1f);
        run(0.0f, maxFrame, (float) Math.ceil((double) (maxFrame / 100.0f)));
        run(0.0f, 99.0f, 0.1f);
        run(0.0f, 999.0f, 100.0f);
        if (distinctCount > 1) {
            run(frames[0], maxFrame - 0.02f, 0.1f);
            run(0.0f, maxFrame - 0.02f, 0.1f);
            run(frames[0] + 0.02f, maxFrame, 0.1f);
            run(frames[0] + 0.02f, 99.0f, 0.1f);
        }
    }

    private void run(float startTime, float endTime, float timeStep) {
        timeStep = Math.max(timeStep, 1.0E-5f);
        boolean loop = false;
        try {
            fire(startTime, endTime, timeStep, false, false);
            loop = true;
            fire(startTime, endTime, timeStep, true, false);
        } catch (FailException e) {
            try {
                fire(startTime, endTime, timeStep, loop, true);
            } catch (FailException ex) {
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        }
    }

    private void fire(float timeStart, float timeEnd, float timeStep, boolean loop, boolean print) {
        if (print) {
            System.out.println("events: " + Arrays.toString(this.events));
            System.out.println("frames: " + Arrays.toString(this.frames));
            System.out.println("timeStart: " + timeStart);
            System.out.println("timeEnd: " + timeEnd);
            System.out.println("timeStep: " + timeStep);
            System.out.println("loop: " + loop);
        }
        int eventIndex = 0;
        while (this.frames[eventIndex] < timeStart) {
            eventIndex++;
        }
        int eventsCount = this.frames.length;
        while (this.frames[eventsCount - 1] > timeEnd) {
            eventsCount--;
        }
        eventsCount -= eventIndex;
        float duration = this.frames[(eventIndex + eventsCount) - 1];
        if (loop && duration > 0.0f) {
            while (timeStep > duration / 2.0f) {
                timeStep /= 2.0f;
            }
        }
        this.firedEvents.clear();
        int i = 0;
        float lastTime = timeStart - 1.0E-5f;
        while (true) {
            float time = Math.min((((float) i) * timeStep) + timeStart, timeEnd);
            float lastTimeLooped = lastTime;
            float timeLooped = time;
            if (loop && duration != 0.0f) {
                lastTimeLooped %= duration;
                timeLooped %= duration;
            }
            Array<Event> original = new Array(this.firedEvents);
            this.timeline.apply(this.skeleton, lastTimeLooped, timeLooped, this.firedEvents, 1.0f);
            for (int beforeCount = this.firedEvents.size; beforeCount < this.firedEvents.size; beforeCount++) {
                char fired = ((Event) this.firedEvents.get(beforeCount)).getData().getName().charAt(0);
                if (loop) {
                    eventIndex %= this.events.length;
                } else if (this.firedEvents.size > eventsCount) {
                    if (print) {
                        System.out.println(new StringBuilder(String.valueOf(lastTimeLooped)).append("->").append(timeLooped).append(": ").append(fired).append(" == ?").toString());
                    }
                    this.timeline.apply(this.skeleton, lastTimeLooped, timeLooped, original, 1.0f);
                    fail("Too many events fired.");
                }
                if (print) {
                    System.out.println(new StringBuilder(String.valueOf(lastTimeLooped)).append("->").append(timeLooped).append(": ").append(fired).append(" == ").append(this.events[eventIndex]).toString());
                }
                if (fired != this.events[eventIndex]) {
                    this.timeline.apply(this.skeleton, lastTimeLooped, timeLooped, original, 1.0f);
                    fail("Wrong event fired.");
                }
                eventIndex++;
            }
            if (time >= timeEnd) {
                break;
            }
            lastTime = time;
            i++;
        }
        if (this.firedEvents.size < eventsCount) {
            this.timeline.apply(this.skeleton, lastTimeLooped, timeLooped, this.firedEvents, 1.0f);
            if (print) {
                System.out.println(this.firedEvents);
            }
            fail("Event not fired: " + this.events[eventIndex] + ", " + this.frames[eventIndex]);
        }
    }

    private void fail(String message) {
        throw new FailException(message);
    }

    public static void main(String[] args) throws Exception {
        EventTimelineTests eventTimelineTests = new EventTimelineTests();
    }
}
