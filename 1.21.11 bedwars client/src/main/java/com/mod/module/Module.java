package com.mod.module;

import com.mod.event.EventListener;
import com.mod.event.impl.*;
import com.mod.settings.Setting;
import net.minecraft.class_310; // obfuscated name for MinecraftClient
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public abstract class Module implements EventListener {
    private final String name;
    private final Category category;
    private int keyBind = GLFW.GLFW_KEY_UNKNOWN;
    private boolean enabled = false;
    private final List<Setting<?>> settings = new ArrayList<>();

    public enum Category {
        COMBAT, VISUAL, MOVEMENT, UTILITY, INVENTORY, MINIGAME, HUD, MISC
    }

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}
    public void onRender2D() {}
    public void onRender3D(float partialTicks) {}

    @Override
    public void onTick(TickEvent event) { if (enabled) onTick(); }
    @Override
    public void onRender2D(Render2DEvent event) { if (enabled) onRender2D(); }
    @Override
    public void onRender3D(Render3DEvent event) { if (enabled) onRender3D(event.partialTicks); }
    @Override
    public void onKeyPress(KeyPressEvent event) {}

    public void toggle() { setEnabled(!enabled); }
    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (enabled) onEnable();
            else onDisable();
        }
    }

    public String getName() { return name; }
    public Category getCategory() { return category; }
    public int getKeyBind() { return keyBind; }
    public void setKeyBind(int keyBind) { this.keyBind = keyBind; }
    public boolean isEnabled() { return enabled; }
    public List<Setting<?>> getSettings() { return settings; }

    public void addSetting(Setting<?> setting) {
        setting.setParent(this);
        settings.add(setting);
    }
    @SuppressWarnings("unchecked")
    public <T extends Setting<?>> T getSettingByName(String name) {
        for (Setting<?> s : settings) {
            if (s.getName().equalsIgnoreCase(name)) return (T) s;
        }
        return null;
    }

    // Use obfuscated name – works without Yarn mappings
    protected class_310 mc() {
        return class_310.method_1551(); // MinecraftClient.getInstance()
    }
}