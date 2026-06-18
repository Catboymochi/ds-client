package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class WTap extends Module {
    public WTap() {
        super("WTap", Category.COMBAT);
        addSetting(new BoolSetting("Auto", true));
        addSetting(new NumSetting("Delay", 100, 50, 500, 10));
        addSetting(new BoolSetting("OnlyOnHit", true));
    }
    // Reset sprint for extra knockback
}