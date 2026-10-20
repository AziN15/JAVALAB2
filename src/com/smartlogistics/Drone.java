package com.smartlogistics;

import java.util.Locale;

public class Drone extends Vehicle implements ITrackable {
    private int batteryLevel;
    private double latitude;
    private double longitude;
    private double altitude;

    public Drone(String id, int batteryLevel) {
        super(id, 5); // максимум 5 кг
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Заряд батареи должен быть в диапазоне 0–100");
        }
        this.batteryLevel = batteryLevel;
        this.latitude = 55.7558;
        this.longitude = 37.6173;
        this.altitude = 120.0;
    }

    @Override
    public void move() {
        if (batteryLevel < 5) {
            System.out.println("Дрон [" + getId() + "] не может лететь — низкий заряд: " + batteryLevel + "%");
            return;
        }
        batteryLevel -= 5;
        // Имитация движения GPS
        latitude += 0.005;
        longitude += 0.008;
        altitude += 2.5;
        System.out.println("Дрон [" + getId() + "] летит по воздуху, заряд батареи: " + batteryLevel + "%");
    }

    @Override
    public String getCurrentCoordinates() {
        return String.format(Locale.US, "lat=%.4f, lon=%.4f, alt=%.1f м", latitude, longitude, altitude);
    }

    @Override
    public void sendStatusUpdate() {
        System.out.println("[STATUS] Drone " + getId() + " → " + getCurrentCoordinates() +
                ", battery=" + batteryLevel + "%");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
