package org.example;

import org.example.exceptions.SlotAlreadyOccupiedException;
import org.example.exceptions.SlotUnoccupiedException;

public class Slot {
    private Vehicle vehicle;
    private boolean isOccupied;
    private Ticket ticket;

    public Slot() {
        this.isOccupied = false;
    }

    public Ticket park(Vehicle vehicle) {
        if(isOccupied) {
            throw new SlotAlreadyOccupiedException();
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
        Ticket ticket = new Ticket();
        this.ticket = ticket;
        return ticket;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isParked(String registrationNumber) {
        if(!isOccupied) {
            return false;
        }
        return vehicle.hasRegistrationNumber(registrationNumber);
    }

    public void unPark() {
        if (!isOccupied) {
            throw new SlotUnoccupiedException();
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean hasVehicleColor(VehicleColor vehicleColor) {
        return vehicle != null && vehicle.hasColor(vehicleColor);
    }

    public boolean hasTicket(Ticket ticket) {
        return this.ticket != null && this.ticket.equals(ticket);
    }
}
