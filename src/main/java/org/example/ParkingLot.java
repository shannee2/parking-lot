package org.example;

public class ParkingLot {
    private final Slot[] slots;
    private Ticket[] tickets;
    private int availableSlots;

    public ParkingLot(int totalSlots) {
        slots = new Slot[totalSlots];
        for (int i = 0; i < totalSlots; i++) {
            slots[i] = new Slot(i+1);
        }
        this.availableSlots = totalSlots;
        this.tickets = new Ticket[totalSlots];
    }

    public Ticket park(Vehicle vehicle) {
        if(isFull()){
            throw new IllegalStateException("Parking lot is full");
        }
        for (int i = 0; i < slots.length; i++) {
            if (!slots[i].isOccupied()) {
                slots[i].park(vehicle);
                availableSlots--;
                Ticket ticket = new Ticket(vehicle.getRegistrationNumber(), slots[i].getSlotNumber());
                tickets[i] = ticket;
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

    public void unPark(Ticket ticket) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].equals(ticket)) {
                slots[i].unPark();
                tickets[i] = null;
                availableSlots++;
                return;
            }
        }
        throw new IllegalStateException("Vehicle not found in parking lot");
    }
}
