package zombicide.actor.zombie.type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;
import zombicide.actor.zombie.Zombie;

import static org.junit.jupiter.api.Assertions.*;

public class AbominationTest {
    private Zombie abomination;

    @BeforeEach
    public void setUp(){
        abomination = new Abomination();
    }
    @Test
    public void abominationHasSixLifePOint(){
        assertEquals(abomination.getLifePoints(), 6 );
    }

    @Test
    public void abominationInflictsTreeDamage(){
        assertEquals(abomination.howManyDamages(), 3);
    }

    @Test
    public void abominationIsTypeOfZombie(){
        assertEquals(ActorType.ZOMBIE, abomination.getTypeOfActor());
    }

    @Test
    public void testLifePointDecrease(){
        abomination.beingAttacked(); // a survivor has initially 5 life points at creation
        assertEquals(abomination.getLifePoints(), 5);
    }
    @Test
    public void abominationIsAliveAtCreation(){
        assertTrue(abomination.isAlive());

    }
}