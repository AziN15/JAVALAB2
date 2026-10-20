package com.smartlogistics;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR-001", 4);
        Truck truck = new Truck("TRUCK-777", true);
        Drone drone = new Drone("DRONE-42", 95);

        truck.load(new StandardBox("SB-1", "Запчасти", 3200));
        truck.load(new FragileItem("FR-1", "Стекло", 150, true));
        drone.load(new StandardBox("SB-2", "Документы", 1.8));

        List<Vehicle> fleet = Arrays.asList(car, truck, drone);
        new FleetManager().startDelivery(fleet);

        List<ITrackable> trackable = Arrays.asList(truck, drone);
        // List<ITrackable> bad = Arrays.asList(truck, drone, car); // ошибка компиляции

        LogisticsCenter center = new LogisticsCenter();
        center.dispatch(trackable);

        truck.move();
        drone.move();

        center.monitorFleet(trackable);
    }
}