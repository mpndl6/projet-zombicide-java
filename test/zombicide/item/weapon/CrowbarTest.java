package zombicide.item.weapon;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrowbarTest {
    @Test
    public void testInitialization() {
        Crowbar crowbar = new Crowbar();
        assertEquals(0, crowbar.getRangeMin());
        assertEquals(0, crowbar.getRangeMax());
        assertEquals(1, crowbar.getHowManyDamage());
        assertEquals(4, crowbar.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Crowbar crowbar = new Crowbar();
        assertEquals(1, crowbar.howManyThrows());
    }
}

