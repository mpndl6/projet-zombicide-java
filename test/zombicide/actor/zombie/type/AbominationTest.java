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
    public void abominationHasFourLifePOint(){
        assertEquals(4, abomination.getLifePoints() );
    }

    @Test
    public void abominationInflictsOneDamage(){
        assertEquals(2, abomination.howManyDamages());
    }

    @Test
    public void abominationIsTypeOfZombie(){
        assertEquals(ActorType.ZOMBIE, abomination.getTypeOfActor());
    }

    @Test
    public void testLifePointDecrease(){
        abomination.beingAttacked(); // a survivor has initially 5 life points at creation
        assertEquals(5, abomination.getLifePoints());
    }

    @Test
    public void abominationIsAliveAtCreation(){
        assertTrue(abomination.isAlive());

    }
}