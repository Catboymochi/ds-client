package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class FPSCounter extends Module {
    public FPSCounter() {
        super("FPSCounter", Category.HUD);
        addSetting(new BoolSetting("ShowMax", false));
        addSetting(new ModeSetting("Position", "TopLeft", new String[]{"TopLeft", "TopRight", "BottomLeft", "BottomRight"}));
    }
    @Override
    public void onRender2D() {
        // Draw FPS on screen
    }
}