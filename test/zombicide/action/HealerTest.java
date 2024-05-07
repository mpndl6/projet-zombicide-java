package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import zombicide.action.actionSurvivor.Heal;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.type.Healer;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class HealerTest {

    @Test
    public void make_SuccessfullyHealed()  {
        Survivor healer = new Healer("Healer1");
        Survivor survivorToHeal = new Survivor("Survivor1");
        Cell cell = new Room();
        healer.setCell(cell);
        survivorToHeal.setCell(cell);
        int initialLifePoints = survivorToHeal.getLifePoints();

        Heal healAction = new Heal(healer);

        boolean actionResult = healAction.make(survivorToHeal);

        assertTrue(actionResult);
        assertEquals(initialLifePoints + 1, survivorToHeal.getLifePoints());
    }

    @Test
    public void make_HealerCannotPerformAction() {
        Survivor healer = new Survivor("Healer1");
        Survivor survivorToHeal = new Survivor("Survivor1");
        Cell cell = new Room();
        healer.setCell(cell);
        survivorToHeal.setCell(cell);

        healer.setCanBeHealed(false);

        Heal healAction = new Heal(healer);

        boolean actionResult = healAction.make(survivorToHeal);

        assertFalse(actionResult);
        assertEquals(5, survivorToHeal.getLifePoints());
    }

    @Test
    public void make_SurvivorCannotPerformLookAround() {
        // Arrange
        Survivor healer = new Survivor("Healer1");
        Survivor survivorToHeal = new Survivor("Survivor1");
        Cell cell = new Room();
        healer.setCell(cell);
        survivorToHeal.setCell(cell);

        // Le survivant ne peut pas effectuer l'action lookaround
        survivorToHeal.setCanLookAround(false);

        // Création de l'action Heal pour le guérisseur
        Heal healAction = new Heal(healer);

        boolean actionResult = healAction.make(survivorToHeal);

        assertFalse(actionResult);
        assertEquals(5, survivorToHeal.getLifePoints());
    }
}