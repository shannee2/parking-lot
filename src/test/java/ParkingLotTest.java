import org.example.*;
import org.example.exceptions.InvalidSlotsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testParkVehicle_InNearestAvailableSlot() {
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle car1 = new Vehicle("KA-01-HH-1234");
        Vehicle car2 = new Vehicle("KA-01-HH-9999");

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        assertTrue(parkingLot.isVehicleParked("KA-01-HH-1234"));
        assertTrue(parkingLot.isVehicleParked("KA-01-HH-9999"));
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
}
