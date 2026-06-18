package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class AntiIdle extends Module {
    public AntiIdle() {
        super("AntiIdle", Category.UTILITY);
        addSetting(new ModeSetting("Method", "Sprint", new String[]{"Sprint", "Jump", "Chat"}));
        addSetting(new NumSetting("Interval", 10, 1, 60, 1));
    }
    @Override
    public void onTick() {
        // Perform idle action periodically
    }
}