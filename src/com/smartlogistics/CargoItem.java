package com.smartlogistics;

/**
 * Старый класс груза из Задачи 2.
 * Оставлен для совместимости. В Задаче 3+ используется иерархия ICargo / BaseCargo.
 */
public class CargoItem {
    private final String name;
    private final double weight;

    public CargoItem(String name, double weight) {
        this.name = name;
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным");
        }
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return name + " (" + weight + " кг)";
    }
}
