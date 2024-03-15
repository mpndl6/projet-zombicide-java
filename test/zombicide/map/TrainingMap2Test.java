package zombicide.map;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.actor.survivors.Survivor;
import zombicide.actor.survivors.type.Healer;
import zombicide.map.cell.Cell;
import zombicide.map.cell.room.Armory;
import zombicide.map.cell.room.Continental;
import zombicide.map.cell.room.DrugStore;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

public class TrainingMap2Test {
    private TrainingMap2 trainingMap;
    private List<Cell> listrooms;
    private List<Cell> liststreets;
    private Survivor healer;
    Position p;
    @Before
    public void setUp(){
        listrooms= new ArrayList<>();
        liststreets = new ArrayList<>();
        listrooms.add(new DrugStore());
        listrooms.add(new Continental());
        listrooms.add(new Armory());
        trainingMap= new TrainingMap2(listrooms,liststreets);
        p = new Position(1,3);
        healer = new Healer("JC");
    }

    @Test
    public void testMoveAnActor() throws IsWallException{
        trainingMap.putActorONCell(healer,p);
        trainingMap.moveActor(healer, Location.EAST); //actor move to the right
        assertEquals(healer.getCell(), trainingMap.getCell(new Position(1,4))); // survivor should be on cell pos(1?3)
    }

    @Test
    public void testIllegalSurvivorTriesToReachAWall() throws IsWallException{
        trainingMap.putActorONCell(healer,p);
        trainingMap.moveActor(healer, Location.EAST); //actor move to the right
        assertThrows(IsWallException.class,()-> {trainingMap.moveActor(healer, Location.EAST);} ); //acror tries to move to the right again but reaches height of map

    }
}
