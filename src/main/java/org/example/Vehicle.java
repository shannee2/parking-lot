package org.example;

public class Vehicle {
    private final String registrationNumber;
    private VehicleType vehicleType;


    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) obj;
        return registrationNumber.equals(vehicle.registrationNumber);
    }
}
