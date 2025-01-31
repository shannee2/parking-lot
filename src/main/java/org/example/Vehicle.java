package org.example;

public class Vehicle {
    private final String registrationNumber;
    private VehicleType vehicleType;
    private VehicleColor color;

    public Vehicle(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType, VehicleColor color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public boolean hasRegistrationNumber(String registrationNumber) {
        return this.registrationNumber.equals(registrationNumber);
    }

    public boolean hasColor(VehicleColor vehicleColor) {
        return this.color.equals(vehicleColor);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
