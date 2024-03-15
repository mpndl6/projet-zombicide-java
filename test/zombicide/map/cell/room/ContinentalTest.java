package zombicide.map.cell.room;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.util.Position;

public class ContinentalTest {
    private Continental continental;

    @Before
    public void before() {
        continental = new Continental();
    }

    @Test
    public void testCanFight() {
        assertFalse(continental.canFight());
    }
}