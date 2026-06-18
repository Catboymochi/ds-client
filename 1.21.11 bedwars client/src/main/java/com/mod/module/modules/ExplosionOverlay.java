package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class ExplosionOverlay extends Module {
    public ExplosionOverlay() {
        super("ExplosionOverlay", Category.VISUAL);
        addSetting(new BoolSetting("ShowParticles", true));
        addSetting(new NumSetting("Duration", 60, 20, 200, 5));
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
