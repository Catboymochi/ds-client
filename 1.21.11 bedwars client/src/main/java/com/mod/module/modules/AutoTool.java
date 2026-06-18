package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class AutoTool extends Module {
    public AutoTool() {
        super("AutoTool", Category.UTILITY);
        addSetting(new BoolSetting("SwitchBack", true));
        addSetting(new BoolSetting("OnlyWhenMining", true));
        addSetting(new NumSetting("SwitchDelay", 50, 0, 200, 10));
    }
    @Override
    public void onTick() {
        // Switch to best tool for block
    }
}