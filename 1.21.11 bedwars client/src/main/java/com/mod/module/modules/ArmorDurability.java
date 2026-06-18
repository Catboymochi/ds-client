package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class ArmorDurability extends Module {
    public ArmorDurability() {
        super("ArmorDurability", Category.HUD);
        addSetting(new BoolSetting("ShowPercent", true));
        addSetting(new ModeSetting("Position", "BottomRight", new String[]{"BottomRight", "TopLeft"}));
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
