package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class AutoRightClick extends Module {
    public AutoRightClick() {
        super("AutoRightClick", Category.COMBAT);
        addSetting(new NumSetting("CPS", 8, 4, 20, 0.5));
        addSetting(new BoolSetting("OnlyWhenHoldingItem", true));
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
