package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;

import exception.FullBackpackException;
import org.junit.Test;
import zombicide.action.actionSurvivor.TakeInHand;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.utility.FirstAidKit;
import zombicide.item.utility.Vial;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class TakeInHandTest {

    @Test
    public void make_PutsItemInHandWhenBackpackNotFull() throws FullBackpackException  {

        Survivor survivor = new Survivor("Survivor1");
        TakeInHand takeInHand = new TakeInHand(survivor);
        Cell cell = new Room();
        survivor.setCell(cell);
        Item item = new FirstAidKit();
        survivor.putItemInBackpack(item);

        try {
            survivor.makeAction(takeInHand,item);
            //takeInHand.make(item);
            assertEquals(item,survivor.getWhatINHand());
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }


    }
    @Test
    public void make_TakesItemInHandWhenBackpackIsFull() throws FullBackpackException {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");
        TakeInHand takeInHand = new TakeInHand(survivor);
        Cell cell = new Room();
        survivor.setCell(cell);
        Item newItem = new Vial();
        survivor.putItemInBackpack(newItem);
        Item newItem2 = new Vial();
        survivor.putItemInBackpack(newItem2);
        Item newItem3 = new Vial();
        survivor.putItemInBackpack(newItem3);
        Item newItem4 = new Vial();
        survivor.putItemInBackpack(newItem4);
        Item newItem5 = new Vial();
        survivor.putItemInBackpack(newItem5);

        // Act
        try {
            survivor.makeAction(takeInHand,newItem);
            assertEquals(newItem,survivor.getWhatINHand());
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetCostActionMakeTakeInHand() throws Exception {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");

        TakeInHand takeInHand = new TakeInHand(survivor);
        assertEquals(1,takeInHand.getCost());
    }

    @Test
    public void testGetSurvivorActionMakeTakeInHand() throws Exception {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");

        TakeInHand takeInHand = new TakeInHand(survivor);
        assertEquals(survivor,takeInHand.getSurvivor());
    }
}
