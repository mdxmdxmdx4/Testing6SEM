package com.belstu.collections;

public class Sedan extends Car {
    public Sedan(String model, double fuelConsumption, double maxSpeed, double price, boolean isElectrical){
        super();
        this.setModel(model);
        this.isElectrical = isElectrical;
        if(isElectrical){
            this.setFuelConsumption(0);
            this.setPrice(price - (price / 20));
        }
        else {
            this.setFuelConsumption(fuelConsumption * 0.95);
            this.setPrice(price);
        }
        this.setMaxSpeed(maxSpeed);
    }
    boolean isElectrical;

    @Override
    public String toString() {
        return "Sedan{" +
                "model='" + getModel() + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", maxSpeed=" + getMaxSpeed() +
                ", price=" + getPrice() +
                ", isElectrical=" + isElectrical +
                '}';
    }

}
