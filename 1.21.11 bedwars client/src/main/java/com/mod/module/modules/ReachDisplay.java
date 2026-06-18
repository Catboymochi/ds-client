package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class ReachDisplay extends Module {
    public ReachDisplay() {
        super("ReachDisplay", Category.HUD);
        addSetting(new BoolSetting("ShowOnCrosshair", true));
        addSetting(new ModeSetting("Position", "TopLeft", new String[]{"TopLeft", "TopRight"}));
    }
    @Override
    public void onRender2D() {
        // Show current interaction distance
    }
}