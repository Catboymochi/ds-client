package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class Freecam extends Module {
    public Freecam() {
        super("Freecam", Category.MOVEMENT);
        addSetting(new NumSetting("Speed", 1.0, 0.1, 10, 0.1));
        addSetting(new BoolSetting("Smooth", true));
        addSetting(new ModeSetting("FlyMode", "Creative", new String[]{"Creative", "Spectator"}));
    }
    @Override
    public void onEnable() {
        // Store original position and enable freecam
    }
    @Override
    public void onDisable() {
        // Restore position
    }
}