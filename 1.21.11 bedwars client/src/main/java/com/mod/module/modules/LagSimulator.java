package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class LagSimulator extends Module {
    public LagSimulator() {
        super("LagSimulator", Category.MOVEMENT);
        addSetting(new NumSetting("PacketDelay", 200, 50, 500, 10));
        addSetting(new NumSetting("DropChance", 10, 1, 50, 1));
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
