package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Walker;

import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class ActionAttackZombieTest {

    @Test
    public void make_AttacksSurvivorWhenAvailable(){
        Zombie zombie = new Walker();
        ActionAttackZombie action = new ActionAttackZombie(zombie);
        Cell cell = new Room();
        Survivor survivor1 = new Survivor("Survivor1");
        survivor1.setCell(cell);
        zombie.setCell(cell);
        cell.welcomeActor(zombie);
        cell.welcomeActor(survivor1);
        // Act
        try {
            zombie.makeAction(action, cell);
            assertEquals(4,survivor1.getLifePoints());// Appel de makeAction

        } catch (Exception e) {
            fail("Une exception ne devrait pas être levée lorsqu'un survivant est disponible pour être attaqué");
        }}}
