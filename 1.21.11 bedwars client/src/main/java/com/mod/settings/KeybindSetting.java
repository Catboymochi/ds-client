package com.mod.settings;

import org.lwjgl.glfw.GLFW;

public class KeybindSetting extends Setting<Integer> {
    public KeybindSetting(String name, int defaultKey) {
        super(name, defaultKey);
    }
    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
    public String getKeyName() {
        return value == GLFW.GLFW_KEY_UNKNOWN ? "None" : GLFW.glfwGetKeyName(value, 0);
    }
}