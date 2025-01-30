import org.example.Vehicle;
import org.example.VehicleColor;
import org.example.VehicleType;
import org.example.ParkingLot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void testParkingLotCreation() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertFalse(parkingLot.isFull());
    }

    @Test
    public void testParkVehicle_InAvailableSlot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleType.CAR);

        parkingLot.park(car);
        boolean isParked = parkingLot.isParked("KA-01-HH-1234");

        assertTrue(isParked);
    }

    @Test
    public void testParkVehicle_InNearestAvailableSlot() {
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-9999", VehicleType.CAR);

        parkingLot.park(car1);
        parkingLot.park(car2);

        assertEquals(2, parkingLot.getSlotNumber(car2));
    }

    @Test
    public void testIfVehicleWithRegistrationNumberIsParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleType.CAR);

        parkingLot.park(car1);

        assertTrue(parkingLot.isParked("KA-01-HH-1234"));
    }

    @Test
    public void testCountOfCarsWithRedColor(){
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleType.CAR, VehicleColor.RED);
        Vehicle car2 = new Vehicle("KA-01-HH-9999", VehicleType.CAR, VehicleColor.RED);

        parkingLot.park(car1);
        parkingLot.park(car2);

        assertEquals(2, parkingLot.countCarsWithColor(VehicleColor.RED));
    }
}
