package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class SpawnerLocator extends Module {
    public SpawnerLocator() {
        super("SpawnerLocator", Category.VISUAL);
        addSetting(new ModeSetting("Color", "Yellow", new String[]{"Yellow", "Blue", "Red"}));
        addSetting(new BoolSetting("ThroughWalls", true));
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
