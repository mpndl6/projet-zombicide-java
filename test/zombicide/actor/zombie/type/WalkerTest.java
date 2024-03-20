package zombicide.actor.zombie.type;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;

import static org.junit.jupiter.api.Assertions.*;

public class WalkerTest {

    @Test
    public void testConstructor() {
        Walker walker = new Walker();
        assertEquals(1, walker.howManyDamages());
        assertEquals(ActorType.ZOMBIE, walker.getTypeOfActor());
    }
}