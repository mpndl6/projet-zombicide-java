package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest {
    @Test
    public void testInitialization() {
        Axe axe = new Axe();
        assertEquals(0, axe.getRangeMin(), "Minimum range should be 0 for Pistol");
        assertEquals(0, axe.getRangeMax(), "Maximum range should be 1 for Pistol");
        assertEquals(2, axe.getHowManyDamage(), "Damage should be 1 for Pistol");
        assertEquals(4, axe.getThreshold(), "Threshold should be 4 for Pistol");
    }

    @Test
    public void testHowManyThrows() {
        Axe axe = new Axe();
        assertEquals(1, axe.howManyThrows(), "Number of dice rolls should be 1 for Pistol");
    }
}
