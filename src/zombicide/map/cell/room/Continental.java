package zombicide.map.cell.room;

import zombicide.map.cell.*;
import zombicide.map.util.*;

public class Continental extends SpecialRoom {
    public Continental(){
        super();
    }
    /**
     * @return true if it's possible to fight in this area
     */
    public boolean canFight(){
        return false;
    }

    /**
     *
     * @return a description od the cell
     */
    public String toString(){
        return "C";
    }


}
