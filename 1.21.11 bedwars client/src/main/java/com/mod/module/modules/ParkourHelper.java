package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class ParkourHelper extends Module {
    public ParkourHelper() {
        super("ParkourHelper", Category.MOVEMENT);
        addSetting(new BoolSetting("AutoJump", true));
        addSetting(new BoolSetting("OnlyWhenSprinting", true));
        addSetting(new NumSetting("JumpDelay", 50, 0, 200, 10));
    }
    @Override
    public void onTick() {
        // Auto jump at block edges
    }
}