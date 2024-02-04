package zombicide.map.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(3, 5);
        assertEquals(3, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(3, 5);
        assertEquals(5, position.getY());
    }

    @Test
    public void testEquals() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(3, 5);
        Position position3 = new Position(7, 2);

        assertTrue(position1.equals(position2));
        assertFalse(position1.equals(position3));
    }

    
}