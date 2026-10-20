package com.smartlogistics;

import java.util.List;

public class LogisticsCenter {

    // Принимает ТОЛЬКО отслеживаемый транспорт
    public void dispatch(List<ITrackable> trackableVehicles) {
        System.out.println("\n=== Отправка статуса ===");
        for (ITrackable v : trackableVehicles) {
            v.sendStatusUpdate();
        }
    }

    public void monitorFleet(List<ITrackable> trackableVehicles) {
        System.out.println("\n=== Мониторинг флота ===");
        for (ITrackable v : trackableVehicles) {
            System.out.println(v.getClass().getSimpleName() + ": " + v.getCurrentCoordinates());
        }
    }
}
