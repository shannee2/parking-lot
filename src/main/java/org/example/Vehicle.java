package org.example;

public class Vehicle {
    private final String registrationNumber;
    private VehicleType vehicleType;


    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
    }

    public Object getRegistrationNumber() {
        return registrationNumber;
    }
}
