package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class KnockbackAdjuster extends Module {
    public KnockbackAdjuster() {
        super("KnockbackAdjuster", Category.COMBAT);
        addSetting(new NumSetting("Horizontal", 100, 0, 200, 1));
        addSetting(new NumSetting("Vertical", 100, 0, 200, 1));
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
