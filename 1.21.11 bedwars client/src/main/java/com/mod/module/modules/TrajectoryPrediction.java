package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class TrajectoryPrediction extends Module {
    public TrajectoryPrediction() {
        super("TrajectoryPrediction", Category.VISUAL);
        addSetting(new BoolSetting("ShowLine", true));
        addSetting(new NumSetting("Points", 20, 10, 50, 1));
        addSetting(new BoolSetting("ShowArrow", true));
    }
    @Override
    public void onRender3D(float partialTicks) {
        // Draw trajectory arc
    }
}