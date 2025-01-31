package org.example;

public class Ticket {
    private String ticketId;

    public Ticket(String registrationNumber, int slotNumber) {
        this.ticketId = registrationNumber.concat(String.valueOf(slotNumber));
    }
}
