package zombicide;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.Map;

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
}































































































































































