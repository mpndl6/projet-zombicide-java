package zombicide.map.cell;

import zombicide.map.cell.util.CellType;
import zombicide.map.util.Position;

/**
 * Represents a special type of street cell in the Zombicide map.
 * StreetWW cells are a subclass of the Street class and have unique features.
 * They are denoted by the letter 'W' when represented in text format.
 */
public class StreetWW extends Street {

    /**
     * Constructs a new StreetWW object.
     * Initializes the cell type of the street to SPECIALSTREET.
     */
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