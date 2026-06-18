package com.mod.event;

import com.mod.event.impl.*;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private static final List<EventListener> listeners = new ArrayList<>();

    public static void register(EventListener listener) {
        listeners.add(listener);
    }
    public static void unregister(EventListener listener) {
        listeners.remove(listener);
    }

    // Called from mixins
    public static void fireTick() {
        TickEvent event = new TickEvent();
        for (EventListener l : listeners) l.onTick(event);
    }

    public static void fireRender2D(float tickDelta) {
        Render2DEvent event = new Render2DEvent(tickDelta);
        for (EventListener l : listeners) l.onRender2D(event);
    }

    public static void fireRender3D(float tickDelta) {
        Render3DEvent event = new Render3DEvent(tickDelta);
        for (EventListener l : listeners) l.onRender3D(event);
    }

    public static void fireKeyPress(int keyCode) {
        KeyPressEvent event = new KeyPressEvent(keyCode);
        for (EventListener l : listeners) l.onKeyPress(event);
    }
}