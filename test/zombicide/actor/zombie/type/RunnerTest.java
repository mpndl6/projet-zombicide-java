package zombicide.actor.zombie.type;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    @Test
    public void testConstructor() {
        Runner runner = new Runner();
        assertEquals(1, runner.howManyDamages());
        assertEquals(ActorType.ZOMBIE, runner.getTypeOfActor());
    }
}