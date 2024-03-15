package zombicide.map.cell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.item.Item;
import zombicide.map.util.Position;
//import zombicide.item.Door; <-- import obselete
import zombicide.map.util.Location;

public class RoomTest {

    private Room room;
   // private Door door;
    private Position position;

    @Before
    public void before() {
        position = new Position(2, 2);
        room = new Room();
       // door = new Door(Location.NORTH);
    }

  /** 
   * @Test
    public void testLocationOfDoors() {
        assertEquals(4, room.locationOfDoors().size());
    }
   * */  

   /* @Test
    public void testCanLeaveByDoor() {
        assertFalse(room.canLeaveByDoor(Location.NORTH));
        room.openDoor(Location.NORTH);
        assertTrue(room.canLeaveByDoor(Location.NORTH));
    }*/

 @Test
    public void testGetNbitems() {
        assertEquals(0, room.getNbitems());
        room.addItem(new Item());
        assertEquals(1, room.getNbitems());
        room.removeItem(new Item());
        assertEquals(0, room.getNbitems());
    }

   

    @Test
    public void testOpenDoor() {
        assertFalse(room.isOpen(Location.NORTH));
        room.openDoor(Location.NORTH);
        assertTrue(room.isOpen(Location.NORTH));
    }

    @Test
    public void testCanFight() {
        assertTrue(room.canFight());
    }

    @Test
    public void isOpen(){
        assertFalse(room.isOpen(Location.NORTH));
        room.openDoor(Location.NORTH);
        assertTrue(room.isOpen(Location.NORTH));
    }

}