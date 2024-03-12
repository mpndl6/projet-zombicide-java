package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainsawTest {

    @Test
    public void testInitialization() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(0, chainsaw.getRangeMin());
        assertEquals(0, chainsaw.getRangeMax());
        assertEquals(3, chainsaw.getHowManyDamage());
        assertEquals(5, chainsaw.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Chainsaw chainsaw = new Chainsaw();
        assertEquals(2, chainsaw.howManyThrows());
    }
}
