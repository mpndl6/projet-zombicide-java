package zombicide.map.cell;

import zombicide.map.cell.util.CellType;
import zombicide.map.util.Position;

public class StreetWW extends Street {

    public StreetWW() {
        super();
        this.cellType = CellType.SPECIALSTREET;
    }

    /**
     * @return a description of the cell
     */
    public String toString() {
        return " W ";

    }

    public void spwanZombies(int howMany){
        //TODO
    }


}