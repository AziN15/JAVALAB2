package com.smartlogistics;

public class Report<T> {
    private final T data;

    public Report(T data) {
        this.data = data;
    }

    public void printReport() {
        System.out.println("=== Отчёт ===");
        System.out.println("Тип данных: " + (data != null ? data.getClass().getSimpleName() : "null"));
        System.out.println("Содержимое: " + data);
        System.out.println("=============\n");
    }

    public T getData() {
        return data;
    }
}
