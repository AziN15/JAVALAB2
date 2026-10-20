package com.smartlogistics;

public class Drone extends Vehicle {
    private int batteryLevel;

    public Drone(String id, int batteryLevel) {
        super(id, 5);
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Заряд батареи должен быть в диапазоне 0–100");
        }
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void move() {
        if (batteryLevel < 5) {
            System.out.println("Дрон [" + getId() + "] не может лететь — низкий заряд батареи: " + batteryLevel + "%");
            return;
        }
        batteryLevel -= 5;
        System.out.println("Дрон [" + getId() + "] летит по воздуху, заряд батареи: " + batteryLevel + "%");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}