package zombicide.map;

import org.junit.Test;
import zombicide.actor.Actor;
import zombicide.map.TrainingMap2;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;
import zombicide.map.util.Position;
import zombicide.actor.survivors.Survivor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TrainingMap2Test {

    @Test
    public void testMoveActorNorth() {
        // Arrange
        List<Cell> listRooms = new ArrayList<>();
        List<Cell> listStreets = new ArrayList<>();
        TrainingMap2 map = new TrainingMap2(listRooms, listStreets);
        Actor survivor = new Survivor();
        map.putActorONCell(survivor, new Position(2, 2));


        map.moveActor(survivor, Location.NORTH);


        assertEquals(survivor.getCell().getPosition().getX(), 1);
        assertEquals(survivor.getCell().getPosition().getY(), 2);
    }

    @Test
    public void testMoveActorSouth() {
        // Arrange
        List<Cell> listRooms = new ArrayList<>();
        List<Cell> listStreets = new ArrayList<>();
        TrainingMap2 map = new TrainingMap2(listRooms, listStreets);
        Actor survivor = new Survivor();
        map.putActorONCell(survivor, new Position(2, 2));


        map.moveActor(survivor, Location.SOUTH);

        assertEquals(survivor.getCell().getPosition().getX(), 3);
        assertEquals(survivor.getCell().getPosition().getY(), 2);
    }

    @Test
    public void testMoveActorWest() {
        // Arrange
        List<Cell> listRooms = new ArrayList<>();
        List<Cell> listStreets = new ArrayList<>();
        TrainingMap2 map = new TrainingMap2(listRooms, listStreets);
        Actor survivor = new Survivor();
        map.putActorONCell(survivor, new Position(2, 2));


        map.moveActor(survivor, Location.WEST);


        assertEquals(survivor.getCell().getPosition().getX(), 2);
        assertEquals(survivor.getCell().getPosition().getY(), 1);
    }

    @Test
    public void testMoveActorEast() {
        // Arrange
        List<Cell> listRooms = new ArrayList<>();
        List<Cell> listStreets = new ArrayList<>();
        TrainingMap2 map = new TrainingMap2(listRooms, listStreets);
        Actor survivor = new Survivor();
        map.putActorONCell(survivor, new Position(2, 2));


        map.moveActor(survivor, Location.EAST);


        assertEquals(survivor.getCell().getPosition().getX(), 2);
        assertEquals(survivor.getCell().getPosition().getY(), 3);
    }
}
