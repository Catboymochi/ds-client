package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class BoxESP extends Module {
    public BoxESP() {
        super("BoxESP", Category.VISUAL);
        addSetting(new ModeSetting("Color", "Red", new String[]{"Red", "Green", "Blue", "Custom"}));
        addSetting(new NumSetting("LineWidth", 1.5, 1, 5, 0.5));
        addSetting(new BoolSetting("ThroughWalls", true));
        addSetting(new BoolSetting("DrawHealth", true));
        addSetting(new BoolSetting("OnlyHostile", false));
    }
    @Override
    public void onRender3D(float partialTicks) {
        // Draw bounding boxes around entities
    }
}