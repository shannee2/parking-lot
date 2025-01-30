package org.example;

public class ParkingLot {
    private final Slot[] slots;
    private int availableSlots;

    public ParkingLot(int totalSlots) {
        slots = new Slot[totalSlots];
        for (int i = 0; i < totalSlots; i++) {
            slots[i] = new Slot(i+1);
        }
        this.availableSlots = totalSlots;
    }

    public void park(Vehicle vehicle) {
        if(isFull()){
            throw new IllegalStateException("Parking lot is full");
        }
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.park(vehicle);
                availableSlots--;
                return;
            }
        }
    }

    public boolean isFull() {
        return availableSlots == 0;
    }

    public int getSlotNumber(Vehicle car) {
        for(Slot slot : slots) {
            if(slot.isOccupied() && slot.hasVehicle(car)) {
                return slot.getSlotNumber();
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

    public void unPark(Vehicle car) {
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.hasVehicle(car)) {
                slot.unPark();
                availableSlots++;
                return;
            }
        }
    }
}
