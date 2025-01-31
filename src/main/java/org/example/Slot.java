package org.example;

public class Slot {
    private final int slotNumber;
    private Vehicle vehicle;
    private boolean isOccupied;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public void park(Vehicle vehicle) {
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
            throw new IllegalStateException("Slot is already empty");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean hasVehicle(Vehicle car) {
        return vehicle.equals(car);
    }

    public boolean hasVehicleColor(VehicleColor vehicleColor) {
        return vehicle.hasColor(vehicleColor);
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
