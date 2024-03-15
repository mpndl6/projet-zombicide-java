package zombicide.item.utility;

import org.junit.Test;
import static org.junit.Assert.*;
import zombicide.actor.survivors.Survivor;
import zombicide.item.utility.Vial;

public class VialTest {

    @Test
    public void testUseVial() {

        Survivor survivor = new Survivor();
        Vial vial = new Vial(survivor);
        vial.use();
        assertEquals(1, survivor.getLifePoints());
    }
