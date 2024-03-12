package zombicide.item.weapon;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
public class PistolTest {

    @Test
    public void testInitialization() {
        Pistol pistol = new Pistol();
        assertEquals(0, pistol.getRangeMin(), "Minimum range should be 0 for Pistol");
        assertEquals(1, pistol.getRangeMax(), "Maximum range should be 1 for Pistol");
        assertEquals(1, pistol.getHowManyDamage(), "Damage should be 1 for Pistol");
        assertEquals(4, pistol.getThreshold(), "Threshold should be 4 for Pistol");
    }


}
