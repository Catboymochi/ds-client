package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class TargetSelector extends Module {
    public TargetSelector() {
        super("TargetSelector", Category.COMBAT);
        addSetting(new ModeSetting("Priority", "Closest", new String[]{"Closest", "LowestHP", "Mouse"}));
        addSetting(new NumSetting("Range", 6, 3, 12, 0.5));
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
