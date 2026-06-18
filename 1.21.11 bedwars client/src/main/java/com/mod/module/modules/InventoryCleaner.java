package com.mod.module.modules;

import com.mod.module.Module;
import com.mod.settings.*;

public class InventoryCleaner extends Module {
    public InventoryCleaner() {
        super("InventoryCleaner", Category.INVENTORY);
        addSetting(new BoolSetting("AutoDrop", true));
        addSetting(new ModeSetting("DropMode", "All", new String[]{"All", "Junk", "Dupes"}));
        addSetting(new BoolSetting("KeepTools", true));
    }
    @Override
    public void onTick() {
        // Drop unwanted items
    }
}