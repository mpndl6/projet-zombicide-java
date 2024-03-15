package zombicide.map.cell;

import zombicide.map.cell.util.CellType;
import zombicide.map.util.Position;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StreetWWTest {
    @Test
    public void testGetTypeOfCell(){
        Street StreetWW = new StreetWW();
        assertEquals(StreetWW.getTypeOfCell(), CellType.SPECIALSTREET);
    }
}