package org.example;

import org.example.exceptions.SlotAlreadyOccupiedException;
import org.example.exceptions.SlotUnoccupiedException;

public class Slot {
    private Vehicle vehicle;


    public void park(Vehicle vehicle) {
        if(isOccupied()) {
            throw new SlotAlreadyOccupiedException();
        }
        this.vehicle = vehicle;
    }

    public boolean isOccupied() {
        return vehicle != null;
    }

    public boolean isParked(String registrationNumber) {
        if(!isOccupied()) {
            return false;
        }
        return vehicle.hasRegistrationNumber(registrationNumber);
    }

    public void unPark() {
        if (!isOccupied()) {
            throw new SlotUnoccupiedException();
        }
        this.vehicle = null;
    }

    public boolean hasVehicleColor(VehicleColor vehicleColor) {
        return isOccupied() && vehicle.hasColor(vehicleColor);
    }
}
