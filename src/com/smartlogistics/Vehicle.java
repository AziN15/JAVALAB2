package com.smartlogistics;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Vehicle {
    private final String id;
    private double maxCapacityKg;
    private double currentLoadKg;
    private final List<CargoItem> cargoList = new ArrayList<>();

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
            cargoList.add(new CargoItem("Безымянный груз", weight));
            System.out.println("Загружено " + weight + " кг в " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    public void load(CargoItem item) {
        if (item == null) return;
        if (currentLoadKg + item.getWeight() <= maxCapacityKg) {
            currentLoadKg += item.getWeight();
            cargoList.add(item);
            System.out.println("Загружен груз \"" + item.getName() + "\" (" + item.getWeight() + " кг) в " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id + " (груз: " + item.getName() + ")");
        }
    }

    public void load(List<CargoItem> items) {
        if (items == null || items.isEmpty()) return;
        double totalWeight = 0;
        for (CargoItem item : items) {
            totalWeight += item.getWeight();
        }
        if (currentLoadKg + totalWeight <= maxCapacityKg) {
            for (CargoItem item : items) {
                currentLoadKg += item.getWeight();
                cargoList.add(item);
            }
            System.out.println("Загружена партия из " + items.size() + " грузов (" + totalWeight + " кг) в " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id + " (партия " + totalWeight + " кг)");
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
    public List<CargoItem> getCargoList() { return new ArrayList<>(cargoList); }
}