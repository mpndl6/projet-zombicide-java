package zombicide.action;

import zombicide.actor.survivor.Survivor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

public class MoveAsideTest {
    @Test
    public void make_MoveSurvivorNorth_Successful() throws Exception {

        Survivor survivor = new Survivor("Survivor1");
        Cell cell = new Room();
        cell.setPosition(new Position(1,1));
        survivor.setCell(cell);
        MoveAside moveAside = new MoveAside(survivor);


        boolean result = moveAside.make(Location.NORTH);


        assertTrue(result);
        assertEquals(new Position(0, 1), cell.getPosition());
    }
}
