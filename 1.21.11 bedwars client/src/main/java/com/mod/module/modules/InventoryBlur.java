package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class InventoryBlur extends Module {
    public InventoryBlur() {
        super("InventoryBlur", Category.VISUAL);
        addSetting(new NumSetting("BlurStrength", 5, 1, 10, 1));
        addSetting(new BoolSetting("OnlyWhenOpen", true));
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
