package com.smartlogistics;

import java.util.UUID;

public abstract class Vehicle {
    private final String id;
    private double maxCapacityKg;
    private double currentLoadKg;

    public Vehicle(String id, double maxCapacityKg) {
        this.id = (id == null || id.isBlank()) ? UUID.randomUUID().toString() : id;
        if (maxCapacityKg <= 0) {
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        }
        this.maxCapacityKg = maxCapacityKg;
        this.currentLoadKg = 0;
    }

    public abstract void move();

    public void load(double weight) {
        if (weight <= 0) {
            System.out.println("Вес должен быть положительным");
            return;
        }
        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;
            System.out.println("Загружено " + weight + " кг в " + id +
                    ". Текущая загрузка: " + currentLoadKg + "/" + maxCapacityKg);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    protected void setMaxCapacityKg(double maxCapacityKg) {
        this.maxCapacityKg = maxCapacityKg;
    }

    protected void setCurrentLoadKg(double currentLoadKg) {
        this.currentLoadKg = currentLoadKg;
    }

    public String getId() { return id; }
    public double getMaxCapacityKg() { return maxCapacityKg; }
    public double getCurrentLoadKg() { return currentLoadKg; }
}