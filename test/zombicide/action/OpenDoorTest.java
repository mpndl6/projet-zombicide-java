package zombicide.action;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.item.CanOpenDoor;
import zombicide.item.Item;
import zombicide.item.utility.MasterKey;
import zombicide.item.utility.Vial;
import zombicide.item.weapon.Pistol;
import zombicide.map.Map;
import java.util.*;
import zombicide.map.*;
import zombicide.map.cell.*;
import zombicide.map.util.Location;
import zombicide.map.util.Position;
import zombicide.Game;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class OpenDoorTest {

    Survivor s;
    OpenDoor op;
    Map map;
    Game game;

    @BeforeEach
    public void setUp(){
        s= new Survivor("Jul");
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        map = new TrainingMap2(listRooms,listSreet);
        op = new OpenDoor(s, map);
        game = new Game(map);
        s.setGame(game);
        s.getWhatINHand().addSurvivor(s);
    }

    @Test
    public void testSetMap() {
        op.setMap(map);
        assertEquals(map, op.getMap());
        //On set une nouvelle map
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        Map map2 = new TrainingMap2(listRooms,listSreet);
        op.setMap(map2);
       assertSame(op.getMap(), map2);
    }

    @Test
    public void testGetMap() {
        //openDoor has a map at creation
        op.setMap(map);
        assertSame(map, op.getMap());
    }
    @Test
    public void testMakePositive() {
        System.out.println("Positive :\n");

        op.setMap(s.getGame().getMap());
        s.setCell(map.getCell(new Position(2,2)));
       s.makeAction(new TakeInHand(s), new MasterKey(map)); //take in hand an object that open a door
        assertTrue(op.make(Location.SOUTH));
        System.out.println("\n\n");
    }
    @Test
   public void testMakeNegative(){
        System.out.println("Negative :\n");
        op.setMap(s.getGame().getMap());
        s.setCell(map.getCell(new Position(2,2)));
        s.makeAction(new TakeInHand(s), new Vial());// cant open door
        assertFalse(op.make(Location.NORTH));
        System.out.println("\n\n");
    }

   @Test
    public void testMakeWhenIsWall(){
        op.setMap(map);
        s.setCell(map.getCell(new Position(4,1)));
       ((CanOpenDoor)s.getWhatINHand()).setMap(map);
       assertFalse(op.make(Location.SOUTH));
    }

    @Test
    public void testGetCost() {
        assertEquals(op.getCost(),0);
    }

    @Test
    public void testCanMakeActionPositif() {
        //survivor has a pistol at creation and its a object that open a door
        assertTrue(op.canMakeAction());
    }
}