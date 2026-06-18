package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class AimAssist extends Module {
    public AimAssist() {
        super("AimAssist", Category.COMBAT);
        addSetting(new BoolSetting("Smooth", true));
        addSetting(new NumSetting("Speed", 10, 1, 20, 0.5));
        addSetting(new NumSetting("Range", 4.5, 3, 8, 0.5));
        addSetting(new BoolSetting("OnlyOnAttack", false));
        addSetting(new ModeSetting("TargetMode", "Closest", new String[]{"Closest", "LowestHP", "Cursor"}));
    }
    // Implement aim smoothing in onTick()
}