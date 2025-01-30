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

    public boolean unPark() {
        if (!isOccupied) {
            throw new IllegalStateException("Slot is already empty");
        }
        this.vehicle = null;
        this.isOccupied = false;
        return false;
    }
}
