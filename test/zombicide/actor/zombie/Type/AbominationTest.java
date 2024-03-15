package zombicide.actor.zombie.Type;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;
import zombicide.actor.zombie.type.Abomination;

import static org.junit.jupiter.api.Assertions.*;

public class AbominationTest {

    @Test
    public void testConstructor() {
        Abomination abomination = new Abomination();
        assertEquals(3, abomination.howManyDamages());
        assertEquals(ActorType.ZOMBIE, abomination.getTypeOfActor());
    }
}