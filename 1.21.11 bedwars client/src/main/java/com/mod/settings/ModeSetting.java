package com.mod.settings;

public class ModeSetting extends Setting<String> {
    private final String[] modes;
    private int index;

    public ModeSetting(String name, String defaultValue, String[] modes) {
        super(name, defaultValue);
        this.modes = modes;
        this.index = 0;
        for (int i = 0; i < modes.length; i++) {
            if (modes[i].equals(defaultValue)) {
                index = i;
                break;
            }
        }
        this.value = modes[index];
    }

    public String[] getModes() { return modes; }
    public String getMode() { return modes[index]; }
    public int getIndex() { return index; }

    public void setIndex(int index) {
        if (index >= 0 && index < modes.length) {
            this.index = index;
            this.value = modes[index];
        }
    }
    public void cycle(boolean forward) {
        if (forward) {
            setIndex((index + 1) % modes.length);
        } else {
            setIndex((index - 1 + modes.length) % modes.length);
        }
    }
    @Override
    public void setValue(String value) {
        for (int i = 0; i < modes.length; i++) {
            if (modes[i].equals(value)) {
                setIndex(i);
                return;
            }
        }
    }
}