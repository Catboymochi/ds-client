package com.mod;

import com.mod.config.ConfigManager;
import com.mod.event.EventManager;
import com.mod.module.ModuleManager;
import net.fabricmc.api.ModInitializer;

public class ModMain implements ModInitializer {
    @Override
    public void onInitialize() {
        ConfigManager.load();
        ModuleManager.registerModules();
        // Key events are handled by MixinKeyboard -> EventManager.fireKeyPress
        // ClickGUI is opened via keybind: ModuleManager.onKeyPress will toggle
        // but we also need to open the GUI. We'll handle that in ModuleManager's onKeyPress.
        // We'll modify ModuleManager.onKeyPress to open ClickGUI when RSHIFT is pressed.
    }
}