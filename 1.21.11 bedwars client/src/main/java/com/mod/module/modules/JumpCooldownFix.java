package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class JumpCooldownFix extends Module {
    public JumpCooldownFix() {
        super("JumpCooldownFix", Category.MOVEMENT);
        addSetting(new BoolSetting("RemoveCooldown", true));
        addSetting(new NumSetting("JumpHeight", 1.0, 0.5, 2.0, 0.1));
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
