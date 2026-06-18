package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;
import org.lwjgl.input.Keyboard;

public class HotbarOrganizer extends Module {
    public HotbarOrganizer() {
        super("HotbarOrganizer", Category.INVENTORY);
        addSetting(new ModeSetting("Slot1", "Sword", new String[]{"Sword", "Pickaxe", "Axe"}));
        addSetting(new ModeSetting("Slot2", "Pickaxe", new String[]{"Pickaxe", "Sword", "Axe"}));
        addSetting(new BoolSetting("AutoSort", true));
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
