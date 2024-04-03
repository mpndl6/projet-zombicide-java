package zombicide.actor.zombie.type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;
import zombicide.actor.zombie.Zombie;

import static org.junit.jupiter.api.Assertions.*;

public class WalkerTest {
    private Zombie walker;

    @BeforeEach
    public void setUp(){
        walker = new Walker();
    }

    @Test
    public void walkerHasOneLifePOint(){
        assertEquals(1, walker.getLifePoints() );
    }

    @Test
    public void walkerInflictsOneDamage(){
        assertEquals(1, walker.howManyDamages());
    }

    @Test
    public void walkerIsTypeOfZombie(){
        assertEquals(ActorType.ZOMBIE, walker.getTypeOfActor());
    }

    @Test
    public void testLifePointDecrease(){
        Zombie zombie = new Walker();
        zombie.beingAttacked(); // a survivor has initially 5 life points at creation
        assertEquals(0, zombie.getLifePoints());
    }

    @Test
    public void walkerIsAliveAtCreation(){
        assertTrue(walker.isAlive());

    }
}