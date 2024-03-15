package zombicide.item.utility;

import zombicide.map.IsWallException;
import zombicide.map.util.Location;
import zombicide.map.*;

public class MasterKey extends Utility{
    protected Map map;
    public MasterKey(Map map) {
        this.map = map;
    }

    /**
     * Uses the master key utility item to open a door at the specified location.
     * If the survivor is in a room cell, the method attempts to open the door.
     * @param l The location of the door to be opened.
     */
    public void use(Location l) throws IsWallException {
        this.map.openDoorOfRoom(this.survivor.getCell(), l);
    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "MasterKey";
    }
}