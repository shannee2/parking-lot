import org.example.Slot;
import org.example.Vehicle;
import org.example.VehicleType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlotTest {

    @Test
    public void testEmptySlotCreation() {
        Slot slot = new Slot(1);

        boolean isOccupied = slot.isOccupied();

        assertFalse(slot.isOccupied());
    }

    @Test
    public void testTestSlotOccupied() {
        Slot slot = new Slot(1);

        slot.park(new Vehicle( "KA-01-HH-1234", VehicleType.CAR));

        assertTrue(slot.isOccupied());
    }
}
