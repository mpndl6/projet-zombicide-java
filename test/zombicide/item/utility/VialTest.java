package zombicide.item.utility;


import org.junit.Test;
import zombicide.actor.survivor.Survivor;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class VialTest {


    @Test
    public void testUse() {
        Vial vail = new Vial();
        Survivor s = new Survivor("toto");
        vail.addSurvivor(s);
        vail.use();
        assertEquals(6,s.getLifePoints());
    }
}
