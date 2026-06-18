package com.mod.settings;

import com.mod.module.Module;

public abstract class Setting<T> {
    private final String name;
    private Module parent;
    protected T value;

    public Setting(String name, T defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    public String getName() { return name; }
    public Module getParent() { return parent; }
    public void setParent(Module parent) { this.parent = parent; }
    public T getValue() { return value; }
    public abstract void setValue(T value);
}