package zombicide.map.cell.room;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class DrugStoreTest {
    private DrugStore drugstore;
    @Before
    public void before() {
        drugstore = new DrugStore();
    }

    @Test
    public void testCanFight() {
        assertTrue(drugstore.canFight());
    }
}