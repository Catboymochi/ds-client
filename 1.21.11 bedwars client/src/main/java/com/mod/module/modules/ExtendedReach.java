package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class ExtendedReach extends Module {
    public ExtendedReach() {
        super("ExtendedReach", Category.COMBAT);
        addSetting(new NumSetting("Reach", 4.5, 3, 6, 0.1));
        addSetting(new BoolSetting("OnlyWhenAttacking", true));
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
