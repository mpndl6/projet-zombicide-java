package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainsawTest {

    @Test
    public void testRangeMinInitialization() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(0, chainsaw.getRangeMin());
    }

    @Test
    public void testRangeMaxInitialization() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(0, chainsaw.getRangeMax());
    }

    @Test
    public void testHowManyDamageInitialization() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(3, chainsaw.getHowMushDamage());
    }

    @Test
    public void testThresholdInitialization() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(5, chainsaw.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(2, chainsaw.howManyThrows());
    }
}
