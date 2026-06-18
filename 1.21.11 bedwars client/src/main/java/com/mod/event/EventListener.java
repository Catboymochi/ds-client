package com.mod.event;

import com.mod.event.impl.*;

public interface EventListener {
    default void onTick(TickEvent event) {}
    default void onRender2D(Render2DEvent event) {}
    default void onRender3D(Render3DEvent event) {}
    default void onKeyPress(KeyPressEvent event) {}
}