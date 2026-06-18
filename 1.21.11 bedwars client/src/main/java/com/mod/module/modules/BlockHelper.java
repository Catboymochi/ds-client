package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class BlockHelper extends Module {
    public BlockHelper() {
        super("BlockHelper", Category.COMBAT);
        addSetting(new BoolSetting("AutoBlock", true));
        addSetting(new BoolSetting("OnlyWhenSword", true));
        addSetting(new NumSetting("BlockDelay", 0, 0, 10, 1));
    }
    // Toggle blocking between swings
}