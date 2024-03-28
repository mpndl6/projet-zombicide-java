package zombicide.actor.zombie.type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.ActorType;
import zombicide.actor.zombie.Zombie;

import static org.junit.jupiter.api.Assertions.*;

public class PowerfulTest {

    private Zombie powerful;

    @BeforeEach
    public void setUp(){
        powerful = new Powerful();
    }

    @Test
    public void powerfulHasFourLifePOint(){
        assertEquals(4, powerful.getLifePoints() );
    }

    @Test
    public void powerfulInflictsOneDamage(){
        assertEquals(2, powerful.howManyDamages());
    }

    @Test
    public void powerfulIsTypeOfZombie(){
        assertEquals(ActorType.ZOMBIE, powerful.getTypeOfActor());
    }

    @Test
    public void testLifePointDecrease(){
        powerful.decreaseLifePoints(); // a survivor has initially 5 life points at creation
        assertEquals(3, powerful.getLifePoints());
    }

    @Test
    public void powerfulIsAliveAtCreation(){
        assertTrue(powerful.isAlive());

    }
}