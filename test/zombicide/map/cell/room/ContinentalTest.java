package zombicide.map.cell.room;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.util.Position;

public class ContinentalTest {

    private Continental continental;

    @Before
    public void before() {
        Position position = new Position(2, 2);
        int width = 4;
        int height = 4;
        continental = new Continental(position, width, height);
    }

    @Test
    public void testCanFight() {
        assertFalse(continental.canFight());
    }
}