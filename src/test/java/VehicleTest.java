import org.example.Vehicle;
import org.example.VehicleColor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    public void testVehicleCreationWithRegistrationNumber() {
        String registrationNumber = "KA-01-HH-1234";
        Vehicle vehicle = new Vehicle(registrationNumber);
        assertTrue(vehicle.hasRegistrationNumber(registrationNumber));
    }

    @Test
    public void testVehicleCreationWithRegistrationNumberAndColor() {
        String registrationNumber = "KA-01-HH-1234";
        Vehicle vehicle = new Vehicle(registrationNumber, VehicleColor.RED);
        assertTrue(vehicle.hasRegistrationNumber(registrationNumber));
        assertTrue(vehicle.hasColor(VehicleColor.RED));
    }

    @Test
    public void testVehicleHasRegistrationNumber() {
        String registrationNumber = "KA-01-HH-1234";
        Vehicle vehicle = new Vehicle(registrationNumber);
        assertTrue(vehicle.hasRegistrationNumber(registrationNumber));
        assertFalse(vehicle.hasRegistrationNumber("KA-01-HH-9999"));
    }

    @Test
    public void testVehicleHasColor() {
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE);
        assertTrue(vehicle.hasColor(VehicleColor.BLUE));
        assertFalse(vehicle.hasColor(VehicleColor.RED));
    }
}