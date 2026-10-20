package com.smartlogistics;

import java.util.List;

public class FleetManager {
    public void startDelivery(List<Vehicle> fleet) {
        System.out.println("\n=== Начало доставки ===");
        for (Vehicle v : fleet) {
            v.move(); // полиморфный вызов
        }
        System.out.println("=== Доставка завершена ===\n");
    }
}
