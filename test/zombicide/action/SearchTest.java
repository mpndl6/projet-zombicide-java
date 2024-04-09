package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;

import exception.FullBackpackException;
import org.junit.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.utility.FirstAidKit;
import zombicide.item.utility.IRGoogles;
import zombicide.item.utility.Vial;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class SearchTest {

    @Test
    public void make_SearchesForItemWhenRoomAvailableAndBackpackHasSpace() {
        Survivor survivor = new Survivor("Survivor1");
        Cell cell = new Room();
        survivor.setCell(cell);
        Item item = new FirstAidKit();
        cell.addItem(item);
        Search search = new Search(survivor);

        try {
            survivor.makeAction(search,cell);
            assertTrue(survivor.getAllInBackpack().contains(item));

        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }


    @Test
    public void make_SearchSucceedsAfterDiscardingItem() throws FullBackpackException {
        Survivor survivor = new Survivor("Survivor1");
        Cell cell = new Room();
        survivor.setCell(cell);
        for (int i = 0; i < Survivor.MAX_NB_ITEM; i++) {
            survivor.putItemInBackpack(new Vial());
        }
        Item item = new FirstAidKit();
        cell.addItem(item);
        Search search = new Search(survivor);
        try {
            survivor.makeAction(search,cell);
            assertTrue(survivor.getAllInBackpack().contains(item));

        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

    @Test
    public void make_SearchFailsWhenRoomIsEmpty() {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");
        Cell cell = new Room();
        survivor.setCell(cell);
        Search search = new Search(survivor);

        try {
            assertFalse(survivor.makeAction(search, cell));
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetCostActionMakeSearch() throws Exception {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");

        Search search = new Search(survivor);
        assertEquals(1,search.getCost());
    }
}
