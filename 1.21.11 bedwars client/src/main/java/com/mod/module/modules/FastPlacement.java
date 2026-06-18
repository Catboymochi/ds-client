package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class FastPlacement extends Module {
    public FastPlacement() {
        super("FastPlacement", Category.UTILITY);
        addSetting(new NumSetting("Delay", 0, 0, 4, 1));
        addSetting(new BoolSetting("OnlyWhenHolding", false));
    }
    // Remove placement delay
}