package zombicide.map.cell.room;

import zombicide.map.cell.*;
import zombicide.map.cell.util.*;
import zombicide.map.util.*;

/**
 * Represents a special type of room in the Zombicide map.
 * Special rooms are a subclass of the Room class and have additional unique features or properties.
 * This class is abstract and serves as a base class for specific types of special rooms.
 */
public abstract class SpecialRoom extends Room {

    /**
     * Constructs a new SpecialRoom object.
     * Initializes the cell type of the special room to SPECIALROOM.
     */
    public SpecialRoom(){
        super();
        this.cellType = CellType.SPECIALROOM;
    }  
    
}