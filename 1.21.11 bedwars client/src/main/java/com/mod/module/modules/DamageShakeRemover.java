package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class DamageShakeRemover extends Module {
    public DamageShakeRemover() {
        super("DamageShakeRemover", Category.MISC);
        // No settings needed
    }
    // The mixin will cancel hurtCameraEffect
}