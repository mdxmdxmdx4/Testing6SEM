package com.belstu.classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrainService {
    private List<Train> trains;

    public TrainService() {
        this.trains = new ArrayList<>();
        trains.add(new Train("Minsk", 101, LocalTime.of(15, 0), 100, 50, 30, 20));
        trains.add(new Train("Kropivnitsky", 108, LocalTime.of(16, 0), 80));
        trains.add(new Train(71, "Oslo", LocalTime.of(17, 0)));
        trains.add(new Train("Kazan", 103, LocalTime.of(18, 0), 40, 20));
    }

    public void printTrainsToDestination(String destination) {
        trains.stream()
                .filter(train -> train.getDestination().equals(destination))
                .forEach(System.out::println);
    }

    public void printTrainsToDestinationAfterTime(String destination, LocalTime time) {
        trains.stream()
                .filter(train -> train.getDestination().equals(destination) && train.getDepartureTime().isAfter(time))
                .forEach(System.out::println);
    }

    public void printTrainsToDestinationWithSeats(String destination) {
        trains.stream()
                .filter(train -> train.getDestination().equals(destination) && train.getGeneralSeats() > 0)
                .forEach(System.out::println);
    }
}