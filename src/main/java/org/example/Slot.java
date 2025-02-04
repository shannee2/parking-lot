package org.example;

import org.example.exceptions.SlotAlreadyOccupiedException;
import org.example.exceptions.SlotUnoccupiedException;

public class Slot {
    private Vehicle vehicle;
    private boolean isOccupied;

    public Slot() {
        this.isOccupied = false;
    }

    public void park(Vehicle vehicle) {
        if(isOccupied) {
            throw new SlotAlreadyOccupiedException();
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isParked(String registrationNumber) {
        if(!isOccupied) {
            return false;
        }
        return vehicle.hasRegistrationNumber(registrationNumber);
    }

    public void unPark() {
        if (!isOccupied) {
            throw new SlotUnoccupiedException();
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean hasVehicleColor(VehicleColor vehicleColor) {
        return vehicle != null && vehicle.hasColor(vehicleColor);
    }
}
