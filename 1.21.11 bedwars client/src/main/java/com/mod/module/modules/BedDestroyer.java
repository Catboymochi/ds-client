package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class BedDestroyer extends Module {
    public BedDestroyer() {
        super("BedDestroyer", Category.MINIGAME);
        addSetting(new BoolSetting("AutoSwitch", true));
        addSetting(new BoolSetting("OnlyWhenHoldingPickaxe", true));
    }
    @Override
    public void onTick() {
        // Auto break beds in BedWars
    }
}