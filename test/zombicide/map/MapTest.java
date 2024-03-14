package zombicide.map;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

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
        assertEquals(10, testMap.getHeight());
    }

    @Test
    public void testGeneratNumberForInitmap() {
        int rand = testMap.generateNumberForInitmap(9, 2);
        assertTrue(rand >= 2 && rand <= 9);
    }
}