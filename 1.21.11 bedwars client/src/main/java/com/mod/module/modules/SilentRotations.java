package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class SilentRotations extends Module {
    public SilentRotations() {
        super("SilentRotations", Category.COMBAT);
        addSetting(new BoolSetting("OnlyOnClick", true));
        addSetting(new NumSetting("Speed", 10, 1, 20, 1));
        addSetting(new NumSetting("MaxAngle", 180, 30, 360, 5));
    }
    // Rotate without visible snap
}