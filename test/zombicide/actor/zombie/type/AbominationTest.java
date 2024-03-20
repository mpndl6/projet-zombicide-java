package zombicide.actor.zombie.type;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;

import static org.junit.jupiter.api.Assertions.*;

public class AbominationTest {

    @Test
    public void testConstructor() {
        Abomination abomination = new Abomination();
        assertEquals(3, abomination.howManyDamages());
        assertEquals(ActorType.ZOMBIE, abomination.getTypeOfActor());
    }
}