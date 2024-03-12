package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainsawTest {

    @Test
    public void testInitialization() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(0, chainsaw.getRangeMin(), "Minimum range should be 0 for Pistol");
        assertEquals(0, chainsaw.getRangeMax(), "Maximum range should be 1 for Pistol");
        assertEquals(3, chainsaw.getHowManyDamage(), "Damage should be 1 for Pistol");
        assertEquals(5, chainsaw.getThreshold(), "Threshold should be 4 for Pistol");
    }

    @Test
    public void testHowManyThrows() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(2, chainsaw.howManyThrows(), "Number of dice rolls should be 1 for Pistol");
    }
}
