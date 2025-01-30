package org.example;

import java.util.List;

public class ParkingLot {
    private Slot[] slots;

    public ParkingLot(int totalSlots) {
        slots = new Slot[totalSlots];
        for (int i = 0; i < totalSlots; i++) {
            slots[i] = new Slot(i+1);
        }
    }

    public void park(Vehicle vehicle) {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.park(vehicle);
                return;
            }
        }
        throw new IllegalStateException("Parking lot is full");
    }

    public boolean isFull() {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    public int getSlotNumber(Vehicle car) {
        for(int i = 0; i < slots.length; i++) {
            if(slots[i].isOccupied() && slots[i].hasVehicle(car)) {
                return i+1;
            }
        }
        return -1;
    }

    public boolean isParked(String registrationNumber) {
        for (Slot slot : slots) {
            if (slot.isParked(registrationNumber)) {
                return true;
            }
        }
        return false;
    }

    public int countCarsWithColor(VehicleColor vehicleColor) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.hasVehicleColor(vehicleColor)) {
                count++;
            }
        }
        return count;
    }
}
