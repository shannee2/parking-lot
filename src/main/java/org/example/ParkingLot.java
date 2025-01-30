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
        return true;
    }

    public boolean isFull() {
        return false;
    }
}
