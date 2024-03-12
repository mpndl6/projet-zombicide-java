package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarabineTest {

    @Test
    public void testInitialization() {
        Carabine carabine = new Carabine();
        assertEquals(1, carabine.getRangeMin(), "Minimum range should be 0 for Pistol");
        assertEquals(3, carabine.getRangeMax(), "Maximum range should be 1 for Pistol");
        assertEquals(1, carabine.getHowManyDamage(), "Damage should be 1 for Pistol");
        assertEquals(4, carabine.getThreshold(), "Threshold should be 4 for Pistol");
    }

    @Test
    public void testHowManyThrows() {
        Carabine carabine = new Carabine();
        assertEquals(2, carabine.howManyThrows(), "Number of dice rolls should be 1 for Pistol");
    }
}

