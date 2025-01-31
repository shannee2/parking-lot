package org.example;

public class Vehicle {
    private final String registrationNumber;
    private VehicleColor color;

    public Vehicle(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public Vehicle(String registrationNumber, VehicleColor color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public boolean hasRegistrationNumber(String registrationNumber) {
        return this.registrationNumber.equals(registrationNumber);
    }

    public boolean hasColor(VehicleColor vehicleColor) {
        return this.color.equals(vehicleColor);
    }
}
