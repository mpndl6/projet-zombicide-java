package zombicide.map.cell;

import zombicide.map.cell.util.CellType;
import zombicide.map.util.Position;

public class StreetWW extends Street {

    public StreetWW() {
        super();
        this.cellType = CellType.SPECIALSTREET;
    }

    public String toString() {
        return " W ";

    }
}