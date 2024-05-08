package zombicide;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.map.Map;
import zombicide.map.util.Position;

public class GameTest {

    private Game game;
    private Map map;

    @Before
    public void setUp() {
        map = new Map(10, 10);
        game = new Game(map);
    }

    @Test
    public void testGetMap() {
        assertEquals(map, game.getMap());

        Map newMap = new Map(8, 8);

        game.setMap(newMap);

        assertEquals(newMap, game.getMap());
    }

    @Test
    public void testAddSurvivorGame() {
        Survivor survivor = new Survivor();

        game.addSurvivorGame(survivor);

        assertEquals(map.getCrossRoad(), survivor.getCell());
    }

    @Test
    public void testAddZombieGame() {
        Zombie zombie = new Zombie();

        game.addZombieGame(zombie);

        assertTrue(game.getListZombies().contains(zombie));

        assertEquals(game, zombie.getGame());
    }

    @Test
    public void testRemoveDeadActors() {
        Survivor survivor1 = new Survivor();
        Survivor survivor2 = new Survivor();
        Zombie zombie1 = new Zombie();
        Zombie zombie2 = new Zombie();

        game.addSurvivorGame(survivor1);
        game.addSurvivorGame(survivor2);
        game.addZombieGame(zombie1);
        game.addZombieGame(zombie2);

        zombie1.beingAttacked();
        survivor2.beingAttacked();

        game.removeDeadActors();

        assertNull(survivor2.getCell());
        assertNull(zombie1.getCell());
    }

    @Test
    public void testGetGlobalXP() {

        Survivor survivor1 = new Survivor();
        survivor1.getXP(50);
        Survivor survivor2 = new Survivor();
        survivor2.getXP(30);
        Survivor survivor3 = new Survivor();
        survivor3.getXP(20);


        game.addSurvivorGame(survivor1);
        game.addSurvivorGame(survivor2);
        game.addSurvivorGame(survivor3);

        assertEquals(100, game.getGlobalXP());
    }

    @Test
    public void testNoiseDown() {
        for (int w = 0; w < game.getMap().getWidth(); w++) {
            for (int h = 0; h < game.getMap().getHeight(); h++) {
                game.getMap().getCell(new Position(w,h)).makeNoise(2);
            }
        }

        game.NoiseDown();

        for (int w = 0; w < game.getMap().getWidth(); w++) {
            for (int h = 0; h < game.getMap().getHeight(); h++) {
                assertEquals(0, game.getMap().getCell(new Position(w,h)).getNoiseLevel());
            }
        }
    }


}


































































































































































