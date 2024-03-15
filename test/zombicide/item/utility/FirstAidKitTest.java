package zombicide.item.utility;

import org.junit.Test;
import zombicide.actor.survivors.Survivor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstAidKitTest {
    @Test
    public void testUse() {
        FirstAidKit f = new FirstAidKit();
        Survivor s = new Survivor("toto");
        Survivor s2 = new Survivor("titi");
        f.addSurvivor(s);
        f.use(s2);
        assertEquals(6,s2.getLifePoints());
    }
}
