package zombicide.map.cell.room;

import zombicide.map.cell.util.*;

public abstract class SpecialRoom extends Room {

    public SpecialRoom(Position p , int w , int h){
        super(p , w , h);
        this.cellType = CellType.SPECIALROOM;
    }  
    
}