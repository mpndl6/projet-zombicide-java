package zombicide.item.weapon;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
public class PistolTest {

    @Test
    public void testInitialization() {
        Pistol pistol = new Pistol();
        assertEquals(0, pistol.getRangeMin());
        assertEquals(1, pistol.getRangeMax());
        assertEquals(1, pistol.getHowManyDamage());
        assertEquals(4, pistol.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Pistol pistol = new Pistol();
        assertEquals(1, pistol.howManyThrows());
    }
}
