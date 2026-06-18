package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class CrystalHelper extends Module {
    public CrystalHelper() {
        super("CrystalHelper", Category.MINIGAME);
        addSetting(new BoolSetting("AutoPlace", true));
        addSetting(new BoolSetting("AutoTrigger", true));
        addSetting(new NumSetting("PlaceDelay", 100, 50, 500, 10));
    }
    @Override
    public void onTick() {
        // Place and trigger end crystals
    }
}