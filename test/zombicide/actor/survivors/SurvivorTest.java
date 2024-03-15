package zombicide.actor.survivors;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.item.weapon.*;
import zombicide.item.*;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Street;


public class SurvivorTest {

    @Test
    public void testInitialization() {
        Survivor survivor = new Survivor("test");

        assertEquals("test", survivor.getNickName());
        assertEquals(0, survivor.getXP());
        assertEquals(3, survivor.getActionPoint());
        assertEquals(5, survivor.getLifePoints());
        assertNotNull(survivor.getWhatINHand());
        assertEquals(0, survivor.getAllInBackpack().size());
    }

    @Test
    public void testIncreaseXP() {
        Survivor survivor = new Survivor("TestSurvivor");
        survivor.increaseXP();
        assertEquals(1, survivor.getXP());
    }

    @Test
    public void testIncreaseActionPoint() {
        Survivor survivor = new Survivor("TestSurvivor");
        survivor.increaseActionPoint();
        assertEquals(4, survivor.getActionPoint());
    }



    @Test
    public void testPutItemInBackpack() {
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street(); // Créez une instance de Cell
        survivor.setCell(cell);
        Item itemInHand = survivor.getWhatINHand();
        survivor.putItemInBackpack(itemInHand);
        assertEquals(1, survivor.getAllInBackpack().size());
        assertTrue(survivor.getAllInBackpack().contains(itemInHand));
    }

    @Test
    public void survivorHasPistolInHandAtCreation(){
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street(); // Créez une instance de Cell
        survivor.setCell(cell);
        Item itemInHand = survivor.getWhatINHand();
        assertTrue(itemInHand instanceof Pistol);
    }

    @Test
    public void testPutInHand() {
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street(); // Créez une instance de Cell
        survivor.setCell(cell);
        Item item = new Axe();
        survivor.putInHand(item);
        assertEquals(item, survivor.getWhatINHand());
    }

    @Test
    public  void testDropItALL() {
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street(); // Créez une instance de Cell
        survivor.setCell(cell);
        Item item1 = new Pistol();
        survivor.putItemInBackpack(item1);
        Item item2 = new Carabine();
        survivor.putItemInBackpack(item2);
        survivor.dropItALL();
        assertEquals(0, survivor.getAllInBackpack().size(), "Backpack should be empty after dropping all items");
    }


}
