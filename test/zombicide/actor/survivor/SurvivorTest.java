package zombicide.actor.survivor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.item.utility.*;
import zombicide.item.weapon.*;
import zombicide.item.*;
import zombicide.map.Map;
import zombicide.map.cell.Street;

import java.util.ArrayList;
import java.util.*;


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
    public void testLifePointsInitialization() {
        Survivor survivor = new Survivor("test");
        assertEquals(5, survivor.getLifePoints(), "Life points should be 5");
    }

    @Test
    public void testInHandItemInitialization() {
        Survivor survivor = new Survivor("test");
        assertNotNull(survivor.getWhatINHand(), "In hand item should not be null");
    }

    @Test
    public void testBackpackInitialization() {
        Survivor survivor = new Survivor("test");
        assertEquals(0, survivor.getAllInBackpack().size(), "Backpack should be empty");
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
    public void testPutItemInBackpack() throws FullBackpackException{
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street();
        survivor.setCell(cell);
        Item itemInHand = survivor.getWhatINHand();
        survivor.putItemInBackpack(itemInHand);
        assertEquals(1, survivor.getAllInBackpack().size());
        assertTrue(survivor.getAllInBackpack().contains(itemInHand));
    }

    @Test
    public void survivorHasPistolInHandAtCreation(){
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street();
        survivor.setCell(cell);
        Item itemInHand = survivor.getWhatINHand();
        assertTrue(itemInHand instanceof Pistol);
    }

    @Test
    public void testPutInHand() throws FullBackpackException{
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street();
        survivor.setCell(cell);
        Item item = new Axe();
        survivor.putInHand(item);
        assertEquals(item, survivor.getWhatINHand());
    }

    @Test
    public void testPutInHandButAlreadyItemInHandAndBackPackFull() throws FullBackpackException{
        Survivor survivor = new Survivor("TestSurvivor"); // Survivor has a pistol in hand at creation
        Street cell = new Street();
        survivor.setCell(cell);

        List<Item> itemOfSurvivor = new ArrayList<>();

        Item Axe = new Axe();
        Item Pistol = new Pistol();
        Item Vial = new Vial();
        Item Carabine = new Carabine();
        Item FAK = new FirstAidKit();

        survivor.putItemInBackpack(Axe);
        survivor.putItemInBackpack(Pistol);
        survivor.putItemInBackpack(Vial);
        survivor.putItemInBackpack(Carabine);
        survivor.putItemInBackpack(FAK); // backpack full

        assertThrows( FullBackpackException.class, () -> {survivor.putInHand(new Vial());}); // It will put the item in hand of the survivor and tries to put it in backapck
    }

    @Test
    public  void testDropItALL() throws FullBackpackException{
        Survivor survivor = new Survivor("TestSurvivor");
        Street cell = new Street();
        survivor.setCell(cell);
        Item item1 = new Pistol();
        survivor.putItemInBackpack(item1);
        Item item2 = new Carabine();
        survivor.putItemInBackpack(item2);
        survivor.dropItALL();
        assertEquals(0, survivor.getAllInBackpack().size(), "Backpack should be empty after dropping all items");
    }


}
