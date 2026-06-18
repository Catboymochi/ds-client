package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class KnockbackReducer extends Module {
    public KnockbackReducer() {
        super("KnockbackReducer", Category.COMBAT);
        addSetting(new NumSetting("Horizontal", 50, 0, 100, 1));
        addSetting(new NumSetting("Vertical", 50, 0, 100, 1));
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
