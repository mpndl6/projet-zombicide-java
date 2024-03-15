package zombicide.map.cell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.util.Position;

public class StreetTest {

    private Street streetWithWastewater;
    private Street streetWithoutWastewater;

    @Before
    public void before() {
        Position position = new Position(1, 1);

        streetWithoutWastewater = new Street();
    }

  /*  @Test
    public void testHasWastewater() {
        assertTrue(streetWithWastewater.hasWastewater());
        assertFalse(streetWithoutWastewater.hasWastewater());
    }*/

    @Test
    public void testCanFight() {
        assertTrue(streetWithoutWastewater.canFight());
    }

    @Test
    public void testHowManyActorOnCell() {
        assertEquals(0, streetWithoutWastewater.howManyZombies());
    }
}