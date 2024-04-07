package com.belstu.classes;

import java.time.LocalTime;

public class Train {
    private String destination;
    private int trainNumber;
    private LocalTime departureTime;
    private int generalSeats;
    private int coupeSeats;
    private int reservedSeats;
    private int luxSeats;

    public Train(String destination, int trainNumber, LocalTime departureTime, int generalSeats, int coupeSeats, int reservedSeats, int luxSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.generalSeats = generalSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeats = reservedSeats;
        this.luxSeats = luxSeats;
    }

    public Train(String destination, int trainNumber, LocalTime departureTime, int generalSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.generalSeats = generalSeats;
    }

    public Train(int trainNumber, String destination, LocalTime departureTime) {
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public Train(String destination, int trainNumber, LocalTime departureTime, int reservedSeats, int luxSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.reservedSeats = reservedSeats;
        this.luxSeats = luxSeats;
    }

    @Override
    public String toString() {
        return "Train №" + trainNumber +
                ". destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", generalSeats=" + generalSeats +
                ", coupeSeats=" + coupeSeats +
                ", reservedSeats=" + reservedSeats +
                ", luxSeats=" + luxSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getGeneralSeats() {
        return generalSeats;
    }

    public void setGeneralSeats(int generalSeats) {
        this.generalSeats = generalSeats;
    }

    public int getCoupeSeats() {
        return coupeSeats;
    }

    public void setCoupeSeats(int coupeSeats) {
        this.coupeSeats = coupeSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public int getLuxSeats() {
        return luxSeats;
    }

    public void setLuxSeats(int luxSeats) {
        this.luxSeats = luxSeats;
    }
}
