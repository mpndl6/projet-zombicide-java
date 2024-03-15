package zombicide.item.weapon;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrowbarTest {
    @Test
    public void testRangeMinInitialization() {
        Crowbar crowbar = new Crowbar();
        assertEquals(0, crowbar.getRangeMin());
    }

    @Test
    public void testRangeMaxInitialization() {
        Crowbar crowbar = new Crowbar();
        assertEquals(0, crowbar.getRangeMax());
    }

    @Test
    public void testHowManyDamageInitialization() {
        Crowbar crowbar = new Crowbar();
        assertEquals(1, crowbar.getHowManyDamage());
    }

    @Test
    public void testThresholdInitialization() {
        Crowbar crowbar = new Crowbar();
        assertEquals(4, crowbar.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Crowbar crowbar = new Crowbar();
        assertEquals(1, crowbar.howManyThrows());
    }
}

