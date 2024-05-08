package zombicide.action;

import zombicide.Game;
import zombicide.actor.survivor.Survivor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.map.Map;
import zombicide.map.TrainingMap2;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveAsideTest {
    @Test
    public void make_MoveSurvivorNorth_Successful()  {

        Survivor survivor = new Survivor("Survivor1");
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        Map map = new TrainingMap2(listRooms,listSreet);
        Game game = new Game(map);
        survivor.setGame(game);
        map.putActorONCell(survivor,new Position(1,1));


        MoveAside moveAside = new MoveAside(survivor);


        boolean result = moveAside.make(Location.NORTH);


        assertTrue(result);
        assertEquals(new Position(0, 1), survivor.getCell().getPosition());
    }

    @Test
    public void make_MoveSurvivorSouth_Successful()  {
        Survivor survivor = new Survivor("Survivor1");
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        Map map = new TrainingMap2(listRooms,listSreet);
        Game game = new Game(map);
        survivor.setGame(game);
        map.putActorONCell(survivor,new Position(1,1));
        MoveAside moveAside = new MoveAside(survivor);

        boolean result = moveAside.make(Location.SOUTH);

        assertTrue(result);
        assertEquals(new Position(2, 1), survivor.getCell().getPosition());
    }
    @Test
    public void make_MoveSurvivorEast_Successful()  {
        Survivor survivor = new Survivor("Survivor1");
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        Map map = new TrainingMap2(listRooms,listSreet);
        Game game = new Game(map);
        survivor.setGame(game);
        map.putActorONCell(survivor,new Position(1,1));
        MoveAside moveAside = new MoveAside(survivor);

        boolean result = moveAside.make(Location.EAST);

        assertTrue(result);
        assertEquals(new Position(1, 2), survivor.getCell().getPosition());
    }

    @Test
    public void make_MoveSurvivorWest_Successful()  {

        Survivor survivor = new Survivor("Survivor1");
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        Map map = new TrainingMap2(listRooms,listSreet);
        Game game = new Game(map);
        survivor.setGame(game);
        map.putActorONCell(survivor,new Position(1,1));
        MoveAside moveAside = new MoveAside(survivor);


        boolean result = moveAside.make(Location.WEST);


        assertTrue(result);
        assertEquals(new Position(1, 0), survivor.getCell().getPosition());
    }
}
