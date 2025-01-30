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

    public boolean park(Vehicle vehicle) {
        for(int i = 0; i < slots.length; i++) {
            if(!slots[i].isOccupied()) {
                slots[i].park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public int getSlotNumber(Vehicle car) {
        for(int i = 0; i < slots.length; i++) {
            if(slots[i].isOccupied() && slots[i].getVehicle().equals(car)) {
                return i+1;
            }
        }
        return -1;
    }

    public boolean isParked(String registrationNumber) {
        for(int i = 0; i < slots.length; i++) {
            if(slots[i].isOccupied() && ((Vehicle)slots[i].getVehicle()).getRegistrationNumber().equals(registrationNumber)) {
                return true;
            }
        }
        return false;
    }

    public int countCarsWithColor(VehicleColor vehicleColor) {
        int count = 0;
        for(int i = 0; i < slots.length; i++) {
            if(slots[i].isOccupied() && ((Vehicle)slots[i].getVehicle()).getColor().equals(vehicleColor)) {
                count++;
            }
        }
        return count;
    }
}
