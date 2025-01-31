import org.example.Slot;
import org.example.Vehicle;
import org.example.exceptions.SlotAlreadyOccupiedException;
import org.example.exceptions.SlotUnoccupiedException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlotTest {

    @Test
    public void testEmptySlotCreation() {
        Slot slot = new Slot();

        assertFalse(slot.isOccupied());
    }

    @Test
    public void testThrowSlotAlreadyOccupiedException_WhenOccupied(){
        Slot slot = new Slot();
        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234");
        Vehicle vehicle2 = new Vehicle("KA-01-HH-9999");
        slot.park(vehicle1);
        assertThrows(SlotAlreadyOccupiedException.class,()-> slot.park(vehicle2));
    }

    @Test
    public void testReturnTrue_WhenSlotOccupied() {
        Slot slot = new Slot();

        slot.park(new Vehicle( "KA-01-HH-1234"));

        assertTrue(slot.isOccupied());
    }

    @Test
    public void testThrowException_WhenUnparkEmptySlot() {
        Slot slot = new Slot();

        assertThrows(SlotUnoccupiedException.class, () -> slot.unPark());
    }

    @Test
    public void testSlotUnpark() {
        Slot slot = new Slot();

        slot.park(new Vehicle( "KA-01-HH-1234"));
        slot.unPark();

        assertFalse(slot.isOccupied());
    }
}
