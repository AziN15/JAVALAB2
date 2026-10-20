package com.smartlogistics;

public class Truck extends Vehicle {
    private final boolean hasTrailer;

    public Truck(String id, boolean hasTrailer) {
        super(id, 10000);
        this.hasTrailer = hasTrailer;
        if (hasTrailer) {
            setMaxCapacityKg(getMaxCapacityKg() + 5000);
        }
    }

    @Override
    public void move() {
        System.out.println("Грузовик [" + getId() + "] едет по трассе со скоростью 70 км/ч");
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }
}