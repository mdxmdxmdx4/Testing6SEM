package com.belstu.classes;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        TrainService trainService = new TrainService();

        LocalTime time = LocalTime.of(10, 0);

        trainService.printTrainsToDestination("Minsk");
        trainService.printTrainsToDestinationAfterTime("Kropivnitsky", time);
        trainService.printTrainsToDestinationWithSeats("Kazan");
    }
}
