package zombicide.actor.survivors.type;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LuckyTest {

    @Test
    public void testDiceThrows() {
        Lucky luckySurvivor = new Lucky("TestLuckySurvivor");


        // Test avec 1 dé
        int result1Die = luckySurvivor.diceThrows(1);
        assertTrue(result1Die >= 1 && result1Die <= 12); // Un dé normal (1-6) + un dé supplémentaire (1-6)

        // Test avec 3 dés
        int result3Dice = luckySurvivor.diceThrows(3);
        assertTrue(result3Dice >= 3 && result3Dice <= 36); // Trois dés normaux (3-18) + trois dés supplémentaires (3-18)
    }
}
