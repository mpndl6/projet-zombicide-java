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
        assertEquals(0, survivor.getActionPoint());
        assertEquals(5, survivor.getLifePoints());
        assertNotNull(survivor.getWhatINHand());
        assertEquals(0, survivor.getAllInBackpack().size());
    }




}
