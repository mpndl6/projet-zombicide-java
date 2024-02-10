package zombicide.map.cell.room;

import zombicide.map.cell.*;
import zombicide.map.util.*;

public class Continental extends SpecialRoom {
    public Continental(Position p, int w,int h){
        super(p,w,h);
    }
    /**
     * @return true if it's possible to fight in this area
     */
    public boolean canFight(){
        return false;
    }

    @Override
    public String display() {
        return null;
    }


}
