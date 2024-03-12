package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest {
    @Test
    public void testInitialization() {
        Axe axe = new Axe();
        assertEquals(0, axe.getRangeMin());
        assertEquals(0, axe.getRangeMax());
        assertEquals(2, axe.getHowManyDamage());
        assertEquals(4, axe.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Axe axe = new Axe();
        assertEquals(1, axe.howManyThrows());
    }
}
