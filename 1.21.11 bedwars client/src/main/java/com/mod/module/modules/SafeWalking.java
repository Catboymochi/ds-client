package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class SafeWalking extends Module {
    public SafeWalking() {
        super("SafeWalking", Category.MOVEMENT);
        addSetting(new BoolSetting("OnlyOnEdge", true));
        addSetting(new BoolSetting("SneakAtEdge", true));
    }
    @Override
    public void onTick() {
        // Prevent walking off edges
    }
}