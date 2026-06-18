package com.mod.settings;

public class BoolSetting extends Setting<Boolean> {
    public BoolSetting(String name, boolean defaultValue) {
        super(name, defaultValue);
    }
    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }
    public void toggle() {
        setValue(!getValue());
    }
}