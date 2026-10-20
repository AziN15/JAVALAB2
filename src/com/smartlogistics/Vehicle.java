package com.smartlogistics;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Vehicle {
    private final String id;
    private double maxCapacityKg;
    private double currentLoadKg;
    private final List<ICargo> cargoList = new ArrayList<>();

    public Vehicle(String id, double maxCapacityKg) {
        this.id = (id == null || id.isBlank()) ? UUID.randomUUID().toString() : id;
        if (maxCapacityKg <= 0) {
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        }
        this.maxCapacityKg = maxCapacityKg;
        this.currentLoadKg = 0;
    }

    public abstract void move();

    // Версия 1: только вес
    public void load(double weight) {
        if (weight <= 0) {
            System.out.println("Вес должен быть положительным");
            return;
        }
        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;
            System.out.println("Загружено " + weight + " кг в " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    // Версия 2: именованный груз (ICargo)
    public void load(ICargo item) {
        if (item == null) return;
        if (currentLoadKg + item.getWeight() <= maxCapacityKg) {
            currentLoadKg += item.getWeight();
            cargoList.add(item);
            System.out.println("Загружен " + item.getType() + " (" + item.getWeight() + " кг) в " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    // Версия 3: партия грузов
    public void load(List<? extends ICargo> items) {
        if (items == null || items.isEmpty()) return;
        double total = 0;
        for (ICargo item : items) {
            total += item.getWeight();
        }
        if (currentLoadKg + total <= maxCapacityKg) {
            for (ICargo item : items) {
                currentLoadKg += item.getWeight();
                cargoList.add(item);
            }
            System.out.println("Загружена партия (" + total + " кг) в " + id);
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
    public List<ICargo> getCargoList() { return new ArrayList<>(cargoList); }
}
