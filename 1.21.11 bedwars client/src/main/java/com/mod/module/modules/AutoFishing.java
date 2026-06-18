package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class AutoFishing extends Module {
    public AutoFishing() {
        super("AutoFishing", Category.UTILITY);
        addSetting(new BoolSetting("AutoCast", true));
        addSetting(new NumSetting("Delay", 500, 100, 2000, 50));
        addSetting(new BoolSetting("SoundAlert", true));
    }
    @Override
    public void onTick() {
        // Auto cast and reel
    }
}