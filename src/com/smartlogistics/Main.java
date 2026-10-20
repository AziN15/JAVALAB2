package com.smartlogistics;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR-001", 4);
        Truck truck = new Truck("TRUCK-001", true);
        Drone drone = new Drone("DRONE-001", 90);

        car.load(200);
        truck.load(new CargoItem("Станки", 4500));
        drone.load(Arrays.asList(
                new CargoItem("Документы", 1.5),
                new CargoItem("Лекарства", 2.0)
        ));

        List<Vehicle> fleet = Arrays.asList(car, truck, drone);
        new FleetManager().startDelivery(fleet);

        drone.move();
    }
}