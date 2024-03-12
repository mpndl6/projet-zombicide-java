package zombicide.item.weapon;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrowbarTest {
    @Test
    public void testInitialization() {
        Crowbar crowbar = new Crowbar();
        assertEquals(0, crowbar.getRangeMin(), "Minimum range should be 0 for Pistol");
        assertEquals(0, crowbar.getRangeMax(), "Maximum range should be 1 for Pistol");
        assertEquals(1, crowbar.getHowManyDamage(), "Damage should be 1 for Pistol");
        assertEquals(4, crowbar.getThreshold(), "Threshold should be 4 for Pistol");
    }


}

