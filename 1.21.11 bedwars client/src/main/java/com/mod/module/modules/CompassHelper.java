package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class CompassHelper extends Module {
    public CompassHelper() {
        super("CompassHelper", Category.HUD);
        addSetting(new ModeSetting("Target", "Coordinates", new String[]{"Coordinates", "Player"}));
        addSetting(new ModeSetting("Color", "Red", new String[]{"Red", "Green", "Blue"}));
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
