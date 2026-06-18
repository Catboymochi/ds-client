package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class StorageGlow extends Module {
    public StorageGlow() {
        super("StorageGlow", Category.VISUAL);
        addSetting(new ModeSetting("Color", "Yellow", new String[]{"Yellow", "Blue", "Red"}));
        addSetting(new BoolSetting("ThroughWalls", true));
    }
    @Override
    public void onRender3D(float partialTicks) {
        // Highlight chests/barrels
    }
}