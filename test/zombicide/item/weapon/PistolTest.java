package zombicide.item.weapon;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
public class PistolTest {

    @Test
    public void testRangeMinInitialization() {
        Pistol pistol = new Pistol();
        assertEquals(0, pistol.getRangeMin());
    }

    @Test
    public void testRangeMaxInitialization() {
        Pistol pistol = new Pistol();
        assertEquals(1, pistol.getRangeMax());
    }

    @Test
    public void testHowManyDamageInitialization() {
        Pistol pistol = new Pistol();
        assertEquals(1, pistol.getHowMushDamage());
    }

    @Test
    public void testThresholdInitialization() {
        Pistol pistol = new Pistol();
        assertEquals(4, pistol.getThreshold());
    }

    @Test
    public void testHowManyThrows() {
        Pistol pistol = new Pistol();
        assertEquals(1, pistol.howManyThrows());
    }
}
