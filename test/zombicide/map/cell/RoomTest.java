package zombicide.map.cell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.item.Item;
import exception.NoSuchItemException;
import zombicide.item.utility.Vial;
import zombicide.item.weapon.Pistol;
import zombicide.map.cell.util.CellType;
import zombicide.map.util.Position;
import zombicide.map.util.Location;

public class RoomTest {

    private Room room;
    private Position position;
    private Item vial;
    private Item pistol;




    @Before
    public void before() {
        position = new Position(2, 2);
        room = new Room();
        vial = new Vial();
        pistol = new Pistol();
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
        assertEquals(0, room.getNbItems());
        room.addItem(pistol);
        room.addItem(pistol);
        assertEquals(room.getNbItems(), 2);
    }

    @Test
    public void testRemoveItem() throws NoSuchItemException {
        room.addItem(pistol);
        room.addItem(vial); //ajout des items
        room.removeItem(vial); // on enlève la fiole
        assertEquals(room.getNbItems(),1); //one left
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
    @Test
    public void testTypeOfCell(){
     assertEquals(room.getTypeOfCell(), CellType.ROOM);
    }

    @Test
    public void testSearchItemOnFloor() {
        room.addItem(pistol);

        Item item = Room.searchForItem(room);
        assertEquals(pistol,item);


    }

    @Test
    public void testSearchItemOnFloorWithAtLeast2item() {
        room.addItem(pistol);
        room.addItem(vial);

        Item item = Room.searchForItem(room);
        assertEquals(pistol,item);


    }
}