package zombicide.map.cell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.cell.util.CellType;
import zombicide.map.util.Position;
import zombicide.item.Item;

public class StreetTest {

    private Street streetWithWastewater;
    private Street streetWithoutWastewater;
    private Position position;
    private Item vial;
    private Item pistol;


    @Before
    public void before() {
        position = new Position(1, 1);
        streetWithoutWastewater = new Street();
    }


    @Test
    public void testCanFight() {
        assertTrue(streetWithoutWastewater.canFight());
    }

    @Test
    public void testHowManyActorOnCell() {
        assertEquals(0, streetWithoutWastewater.howManyZombies());
    }

    @Test
    public void testGetTypeOfCell(){
        assertEquals(streetWithoutWastewater.getTypeOfCell(), CellType.STREET);
    }

    @Test
    public void testAddItem(){
        streetWithoutWastewater.addItem(pistol);
        streetWithoutWastewater.addItem(vial);
        assertEquals(streetWithoutWastewater.getNbItems(),0); //bc item can be added on street
    }

    @Test
    public void testRemoveItem(){

    }
}