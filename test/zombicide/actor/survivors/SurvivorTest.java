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
    public void testNicknameInitialization() {
        Survivor survivor = new Survivor("test");
        assertEquals("test", survivor.getNickName(), "Nickname should be 'test'");
    }

    @Test
    public void testXPInitialization() {
        Survivor survivor = new Survivor("test");
        assertEquals(0, survivor.getXP(), "XP should be 0");
    }

    @Test
    public void testActionPointInitialization() {
        Survivor survivor = new Survivor("test");
        assertEquals(3, survivor.getActionPoint(), "Action points should be 3");
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
        Item item = new Pistol();
        survivor.putItemInBackpack(item);
        assertEquals(1, survivor.getAllInBackpack().size());
        assertTrue(survivor.getAllInBackpack().contains(item));
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
