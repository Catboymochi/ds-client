package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class AnchorPlacer extends Module {
    public AnchorPlacer() {
        super("AnchorPlacer", Category.UTILITY);
        addSetting(new BoolSetting("AutoPlace", true));
        addSetting(new NumSetting("PlaceRadius", 4, 1, 8, 1));
    }

    @Override
    public void onEnable() { /* enable logic */ }
    @Override
    public void onDisable() { /* disable logic */ }
    @Override
    public void onTick() { if (!isEnabled()) return; /* logic */ }
    @Override
    public void onRender2D() { /* 2D render */ }
    @Override
    public void onRender3D(float partialTicks) { /* 3D render */ }
}
