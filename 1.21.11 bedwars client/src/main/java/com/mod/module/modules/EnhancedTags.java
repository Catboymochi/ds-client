package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class EnhancedTags extends Module {
    public EnhancedTags() {
        super("EnhancedTags", Category.VISUAL);
        addSetting(new NumSetting("Scale", 1.2, 0.5, 2.0, 0.1));
        addSetting(new BoolSetting("ShowHealth", true));
        addSetting(new BoolSetting("ShowArmor", true));
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
