package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class ThrowTester extends Module {
    public ThrowTester() {
        super("ThrowTester", Category.UTILITY);
        addSetting(new ModeSetting("Pattern", "Line", new String[]{"Line", "Circle", "Random"}));
        addSetting(new NumSetting("Delay", 200, 50, 500, 10));
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
