package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class Triggerbot extends Module {
    public Triggerbot() {
        super("Triggerbot", Category.COMBAT);
        addSetting(new NumSetting("Delay", 50, 0, 500, 10));
        addSetting(new BoolSetting("OnlyOnAttack", false));
        addSetting(new NumSetting("HitboxScale", 1.0, 0.5, 2.0, 0.1));
    }
    // Attack when crosshair over target
}