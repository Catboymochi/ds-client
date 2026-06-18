package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class TimeVisualizer extends Module {
    public TimeVisualizer() {
        super("TimeVisualizer", Category.VISUAL);
        addSetting(new ModeSetting("TimeMode", "Day", new String[]{"Day", "Night", "Sunset"}));
        addSetting(new NumSetting("Speed", 1.0, 0.1, 10, 0.1));
    }

    @Override
    public void onEnable() { /* enable logic */ }
    @Override
    public void onDisable() { /* disable logic */ }
    @Override
    public void onTick() { if (!isEnabled()) return; /* logic */ }
    @Override
    public void onRender2D() { /* 2D render */ }
    @Override
    public void onRender3D(float partialTicks) { /* 3D render */ }
}
