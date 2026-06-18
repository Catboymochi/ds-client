package com.mod.settings;

public class NumSetting extends Setting<Double> {
    private final double min, max, increment;

    public NumSetting(String name, double defaultValue, double min, double max, double increment) {
        super(name, defaultValue);
        this.min = min;
        this.max = max;
        this.increment = increment;
    }
    public double getMin() { return min; }
    public double getMax() { return max; }
    public double getIncrement() { return increment; }
    @Override
    public void setValue(Double value) {
        this.value = Math.max(min, Math.min(max, value));
    }
}