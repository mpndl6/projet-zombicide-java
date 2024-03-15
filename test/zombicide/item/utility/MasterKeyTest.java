package zombicide.item.utility;

import org.junit.Test;
import zombicide.actor.survivors.Survivor;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MasterKeyTest {
    @Test
    public void testUse() {
        try {
            List<Cell> liststreets = new ArrayList<>();
            liststreets.add(new StreetWW());
            List<Cell> listrooms = new ArrayList<>();
            listrooms.add(new Continental());
            Map map = new Map(5,5,listrooms,liststreets);

            Position p =new Position(0,0);
            Cell cell = map.getCell(p);

            MasterKey key = new MasterKey(map);
            Survivor s = new Survivor("toto");
            s.setCell(cell);

            key.addSurvivor(s);
            key.use(Location.SOUTH);
            Room room = (Room) cell;
            assertTrue(room.isOpen(Location.SOUTH));
        }
        catch(Exception e) {

        }
    }
}
