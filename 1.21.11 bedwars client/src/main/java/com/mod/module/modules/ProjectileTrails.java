package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class ProjectileTrails extends Module {
    public ProjectileTrails() {
        super("ProjectileTrails", Category.VISUAL);
        addSetting(new ModeSetting("Color", "Red", new String[]{"Red", "Green", "Blue"}));
        addSetting(new NumSetting("Length", 20, 5, 50, 1));
        addSetting(new BoolSetting("OnlyOwn", true));
    }
    @Override
    public void onRender3D(float partialTicks) {
        // Render trails behind projectiles
    }
}