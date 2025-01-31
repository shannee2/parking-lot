package org.example;

import org.example.exceptions.InvalidSlotsException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Slot> slots;
    private int availableSlots;

    public ParkingLot(int totalSlots) {
        if (totalSlots <= 0) {
            throw new InvalidSlotsException();
        }
        slots = new ArrayList<>(totalSlots);
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new Slot(i));
        }
        this.availableSlots = totalSlots;
    }

    public Ticket park(Vehicle vehicle) {
        if(isFull()){
            throw new IllegalStateException("Parking lot is full");
        }
        for (Slot slot: slots) {
            if (!slot.isOccupied()) {
                Ticket ticket = slot.park(vehicle);
                availableSlots--;
                return ticket;
            }
        }
        return null;
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

    public boolean isVehicleParked(String registrationNumber) {
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

    public void unPark(Ticket ticket) {
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.hasTicket(ticket)) {
                slot.unPark();
                availableSlots++;
                return;
            }
        }
        throw new IllegalStateException("Vehicle not found in parking lot");
    }
}
