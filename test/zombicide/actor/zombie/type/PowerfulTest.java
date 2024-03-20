package zombicide.actor.zombie.type;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;

import static org.junit.jupiter.api.Assertions.*;

public class PowerfulTest {

    @Test
    public void testConstructor() {
        Powerful powerful = new Powerful();
        assertEquals(2, powerful.howManyDamages());
        assertEquals(ActorType.ZOMBIE, powerful.getTypeOfActor());
    }
}