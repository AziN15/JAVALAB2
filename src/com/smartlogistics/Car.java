package com.smartlogistics;

public class Car extends Vehicle {
    private final int passengerCount;

    public Car(String id, int passengerCount) {
        super(id, 500); // максимум 500 кг
        if (passengerCount < 0) {
            throw new IllegalArgumentException("Количество пассажиров не может быть отрицательным");
        }
        this.passengerCount = passengerCount;
    }

    @Override
    public void move() {
        System.out.println("Легковой автомобиль [" + getId() + "] едет по дороге со скоростью 90 км/ч");
    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
