package zombicide.actor.zombie.Type;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;
import zombicide.actor.zombie.type.Runner;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    @Test
    public void testConstructor() {
        Runner runner = new Runner();
        assertEquals(1, runner.howManyDamages());
        assertEquals(ActorType.ZOMBIE, runner.getTypeOfActor());
    }
}