package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import zombicide.action.actionSurvivor.LookAround;
import zombicide.actor.survivor.Survivor;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;


public class LookAroundTest {

    @Test
    public void make_SuccessfullyLookedAround()  {
        Survivor survivor = new Survivor("Survivor1");
        Cell cell = new Room();
        survivor.setCell(cell);
        LookAround lookAround = new LookAround(survivor);
        assertTrue(survivor.makeAction(lookAround,cell));
    }

    @Test
    public void testGetCostActionLookAround()  {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");

        LookAround lookAround = new LookAround(survivor);
        assertEquals(0,lookAround.getCost());
    }

    @Test
    public void testGetSurvivorActionLookAround()  {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");

        LookAround lookAround = new LookAround(survivor);
        assertEquals(survivor,lookAround.getActor());
    }
}
