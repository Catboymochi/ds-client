package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class PotionThrower extends Module {
    public PotionThrower() {
        super("PotionThrower", Category.COMBAT);
        addSetting(new BoolSetting("AutoThrow", true));
        addSetting(new ModeSetting("PotionType", "Healing", new String[]{"Healing", "Harm", "Speed"}));
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
