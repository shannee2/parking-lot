package org.example;

public class Vehicle {
    private final String registrationNumber;
    private VehicleType vehicleType;
    private VehicleColor color;


    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType, VehicleColor color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }


    public Object getRegistrationNumber() {
        return registrationNumber;
    }

    public Object getColor() {
        return color;
    }
}
