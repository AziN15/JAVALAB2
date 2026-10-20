package com.smartlogistics;

import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends ICargo> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        if (item != null) {
            items.add(item);
        }
    }

    public double getTotalWeight() {
        double sum = 0;
        for (T item : items) {
            sum += item.getWeight();
        }
        return sum;
    }

    public void printManifest() {
        System.out.println("--- Манифест склада ---");
        for (T item : items) {
            System.out.println(item.getType() + " — " + item.getWeight() + " кг");
        }
        System.out.println("Общий вес: " + getTotalWeight() + " кг\n");
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}
