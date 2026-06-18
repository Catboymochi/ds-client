package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class Tracers extends Module {
    public Tracers() {
        super("Tracers", Category.VISUAL);
        addSetting(new ModeSetting("Color", "Red", new String[]{"Red", "Green", "Blue"}));
        addSetting(new NumSetting("LineWidth", 1, 1, 5, 0.5));
        addSetting(new BoolSetting("ThroughWalls", true));
    }
    @Override
    public void onRender3D(float partialTicks) {
        // Draw lines from player to entities
    }
}