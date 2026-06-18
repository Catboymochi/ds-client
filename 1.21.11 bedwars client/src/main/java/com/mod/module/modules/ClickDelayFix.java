package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class ClickDelayFix extends Module {
    public ClickDelayFix() {
        super("ClickDelayFix", Category.MISC);
        addSetting(new BoolSetting("RemoveCooldown", true));
        addSetting(new NumSetting("ClickSpeed", 4, 1, 20, 1));
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
