package zombicide.map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

public class MapTest {

    private Map map;
    private List<Cell> listrooms = new ArrayList<Cell>();
    private List<Cell> liststreets = new ArrayList<Cell>();
    private Survivor survivor = new Survivor("ju");

    @Before
    public void before() {
        liststreets.add(new StreetWW());
        listrooms.add(new Continental());
        map = new Map(5,5,listrooms,liststreets);
    }

    @Test
    public void testGetWidth() {
        assertEquals(5, map.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(5, map.getHeight());
    }

    @Test
    public void testCellThere(){
        //Une map de 5/5 devrait ressemblait à celle juste en dessous donc
        Cell cellBellowARoom = map.getCell(new Position(2,3));
        assertEquals(map.roomThere(cellBellowARoom, Location.WEST), cellBellowARoom.getTypeOfCell()); // c'est une room au dessus normalement
    }

    @Test
    public void testGetCells(){
        listrooms = new ArrayList<>();
        liststreets = new ArrayList<>();
        map = new Map(5,5,listrooms,liststreets);
        // with a map without any special room nor special street, and of width 5 and height 5 it should be like this:
        /*
            ――――――――――――――――――――――――――――――――――――――――――――――――――
            █R        ❘R        ❘ W       ❘R        ❘R        █
            █         ❘         ❘         ❘         ❘         █
            ――――――――――――――――――――          ――――――――――――――――――――
            █R        ❘R        ❘         ❘R        ❘R        █
            █         ❘         ❘         ❘         ❘         █
            ――――――――――――――――――――          ――――――――――――――――――――
            █ W                                       W       █
            █                                                 █
            ――――――――――――――――――――          ――――――――――――――――――――
            █R        ❘R        ❘         ❘R        ❘R        █
            █         ❘         ❘         ❘         ❘         █
            ――――――――――――――――――――          ――――――――――――――――――――
            █R        ❘R        ❘ W       ❘R        ❘R        █
            █         ❘         ❘         ❘         ❘         █
            ――――――――――――――――――――――――――――――――――――――――――――――――――
         */
        Cell[][] cellOfMap = map.getCells();
        assertTrue(cellOfMap[0][0] instanceof Room);
        assertTrue(cellOfMap[2][4] instanceof StreetWW);
        assertTrue(cellOfMap[4][4] instanceof Room);
    }
    @Test
    public void testGetCell(){
        map.putActorONCell(survivor, new Position(1,3));
        assertSame(survivor.getCell(), map.getCell(new Position(1,3)));
    }

    @Test
    public void testPutActorOnCell(){
        map.putActorONCell(survivor, new Position(2,3));
        assertSame(survivor.getCell(),map.getCell(new Position(2,3))); // survivor has been put on cell ppos (2,3)
        map.putActorONCell(survivor, new Position(4,3));
        assertSame(survivor.getCell(),map.getCell(new Position(4,3))); // survivor has been put on cell ppos (4,3)
    }

    @Test
    public void testWhenActorIsPutOnCellTheyAreNotInTheirPreviousCell(){
        map.putActorONCell(survivor, new Position(2,3));
        assertSame(survivor.getCell(),map.getCell(new Position(2,3))); // survivor has been put on cell ppos (2,3)
        map.putActorONCell(survivor, new Position(4,3));
        assertNotSame(survivor.getCell(),map.getCell(new Position(2,3))); // survivor has been put on cell ppos (4,3) and they are not on cell 2,3 anymore.
    }

    @Test
    public void testGetPrincipalInterSection(){
        //pour une map 5,5 les coordonées de la rue principale  devrait être 2,2
        assertEquals(map.getCrossRoad(), new Position(2,2));
    }


}