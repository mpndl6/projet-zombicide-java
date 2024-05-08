package zombicide;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.action.actionSurvivor.MakeNoise;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Runner;
import zombicide.actor.zombie.type.Walker;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private Game game;
    private Map map;

    @Before
    public void setUp() {
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        map = new Map(10, 10,listrooms,liststreets);
        game = new Game(map);
    }

    @Test
    public void testGetMap() {
        assertEquals(map, game.getMap());
        List<Cell> listroomz = new ArrayList<Cell>();
        List<Cell> liststreetz = new ArrayList<Cell>();

        Map newMap = new Map(8, 8,listroomz,liststreetz);

        game.setMap(newMap);

        assertEquals(newMap, game.getMap());
    }

    @Test
    public void testAddSurvivorGame() {
        Survivor survivor = new Survivor("blop");

        game.addSurvivorGame(survivor);
        assertEquals(map.getCrossRoad(), survivor.getCell().getPosition());
    }

    @Test
    public void testAddZombieGame() {
        Zombie zombie = new Walker();

        game.addZombieGame(zombie);

        assertTrue(game.getListZombies().contains(zombie));

        assertEquals(game, zombie.getGame());
    }
/**
    @Test
    public void testRemoveDeadActors() {
        Survivor survivor1 = new Survivor("1");
        Survivor survivor2 = new Survivor("2");
        Zombie zombie1 = new Walker();
        Zombie zombie2 = new Walker();

        game.addSurvivorGame(survivor1);
        game.addSurvivorGame(survivor2);
        game.addZombieGame(zombie1);
        game.addZombieGame(zombie2);

        zombie1.beingAttacked();
        survivor2.beingAttacked();
        survivor2.beingAttacked();
        survivor2.beingAttacked();
        survivor2.beingAttacked();
        survivor2.beingAttacked();


        game.removeDeadActors();

        assertEquals(1,game.getListZombies().size());
    }*/

    @Test
    public void testGetGlobalXP() {

        Survivor survivor1 = new Survivor("1");
        Survivor survivor2 = new Survivor("2");
        Survivor survivor3 = new Survivor("3");



        game.addSurvivorGame(survivor1);
        game.addSurvivorGame(survivor2);
        game.addSurvivorGame(survivor3);

        assertEquals(0, game.getGlobalXP());
    }


    @Test
    public void testNoiseDown() {
        Survivor survivor1 = new Survivor("1");
        Survivor survivor2 = new Survivor("2");



        game.addSurvivorGame(survivor1);
        game.addSurvivorGame(survivor2);

        MakeNoise makeNoise = new MakeNoise(survivor1);
        survivor1.makeAction(makeNoise,survivor1.getCell());
        assertEquals(1,survivor1.getCell().getNoiseLevel());
        game.NoiseDown();
        assertEquals(0,survivor1.getCell().getNoiseLevel());
}}


































































































































































