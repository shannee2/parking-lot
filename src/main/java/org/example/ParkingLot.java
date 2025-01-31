package org.example;

import org.example.exceptions.AllSlotsOccupiedException;
import org.example.exceptions.InvalidSlotsException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingLot {
    private final List<Slot> slots;
    private int availableSlots;

    public ParkingLot(int totalSlots) {
        if (totalSlots <= 0) {
            throw new InvalidSlotsException();
        }
        slots = new ArrayList<>(totalSlots);
        IntStream.range(0, totalSlots).forEach(i -> slots.add(new Slot()));
        this.availableSlots = totalSlots;
    }

    private Slot fetchNearestAvailableSlot() {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        throw new AllSlotsOccupiedException();
    }

    public Ticket park(Vehicle vehicle) {
        if(isFull()){
            throw new AllSlotsOccupiedException();
        }
        Slot slot = fetchNearestAvailableSlot();
        Ticket ticket = slot.park(vehicle);
        availableSlots--;
        return ticket;
    }

    public boolean isFull() {
        return availableSlots == 0;
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
