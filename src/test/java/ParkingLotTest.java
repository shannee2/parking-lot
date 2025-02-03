import org.example.*;
import org.example.exceptions.InvalidSlotsException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ParkingLotTest {

    @Test
    public void testParkingLotCreation() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertFalse(parkingLot.isFull());
    }

    @Test
    public void testThrowInvalidSlotsException_WhenParkingLotCreatedWith0Slots() {
        assertThrows(InvalidSlotsException.class, () -> new ParkingLot(0));
    }

    @Test
    public void testThrowInvalidSlotsException_WhenParkingLotCreatedWithNegativeSlots() {
        assertThrows(InvalidSlotsException.class, () -> new ParkingLot(-1));
    }

    @Test
    public void testParkVehicle_InAvailableSlot() {
        ParkingLot parkingLot = new ParkingLot(1);
        String registrationNumber = "KA-01-HH-1234";
        Vehicle car = new Vehicle(registrationNumber);

        parkingLot.park(car);
        boolean isParked = parkingLot.isVehicleParked(registrationNumber);

        assertTrue(isParked);
    }

    @Test
    public void testParkVehicle_InNearestAvailableSlot2() {
        Slot slot1 = new Slot();
        Slot slot2 = new Slot();
        Slot slot3 = new Slot();
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(Arrays.asList(slot1, slot2, slot3)));
        Vehicle car1 = new Vehicle("KA-01-HH-1234");
        Vehicle car2 = new Vehicle("KA-01-HH-9999");

        parkingLot.park(car1);
        assertFalse(slot2.isOccupied());
        parkingLot.park(car2);
        assertTrue(slot2.isOccupied());
    }

    @Test
    public void testParkVehicle_InNearestAvailableSlot1() {
        Slot slot1 = new Slot();
        Slot slot2 = new Slot();
        Slot slot3 = new Slot();
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(Arrays.asList(slot1, slot2, slot3)));
        Vehicle car1 = new Vehicle("KA-01-HH-1234");
        Vehicle car2 = new Vehicle("KA-01-HH-9999");
        Vehicle car3 = new Vehicle("KA-01-HH-9998");

        Ticket ticket1 = parkingLot.park(car1);
        parkingLot.park(car2);
        assertTrue(slot1.isOccupied());
        parkingLot.unPark(ticket1);
        assertFalse(slot1.isOccupied());
        parkingLot.park(car3);
        assertTrue(slot1.isOccupied());
    }

    @Test
    public void testIfVehicleWithRegistrationNumberIsVehicleParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car1 = new Vehicle("KA-01-HH-1234");

        parkingLot.park(car1);

        assertTrue(parkingLot.isVehicleParked("KA-01-HH-1234"));
    }

    @Test
    public void testCountOfCarsWithRedColor(){
        ParkingLot parkingLot = new ParkingLot(5);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleColor.RED);
        Vehicle car2 = new Vehicle("KA-01-HH-9999", VehicleColor.RED);
        Vehicle car3 = new Vehicle("KA-01-HH-9998", VehicleColor.BLUE);
        Vehicle car4 = new Vehicle("KA-01-HH-9997", VehicleColor.RED);

        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        parkingLot.park(car4);

        assertEquals(3, parkingLot.countCarsWithColor(VehicleColor.RED));
    }

    @Test
    public void testUnparkVehicle() {
        ParkingLot parkingLot = new ParkingLot(1);

        String registrationNumber = "KA-01-HH-1234";
        Vehicle car = new Vehicle(registrationNumber);
        Ticket ticket = parkingLot.park(car);
        parkingLot.unPark(ticket);

        assertFalse(parkingLot.isVehicleParked(registrationNumber));
    }

    @Test
    public void testIfParkingLotCallingSlotMethodToPark() {
        Slot mockSlot = Mockito.mock(Slot.class);
        List<Slot> slots = new ArrayList<>();
        slots.add(mockSlot);

        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(List.of(mockSlot)));
        Vehicle car = new Vehicle("KA-01-HH-1234");
        parkingLot.park(car);

        verify(mockSlot, times(1)).park(car);
    }

    @Test
    public void testIfParkingLotCallingSlotMethodToUnpark() {
        Slot spySlot = Mockito.spy(new Slot());
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(List.of(spySlot)));

        Vehicle car = new Vehicle("KA-01-HH-1234");
        Ticket ticket = parkingLot.park(car);
        parkingLot.unPark(ticket);

        verify(spySlot, times(1)).unPark();
    }
}
