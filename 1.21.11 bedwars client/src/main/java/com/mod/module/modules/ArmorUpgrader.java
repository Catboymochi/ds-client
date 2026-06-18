package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class ArmorUpgrader extends Module {
    public ArmorUpgrader() {
        super("ArmorUpgrader", Category.INVENTORY);
        addSetting(new BoolSetting("AutoEquip", true));
        addSetting(new NumSetting("Delay", 50, 0, 200, 10));
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
