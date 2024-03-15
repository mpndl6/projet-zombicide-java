package zombicide.item.utility;
import org.junit.Test;
import static org.junit.Assert.*;

import zombicide.actor.survivors.Survivor;
import zombicide.item.utility.FirstAidKit;

public class FirstAidKitTest {

    @Test
    public void testUseFirstAidKit() {
        // Arrange
        Survivor survivor = new Survivor();
        FirstAidKit firstAidKit = new FirstAidKit();

        // Act
        firstAidKit.use(survivor);

        // Assert
        assertEquals(1, survivor.getLifePoints());
    }

