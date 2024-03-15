package zombicide.map;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import zombicide.map.cell.Cell;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;

import java.util.ArrayList;
import java.util.List;

public class MapTest {

    private Map testMap;
    private List<Cell> listrooms = new ArrayList<Cell>();
    private List<Cell> liststreets = new ArrayList<Cell>();

    @Before
    public void before() {
        liststreets.add(new StreetWW());
        listrooms.add(new Continental());
        testMap = new Map(5,5,listrooms,liststreets);
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