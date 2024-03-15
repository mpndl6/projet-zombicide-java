package zombicide.actor.survivor.type;

import zombicide.actor.survivor.Survivor;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealerTest {

    @Test
    public void testHeal() {
        String name = "TestHealer";
        Healer healer = new Healer(name);
        Survivor targetSurvivor = new Survivor("TargetSurvivor");

        int initialLifePoints = healer.getLifePoints();
        int lifeOfTarget = targetSurvivor.getLifePoints();

        healer.heal(targetSurvivor);


        assertEquals(initialLifePoints+1, healer.getLifePoints());

        // On verifie que ça augmente
        assertEquals(lifeOfTarget+1, targetSurvivor.getLifePoints());
    }
}
