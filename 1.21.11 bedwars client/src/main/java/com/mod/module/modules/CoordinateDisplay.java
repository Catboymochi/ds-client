package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class CoordinateDisplay extends Module {
    public CoordinateDisplay() {
        super("CoordinateDisplay", Category.HUD);
        addSetting(new BoolSetting("ShowNether", true));
        addSetting(new ModeSetting("Position", "TopLeft", new String[]{"TopLeft", "TopRight"}));
    }
    @Override
    public void onRender2D() {
        // Draw XYZ coordinates
    }
}