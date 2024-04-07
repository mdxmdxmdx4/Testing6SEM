package com.belstu.collections;

import java.util.ArrayList;
import java.util.List;

public class TaxiPark {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Car car : cars) {
            total += car.getPrice();
        }
        return total;
    }

    public Car findCarBySpeedRange(double minSpeed, double maxSpeed) {
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                return car;
            }
        }
        return null;
    }
    public void sortCarsByFuelConsumption() {
        cars.sort((car1, car2) -> Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption()));
    }

    public void getElements() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
