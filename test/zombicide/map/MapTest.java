package zombicide.map;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zombicide.map.cell.*;
import zombicide.map.util.Position;

public class MapTest {

    private Map testMap;

    @Before
    public void before() {
        testMap = new Map(10, 10);
    }

    @Test
    public void testGetWidth() {
        assertEquals(10, testMap.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(10, testMap.getheigth());
    }

    @Test
    public void testGeneratNumberForInitmap() {
        int rand = testMap.generatNumberForInitmap(9, 2);
        assertTrue(rand >= 2 && rand <= 9);
    }
}