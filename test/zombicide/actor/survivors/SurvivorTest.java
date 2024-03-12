package zombicide.actor.survivors;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.item.weapon.*;
import zombicide.item.*;


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
        Item item = new Pistol();
        survivor.putItemInBackpack(item);
        assertEquals(1, survivor.getAllInBackpack().size());
        assertTrue(survivor.getAllInBackpack().contains(item));
    }


}
