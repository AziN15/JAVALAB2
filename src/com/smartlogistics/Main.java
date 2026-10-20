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
        

        LogisticsCenter center = new LogisticsCenter();
        center.dispatch(trackable);

        truck.move();
        drone.move();

        center.monitorFleet(trackable);

       
        Warehouse<StandardBox> boxWarehouse = new Warehouse<>();
        boxWarehouse.addItem(new StandardBox("SB-10", "Одежда", 12.5));
        boxWarehouse.addItem(new StandardBox("SB-11", "Книги", 8.0));

        Warehouse<FragileItem> fragileWarehouse = new Warehouse<>();
        fragileWarehouse.addItem(new FragileItem("FR-10", "Ваза", 3.2, true));
        fragileWarehouse.addItem(new FragileItem("FR-11", "Монитор", 7.5, true));

      

        boxWarehouse.printManifest();
        fragileWarehouse.printManifest();

        new Report<>(boxWarehouse).printReport();
        new Report<>(fragileWarehouse).printReport();
        new Report<>("Текстовый отчёт о доставке").printReport();
    }
}
