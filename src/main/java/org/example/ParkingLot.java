package org.example;

import org.example.exceptions.AllSlotsOccupiedException;
import org.example.exceptions.InvalidSlotsException;
import org.example.exceptions.TicketNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private final List<Slot> slots;
    private Map<Ticket, Slot> map;
    private int availableSlots;

    public ParkingLot(int totalSlots) {
        if (totalSlots <= 0) {
            throw new InvalidSlotsException();
        }
        slots = new ArrayList<>(totalSlots);
        IntStream.range(0, totalSlots).forEach(i -> slots.add(new Slot()));
        this.availableSlots = totalSlots;
        map = new HashMap<>();
    }

    public ParkingLot(List<Slot> slots) {
        this.slots = slots;
        this.availableSlots = (int) slots.stream().filter(slot -> !slot.isOccupied()).count();
        map = new HashMap<>();
    }

    private Slot fetchNearestAvailableSlot() {
        if(isFull()){
            throw new AllSlotsOccupiedException();
        }
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        throw new AllSlotsOccupiedException();
    }

    public Ticket park(Vehicle vehicle) {
        Slot slot = fetchNearestAvailableSlot();
        Ticket ticket = new Ticket();
        slot.park(vehicle);
        map.put(ticket, slot);
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
            if (slot.hasVehicleColor(vehicleColor)) {
                count++;
            }
        }
        return count;
    }

    public void unPark(Ticket ticket) {
        for(Ticket t: map.keySet()){
            if(t == ticket){
                Slot slot = map.get(t);
                slot.unPark();
                map.remove(t);
                availableSlots++;
                return;
            }
        }
        throw new TicketNotFoundException();
    }

}
