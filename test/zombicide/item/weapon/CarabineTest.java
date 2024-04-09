package zombicide.item.weapon;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarabineTest {

        @Test
        public void testRangeMinInitialization() {
            Carabine carabine = new Carabine();
            assertEquals(1, carabine.getRangeMin());
        }

        @Test
        public void testRangeMaxInitialization() {
            Carabine carabine = new Carabine();
            assertEquals(3, carabine.getRangeMax());
        }

        @Test
        public void testHowManyDamageInitialization() {
            Carabine carabine = new Carabine();
            assertEquals(1, carabine.getHowMushDamage());
        }

        @Test
        public void testThresholdInitialization() {
            Carabine carabine = new Carabine();
            assertEquals(4, carabine.getThreshold());
        }

    @Test
    public void testHowManyThrows() {
        Carabine carabine = new Carabine();
        assertEquals(2, carabine.howManyThrows());
    }
}

