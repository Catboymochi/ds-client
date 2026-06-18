package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class TimeDisplay extends Module {
    public TimeDisplay() {
        super("TimeDisplay", Category.HUD);
        addSetting(new ModeSetting("Format", "12h", new String[]{"12h", "24h"}));
        addSetting(new ModeSetting("Position", "TopRight", new String[]{"TopRight", "BottomLeft"}));
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
