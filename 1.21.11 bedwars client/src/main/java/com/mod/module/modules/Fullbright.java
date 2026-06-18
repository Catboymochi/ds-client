package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class Fullbright extends Module {
    public Fullbright() {
        super("Fullbright", Category.VISUAL);
        addSetting(new ModeSetting("Mode", "Gamma", new String[]{"Gamma", "NightVision"}));
        addSetting(new NumSetting("Brightness", 100, 1, 100, 1));
    }
    @Override
    public void onEnable() {
        if (getSettingByName("Mode").getMode().equals("Gamma")) {
            mc().gameSettings.gammaSetting = 100f;
        }
    }
    @Override
    public void onDisable() {
        mc().gameSettings.gammaSetting = 0.0f;
    }
}