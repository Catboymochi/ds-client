package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class PearlHelper extends Module {
    public PearlHelper() {
        super("PearlHelper", Category.MOVEMENT);
        addSetting(new BoolSetting("AutoThrow", true));
        addSetting(new NumSetting("ThrowDelay", 100, 50, 500, 10));
        addSetting(new BoolSetting("OnlyWhenHolding", true));
    }
    @Override
    public void onTick() {
        // Throw pearl at cursor
    }
}