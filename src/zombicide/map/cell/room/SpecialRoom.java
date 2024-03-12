package zombicide.map.cell.room;

import zombicide.map.cell.*;
import zombicide.map.cell.util.*;
import zombicide.map.util.*;

public abstract class SpecialRoom extends Room {

    public SpecialRoom(){
        super();
        this.cellType = CellType.SPECIALROOM;
    }  
    
}