import org.example.Slot;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlotTest {

    @Test
    public void testEmptySlotCreation() {
        Slot slot = new Slot(1);

        assertFalse(slot.isOccupied());
    }

    @Test
    public void testReturnTrue_WhenSlotOccupied() {
        Slot slot = new Slot(1);

        slot.park(new Vehicle( "KA-01-HH-1234"));

        assertTrue(slot.isOccupied());
    }

    @Test
    public void testThrowException_WhenUnparkEmptySlot() {
        Slot slot = new Slot(1);

        assertThrows(IllegalStateException.class, () -> slot.unPark());
    }

    @Test
    public void testSlotUnpark() {
        Slot slot = new Slot(1);

        slot.park(new Vehicle( "KA-01-HH-1234"));
        slot.unPark();

        assertFalse(slot.isOccupied());
    }
}
