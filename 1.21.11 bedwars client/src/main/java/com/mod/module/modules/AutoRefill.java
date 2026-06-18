package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class AutoRefill extends Module {
    public AutoRefill() {
        super("AutoRefill", Category.INVENTORY);
        addSetting(new NumSetting("RefillWhenLow", 5, 1, 10, 1));
        addSetting(new BoolSetting("OnlyWhenInventoryOpen", true));
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
