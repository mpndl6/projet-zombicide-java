package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarabineTest {

    @Test
    public void testInitialization() {
        Carabine carabine = new Carabine();
        assertEquals(1, carabine.getRangeMin());
        assertEquals(3, carabine.getRangeMax());
        assertEquals(1, carabine.getHowManyDamage());
        assertEquals(4, carabine.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Carabine carabine = new Carabine();
        assertEquals(2, carabine.howManyThrows());
    }
}

