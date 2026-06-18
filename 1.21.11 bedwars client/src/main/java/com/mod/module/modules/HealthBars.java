package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class HealthBars extends Module {
    public HealthBars() {
        super("HealthBars", Category.VISUAL);
        addSetting(new BoolSetting("ShowNumber", true));
        addSetting(new NumSetting("Scale", 1.0, 0.5, 2.0, 0.1));
        addSetting(new BoolSetting("OnlyHostile", false));
    }
    @Override
    public void onRender3D(float partialTicks) {
        // Draw health above entities
    }
}