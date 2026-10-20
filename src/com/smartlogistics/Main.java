package com.smartlogistics;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR-001", 4);
        Truck truck = new Truck("TRUCK-001", true);
        Drone drone = new Drone("DRONE-001", 80);

        System.out.println("Car capacity: " + car.getMaxCapacityKg());
        System.out.println("Truck capacity: " + truck.getMaxCapacityKg());
        System.out.println("Drone capacity: " + drone.getMaxCapacityKg());

        car.load(300);
        truck.load(12000);
        drone.load(3);
        drone.load(4);

        car.move();
        truck.move();
        drone.move();
    }
}