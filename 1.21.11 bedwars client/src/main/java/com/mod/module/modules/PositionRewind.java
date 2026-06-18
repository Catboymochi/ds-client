package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class PositionRewind extends Module {
    public PositionRewind() {
        super("PositionRewind", Category.MOVEMENT);
        addSetting(new NumSetting("RewindTicks", 5, 1, 20, 1));
        addSetting(new BoolSetting("OnlyOnAttack", true));
    }
    // Interpolate position for hit registration
}