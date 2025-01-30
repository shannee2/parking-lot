import org.example.Vehicle;
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

}
