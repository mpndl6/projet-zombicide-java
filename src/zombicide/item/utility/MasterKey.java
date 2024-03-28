package zombicide.item.utility;

import zombicide.callable.Callable;
import exception.IsWallException;
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
     * @param callable The location of the door to be opened.
     */
    public void use(Callable callable){
        try {
            this.map.openDoorOfRoom(this.survivor.getCell(), (Location) callable);
        }
        catch(IsWallException iw){
            System.out.println(iw.getMessage());
        }
    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "MasterKey";
    }
}