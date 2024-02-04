package zombicide.map.cell.room;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.util.Position;

public class DrugStoreTest {

    private DrugStore drugstore;

    @Before
    public void before() {
        Position position = new Position(2, 2);
        int width = 4;
        int height = 4;
        drugstore = new DrugStore(position, width, height);
    }

    @Test
    public void testCanFight() {
        assertTrue(drugStore.canFight());
    }
}