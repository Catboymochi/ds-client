package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class KeystrokeDisplay extends Module {
    public KeystrokeDisplay() {
        super("KeystrokeDisplay", Category.HUD);
        addSetting(new BoolSetting("ShowCPS", true));
        addSetting(new ModeSetting("Position", "BottomRight", new String[]{"BottomRight", "BottomLeft"}));
    }
    @Override
    public void onRender2D() {
        // Draw WASD and mouse clicks
    }
}