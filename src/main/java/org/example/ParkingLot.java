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
    private final Map<Ticket, Slot> ticketSlotMap;

    public ParkingLot(int totalSlots) {
        if (totalSlots <= 0) {
            throw new InvalidSlotsException();
        }
        slots = new ArrayList<>(totalSlots);
        IntStream.range(0, totalSlots).forEach(i -> slots.add(new Slot()));
        ticketSlotMap = new HashMap<>();
    }

    public ParkingLot(List<Slot> slots) {
        this.slots = slots;
        ticketSlotMap = new HashMap<>();
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
        Slot slot = fetchNearestAvailableSlot();
        Ticket ticket = new Ticket();
        slot.park(vehicle);
        ticketSlotMap.put(ticket, slot);
        return ticket;
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
        if(ticketSlotMap.containsKey(ticket)){
            Slot slot = ticketSlotMap.get(ticket);
            slot.unPark();
            ticketSlotMap.remove(ticket);
            return;
        }
        throw new TicketNotFoundException();
    }

}
