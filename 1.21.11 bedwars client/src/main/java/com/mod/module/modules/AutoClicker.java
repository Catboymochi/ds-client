package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class AutoClicker extends Module {
    public AutoClicker() {
        super("AutoClicker", Category.COMBAT);
        addSetting(new NumSetting("CPS", 12, 6, 20, 0.5));
        addSetting(new BoolSetting("Jitter", false));
        addSetting(new NumSetting("JitterAmount", 2, 0, 5, 0.5));
        addSetting(new BoolSetting("OnlyWhileHolding", true));
        addSetting(new BoolSetting("Randomize", true));
    }
    // Implement clicking logic in onTick()
}