package com.smartlogistics;

import java.util.Locale;

public class Truck extends Vehicle implements ITrackable {
    private final boolean hasTrailer;
    private double latitude;
    private double longitude;

    public Truck(String id, boolean hasTrailer) {
        super(id, 10000); // базовая грузоподъёмность
        this.hasTrailer = hasTrailer;
        if (hasTrailer) {
            setMaxCapacityKg(getMaxCapacityKg() + 5000);
        }
        // Начальные координаты (Москва)
        this.latitude = 55.7558;
        this.longitude = 37.6173;
    }

    @Override
    public void move() {
        // Имитация движения GPS
        latitude += 0.01;
        longitude += 0.015;
        System.out.println("Грузовик [" + getId() + "] едет по трассе со скоростью 70 км/ч");
    }

    @Override
    public String getCurrentCoordinates() {
        return String.format(Locale.US, "lat=%.4f, lon=%.4f", latitude, longitude);
    }

    @Override
    public void sendStatusUpdate() {
        System.out.println("[STATUS] Truck " + getId() + " → " + getCurrentCoordinates() +
                ", load=" + getCurrentLoadKg() + "/" + getMaxCapacityKg() + " кг");
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }
}
