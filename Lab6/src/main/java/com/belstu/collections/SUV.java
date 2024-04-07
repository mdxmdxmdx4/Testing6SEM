package com.belstu.collections;

public class SUV extends Car {
    public SUV(String model,double fuelConsumption, double maxSpeed, double price){
        super();
        this.setModel(model);
        this.setFuelConsumption(fuelConsumption * 1.11);
        this.setPrice(price);
        this.setMaxSpeed(maxSpeed);
    }

    @Override
    public String toString() {
        return "SUV{" +
                "model='" + getModel() + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", maxSpeed=" + getMaxSpeed() +
                ", price=" + getPrice() +
                '}';
    }


}
