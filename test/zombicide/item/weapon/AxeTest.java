package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest {
    @Test
    public void testRangeMinInitialization() {
        Axe axe = new Axe();
        assertEquals(0, axe.getRangeMin());
    }

    @Test
    public void testRangeMaxInitialization() {
        Axe axe = new Axe();
        assertEquals(0, axe.getRangeMax());
    }

    @Test
    public void testHowManyDamageInitialization() {
        Axe axe = new Axe();
        assertEquals(2, axe.getHowMushDamage());
    }

    @Test
    public void testThresholdInitialization() {
        Axe axe = new Axe();
        assertEquals(4, axe.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Axe axe = new Axe();
        assertEquals(1, axe.howManyThrows());
    }
}
