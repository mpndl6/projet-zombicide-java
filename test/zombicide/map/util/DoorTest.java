package zombicide.map.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DoorTest {

    private Door door;
    private Location location;

    @Before
    public void before() {
        location = Location.NORTH;
        door = new Door(location);
    }

    @Test
    public void testIsInitiallyClosed() {
        assertFalse(door.isOpen());
    }

    @Test
    public void testOpen() {
        door.open();
        assertTrue(door.isOpen());
    }

    @Test
    public void testGetLocation() {
        assertEquals(location, door.getLocation());
    }

    @Test
    public void testOpenChangesState() {
        assertFalse(door.isOpen());
        door.open();
        assertTrue(door.isOpen());
    }
}