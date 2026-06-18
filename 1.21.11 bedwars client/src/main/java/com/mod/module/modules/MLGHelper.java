package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class MLGHelper extends Module {
    public MLGHelper() {
        super("MLGHelper", Category.MOVEMENT);
        addSetting(new BoolSetting("AutoPlaceWater", true));
        addSetting(new BoolSetting("OnlyWhenFalling", true));
        addSetting(new NumSetting("WaterDelay", 100, 50, 300, 10));
    }
    @Override
    public void onTick() {
        // Place water bucket when falling
    }
}