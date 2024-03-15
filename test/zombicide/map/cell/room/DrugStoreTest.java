package zombicide.map.cell.room;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
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
        drugstore = new DrugStore();
    }

    @Test
    public void testCanFight() {
        assertTrue(drugstore.canFight());
    }
}