package com.mod.util;

public class TimerUtil {
    private long lastMS = System.currentTimeMillis();

    public boolean hasElapsed(long milliseconds) {
        return System.currentTimeMillis() - lastMS >= milliseconds;
    }

    public void reset() {
        lastMS = System.currentTimeMillis();
    }

    public long getElapsed() {
        return System.currentTimeMillis() - lastMS;
    }
}