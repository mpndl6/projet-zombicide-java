package zombicide.actor.survivors.type;

import zombicide.actor.survivors.Survivor;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FighterTest {
    @Test
    public void testDiceThrows() {
        Fighter fighter = new Fighter("TestFighter");

        // Test with one die
        assertEquals(1, fighter.diceThrows(0), "Expected result should be incremented by 1");
        int result1Die =    fighter.diceThrows(1);
        assertTrue(result1Die >= 1 && result1Die <= 7);
}}
