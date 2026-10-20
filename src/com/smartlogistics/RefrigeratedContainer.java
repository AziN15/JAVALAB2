package com.smartlogistics;

public class RefrigeratedContainer extends BaseCargo {
    private final double targetTemperature;

    public RefrigeratedContainer(String id, String name, double weight, double targetTemperature) {
        super(id, name, weight);
        this.targetTemperature = targetTemperature;
    }

    @Override
    public String getType() {
        return "RefrigeratedContainer (target: " + targetTemperature + "°C)";
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }
}
