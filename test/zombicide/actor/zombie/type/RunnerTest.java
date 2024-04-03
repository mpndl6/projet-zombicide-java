package zombicide.actor.zombie.type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;
import zombicide.actor.zombie.Zombie;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    private Zombie runner;

    @BeforeEach
    public void setUp(){
        runner = new Runner();
    }

    @Test
    public void runnerHasTwoLifePOint(){
        assertEquals(2, runner.getLifePoints() );
    }

    @Test
    public void runnerInflictsOneDamage(){
        assertEquals(1, runner.howManyDamages());
    }

    @Test
    public void runnerIsTypeOfZombie(){
        assertEquals(ActorType.ZOMBIE, runner.getTypeOfActor());
    }

    @Test
    public void testLifePointDecrease(){
        runner.beingAttacked(); // a survivor has initially 5 life points at creation
        assertEquals(1, runner.getLifePoints());
    }

    @Test
    public void runnerIsAliveAtCreation(){
        assertTrue(runner.isAlive());

    }
}