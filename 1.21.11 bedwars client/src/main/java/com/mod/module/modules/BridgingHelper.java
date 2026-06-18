package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class BridgingHelper extends Module {
    public BridgingHelper() {
        super("BridgingHelper", Category.MOVEMENT);
        addSetting(new ModeSetting("Mode", "Legit", new String[]{"Legit", "Godbridge", "Tower"}));
        addSetting(new NumSetting("Speed", 1.0, 0.5, 2.0, 0.1));
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
